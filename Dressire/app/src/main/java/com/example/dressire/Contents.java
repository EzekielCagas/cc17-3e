package com.example.dressire;

public class Contents {

    private String aboutName, desc;
    private boolean expandable;

    public boolean isExpandable() {
        return expandable;
    }

    public void setExpandable(boolean expandable) {
        this.expandable = expandable;
    }

    public Contents(String aboutName, String desc) {
        this.aboutName = aboutName;
        this.desc = desc;
        this.expandable = false;
    }

    public String getAboutName() {
        return aboutName;
    }

    public void setAboutName(String aboutName) {
        this.aboutName = aboutName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Contents{" +
                "aboutName='" + aboutName + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
