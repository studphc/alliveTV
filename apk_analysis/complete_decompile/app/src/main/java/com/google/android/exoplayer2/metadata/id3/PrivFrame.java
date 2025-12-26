package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import p000.C1749r5;

/* loaded from: classes.dex */
public final class PrivFrame extends Id3Frame {
    public static final Parcelable.Creator<PrivFrame> CREATOR = new C1749r5(28);

    /* renamed from: ID */
    public static final String f10766ID = "PRIV";
    public final String owner;
    public final byte[] privateData;

    public PrivFrame(String str, byte[] bArr) {
        super(f10766ID);
        this.owner = str;
        this.privateData = bArr;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || PrivFrame.class != obj.getClass()) {
            return false;
        }
        PrivFrame privFrame = (PrivFrame) obj;
        if (Util.areEqual(this.owner, privFrame.owner) && Arrays.equals(this.privateData, privFrame.privateData)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i;
        String str = this.owner;
        if (str != null) {
            i = str.hashCode();
        } else {
            i = 0;
        }
        return Arrays.hashCode(this.privateData) + ((527 + i) * 31);
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public String toString() {
        return this.f10763id + ": owner=" + this.owner;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.owner);
        parcel.writeByteArray(this.privateData);
    }

    public PrivFrame(Parcel parcel) {
        super(f10766ID);
        this.owner = (String) Util.castNonNull(parcel.readString());
        this.privateData = (byte[]) Util.castNonNull(parcel.createByteArray());
    }
}
