package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import org.reactivestreams.Publisher;
import p000.AbstractC0003a2;
import p000.pj1;

/* loaded from: classes2.dex */
public final class MaybeTakeUntilPublisher<T, U> extends AbstractC0003a2 {

    /* renamed from: a */
    public final Publisher f19204a;

    public MaybeTakeUntilPublisher(MaybeSource<T> maybeSource, Publisher<U> publisher) {
        super(maybeSource);
        this.f19204a = publisher;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        pj1 pj1Var = new pj1(maybeObserver);
        maybeObserver.onSubscribe(pj1Var);
        this.f19204a.subscribe(pj1Var.f25198b);
        this.source.subscribe(pj1Var);
    }
}
