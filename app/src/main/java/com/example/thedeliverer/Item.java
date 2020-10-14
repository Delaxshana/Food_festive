package com.example.thedeliverer;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

public class Item implements Parcelable {

    int id;
    String name;
    String type;
    String description;
    Bitmap image;
    String price;

    public Item() {

    }

    public Item(int id, String name, String type, String desc, Bitmap image){
        this.id=id;
        this.name=name;
        this.type=type;
        this.description=desc;
        this.image=image;

    }

    protected Item(Parcel in) {
        id=in.readInt();
        name=in.readString();
        type=in.readString();
        description=in.readString();
        image=in.readParcelable(Bitmap.class.getClassLoader());
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    public int getId(){
     return id;
    }

    public void setId(int id){
        this.id=id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getType(){
        return type;
    }

    public void setType(){
        this.type=type;
    }

    public Bitmap getImage(){
        return image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(type);
        dest.writeString(description);
        dest.writeParcelable(image, flags);
    }

}
