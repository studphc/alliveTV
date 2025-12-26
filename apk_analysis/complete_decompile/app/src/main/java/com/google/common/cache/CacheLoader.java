package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.errorprone.annotations.CheckReturnValue;
import java.util.Map;
import java.util.concurrent.Executor;
import p000.C1235gk;
import p000.C1272hk;
import p000.C1309ik;

@GwtCompatible(emulated = true)
/* loaded from: classes.dex */
public abstract class CacheLoader<K, V> {

    /* loaded from: classes.dex */
    public static final class InvalidCacheLoadException extends RuntimeException {
        public InvalidCacheLoadException(String str) {
            super(str);
        }
    }

    /* loaded from: classes.dex */
    public static final class UnsupportedLoadingOperationException extends UnsupportedOperationException {
    }

    @CheckReturnValue
    @GwtIncompatible
    public static <K, V> CacheLoader<K, V> asyncReloading(CacheLoader<K, V> cacheLoader, Executor executor) {
        Preconditions.checkNotNull(cacheLoader);
        Preconditions.checkNotNull(executor);
        return new C1235gk(cacheLoader, executor);
    }

    @CheckReturnValue
    public static <K, V> CacheLoader<K, V> from(Function<K, V> function) {
        return new C1272hk(function);
    }

    public abstract V load(K k);

    public Map<K, V> loadAll(Iterable<? extends K> iterable) {
        throw new UnsupportedOperationException();
    }

    @GwtIncompatible
    public ListenableFuture<V> reload(K k, V v) {
        Preconditions.checkNotNull(k);
        Preconditions.checkNotNull(v);
        return Futures.immediateFuture(load(k));
    }

    @CheckReturnValue
    public static <V> CacheLoader<Object, V> from(Supplier<V> supplier) {
        return new C1309ik(supplier);
    }
}
