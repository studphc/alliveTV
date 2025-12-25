package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ClosingFuture;

/* renamed from: com.google.common.util.concurrent.c0 */
/* loaded from: classes2.dex */
public final class C0983c0 implements ClosingFuture.AsyncClosingFunction {

    /* renamed from: a */
    public final /* synthetic */ AsyncFunction f15361a;

    public C0983c0(AsyncFunction asyncFunction) {
        this.f15361a = asyncFunction;
    }

    @Override // com.google.common.util.concurrent.ClosingFuture.AsyncClosingFunction
    public final ClosingFuture apply(ClosingFuture.DeferredCloser deferredCloser, Object obj) {
        return ClosingFuture.from(this.f15361a.apply(obj));
    }
}
