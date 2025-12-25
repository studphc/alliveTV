package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.util.Pair;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import p000.ub3;

/* loaded from: classes.dex */
public final class zzhq {

    /* renamed from: a */
    public final String f14213a;

    /* renamed from: b */
    public final String f14214b;

    /* renamed from: c */
    public final String f14215c;

    /* renamed from: d */
    public final long f14216d;

    /* renamed from: e */
    public final /* synthetic */ ub3 f14217e;

    public /* synthetic */ zzhq(ub3 ub3Var, long j) {
        boolean z;
        this.f14217e = ub3Var;
        Preconditions.checkNotEmpty("health_monitor");
        if (j > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        this.f14213a = "health_monitor:start";
        this.f14214b = "health_monitor:count";
        this.f14215c = "health_monitor:value";
        this.f14216d = j;
    }

    /* renamed from: a */
    public final void m3534a() {
        ub3 ub3Var = this.f14217e;
        ub3Var.zzg();
        long currentTimeMillis = ub3Var.zzu.zzaU().currentTimeMillis();
        SharedPreferences.Editor edit = ub3Var.m7692b().edit();
        edit.remove(this.f14214b);
        edit.remove(this.f14215c);
        edit.putLong(this.f14213a, currentTimeMillis);
        edit.apply();
    }

    @WorkerThread
    public final Pair zza() {
        long abs;
        ub3 ub3Var = this.f14217e;
        ub3Var.zzg();
        ub3Var.zzg();
        long j = ub3Var.m7692b().getLong(this.f14213a, 0L);
        if (j == 0) {
            m3534a();
            abs = 0;
        } else {
            abs = Math.abs(j - ub3Var.zzu.zzaU().currentTimeMillis());
        }
        long j2 = this.f14216d;
        if (abs < j2) {
            return null;
        }
        if (abs > j2 + j2) {
            m3534a();
            return null;
        }
        String string = ub3Var.m7692b().getString(this.f14215c, null);
        long j3 = ub3Var.m7692b().getLong(this.f14214b, 0L);
        m3534a();
        if (string != null && j3 > 0) {
            return new Pair(string, Long.valueOf(j3));
        }
        return ub3.f27192z;
    }

    @WorkerThread
    public final void zzb(String str, long j) {
        ub3 ub3Var = this.f14217e;
        ub3Var.zzg();
        if (ub3Var.m7692b().getLong(this.f14213a, 0L) == 0) {
            m3534a();
        }
        if (str == null) {
            str = "";
        }
        SharedPreferences m7692b = ub3Var.m7692b();
        String str2 = this.f14214b;
        long j2 = m7692b.getLong(str2, 0L);
        String str3 = this.f14215c;
        if (j2 <= 0) {
            SharedPreferences.Editor edit = ub3Var.m7692b().edit();
            edit.putString(str3, str);
            edit.putLong(str2, 1L);
            edit.apply();
            return;
        }
        long nextLong = ub3Var.zzu.zzw().m3727g().nextLong() & Long.MAX_VALUE;
        long j3 = j2 + 1;
        long j4 = Long.MAX_VALUE / j3;
        SharedPreferences.Editor edit2 = ub3Var.m7692b().edit();
        if (nextLong < j4) {
            edit2.putString(str3, str);
        }
        edit2.putLong(str2, j3);
        edit2.apply();
    }
}
