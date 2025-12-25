package com.bumptech.glide.util.pool;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import java.util.List;

/* loaded from: classes.dex */
public final class FactoryPools {

    /* renamed from: a */
    public static final C0639a f9185a = new Object();

    /* loaded from: classes.dex */
    public interface Factory<T> {
        T create();
    }

    /* loaded from: classes.dex */
    public interface Poolable {
        @NonNull
        StateVerifier getVerifier();
    }

    /* loaded from: classes.dex */
    public interface Resetter<T> {
        void reset(@NonNull T t);
    }

    @NonNull
    public static <T extends Poolable> Pools.Pool<T> simple(int i, @NonNull Factory<T> factory) {
        return new C0642d(new Pools.SimplePool(i), factory, f9185a);
    }

    @NonNull
    public static <T extends Poolable> Pools.Pool<T> threadSafe(int i, @NonNull Factory<T> factory) {
        return new C0642d(new Pools.SynchronizedPool(i), factory, f9185a);
    }

    @NonNull
    public static <T> Pools.Pool<List<T>> threadSafeList() {
        return threadSafeList(20);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.bumptech.glide.util.pool.FactoryPools$Resetter, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.bumptech.glide.util.pool.FactoryPools$Factory, java.lang.Object] */
    @NonNull
    public static <T> Pools.Pool<List<T>> threadSafeList(int i) {
        return new C0642d(new Pools.SynchronizedPool(i), new Object(), new Object());
    }
}
