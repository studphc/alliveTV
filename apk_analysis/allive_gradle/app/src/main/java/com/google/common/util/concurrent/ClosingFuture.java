package com.google.common.util.concurrent;

import com.google.common.base.Functions;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Futures;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotMock;
import java.io.Closeable;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;
import p000.EnumC1917vp;
import p000.RunnableC1104d;
import p000.yw2;

@DoNotMock("Use ClosingFuture.from(Futures.immediate*Future)")
/* loaded from: classes2.dex */
public final class ClosingFuture<V> {

    /* renamed from: d */
    public static final Logger f15283d = Logger.getLogger(ClosingFuture.class.getName());

    /* renamed from: a */
    public final AtomicReference f15284a = new AtomicReference(EnumC1917vp.f27904a);

    /* renamed from: b */
    public final C0992f0 f15285b = new C0992f0();

    /* renamed from: c */
    public final FluentFuture f15286c;

    /* loaded from: classes2.dex */
    public interface AsyncClosingCallable<V> {
        ClosingFuture<V> call(DeferredCloser deferredCloser);
    }

    /* loaded from: classes2.dex */
    public interface AsyncClosingFunction<T, U> {
        ClosingFuture<U> apply(DeferredCloser deferredCloser, T t);
    }

    /* loaded from: classes2.dex */
    public interface ClosingCallable<V> {
        V call(DeferredCloser deferredCloser);
    }

    /* loaded from: classes2.dex */
    public interface ClosingFunction<T, U> {
        U apply(DeferredCloser deferredCloser, T t);
    }

    @DoNotMock("Use ClosingFuture.whenAllSucceed() or .whenAllComplete() instead.")
    /* loaded from: classes2.dex */
    public static class Combiner {

        /* renamed from: c */
        public static final C0999i0 f15287c = new Object();

        /* renamed from: a */
        public final C0992f0 f15288a = new C0992f0();

        /* renamed from: b */
        public final boolean f15289b;
        protected final ImmutableList<ClosingFuture<?>> inputs;

        /* loaded from: classes2.dex */
        public interface AsyncCombiningCallable<V> {
            ClosingFuture<V> call(DeferredCloser deferredCloser, Peeker peeker);
        }

        /* loaded from: classes2.dex */
        public interface CombiningCallable<V> {
            V call(DeferredCloser deferredCloser, Peeker peeker);
        }

        public Combiner(Iterable iterable, boolean z) {
            this.f15289b = z;
            this.inputs = ImmutableList.copyOf(iterable);
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                ClosingFuture closingFuture = (ClosingFuture) it.next();
                C0992f0 c0992f0 = this.f15288a;
                Logger logger = ClosingFuture.f15283d;
                closingFuture.m4321a(c0992f0);
            }
        }

        public <V> ClosingFuture<V> call(CombiningCallable<V> combiningCallable, Executor executor) {
            Futures.FutureCombiner whenAllComplete;
            CallableC0995g0 callableC0995g0 = new CallableC0995g0(this, combiningCallable);
            C0999i0 c0999i0 = f15287c;
            if (this.f15289b) {
                whenAllComplete = Futures.whenAllSucceed(FluentIterable.from(this.inputs).transform(c0999i0).toList());
            } else {
                whenAllComplete = Futures.whenAllComplete(FluentIterable.from(this.inputs).transform(c0999i0).toList());
            }
            ClosingFuture<V> closingFuture = new ClosingFuture<>(whenAllComplete.call(callableC0995g0, executor));
            closingFuture.f15285b.m4348a(this.f15288a, MoreExecutors.directExecutor());
            return closingFuture;
        }

        public <V> ClosingFuture<V> callAsync(AsyncCombiningCallable<V> asyncCombiningCallable, Executor executor) {
            Futures.FutureCombiner whenAllComplete;
            C0997h0 c0997h0 = new C0997h0(this, asyncCombiningCallable);
            C0999i0 c0999i0 = f15287c;
            if (this.f15289b) {
                whenAllComplete = Futures.whenAllSucceed(FluentIterable.from(this.inputs).transform(c0999i0).toList());
            } else {
                whenAllComplete = Futures.whenAllComplete(FluentIterable.from(this.inputs).transform(c0999i0).toList());
            }
            ClosingFuture<V> closingFuture = new ClosingFuture<>(whenAllComplete.callAsync(c0997h0, executor));
            closingFuture.f15285b.m4348a(this.f15288a, MoreExecutors.directExecutor());
            return closingFuture;
        }
    }

    /* loaded from: classes2.dex */
    public static final class Combiner2<V1, V2> extends Combiner {

        /* renamed from: d */
        public final ClosingFuture f15290d;

        /* renamed from: e */
        public final ClosingFuture f15291e;

        /* loaded from: classes2.dex */
        public interface AsyncClosingFunction2<V1, V2, U> {
            ClosingFuture<U> apply(DeferredCloser deferredCloser, V1 v1, V2 v2);
        }

        /* loaded from: classes2.dex */
        public interface ClosingFunction2<V1, V2, U> {
            U apply(DeferredCloser deferredCloser, V1 v1, V2 v2);
        }

        public Combiner2(ClosingFuture closingFuture, ClosingFuture closingFuture2) {
            super(ImmutableList.m3904of(closingFuture, closingFuture2), true);
            this.f15290d = closingFuture;
            this.f15291e = closingFuture2;
        }

        public <U> ClosingFuture<U> call(ClosingFunction2<V1, V2, U> closingFunction2, Executor executor) {
            return call(new C1001j0(this, closingFunction2), executor);
        }

        public <U> ClosingFuture<U> callAsync(AsyncClosingFunction2<V1, V2, U> asyncClosingFunction2, Executor executor) {
            return callAsync(new C1003k0(this, asyncClosingFunction2), executor);
        }
    }

    /* loaded from: classes2.dex */
    public static final class Combiner3<V1, V2, V3> extends Combiner {

        /* renamed from: d */
        public final ClosingFuture f15292d;

        /* renamed from: e */
        public final ClosingFuture f15293e;

        /* renamed from: f */
        public final ClosingFuture f15294f;

        /* loaded from: classes2.dex */
        public interface AsyncClosingFunction3<V1, V2, V3, U> {
            ClosingFuture<U> apply(DeferredCloser deferredCloser, V1 v1, V2 v2, V3 v3);
        }

        /* loaded from: classes2.dex */
        public interface ClosingFunction3<V1, V2, V3, U> {
            U apply(DeferredCloser deferredCloser, V1 v1, V2 v2, V3 v3);
        }

        public Combiner3(ClosingFuture closingFuture, ClosingFuture closingFuture2, ClosingFuture closingFuture3) {
            super(ImmutableList.m3905of(closingFuture, closingFuture2, closingFuture3), true);
            this.f15292d = closingFuture;
            this.f15293e = closingFuture2;
            this.f15294f = closingFuture3;
        }

        public <U> ClosingFuture<U> call(ClosingFunction3<V1, V2, V3, U> closingFunction3, Executor executor) {
            return call(new C1005l0(this, closingFunction3), executor);
        }

        public <U> ClosingFuture<U> callAsync(AsyncClosingFunction3<V1, V2, V3, U> asyncClosingFunction3, Executor executor) {
            return callAsync(new C1007m0(this, asyncClosingFunction3), executor);
        }
    }

    /* loaded from: classes2.dex */
    public static final class Combiner4<V1, V2, V3, V4> extends Combiner {

        /* renamed from: d */
        public final ClosingFuture f15295d;

        /* renamed from: e */
        public final ClosingFuture f15296e;

        /* renamed from: f */
        public final ClosingFuture f15297f;

        /* renamed from: g */
        public final ClosingFuture f15298g;

        /* loaded from: classes2.dex */
        public interface AsyncClosingFunction4<V1, V2, V3, V4, U> {
            ClosingFuture<U> apply(DeferredCloser deferredCloser, V1 v1, V2 v2, V3 v3, V4 v4);
        }

        /* loaded from: classes2.dex */
        public interface ClosingFunction4<V1, V2, V3, V4, U> {
            U apply(DeferredCloser deferredCloser, V1 v1, V2 v2, V3 v3, V4 v4);
        }

        public Combiner4(ClosingFuture closingFuture, ClosingFuture closingFuture2, ClosingFuture closingFuture3, ClosingFuture closingFuture4) {
            super(ImmutableList.m3906of(closingFuture, closingFuture2, closingFuture3, closingFuture4), true);
            this.f15295d = closingFuture;
            this.f15296e = closingFuture2;
            this.f15297f = closingFuture3;
            this.f15298g = closingFuture4;
        }

        public <U> ClosingFuture<U> call(ClosingFunction4<V1, V2, V3, V4, U> closingFunction4, Executor executor) {
            return call(new C1009n0(this, closingFunction4), executor);
        }

        public <U> ClosingFuture<U> callAsync(AsyncClosingFunction4<V1, V2, V3, V4, U> asyncClosingFunction4, Executor executor) {
            return callAsync(new C1011o0(this, asyncClosingFunction4), executor);
        }
    }

    /* loaded from: classes2.dex */
    public static final class Combiner5<V1, V2, V3, V4, V5> extends Combiner {

        /* renamed from: d */
        public final ClosingFuture f15299d;

        /* renamed from: e */
        public final ClosingFuture f15300e;

        /* renamed from: f */
        public final ClosingFuture f15301f;

        /* renamed from: g */
        public final ClosingFuture f15302g;

        /* renamed from: h */
        public final ClosingFuture f15303h;

        /* loaded from: classes2.dex */
        public interface AsyncClosingFunction5<V1, V2, V3, V4, V5, U> {
            ClosingFuture<U> apply(DeferredCloser deferredCloser, V1 v1, V2 v2, V3 v3, V4 v4, V5 v5);
        }

        /* loaded from: classes2.dex */
        public interface ClosingFunction5<V1, V2, V3, V4, V5, U> {
            U apply(DeferredCloser deferredCloser, V1 v1, V2 v2, V3 v3, V4 v4, V5 v5);
        }

        public Combiner5(ClosingFuture closingFuture, ClosingFuture closingFuture2, ClosingFuture closingFuture3, ClosingFuture closingFuture4, ClosingFuture closingFuture5) {
            super(ImmutableList.m3907of(closingFuture, closingFuture2, closingFuture3, closingFuture4, closingFuture5), true);
            this.f15299d = closingFuture;
            this.f15300e = closingFuture2;
            this.f15301f = closingFuture3;
            this.f15302g = closingFuture4;
            this.f15303h = closingFuture5;
        }

        public <U> ClosingFuture<U> call(ClosingFunction5<V1, V2, V3, V4, V5, U> closingFunction5, Executor executor) {
            return call(new C1013p0(this, closingFunction5), executor);
        }

        public <U> ClosingFuture<U> callAsync(AsyncClosingFunction5<V1, V2, V3, V4, V5, U> asyncClosingFunction5, Executor executor) {
            return callAsync(new C1015q0(this, asyncClosingFunction5), executor);
        }
    }

    /* loaded from: classes2.dex */
    public static final class DeferredCloser {

        /* renamed from: a */
        public final C0992f0 f15304a;

        public DeferredCloser(C0992f0 c0992f0) {
            this.f15304a = c0992f0;
        }

        @CanIgnoreReturnValue
        public <C extends Closeable> C eventuallyClose(C c, Executor executor) {
            Preconditions.checkNotNull(executor);
            if (c != null) {
                this.f15304a.m4348a(c, executor);
            }
            return c;
        }
    }

    /* loaded from: classes2.dex */
    public static final class Peeker {

        /* renamed from: a */
        public final ImmutableList f15305a;

        /* renamed from: b */
        public volatile boolean f15306b;

        public Peeker(ImmutableList immutableList) {
            this.f15305a = (ImmutableList) Preconditions.checkNotNull(immutableList);
        }

        public final <D> D getDone(ClosingFuture<D> closingFuture) {
            Preconditions.checkState(this.f15306b);
            Preconditions.checkArgument(this.f15305a.contains(closingFuture));
            return (D) Futures.getDone(closingFuture.f15286c);
        }
    }

    /* loaded from: classes2.dex */
    public static final class ValueAndCloser<V> {

        /* renamed from: a */
        public final ClosingFuture f15307a;

        public ValueAndCloser(ClosingFuture closingFuture) {
            this.f15307a = (ClosingFuture) Preconditions.checkNotNull(closingFuture);
        }

        public void closeAsync() {
            Logger logger = ClosingFuture.f15283d;
            this.f15307a.m4322b();
        }

        public V get() {
            return (V) Futures.getDone(this.f15307a.f15286c);
        }
    }

    /* loaded from: classes2.dex */
    public interface ValueAndCloserConsumer<V> {
        void accept(ValueAndCloser<V> valueAndCloser);
    }

    public ClosingFuture(ListenableFuture listenableFuture) {
        this.f15286c = FluentFuture.from(listenableFuture);
    }

    /* renamed from: c */
    public static void m4320c(Closeable closeable, Executor executor) {
        if (closeable == null) {
            return;
        }
        try {
            executor.execute(new RunnableC1104d(8, closeable));
        } catch (RejectedExecutionException e) {
            Level level = Level.WARNING;
            Logger logger = f15283d;
            if (logger.isLoggable(level)) {
                logger.log(level, String.format("while submitting close to %s; will close inline", executor), (Throwable) e);
            }
            m4320c(closeable, MoreExecutors.directExecutor());
        }
    }

    @Deprecated
    public static <C extends Closeable> ClosingFuture<C> eventuallyClosing(ListenableFuture<C> listenableFuture, Executor executor) {
        Preconditions.checkNotNull(executor);
        ClosingFuture<C> closingFuture = new ClosingFuture<>(Futures.nonCancellationPropagating(listenableFuture));
        Futures.addCallback(listenableFuture, new C1028x(closingFuture, executor), MoreExecutors.directExecutor());
        return closingFuture;
    }

    public static <V> ClosingFuture<V> from(ListenableFuture<V> listenableFuture) {
        return new ClosingFuture<>(listenableFuture);
    }

    public static <V> ClosingFuture<V> submit(ClosingCallable<V> closingCallable, Executor executor) {
        return new ClosingFuture<>(closingCallable, executor);
    }

    public static <V> ClosingFuture<V> submitAsync(AsyncClosingCallable<V> asyncClosingCallable, Executor executor) {
        return new ClosingFuture<>(asyncClosingCallable, executor);
    }

    public static Combiner whenAllComplete(Iterable<? extends ClosingFuture<?>> iterable) {
        return new Combiner(iterable, false);
    }

    public static Combiner whenAllSucceed(Iterable<? extends ClosingFuture<?>> iterable) {
        return new Combiner(iterable, true);
    }

    public static <V, U> AsyncClosingFunction<V, U> withoutCloser(AsyncFunction<V, U> asyncFunction) {
        Preconditions.checkNotNull(asyncFunction);
        return new C0983c0(asyncFunction);
    }

    /* renamed from: a */
    public final void m4321a(C0992f0 c0992f0) {
        EnumC1917vp enumC1917vp = EnumC1917vp.f27904a;
        EnumC1917vp enumC1917vp2 = EnumC1917vp.f27905b;
        Preconditions.checkState(m4323d(enumC1917vp, enumC1917vp2), "Expected state to be %s, but it was %s", enumC1917vp, enumC1917vp2);
        c0992f0.m4348a(this.f15285b, MoreExecutors.directExecutor());
    }

    /* renamed from: b */
    public final void m4322b() {
        f15283d.log(Level.FINER, "closing {0}", this);
        this.f15285b.close();
    }

    @CanIgnoreReturnValue
    public boolean cancel(boolean z) {
        f15283d.log(Level.FINER, "cancelling {0}", this);
        boolean cancel = this.f15286c.cancel(z);
        if (cancel) {
            m4322b();
        }
        return cancel;
    }

    public <X extends Throwable> ClosingFuture<V> catching(Class<X> cls, ClosingFunction<? super X, ? extends V> closingFunction, Executor executor) {
        Preconditions.checkNotNull(closingFunction);
        ClosingFuture<V> closingFuture = new ClosingFuture<>(this.f15286c.catchingAsync(cls, new C0986d0(this, closingFunction), executor));
        m4321a(closingFuture.f15285b);
        return closingFuture;
    }

    public <X extends Throwable> ClosingFuture<V> catchingAsync(Class<X> cls, AsyncClosingFunction<? super X, ? extends V> asyncClosingFunction, Executor executor) {
        Preconditions.checkNotNull(asyncClosingFunction);
        ClosingFuture<V> closingFuture = new ClosingFuture<>(this.f15286c.catchingAsync(cls, new C0989e0(this, asyncClosingFunction), executor));
        m4321a(closingFuture.f15285b);
        return closingFuture;
    }

    /* renamed from: d */
    public final boolean m4323d(EnumC1917vp enumC1917vp, EnumC1917vp enumC1917vp2) {
        AtomicReference atomicReference;
        do {
            atomicReference = this.f15284a;
            if (atomicReference.compareAndSet(enumC1917vp, enumC1917vp2)) {
                return true;
            }
        } while (atomicReference.get() == enumC1917vp);
        return false;
    }

    public void finalize() {
        if (((EnumC1917vp) this.f15284a.get()).equals(EnumC1917vp.f27904a)) {
            f15283d.log(Level.SEVERE, "Uh oh! An open ClosingFuture has leaked and will close: {0}", this);
            finishToFuture();
        }
    }

    public FluentFuture<V> finishToFuture() {
        boolean m4323d = m4323d(EnumC1917vp.f27904a, EnumC1917vp.f27906c);
        FluentFuture<V> fluentFuture = this.f15286c;
        if (m4323d) {
            f15283d.log(Level.FINER, "will close {0}", this);
            fluentFuture.addListener(new RunnableC1104d(9, this), MoreExecutors.directExecutor());
        } else {
            int ordinal = ((EnumC1917vp) this.f15284a.get()).ordinal();
            if (ordinal != 0) {
                if (ordinal != 1) {
                    if (ordinal != 2 && ordinal != 3 && ordinal != 4) {
                        if (ordinal == 5) {
                            throw new IllegalStateException("Cannot call finishToFuture() after calling finishToValueAndCloser()");
                        }
                    } else {
                        throw new IllegalStateException("Cannot call finishToFuture() twice");
                    }
                } else {
                    throw new IllegalStateException("Cannot call finishToFuture() after deriving another step");
                }
            } else {
                throw new AssertionError();
            }
        }
        return fluentFuture;
    }

    public void finishToValueAndCloser(ValueAndCloserConsumer<? super V> valueAndCloserConsumer, Executor executor) {
        Preconditions.checkNotNull(valueAndCloserConsumer);
        if (!m4323d(EnumC1917vp.f27904a, EnumC1917vp.f27909f)) {
            AtomicReference atomicReference = this.f15284a;
            int ordinal = ((EnumC1917vp) atomicReference.get()).ordinal();
            if (ordinal != 1) {
                if (ordinal != 2 && ordinal != 3 && ordinal != 4) {
                    if (ordinal != 5) {
                        throw new AssertionError(atomicReference);
                    }
                    throw new IllegalStateException("Cannot call finishToValueAndCloser() twice");
                }
                throw new IllegalStateException("Cannot call finishToValueAndCloser() after calling finishToFuture()");
            }
            throw new IllegalStateException("Cannot call finishToValueAndCloser() after deriving another step");
        }
        this.f15286c.addListener(new RunnableC1026w(this, valueAndCloserConsumer), executor);
    }

    public ListenableFuture<?> statusFuture() {
        return Futures.nonCancellationPropagating(this.f15286c.transform(Functions.constant(null), MoreExecutors.directExecutor()));
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("state", this.f15284a.get()).addValue(this.f15286c).toString();
    }

    public <U> ClosingFuture<U> transform(ClosingFunction<? super V, U> closingFunction, Executor executor) {
        Preconditions.checkNotNull(closingFunction);
        ClosingFuture<U> closingFuture = new ClosingFuture<>(this.f15286c.transformAsync(new C0977a0(this, closingFunction), executor));
        m4321a(closingFuture.f15285b);
        return closingFuture;
    }

    public <U> ClosingFuture<U> transformAsync(AsyncClosingFunction<? super V, U> asyncClosingFunction, Executor executor) {
        Preconditions.checkNotNull(asyncClosingFunction);
        ClosingFuture<U> closingFuture = new ClosingFuture<>(this.f15286c.transformAsync(new C0980b0(this, asyncClosingFunction), executor));
        m4321a(closingFuture.f15285b);
        return closingFuture;
    }

    public static Combiner whenAllComplete(ClosingFuture<?> closingFuture, ClosingFuture<?>... closingFutureArr) {
        return whenAllComplete(Lists.asList(closingFuture, closingFutureArr));
    }

    public static <V1, V2> Combiner2<V1, V2> whenAllSucceed(ClosingFuture<V1> closingFuture, ClosingFuture<V2> closingFuture2) {
        return new Combiner2<>(closingFuture, closingFuture2);
    }

    public static <V1, V2, V3> Combiner3<V1, V2, V3> whenAllSucceed(ClosingFuture<V1> closingFuture, ClosingFuture<V2> closingFuture2, ClosingFuture<V3> closingFuture3) {
        return new Combiner3<>(closingFuture, closingFuture2, closingFuture3);
    }

    public static <V1, V2, V3, V4> Combiner4<V1, V2, V3, V4> whenAllSucceed(ClosingFuture<V1> closingFuture, ClosingFuture<V2> closingFuture2, ClosingFuture<V3> closingFuture3, ClosingFuture<V4> closingFuture4) {
        return new Combiner4<>(closingFuture, closingFuture2, closingFuture3, closingFuture4);
    }

    public static <V1, V2, V3, V4, V5> Combiner5<V1, V2, V3, V4, V5> whenAllSucceed(ClosingFuture<V1> closingFuture, ClosingFuture<V2> closingFuture2, ClosingFuture<V3> closingFuture3, ClosingFuture<V4> closingFuture4, ClosingFuture<V5> closingFuture5) {
        return new Combiner5<>(closingFuture, closingFuture2, closingFuture3, closingFuture4, closingFuture5);
    }

    public static Combiner whenAllSucceed(ClosingFuture<?> closingFuture, ClosingFuture<?> closingFuture2, ClosingFuture<?> closingFuture3, ClosingFuture<?> closingFuture4, ClosingFuture<?> closingFuture5, ClosingFuture<?> closingFuture6, ClosingFuture<?>... closingFutureArr) {
        return whenAllSucceed(FluentIterable.m3857of(closingFuture, closingFuture2, closingFuture3, closingFuture4, closingFuture5, closingFuture6).append(closingFutureArr));
    }

    public ClosingFuture(ClosingCallable closingCallable, Executor executor) {
        Preconditions.checkNotNull(closingCallable);
        yw2 yw2Var = new yw2(new CallableC1030y(this, closingCallable));
        executor.execute(yw2Var);
        this.f15286c = yw2Var;
    }

    public ClosingFuture(AsyncClosingCallable asyncClosingCallable, Executor executor) {
        Preconditions.checkNotNull(asyncClosingCallable);
        yw2 m8329j = yw2.m8329j(new C1032z(this, asyncClosingCallable));
        executor.execute(m8329j);
        this.f15286c = m8329j;
    }
}
