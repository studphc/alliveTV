package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ClosingFuture;

/* renamed from: com.google.common.util.concurrent.n0 */
/* loaded from: classes2.dex */
public final class C1009n0 implements ClosingFuture.Combiner.CombiningCallable {

    /* renamed from: a */
    public final /* synthetic */ ClosingFuture.Combiner4.ClosingFunction4 f15408a;

    /* renamed from: b */
    public final /* synthetic */ ClosingFuture.Combiner4 f15409b;

    public C1009n0(ClosingFuture.Combiner4 combiner4, ClosingFuture.Combiner4.ClosingFunction4 closingFunction4) {
        this.f15409b = combiner4;
        this.f15408a = closingFunction4;
    }

    @Override // com.google.common.util.concurrent.ClosingFuture.Combiner.CombiningCallable
    public final Object call(ClosingFuture.DeferredCloser deferredCloser, ClosingFuture.Peeker peeker) {
        ClosingFuture.Combiner4 combiner4 = this.f15409b;
        return this.f15408a.apply(deferredCloser, peeker.getDone(combiner4.f15295d), peeker.getDone(combiner4.f15296e), peeker.getDone(combiner4.f15297f), peeker.getDone(combiner4.f15298g));
    }

    public final String toString() {
        return this.f15408a.toString();
    }
}
