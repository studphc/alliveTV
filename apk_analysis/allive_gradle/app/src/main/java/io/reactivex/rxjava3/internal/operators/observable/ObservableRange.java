package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import p000.jx1;

/* loaded from: classes2.dex */
public final class ObservableRange extends Observable<Integer> {

    /* renamed from: a */
    public final int f19507a;

    /* renamed from: b */
    public final long f19508b;

    public ObservableRange(int i, int i2) {
        this.f19507a = i;
        this.f19508b = i + i2;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super Integer> observer) {
        Observer observer2;
        jx1 jx1Var = new jx1(observer, this.f19507a, this.f19508b);
        observer.onSubscribe(jx1Var);
        if (!jx1Var.f20676d) {
            long j = jx1Var.f20675c;
            while (true) {
                long j2 = jx1Var.f20674b;
                observer2 = jx1Var.f20673a;
                if (j == j2 || jx1Var.get() != 0) {
                    break;
                }
                observer2.onNext(Integer.valueOf((int) j));
                j++;
            }
            if (jx1Var.get() == 0) {
                jx1Var.lazySet(1);
                observer2.onComplete();
            }
        }
    }
}
