package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import p000.AbstractC1607o2;
import p000.qv1;

/* loaded from: classes2.dex */
public final class ObservableElementAt<T> extends AbstractC1607o2 {

    /* renamed from: a */
    public final long f19410a;

    /* renamed from: b */
    public final Object f19411b;

    /* renamed from: c */
    public final boolean f19412c;

    public ObservableElementAt(ObservableSource<T> observableSource, long j, T t, boolean z) {
        super(observableSource);
        this.f19410a = j;
        this.f19411b = t;
        this.f19412c = z;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new qv1(observer, this.f19410a, this.f19411b, this.f19412c));
    }
}
