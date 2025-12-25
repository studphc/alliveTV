package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ClosingFuture;

/* renamed from: com.google.common.util.concurrent.l0 */
/* loaded from: classes2.dex */
public final class C1005l0 implements ClosingFuture.Combiner.CombiningCallable {

    /* renamed from: a */
    public final /* synthetic */ ClosingFuture.Combiner3.ClosingFunction3 f15401a;

    /* renamed from: b */
    public final /* synthetic */ ClosingFuture.Combiner3 f15402b;

    public C1005l0(ClosingFuture.Combiner3 combiner3, ClosingFuture.Combiner3.ClosingFunction3 closingFunction3) {
        this.f15402b = combiner3;
        this.f15401a = closingFunction3;
    }

    @Override // com.google.common.util.concurrent.ClosingFuture.Combiner.CombiningCallable
    public final Object call(ClosingFuture.DeferredCloser deferredCloser, ClosingFuture.Peeker peeker) {
        ClosingFuture.Combiner3 combiner3 = this.f15402b;
        return this.f15401a.apply(deferredCloser, peeker.getDone(combiner3.f15292d), peeker.getDone(combiner3.f15293e), peeker.getDone(combiner3.f15294f));
    }

    public final String toString() {
        return this.f15401a.toString();
    }
}
