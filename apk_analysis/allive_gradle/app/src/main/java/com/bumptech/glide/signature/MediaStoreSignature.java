package com.bumptech.glide.signature;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Key;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public class MediaStoreSignature implements Key {

    /* renamed from: a */
    public final String f9154a;

    /* renamed from: b */
    public final long f9155b;

    /* renamed from: c */
    public final int f9156c;

    public MediaStoreSignature(@Nullable String str, long j, int i) {
        this.f9154a = str == null ? "" : str;
        this.f9155b = j;
        this.f9156c = i;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MediaStoreSignature mediaStoreSignature = (MediaStoreSignature) obj;
        if (this.f9155b == mediaStoreSignature.f9155b && this.f9156c == mediaStoreSignature.f9156c && this.f9154a.equals(mediaStoreSignature.f9154a)) {
            return true;
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        int hashCode = this.f9154a.hashCode() * 31;
        long j = this.f9155b;
        return ((hashCode + ((int) (j ^ (j >>> 32)))) * 31) + this.f9156c;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(ByteBuffer.allocate(12).putLong(this.f9155b).putInt(this.f9156c).array());
        messageDigest.update(this.f9154a.getBytes(Key.CHARSET));
    }
}
