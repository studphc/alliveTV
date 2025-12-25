package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableOperator;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

/* loaded from: classes2.dex */
public final class CompletableLift extends Completable {

    /* renamed from: a */
    public final CompletableSource f18678a;

    /* renamed from: b */
    public final CompletableOperator f18679b;

    public CompletableLift(CompletableSource completableSource, CompletableOperator completableOperator) {
        this.f18678a = completableSource;
        this.f18679b = completableOperator;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        try {
            this.f18678a.subscribe(this.f18679b.apply(completableObserver));
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
        }
    }
}
