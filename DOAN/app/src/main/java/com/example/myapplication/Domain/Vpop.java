package com.example.myapplication.Domain;

import java.io.Serializable;

public class Vpop implements Serializable {
    private int imgVpop;
    private String tvTenVpop;

    public Vpop(int imgVpop, String tvTenVpop) {
        this.imgVpop = imgVpop;
        this.tvTenVpop = tvTenVpop;
    }

    public int getImgVpop() {
        return imgVpop;
    }

    public void setImgVpop(int imgVpop) {
        this.imgVpop = imgVpop;
    }

    public String getTvTenVpop() {
        return tvTenVpop;
    }

    public void setTvTenVpop(String tvTenVpop) {
        this.tvTenVpop = tvTenVpop;
    }
}
