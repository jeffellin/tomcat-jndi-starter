package com.ellin.tomcat.db;
import com.ellin.tomcat.db.*;
import org.apache.tomcat.util.descriptor.web.ContextResource;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.web.embedded.*;
import org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatWebServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(JndiDatabases.class)
@AutoConfigureBefore(ServletWebServerFactoryAutoConfiguration.class)
public class TomcatDb {

    private JndiDatabases jndiDatabases = null;

    @Bean
    @ConditionalOnMissingBean(type = "org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory")
    public TomcatServletWebServerFactory tomcatFactory(JndiDatabases jndiDatabases) {
            return new JndiTomcatWebServerFactory(jndiDatabases);
        };
    }


