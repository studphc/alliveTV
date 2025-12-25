package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.Iterator;
import java.util.Objects;
import p000.iw1;

/* loaded from: classes2.dex */
public final class ObservableFromIterable<T> extends Observable<T> {

    /* renamed from: a */
    public final Iterable f19443a;

    public ObservableFromIterable(Iterable<? extends T> iterable) {
        this.f19443a = iterable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        try {
            Iterator<T> it = this.f19443a.iterator();
            try {
                if (!it.hasNext()) {
                    EmptyDisposable.complete(observer);
                    return;
                }
                iw1 iw1Var = new iw1(observer, it);
                observer.onSubscribe(iw1Var);
                if (iw1Var.f20293d) {
                    return;
                }
                while (!iw1Var.f20292c) {
                    try {
                        Object next = iw1Var.f20291b.next();
                        Objects.requireNonNull(next, "The iterator returned a null value");
                        iw1Var.f20290a.onNext(next);
                        if (!iw1Var.f20292c) {
                            try {
                                if (!iw1Var.f20291b.hasNext()) {
                                    if (!iw1Var.f20292c) {
                                        iw1Var.f20290a.onComplete();
                                        return;
                                    }
                                    return;
                                }
                            } catch (Throwable th) {
                                Exceptions.throwIfFatal(th);
                                iw1Var.f20290a.onError(th);
                                return;
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        iw1Var.f20290a.onError(th2);
                        return;
                    }
                }
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                EmptyDisposable.error(th3, observer);
            }
        } catch (Throwable th4) {
            Exceptions.throwIfFatal(th4);
            EmptyDisposable.error(th4, observer);
        }
    }
}
