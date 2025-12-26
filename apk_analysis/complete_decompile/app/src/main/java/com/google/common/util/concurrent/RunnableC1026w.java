package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ClosingFuture;
import java.util.logging.Logger;

/* renamed from: com.google.common.util.concurrent.w */
/* loaded from: classes2.dex */
public final class RunnableC1026w implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ ClosingFuture.ValueAndCloserConsumer f15437a;

    /* renamed from: b */
    public final /* synthetic */ ClosingFuture f15438b;

    public RunnableC1026w(ClosingFuture closingFuture, ClosingFuture.ValueAndCloserConsumer valueAndCloserConsumer) {
        this.f15438b = closingFuture;
        this.f15437a = valueAndCloserConsumer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Logger logger = ClosingFuture.f15283d;
        this.f15437a.accept(new ClosingFuture.ValueAndCloser(this.f15438b));
    }
}
