package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.DoNotMock;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import p000.bt0;

@DoNotMock("Use FluentFuture.from(Futures.immediate*Future) or SettableFuture")
@GwtCompatible(emulated = true)
/* loaded from: classes2.dex */
public abstract class FluentFuture<V> extends AbstractFuture {
    public static <V> FluentFuture<V> from(ListenableFuture<V> listenableFuture) {
        if (listenableFuture instanceof FluentFuture) {
            return (FluentFuture) listenableFuture;
        }
        return new bt0(listenableFuture);
    }

    public final void addCallback(FutureCallback<? super V> futureCallback, Executor executor) {
        Futures.addCallback(this, futureCallback, executor);
    }

    @Beta
    public final <X extends Throwable> FluentFuture<V> catching(Class<X> cls, Function<? super X, ? extends V> function, Executor executor) {
        return (FluentFuture) Futures.catching(this, cls, function, executor);
    }

    @Beta
    public final <X extends Throwable> FluentFuture<V> catchingAsync(Class<X> cls, AsyncFunction<? super X, ? extends V> asyncFunction, Executor executor) {
        return (FluentFuture) Futures.catchingAsync(this, cls, asyncFunction, executor);
    }

    @Beta
    public final <T> FluentFuture<T> transform(Function<? super V, T> function, Executor executor) {
        return (FluentFuture) Futures.transform(this, function, executor);
    }

    @Beta
    public final <T> FluentFuture<T> transformAsync(AsyncFunction<? super V, T> asyncFunction, Executor executor) {
        return (FluentFuture) Futures.transformAsync(this, asyncFunction, executor);
    }

    @Beta
    @GwtIncompatible
    public final FluentFuture<V> withTimeout(long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return (FluentFuture) Futures.withTimeout(this, j, timeUnit, scheduledExecutorService);
    }

    @Deprecated
    public static <V> FluentFuture<V> from(FluentFuture<V> fluentFuture) {
        return (FluentFuture) Preconditions.checkNotNull(fluentFuture);
    }
}
