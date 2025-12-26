package com.bumptech.glide.signature;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class ObjectKey implements Key {

    /* renamed from: a */
    public final Object f9157a;

    public ObjectKey(@NonNull Object obj) {
        this.f9157a = Preconditions.checkNotNull(obj);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof ObjectKey) {
            return this.f9157a.equals(((ObjectKey) obj).f9157a);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.f9157a.hashCode();
    }

    public String toString() {
        return "ObjectKey{object=" + this.f9157a + '}';
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(this.f9157a.toString().getBytes(Key.CHARSET));
    }
}
