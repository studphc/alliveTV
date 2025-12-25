package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import p000.bz1;
import p000.yy2;

/* loaded from: classes2.dex */
public final class ObservableSwitchMapCompletable<T> extends Completable {

    /* renamed from: a */
    public final Observable f19305a;

    /* renamed from: b */
    public final Function f19306b;

    /* renamed from: c */
    public final boolean f19307c;

    public ObservableSwitchMapCompletable(Observable<T> observable, Function<? super T, ? extends CompletableSource> function, boolean z) {
        this.f19305a = observable;
        this.f19306b = function;
        this.f19307c = z;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        Observable observable = this.f19305a;
        Function function = this.f19306b;
        if (!yy2.m8344S(observable, function, completableObserver)) {
            observable.subscribe(new bz1(completableObserver, function, this.f19307c));
        }
    }
}
