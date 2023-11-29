package com.example.dressire;

public class Descriptions {

    private String abouts, description;
    private boolean exapandable;

    public Descriptions(String description) {
        this.abouts = abouts;
        this.description = description;
        this.exapandable = false;
    }

    public String getAbouts() {
        return abouts;
    }

    public void setAbouts(String abouts) {
        this.abouts = abouts;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isExapandable() {
        return exapandable;
    }

    public void setExapandable(boolean exapandable) {
        this.exapandable = exapandable;
    }

    @Override
    public String toString() {
        return "Descriptions{" +
                "abouts='" + abouts + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
