package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.LongConsumer;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p000.el0;

/* loaded from: classes2.dex */
public final class ParallelPeek<T> extends ParallelFlowable<T> {

    /* renamed from: a */
    public final ParallelFlowable f19688a;

    /* renamed from: b */
    public final Consumer f19689b;

    /* renamed from: c */
    public final Consumer f19690c;

    /* renamed from: d */
    public final Consumer f19691d;

    /* renamed from: e */
    public final Action f19692e;

    /* renamed from: f */
    public final Action f19693f;

    /* renamed from: g */
    public final Consumer f19694g;

    /* renamed from: h */
    public final LongConsumer f19695h;

    /* renamed from: i */
    public final Action f19696i;

    public ParallelPeek(ParallelFlowable<T> parallelFlowable, Consumer<? super T> consumer, Consumer<? super T> consumer2, Consumer<? super Throwable> consumer3, Action action, Action action2, Consumer<? super Subscription> consumer4, LongConsumer longConsumer, Action action3) {
        this.f19688a = parallelFlowable;
        Objects.requireNonNull(consumer, "onNext is null");
        this.f19689b = consumer;
        Objects.requireNonNull(consumer2, "onAfterNext is null");
        this.f19690c = consumer2;
        Objects.requireNonNull(consumer3, "onError is null");
        this.f19691d = consumer3;
        Objects.requireNonNull(action, "onComplete is null");
        this.f19692e = action;
        Objects.requireNonNull(action2, "onAfterTerminated is null");
        this.f19693f = action2;
        Objects.requireNonNull(consumer4, "onSubscribe is null");
        this.f19694g = consumer4;
        Objects.requireNonNull(longConsumer, "onRequest is null");
        this.f19695h = longConsumer;
        Objects.requireNonNull(action3, "onCancel is null");
        this.f19696i = action3;
    }

    @Override // io.reactivex.rxjava3.parallel.ParallelFlowable
    public int parallelism() {
        return this.f19688a.parallelism();
    }

    @Override // io.reactivex.rxjava3.parallel.ParallelFlowable
    public void subscribe(Subscriber<? super T>[] subscriberArr) {
        Subscriber<?>[] onSubscribe = RxJavaPlugins.onSubscribe(this, subscriberArr);
        if (!validate(onSubscribe)) {
            return;
        }
        int length = onSubscribe.length;
        Subscriber<? super T>[] subscriberArr2 = new Subscriber[length];
        for (int i = 0; i < length; i++) {
            subscriberArr2[i] = new el0(onSubscribe[i], this, 2);
        }
        this.f19688a.subscribe(subscriberArr2);
    }
}
