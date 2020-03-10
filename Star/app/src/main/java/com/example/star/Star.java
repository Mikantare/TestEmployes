package com.example.star;

public class Star {
    private String name;
    private String imageUrl;

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Star(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }
}
