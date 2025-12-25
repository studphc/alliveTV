package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ClosingFuture;

/* renamed from: com.google.common.util.concurrent.m0 */
/* loaded from: classes2.dex */
public final class C1007m0 implements ClosingFuture.Combiner.AsyncCombiningCallable {

    /* renamed from: a */
    public final /* synthetic */ ClosingFuture.Combiner3.AsyncClosingFunction3 f15404a;

    /* renamed from: b */
    public final /* synthetic */ ClosingFuture.Combiner3 f15405b;

    public C1007m0(ClosingFuture.Combiner3 combiner3, ClosingFuture.Combiner3.AsyncClosingFunction3 asyncClosingFunction3) {
        this.f15405b = combiner3;
        this.f15404a = asyncClosingFunction3;
    }

    @Override // com.google.common.util.concurrent.ClosingFuture.Combiner.AsyncCombiningCallable
    public final ClosingFuture call(ClosingFuture.DeferredCloser deferredCloser, ClosingFuture.Peeker peeker) {
        ClosingFuture.Combiner3 combiner3 = this.f15405b;
        return this.f15404a.apply(deferredCloser, peeker.getDone(combiner3.f15292d), peeker.getDone(combiner3.f15293e), peeker.getDone(combiner3.f15294f));
    }

    public final String toString() {
        return this.f15404a.toString();
    }
}
