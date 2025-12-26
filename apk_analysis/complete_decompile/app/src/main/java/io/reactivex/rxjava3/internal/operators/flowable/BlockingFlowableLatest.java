package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Notification;
import java.util.Iterator;
import org.reactivestreams.Publisher;
import p000.C1945wg;

/* loaded from: classes2.dex */
public final class BlockingFlowableLatest<T> implements Iterable<T> {

    /* renamed from: a */
    public final Publisher f18726a;

    public BlockingFlowableLatest(Publisher<? extends T> publisher) {
        this.f18726a = publisher;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        C1945wg c1945wg = new C1945wg();
        Flowable.fromPublisher(this.f18726a).materialize().subscribe((FlowableSubscriber<? super Notification<T>>) c1945wg);
        return c1945wg;
    }
}
