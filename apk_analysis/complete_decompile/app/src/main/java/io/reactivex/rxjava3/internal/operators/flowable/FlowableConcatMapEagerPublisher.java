package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import p000.yj0;

/* loaded from: classes2.dex */
public final class FlowableConcatMapEagerPublisher<T, R> extends Flowable<R> {

    /* renamed from: b */
    public final Publisher f18787b;

    /* renamed from: c */
    public final Function f18788c;

    /* renamed from: d */
    public final int f18789d;

    /* renamed from: e */
    public final int f18790e;

    /* renamed from: f */
    public final ErrorMode f18791f;

    public FlowableConcatMapEagerPublisher(Publisher<T> publisher, Function<? super T, ? extends Publisher<? extends R>> function, int i, int i2, ErrorMode errorMode) {
        this.f18787b = publisher;
        this.f18788c = function;
        this.f18789d = i;
        this.f18790e = i2;
        this.f18791f = errorMode;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.f18787b.subscribe(new yj0(subscriber, this.f18788c, this.f18789d, this.f18790e, this.f18791f));
    }
}
