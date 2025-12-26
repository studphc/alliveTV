package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import p000.AbstractRunnableC1181f3;
import p000.AbstractRunnableC1854u;
import p000.C1131dr;
import p000.C1168er;
import p000.C1954wp;
import p000.RunnableC1104d;
import p000.RunnableC2049z9;
import p000.f21;
import p000.fw0;
import p000.gw0;
import p000.iw0;
import p000.lw0;
import p000.mw0;
import p000.sn1;
import p000.yw2;
import p000.yy2;

@GwtCompatible(emulated = true)
/* loaded from: classes2.dex */
public final class Futures extends yy2 {

    @Beta
    @GwtCompatible
    @CanIgnoreReturnValue
    /* loaded from: classes2.dex */
    public static final class FutureCombiner<V> {

        /* renamed from: a */
        public final boolean f15322a;

        /* renamed from: b */
        public final ImmutableList f15323b;

        public FutureCombiner(ImmutableList immutableList, boolean z) {
            this.f15322a = z;
            this.f15323b = immutableList;
        }

        @CanIgnoreReturnValue
        public <C> ListenableFuture<C> call(Callable<C> callable, Executor executor) {
            AbstractC1022u abstractC1022u = new AbstractC1022u(this.f15323b, this.f15322a, false);
            abstractC1022u.f16955p = new C1131dr((C1168er) abstractC1022u, (Callable) callable, executor);
            abstractC1022u.m4361n();
            return abstractC1022u;
        }

        public <C> ListenableFuture<C> callAsync(AsyncCallable<C> asyncCallable, Executor executor) {
            AbstractC1022u abstractC1022u = new AbstractC1022u(this.f15323b, this.f15322a, false);
            abstractC1022u.f16955p = new C1131dr((C1168er) abstractC1022u, (AsyncCallable) asyncCallable, executor);
            abstractC1022u.m4361n();
            return abstractC1022u;
        }

        public ListenableFuture<?> run(Runnable runnable, Executor executor) {
            return call(new CallableC1027w0(runnable), executor);
        }
    }

    public static <V> void addCallback(ListenableFuture<V> listenableFuture, FutureCallback<? super V> futureCallback, Executor executor) {
        Preconditions.checkNotNull(futureCallback);
        listenableFuture.addListener(new gw0(listenableFuture, futureCallback), executor);
    }

    @SafeVarargs
    @Beta
    public static <V> ListenableFuture<List<V>> allAsList(ListenableFuture<? extends V>... listenableFutureArr) {
        return new C1954wp(ImmutableList.copyOf(listenableFutureArr), true);
    }

    @Beta
    public static <V, X extends Throwable> ListenableFuture<V> catching(ListenableFuture<? extends V> listenableFuture, Class<X> cls, Function<? super X, ? extends V> function, Executor executor) {
        int i = AbstractRunnableC1854u.f27044k;
        AbstractRunnableC1854u abstractRunnableC1854u = new AbstractRunnableC1854u(listenableFuture, cls, function);
        listenableFuture.addListener(abstractRunnableC1854u, MoreExecutors.m4337b(executor, abstractRunnableC1854u));
        return abstractRunnableC1854u;
    }

    @Beta
    public static <V, X extends Throwable> ListenableFuture<V> catchingAsync(ListenableFuture<? extends V> listenableFuture, Class<X> cls, AsyncFunction<? super X, ? extends V> asyncFunction, Executor executor) {
        int i = AbstractRunnableC1854u.f27044k;
        AbstractRunnableC1854u abstractRunnableC1854u = new AbstractRunnableC1854u(listenableFuture, cls, asyncFunction);
        listenableFuture.addListener(abstractRunnableC1854u, MoreExecutors.m4337b(executor, abstractRunnableC1854u));
        return abstractRunnableC1854u;
    }

    @CanIgnoreReturnValue
    @Beta
    @GwtIncompatible
    public static <V, X extends Exception> V getChecked(Future<V> future, Class<X> cls) {
        Ordering ordering = mw0.f23142a;
        lw0.f22685a.m5796a(cls);
        try {
            return future.get();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw mw0.m6260a(e, cls);
        } catch (ExecutionException e2) {
            Throwable cause = e2.getCause();
            if (!(cause instanceof Error)) {
                if (cause instanceof RuntimeException) {
                    throw new UncheckedExecutionException(cause);
                }
                throw mw0.m6260a(cause, cls);
            }
            throw new ExecutionError((Error) cause);
        }
    }

    @CanIgnoreReturnValue
    public static <V> V getDone(Future<V> future) {
        Preconditions.checkState(future.isDone(), "Future was expected to be done: %s", future);
        return (V) Uninterruptibles.getUninterruptibly(future);
    }

    @CanIgnoreReturnValue
    public static <V> V getUnchecked(Future<V> future) {
        Preconditions.checkNotNull(future);
        try {
            return (V) Uninterruptibles.getUninterruptibly(future);
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof Error) {
                throw new ExecutionError((Error) cause);
            }
            throw new UncheckedExecutionException(cause);
        }
    }

    public static <V> ListenableFuture<V> immediateCancelledFuture() {
        C1029x0 c1029x0 = C1029x0.f15442h;
        if (c1029x0 != null) {
            return c1029x0;
        }
        return new C1029x0();
    }

    public static <V> ListenableFuture<V> immediateFailedFuture(Throwable th) {
        Preconditions.checkNotNull(th);
        AbstractFuture abstractFuture = new AbstractFuture();
        abstractFuture.setException(th);
        return abstractFuture;
    }

    public static <V> ListenableFuture<V> immediateFuture(V v) {
        if (v == null) {
            return f21.f17087b;
        }
        return new f21(v);
    }

    public static ListenableFuture<Void> immediateVoidFuture() {
        return f21.f17087b;
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [hw0, java.lang.Object, com.google.common.util.concurrent.AbstractFuture] */
    public static <T> ImmutableList<ListenableFuture<T>> inCompletionOrder(Iterable<? extends ListenableFuture<? extends T>> iterable) {
        Collection copyOf;
        if (iterable instanceof Collection) {
            copyOf = (Collection) iterable;
        } else {
            copyOf = ImmutableList.copyOf(iterable);
        }
        ListenableFuture[] listenableFutureArr = (ListenableFuture[]) copyOf.toArray(new ListenableFuture[0]);
        iw0 iw0Var = new iw0(listenableFutureArr);
        ImmutableList.Builder builderWithExpectedSize = ImmutableList.builderWithExpectedSize(listenableFutureArr.length);
        for (int i = 0; i < listenableFutureArr.length; i++) {
            ?? abstractFuture = new AbstractFuture();
            abstractFuture.f18204h = iw0Var;
            builderWithExpectedSize.add((ImmutableList.Builder) abstractFuture);
        }
        ImmutableList<ListenableFuture<T>> build = builderWithExpectedSize.build();
        for (int i2 = 0; i2 < listenableFutureArr.length; i2++) {
            listenableFutureArr[i2].addListener(new RunnableC2049z9(iw0Var, build, i2, 1), MoreExecutors.directExecutor());
        }
        return build;
    }

    @Beta
    @GwtIncompatible
    public static <I, O> Future<O> lazyTransform(Future<I> future, Function<? super I, ? extends O> function) {
        Preconditions.checkNotNull(future);
        Preconditions.checkNotNull(function);
        return new fw0(future, function);
    }

    public static <V> ListenableFuture<V> nonCancellationPropagating(ListenableFuture<V> listenableFuture) {
        if (listenableFuture.isDone()) {
            return listenableFuture;
        }
        AbstractFuture abstractFuture = new AbstractFuture();
        abstractFuture.f20658h = listenableFuture;
        listenableFuture.addListener(abstractFuture, MoreExecutors.directExecutor());
        return abstractFuture;
    }

    @GwtIncompatible
    public static <O> ListenableFuture<O> scheduleAsync(AsyncCallable<O> asyncCallable, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        yw2 m8329j = yw2.m8329j(asyncCallable);
        m8329j.addListener(new RunnableC1104d(22, scheduledExecutorService.schedule(m8329j, j, timeUnit)), MoreExecutors.directExecutor());
        return m8329j;
    }

    public static <O> ListenableFuture<O> submit(Callable<O> callable, Executor executor) {
        yw2 yw2Var = new yw2(callable);
        executor.execute(yw2Var);
        return yw2Var;
    }

    public static <O> ListenableFuture<O> submitAsync(AsyncCallable<O> asyncCallable, Executor executor) {
        yw2 m8329j = yw2.m8329j(asyncCallable);
        executor.execute(m8329j);
        return m8329j;
    }

    @SafeVarargs
    @Beta
    public static <V> ListenableFuture<List<V>> successfulAsList(ListenableFuture<? extends V>... listenableFutureArr) {
        return new C1954wp(ImmutableList.copyOf(listenableFutureArr), false);
    }

    @Beta
    public static <I, O> ListenableFuture<O> transform(ListenableFuture<I> listenableFuture, Function<? super I, ? extends O> function, Executor executor) {
        int i = AbstractRunnableC1181f3.f17111j;
        Preconditions.checkNotNull(function);
        AbstractRunnableC1181f3 abstractRunnableC1181f3 = new AbstractRunnableC1181f3(listenableFuture, function);
        listenableFuture.addListener(abstractRunnableC1181f3, MoreExecutors.m4337b(executor, abstractRunnableC1181f3));
        return abstractRunnableC1181f3;
    }

    @Beta
    public static <I, O> ListenableFuture<O> transformAsync(ListenableFuture<I> listenableFuture, AsyncFunction<? super I, ? extends O> asyncFunction, Executor executor) {
        int i = AbstractRunnableC1181f3.f17111j;
        Preconditions.checkNotNull(executor);
        AbstractRunnableC1181f3 abstractRunnableC1181f3 = new AbstractRunnableC1181f3(listenableFuture, asyncFunction);
        listenableFuture.addListener(abstractRunnableC1181f3, MoreExecutors.m4337b(executor, abstractRunnableC1181f3));
        return abstractRunnableC1181f3;
    }

    @SafeVarargs
    @Beta
    public static <V> FutureCombiner<V> whenAllComplete(ListenableFuture<? extends V>... listenableFutureArr) {
        return new FutureCombiner<>(ImmutableList.copyOf(listenableFutureArr), false);
    }

    @SafeVarargs
    @Beta
    public static <V> FutureCombiner<V> whenAllSucceed(ListenableFuture<? extends V>... listenableFutureArr) {
        return new FutureCombiner<>(ImmutableList.copyOf(listenableFutureArr), true);
    }

    @Beta
    @GwtIncompatible
    public static <V> ListenableFuture<V> withTimeout(ListenableFuture<V> listenableFuture, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        if (listenableFuture.isDone()) {
            return listenableFuture;
        }
        AbstractFuture abstractFuture = new AbstractFuture();
        abstractFuture.f28329h = (ListenableFuture) Preconditions.checkNotNull(listenableFuture);
        sn1 sn1Var = new sn1();
        sn1Var.f26503b = abstractFuture;
        abstractFuture.f28330i = scheduledExecutorService.schedule(sn1Var, j, timeUnit);
        listenableFuture.addListener(sn1Var, MoreExecutors.directExecutor());
        return abstractFuture;
    }

    @Beta
    public static <V> ListenableFuture<List<V>> successfulAsList(Iterable<? extends ListenableFuture<? extends V>> iterable) {
        return new C1954wp(ImmutableList.copyOf(iterable), false);
    }

    @Beta
    public static <V> FutureCombiner<V> whenAllComplete(Iterable<? extends ListenableFuture<? extends V>> iterable) {
        return new FutureCombiner<>(ImmutableList.copyOf(iterable), false);
    }

    @Beta
    public static <V> FutureCombiner<V> whenAllSucceed(Iterable<? extends ListenableFuture<? extends V>> iterable) {
        return new FutureCombiner<>(ImmutableList.copyOf(iterable), true);
    }

    @Beta
    public static <V> ListenableFuture<List<V>> allAsList(Iterable<? extends ListenableFuture<? extends V>> iterable) {
        return new C1954wp(ImmutableList.copyOf(iterable), true);
    }

    public static ListenableFuture<Void> submit(Runnable runnable, Executor executor) {
        yw2 yw2Var = new yw2(Executors.callable(runnable, null));
        executor.execute(yw2Var);
        return yw2Var;
    }

    @CanIgnoreReturnValue
    @Beta
    @GwtIncompatible
    public static <V, X extends Exception> V getChecked(Future<V> future, Class<X> cls, long j, TimeUnit timeUnit) {
        Ordering ordering = mw0.f23142a;
        lw0.f22685a.m5796a(cls);
        try {
            return future.get(j, timeUnit);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw mw0.m6260a(e, cls);
        } catch (ExecutionException e2) {
            Throwable cause = e2.getCause();
            if (!(cause instanceof Error)) {
                if (cause instanceof RuntimeException) {
                    throw new UncheckedExecutionException(cause);
                }
                throw mw0.m6260a(cause, cls);
            }
            throw new ExecutionError((Error) cause);
        } catch (TimeoutException e3) {
            throw mw0.m6260a(e3, cls);
        }
    }
}
