package com.google.android.exoplayer2.source.hls;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry;

/* renamed from: com.google.android.exoplayer2.source.hls.a */
/* loaded from: classes.dex */
public final class C0700a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        return new HlsTrackMetadataEntry.VariantInfo(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new HlsTrackMetadataEntry.VariantInfo[i];
    }
}
