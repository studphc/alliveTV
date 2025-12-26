package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.Predicate;
import p000.AbstractC1607o2;
import p000.kt1;

/* loaded from: classes2.dex */
public final class ObservableAll<T> extends AbstractC1607o2 {

    /* renamed from: a */
    public final Predicate f19322a;

    public ObservableAll(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        super(observableSource);
        this.f19322a = predicate;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super Boolean> observer) {
        this.source.subscribe(new kt1(observer, this.f19322a, 0));
    }
}
