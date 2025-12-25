package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.functions.Function;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.xl0;

/* loaded from: classes2.dex */
public final class FlowableFlatMapCompletable<T> extends AbstractC1215g0 {

    /* renamed from: b */
    public final Function f18843b;

    /* renamed from: c */
    public final int f18844c;

    /* renamed from: d */
    public final boolean f18845d;

    public FlowableFlatMapCompletable(Flowable<T> flowable, Function<? super T, ? extends CompletableSource> function, boolean z, int i) {
        super(flowable);
        this.f18843b = function;
        this.f18845d = z;
        this.f18844c = i;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber<? super Object>) new xl0(this.f18844c, this.f18843b, subscriber, this.f18845d));
    }
}
