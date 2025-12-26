package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import p000.AbstractC1607o2;
import p000.pv1;

/* loaded from: classes2.dex */
public final class ObservableDoOnEach<T> extends AbstractC1607o2 {

    /* renamed from: a */
    public final Consumer f19404a;

    /* renamed from: b */
    public final Consumer f19405b;

    /* renamed from: c */
    public final Action f19406c;

    /* renamed from: d */
    public final Action f19407d;

    public ObservableDoOnEach(ObservableSource<T> observableSource, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2) {
        super(observableSource);
        this.f19404a = consumer;
        this.f19405b = consumer2;
        this.f19406c = action;
        this.f19407d = action2;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new pv1(observer, this.f19404a, this.f19405b, this.f19406c, this.f19407d));
    }
}
