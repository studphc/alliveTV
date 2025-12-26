package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.measurement.internal.b0 */
/* loaded from: classes.dex */
public final class RunnableC0790b0 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f13988a = 0;

    /* renamed from: b */
    public final /* synthetic */ String f13989b;

    /* renamed from: c */
    public final /* synthetic */ String f13990c;

    /* renamed from: d */
    public final /* synthetic */ zzr f13991d;

    /* renamed from: e */
    public final /* synthetic */ boolean f13992e;

    /* renamed from: f */
    public final /* synthetic */ zzny f13993f;

    /* renamed from: g */
    public final /* synthetic */ Object f13994g;

    public RunnableC0790b0(zzny zznyVar, String str, String str2, zzr zzrVar, boolean z, com.google.android.gms.internal.measurement.zzcy zzcyVar) {
        this.f13989b = str;
        this.f13990c = str2;
        this.f13991d = zzrVar;
        this.f13992e = z;
        this.f13994g = zzcyVar;
        this.f13993f = zznyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bundle bundle;
        RemoteException e;
        zzio zzioVar;
        zzgl zzglVar;
        String str;
        AtomicReference atomicReference;
        zzny zznyVar;
        zzgl zzglVar2;
        switch (this.f13988a) {
            case 0:
                String str2 = this.f13989b;
                com.google.android.gms.internal.measurement.zzcy zzcyVar = (com.google.android.gms.internal.measurement.zzcy) this.f13994g;
                zzny zznyVar2 = this.f13993f;
                Bundle bundle2 = new Bundle();
                try {
                    zzglVar = zznyVar2.f14338c;
                    str = this.f13990c;
                } catch (RemoteException e2) {
                    bundle = bundle2;
                    e = e2;
                } catch (Throwable th) {
                    th = th;
                    zznyVar2.zzu.zzw().zzV(zzcyVar, bundle2);
                    throw th;
                }
                if (zzglVar == null) {
                    zzio zzioVar2 = zznyVar2.zzu;
                    zzioVar2.zzaW().zze().zzc("Failed to get user properties; not connected to service", str2, str);
                    zzioVar2.zzw().zzV(zzcyVar, bundle2);
                    return;
                }
                zzr zzrVar = this.f13991d;
                Preconditions.checkNotNull(zzrVar);
                List<zzqb> zzk = zzglVar.zzk(str2, str, this.f13992e, zzrVar);
                bundle = new Bundle();
                if (zzk != null) {
                    for (zzqb zzqbVar : zzk) {
                        String str3 = zzqbVar.zze;
                        if (str3 != null) {
                            bundle.putString(zzqbVar.zzb, str3);
                        } else {
                            Long l = zzqbVar.zzd;
                            if (l != null) {
                                bundle.putLong(zzqbVar.zzb, l.longValue());
                            } else {
                                Double d = zzqbVar.zzg;
                                if (d != null) {
                                    bundle.putDouble(zzqbVar.zzb, d.doubleValue());
                                }
                            }
                        }
                    }
                }
                try {
                    try {
                        zznyVar2.m3589g();
                        zzioVar = zznyVar2.zzu;
                    } catch (RemoteException e3) {
                        e = e3;
                        zznyVar2.zzu.zzaW().zze().zzc("Failed to get user properties; remote exception", str2, e);
                        zzioVar = zznyVar2.zzu;
                        zzioVar.zzw().zzV(zzcyVar, bundle);
                        return;
                    }
                    zzioVar.zzw().zzV(zzcyVar, bundle);
                    return;
                } catch (Throwable th2) {
                    th = th2;
                    bundle2 = bundle;
                    zznyVar2.zzu.zzw().zzV(zzcyVar, bundle2);
                    throw th;
                }
            default:
                AtomicReference atomicReference2 = (AtomicReference) this.f13994g;
                synchronized (atomicReference2) {
                    try {
                        try {
                            zznyVar = this.f13993f;
                            zzglVar2 = zznyVar.f14338c;
                        } catch (RemoteException e4) {
                            this.f13993f.zzu.zzaW().zze().zzd("(legacy) Failed to get user properties; remote exception", null, this.f13989b, e4);
                            ((AtomicReference) this.f13994g).set(Collections.emptyList());
                            atomicReference = (AtomicReference) this.f13994g;
                        }
                        if (zzglVar2 == null) {
                            zznyVar.zzu.zzaW().zze().zzd("(legacy) Failed to get user properties; not connected to service", null, this.f13989b, this.f13990c);
                            atomicReference2.set(Collections.emptyList());
                            atomicReference2.notify();
                            return;
                        }
                        if (TextUtils.isEmpty(null)) {
                            zzr zzrVar2 = this.f13991d;
                            Preconditions.checkNotNull(zzrVar2);
                            atomicReference2.set(zzglVar2.zzk(this.f13989b, this.f13990c, this.f13992e, zzrVar2));
                        } else {
                            atomicReference2.set(zzglVar2.zzl(null, this.f13989b, this.f13990c, this.f13992e));
                        }
                        zznyVar.m3589g();
                        atomicReference = (AtomicReference) this.f13994g;
                        atomicReference.notify();
                        return;
                    } catch (Throwable th3) {
                        ((AtomicReference) this.f13994g).notify();
                        throw th3;
                    }
                }
        }
    }

    public RunnableC0790b0(zzny zznyVar, AtomicReference atomicReference, String str, String str2, zzr zzrVar, boolean z) {
        this.f13994g = atomicReference;
        this.f13989b = str;
        this.f13990c = str2;
        this.f13991d = zzrVar;
        this.f13992e = z;
        this.f13993f = zznyVar;
    }
}
