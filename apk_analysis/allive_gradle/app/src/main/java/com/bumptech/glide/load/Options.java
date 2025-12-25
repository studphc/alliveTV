package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class Options implements Key {

    /* renamed from: a */
    public final CachedHashCodeArrayMap f8632a = new CachedHashCodeArrayMap();

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof Options) {
            return this.f8632a.equals(((Options) obj).f8632a);
        }
        return false;
    }

    @Nullable
    public <T> T get(@NonNull Option<T> option) {
        CachedHashCodeArrayMap cachedHashCodeArrayMap = this.f8632a;
        if (cachedHashCodeArrayMap.containsKey(option)) {
            return (T) cachedHashCodeArrayMap.get(option);
        }
        return option.getDefaultValue();
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.f8632a.hashCode();
    }

    public void putAll(@NonNull Options options) {
        this.f8632a.putAll((SimpleArrayMap) options.f8632a);
    }

    @NonNull
    public <T> Options set(@NonNull Option<T> option, @NonNull T t) {
        this.f8632a.put(option, t);
        return this;
    }

    public String toString() {
        return "Options{values=" + this.f8632a + '}';
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        int i = 0;
        while (true) {
            CachedHashCodeArrayMap cachedHashCodeArrayMap = this.f8632a;
            if (i < cachedHashCodeArrayMap.getF1755c()) {
                ((Option) cachedHashCodeArrayMap.keyAt(i)).update(cachedHashCodeArrayMap.valueAt(i), messageDigest);
                i++;
            } else {
                return;
            }
        }
    }
}
