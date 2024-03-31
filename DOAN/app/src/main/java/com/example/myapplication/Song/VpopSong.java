package com.example.myapplication.Song;

public class VpopSong {
    private String vpopTitle;
    private int vpopFile;

    public VpopSong(String vpopTitle, int vpopFile) {
        this.vpopTitle = vpopTitle;
        this.vpopFile = vpopFile;
    }

    public String getVpopTitle() {
        return vpopTitle;
    }

    public void setVpopTitle(String vpopTitle) {
        this.vpopTitle = vpopTitle;
    }

    public int getVpopFile() {
        return vpopFile;
    }

    public void setVpopFile(int vpopFile) {
        this.vpopFile = vpopFile;
    }
}