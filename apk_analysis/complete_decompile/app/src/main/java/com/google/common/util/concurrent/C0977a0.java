package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ClosingFuture;

/* renamed from: com.google.common.util.concurrent.a0 */
/* loaded from: classes2.dex */
public final class C0977a0 implements AsyncFunction {

    /* renamed from: a */
    public final /* synthetic */ ClosingFuture.ClosingFunction f15348a;

    /* renamed from: b */
    public final /* synthetic */ ClosingFuture f15349b;

    public C0977a0(ClosingFuture closingFuture, ClosingFuture.ClosingFunction closingFunction) {
        this.f15349b = closingFuture;
        this.f15348a = closingFunction;
    }

    @Override // com.google.common.util.concurrent.AsyncFunction
    public final ListenableFuture apply(Object obj) {
        return this.f15349b.f15285b.m4350e(this.f15348a, obj);
    }

    public final String toString() {
        return this.f15348a.toString();
    }
}
