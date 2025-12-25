package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import p000.ub3;

/* loaded from: classes.dex */
public final class zzhn {

    /* renamed from: a */
    public final String f14199a;

    /* renamed from: b */
    public final boolean f14200b;

    /* renamed from: c */
    public boolean f14201c;

    /* renamed from: d */
    public boolean f14202d;

    /* renamed from: e */
    public final /* synthetic */ ub3 f14203e;

    public zzhn(ub3 ub3Var, String str, boolean z) {
        this.f14203e = ub3Var;
        Preconditions.checkNotEmpty(str);
        this.f14199a = str;
        this.f14200b = z;
    }

    @WorkerThread
    public final void zza(boolean z) {
        SharedPreferences.Editor edit = this.f14203e.m7692b().edit();
        edit.putBoolean(this.f14199a, z);
        edit.apply();
        this.f14202d = z;
    }

    @WorkerThread
    public final boolean zzb() {
        if (!this.f14201c) {
            this.f14201c = true;
            this.f14202d = this.f14203e.m7692b().getBoolean(this.f14199a, this.f14200b);
        }
        return this.f14202d;
    }
}
