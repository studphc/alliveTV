package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.Callable;
import p000.CallableC1838tk;
import p000.RunnableC0583c7;

@GwtCompatible(emulated = true)
/* loaded from: classes2.dex */
public final class Callables {
    /* renamed from: a */
    public static RunnableC0583c7 m4318a(Runnable runnable, Supplier supplier) {
        Preconditions.checkNotNull(supplier);
        Preconditions.checkNotNull(runnable);
        return new RunnableC0583c7(5, supplier, runnable);
    }

    @Beta
    @GwtIncompatible
    public static <T> AsyncCallable<T> asAsyncCallable(final Callable<T> callable, final ListeningExecutorService listeningExecutorService) {
        Preconditions.checkNotNull(callable);
        Preconditions.checkNotNull(listeningExecutorService);
        return new AsyncCallable() { // from class: sk
            @Override // com.google.common.util.concurrent.AsyncCallable
            public final ListenableFuture call() {
                return ListeningExecutorService.this.submit(callable);
            }
        };
    }

    /* renamed from: b */
    public static boolean m4319b(String str, Thread thread) {
        try {
            thread.setName(str);
            return true;
        } catch (SecurityException unused) {
            return false;
        }
    }

    public static <T> Callable<T> returning(T t) {
        return new CallableC1838tk(0, t);
    }
}
