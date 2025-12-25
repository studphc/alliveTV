package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import p000.qi0;
import p000.ri0;

/* loaded from: classes2.dex */
public final class FlowableAmb<T> extends Flowable<T> {

    /* renamed from: b */
    public final Publisher[] f18733b;

    /* renamed from: c */
    public final Iterable f18734c;

    public FlowableAmb(Publisher<? extends T>[] publisherArr, Iterable<? extends Publisher<? extends T>> iterable) {
        this.f18733b = publisherArr;
        this.f18734c = iterable;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        int length;
        Subscriber subscriber2;
        Publisher[] publisherArr = this.f18733b;
        if (publisherArr == null) {
            publisherArr = new Publisher[8];
            try {
                length = 0;
                for (Publisher publisher : this.f18734c) {
                    if (publisher == null) {
                        EmptySubscription.error(new NullPointerException("One of the sources is null"), subscriber);
                        return;
                    }
                    if (length == publisherArr.length) {
                        Publisher[] publisherArr2 = new Publisher[(length >> 2) + length];
                        System.arraycopy(publisherArr, 0, publisherArr2, 0, length);
                        publisherArr = publisherArr2;
                    }
                    int i = length + 1;
                    publisherArr[length] = publisher;
                    length = i;
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptySubscription.error(th, subscriber);
                return;
            }
        } else {
            length = publisherArr.length;
        }
        if (length == 0) {
            EmptySubscription.complete(subscriber);
            return;
        }
        if (length == 1) {
            publisherArr[0].subscribe(subscriber);
            return;
        }
        qi0 qi0Var = new qi0(subscriber, length);
        ri0[] ri0VarArr = qi0Var.f25598b;
        int length2 = ri0VarArr.length;
        int i2 = 0;
        while (true) {
            subscriber2 = qi0Var.f25597a;
            if (i2 >= length2) {
                break;
            }
            int i3 = i2 + 1;
            ri0VarArr[i2] = new ri0(qi0Var, i3, subscriber2);
            i2 = i3;
        }
        AtomicInteger atomicInteger = qi0Var.f25599c;
        atomicInteger.lazySet(0);
        subscriber2.onSubscribe(qi0Var);
        for (int i4 = 0; i4 < length2 && atomicInteger.get() == 0; i4++) {
            publisherArr[i4].subscribe(ri0VarArr[i4]);
        }
    }
}
