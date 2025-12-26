package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.functions.Function;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import p000.xq0;

/* loaded from: classes2.dex */
public final class FlowableSwitchMapMaybePublisher<T, R> extends Flowable<R> {

    /* renamed from: b */
    public final Publisher f19278b;

    /* renamed from: c */
    public final Function f19279c;

    /* renamed from: d */
    public final boolean f19280d;

    public FlowableSwitchMapMaybePublisher(Publisher<T> publisher, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z) {
        this.f19278b = publisher;
        this.f19279c = function;
        this.f19280d = z;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.f19278b.subscribe(new xq0(subscriber, this.f19279c, this.f19280d));
    }
}
