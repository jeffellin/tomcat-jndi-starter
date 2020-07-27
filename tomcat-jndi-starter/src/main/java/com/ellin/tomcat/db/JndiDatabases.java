package com.ellin.tomcat.db;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@ConfigurationProperties(prefix = "com.ellin.tomcat.db")
public class JndiDatabases {

    Map<String,DBConfiguration> dbConfigurationList;

    private String test;



    public Map<String,DBConfiguration> getDbConfigurationList() {
        return dbConfigurationList;
    }

    public void setDbConfigurationList(Map<String,DBConfiguration> dbConfigurationList) {
        this.dbConfigurationList = dbConfigurationList;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    @Override
    public String toString() {
        return "JndiDatabases{" +
                "dbConfigurationList=" + dbConfigurationList +
                '}';
    }
}
