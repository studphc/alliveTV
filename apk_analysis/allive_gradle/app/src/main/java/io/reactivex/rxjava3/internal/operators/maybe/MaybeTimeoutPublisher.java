package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import org.reactivestreams.Publisher;
import p000.AbstractC0003a2;
import p000.vj1;

/* loaded from: classes2.dex */
public final class MaybeTimeoutPublisher<T, U> extends AbstractC0003a2 {

    /* renamed from: a */
    public final Publisher f19211a;

    /* renamed from: b */
    public final MaybeSource f19212b;

    public MaybeTimeoutPublisher(MaybeSource<T> maybeSource, Publisher<U> publisher, MaybeSource<? extends T> maybeSource2) {
        super(maybeSource);
        this.f19211a = publisher;
        this.f19212b = maybeSource2;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        vj1 vj1Var = new vj1(maybeObserver, this.f19212b);
        maybeObserver.onSubscribe(vj1Var);
        this.f19211a.subscribe(vj1Var.f27816b);
        this.source.subscribe(vj1Var);
    }
}
