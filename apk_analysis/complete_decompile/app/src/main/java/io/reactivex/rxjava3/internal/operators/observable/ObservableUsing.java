package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.Objects;
import p000.xz1;

/* loaded from: classes2.dex */
public final class ObservableUsing<T, D> extends Observable<T> {

    /* renamed from: a */
    public final Supplier f19607a;

    /* renamed from: b */
    public final Function f19608b;

    /* renamed from: c */
    public final Consumer f19609c;

    /* renamed from: d */
    public final boolean f19610d;

    public ObservableUsing(Supplier<? extends D> supplier, Function<? super D, ? extends ObservableSource<? extends T>> function, Consumer<? super D> consumer, boolean z) {
        this.f19607a = supplier;
        this.f19608b = function;
        this.f19609c = consumer;
        this.f19610d = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        Consumer consumer = this.f19609c;
        try {
            Object obj = this.f19607a.get();
            try {
                Object apply = this.f19608b.apply(obj);
                Objects.requireNonNull(apply, "The sourceSupplier returned a null ObservableSource");
                ((ObservableSource) apply).subscribe(new xz1(observer, obj, consumer, this.f19610d));
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                try {
                    consumer.accept(obj);
                    EmptyDisposable.error(th, observer);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    EmptyDisposable.error(new CompositeException(th, th2), observer);
                }
            }
        } catch (Throwable th3) {
            Exceptions.throwIfFatal(th3);
            EmptyDisposable.error(th3, observer);
        }
    }
}
