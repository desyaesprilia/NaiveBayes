package com.example.coba.gejala.Article;

/**
 * Created by Owner on 09/04/2018.
 */

public class NyeriKepala {

    private String Title;
    private String Description;
    private int Thumbnail;

    public NyeriKepala() {
    }

    public NyeriKepala(String title, String description, int thumbnail) {
        Title = title;
        Description = description;
        Thumbnail = thumbnail;
    }

    public String getTitle() {
        return Title;
    }

    public String getDescription() {
        return Description;
    }

    public int getThumbnail() {
        return Thumbnail;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }
}
