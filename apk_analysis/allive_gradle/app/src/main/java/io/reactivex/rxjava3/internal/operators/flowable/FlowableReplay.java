package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.flowables.ConnectableFlowable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamPublisher;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import p000.fp0;
import p000.hp0;
import p000.jp0;
import p000.kp0;
import p000.lp0;
import p000.mp0;
import p000.np0;

/* loaded from: classes2.dex */
public final class FlowableReplay<T> extends ConnectableFlowable<T> implements HasUpstreamPublisher<T> {

    /* renamed from: f */
    public static final fp0 f18985f = new fp0(0);

    /* renamed from: b */
    public final Flowable f18986b;

    /* renamed from: c */
    public final AtomicReference f18987c;

    /* renamed from: d */
    public final Supplier f18988d;

    /* renamed from: e */
    public final lp0 f18989e;

    public FlowableReplay(lp0 lp0Var, Flowable flowable, AtomicReference atomicReference, Supplier supplier) {
        this.f18989e = lp0Var;
        this.f18986b = flowable;
        this.f18987c = atomicReference;
        this.f18988d = supplier;
    }

    public static <T> ConnectableFlowable<T> create(Flowable<T> flowable, int i, boolean z) {
        if (i == Integer.MAX_VALUE) {
            return createFrom(flowable);
        }
        return m5279e(flowable, new kp0(i, z));
    }

    public static <T> ConnectableFlowable<T> createFrom(Flowable<? extends T> flowable) {
        return m5279e(flowable, f18985f);
    }

    /* renamed from: e */
    public static ConnectableFlowable m5279e(Flowable flowable, Supplier supplier) {
        AtomicReference atomicReference = new AtomicReference();
        return RxJavaPlugins.onAssembly((ConnectableFlowable) new FlowableReplay(new lp0(atomicReference, supplier), flowable, atomicReference, supplier));
    }

    public static <U, R> Flowable<R> multicastSelector(Supplier<? extends ConnectableFlowable<U>> supplier, Function<? super Flowable<U>, ? extends Publisher<R>> function) {
        return new hp0(supplier, function, 0);
    }

    @Override // io.reactivex.rxjava3.flowables.ConnectableFlowable
    public void connect(Consumer<? super Disposable> consumer) {
        mp0 mp0Var;
        boolean z;
        loop0: while (true) {
            AtomicReference atomicReference = this.f18987c;
            mp0Var = (mp0) atomicReference.get();
            if (mp0Var != null && !mp0Var.isDisposed()) {
                break;
            }
            try {
                mp0 mp0Var2 = new mp0((jp0) this.f18988d.get(), atomicReference);
                while (!atomicReference.compareAndSet(mp0Var, mp0Var2)) {
                    if (atomicReference.get() != mp0Var) {
                        break;
                    }
                }
                mp0Var = mp0Var2;
                break loop0;
            } finally {
                Exceptions.throwIfFatal(th);
                RuntimeException wrapOrThrow = ExceptionHelper.wrapOrThrow(th);
            }
        }
        AtomicBoolean atomicBoolean = mp0Var.f23041d;
        if (!atomicBoolean.get() && atomicBoolean.compareAndSet(false, true)) {
            z = true;
        } else {
            z = false;
        }
        try {
            consumer.accept(mp0Var);
            if (z) {
                this.f18986b.subscribe((FlowableSubscriber) mp0Var);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            if (z) {
                atomicBoolean.compareAndSet(true, false);
            }
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    @Override // io.reactivex.rxjava3.flowables.ConnectableFlowable
    public void reset() {
        AtomicReference atomicReference = this.f18987c;
        mp0 mp0Var = (mp0) atomicReference.get();
        if (mp0Var == null || !mp0Var.isDisposed()) {
            return;
        }
        while (!atomicReference.compareAndSet(mp0Var, null) && atomicReference.get() == mp0Var) {
        }
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.HasUpstreamPublisher
    public Publisher<T> source() {
        return this.f18986b;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f18989e.subscribe(subscriber);
    }

    public static <T> ConnectableFlowable<T> create(Flowable<T> flowable, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        return create(flowable, j, timeUnit, scheduler, Integer.MAX_VALUE, z);
    }

    public static <T> ConnectableFlowable<T> create(Flowable<T> flowable, long j, TimeUnit timeUnit, Scheduler scheduler, int i, boolean z) {
        return m5279e(flowable, new np0(i, j, timeUnit, scheduler, z));
    }
}
