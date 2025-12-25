package com.google.android.gms.measurement.internal;

import java.util.concurrent.Executor;

/* renamed from: com.google.android.gms.measurement.internal.o */
/* loaded from: classes.dex */
public final class ExecutorC0815o implements Executor {

    /* renamed from: a */
    public final /* synthetic */ zzlw f14068a;

    public ExecutorC0815o(zzlw zzlwVar) {
        this.f14068a = zzlwVar;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f14068a.zzu.zzaX().zzq(runnable);
    }
}
