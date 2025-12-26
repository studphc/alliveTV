package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.bk0;
import p000.dk0;
import p000.ek0;

/* loaded from: classes2.dex */
public final class FlowableConcatMapScheduler<T, R> extends AbstractC1215g0 {

    /* renamed from: b */
    public final Function f18792b;

    /* renamed from: c */
    public final int f18793c;

    /* renamed from: d */
    public final ErrorMode f18794d;

    /* renamed from: e */
    public final Scheduler f18795e;

    public FlowableConcatMapScheduler(Flowable<T> flowable, Function<? super T, ? extends Publisher<? extends R>> function, int i, ErrorMode errorMode, Scheduler scheduler) {
        super(flowable);
        this.f18792b = function;
        this.f18793c = i;
        this.f18794d = errorMode;
        this.f18795e = scheduler;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        int i = bk0.f8052a[this.f18794d.ordinal()];
        Scheduler scheduler = this.f18795e;
        if (i != 1) {
            if (i != 2) {
                this.source.subscribe((FlowableSubscriber<? super Object>) new ek0(subscriber, this.f18792b, this.f18793c, scheduler.createWorker()));
                return;
            } else {
                this.source.subscribe((FlowableSubscriber<? super Object>) new dk0(subscriber, this.f18792b, this.f18793c, true, scheduler.createWorker()));
                return;
            }
        }
        this.source.subscribe((FlowableSubscriber<? super Object>) new dk0(subscriber, this.f18792b, this.f18793c, false, scheduler.createWorker()));
    }
}
