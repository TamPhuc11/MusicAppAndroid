package com.example.myapplication.Song;

public class KpopSong {
    private String kpopTitle;
    private int kpopFile;

    public KpopSong(String kpopTitle, int kpopFile) {
        this.kpopTitle = kpopTitle;
        this.kpopFile = kpopFile;
    }

    public String getKpopTitle() {
        return kpopTitle;
    }

    public void setKpopTitle(String kpopTitle) {
        this.kpopTitle = kpopTitle;
    }

    public int getKpopFile() {
        return kpopFile;
    }

    public void setKpopFile(int kpopFile) {
        this.kpopFile = kpopFile;
    }
}
