package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import io.reactivex.rxjava3.subscribers.DefaultSubscriber;
import java.util.Iterator;
import p000.C1982xg;

/* loaded from: classes2.dex */
public final class BlockingFlowableMostRecent<T> implements Iterable<T> {

    /* renamed from: a */
    public final Flowable f18727a;

    /* renamed from: b */
    public final Object f18728b;

    public BlockingFlowableMostRecent(Flowable<T> flowable, T t) {
        this.f18727a = flowable;
        this.f18728b = t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [io.reactivex.rxjava3.core.FlowableSubscriber, io.reactivex.rxjava3.subscribers.DefaultSubscriber, java.lang.Object, yg] */
    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        Object obj = this.f18728b;
        ?? defaultSubscriber = new DefaultSubscriber();
        defaultSubscriber.f28943b = NotificationLite.next(obj);
        this.f18727a.subscribe((FlowableSubscriber) defaultSubscriber);
        return new C1982xg(0, (Object) defaultSubscriber);
    }
}
