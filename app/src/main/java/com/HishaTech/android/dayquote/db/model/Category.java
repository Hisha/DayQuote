package com.HishaTech.android.dayquote.db.model;

/**
 * Created by smithkev on 1/27/2015.
 */
public class Category {

    private Integer id;
    private String name;
    private String description;

    public Integer getID() {
        return id;
    }

    public void setID(Integer ID) {
        this.id = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String Description) {
        this.description = Description;
    }

}
