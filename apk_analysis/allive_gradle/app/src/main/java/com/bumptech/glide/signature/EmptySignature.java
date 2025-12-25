package com.bumptech.glide.signature;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class EmptySignature implements Key {

    /* renamed from: a */
    public static final EmptySignature f9153a = new Object();

    @NonNull
    public static EmptySignature obtain() {
        return f9153a;
    }

    public String toString() {
        return "EmptySignature";
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
    }
}
