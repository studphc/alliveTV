package com.google.android.exoplayer2.offline;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import p000.u82;

/* loaded from: classes.dex */
public final class StreamKey implements Comparable<StreamKey>, Parcelable {
    public static final Parcelable.Creator<StreamKey> CREATOR = new u82(7);
    public final int groupIndex;
    public final int periodIndex;
    public final int streamIndex;

    @Deprecated
    public final int trackIndex;

    public StreamKey(int i, int i2) {
        this(0, i, i2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || StreamKey.class != obj.getClass()) {
            return false;
        }
        StreamKey streamKey = (StreamKey) obj;
        if (this.periodIndex == streamKey.periodIndex && this.groupIndex == streamKey.groupIndex && this.streamIndex == streamKey.streamIndex) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.periodIndex * 31) + this.groupIndex) * 31) + this.streamIndex;
    }

    public String toString() {
        return this.periodIndex + "." + this.groupIndex + "." + this.streamIndex;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.periodIndex);
        parcel.writeInt(this.groupIndex);
        parcel.writeInt(this.streamIndex);
    }

    public StreamKey(int i, int i2, int i3) {
        this.periodIndex = i;
        this.groupIndex = i2;
        this.streamIndex = i3;
        this.trackIndex = i3;
    }

    @Override // java.lang.Comparable
    public int compareTo(StreamKey streamKey) {
        int i = this.periodIndex - streamKey.periodIndex;
        if (i != 0) {
            return i;
        }
        int i2 = this.groupIndex - streamKey.groupIndex;
        return i2 == 0 ? this.streamIndex - streamKey.streamIndex : i2;
    }

    public StreamKey(Parcel parcel) {
        this.periodIndex = parcel.readInt();
        this.groupIndex = parcel.readInt();
        int readInt = parcel.readInt();
        this.streamIndex = readInt;
        this.trackIndex = readInt;
    }
}
