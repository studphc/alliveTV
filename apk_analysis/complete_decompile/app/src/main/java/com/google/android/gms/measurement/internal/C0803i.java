package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import p000.AbstractC1726qj;

/* renamed from: com.google.android.gms.measurement.internal.i */
/* loaded from: classes.dex */
public final class C0803i extends FutureTask implements Comparable {

    /* renamed from: a */
    public final long f14035a;

    /* renamed from: b */
    public final boolean f14036b;

    /* renamed from: c */
    public final String f14037c;

    /* renamed from: d */
    public final /* synthetic */ zzil f14038d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0803i(zzil zzilVar, Runnable runnable, boolean z, String str) {
        super(runnable, null);
        this.f14038d = zzilVar;
        Preconditions.checkNotNull(str);
        long andIncrement = zzil.f14237j.getAndIncrement();
        this.f14035a = andIncrement;
        this.f14037c = str;
        this.f14036b = z;
        if (andIncrement == Long.MAX_VALUE) {
            AbstractC1726qj.m7039D(zzilVar.zzu, "Tasks index overflow");
        }
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        C0803i c0803i = (C0803i) obj;
        boolean z = c0803i.f14036b;
        boolean z2 = this.f14036b;
        if (z2 != z) {
            if (z2) {
                return -1;
            }
        } else {
            long j = this.f14035a;
            long j2 = c0803i.f14035a;
            if (j < j2) {
                return -1;
            }
            if (j <= j2) {
                this.f14038d.zzu.zzaW().zzh().zzb("Two tasks share the same index. index", Long.valueOf(j));
                return 0;
            }
        }
        return 1;
    }

    @Override // java.util.concurrent.FutureTask
    public final void setException(Throwable th) {
        this.f14038d.zzu.zzaW().zze().zzb(this.f14037c, th);
        super.setException(th);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0803i(zzil zzilVar, Callable callable, boolean z) {
        super(callable);
        this.f14038d = zzilVar;
        Preconditions.checkNotNull("Task exception on worker thread");
        long andIncrement = zzil.f14237j.getAndIncrement();
        this.f14035a = andIncrement;
        this.f14037c = "Task exception on worker thread";
        this.f14036b = z;
        if (andIncrement == Long.MAX_VALUE) {
            AbstractC1726qj.m7039D(zzilVar.zzu, "Tasks index overflow");
        }
    }
}
