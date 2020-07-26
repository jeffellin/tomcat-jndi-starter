package com.example.jsfdemo.bean;

import org.springframework.context.annotation.*;
import org.springframework.stereotype.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
@Component("viewManager")
@Scope("view")
public class ViewManager   implements Serializable{

    ArrayList<Property>   cacheList = new ArrayList ();
    private Property item = new Property();
    public ViewManager() {
    }
    private String key;
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    private boolean edit;

    public void add() {
        cacheList.add(item);
        item = new Property();

    }

    public void edit(Property item) {
        System.out.println("Called edit with "+item);
        this.item = item;
        edit = true;
    }

    public void save() {
        // dao.update(item);
        item = new Property(); // Reset placeholder.
        edit = false;
    }

    public void delete(Property item) {
        System.out.println("Called delete with "+item);
        cacheList.remove(item);
    }

    public List getCacheList() {
        return cacheList;
    }
    public Property getItem() {
        return item;
    }

    public boolean isEdit() {
        return edit;
    }
}