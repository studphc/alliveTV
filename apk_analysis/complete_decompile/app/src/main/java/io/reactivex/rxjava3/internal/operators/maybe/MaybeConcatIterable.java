package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import java.util.Iterator;
import java.util.Objects;
import org.reactivestreams.Subscriber;
import p000.wh1;

/* loaded from: classes2.dex */
public final class MaybeConcatIterable<T> extends Flowable<T> {

    /* renamed from: b */
    public final Iterable f19126b;

    public MaybeConcatIterable(Iterable<? extends MaybeSource<? extends T>> iterable) {
        this.f19126b = iterable;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        try {
            Iterator<T> it = this.f19126b.iterator();
            Objects.requireNonNull(it, "The sources Iterable returned a null Iterator");
            wh1 wh1Var = new wh1(subscriber, it);
            subscriber.onSubscribe(wh1Var);
            wh1Var.m8057a();
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
