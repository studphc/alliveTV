package com.google.android.exoplayer2.metadata.icy;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Arrays;
import p000.C1749r5;
import p000.vn1;
import p000.ye0;

/* loaded from: classes.dex */
public final class IcyInfo implements Metadata.Entry {
    public static final Parcelable.Creator<IcyInfo> CREATOR = new C1749r5(16);
    public final byte[] rawMetadata;

    @Nullable
    public final String title;

    @Nullable
    public final String url;

    public IcyInfo(byte[] bArr, @Nullable String str, @Nullable String str2) {
        this.rawMetadata = bArr;
        this.title = str;
        this.url = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && IcyInfo.class == obj.getClass()) {
            return Arrays.equals(this.rawMetadata, ((IcyInfo) obj).rawMetadata);
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public final /* synthetic */ byte[] getWrappedMetadataBytes() {
        return vn1.m7926a(this);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public final /* synthetic */ Format getWrappedMetadataFormat() {
        return vn1.m7927b(this);
    }

    public int hashCode() {
        return Arrays.hashCode(this.rawMetadata);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public void populateMediaMetadata(MediaMetadata.Builder builder) {
        String str = this.title;
        if (str != null) {
            builder.setTitle(str);
        }
    }

    public String toString() {
        String str = this.title;
        String str2 = this.url;
        int length = this.rawMetadata.length;
        StringBuilder sb = new StringBuilder("ICY: title=\"");
        sb.append(str);
        sb.append("\", url=\"");
        sb.append(str2);
        sb.append("\", rawMetadata.length=\"");
        return ye0.m8298r(sb, "\"", length);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(this.rawMetadata);
        parcel.writeString(this.title);
        parcel.writeString(this.url);
    }

    public IcyInfo(Parcel parcel) {
        this.rawMetadata = (byte[]) Assertions.checkNotNull(parcel.createByteArray());
        this.title = parcel.readString();
        this.url = parcel.readString();
    }
}
