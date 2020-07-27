package com.ellin.tomcat.db;

import org.apache.tomcat.util.descriptor.web.*;
import org.springframework.boot.web.embedded.tomcat.*;

public class JndiTomcatWebServerFactory extends TomcatServletWebServerFactory {

    public JndiTomcatWebServerFactory() {
    }

    JndiDatabases jndiDatabases;

    public JndiTomcatWebServerFactory(JndiDatabases jndiDatabases) {
        this.jndiDatabases = jndiDatabases;
    }

    @Override
    protected TomcatWebServer getTomcatWebServer(org.apache.catalina.startup.Tomcat tomcat) {
        tomcat.enableNaming();
        return new TomcatWebServer(tomcat, this.getPort() >= 0);

    }

    public TomcatWebServer test(org.apache.catalina.startup.Tomcat tomcat) {
        return getTomcatWebServer(tomcat);

    }

    @Override
    protected void postProcessContext(org.apache.catalina.Context context) {


        jndiDatabases.dbConfigurationList.forEach((x,dbConfiguration) -> {

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
}
