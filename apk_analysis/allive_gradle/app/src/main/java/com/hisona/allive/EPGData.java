package com.hisona.allive;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Date;
import p000.C1749r5;

/* loaded from: classes2.dex */
public class EPGData implements Parcelable {
    public static final Parcelable.Creator<EPGData> CREATOR = new C1749r5(11);

    /* renamed from: a */
    public String f15819a;

    /* renamed from: b */
    public Date f15820b;

    /* renamed from: c */
    public Date f15821c;

    /* renamed from: d */
    public Boolean f15822d;

    /* renamed from: e */
    public Boolean f15823e;

    public EPGData() {
        this.f15819a = "";
        this.f15820b = null;
        this.f15821c = null;
        this.f15822d = Boolean.FALSE;
        this.f15823e = Boolean.TRUE;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Date getEndTime() {
        return this.f15821c;
    }

    public String getProgramName() {
        return this.f15819a;
    }

    public Date getStartTime() {
        return this.f15820b;
    }

    public Boolean isAdultContent() {
        return this.f15822d;
    }

    public Boolean isFreeContent() {
        return this.f15823e;
    }

    public void setAdultContent(Boolean bool) {
        this.f15822d = bool;
    }

    public void setEndTime(Date date) {
        this.f15821c = date;
    }

    public void setFreeContent(Boolean bool) {
        this.f15823e = bool;
    }

    public void setProgramName(String str) {
        this.f15819a = str;
    }

    public void setStartTime(Date date) {
        this.f15820b = date;
    }

    public String toString() {
        return "EPGData{mProgramName=" + this.f15819a + ", mStartTime=" + this.f15820b.toString() + ", mEndTime=" + this.f15821c.toString() + ", mAdultContent=" + this.f15822d + ", mFreeContent=" + this.f15823e + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f15819a);
        parcel.writeSerializable(this.f15820b);
        parcel.writeSerializable(this.f15821c);
        parcel.writeByte(this.f15822d.booleanValue() ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f15823e.booleanValue() ? (byte) 1 : (byte) 0);
    }

    public EPGData(EPGData ePGData) {
        this.f15819a = "";
        this.f15820b = null;
        this.f15821c = null;
        this.f15822d = Boolean.FALSE;
        this.f15823e = Boolean.TRUE;
        setProgramName(ePGData.getProgramName());
        setStartTime(ePGData.getStartTime());
        setEndTime(ePGData.getEndTime());
        setAdultContent(ePGData.isAdultContent());
        setFreeContent(ePGData.isFreeContent());
    }

    public EPGData(String str, Date date, Date date2, Boolean bool, Boolean bool2) {
        this.f15819a = "";
        this.f15820b = null;
        this.f15821c = null;
        this.f15822d = Boolean.FALSE;
        this.f15823e = Boolean.TRUE;
        setProgramName(str);
        setStartTime(date);
        setEndTime(date2);
        setAdultContent(bool);
        setFreeContent(bool2);
    }

    public EPGData(Parcel parcel) {
        this.f15819a = "";
        this.f15820b = null;
        this.f15821c = null;
        this.f15822d = Boolean.FALSE;
        this.f15823e = Boolean.TRUE;
        this.f15819a = parcel.readString();
        this.f15820b = (Date) parcel.readSerializable();
        this.f15821c = (Date) parcel.readSerializable();
        this.f15822d = Boolean.valueOf(parcel.readByte() != 0);
        this.f15823e = Boolean.valueOf(parcel.readByte() != 0);
    }
}
