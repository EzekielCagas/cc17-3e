package com.example.dressire.Model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Women implements Parcelable {

    String img;
    String name;
    int price;
    String key;

    public Women(){}

    public Women(String img, String name, int price) {
        this.img = img;
        this.name = name;
        this.price = price;
    }

    protected Women(Parcel in){
        img = in.readString();
        name = in.readString();
        price = in.readInt();
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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
        dest.writeInt(price);
    }
}
