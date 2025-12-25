package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.measurement.internal.t */
/* loaded from: classes.dex */
public final class RunnableC0824t implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ AtomicReference f14092a;

    /* renamed from: b */
    public final /* synthetic */ boolean f14093b;

    /* renamed from: c */
    public final /* synthetic */ zzlw f14094c;

    public RunnableC0824t(zzlw zzlwVar, AtomicReference atomicReference, boolean z) {
        this.f14092a = atomicReference;
        this.f14093b = z;
        this.f14094c = zzlwVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f14094c.zzu.zzu().zzJ(this.f14092a, this.f14093b);
    }
}
