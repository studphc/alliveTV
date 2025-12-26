package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ClosingFuture;

/* renamed from: com.google.common.util.concurrent.b0 */
/* loaded from: classes2.dex */
public final class C0980b0 implements AsyncFunction {

    /* renamed from: a */
    public final /* synthetic */ ClosingFuture.AsyncClosingFunction f15351a;

    /* renamed from: b */
    public final /* synthetic */ ClosingFuture f15352b;

    public C0980b0(ClosingFuture closingFuture, ClosingFuture.AsyncClosingFunction asyncClosingFunction) {
        this.f15352b = closingFuture;
        this.f15351a = asyncClosingFunction;
    }

    @Override // com.google.common.util.concurrent.AsyncFunction
    public final ListenableFuture apply(Object obj) {
        return this.f15352b.f15285b.m4349c(this.f15351a, obj);
    }

    public final String toString() {
        return this.f15351a.toString();
    }
}
