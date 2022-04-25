package com.example.app_ban_hang.model;

import java.io.Serializable;

public class New_Product implements Serializable {
    int id;
    String name;
    String image;
    String description;
    String price;
    int type;

    public int getType ( ) {
        return type;
    }

    public void setType (int type) {
        this.type = type;
    }

    public int getId ( ) {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public String getName ( ) {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getImage ( ) {
        return image;
    }

    public void setImage (String image) {
        this.image = image;
    }

    public String getDescription ( ) {
        return description;
    }

    public void setDescription (String description) {
        this.description = description;
    }

    public String getPrice ( ) {
        return price;
    }

    public void setPrice (String price) {
        this.price = price;
    }


}
