package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import org.reactivestreams.Subscriber;
import p000.zq0;

/* loaded from: classes2.dex */
public final class FlowableSwitchMapSingle<T, R> extends Flowable<R> {

    /* renamed from: b */
    public final Flowable f19281b;

    /* renamed from: c */
    public final Function f19282c;

    /* renamed from: d */
    public final boolean f19283d;

    public FlowableSwitchMapSingle(Flowable<T> flowable, Function<? super T, ? extends SingleSource<? extends R>> function, boolean z) {
        this.f19281b = flowable;
        this.f19282c = function;
        this.f19283d = z;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.f19281b.subscribe((FlowableSubscriber) new zq0(subscriber, this.f19282c, this.f19283d));
    }
}
