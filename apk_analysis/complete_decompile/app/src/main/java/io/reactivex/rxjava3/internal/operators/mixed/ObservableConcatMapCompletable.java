package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import p000.lu1;
import p000.yy2;

/* loaded from: classes2.dex */
public final class ObservableConcatMapCompletable<T> extends Completable {

    /* renamed from: a */
    public final Observable f19293a;

    /* renamed from: b */
    public final Function f19294b;

    /* renamed from: c */
    public final ErrorMode f19295c;

    /* renamed from: d */
    public final int f19296d;

    public ObservableConcatMapCompletable(Observable<T> observable, Function<? super T, ? extends CompletableSource> function, ErrorMode errorMode, int i) {
        this.f19293a = observable;
        this.f19294b = function;
        this.f19295c = errorMode;
        this.f19296d = i;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        Observable observable = this.f19293a;
        Function function = this.f19294b;
        if (!yy2.m8344S(observable, function, completableObserver)) {
            observable.subscribe(new lu1(completableObserver, function, this.f19295c, this.f19296d));
        }
    }
}
