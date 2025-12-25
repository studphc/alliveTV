package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.Objects;
import java.util.stream.Stream;
import p000.dw1;
import p000.ki0;

/* loaded from: classes2.dex */
public final class ObservableFlatMapStream<T, R> extends Observable<R> {

    /* renamed from: a */
    public final Observable f18560a;

    /* renamed from: b */
    public final Function f18561b;

    public ObservableFlatMapStream(Observable<T> observable, Function<? super T, ? extends Stream<? extends R>> function) {
        this.f18560a = observable;
        this.f18561b = function;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super R> observer) {
        Stream stream;
        ObservableSource observableSource = this.f18560a;
        boolean z = observableSource instanceof Supplier;
        Function function = this.f18561b;
        if (z) {
            try {
                Object obj = ((Supplier) observableSource).get();
                if (obj != null) {
                    Object apply = function.apply(obj);
                    Objects.requireNonNull(apply, "The mapper returned a null Stream");
                    stream = ki0.m5549q(apply);
                } else {
                    stream = null;
                }
                if (stream != null) {
                    ObservableFromStream.subscribeStream(observer, stream);
                    return;
                } else {
                    EmptyDisposable.complete(observer);
                    return;
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptyDisposable.error(th, observer);
                return;
            }
        }
        observableSource.subscribe(new dw1(observer, function));
    }
}
