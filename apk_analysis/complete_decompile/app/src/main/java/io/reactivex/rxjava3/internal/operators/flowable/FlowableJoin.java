package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Function;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.mn0;
import p000.xm0;

/* loaded from: classes2.dex */
public final class FlowableJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AbstractC1215g0 {

    /* renamed from: b */
    public final Publisher f18919b;

    /* renamed from: c */
    public final Function f18920c;

    /* renamed from: d */
    public final Function f18921d;

    /* renamed from: e */
    public final BiFunction f18922e;

    public FlowableJoin(Flowable<TLeft> flowable, Publisher<? extends TRight> publisher, Function<? super TLeft, ? extends Publisher<TLeftEnd>> function, Function<? super TRight, ? extends Publisher<TRightEnd>> function2, BiFunction<? super TLeft, ? super TRight, ? extends R> biFunction) {
        super(flowable);
        this.f18919b = publisher;
        this.f18920c = function;
        this.f18921d = function2;
        this.f18922e = biFunction;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        mn0 mn0Var = new mn0(subscriber, this.f18920c, this.f18921d, this.f18922e);
        subscriber.onSubscribe(mn0Var);
        xm0 xm0Var = new xm0(mn0Var, true);
        CompositeDisposable compositeDisposable = mn0Var.f22995d;
        compositeDisposable.add(xm0Var);
        xm0 xm0Var2 = new xm0(mn0Var, false);
        compositeDisposable.add(xm0Var2);
        this.source.subscribe((FlowableSubscriber<? super Object>) xm0Var);
        this.f18919b.subscribe(xm0Var2);
    }
}
