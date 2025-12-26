package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ClosingFuture;
import java.util.concurrent.Callable;

/* renamed from: com.google.common.util.concurrent.g0 */
/* loaded from: classes2.dex */
public final class CallableC0995g0 implements Callable {

    /* renamed from: a */
    public final /* synthetic */ ClosingFuture.Combiner.CombiningCallable f15390a;

    /* renamed from: b */
    public final /* synthetic */ ClosingFuture.Combiner f15391b;

    public CallableC0995g0(ClosingFuture.Combiner combiner, ClosingFuture.Combiner.CombiningCallable combiningCallable) {
        this.f15391b = combiner;
        this.f15390a = combiningCallable;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        ClosingFuture.Peeker peeker = new ClosingFuture.Peeker(this.f15391b.inputs);
        ClosingFuture.Combiner.CombiningCallable combiningCallable = this.f15390a;
        C0992f0 c0992f0 = this.f15391b.f15288a;
        peeker.f15306b = true;
        C0992f0 c0992f02 = new C0992f0();
        try {
            return combiningCallable.call(c0992f02.f15377a, peeker);
        } finally {
            c0992f0.m4348a(c0992f02, MoreExecutors.directExecutor());
            peeker.f15306b = false;
        }
    }

    public final String toString() {
        return this.f15390a.toString();
    }
}
