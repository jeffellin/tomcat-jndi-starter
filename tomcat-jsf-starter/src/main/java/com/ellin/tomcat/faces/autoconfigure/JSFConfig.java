package com.ellin.tomcat.faces.autoconfigure;

import com.ellin.tomcat.scope.*;
import org.apache.myfaces.webapp.*;
import org.springframework.beans.factory.config.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.autoconfigure.web.servlet.*;
import org.springframework.boot.context.properties.*;
import org.springframework.boot.web.servlet.*;
import org.springframework.context.annotation.*;
import org.springframework.web.context.request.*;

import javax.faces.webapp.*;
import javax.servlet.*;
import java.util.*;

@Configuration
@EnableConfigurationProperties(FacesServletProperties.class)
@AutoConfigureBefore(WebMvcAutoConfiguration.class)
public class JSFConfig {

    private FacesServletProperties jndiDatabases = null;

    public JSFConfig(FacesServletProperties properties) {
        this.jndiDatabases = properties;
    }

    public JSFConfig() {
    }

    @Bean
    public CustomScopeConfigurer scopeConfigurer(ViewScope viewScope) {
        CustomScopeConfigurer configurer = new CustomScopeConfigurer();
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("view", viewScope);
        configurer.setScopes(hashMap);
        return configurer;
    }

    @Bean
    public ViewScope viewScope() {
        return new ViewScope();
    }

    @Bean
    public ServletListenerRegistrationBean<RequestContextListener> jsfConfigureListener() {
        return new ServletListenerRegistrationBean<RequestContextListener>(
                new RequestContextListener());
    }

    @Bean
    public ServletListenerRegistrationBean<StartupServletContextListener> startupServletContextListener() {
        return new ServletListenerRegistrationBean<StartupServletContextListener>(
                new StartupServletContextListener());
    }

    @Bean
    public ServletRegistrationBean<FacesServlet> facesServletRegistrationBean() {
        ServletRegistrationBean<FacesServlet> facesServletServletRegistrationBean = new ServletRegistrationBean<FacesServlet>(new FacesServlet(), "*.html") {
            @Override
            protected ServletRegistration.Dynamic addRegistration(String description, ServletContext servletContext) {
                ServletRegistration.Dynamic servletRegistration = super.addRegistration(description, servletContext);
                if (servletRegistration != null) {
                    servletContext.setAttribute("org.apache.myfaces.DYNAMICALLY_ADDED_FACES_SERVLET", true);
                    servletContext.setAttribute("com.sun.faces.facesInitializerMappingsAdded", true);
                }
                return servletRegistration;
            }
        };

        FacesServletProperties facesServletProperties = new FacesServletProperties();

        facesServletServletRegistrationBean.setName(facesServletProperties.getName());
        facesServletServletRegistrationBean.setUrlMappings(facesServletProperties.getUrlMappings());
        facesServletServletRegistrationBean.setLoadOnStartup(facesServletProperties.getLoadOnStartup());
        facesServletServletRegistrationBean.setEnabled(facesServletProperties.isEnabled());
        facesServletServletRegistrationBean.setAsyncSupported(facesServletProperties.isAsyncSupported());
        facesServletServletRegistrationBean.setOrder(facesServletProperties.getOrder());

        return facesServletServletRegistrationBean;
    }



}
