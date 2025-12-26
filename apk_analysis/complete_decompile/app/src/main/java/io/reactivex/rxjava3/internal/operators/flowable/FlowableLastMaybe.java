package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import org.reactivestreams.Publisher;
import p000.nn0;

/* loaded from: classes2.dex */
public final class FlowableLastMaybe<T> extends Maybe<T> {

    /* renamed from: a */
    public final Publisher f18924a;

    public FlowableLastMaybe(Publisher<T> publisher) {
        this.f18924a = publisher;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f18924a.subscribe(new nn0(maybeObserver));
    }
}
