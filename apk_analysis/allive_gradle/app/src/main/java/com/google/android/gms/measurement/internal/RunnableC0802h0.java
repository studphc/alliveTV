package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.measurement.internal.h0 */
/* loaded from: classes.dex */
public final class RunnableC0802h0 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f14029a = 1;

    /* renamed from: b */
    public final /* synthetic */ String f14030b;

    /* renamed from: c */
    public final /* synthetic */ String f14031c;

    /* renamed from: d */
    public final /* synthetic */ zzr f14032d;

    /* renamed from: e */
    public final /* synthetic */ zzny f14033e;

    /* renamed from: f */
    public final /* synthetic */ Object f14034f;

    public RunnableC0802h0(zzny zznyVar, String str, String str2, zzr zzrVar, com.google.android.gms.internal.measurement.zzcy zzcyVar) {
        this.f14030b = str;
        this.f14031c = str2;
        this.f14032d = zzrVar;
        this.f14034f = zzcyVar;
        this.f14033e = zznyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference;
        zzny zznyVar;
        zzgl zzglVar;
        zzqf zzw;
        zzgl zzglVar2;
        switch (this.f14029a) {
            case 0:
                AtomicReference atomicReference2 = (AtomicReference) this.f14034f;
                synchronized (atomicReference2) {
                    try {
                        try {
                            zznyVar = this.f14033e;
                            zzglVar = zznyVar.f14338c;
                        } catch (RemoteException e) {
                            this.f14033e.zzu.zzaW().zze().zzd("(legacy) Failed to get conditional properties; remote exception", null, this.f14030b, e);
                            ((AtomicReference) this.f14034f).set(Collections.emptyList());
                            atomicReference = (AtomicReference) this.f14034f;
                        }
                        if (zzglVar == null) {
                            zznyVar.zzu.zzaW().zze().zzd("(legacy) Failed to get conditional properties; not connected to service", null, this.f14030b, this.f14031c);
                            atomicReference2.set(Collections.emptyList());
                            atomicReference2.notify();
                            return;
                        }
                        if (TextUtils.isEmpty(null)) {
                            zzr zzrVar = this.f14032d;
                            Preconditions.checkNotNull(zzrVar);
                            atomicReference2.set(zzglVar.zzi(this.f14030b, this.f14031c, zzrVar));
                        } else {
                            atomicReference2.set(zzglVar.zzj(null, this.f14030b, this.f14031c));
                        }
                        zznyVar.m3589g();
                        atomicReference = (AtomicReference) this.f14034f;
                        atomicReference.notify();
                        return;
                    } catch (Throwable th) {
                        ((AtomicReference) this.f14034f).notify();
                        throw th;
                    }
                }
            default:
                com.google.android.gms.internal.measurement.zzcy zzcyVar = (com.google.android.gms.internal.measurement.zzcy) this.f14034f;
                String str = this.f14031c;
                String str2 = this.f14030b;
                zzny zznyVar2 = this.f14033e;
                ArrayList arrayList = new ArrayList();
                try {
                    try {
                        zzglVar2 = zznyVar2.f14338c;
                    } catch (Throwable th2) {
                        zznyVar2.zzu.zzw().zzU(zzcyVar, arrayList);
                        throw th2;
                    }
                } catch (RemoteException e2) {
                    zznyVar2.zzu.zzaW().zze().zzd("Failed to get conditional properties; remote exception", str2, str, e2);
                }
                if (zzglVar2 == null) {
                    zzio zzioVar = zznyVar2.zzu;
                    zzioVar.zzaW().zze().zzc("Failed to get conditional properties; not connected to service", str2, str);
                    zzw = zzioVar.zzw();
                    zzw.zzU(zzcyVar, arrayList);
                    return;
                }
                zzr zzrVar2 = this.f14032d;
                Preconditions.checkNotNull(zzrVar2);
                arrayList = zzqf.zzK(zzglVar2.zzi(str2, str, zzrVar2));
                zznyVar2.m3589g();
                zzw = zznyVar2.zzu.zzw();
                zzw.zzU(zzcyVar, arrayList);
                return;
        }
    }

    public RunnableC0802h0(zzny zznyVar, AtomicReference atomicReference, String str, String str2, zzr zzrVar) {
        this.f14034f = atomicReference;
        this.f14030b = str;
        this.f14031c = str2;
        this.f14032d = zzrVar;
        this.f14033e = zznyVar;
    }
}
