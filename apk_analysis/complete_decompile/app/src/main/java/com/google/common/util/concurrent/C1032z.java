package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ClosingFuture;

/* renamed from: com.google.common.util.concurrent.z */
/* loaded from: classes2.dex */
public final class C1032z implements AsyncCallable {

    /* renamed from: a */
    public final /* synthetic */ ClosingFuture.AsyncClosingCallable f15446a;

    /* renamed from: b */
    public final /* synthetic */ ClosingFuture f15447b;

    public C1032z(ClosingFuture closingFuture, ClosingFuture.AsyncClosingCallable asyncClosingCallable) {
        this.f15447b = closingFuture;
        this.f15446a = asyncClosingCallable;
    }

    @Override // com.google.common.util.concurrent.AsyncCallable
    public final ListenableFuture call() {
        ClosingFuture closingFuture = this.f15447b;
        C0992f0 c0992f0 = new C0992f0();
        try {
            ClosingFuture call = this.f15446a.call(c0992f0.f15377a);
            call.m4321a(closingFuture.f15285b);
            return call.f15286c;
        } finally {
            closingFuture.f15285b.m4348a(c0992f0, MoreExecutors.directExecutor());
        }
    }

    public final String toString() {
        return this.f15446a.toString();
    }
}
