package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import java.util.concurrent.atomic.AtomicInteger;
import p000.bj2;

/* loaded from: classes2.dex */
public final class SingleEquals<T> extends Single<Boolean> {

    /* renamed from: a */
    public final SingleSource f19758a;

    /* renamed from: b */
    public final SingleSource f19759b;

    public SingleEquals(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2) {
        this.f19758a = singleSource;
        this.f19759b = singleSource2;
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        AtomicInteger atomicInteger = new AtomicInteger();
        Object[] objArr = {null, null};
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        singleObserver.onSubscribe(compositeDisposable);
        this.f19758a.subscribe(new bj2(0, compositeDisposable, objArr, singleObserver, atomicInteger));
        this.f19759b.subscribe(new bj2(1, compositeDisposable, objArr, singleObserver, atomicInteger));
    }
}
