package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ClosingFuture;

/* renamed from: com.google.common.util.concurrent.j0 */
/* loaded from: classes2.dex */
public final class C1001j0 implements ClosingFuture.Combiner.CombiningCallable {

    /* renamed from: a */
    public final /* synthetic */ ClosingFuture.Combiner2.ClosingFunction2 f15396a;

    /* renamed from: b */
    public final /* synthetic */ ClosingFuture.Combiner2 f15397b;

    public C1001j0(ClosingFuture.Combiner2 combiner2, ClosingFuture.Combiner2.ClosingFunction2 closingFunction2) {
        this.f15397b = combiner2;
        this.f15396a = closingFunction2;
    }

    @Override // com.google.common.util.concurrent.ClosingFuture.Combiner.CombiningCallable
    public final Object call(ClosingFuture.DeferredCloser deferredCloser, ClosingFuture.Peeker peeker) {
        ClosingFuture.Combiner2 combiner2 = this.f15397b;
        return this.f15396a.apply(deferredCloser, peeker.getDone(combiner2.f15290d), peeker.getDone(combiner2.f15291e));
    }

    public final String toString() {
        return this.f15396a.toString();
    }
}
