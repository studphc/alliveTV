package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import org.reactivestreams.Publisher;
import p000.AbstractC0003a2;
import p000.nn0;

/* loaded from: classes2.dex */
public final class MaybeDelaySubscriptionOtherPublisher<T, U> extends AbstractC0003a2 {

    /* renamed from: a */
    public final Publisher f19137a;

    public MaybeDelaySubscriptionOtherPublisher(MaybeSource<T> maybeSource, Publisher<U> publisher) {
        super(maybeSource);
        this.f19137a = publisher;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f19137a.subscribe(new nn0(maybeObserver, this.source));
    }
}
