package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleOnSubscribe;
import io.reactivex.rxjava3.exceptions.Exceptions;
import p000.oi2;

/* loaded from: classes2.dex */
public final class SingleCreate<T> extends Single<T> {

    /* renamed from: a */
    public final SingleOnSubscribe f19719a;

    public SingleCreate(SingleOnSubscribe<T> singleOnSubscribe) {
        this.f19719a = singleOnSubscribe;
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        oi2 oi2Var = new oi2(singleObserver);
        singleObserver.onSubscribe(oi2Var);
        try {
            this.f19719a.subscribe(oi2Var);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            oi2Var.onError(th);
        }
    }
}
