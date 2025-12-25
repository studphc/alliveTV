package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.annotation.MainThread;
import p000.AbstractC1726qj;
import p000.xy1;

/* loaded from: classes.dex */
public final class zzhv implements ServiceConnection {

    /* renamed from: a */
    public final String f14222a;

    /* renamed from: b */
    public final /* synthetic */ zzhw f14223b;

    public zzhv(zzhw zzhwVar, String str) {
        this.f14223b = zzhwVar;
        this.f14222a = str;
    }

    @Override // android.content.ServiceConnection
    @MainThread
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        zzio zzioVar = this.f14223b.f14224a;
        if (iBinder != null) {
            try {
                com.google.android.gms.internal.measurement.zzbr zzb = com.google.android.gms.internal.measurement.zzbq.zzb(iBinder);
                if (zzb == null) {
                    zzioVar.zzaW().zzk().zza("Install Referrer Service implementation was not found");
                    return;
                } else {
                    zzioVar.zzaW().zzj().zza("Install Referrer Service connected");
                    zzioVar.zzaX().zzq(new xy1(this, zzb, this));
                    return;
                }
            } catch (RuntimeException e) {
                zzioVar.zzaW().zzk().zzb("Exception occurred while calling Install Referrer API", e);
                return;
            }
        }
        AbstractC1726qj.m7037B(zzioVar, "Install Referrer connection returned with null binder");
    }

    @Override // android.content.ServiceConnection
    @MainThread
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f14223b.f14224a.zzaW().zzj().zza("Install Referrer Service disconnected");
    }
}
