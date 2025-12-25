package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.internal.fuseable.FuseToObservable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Collection;
import p000.tw1;

/* loaded from: classes2.dex */
public final class ObservableToListSingle<T, U extends Collection<? super T>> extends Single<U> implements FuseToObservable<U> {

    /* renamed from: a */
    public final ObservableSource f19604a;

    /* renamed from: b */
    public final Supplier f19605b;

    public ObservableToListSingle(ObservableSource<T> observableSource, int i) {
        this.f19604a = observableSource;
        this.f19605b = Functions.createArrayList(i);
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.FuseToObservable
    public Observable<U> fuseToObservable() {
        return RxJavaPlugins.onAssembly(new ObservableToList(this.f19604a, this.f19605b));
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super U> singleObserver) {
        try {
            this.f19604a.subscribe(new tw1(singleObserver, (Collection) ExceptionHelper.nullCheck(this.f19605b.get(), "The collectionSupplier returned a null Collection."), 3));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, singleObserver);
        }
    }

    public ObservableToListSingle(ObservableSource<T> observableSource, Supplier<U> supplier) {
        this.f19604a = observableSource;
        this.f19605b = supplier;
    }
}
