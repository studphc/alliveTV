package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.functions.Function;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.jr0;
import p000.kr0;
import p000.mr0;

/* loaded from: classes2.dex */
public final class FlowableTimeout<T, U, V> extends AbstractC1215g0 {

    /* renamed from: b */
    public final Publisher f19054b;

    /* renamed from: c */
    public final Function f19055c;

    /* renamed from: d */
    public final Publisher f19056d;

    public FlowableTimeout(Flowable<T> flowable, Publisher<U> publisher, Function<? super T, ? extends Publisher<V>> function, Publisher<? extends T> publisher2) {
        super(flowable);
        this.f19054b = publisher;
        this.f19055c = function;
        this.f19056d = publisher2;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        Publisher publisher = this.f19054b;
        Function function = this.f19055c;
        Publisher publisher2 = this.f19056d;
        if (publisher2 == null) {
            mr0 mr0Var = new mr0(subscriber, function);
            subscriber.onSubscribe(mr0Var);
            if (publisher != null) {
                jr0 jr0Var = new jr0(0L, mr0Var);
                if (mr0Var.f23081c.replace(jr0Var)) {
                    publisher.subscribe(jr0Var);
                }
            }
            this.source.subscribe((FlowableSubscriber<? super Object>) mr0Var);
            return;
        }
        kr0 kr0Var = new kr0(publisher2, subscriber, function);
        subscriber.onSubscribe(kr0Var);
        if (publisher != null) {
            jr0 jr0Var2 = new jr0(0L, kr0Var);
            if (kr0Var.f22167j.replace(jr0Var2)) {
                publisher.subscribe(jr0Var2);
            }
        }
        this.source.subscribe((FlowableSubscriber<? super Object>) kr0Var);
    }
}
