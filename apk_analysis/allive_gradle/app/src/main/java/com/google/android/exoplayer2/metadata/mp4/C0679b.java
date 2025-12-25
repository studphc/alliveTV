package com.google.android.exoplayer2.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.mp4.SlowMotionData;

/* renamed from: com.google.android.exoplayer2.metadata.mp4.b */
/* loaded from: classes.dex */
public final class C0679b implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        return new SlowMotionData.Segment(parcel.readLong(), parcel.readLong(), parcel.readInt());
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new SlowMotionData.Segment[i];
    }
}
