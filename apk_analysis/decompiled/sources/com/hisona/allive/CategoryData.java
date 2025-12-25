package com.hisona.allive;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.qj;
import defpackage.r5;

/* loaded from: classes2.dex */
public class CategoryData implements Parcelable {
    public static final Parcelable.Creator<CategoryData> CREATOR = new r5(4);
    public int a;
    public String b;

    public CategoryData() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getId() {
        return this.a;
    }

    public String getTitle() {
        return this.b;
    }

    public void setId(int i) {
        this.a = i;
    }

    public void setTitle(String str) {
        this.b = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ChannelData{mId=");
        sb.append(this.a);
        sb.append(", mTitle='");
        return qj.q(sb, this.b, "'}");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeString(this.b);
    }

    public CategoryData(Parcel parcel) {
        this.a = parcel.readInt();
        this.b = parcel.readString();
    }
}
