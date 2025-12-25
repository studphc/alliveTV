package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamObservableSource;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.observables.ConnectableObservable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p000.sx1;
import p000.ux1;
import p000.wd0;
import p000.xx1;
import p000.yx1;
import p000.zx1;

/* loaded from: classes2.dex */
public final class ObservableReplay<T> extends ConnectableObservable<T> implements HasUpstreamObservableSource<T> {

    /* renamed from: e */
    public static final wd0 f19528e = new wd0(22);

    /* renamed from: a */
    public final ObservableSource f19529a;

    /* renamed from: b */
    public final AtomicReference f19530b;

    /* renamed from: c */
    public final sx1 f19531c;

    /* renamed from: d */
    public final zx1 f19532d;

    public ObservableReplay(zx1 zx1Var, ObservableSource observableSource, AtomicReference atomicReference, sx1 sx1Var) {
        this.f19532d = zx1Var;
        this.f19529a = observableSource;
        this.f19530b = atomicReference;
        this.f19531c = sx1Var;
    }

    public static <T> ConnectableObservable<T> create(ObservableSource<T> observableSource, int i, boolean z) {
        if (i == Integer.MAX_VALUE) {
            return createFrom(observableSource);
        }
        return m5294d(observableSource, new xx1(i, z));
    }

    public static <T> ConnectableObservable<T> createFrom(ObservableSource<? extends T> observableSource) {
        return m5294d(observableSource, f19528e);
    }

    /* renamed from: d */
    public static ConnectableObservable m5294d(ObservableSource observableSource, sx1 sx1Var) {
        AtomicReference atomicReference = new AtomicReference();
        return RxJavaPlugins.onAssembly((ConnectableObservable) new ObservableReplay(new zx1(atomicReference, sx1Var), observableSource, atomicReference, sx1Var));
    }

    public static <U, R> Observable<R> multicastSelector(Supplier<? extends ConnectableObservable<U>> supplier, Function<? super Observable<U>, ? extends ObservableSource<R>> function) {
        return RxJavaPlugins.onAssembly(new ux1(supplier, function));
    }

    @Override // io.reactivex.rxjava3.observables.ConnectableObservable
    public void connect(Consumer<? super Disposable> consumer) {
        yx1 yx1Var;
        boolean z;
        loop0: while (true) {
            AtomicReference atomicReference = this.f19530b;
            yx1Var = (yx1) atomicReference.get();
            if (yx1Var != null && !yx1Var.isDisposed()) {
                break;
            }
            yx1 yx1Var2 = new yx1(this.f19531c.call(), atomicReference);
            while (!atomicReference.compareAndSet(yx1Var, yx1Var2)) {
                if (atomicReference.get() != yx1Var) {
                    break;
                }
            }
            yx1Var = yx1Var2;
            break loop0;
        }
        AtomicBoolean atomicBoolean = yx1Var.f29166d;
        if (!atomicBoolean.get() && atomicBoolean.compareAndSet(false, true)) {
            z = true;
        } else {
            z = false;
        }
        try {
            consumer.accept(yx1Var);
            if (z) {
                this.f19529a.subscribe(yx1Var);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            if (z) {
                atomicBoolean.compareAndSet(true, false);
            }
            Exceptions.throwIfFatal(th);
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    @Override // io.reactivex.rxjava3.observables.ConnectableObservable
    public void reset() {
        AtomicReference atomicReference = this.f19530b;
        yx1 yx1Var = (yx1) atomicReference.get();
        if (yx1Var == null || !yx1Var.isDisposed()) {
            return;
        }
        while (!atomicReference.compareAndSet(yx1Var, null) && atomicReference.get() == yx1Var) {
        }
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.HasUpstreamObservableSource
    public ObservableSource<T> source() {
        return this.f19529a;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.f19532d.subscribe(observer);
    }

    public static <T> ConnectableObservable<T> create(ObservableSource<T> observableSource, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        return create(observableSource, j, timeUnit, scheduler, Integer.MAX_VALUE, z);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [ne0, java.lang.Object, sx1] */
    public static <T> ConnectableObservable<T> create(ObservableSource<T> observableSource, long j, TimeUnit timeUnit, Scheduler scheduler, int i, boolean z) {
        ?? obj = new Object();
        obj.f23338a = i;
        obj.f23339b = j;
        obj.f23341d = timeUnit;
        obj.f23342e = scheduler;
        obj.f23340c = z;
        return m5294d(observableSource, obj);
    }
}
