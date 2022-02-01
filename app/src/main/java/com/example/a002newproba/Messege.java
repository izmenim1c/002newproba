package com.example.a002newproba;

import android.os.Parcel;
import android.os.Parcelable;

public class Messege implements Parcelable {
    private int id;
    private String text;

    public Messege(int id, String text) {
        this.id = id;
        this.text = text;
    }

    protected Messege(Parcel in) {
        id = in.readInt();
        text = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(text);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Messege> CREATOR = new Creator<Messege>() {
        @Override
        public Messege createFromParcel(Parcel in) {
            return new Messege(in);
        }

        @Override
        public Messege[] newArray(int size) {
            return new Messege[size];
        }
    };

    public String getText() {
        return text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }
}
