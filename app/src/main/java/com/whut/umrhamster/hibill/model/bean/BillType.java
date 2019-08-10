package com.whut.umrhamster.hibill.model.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class BillType implements Parcelable {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
    }

    public BillType() {
    }

    protected BillType(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
    }

    public static final Parcelable.Creator<BillType> CREATOR = new Parcelable.Creator<BillType>() {
        @Override
        public BillType createFromParcel(Parcel source) {
            return new BillType(source);
        }

        @Override
        public BillType[] newArray(int size) {
            return new BillType[size];
        }
    };
}
