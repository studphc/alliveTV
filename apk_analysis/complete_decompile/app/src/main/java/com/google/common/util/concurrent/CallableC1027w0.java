package com.google.common.util.concurrent;

import java.util.concurrent.Callable;

/* renamed from: com.google.common.util.concurrent.w0 */
/* loaded from: classes2.dex */
public final class CallableC1027w0 implements Callable {

    /* renamed from: a */
    public final /* synthetic */ Runnable f15439a;

    public CallableC1027w0(Runnable runnable) {
        this.f15439a = runnable;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        this.f15439a.run();
        return null;
    }
}
