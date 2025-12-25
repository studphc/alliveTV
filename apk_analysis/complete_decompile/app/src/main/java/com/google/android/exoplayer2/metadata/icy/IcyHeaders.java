package com.google.android.exoplayer2.metadata.icy;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.util.List;
import java.util.Map;
import p000.C1749r5;
import p000.vn1;
import p000.ye0;

/* loaded from: classes.dex */
public final class IcyHeaders implements Metadata.Entry {
    public static final Parcelable.Creator<IcyHeaders> CREATOR = new C1749r5(15);
    public static final String REQUEST_HEADER_ENABLE_METADATA_NAME = "Icy-MetaData";
    public static final String REQUEST_HEADER_ENABLE_METADATA_VALUE = "1";
    public final int bitrate;

    @Nullable
    public final String genre;
    public final boolean isPublic;
    public final int metadataInterval;

    @Nullable
    public final String name;

    @Nullable
    public final String url;

    public IcyHeaders(int i, @Nullable String str, @Nullable String str2, @Nullable String str3, boolean z, int i2) {
        Assertions.checkArgument(i2 == -1 || i2 > 0);
        this.bitrate = i;
        this.genre = str;
        this.name = str2;
        this.url = str3;
        this.isPublic = z;
        this.metadataInterval = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0054  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static IcyHeaders parse(Map<String, List<String>> map) {
        boolean z;
        int i;
        List<String> list;
        String str;
        List<String> list2;
        String str2;
        List<String> list3;
        String str3;
        List<String> list4;
        boolean z2;
        List<String> list5;
        int i2;
        List<String> list6 = map.get("icy-br");
        boolean z3 = true;
        int i3 = -1;
        if (list6 != null) {
            String str4 = list6.get(0);
            try {
                i2 = Integer.parseInt(str4) * 1000;
                if (i2 > 0) {
                    z = true;
                } else {
                    try {
                        Log.m3027w("IcyHeaders", "Invalid bitrate: " + str4);
                        z = false;
                        i2 = -1;
                    } catch (NumberFormatException unused) {
                        ye0.m8279B("Invalid bitrate header: ", str4, "IcyHeaders");
                        z = false;
                        i = i2;
                        list = map.get("icy-genre");
                        if (list == null) {
                        }
                        list2 = map.get("icy-name");
                        if (list2 == null) {
                        }
                        list3 = map.get("icy-url");
                        if (list3 == null) {
                        }
                        list4 = map.get("icy-pub");
                        if (list4 == null) {
                        }
                        list5 = map.get("icy-metaint");
                        if (list5 != null) {
                        }
                        int i4 = i3;
                        if (!z) {
                        }
                    }
                }
            } catch (NumberFormatException unused2) {
                i2 = -1;
            }
            i = i2;
        } else {
            z = false;
            i = -1;
        }
        list = map.get("icy-genre");
        if (list == null) {
            str = list.get(0);
            z = true;
        } else {
            str = null;
        }
        list2 = map.get("icy-name");
        if (list2 == null) {
            str2 = list2.get(0);
            z = true;
        } else {
            str2 = null;
        }
        list3 = map.get("icy-url");
        if (list3 == null) {
            str3 = list3.get(0);
            z = true;
        } else {
            str3 = null;
        }
        list4 = map.get("icy-pub");
        if (list4 == null) {
            z2 = list4.get(0).equals(REQUEST_HEADER_ENABLE_METADATA_VALUE);
            z = true;
        } else {
            z2 = false;
        }
        list5 = map.get("icy-metaint");
        if (list5 != null) {
            String str5 = list5.get(0);
            try {
                int parseInt = Integer.parseInt(str5);
                if (parseInt > 0) {
                    i3 = parseInt;
                } else {
                    try {
                        Log.m3027w("IcyHeaders", "Invalid metadata interval: " + str5);
                        z3 = z;
                    } catch (NumberFormatException unused3) {
                        i3 = parseInt;
                        ye0.m8279B("Invalid metadata interval: ", str5, "IcyHeaders");
                        int i42 = i3;
                        if (!z) {
                        }
                    }
                }
                z = z3;
            } catch (NumberFormatException unused4) {
            }
        }
        int i422 = i3;
        if (!z) {
            return null;
        }
        return new IcyHeaders(i, str, str2, str3, z2, i422);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || IcyHeaders.class != obj.getClass()) {
            return false;
        }
        IcyHeaders icyHeaders = (IcyHeaders) obj;
        if (this.bitrate == icyHeaders.bitrate && Util.areEqual(this.genre, icyHeaders.genre) && Util.areEqual(this.name, icyHeaders.name) && Util.areEqual(this.url, icyHeaders.url) && this.isPublic == icyHeaders.isPublic && this.metadataInterval == icyHeaders.metadataInterval) {
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
        int i;
        int i2;
        int i3 = (527 + this.bitrate) * 31;
        String str = this.genre;
        int i4 = 0;
        if (str != null) {
            i = str.hashCode();
        } else {
            i = 0;
        }
        int i5 = (i3 + i) * 31;
        String str2 = this.name;
        if (str2 != null) {
            i2 = str2.hashCode();
        } else {
            i2 = 0;
        }
        int i6 = (i5 + i2) * 31;
        String str3 = this.url;
        if (str3 != null) {
            i4 = str3.hashCode();
        }
        return ((((i6 + i4) * 31) + (this.isPublic ? 1 : 0)) * 31) + this.metadataInterval;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public void populateMediaMetadata(MediaMetadata.Builder builder) {
        String str = this.name;
        if (str != null) {
            builder.setStation(str);
        }
        String str2 = this.genre;
        if (str2 != null) {
            builder.setGenre(str2);
        }
    }

    public String toString() {
        return "IcyHeaders: name=\"" + this.name + "\", genre=\"" + this.genre + "\", bitrate=" + this.bitrate + ", metadataInterval=" + this.metadataInterval;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.bitrate);
        parcel.writeString(this.genre);
        parcel.writeString(this.name);
        parcel.writeString(this.url);
        Util.writeBoolean(parcel, this.isPublic);
        parcel.writeInt(this.metadataInterval);
    }

    public IcyHeaders(Parcel parcel) {
        this.bitrate = parcel.readInt();
        this.genre = parcel.readString();
        this.name = parcel.readString();
        this.url = parcel.readString();
        this.isPublic = Util.readBoolean(parcel);
        this.metadataInterval = parcel.readInt();
    }
}
