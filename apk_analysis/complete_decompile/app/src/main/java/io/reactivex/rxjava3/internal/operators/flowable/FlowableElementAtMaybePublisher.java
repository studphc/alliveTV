package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import org.reactivestreams.Publisher;
import p000.rl0;

/* loaded from: classes2.dex */
public final class FlowableElementAtMaybePublisher<T> extends Maybe<T> {

    /* renamed from: a */
    public final Publisher f18832a;

    /* renamed from: b */
    public final long f18833b;

    public FlowableElementAtMaybePublisher(Publisher<T> publisher, long j) {
        this.f18832a = publisher;
        this.f18833b = j;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f18832a.subscribe(new rl0(maybeObserver, this.f18833b));
    }
}
