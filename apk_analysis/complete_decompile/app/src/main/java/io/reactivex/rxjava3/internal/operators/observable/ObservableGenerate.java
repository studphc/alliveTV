package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Emitter;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import p000.kw1;

/* loaded from: classes2.dex */
public final class ObservableGenerate<T, S> extends Observable<T> {

    /* renamed from: a */
    public final Supplier f19448a;

    /* renamed from: b */
    public final BiFunction f19449b;

    /* renamed from: c */
    public final Consumer f19450c;

    public ObservableGenerate(Supplier<S> supplier, BiFunction<S, Emitter<T>, S> biFunction, Consumer<? super S> consumer) {
        this.f19448a = supplier;
        this.f19449b = biFunction;
        this.f19450c = consumer;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        try {
            Object obj = this.f19448a.get();
            BiFunction biFunction = this.f19449b;
            kw1 kw1Var = new kw1(observer, biFunction, this.f19450c, obj);
            observer.onSubscribe(kw1Var);
            Object obj2 = kw1Var.f22229d;
            if (kw1Var.f22230e) {
                kw1Var.f22229d = null;
                kw1Var.m5797a(obj2);
                return;
            }
            while (!kw1Var.f22230e) {
                kw1Var.f22232g = false;
                try {
                    obj2 = biFunction.apply(obj2, kw1Var);
                    if (kw1Var.f22231f) {
                        kw1Var.f22230e = true;
                        kw1Var.f22229d = null;
                        kw1Var.m5797a(obj2);
                        return;
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    kw1Var.f22229d = null;
                    kw1Var.f22230e = true;
                    kw1Var.onError(th);
                    kw1Var.m5797a(obj2);
                    return;
                }
            }
            kw1Var.f22229d = null;
            kw1Var.m5797a(obj2);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptyDisposable.error(th2, observer);
        }
    }
}
