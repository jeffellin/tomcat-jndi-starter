package com.ellin.tomcat.db.autoconfigure;
import org.apache.tomcat.util.descriptor.web.ContextEnvironment;
import org.apache.tomcat.util.descriptor.web.ContextResource;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatWebServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.jndi.JndiTemplate;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties(JndiDatabases.class)
@AutoConfigureBefore(ServletWebServerFactoryAutoConfiguration.class)
public class TomcatDb {

    private JndiDatabases jndiDatabases = null;

    public TomcatDb(JndiDatabases properties) {
        this.jndiDatabases = properties;
    }

    @Bean
    @ConditionalOnMissingBean(type = "org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory")
    public TomcatServletWebServerFactory tomcatFactory() {
        return new TomcatServletWebServerFactory() {
            @Override
            protected TomcatWebServer getTomcatWebServer(org.apache.catalina.startup.Tomcat tomcat) {
                tomcat.enableNaming();
                return super.getTomcatWebServer(tomcat);
            }

            @Override
            protected void postProcessContext(org.apache.catalina.Context context) {


                jndiDatabases.dbConfigurationList.forEach((x,dbConfiguration) -> {

                    System.err.println(x);

                    ContextResource resource = new ContextResource();

                    resource.setName(dbConfiguration.getName());

                    resource.setType(dbConfiguration.getType());
                    resource.setProperty("driverClassName",
                            dbConfiguration.getDriverClassName());
                    resource.setProperty("url", dbConfiguration.getUrl());
                    resource.setProperty("username", dbConfiguration.getUsername());
                    resource.setProperty("password", dbConfiguration.getPassword());
                    resource.setProperty("maxIdle", dbConfiguration.getMaxIdle());
                    resource.setProperty("maxTotal", dbConfiguration.getMaxTotal());
                    resource.setProperty("factory", dbConfiguration.getFactory());
                    context.getNamingResources().addResource(resource);

                });






            }
        };
    }
}
