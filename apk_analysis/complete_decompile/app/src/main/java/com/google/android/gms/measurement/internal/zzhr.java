package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import p000.ub3;

/* loaded from: classes.dex */
public final class zzhr {

    /* renamed from: a */
    public final String f14218a;

    /* renamed from: b */
    public boolean f14219b;

    /* renamed from: c */
    public String f14220c;

    /* renamed from: d */
    public final /* synthetic */ ub3 f14221d;

    public zzhr(ub3 ub3Var, String str, String str2) {
        this.f14221d = ub3Var;
        Preconditions.checkNotEmpty(str);
        this.f14218a = str;
    }

    @WorkerThread
    public final String zza() {
        if (!this.f14219b) {
            this.f14219b = true;
            this.f14220c = this.f14221d.m7692b().getString(this.f14218a, null);
        }
        return this.f14220c;
    }

    @WorkerThread
    public final void zzb(String str) {
        SharedPreferences.Editor edit = this.f14221d.m7692b().edit();
        edit.putString(this.f14218a, str);
        edit.apply();
        this.f14220c = str;
    }
}
