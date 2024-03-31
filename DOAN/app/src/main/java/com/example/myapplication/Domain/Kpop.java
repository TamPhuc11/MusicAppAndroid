package com.example.myapplication.Domain;

import java.io.Serializable;

public class Kpop implements Serializable {
    private int imgKpop;
    private String tvTenbhKpop;

    public Kpop(int imgKpop, String tvTenbhKpop) {
        this.imgKpop = imgKpop;
        this.tvTenbhKpop = tvTenbhKpop;
    }

    public int getImgKpop() {
        return imgKpop;
    }

    public void setImgKpop(int imgKpop) {
        this.imgKpop = imgKpop;
    }

    public String getTvTenbhKpop() {
        return tvTenbhKpop;
    }

    public void setTvTenbhKpop(String tvTenbhKpop) {
        this.tvTenbhKpop = tvTenbhKpop;
    }
}
