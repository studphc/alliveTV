package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ClosingFuture;

/* renamed from: com.google.common.util.concurrent.d0 */
/* loaded from: classes2.dex */
public final class C0986d0 implements AsyncFunction {

    /* renamed from: a */
    public final /* synthetic */ ClosingFuture.ClosingFunction f15365a;

    /* renamed from: b */
    public final /* synthetic */ ClosingFuture f15366b;

    public C0986d0(ClosingFuture closingFuture, ClosingFuture.ClosingFunction closingFunction) {
        this.f15366b = closingFuture;
        this.f15365a = closingFunction;
    }

    @Override // com.google.common.util.concurrent.AsyncFunction
    public final ListenableFuture apply(Object obj) {
        return this.f15366b.f15285b.m4350e(this.f15365a, (Throwable) obj);
    }

    public final String toString() {
        return this.f15365a.toString();
    }
}
