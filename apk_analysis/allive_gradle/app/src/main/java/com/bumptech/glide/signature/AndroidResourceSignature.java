package com.bumptech.glide.signature;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class AndroidResourceSignature implements Key {

    /* renamed from: a */
    public final int f9150a;

    /* renamed from: b */
    public final Key f9151b;

    public AndroidResourceSignature(int i, Key key) {
        this.f9150a = i;
        this.f9151b = key;
    }

    @NonNull
    public static Key obtain(@NonNull Context context) {
        return new AndroidResourceSignature(context.getResources().getConfiguration().uiMode & 48, ApplicationVersionSignature.obtain(context));
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (!(obj instanceof AndroidResourceSignature)) {
            return false;
        }
        AndroidResourceSignature androidResourceSignature = (AndroidResourceSignature) obj;
        if (this.f9150a != androidResourceSignature.f9150a || !this.f9151b.equals(androidResourceSignature.f9151b)) {
            return false;
        }
        return true;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return Util.hashCode(this.f9151b, this.f9150a);
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        this.f9151b.updateDiskCacheKey(messageDigest);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f9150a).array());
    }
}
