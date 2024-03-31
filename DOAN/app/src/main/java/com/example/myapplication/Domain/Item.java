package com.example.myapplication.Domain;

import android.os.Parcel;

import java.io.Serializable;

public class Item implements Serializable {
    private int img;
    private String tvLics;

    private String tvLibh;

    public Item(int img, String tvLibh,String tvLics) {
        this.img = img;
        this.tvLibh = tvLibh;
        this.tvLics = tvLics;

    }

    protected Item(Parcel in) {
        img = in.readInt();
        tvLibh = in.readString();
        tvLics = in.readString();

    }





    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTvLics() {
        return tvLics;
    }

    public void setTvLics(String tvLics) {
        this.tvLics = tvLics;
    }

    public String getTvLibh() {
        return tvLibh;
    }

    public void setTvLibh(String tvLibh) {
        this.tvLibh = tvLibh;
    }
    public int describeContents() {
        return 0;
    }

}
