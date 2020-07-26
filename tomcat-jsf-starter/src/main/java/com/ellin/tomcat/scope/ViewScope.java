package com.ellin.tomcat.scope;

import javax.faces.context.FacesContext;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.*;

public class ViewScope implements Scope {
    public Object get(String name, ObjectFactory<? extends Object> objectFactory) {
        Map<String, Object> viewMap = FacesContext.getCurrentInstance().getViewRoot().getViewMap();
        Object obj;
        if (viewMap.containsKey(name)) {
            obj = viewMap.get(name);
        } else {
            Object object = objectFactory.getObject();
            viewMap.put(name, object);
            obj = object;
        }
        return obj;
    }

    public Object remove(String name) {
        return FacesContext.getCurrentInstance().getViewRoot();
    }

    public String getConversationId() {
        return null;
    }

    public void registerDestructionCallback(String name, Runnable callback) {
        // Not supported
    }

    public Object resolveContextualObject(String key) {
        return null;
    }
}