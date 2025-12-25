package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ClosingFuture;

/* renamed from: com.google.common.util.concurrent.q0 */
/* loaded from: classes2.dex */
public final class C1015q0 implements ClosingFuture.Combiner.AsyncCombiningCallable {

    /* renamed from: a */
    public final /* synthetic */ ClosingFuture.Combiner5.AsyncClosingFunction5 f15417a;

    /* renamed from: b */
    public final /* synthetic */ ClosingFuture.Combiner5 f15418b;

    public C1015q0(ClosingFuture.Combiner5 combiner5, ClosingFuture.Combiner5.AsyncClosingFunction5 asyncClosingFunction5) {
        this.f15418b = combiner5;
        this.f15417a = asyncClosingFunction5;
    }

    @Override // com.google.common.util.concurrent.ClosingFuture.Combiner.AsyncCombiningCallable
    public final ClosingFuture call(ClosingFuture.DeferredCloser deferredCloser, ClosingFuture.Peeker peeker) {
        ClosingFuture.Combiner5 combiner5 = this.f15418b;
        return this.f15417a.apply(deferredCloser, peeker.getDone(combiner5.f15299d), peeker.getDone(combiner5.f15300e), peeker.getDone(combiner5.f15301f), peeker.getDone(combiner5.f15302g), peeker.getDone(combiner5.f15303h));
    }

    public final String toString() {
        return this.f15417a.toString();
    }
}
