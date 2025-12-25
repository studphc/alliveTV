package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import p000.ub3;

/* loaded from: classes.dex */
public final class zzhp {

    /* renamed from: a */
    public final String f14208a;

    /* renamed from: b */
    public final long f14209b;

    /* renamed from: c */
    public boolean f14210c;

    /* renamed from: d */
    public long f14211d;

    /* renamed from: e */
    public final /* synthetic */ ub3 f14212e;

    public zzhp(ub3 ub3Var, String str, long j) {
        this.f14212e = ub3Var;
        Preconditions.checkNotEmpty(str);
        this.f14208a = str;
        this.f14209b = j;
    }

    @WorkerThread
    public final long zza() {
        if (!this.f14210c) {
            this.f14210c = true;
            this.f14211d = this.f14212e.m7692b().getLong(this.f14208a, this.f14209b);
        }
        return this.f14211d;
    }

    @WorkerThread
    public final void zzb(long j) {
        SharedPreferences.Editor edit = this.f14212e.m7692b().edit();
        edit.putLong(this.f14208a, j);
        edit.apply();
        this.f14211d = j;
    }
}
