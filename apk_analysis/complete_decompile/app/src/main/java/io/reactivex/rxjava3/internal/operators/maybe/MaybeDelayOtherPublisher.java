package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import org.reactivestreams.Publisher;
import p000.AbstractC0003a2;
import p000.bi1;

/* loaded from: classes2.dex */
public final class MaybeDelayOtherPublisher<T, U> extends AbstractC0003a2 {

    /* renamed from: a */
    public final Publisher f19136a;

    public MaybeDelayOtherPublisher(MaybeSource<T> maybeSource, Publisher<U> publisher) {
        super(maybeSource);
        this.f19136a = publisher;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe(new bi1(maybeObserver, this.f19136a));
    }
}
