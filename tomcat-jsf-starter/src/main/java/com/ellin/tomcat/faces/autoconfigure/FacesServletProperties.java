package com.ellin.tomcat.faces.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.*;

@ConfigurationProperties(prefix = "com.ellin.tomcat.faces")
public class FacesServletProperties {

    private String name = "FacesServlet";

    private int loadOnStartup = -1;

    private Set<String> urlMappings = new LinkedHashSet<>(Arrays.asList("/faces/*", "*.jsf", "*.faces", "*.xhtml"));

    /**
     * If the FacesServlet should be actively handled by Joinfaces.
     */
    private boolean enabled = true;

    private boolean asyncSupported = true;

    /**
     * The order-property for the ServletRegistrationBean.
     */
    private int order = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLoadOnStartup() {
        return loadOnStartup;
    }

    public void setLoadOnStartup(int loadOnStartup) {
        this.loadOnStartup = loadOnStartup;
    }

    public Set<String> getUrlMappings() {
        return urlMappings;
    }

    public void setUrlMappings(Set<String> urlMappings) {
        this.urlMappings = urlMappings;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isAsyncSupported() {
        return asyncSupported;
    }

    public void setAsyncSupported(boolean asyncSupported) {
        this.asyncSupported = asyncSupported;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }


    @Override
    public String toString() {
        return "FacesServletProperties{" +
                "name='" + name + '\'' +
                ", loadOnStartup=" + loadOnStartup +
                ", urlMappings=" + urlMappings +
                ", enabled=" + enabled +
                ", asyncSupported=" + asyncSupported +
                ", order=" + order +
                '}';
    }
}
