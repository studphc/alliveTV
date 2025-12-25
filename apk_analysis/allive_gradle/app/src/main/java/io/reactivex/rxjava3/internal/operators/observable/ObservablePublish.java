package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamObservableSource;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.observables.ConnectableObservable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p000.fx1;
import p000.gx1;

/* loaded from: classes2.dex */
public final class ObservablePublish<T> extends ConnectableObservable<T> implements HasUpstreamObservableSource<T> {

    /* renamed from: a */
    public final ObservableSource f19504a;

    /* renamed from: b */
    public final AtomicReference f19505b = new AtomicReference();

    public ObservablePublish(ObservableSource<T> observableSource) {
        this.f19504a = observableSource;
    }

    @Override // io.reactivex.rxjava3.observables.ConnectableObservable
    public void connect(Consumer<? super Disposable> consumer) {
        gx1 gx1Var;
        loop0: while (true) {
            AtomicReference atomicReference = this.f19505b;
            gx1Var = (gx1) atomicReference.get();
            if (gx1Var != null && !gx1Var.isDisposed()) {
                break;
            }
            gx1 gx1Var2 = new gx1(atomicReference);
            while (!atomicReference.compareAndSet(gx1Var, gx1Var2)) {
                if (atomicReference.get() != gx1Var) {
                    break;
                }
            }
            gx1Var = gx1Var2;
            break loop0;
        }
        AtomicBoolean atomicBoolean = gx1Var.f17858a;
        boolean z = false;
        if (!atomicBoolean.get() && atomicBoolean.compareAndSet(false, true)) {
            z = true;
        }
        try {
            consumer.accept(gx1Var);
            if (z) {
                this.f19504a.subscribe(gx1Var);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    @Override // io.reactivex.rxjava3.observables.ConnectableObservable
    public void reset() {
        AtomicReference atomicReference = this.f19505b;
        gx1 gx1Var = (gx1) atomicReference.get();
        if (gx1Var == null || !gx1Var.isDisposed()) {
            return;
        }
        while (!atomicReference.compareAndSet(gx1Var, null) && atomicReference.get() == gx1Var) {
        }
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.HasUpstreamObservableSource
    public ObservableSource<T> source() {
        return this.f19504a;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        gx1 gx1Var;
        fx1[] fx1VarArr;
        fx1[] fx1VarArr2;
        loop0: while (true) {
            AtomicReference atomicReference = this.f19505b;
            gx1Var = (gx1) atomicReference.get();
            if (gx1Var != null) {
                break;
            }
            gx1 gx1Var2 = new gx1(atomicReference);
            while (!atomicReference.compareAndSet(gx1Var, gx1Var2)) {
                if (atomicReference.get() != gx1Var) {
                    break;
                }
            }
            gx1Var = gx1Var2;
            break loop0;
        }
        fx1 fx1Var = new fx1(observer, gx1Var);
        observer.onSubscribe(fx1Var);
        do {
            fx1VarArr = (fx1[]) gx1Var.get();
            if (fx1VarArr == gx1.f17857f) {
                Throwable th = gx1Var.f17861d;
                if (th != null) {
                    observer.onError(th);
                    return;
                } else {
                    observer.onComplete();
                    return;
                }
            }
            int length = fx1VarArr.length;
            fx1VarArr2 = new fx1[length + 1];
            System.arraycopy(fx1VarArr, 0, fx1VarArr2, 0, length);
            fx1VarArr2[length] = fx1Var;
        } while (!gx1Var.compareAndSet(fx1VarArr, fx1VarArr2));
        if (fx1Var.isDisposed()) {
            gx1Var.m5025a(fx1Var);
        }
    }
}
