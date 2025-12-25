package com.hisona.allive;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import p000.C1749r5;

/* loaded from: classes2.dex */
public class ChannelData implements Parcelable, Comparable<ChannelData> {
    public static final Parcelable.Creator<ChannelData> CREATOR = new C1749r5(5);

    /* renamed from: a */
    public int f15806a;

    /* renamed from: b */
    public int f15807b;

    /* renamed from: c */
    public String f15808c;

    /* renamed from: d */
    public int f15809d;

    /* renamed from: e */
    public String f15810e;

    /* renamed from: f */
    public String f15811f;

    /* renamed from: g */
    public String f15812g;

    /* renamed from: h */
    public String f15813h;

    /* renamed from: i */
    public Boolean f15814i;

    /* renamed from: j */
    public int f15815j;

    /* renamed from: k */
    public int f15816k;

    /* renamed from: l */
    public int f15817l;

    /* renamed from: m */
    public ArrayList f15818m;

    public ChannelData() {
        this.f15808c = "";
        this.f15810e = "";
        this.f15811f = "";
        this.f15812g = "";
        this.f15813h = "";
        this.f15814i = Boolean.FALSE;
        this.f15815j = 0;
        this.f15816k = 0;
        this.f15817l = 0;
        this.f15818m = new ArrayList();
    }

    @Override // java.lang.Comparable
    public int compareTo(ChannelData channelData) {
        return 0;
    }

    public void copyFrom(ChannelData channelData) {
        setSiteType(channelData.getSiteType());
        setQualityType(channelData.getQualityType());
        setId(channelData.getId());
        setCategoryId(channelData.getCategoryId());
        setTitle(channelData.getTitle());
        setProgramName(channelData.getProgramName());
        setResolution(channelData.getResolution());
        setStillImageUrl(channelData.getStillImageUrl());
        setAudioChannel(channelData.isAudioChannel());
        setFavorite(channelData.getFavorite());
        setRowIndex(channelData.getRowIndex());
        setItemIndex(channelData.getItemIndex());
        this.f15818m = channelData.getEPG();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCategoryId() {
        return this.f15809d;
    }

    public ArrayList<EPGData> getEPG() {
        return this.f15818m;
    }

    public int getFavorite() {
        return this.f15815j;
    }

    public String getId() {
        return this.f15808c;
    }

    public int getItemIndex() {
        return this.f15817l;
    }

    public String getProgramName() {
        return this.f15811f;
    }

    public int getQualityType() {
        return this.f15807b;
    }

    public String getResolution() {
        return this.f15812g;
    }

    public int getRowIndex() {
        return this.f15816k;
    }

    public int getSiteType() {
        return this.f15806a;
    }

    public String getStillImageUrl() {
        return this.f15813h;
    }

    public String getTitle() {
        return this.f15810e;
    }

    public Boolean isAudioChannel() {
        return this.f15814i;
    }

    public void setAudioChannel(Boolean bool) {
        this.f15814i = bool;
    }

    public void setCategoryId(int i) {
        this.f15809d = i;
    }

    public void setEPG(ArrayList<EPGData> arrayList) {
        if (!this.f15818m.isEmpty()) {
            this.f15818m.clear();
        }
        this.f15818m = arrayList;
    }

    public void setFavorite(int i) {
        this.f15815j = i;
    }

    public void setId(String str) {
        this.f15808c = str;
    }

    public void setItemIndex(int i) {
        this.f15817l = i;
    }

    public void setProgramName(String str) {
        this.f15811f = str;
    }

    public void setQualityType(int i) {
        this.f15807b = i;
    }

    public void setResolution(String str) {
        this.f15812g = str;
    }

    public void setRowIndex(int i) {
        this.f15816k = i;
    }

    public void setSiteType(int i) {
        this.f15806a = i;
    }

    public void setStillImageUrl(String str) {
        this.f15813h = str;
    }

    public void setTitle(String str) {
        this.f15810e = str;
    }

    public String toString() {
        return "ChannelData{mSiteType=" + Integer.toString(this.f15806a) + ", mQualityType=" + Integer.toString(this.f15807b) + ", mId=" + this.f15808c + ", mCategoryId=" + Integer.toString(this.f15809d) + ", mTitle='" + this.f15810e + "', mProgramName='" + this.f15811f + "', mResolution='" + this.f15812g + "', mStillImageUrl='" + this.f15813h + "', mAudioChannel=" + this.f15814i + ", mFavorite=" + this.f15815j + ", mRowIndex=" + this.f15816k + ", mItemIndex=" + this.f15817l + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f15806a);
        parcel.writeInt(this.f15807b);
        parcel.writeString(this.f15808c);
        parcel.writeInt(this.f15809d);
        parcel.writeString(this.f15810e);
        parcel.writeString(this.f15811f);
        parcel.writeString(this.f15812g);
        parcel.writeString(this.f15813h);
        parcel.writeByte(this.f15814i.booleanValue() ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f15815j);
        parcel.writeInt(this.f15816k);
        parcel.writeInt(this.f15817l);
        parcel.writeList(this.f15818m);
    }

    public void setEPG(ArrayList<EPGData> arrayList, boolean z) {
        if (!this.f15818m.isEmpty()) {
            this.f15818m.clear();
        }
        if (z) {
            for (int i = 0; i < arrayList.size(); i++) {
                this.f15818m.add(new EPGData(arrayList.get(i)));
            }
            return;
        }
        this.f15818m = arrayList;
    }

    public ChannelData(ChannelData channelData) {
        this.f15808c = "";
        this.f15810e = "";
        this.f15811f = "";
        this.f15812g = "";
        this.f15813h = "";
        this.f15814i = Boolean.FALSE;
        this.f15815j = 0;
        this.f15816k = 0;
        this.f15817l = 0;
        this.f15818m = new ArrayList();
        setSiteType(channelData.getSiteType());
        setQualityType(channelData.getQualityType());
        setId(channelData.getId());
        setCategoryId(channelData.getCategoryId());
        setTitle(channelData.getTitle());
        setProgramName(channelData.getProgramName());
        setResolution(channelData.getResolution());
        setStillImageUrl(channelData.getStillImageUrl());
        setAudioChannel(channelData.isAudioChannel());
        setFavorite(channelData.getFavorite());
        setRowIndex(channelData.getRowIndex());
        setItemIndex(channelData.getItemIndex());
        for (int i = 0; i < channelData.getEPG().size(); i++) {
            this.f15818m.add(new EPGData(channelData.getEPG().get(i)));
        }
    }

    public ChannelData(Parcel parcel) {
        this.f15808c = "";
        this.f15810e = "";
        this.f15811f = "";
        this.f15812g = "";
        this.f15813h = "";
        this.f15814i = Boolean.FALSE;
        this.f15815j = 0;
        this.f15816k = 0;
        this.f15817l = 0;
        this.f15818m = new ArrayList();
        this.f15806a = parcel.readInt();
        this.f15807b = parcel.readInt();
        this.f15808c = parcel.readString();
        this.f15809d = parcel.readInt();
        this.f15810e = parcel.readString();
        this.f15811f = parcel.readString();
        this.f15812g = parcel.readString();
        this.f15813h = parcel.readString();
        this.f15814i = Boolean.valueOf(parcel.readByte() != 0);
        this.f15815j = parcel.readInt();
        this.f15816k = parcel.readInt();
        this.f15817l = parcel.readInt();
        this.f15818m = parcel.readArrayList(EPGData.class.getClassLoader());
    }
}
