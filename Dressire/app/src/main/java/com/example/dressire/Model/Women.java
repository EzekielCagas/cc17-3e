package com.example.dressire.Model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Women implements Parcelable {

    String img;
    String name;
    String price;
    double bookmark;
    String key;

    public Women(){}

    public Women(String img, String name, String price, double bookmark) {
        this.img = img;
        this.name = name;
        this.price = price;
        this.bookmark = bookmark;
    }

    protected Women(Parcel in){
        img = in.readString();
        name = in.readString();
        price = in.readString();
        bookmark = in.readDouble();
        key = in.readString();
    }


    public static final Creator<Women> CREATOR = new Creator<Women>() {
        @Override
        public Women createFromParcel(Parcel in) {
            return new Women(in);
        }

        @Override
        public Women[] newArray(int size) {
            return new Women[size];
        }
    };

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public double getBookmark() {
        return bookmark;
    }

    public void setBookmark(double bookmark) {
        this.bookmark = bookmark;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(img);
        dest.writeString(name);
        dest.writeString(price);
        dest.writeDouble(bookmark);
    }
}
