package com.HishaTech.android.dayquote.db.model;

/**
 * Created by smithkev on 1/27/2015.
 */
public class Author {

    private Integer id;
    private String firstname;
    private String lastname;
    private String wikilink;

    public Integer getID() {
        return id;
    }

    public void setID(Integer ID) {
        this.id = ID;
    }

    public String getFirstName() {
        return firstname;
    }

    public void setFirstName(String FirstName) {
        this.firstname = FirstName;
    }

    public String getLastName() {
        return lastname;
    }

    public void setLastName(String LastName) {
        this.lastname = LastName;
    }

    public String getWikiLink() {
        return wikilink;
    }

    public void setWikiLink(String WikiLink) {
        this.wikilink = WikiLink;
    }

}
