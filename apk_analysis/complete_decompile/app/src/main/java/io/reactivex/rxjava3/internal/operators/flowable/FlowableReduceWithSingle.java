package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.Objects;
import org.reactivestreams.Publisher;
import p000.on0;

/* loaded from: classes2.dex */
public final class FlowableReduceWithSingle<T, R> extends Single<R> {

    /* renamed from: a */
    public final Publisher f18973a;

    /* renamed from: b */
    public final Supplier f18974b;

    /* renamed from: c */
    public final BiFunction f18975c;

    public FlowableReduceWithSingle(Publisher<T> publisher, Supplier<R> supplier, BiFunction<R, ? super T, R> biFunction) {
        this.f18973a = publisher;
        this.f18974b = supplier;
        this.f18975c = biFunction;
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super R> singleObserver) {
        try {
            Object obj = this.f18974b.get();
            Objects.requireNonNull(obj, "The seedSupplier returned a null value");
            this.f18973a.subscribe(new on0(singleObserver, this.f18975c, obj));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, singleObserver);
        }
    }
}
