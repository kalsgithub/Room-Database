package com.mcs.kalherath.playground;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

@Entity
public class Student implements Parcelable {

    @PrimaryKey
    @NonNull
    private int rollNum;
    @ColumnInfo (name = "first_name")
    private String firstName;
    @ColumnInfo (name = "last_name")
    private String lastName;



    public Student(String firstName, String lastName, int rollNum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.rollNum = rollNum;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getRollNum() {
        return rollNum;
    }

    public void setRollNum(int rollNum) {
        this.rollNum = rollNum;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(firstName);
        dest.writeString(lastName);
        dest.writeInt(rollNum);
    }
    private Student(Parcel in) {
        firstName = in.readString();
        lastName = in.readString();
        rollNum = in.readInt();
    }

    public static final Parcelable.Creator<Student> CREATOR
            = new Parcelable.Creator<Student>() {

        // This simply calls our new constructor (typically private) and
        // passes along the unmarshalled `Parcel`, and then returns the new object!
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        // We just need to copy this and change the type to match our class.
        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };
}
