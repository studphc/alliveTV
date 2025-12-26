package com.hisona.allive;

import android.os.Parcel;
import android.os.Parcelable;
import p000.AbstractC1726qj;
import p000.C1749r5;

/* loaded from: classes2.dex */
public class CategoryData implements Parcelable {
    public static final Parcelable.Creator<CategoryData> CREATOR = new C1749r5(4);

    /* renamed from: a */
    public int f15804a;

    /* renamed from: b */
    public String f15805b;

    public CategoryData() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getId() {
        return this.f15804a;
    }

    public String getTitle() {
        return this.f15805b;
    }

    public void setId(int i) {
        this.f15804a = i;
    }

    public void setTitle(String str) {
        this.f15805b = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ChannelData{mId=");
        sb.append(this.f15804a);
        sb.append(", mTitle='");
        return AbstractC1726qj.m7061q(sb, this.f15805b, "'}");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f15804a);
        parcel.writeString(this.f15805b);
    }

    public CategoryData(Parcel parcel) {
        this.f15804a = parcel.readInt();
        this.f15805b = parcel.readString();
    }
}
