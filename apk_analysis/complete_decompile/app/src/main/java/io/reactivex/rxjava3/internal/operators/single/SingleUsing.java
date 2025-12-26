package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import p000.fk2;

/* loaded from: classes2.dex */
public final class SingleUsing<T, U> extends Single<T> {

    /* renamed from: a */
    public final Supplier f19819a;

    /* renamed from: b */
    public final Function f19820b;

    /* renamed from: c */
    public final Consumer f19821c;

    /* renamed from: d */
    public final boolean f19822d;

    public SingleUsing(Supplier<U> supplier, Function<? super U, ? extends SingleSource<? extends T>> function, Consumer<? super U> consumer, boolean z) {
        this.f19819a = supplier;
        this.f19820b = function;
        this.f19821c = consumer;
        this.f19822d = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        Consumer consumer = this.f19821c;
        boolean z = this.f19822d;
        try {
            Object obj = this.f19819a.get();
            try {
                Object apply = this.f19820b.apply(obj);
                Objects.requireNonNull(apply, "The singleFunction returned a null SingleSource");
                ((SingleSource) apply).subscribe(new fk2(singleObserver, obj, z, consumer));
            } catch (Throwable th) {
                th = th;
                Exceptions.throwIfFatal(th);
                if (z) {
                    try {
                        consumer.accept(obj);
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        th = new CompositeException(th, th2);
                    }
                }
                EmptyDisposable.error(th, singleObserver);
                if (!z) {
                    try {
                        consumer.accept(obj);
                    } catch (Throwable th3) {
                        Exceptions.throwIfFatal(th3);
                        RxJavaPlugins.onError(th3);
                    }
                }
            }
        } catch (Throwable th4) {
            Exceptions.throwIfFatal(th4);
            EmptyDisposable.error(th4, singleObserver);
        }
    }
}
