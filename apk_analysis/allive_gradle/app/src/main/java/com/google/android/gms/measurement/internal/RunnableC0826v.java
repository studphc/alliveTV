package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;
import p000.mb3;

/* renamed from: com.google.android.gms.measurement.internal.v */
/* loaded from: classes.dex */
public final class RunnableC0826v implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f14098a;

    /* renamed from: b */
    public final /* synthetic */ String f14099b;

    /* renamed from: c */
    public final /* synthetic */ Object f14100c;

    /* renamed from: d */
    public final /* synthetic */ Object f14101d;

    /* renamed from: e */
    public final /* synthetic */ mb3 f14102e;

    public /* synthetic */ RunnableC0826v(mb3 mb3Var, Object obj, String str, Object obj2, int i) {
        this.f14098a = i;
        this.f14100c = obj;
        this.f14099b = str;
        this.f14101d = obj2;
        this.f14102e = mb3Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzgl zzglVar;
        switch (this.f14098a) {
            case 0:
                ((zzlw) this.f14102e).zzu.zzu().zzG((AtomicReference) this.f14100c, null, this.f14099b, (String) this.f14101d);
                return;
            default:
                com.google.android.gms.internal.measurement.zzcy zzcyVar = (com.google.android.gms.internal.measurement.zzcy) this.f14101d;
                zzny zznyVar = (zzny) this.f14102e;
                byte[] bArr = null;
                try {
                    try {
                        zzglVar = zznyVar.f14338c;
                    } catch (RemoteException e) {
                        zznyVar.zzu.zzaW().zze().zzb("Failed to send event to the service to bundle", e);
                    }
                    if (zzglVar == null) {
                        zzio zzioVar = zznyVar.zzu;
                        zzioVar.zzaW().zze().zza("Discarding data. Failed to send event to service to bundle");
                        zzioVar.zzw().zzW(zzcyVar, null);
                        return;
                    } else {
                        bArr = zzglVar.zzD((zzbh) this.f14100c, this.f14099b);
                        zznyVar.m3589g();
                        return;
                    }
                } finally {
                    zznyVar.zzu.zzw().zzW(zzcyVar, null);
                }
        }
    }
}
