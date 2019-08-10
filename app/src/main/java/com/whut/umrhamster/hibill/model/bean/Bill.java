package com.whut.umrhamster.hibill.model.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Bill implements Parcelable {
    private int id;
    private String title;
    private String description;
    private double money;
    private BillType billType;
    private Date date;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.title);
        dest.writeString(this.description);
        dest.writeDouble(this.money);
        dest.writeParcelable(this.billType, flags);
        dest.writeLong(this.date != null ? this.date.getTime() : -1);
    }

    public Bill() {
    }

    protected Bill(Parcel in) {
        this.id = in.readInt();
        this.title = in.readString();
        this.description = in.readString();
        this.money = in.readDouble();
        this.billType = in.readParcelable(BillType.class.getClassLoader());
        long tmpDate = in.readLong();
        this.date = tmpDate == -1 ? null : new Date(tmpDate);
    }

    public static final Parcelable.Creator<Bill> CREATOR = new Parcelable.Creator<Bill>() {
        @Override
        public Bill createFromParcel(Parcel source) {
            return new Bill(source);
        }

        @Override
        public Bill[] newArray(int size) {
            return new Bill[size];
        }
    };
}
