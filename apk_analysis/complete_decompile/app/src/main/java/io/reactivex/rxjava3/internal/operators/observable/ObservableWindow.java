package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import p000.AbstractC1607o2;
import p000.yz1;
import p000.zz1;

/* loaded from: classes2.dex */
public final class ObservableWindow<T> extends AbstractC1607o2 {

    /* renamed from: a */
    public final long f19611a;

    /* renamed from: b */
    public final long f19612b;

    /* renamed from: c */
    public final int f19613c;

    public ObservableWindow(ObservableSource<T> observableSource, long j, long j2, int i) {
        super(observableSource);
        this.f19611a = j;
        this.f19612b = j2;
        this.f19613c = i;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super Observable<T>> observer) {
        long j = this.f19611a;
        if (j == this.f19612b) {
            this.source.subscribe(new yz1(observer, j, this.f19613c));
            return;
        }
        this.source.subscribe(new zz1(observer, this.f19611a, this.f19612b, this.f19613c));
    }
}
