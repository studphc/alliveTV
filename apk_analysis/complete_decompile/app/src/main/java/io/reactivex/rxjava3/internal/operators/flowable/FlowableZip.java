package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import p000.ms0;
import p000.ns0;

/* loaded from: classes2.dex */
public final class FlowableZip<T, R> extends Flowable<R> {

    /* renamed from: b */
    public final Publisher[] f19092b;

    /* renamed from: c */
    public final Iterable f19093c;

    /* renamed from: d */
    public final Function f19094d;

    /* renamed from: e */
    public final int f19095e;

    /* renamed from: f */
    public final boolean f19096f;

    public FlowableZip(Publisher<? extends T>[] publisherArr, Iterable<? extends Publisher<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i, boolean z) {
        this.f19092b = publisherArr;
        this.f19093c = iterable;
        this.f19094d = function;
        this.f19095e = i;
        this.f19096f = z;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        int length;
        Publisher[] publisherArr = this.f19092b;
        if (publisherArr == null) {
            publisherArr = new Publisher[8];
            length = 0;
            for (Publisher publisher : this.f19093c) {
                if (length == publisherArr.length) {
                    Publisher[] publisherArr2 = new Publisher[(length >> 2) + length];
                    System.arraycopy(publisherArr, 0, publisherArr2, 0, length);
                    publisherArr = publisherArr2;
                }
                publisherArr[length] = publisher;
                length++;
            }
        } else {
            length = publisherArr.length;
        }
        int i = length;
        if (i == 0) {
            EmptySubscription.complete(subscriber);
            return;
        }
        ms0 ms0Var = new ms0(subscriber, this.f19094d, this.f19096f, i, this.f19095e);
        subscriber.onSubscribe(ms0Var);
        ns0[] ns0VarArr = ms0Var.f23094b;
        for (int i2 = 0; i2 < i && !ms0Var.f23099g; i2++) {
            if (ms0Var.f23098f || ms0Var.f23097e.get() == null) {
                publisherArr[i2].subscribe(ns0VarArr[i2]);
            } else {
                return;
            }
        }
    }
}
