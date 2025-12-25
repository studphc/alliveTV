package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.functions.Supplier;
import java.util.Collection;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.ti0;
import p000.ui0;
import p000.vi0;

/* loaded from: classes2.dex */
public final class FlowableBuffer<T, C extends Collection<? super T>> extends AbstractC1215g0 {

    /* renamed from: b */
    public final int f18742b;

    /* renamed from: c */
    public final int f18743c;

    /* renamed from: d */
    public final Supplier f18744d;

    public FlowableBuffer(Flowable<T> flowable, int i, int i2, Supplier<C> supplier) {
        super(flowable);
        this.f18742b = i;
        this.f18743c = i2;
        this.f18744d = supplier;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super C> subscriber) {
        Supplier supplier = this.f18744d;
        int i = this.f18742b;
        int i2 = this.f18743c;
        if (i == i2) {
            this.source.subscribe((FlowableSubscriber<? super Object>) new ti0(subscriber, i, supplier));
        } else if (i2 > i) {
            this.source.subscribe((FlowableSubscriber<? super Object>) new vi0(subscriber, i, i2, supplier));
        } else {
            this.source.subscribe((FlowableSubscriber<? super Object>) new ui0(subscriber, i, i2, supplier));
        }
    }
}
