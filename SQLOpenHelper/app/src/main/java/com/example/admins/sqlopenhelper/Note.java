package com.example.admins.sqlopenhelper;

import java.io.Serializable;

/**
 * Created by Admins on 10/9/2017.
 */

public class Note implements Serializable {
    private String title;
    private String description;
    private int id;

    public Note(String title, String des) {
        this.title=title;
        this.description=des;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Note() {
        this.title = title;
        this.description = description;
        this.id = id;
    }

    @Override
    public String toString() {
        return id +" _ " +title+ " _ "+ description+ " _ ";
    }
}
