package com.example.myapplication.Domain;

import java.io.Serializable;

public class NhacPhim implements Serializable {
    private int imgNP;
    private String tvTenNP;

    public NhacPhim(int imgNP, String tvTenNP) {
        this.imgNP = imgNP;
        this.tvTenNP = tvTenNP;
    }

    public int getImgNP() {
        return imgNP;
    }

    public void setImgNP(int imgNP) {
        this.imgNP = imgNP;
    }

    public String getTvTenNP() {
        return tvTenNP;
    }

    public void setTvTenNP(String tvTenNP) {
        this.tvTenNP = tvTenNP;
    }
}
