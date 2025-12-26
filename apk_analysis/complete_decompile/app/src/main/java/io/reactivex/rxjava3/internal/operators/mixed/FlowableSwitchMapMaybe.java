package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.functions.Function;
import org.reactivestreams.Subscriber;
import p000.xq0;

/* loaded from: classes2.dex */
public final class FlowableSwitchMapMaybe<T, R> extends Flowable<R> {

    /* renamed from: b */
    public final Flowable f19275b;

    /* renamed from: c */
    public final Function f19276c;

    /* renamed from: d */
    public final boolean f19277d;

    public FlowableSwitchMapMaybe(Flowable<T> flowable, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z) {
        this.f19275b = flowable;
        this.f19276c = function;
        this.f19277d = z;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.f19275b.subscribe((FlowableSubscriber) new xq0(subscriber, this.f19276c, this.f19277d));
    }
}
