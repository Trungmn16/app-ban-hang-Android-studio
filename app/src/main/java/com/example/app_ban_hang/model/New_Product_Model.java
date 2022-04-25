package com.example.app_ban_hang.model;

import java.util.List;

public class New_Product_Model {
    boolean success;
    String message;
    List<New_Product> result;

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

    public List<New_Product> getResult ( ) {
        return result;
    }

    public void setResult (List<New_Product> result) {
        this.result = result;
    }
}
