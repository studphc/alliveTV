package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import p000.kx1;

/* loaded from: classes2.dex */
public final class ObservableRangeLong extends Observable<Long> {

    /* renamed from: a */
    public final long f19509a;

    /* renamed from: b */
    public final long f19510b;

    public ObservableRangeLong(long j, long j2) {
        this.f19509a = j;
        this.f19510b = j2;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super Long> observer) {
        Observer observer2;
        long j = this.f19509a;
        kx1 kx1Var = new kx1(observer, j, j + this.f19510b);
        observer.onSubscribe(kx1Var);
        if (!kx1Var.f22242d) {
            long j2 = kx1Var.f22241c;
            while (true) {
                long j3 = kx1Var.f22240b;
                observer2 = kx1Var.f22239a;
                if (j2 == j3 || kx1Var.get() != 0) {
                    break;
                }
                observer2.onNext(Long.valueOf(j2));
                j2++;
            }
            if (kx1Var.get() == 0) {
                kx1Var.lazySet(1);
                observer2.onComplete();
            }
        }
    }
}
