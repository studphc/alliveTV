package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ClosingFuture;

/* renamed from: com.google.common.util.concurrent.k0 */
/* loaded from: classes2.dex */
public final class C1003k0 implements ClosingFuture.Combiner.AsyncCombiningCallable {

    /* renamed from: a */
    public final /* synthetic */ ClosingFuture.Combiner2.AsyncClosingFunction2 f15398a;

    /* renamed from: b */
    public final /* synthetic */ ClosingFuture.Combiner2 f15399b;

    public C1003k0(ClosingFuture.Combiner2 combiner2, ClosingFuture.Combiner2.AsyncClosingFunction2 asyncClosingFunction2) {
        this.f15399b = combiner2;
        this.f15398a = asyncClosingFunction2;
    }

    @Override // com.google.common.util.concurrent.ClosingFuture.Combiner.AsyncCombiningCallable
    public final ClosingFuture call(ClosingFuture.DeferredCloser deferredCloser, ClosingFuture.Peeker peeker) {
        ClosingFuture.Combiner2 combiner2 = this.f15399b;
        return this.f15398a.apply(deferredCloser, peeker.getDone(combiner2.f15290d), peeker.getDone(combiner2.f15291e));
    }

    public final String toString() {
        return this.f15398a.toString();
    }
}
