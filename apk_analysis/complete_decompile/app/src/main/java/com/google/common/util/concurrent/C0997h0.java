package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ClosingFuture;
import java.util.logging.Logger;

/* renamed from: com.google.common.util.concurrent.h0 */
/* loaded from: classes2.dex */
public final class C0997h0 implements AsyncCallable {

    /* renamed from: a */
    public final /* synthetic */ ClosingFuture.Combiner.AsyncCombiningCallable f15393a;

    /* renamed from: b */
    public final /* synthetic */ ClosingFuture.Combiner f15394b;

    public C0997h0(ClosingFuture.Combiner combiner, ClosingFuture.Combiner.AsyncCombiningCallable asyncCombiningCallable) {
        this.f15394b = combiner;
        this.f15393a = asyncCombiningCallable;
    }

    @Override // com.google.common.util.concurrent.AsyncCallable
    public final ListenableFuture call() {
        ClosingFuture.Peeker peeker = new ClosingFuture.Peeker(this.f15394b.inputs);
        ClosingFuture.Combiner.AsyncCombiningCallable asyncCombiningCallable = this.f15393a;
        C0992f0 c0992f0 = this.f15394b.f15288a;
        peeker.f15306b = true;
        C0992f0 c0992f02 = new C0992f0();
        try {
            ClosingFuture call = asyncCombiningCallable.call(c0992f02.f15377a, peeker);
            Logger logger = ClosingFuture.f15283d;
            call.m4321a(c0992f0);
            return call.f15286c;
        } finally {
            c0992f0.m4348a(c0992f02, MoreExecutors.directExecutor());
            peeker.f15306b = false;
        }
    }

    public final String toString() {
        return this.f15393a.toString();
    }
}
