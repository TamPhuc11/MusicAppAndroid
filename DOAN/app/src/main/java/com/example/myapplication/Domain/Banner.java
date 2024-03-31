package com.example.myapplication.Domain;

import android.os.Parcel;

import java.io.Serializable;

public class Banner implements Serializable {
    private int imgBanner;


    public Banner(int imgBanner) {
        this.imgBanner = imgBanner;


    }

    protected Banner(Parcel in) {
        imgBanner = in.readInt();


    }

    public int getImgBanner() {
        return imgBanner;
    }

    public void setImgBanner(int imgBanner) {
        this.imgBanner = imgBanner;
    }

    public int describeContents() {
        return 0;
    }

}
