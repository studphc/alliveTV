package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import java.util.Iterator;
import p000.RunnableC1908vg;

/* loaded from: classes2.dex */
public final class BlockingFlowableIterable<T> implements Iterable<T> {

    /* renamed from: a */
    public final Flowable f18724a;

    /* renamed from: b */
    public final int f18725b;

    public BlockingFlowableIterable(Flowable<T> flowable, int i) {
        this.f18724a = flowable;
        this.f18725b = i;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        RunnableC1908vg runnableC1908vg = new RunnableC1908vg(this.f18725b);
        this.f18724a.subscribe((FlowableSubscriber) runnableC1908vg);
        return runnableC1908vg;
    }
}
