package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableOnSubscribe;
import io.reactivex.rxjava3.exceptions.Exceptions;
import p000.C1329is;

/* loaded from: classes2.dex */
public final class CompletableCreate extends Completable {

    /* renamed from: a */
    public final CompletableOnSubscribe f18653a;

    public CompletableCreate(CompletableOnSubscribe completableOnSubscribe) {
        this.f18653a = completableOnSubscribe;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        C1329is c1329is = new C1329is(completableObserver);
        completableObserver.onSubscribe(c1329is);
        try {
            this.f18653a.subscribe(c1329is);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            c1329is.onError(th);
        }
    }
}
