package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.Iterator;
import java.util.Objects;
import p000.bu1;

/* loaded from: classes2.dex */
public final class ObservableZipIterable<T, U, V> extends Observable<V> {

    /* renamed from: a */
    public final Observable f19636a;

    /* renamed from: b */
    public final Iterable f19637b;

    /* renamed from: c */
    public final BiFunction f19638c;

    public ObservableZipIterable(Observable<? extends T> observable, Iterable<U> iterable, BiFunction<? super T, ? super U, ? extends V> biFunction) {
        this.f19636a = observable;
        this.f19637b = iterable;
        this.f19638c = biFunction;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super V> observer) {
        try {
            Iterator<T> it = this.f19637b.iterator();
            Objects.requireNonNull(it, "The iterator returned by other is null");
            try {
                if (!it.hasNext()) {
                    EmptyDisposable.complete(observer);
                } else {
                    this.f19636a.subscribe(new bu1(observer, it, this.f19638c));
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptyDisposable.error(th, observer);
            }
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptyDisposable.error(th2, observer);
        }
    }
}
