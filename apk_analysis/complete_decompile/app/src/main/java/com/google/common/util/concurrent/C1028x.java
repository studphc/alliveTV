package com.google.common.util.concurrent;

import java.io.Closeable;
import java.util.concurrent.Executor;

/* renamed from: com.google.common.util.concurrent.x */
/* loaded from: classes2.dex */
public final class C1028x implements FutureCallback {

    /* renamed from: a */
    public final /* synthetic */ ClosingFuture f15440a;

    /* renamed from: b */
    public final /* synthetic */ Executor f15441b;

    public C1028x(ClosingFuture closingFuture, Executor executor) {
        this.f15440a = closingFuture;
        this.f15441b = executor;
    }

    @Override // com.google.common.util.concurrent.FutureCallback
    public final void onFailure(Throwable th) {
    }

    @Override // com.google.common.util.concurrent.FutureCallback
    public final void onSuccess(Object obj) {
        this.f15440a.f15285b.f15377a.eventuallyClose((Closeable) obj, this.f15441b);
    }
}
