package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.functions.Function;
import p000.C0532at;

/* loaded from: classes2.dex */
public final class CompletableResumeNext extends Completable {

    /* renamed from: a */
    public final CompletableSource f18701a;

    /* renamed from: b */
    public final Function f18702b;

    public CompletableResumeNext(CompletableSource completableSource, Function<? super Throwable, ? extends CompletableSource> function) {
        this.f18701a = completableSource;
        this.f18702b = function;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        C0532at c0532at = new C0532at(completableObserver, this.f18702b);
        completableObserver.onSubscribe(c0532at);
        this.f18701a.subscribe(c0532at);
    }
}
