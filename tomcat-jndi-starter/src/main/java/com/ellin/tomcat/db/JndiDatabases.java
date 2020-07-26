package com.ellin.tomcat.db;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@ConfigurationProperties(prefix = "com.ellin.tomcat.db")
public class JndiDatabases {

    Map<String,DBConfiguration> dbConfigurationList;


    public Map<String,DBConfiguration> getDbConfigurationList() {
        return dbConfigurationList;
    }

    public void setDbConfigurationList(Map<String,DBConfiguration> dbConfigurationList) {
        this.dbConfigurationList = dbConfigurationList;
    }

    @Override
    public String toString() {
        return "JndiDatabases{" +
                "dbConfigurationList=" + dbConfigurationList +
                '}';
    }
}
