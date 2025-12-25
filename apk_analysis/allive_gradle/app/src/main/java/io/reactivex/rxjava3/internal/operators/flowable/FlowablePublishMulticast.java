package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import java.util.Objects;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.no0;
import p000.po0;

/* loaded from: classes2.dex */
public final class FlowablePublishMulticast<T, R> extends AbstractC1215g0 {

    /* renamed from: b */
    public final Function f18960b;

    /* renamed from: c */
    public final int f18961c;

    /* renamed from: d */
    public final boolean f18962d;

    public FlowablePublishMulticast(Flowable<T> flowable, Function<? super Flowable<T>, ? extends Publisher<? extends R>> function, int i, boolean z) {
        super(flowable);
        this.f18960b = function;
        this.f18961c = i;
        this.f18962d = z;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        no0 no0Var = new no0(this.f18961c, this.f18962d);
        try {
            Object apply = this.f18960b.apply(no0Var);
            Objects.requireNonNull(apply, "selector returned a null Publisher");
            ((Publisher) apply).subscribe(new po0(subscriber, no0Var));
            this.source.subscribe((FlowableSubscriber<? super Object>) no0Var);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
