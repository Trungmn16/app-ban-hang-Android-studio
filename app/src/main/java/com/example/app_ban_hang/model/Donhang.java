package com.example.app_ban_hang.model;

import java.util.List;

public class Donhang {
    int id;
    int iduser;
    String diachi;
    String sdt;
    String tongtien;
    List<item> ITEM;

    public int getId ( ) {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public int getIduser ( ) {
        return iduser;
    }

    public void setIduser (int iduser) {
        this.iduser = iduser;
    }

    public String getDiachi ( ) {
        return diachi;
    }
    public void setDiachi (String diachi) {
        this.diachi = diachi;
    }

    public String getSdt ( ) {
        return sdt;
    }

    public void setSdt (String sdt) {
        this.sdt = sdt;
    }

    public String getTongtien ( ) {
        return tongtien;
    }

    public void setTongtien (String tongtien) {
        this.tongtien = tongtien;
    }

    public List<item> getITEM ( ) {
        return ITEM;
    }

    public void setITEM (List<item> ITEM) {
        this.ITEM = ITEM;
    }
}
