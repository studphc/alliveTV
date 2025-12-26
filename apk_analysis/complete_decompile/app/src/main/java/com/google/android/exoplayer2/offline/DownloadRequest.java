package com.google.android.exoplayer2.offline;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import p000.C1749r5;

/* loaded from: classes.dex */
public final class DownloadRequest implements Parcelable {
    public static final Parcelable.Creator<DownloadRequest> CREATOR = new C1749r5(9);

    @Nullable
    public final String customCacheKey;
    public final byte[] data;

    /* renamed from: id */
    public final String f10811id;

    @Nullable
    public final byte[] keySetId;

    @Nullable
    public final String mimeType;
    public final List<StreamKey> streamKeys;
    public final Uri uri;

    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a */
        public final String f10812a;

        /* renamed from: b */
        public final Uri f10813b;

        /* renamed from: c */
        public String f10814c;

        /* renamed from: d */
        public List f10815d;

        /* renamed from: e */
        public byte[] f10816e;

        /* renamed from: f */
        public String f10817f;

        /* renamed from: g */
        public byte[] f10818g;

        public Builder(String str, Uri uri) {
            this.f10812a = str;
            this.f10813b = uri;
        }

        public DownloadRequest build() {
            String str = this.f10814c;
            List list = this.f10815d;
            if (list == null) {
                list = ImmutableList.m3902of();
            }
            return new DownloadRequest(this.f10812a, this.f10813b, str, list, this.f10816e, this.f10817f, this.f10818g);
        }

        public Builder setCustomCacheKey(@Nullable String str) {
            this.f10817f = str;
            return this;
        }

        public Builder setData(@Nullable byte[] bArr) {
            this.f10818g = bArr;
            return this;
        }

        public Builder setKeySetId(@Nullable byte[] bArr) {
            this.f10816e = bArr;
            return this;
        }

        public Builder setMimeType(@Nullable String str) {
            this.f10814c = str;
            return this;
        }

        public Builder setStreamKeys(@Nullable List<StreamKey> list) {
            this.f10815d = list;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static class UnsupportedRequestException extends IOException {
    }

    public DownloadRequest(String str, Uri uri, String str2, List list, byte[] bArr, String str3, byte[] bArr2) {
        int inferContentTypeForUriAndMimeType = Util.inferContentTypeForUriAndMimeType(uri, str2);
        if (inferContentTypeForUriAndMimeType == 0 || inferContentTypeForUriAndMimeType == 2 || inferContentTypeForUriAndMimeType == 1) {
            Assertions.checkArgument(str3 == null, "customCacheKey must be null for type: " + inferContentTypeForUriAndMimeType);
        }
        this.f10811id = str;
        this.uri = uri;
        this.mimeType = str2;
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList);
        this.streamKeys = Collections.unmodifiableList(arrayList);
        this.keySetId = bArr != null ? Arrays.copyOf(bArr, bArr.length) : null;
        this.customCacheKey = str3;
        this.data = bArr2 != null ? Arrays.copyOf(bArr2, bArr2.length) : Util.EMPTY_BYTE_ARRAY;
    }

    public DownloadRequest copyWithId(String str) {
        return new DownloadRequest(str, this.uri, this.mimeType, this.streamKeys, this.keySetId, this.customCacheKey, this.data);
    }

    public DownloadRequest copyWithKeySetId(@Nullable byte[] bArr) {
        return new DownloadRequest(this.f10811id, this.uri, this.mimeType, this.streamKeys, bArr, this.customCacheKey, this.data);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.util.ArrayList] */
    public DownloadRequest copyWithMergedRequest(DownloadRequest downloadRequest) {
        List emptyList;
        Assertions.checkArgument(this.f10811id.equals(downloadRequest.f10811id));
        if (!this.streamKeys.isEmpty() && !downloadRequest.streamKeys.isEmpty()) {
            emptyList = new ArrayList(this.streamKeys);
            for (int i = 0; i < downloadRequest.streamKeys.size(); i++) {
                StreamKey streamKey = downloadRequest.streamKeys.get(i);
                if (!emptyList.contains(streamKey)) {
                    emptyList.add(streamKey);
                }
            }
        } else {
            emptyList = Collections.emptyList();
        }
        return new DownloadRequest(this.f10811id, downloadRequest.uri, downloadRequest.mimeType, emptyList, downloadRequest.keySetId, downloadRequest.customCacheKey, downloadRequest.data);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof DownloadRequest)) {
            return false;
        }
        DownloadRequest downloadRequest = (DownloadRequest) obj;
        if (!this.f10811id.equals(downloadRequest.f10811id) || !this.uri.equals(downloadRequest.uri) || !Util.areEqual(this.mimeType, downloadRequest.mimeType) || !this.streamKeys.equals(downloadRequest.streamKeys) || !Arrays.equals(this.keySetId, downloadRequest.keySetId) || !Util.areEqual(this.customCacheKey, downloadRequest.customCacheKey) || !Arrays.equals(this.data, downloadRequest.data)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int i;
        int hashCode = (this.uri.hashCode() + (this.f10811id.hashCode() * 961)) * 31;
        String str = this.mimeType;
        int i2 = 0;
        if (str != null) {
            i = str.hashCode();
        } else {
            i = 0;
        }
        int hashCode2 = (Arrays.hashCode(this.keySetId) + ((this.streamKeys.hashCode() + ((hashCode + i) * 31)) * 31)) * 31;
        String str2 = this.customCacheKey;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return Arrays.hashCode(this.data) + ((hashCode2 + i2) * 31);
    }

    public MediaItem toMediaItem() {
        return new MediaItem.Builder().setMediaId(this.f10811id).setUri(this.uri).setCustomCacheKey(this.customCacheKey).setMimeType(this.mimeType).setStreamKeys(this.streamKeys).build();
    }

    public String toString() {
        return this.mimeType + ":" + this.f10811id;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f10811id);
        parcel.writeString(this.uri.toString());
        parcel.writeString(this.mimeType);
        parcel.writeInt(this.streamKeys.size());
        for (int i2 = 0; i2 < this.streamKeys.size(); i2++) {
            parcel.writeParcelable(this.streamKeys.get(i2), 0);
        }
        parcel.writeByteArray(this.keySetId);
        parcel.writeString(this.customCacheKey);
        parcel.writeByteArray(this.data);
    }

    public DownloadRequest(Parcel parcel) {
        this.f10811id = (String) Util.castNonNull(parcel.readString());
        this.uri = Uri.parse((String) Util.castNonNull(parcel.readString()));
        this.mimeType = parcel.readString();
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            arrayList.add((StreamKey) parcel.readParcelable(StreamKey.class.getClassLoader()));
        }
        this.streamKeys = Collections.unmodifiableList(arrayList);
        this.keySetId = parcel.createByteArray();
        this.customCacheKey = parcel.readString();
        this.data = (byte[]) Util.castNonNull(parcel.createByteArray());
    }
}
