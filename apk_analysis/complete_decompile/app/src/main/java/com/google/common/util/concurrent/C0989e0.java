package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ClosingFuture;

/* renamed from: com.google.common.util.concurrent.e0 */
/* loaded from: classes2.dex */
public final class C0989e0 implements AsyncFunction {

    /* renamed from: a */
    public final /* synthetic */ ClosingFuture.AsyncClosingFunction f15371a;

    /* renamed from: b */
    public final /* synthetic */ ClosingFuture f15372b;

    public C0989e0(ClosingFuture closingFuture, ClosingFuture.AsyncClosingFunction asyncClosingFunction) {
        this.f15372b = closingFuture;
        this.f15371a = asyncClosingFunction;
    }

    @Override // com.google.common.util.concurrent.AsyncFunction
    public final ListenableFuture apply(Object obj) {
        return this.f15372b.f15285b.m4349c(this.f15371a, (Throwable) obj);
    }

    public final String toString() {
        return this.f15371a.toString();
    }
}
