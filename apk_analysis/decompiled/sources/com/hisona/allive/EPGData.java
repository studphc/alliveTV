package com.hisona.allive;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.r5;
import java.util.Date;

/* loaded from: classes2.dex */
public class EPGData implements Parcelable {
    public static final Parcelable.Creator<EPGData> CREATOR = new r5(11);
    public String a;
    public Date b;
    public Date c;
    public Boolean d;
    public Boolean e;

    public EPGData() {
        this.a = "";
        this.b = null;
        this.c = null;
        this.d = Boolean.FALSE;
        this.e = Boolean.TRUE;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Date getEndTime() {
        return this.c;
    }

    public String getProgramName() {
        return this.a;
    }

    public Date getStartTime() {
        return this.b;
    }

    public Boolean isAdultContent() {
        return this.d;
    }

    public Boolean isFreeContent() {
        return this.e;
    }

    public void setAdultContent(Boolean bool) {
        this.d = bool;
    }

    public void setEndTime(Date date) {
        this.c = date;
    }

    public void setFreeContent(Boolean bool) {
        this.e = bool;
    }

    public void setProgramName(String str) {
        this.a = str;
    }

    public void setStartTime(Date date) {
        this.b = date;
    }

    public String toString() {
        return "EPGData{mProgramName=" + this.a + ", mStartTime=" + this.b.toString() + ", mEndTime=" + this.c.toString() + ", mAdultContent=" + this.d + ", mFreeContent=" + this.e + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeSerializable(this.b);
        parcel.writeSerializable(this.c);
        parcel.writeByte(this.d.booleanValue() ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.e.booleanValue() ? (byte) 1 : (byte) 0);
    }

    public EPGData(EPGData ePGData) {
        this.a = "";
        this.b = null;
        this.c = null;
        this.d = Boolean.FALSE;
        this.e = Boolean.TRUE;
        setProgramName(ePGData.getProgramName());
        setStartTime(ePGData.getStartTime());
        setEndTime(ePGData.getEndTime());
        setAdultContent(ePGData.isAdultContent());
        setFreeContent(ePGData.isFreeContent());
    }

    public EPGData(String str, Date date, Date date2, Boolean bool, Boolean bool2) {
        this.a = "";
        this.b = null;
        this.c = null;
        this.d = Boolean.FALSE;
        this.e = Boolean.TRUE;
        setProgramName(str);
        setStartTime(date);
        setEndTime(date2);
        setAdultContent(bool);
        setFreeContent(bool2);
    }

    public EPGData(Parcel parcel) {
        this.a = "";
        this.b = null;
        this.c = null;
        this.d = Boolean.FALSE;
        this.e = Boolean.TRUE;
        this.a = parcel.readString();
        this.b = (Date) parcel.readSerializable();
        this.c = (Date) parcel.readSerializable();
        this.d = Boolean.valueOf(parcel.readByte() != 0);
        this.e = Boolean.valueOf(parcel.readByte() != 0);
    }
}
