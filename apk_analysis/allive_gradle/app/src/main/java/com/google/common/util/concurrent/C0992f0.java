package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ClosingFuture;
import java.io.Closeable;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

/* renamed from: com.google.common.util.concurrent.f0 */
/* loaded from: classes2.dex */
public final class C0992f0 extends IdentityHashMap implements Closeable {

    /* renamed from: a */
    public final ClosingFuture.DeferredCloser f15377a = new ClosingFuture.DeferredCloser(this);

    /* renamed from: b */
    public volatile boolean f15378b;

    /* renamed from: a */
    public final void m4348a(Closeable closeable, Executor executor) {
        Preconditions.checkNotNull(executor);
        if (closeable == null) {
            return;
        }
        synchronized (this) {
            try {
                if (!this.f15378b) {
                    put(closeable, executor);
                } else {
                    ClosingFuture.m4320c(closeable, executor);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: c */
    public final FluentFuture m4349c(ClosingFuture.AsyncClosingFunction asyncClosingFunction, Object obj) {
        C0992f0 c0992f0 = new C0992f0();
        try {
            ClosingFuture apply = asyncClosingFunction.apply(c0992f0.f15377a, obj);
            Logger logger = ClosingFuture.f15283d;
            apply.m4321a(c0992f0);
            return apply.f15286c;
        } finally {
            m4348a(c0992f0, MoreExecutors.directExecutor());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f15378b) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f15378b) {
                    return;
                }
                this.f15378b = true;
                Iterator it = entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    ClosingFuture.m4320c((Closeable) entry.getKey(), (Executor) entry.getValue());
                }
                clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: e */
    public final ListenableFuture m4350e(ClosingFuture.ClosingFunction closingFunction, Object obj) {
        C0992f0 c0992f0 = new C0992f0();
        try {
            return Futures.immediateFuture(closingFunction.apply(c0992f0.f15377a, obj));
        } finally {
            m4348a(c0992f0, MoreExecutors.directExecutor());
        }
    }
}
