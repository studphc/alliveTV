package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import p000.gk0;

/* loaded from: classes2.dex */
public final class FlowableConcatMapSinglePublisher<T, R> extends Flowable<R> {

    /* renamed from: b */
    public final Publisher f19265b;

    /* renamed from: c */
    public final Function f19266c;

    /* renamed from: d */
    public final ErrorMode f19267d;

    /* renamed from: e */
    public final int f19268e;

    public FlowableConcatMapSinglePublisher(Publisher<T> publisher, Function<? super T, ? extends SingleSource<? extends R>> function, ErrorMode errorMode, int i) {
        this.f19265b = publisher;
        this.f19266c = function;
        this.f19267d = errorMode;
        this.f19268e = i;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.f19265b.subscribe(new gk0(subscriber, this.f19266c, this.f19268e, this.f19267d));
    }
}
