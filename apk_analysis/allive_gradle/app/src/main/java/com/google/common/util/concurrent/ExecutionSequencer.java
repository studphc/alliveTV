package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import p000.jz2;
import p000.la0;
import p000.ma0;
import p000.na0;
import p000.yw2;

/* loaded from: classes2.dex */
public final class ExecutionSequencer {

    /* renamed from: a */
    public final AtomicReference f15318a = new AtomicReference(Futures.immediateVoidFuture());

    /* renamed from: b */
    public jz2 f15319b = new jz2(2);

    public static ExecutionSequencer create() {
        return new ExecutionSequencer();
    }

    public <T> ListenableFuture<T> submit(Callable<T> callable, Executor executor) {
        Preconditions.checkNotNull(callable);
        Preconditions.checkNotNull(executor);
        return submitAsync(new la0(callable), executor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.util.concurrent.Executor, java.util.concurrent.atomic.AtomicReference, oa0] */
    public <T> ListenableFuture<T> submitAsync(AsyncCallable<T> asyncCallable, Executor executor) {
        Preconditions.checkNotNull(asyncCallable);
        Preconditions.checkNotNull(executor);
        final ?? atomicReference = new AtomicReference(na0.f23309a);
        atomicReference.f23679b = executor;
        atomicReference.f23678a = this;
        ma0 ma0Var = new ma0(atomicReference, asyncCallable);
        final SettableFuture create = SettableFuture.create();
        final ListenableFuture listenableFuture = (ListenableFuture) this.f15318a.getAndSet(create);
        final yw2 m8329j = yw2.m8329j(ma0Var);
        listenableFuture.addListener(m8329j, atomicReference);
        final ListenableFuture<T> nonCancellationPropagating = Futures.nonCancellationPropagating(m8329j);
        Runnable runnable = new Runnable() { // from class: ka0
            @Override // java.lang.Runnable
            public final void run() {
                yw2 yw2Var = yw2.this;
                if (yw2Var.isDone()) {
                    create.setFuture(listenableFuture);
                    return;
                }
                if (nonCancellationPropagating.isCancelled()) {
                    int i = oa0.f23677e;
                    if (atomicReference.compareAndSet(na0.f23309a, na0.f23310b)) {
                        yw2Var.cancel(false);
                    }
                }
            }
        };
        nonCancellationPropagating.addListener(runnable, MoreExecutors.directExecutor());
        m8329j.addListener(runnable, MoreExecutors.directExecutor());
        return nonCancellationPropagating;
    }
}
