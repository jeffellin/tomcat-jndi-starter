package com.ellin.tomcat.db;


import org.apache.catalina.*;
import org.apache.catalina.deploy.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.*;
import org.mockito.junit.jupiter.*;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.assertj.*;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.*;
import org.springframework.test.util.*;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TomcatDbTest {



    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
            .withConfiguration(AutoConfigurations.of(TomcatDb.class));

    @Test
    void clientExists() {
        this.contextRunner.run((context) -> assertThat(context).hasSingleBean(TomcatServletWebServerFactory.class));
    }

    @Test
    void configuresSingleClient() {
        this.contextRunner.withUserConfiguration(SingleDataSource.class)
                .run((context) -> assertThat(context).hasSingleBean(TomcatServletWebServerFactory.class));
    }

    @Test
    void settingsAdded() {
        this.contextRunner.withUserConfiguration(SingleDataSource.class)
                .run((context) -> assertThat(
                        getSettings(context).getTest())
                        .isEqualTo("hooya"));
    }

    @Test
    void tomcatConfiguredJndiDatasources() {
        this.contextRunner.withUserConfiguration(SingleDataSource.class)
                .run((context) -> {
                    JndiTomcatWebServerFactory bean = context.getBean(JndiTomcatWebServerFactory.class);
                    Context catalinaContext = mock(Context.class);
                    NamingResourcesImpl namingResources = mock(NamingResourcesImpl.class);
                    when(catalinaContext.getNamingResources()).thenReturn(namingResources);
                    ReflectionTestUtils.invokeMethod(bean,JndiTomcatWebServerFactory.class,"postProcessContext",catalinaContext);
                    Set<String> entries = (Set<String>) ReflectionTestUtils.getField(catalinaContext.getNamingResources(),"entries");
                    verify(namingResources,times(1))
                            .addResource(argThat(x -> x.getType().equals("javax.sql.DataSource")
                                                    && x.getName().equals("unitTestDB")

                            ));

                });
    }

    private JndiDatabases getSettings(AssertableApplicationContext context) {
        assertThat(context).hasSingleBean(JndiTomcatWebServerFactory.class);
        JndiTomcatWebServerFactory client = context.getBean(JndiTomcatWebServerFactory.class);

        return (JndiDatabases) ReflectionTestUtils.getField(client, "jndiDatabases");
    }

    @Configuration(proxyBeanMethods = false)
    static class SingleDataSource {

        @Bean
        JndiDatabases jndiDatabases() {
            DBConfiguration dbConfiguration = new DBConfiguration();
            dbConfiguration.setName("unitTestDB");
            JndiDatabases jndiDatabases = new JndiDatabases();
            Map<String,DBConfiguration> dbs = new HashMap();
            dbs.put("test",dbConfiguration);
            jndiDatabases.setTest("hooya");
            jndiDatabases.setDbConfigurationList(dbs);
            return jndiDatabases;
        }

    }


}