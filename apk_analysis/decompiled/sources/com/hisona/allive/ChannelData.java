package com.hisona.allive;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.r5;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class ChannelData implements Parcelable, Comparable<ChannelData> {
    public static final Parcelable.Creator<ChannelData> CREATOR = new r5(5);
    public int a;
    public int b;
    public String c;
    public int d;
    public String e;
    public String f;
    public String g;
    public String h;
    public Boolean i;
    public int j;
    public int k;
    public int l;
    public ArrayList m;

    public ChannelData() {
        this.c = "";
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = "";
        this.i = Boolean.FALSE;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = new ArrayList();
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
        this.m = channelData.getEPG();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCategoryId() {
        return this.d;
    }

    public ArrayList<EPGData> getEPG() {
        return this.m;
    }

    public int getFavorite() {
        return this.j;
    }

    public String getId() {
        return this.c;
    }

    public int getItemIndex() {
        return this.l;
    }

    public String getProgramName() {
        return this.f;
    }

    public int getQualityType() {
        return this.b;
    }

    public String getResolution() {
        return this.g;
    }

    public int getRowIndex() {
        return this.k;
    }

    public int getSiteType() {
        return this.a;
    }

    public String getStillImageUrl() {
        return this.h;
    }

    public String getTitle() {
        return this.e;
    }

    public Boolean isAudioChannel() {
        return this.i;
    }

    public void setAudioChannel(Boolean bool) {
        this.i = bool;
    }

    public void setCategoryId(int i) {
        this.d = i;
    }

    public void setEPG(ArrayList<EPGData> arrayList) {
        if (!this.m.isEmpty()) {
            this.m.clear();
        }
        this.m = arrayList;
    }

    public void setFavorite(int i) {
        this.j = i;
    }

    public void setId(String str) {
        this.c = str;
    }

    public void setItemIndex(int i) {
        this.l = i;
    }

    public void setProgramName(String str) {
        this.f = str;
    }

    public void setQualityType(int i) {
        this.b = i;
    }

    public void setResolution(String str) {
        this.g = str;
    }

    public void setRowIndex(int i) {
        this.k = i;
    }

    public void setSiteType(int i) {
        this.a = i;
    }

    public void setStillImageUrl(String str) {
        this.h = str;
    }

    public void setTitle(String str) {
        this.e = str;
    }

    public String toString() {
        return "ChannelData{mSiteType=" + Integer.toString(this.a) + ", mQualityType=" + Integer.toString(this.b) + ", mId=" + this.c + ", mCategoryId=" + Integer.toString(this.d) + ", mTitle='" + this.e + "', mProgramName='" + this.f + "', mResolution='" + this.g + "', mStillImageUrl='" + this.h + "', mAudioChannel=" + this.i + ", mFavorite=" + this.j + ", mRowIndex=" + this.k + ", mItemIndex=" + this.l + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeInt(this.b);
        parcel.writeString(this.c);
        parcel.writeInt(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeByte(this.i.booleanValue() ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.j);
        parcel.writeInt(this.k);
        parcel.writeInt(this.l);
        parcel.writeList(this.m);
    }

    public void setEPG(ArrayList<EPGData> arrayList, boolean z) {
        if (!this.m.isEmpty()) {
            this.m.clear();
        }
        if (z) {
            for (int i = 0; i < arrayList.size(); i++) {
                this.m.add(new EPGData(arrayList.get(i)));
            }
            return;
        }
        this.m = arrayList;
    }

    public ChannelData(ChannelData channelData) {
        this.c = "";
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = "";
        this.i = Boolean.FALSE;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = new ArrayList();
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
            this.m.add(new EPGData(channelData.getEPG().get(i)));
        }
    }

    public ChannelData(Parcel parcel) {
        this.c = "";
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = "";
        this.i = Boolean.FALSE;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = new ArrayList();
        this.a = parcel.readInt();
        this.b = parcel.readInt();
        this.c = parcel.readString();
        this.d = parcel.readInt();
        this.e = parcel.readString();
        this.f = parcel.readString();
        this.g = parcel.readString();
        this.h = parcel.readString();
        this.i = Boolean.valueOf(parcel.readByte() != 0);
        this.j = parcel.readInt();
        this.k = parcel.readInt();
        this.l = parcel.readInt();
        this.m = parcel.readArrayList(EPGData.class.getClassLoader());
    }
}
