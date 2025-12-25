package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.functions.BiPredicate;
import io.reactivex.rxjava3.internal.fuseable.FuseToObservable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import p000.py1;
import p000.qy1;

/* loaded from: classes2.dex */
public final class ObservableSequenceEqualSingle<T> extends Single<Boolean> implements FuseToObservable<Boolean> {

    /* renamed from: a */
    public final ObservableSource f19552a;

    /* renamed from: b */
    public final ObservableSource f19553b;

    /* renamed from: c */
    public final BiPredicate f19554c;

    /* renamed from: d */
    public final int f19555d;

    public ObservableSequenceEqualSingle(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, BiPredicate<? super T, ? super T> biPredicate, int i) {
        this.f19552a = observableSource;
        this.f19553b = observableSource2;
        this.f19554c = biPredicate;
        this.f19555d = i;
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.FuseToObservable
    public Observable<Boolean> fuseToObservable() {
        return RxJavaPlugins.onAssembly(new ObservableSequenceEqual(this.f19552a, this.f19553b, this.f19554c, this.f19555d));
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        qy1 qy1Var = new qy1(singleObserver, this.f19555d, this.f19552a, this.f19553b, this.f19554c);
        singleObserver.onSubscribe(qy1Var);
        py1[] py1VarArr = qy1Var.f25804f;
        qy1Var.f25802d.subscribe(py1VarArr[0]);
        qy1Var.f25803e.subscribe(py1VarArr[1]);
    }
}
