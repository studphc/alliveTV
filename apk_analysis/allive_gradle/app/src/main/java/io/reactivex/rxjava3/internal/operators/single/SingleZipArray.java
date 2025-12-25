package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import p000.gk2;
import p000.nj0;
import p000.xi1;

/* loaded from: classes2.dex */
public final class SingleZipArray<T, R> extends Single<R> {

    /* renamed from: a */
    public final SingleSource[] f19823a;

    /* renamed from: b */
    public final Function f19824b;

    public SingleZipArray(SingleSource<? extends T>[] singleSourceArr, Function<? super Object[], ? extends R> function) {
        this.f19823a = singleSourceArr;
        this.f19824b = function;
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super R> singleObserver) {
        SingleSource[] singleSourceArr = this.f19823a;
        int length = singleSourceArr.length;
        if (length == 1) {
            singleSourceArr[0].subscribe(new xi1(8, singleObserver, new nj0(15, this)));
            return;
        }
        gk2 gk2Var = new gk2(singleObserver, length, this.f19824b);
        singleObserver.onSubscribe(gk2Var);
        for (int i = 0; i < length && !gk2Var.isDisposed(); i++) {
            SingleSource singleSource = singleSourceArr[i];
            if (singleSource == null) {
                gk2Var.m4954a(new NullPointerException("One of the sources is null"), i);
                return;
            }
            singleSource.subscribe(gk2Var.f17744c[i]);
        }
    }
}
