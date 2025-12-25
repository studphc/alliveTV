package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.Supplier;
import java.util.Collection;
import p000.AbstractC1607o2;
import p000.ot1;
import p000.pt1;

/* loaded from: classes2.dex */
public final class ObservableBuffer<T, U extends Collection<? super T>> extends AbstractC1607o2 {

    /* renamed from: a */
    public final int f19334a;

    /* renamed from: b */
    public final int f19335b;

    /* renamed from: c */
    public final Supplier f19336c;

    public ObservableBuffer(ObservableSource<T> observableSource, int i, int i2, Supplier<U> supplier) {
        super(observableSource);
        this.f19334a = i;
        this.f19335b = i2;
        this.f19336c = supplier;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super U> observer) {
        Supplier supplier = this.f19336c;
        int i = this.f19335b;
        int i2 = this.f19334a;
        if (i == i2) {
            ot1 ot1Var = new ot1(observer, i2, supplier);
            if (ot1Var.m6728a()) {
                this.source.subscribe(ot1Var);
                return;
            }
            return;
        }
        this.source.subscribe(new pt1(observer, i2, i, supplier));
    }
}
