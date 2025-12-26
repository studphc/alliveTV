package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;
import p000.AbstractC1726qj;

/* loaded from: classes.dex */
public final class Option<T> {

    /* renamed from: e */
    public static final C0605a f8627e = new Object();

    /* renamed from: a */
    public final Object f8628a;

    /* renamed from: b */
    public final CacheKeyUpdater f8629b;

    /* renamed from: c */
    public final String f8630c;

    /* renamed from: d */
    public volatile byte[] f8631d;

    /* loaded from: classes.dex */
    public interface CacheKeyUpdater<T> {
        void update(@NonNull byte[] bArr, @NonNull T t, @NonNull MessageDigest messageDigest);
    }

    public Option(String str, Object obj, CacheKeyUpdater cacheKeyUpdater) {
        this.f8630c = Preconditions.checkNotEmpty(str);
        this.f8628a = obj;
        this.f8629b = (CacheKeyUpdater) Preconditions.checkNotNull(cacheKeyUpdater);
    }

    @NonNull
    public static <T> Option<T> disk(@NonNull String str, @NonNull CacheKeyUpdater<T> cacheKeyUpdater) {
        return new Option<>(str, null, cacheKeyUpdater);
    }

    @NonNull
    public static <T> Option<T> memory(@NonNull String str) {
        return new Option<>(str, null, f8627e);
    }

    public boolean equals(Object obj) {
        if (obj instanceof Option) {
            return this.f8630c.equals(((Option) obj).f8630c);
        }
        return false;
    }

    @Nullable
    public T getDefaultValue() {
        return (T) this.f8628a;
    }

    public int hashCode() {
        return this.f8630c.hashCode();
    }

    public String toString() {
        return AbstractC1726qj.m7061q(new StringBuilder("Option{key='"), this.f8630c, "'}");
    }

    public void update(@NonNull T t, @NonNull MessageDigest messageDigest) {
        CacheKeyUpdater cacheKeyUpdater = this.f8629b;
        if (this.f8631d == null) {
            this.f8631d = this.f8630c.getBytes(Key.CHARSET);
        }
        cacheKeyUpdater.update(this.f8631d, t, messageDigest);
    }

    @NonNull
    public static <T> Option<T> disk(@NonNull String str, @Nullable T t, @NonNull CacheKeyUpdater<T> cacheKeyUpdater) {
        return new Option<>(str, t, cacheKeyUpdater);
    }

    @NonNull
    public static <T> Option<T> memory(@NonNull String str, @NonNull T t) {
        return new Option<>(str, t, f8627e);
    }
}
