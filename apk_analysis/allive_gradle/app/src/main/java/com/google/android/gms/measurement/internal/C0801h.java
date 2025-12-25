package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.lang.Thread;

/* renamed from: com.google.android.gms.measurement.internal.h */
/* loaded from: classes.dex */
public final class C0801h implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    public final String f14027a;

    /* renamed from: b */
    public final /* synthetic */ zzil f14028b;

    public C0801h(zzil zzilVar, String str) {
        this.f14028b = zzilVar;
        Preconditions.checkNotNull(str);
        this.f14027a = str;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        this.f14028b.zzu.zzaW().zze().zzb(this.f14027a, th);
    }
}
