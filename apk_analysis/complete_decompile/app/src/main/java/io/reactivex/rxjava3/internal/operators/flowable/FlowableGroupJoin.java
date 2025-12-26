package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Function;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.um0;
import p000.xm0;

/* loaded from: classes2.dex */
public final class FlowableGroupJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AbstractC1215g0 {

    /* renamed from: b */
    public final Publisher f18903b;

    /* renamed from: c */
    public final Function f18904c;

    /* renamed from: d */
    public final Function f18905d;

    /* renamed from: e */
    public final BiFunction f18906e;

    public FlowableGroupJoin(Flowable<TLeft> flowable, Publisher<? extends TRight> publisher, Function<? super TLeft, ? extends Publisher<TLeftEnd>> function, Function<? super TRight, ? extends Publisher<TRightEnd>> function2, BiFunction<? super TLeft, ? super Flowable<TRight>, ? extends R> biFunction) {
        super(flowable);
        this.f18903b = publisher;
        this.f18904c = function;
        this.f18905d = function2;
        this.f18906e = biFunction;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        um0 um0Var = new um0(subscriber, this.f18904c, this.f18905d, this.f18906e);
        subscriber.onSubscribe(um0Var);
        xm0 xm0Var = new xm0(um0Var, true);
        CompositeDisposable compositeDisposable = um0Var.f27352d;
        compositeDisposable.add(xm0Var);
        xm0 xm0Var2 = new xm0(um0Var, false);
        compositeDisposable.add(xm0Var2);
        this.source.subscribe((FlowableSubscriber<? super Object>) xm0Var);
        this.f18903b.subscribe(xm0Var2);
    }
}
