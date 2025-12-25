package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import org.reactivestreams.Subscriber;
import p000.ak0;

/* loaded from: classes2.dex */
public final class FlowableConcatMapMaybe<T, R> extends Flowable<R> {

    /* renamed from: b */
    public final Flowable f19253b;

    /* renamed from: c */
    public final Function f19254c;

    /* renamed from: d */
    public final ErrorMode f19255d;

    /* renamed from: e */
    public final int f19256e;

    public FlowableConcatMapMaybe(Flowable<T> flowable, Function<? super T, ? extends MaybeSource<? extends R>> function, ErrorMode errorMode, int i) {
        this.f19253b = flowable;
        this.f19254c = function;
        this.f19255d = errorMode;
        this.f19256e = i;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.f19253b.subscribe((FlowableSubscriber) new ak0(subscriber, this.f19254c, this.f19256e, this.f19255d));
    }
}
