package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import p000.AbstractC1670p0;

@GwtCompatible
/* loaded from: classes2.dex */
public final class SettableFuture<V> extends AbstractC1670p0 {
    public static <V> SettableFuture<V> create() {
        return (SettableFuture<V>) new AbstractFuture();
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    @CanIgnoreReturnValue
    public boolean set(V v) {
        return super.set(v);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    @CanIgnoreReturnValue
    public boolean setException(Throwable th) {
        return super.setException(th);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    @CanIgnoreReturnValue
    public boolean setFuture(ListenableFuture<? extends V> listenableFuture) {
        return super.setFuture(listenableFuture);
    }
}
