package com.example.app_ban_hang.model;

import java.util.List;

public class type_product_model {
    boolean success;
    String message;
    List<type_product> result;

    public boolean isSuccess ( ) {

        return success;
    }

    public void setSuccess (boolean success) {

        this.success = success;
    }

    public String getMessage ( ) {
        return message;
    }

    public void setMessage (String message) {
        this.message = message;
    }

    public List<type_product> getResult ( ) {
        return result;
    }

    public void setResult (List<type_product> result) {
        this.result = result;
    }
}
