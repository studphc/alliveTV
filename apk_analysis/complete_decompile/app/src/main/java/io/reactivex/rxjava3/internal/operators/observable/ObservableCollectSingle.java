package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiConsumer;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.fuseable.FuseToObservable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import p000.bu1;

/* loaded from: classes2.dex */
public final class ObservableCollectSingle<T, U> extends Single<U> implements FuseToObservable<U> {

    /* renamed from: a */
    public final ObservableSource f19362a;

    /* renamed from: b */
    public final Supplier f19363b;

    /* renamed from: c */
    public final BiConsumer f19364c;

    public ObservableCollectSingle(ObservableSource<T> observableSource, Supplier<? extends U> supplier, BiConsumer<? super U, ? super T> biConsumer) {
        this.f19362a = observableSource;
        this.f19363b = supplier;
        this.f19364c = biConsumer;
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.FuseToObservable
    public Observable<U> fuseToObservable() {
        return RxJavaPlugins.onAssembly(new ObservableCollect(this.f19362a, this.f19363b, this.f19364c));
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super U> singleObserver) {
        try {
            Object obj = this.f19363b.get();
            Objects.requireNonNull(obj, "The initialSupplier returned a null value");
            this.f19362a.subscribe(new bu1(singleObserver, obj, this.f19364c, 1));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, singleObserver);
        }
    }
}
