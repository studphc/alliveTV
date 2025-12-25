package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import p000.C1749r5;
import p000.ye0;

/* loaded from: classes.dex */
public final class BinaryFrame extends Id3Frame {
    public static final Parcelable.Creator<BinaryFrame> CREATOR = new C1749r5(3);
    public final byte[] data;

    public BinaryFrame(String str, byte[] bArr) {
        super(str);
        this.data = bArr;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || BinaryFrame.class != obj.getClass()) {
            return false;
        }
        BinaryFrame binaryFrame = (BinaryFrame) obj;
        if (this.f10763id.equals(binaryFrame.f10763id) && Arrays.equals(this.data, binaryFrame.data)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(this.data) + ye0.m8286f(527, 31, this.f10763id);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f10763id);
        parcel.writeByteArray(this.data);
    }

    public BinaryFrame(Parcel parcel) {
        super((String) Util.castNonNull(parcel.readString()));
        this.data = (byte[]) Util.castNonNull(parcel.createByteArray());
    }
}
