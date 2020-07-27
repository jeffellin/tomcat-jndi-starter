package com.ellin.tomcat.db;

public class DBConfiguration {

    private static final String DEFAULT_TYPE = "javax.sql.DataSource";
    private String name;
    private String type;
    private String driverClassName;
    private String url;
    private String username;
    private String password;
    private String maxIdle;
    private String maxTotal;
    private String factory;
    private String maxActive = "100";
    private String initialSize = "10";
    private String maxWait = "30000";
    private String testOnBorrow = "false";
    private String testOnConnect = "false";
    private String testOnReturn = "false";
    private String testWhileIdle = "false";
    private String validationQuery = null;
    private String validationQueryTimeout = "-1";
    private String connectionProperties = "";

    public String getMaxActive() {
        return maxActive;
    }

    public void setMaxActive(String maxActive) {
        this.maxActive = maxActive;
    }

    public String getInitialSize() {
        return initialSize;
    }

    public void setInitialSize(String initialSize) {
        this.initialSize = initialSize;
    }

    public String getMaxWait() {
        return maxWait;
    }

    public void setMaxWait(String maxWait) {
        this.maxWait = maxWait;
    }

    public String getTestOnBorrow() {
        return testOnBorrow;
    }

    public void setTestOnBorrow(String testOnBorrow) {
        this.testOnBorrow = testOnBorrow;
    }

    public String getTestOnConnect() {
        return testOnConnect;
    }

    public void setTestOnConnect(String testOnConnect) {
        this.testOnConnect = testOnConnect;
    }

    public String getTestOnReturn() {
        return testOnReturn;
    }

    public void setTestOnReturn(String testOnReturn) {
        this.testOnReturn = testOnReturn;
    }

    public String getTestWhileIdle() {
        return testWhileIdle;
    }

    public void setTestWhileIdle(String testWhileIdle) {
        this.testWhileIdle = testWhileIdle;
    }

    public String getValidationQuery() {
        return validationQuery;
    }

    public void setValidationQuery(String validationQuery) {
        this.validationQuery = validationQuery;
    }

    public String getValidationQueryTimeout() {
        return validationQueryTimeout;
    }

    public void setValidationQueryTimeout(String validationQueryTimeout) {
        this.validationQueryTimeout = validationQueryTimeout;
    }

    public String getConnectionProperties() {
        return connectionProperties;
    }

    public void setConnectionProperties(String connectionProperties) {
        this.connectionProperties = connectionProperties;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return (this.type != null) ? this.type : DEFAULT_TYPE;
    }

    public void setType(String type) {
       this.type = type;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(String maxIdle) {
        this.maxIdle = maxIdle;
    }

    public String getMaxTotal() {
        return maxTotal;
    }

    public void setMaxTotal(String maxTotal) {
        this.maxTotal = maxTotal;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }



    @Override
    public String toString() {
        return "DBConfiguration{" +
                "name='" + name + '\'' +
                ", type='" + getType() + '\'' +
                ", driverClassName='" + driverClassName + '\'' +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", maxIdle='" + maxIdle + '\'' +
                ", maxTotal='" + maxTotal + '\'' +
                ", factory='" + factory + '\'' +
                '}';
    }

    /* resource.setName("jdbc/config");

                resource.setType(DataSource .class.getName());
                resource.setProperty("driverClassName",
                        "org.postgresql.Driver");
                resource.setProperty("url", "jdbc:postgresql://localhost/test");
                resource.setProperty("username", "postgres");
                resource.setProperty("password", "password");
                resource.setProperty("maxIdle", "10");
                resource.setProperty("maxTotal", "150");
                resource.setProperty("factory", "org.apache.tomcat.jdbc.pool.DataSourceFactory");*/

}
