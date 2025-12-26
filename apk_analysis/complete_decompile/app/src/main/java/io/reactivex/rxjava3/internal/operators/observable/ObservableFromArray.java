package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import p000.fw1;
import p000.ye0;

/* loaded from: classes2.dex */
public final class ObservableFromArray<T> extends Observable<T> {

    /* renamed from: a */
    public final Object[] f19435a;

    public ObservableFromArray(T[] tArr) {
        this.f19435a = tArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        fw1 fw1Var = new fw1(observer, this.f19435a);
        observer.onSubscribe(fw1Var);
        if (fw1Var.f17420d) {
            return;
        }
        Object[] objArr = fw1Var.f17418b;
        int length = objArr.length;
        for (int i = 0; i < length && !fw1Var.f17421e; i++) {
            Object obj = objArr[i];
            if (obj == null) {
                fw1Var.f17417a.onError(new NullPointerException(ye0.m8292l(i, "The element at index ", " is null")));
                return;
            }
            fw1Var.f17417a.onNext(obj);
        }
        if (!fw1Var.f17421e) {
            fw1Var.f17417a.onComplete();
        }
    }
}
