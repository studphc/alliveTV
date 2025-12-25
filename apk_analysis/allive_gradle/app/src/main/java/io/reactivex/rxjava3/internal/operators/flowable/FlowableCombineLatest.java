package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import java.util.Objects;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import p000.kl0;
import p000.lj0;
import p000.mj0;
import p000.nj0;

/* loaded from: classes2.dex */
public final class FlowableCombineLatest<T, R> extends Flowable<R> {

    /* renamed from: b */
    public final Publisher[] f18773b;

    /* renamed from: c */
    public final Iterable f18774c;

    /* renamed from: d */
    public final Function f18775d;

    /* renamed from: e */
    public final int f18776e;

    /* renamed from: f */
    public final boolean f18777f;

    public FlowableCombineLatest(@NonNull Publisher<? extends T>[] publisherArr, @NonNull Function<? super Object[], ? extends R> function, int i, boolean z) {
        this.f18773b = publisherArr;
        this.f18774c = null;
        this.f18775d = function;
        this.f18776e = i;
        this.f18777f = z;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        int length;
        Publisher[] publisherArr = this.f18773b;
        if (publisherArr == null) {
            publisherArr = new Publisher[8];
            try {
                length = 0;
                for (Publisher publisher : this.f18774c) {
                    if (length == publisherArr.length) {
                        Publisher[] publisherArr2 = new Publisher[(length >> 2) + length];
                        System.arraycopy(publisherArr, 0, publisherArr2, 0, length);
                        publisherArr = publisherArr2;
                    }
                    int i = length + 1;
                    Objects.requireNonNull(publisher, "The Iterator returned a null Publisher");
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
        int i2 = length;
        if (i2 == 0) {
            EmptySubscription.complete(subscriber);
            return;
        }
        if (i2 == 1) {
            publisherArr[0].subscribe(new kl0(subscriber, new nj0(0, this), 1));
            return;
        }
        lj0 lj0Var = new lj0(subscriber, this.f18775d, this.f18777f, i2, this.f18776e);
        subscriber.onSubscribe(lj0Var);
        mj0[] mj0VarArr = lj0Var.f22522c;
        for (int i3 = 0; i3 < i2 && !lj0Var.f22531l && !lj0Var.f22529j; i3++) {
            publisherArr[i3].subscribe(mj0VarArr[i3]);
        }
    }

    public FlowableCombineLatest(@NonNull Iterable<? extends Publisher<? extends T>> iterable, @NonNull Function<? super Object[], ? extends R> function, int i, boolean z) {
        this.f18773b = null;
        this.f18774c = iterable;
        this.f18775d = function;
        this.f18776e = i;
        this.f18777f = z;
    }
}
