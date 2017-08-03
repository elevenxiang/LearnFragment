package com.htc.eleven.learnfragment;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by eleven on 17-8-3.
 */

public class UserData implements Parcelable {
    private String name;
    private String sex;
    private int age;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public UserData (String name, String sex, int age) {

        this.name = name;
        this.sex = sex;
        this.age = age;

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        Bundle data = new Bundle();
        data.putString("name", getName());
        data.putString("sex", getSex());
        data.putInt("age", getAge());

        parcel.writeBundle(data);
    }

    public static final Creator<UserData> CREATOR = new Creator<UserData>() {
        @Override
        public UserData createFromParcel(Parcel parcel) {
            Bundle bundle = parcel.readBundle();


            return new UserData(bundle.getString("name"), bundle.getString("sex"), bundle.getInt("age"));
        }

        @Override
        public UserData[] newArray(int i) {
            return new UserData[i];
        }
    };
}
