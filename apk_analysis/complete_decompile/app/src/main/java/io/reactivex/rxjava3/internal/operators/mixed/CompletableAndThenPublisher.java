package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Flowable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import p000.C1096cs;

/* loaded from: classes2.dex */
public final class CompletableAndThenPublisher<R> extends Flowable<R> {

    /* renamed from: b */
    public final CompletableSource f19232b;

    /* renamed from: c */
    public final Publisher f19233c;

    public CompletableAndThenPublisher(CompletableSource completableSource, Publisher<? extends R> publisher) {
        this.f19232b = completableSource;
        this.f19233c = publisher;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.f19232b.subscribe(new C1096cs(this.f19233c, subscriber));
    }
}
