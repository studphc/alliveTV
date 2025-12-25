package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import p000.k22;

/* loaded from: classes2.dex */
public final class ParallelFromPublisher<T> extends ParallelFlowable<T> {

    /* renamed from: a */
    public final Publisher f19677a;

    /* renamed from: b */
    public final int f19678b;

    /* renamed from: c */
    public final int f19679c;

    public ParallelFromPublisher(Publisher<? extends T> publisher, int i, int i2) {
        this.f19677a = publisher;
        this.f19678b = i;
        this.f19679c = i2;
    }

    @Override // io.reactivex.rxjava3.parallel.ParallelFlowable
    public int parallelism() {
        return this.f19678b;
    }

    @Override // io.reactivex.rxjava3.parallel.ParallelFlowable
    public void subscribe(Subscriber<? super T>[] subscriberArr) {
        Subscriber<?>[] onSubscribe = RxJavaPlugins.onSubscribe(this, subscriberArr);
        if (!validate(onSubscribe)) {
            return;
        }
        this.f19677a.subscribe(new k22(onSubscribe, this.f19679c));
    }
}
