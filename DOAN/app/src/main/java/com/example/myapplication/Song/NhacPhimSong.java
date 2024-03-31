package com.example.myapplication.Song;

public class NhacPhimSong {
    private String nhacphimTitle;
    private int nhacphimFile;

    public NhacPhimSong(String nhacphimTitle, int nhacphimFile) {
        this.nhacphimTitle = nhacphimTitle;
        this.nhacphimFile = nhacphimFile;
    }

    public String getnhacphimTitle() {
        return nhacphimTitle;
    }

    public void setnhacphimTitle(String nhacphimTitle) {
        this.nhacphimTitle = nhacphimTitle;
    }

    public int getnhacphimFile() {
        return nhacphimFile;
    }

    public void setnhacphimFile(int nhacphimFile) {
        this.nhacphimFile = nhacphimFile;
    }
}