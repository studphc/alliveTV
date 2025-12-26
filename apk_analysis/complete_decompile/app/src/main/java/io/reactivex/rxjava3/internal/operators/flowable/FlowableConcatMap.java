package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.pj0;
import p000.rj0;
import p000.sj0;

/* loaded from: classes2.dex */
public final class FlowableConcatMap<T, R> extends AbstractC1215g0 {

    /* renamed from: b */
    public final Function f18780b;

    /* renamed from: c */
    public final int f18781c;

    /* renamed from: d */
    public final ErrorMode f18782d;

    public FlowableConcatMap(Flowable<T> flowable, Function<? super T, ? extends Publisher<? extends R>> function, int i, ErrorMode errorMode) {
        super(flowable);
        this.f18780b = function;
        this.f18781c = i;
        this.f18782d = errorMode;
    }

    public static <T, R> Subscriber<T> subscribe(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i, ErrorMode errorMode) {
        int i2 = pj0.f25196a[errorMode.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                return new sj0(subscriber, function, i);
            }
            return new rj0(i, function, subscriber, true);
        }
        return new rj0(i, function, subscriber, false);
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        Flowable<Object> flowable = this.source;
        Function function = this.f18780b;
        if (FlowableScalarXMap.tryScalarXMapSubscribe(flowable, subscriber, function)) {
            return;
        }
        this.source.subscribe(subscribe(subscriber, function, this.f18781c, this.f18782d));
    }
}
