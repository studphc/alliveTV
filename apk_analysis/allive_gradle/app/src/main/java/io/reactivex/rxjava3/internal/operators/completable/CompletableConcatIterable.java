package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.Iterator;
import java.util.Objects;
import p000.C1280hs;

/* loaded from: classes2.dex */
public final class CompletableConcatIterable extends Completable {

    /* renamed from: a */
    public final Iterable f18652a;

    public CompletableConcatIterable(Iterable<? extends CompletableSource> iterable) {
        this.f18652a = iterable;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        try {
            Iterator it = this.f18652a.iterator();
            Objects.requireNonNull(it, "The iterator returned is null");
            C1280hs c1280hs = new C1280hs(completableObserver, it);
            completableObserver.onSubscribe(c1280hs.f18156c);
            c1280hs.m5126a();
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, completableObserver);
        }
    }
}
