package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ClosingFuture;
import java.util.concurrent.Callable;

/* renamed from: com.google.common.util.concurrent.y */
/* loaded from: classes2.dex */
public final class CallableC1030y implements Callable {

    /* renamed from: a */
    public final /* synthetic */ ClosingFuture.ClosingCallable f15443a;

    /* renamed from: b */
    public final /* synthetic */ ClosingFuture f15444b;

    public CallableC1030y(ClosingFuture closingFuture, ClosingFuture.ClosingCallable closingCallable) {
        this.f15444b = closingFuture;
        this.f15443a = closingCallable;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.f15443a.call(this.f15444b.f15285b.f15377a);
    }

    public final String toString() {
        return this.f15443a.toString();
    }
}
