package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ClosingFuture;

/* renamed from: com.google.common.util.concurrent.o0 */
/* loaded from: classes2.dex */
public final class C1011o0 implements ClosingFuture.Combiner.AsyncCombiningCallable {

    /* renamed from: a */
    public final /* synthetic */ ClosingFuture.Combiner4.AsyncClosingFunction4 f15411a;

    /* renamed from: b */
    public final /* synthetic */ ClosingFuture.Combiner4 f15412b;

    public C1011o0(ClosingFuture.Combiner4 combiner4, ClosingFuture.Combiner4.AsyncClosingFunction4 asyncClosingFunction4) {
        this.f15412b = combiner4;
        this.f15411a = asyncClosingFunction4;
    }

    @Override // com.google.common.util.concurrent.ClosingFuture.Combiner.AsyncCombiningCallable
    public final ClosingFuture call(ClosingFuture.DeferredCloser deferredCloser, ClosingFuture.Peeker peeker) {
        ClosingFuture.Combiner4 combiner4 = this.f15412b;
        return this.f15411a.apply(deferredCloser, peeker.getDone(combiner4.f15295d), peeker.getDone(combiner4.f15296e), peeker.getDone(combiner4.f15297f), peeker.getDone(combiner4.f15298g));
    }

    public final String toString() {
        return this.f15411a.toString();
    }
}
