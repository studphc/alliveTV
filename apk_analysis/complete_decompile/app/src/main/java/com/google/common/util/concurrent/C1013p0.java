package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ClosingFuture;

/* renamed from: com.google.common.util.concurrent.p0 */
/* loaded from: classes2.dex */
public final class C1013p0 implements ClosingFuture.Combiner.CombiningCallable {

    /* renamed from: a */
    public final /* synthetic */ ClosingFuture.Combiner5.ClosingFunction5 f15414a;

    /* renamed from: b */
    public final /* synthetic */ ClosingFuture.Combiner5 f15415b;

    public C1013p0(ClosingFuture.Combiner5 combiner5, ClosingFuture.Combiner5.ClosingFunction5 closingFunction5) {
        this.f15415b = combiner5;
        this.f15414a = closingFunction5;
    }

    @Override // com.google.common.util.concurrent.ClosingFuture.Combiner.CombiningCallable
    public final Object call(ClosingFuture.DeferredCloser deferredCloser, ClosingFuture.Peeker peeker) {
        ClosingFuture.Combiner5 combiner5 = this.f15415b;
        return this.f15414a.apply(deferredCloser, peeker.getDone(combiner5.f15299d), peeker.getDone(combiner5.f15300e), peeker.getDone(combiner5.f15301f), peeker.getDone(combiner5.f15302g), peeker.getDone(combiner5.f15303h));
    }

    public final String toString() {
        return this.f15414a.toString();
    }
}
