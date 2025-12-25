package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import org.reactivestreams.Publisher;
import p000.C1206fs;

/* loaded from: classes2.dex */
public final class CompletableConcat extends Completable {

    /* renamed from: a */
    public final Publisher f18649a;

    /* renamed from: b */
    public final int f18650b;

    public CompletableConcat(Publisher<? extends CompletableSource> publisher, int i) {
        this.f18649a = publisher;
        this.f18650b = i;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.f18649a.subscribe(new C1206fs(completableObserver, this.f18650b));
    }
}
