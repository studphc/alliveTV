package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableOnSubscribe;
import io.reactivex.rxjava3.exceptions.Exceptions;
import org.reactivestreams.Subscriber;
import p000.mk0;
import p000.nk0;
import p000.ok0;
import p000.rk0;

/* loaded from: classes2.dex */
public final class FlowableCreate<T> extends Flowable<T> {

    /* renamed from: b */
    public final FlowableOnSubscribe f18800b;

    /* renamed from: c */
    public final BackpressureStrategy f18801c;

    public FlowableCreate(FlowableOnSubscribe<T> flowableOnSubscribe, BackpressureStrategy backpressureStrategy) {
        this.f18800b = flowableOnSubscribe;
        this.f18801c = backpressureStrategy;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        nk0 nk0Var;
        int i = mk0.f22970a[this.f18801c.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        nk0Var = new ok0(subscriber, Flowable.bufferSize());
                    } else {
                        nk0Var = new rk0(subscriber);
                    }
                } else {
                    nk0Var = new nk0(subscriber);
                }
            } else {
                nk0Var = new nk0(subscriber);
            }
        } else {
            nk0Var = new nk0(subscriber);
        }
        subscriber.onSubscribe(nk0Var);
        try {
            this.f18800b.subscribe(nk0Var);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            nk0Var.onError(th);
        }
    }
}
