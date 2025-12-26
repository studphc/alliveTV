package com.google.android.exoplayer2.metadata.flac;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.Util;
import p000.u82;
import p000.vn1;
import p000.ye0;

@Deprecated
/* loaded from: classes.dex */
public class VorbisComment implements Metadata.Entry {
    public static final Parcelable.Creator<VorbisComment> CREATOR = new u82(12);
    public final String key;
    public final String value;

    public VorbisComment(String str, String str2) {
        this.key = str;
        this.value = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        VorbisComment vorbisComment = (VorbisComment) obj;
        if (this.key.equals(vorbisComment.key) && this.value.equals(vorbisComment.value)) {
            return true;
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
        return this.value.hashCode() + ye0.m8286f(527, 31, this.key);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public void populateMediaMetadata(MediaMetadata.Builder builder) {
        String str = this.key;
        str.getClass();
        char c = 65535;
        switch (str.hashCode()) {
            case 62359119:
                if (str.equals("ALBUM")) {
                    c = 0;
                    break;
                }
                break;
            case 79833656:
                if (str.equals("TITLE")) {
                    c = 1;
                    break;
                }
                break;
            case 428414940:
                if (str.equals("DESCRIPTION")) {
                    c = 2;
                    break;
                }
                break;
            case 1746739798:
                if (str.equals("ALBUMARTIST")) {
                    c = 3;
                    break;
                }
                break;
            case 1939198791:
                if (str.equals("ARTIST")) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                builder.setAlbumTitle(this.value);
                return;
            case 1:
                builder.setTitle(this.value);
                return;
            case 2:
                builder.setDescription(this.value);
                return;
            case 3:
                builder.setAlbumArtist(this.value);
                return;
            case 4:
                builder.setArtist(this.value);
                return;
            default:
                return;
        }
    }

    public String toString() {
        return "VC: " + this.key + "=" + this.value;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.key);
        parcel.writeString(this.value);
    }

    public VorbisComment(Parcel parcel) {
        this.key = (String) Util.castNonNull(parcel.readString());
        this.value = (String) Util.castNonNull(parcel.readString());
    }
}
