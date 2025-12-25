package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;
import p000.AbstractC1726qj;
import p000.C1972x6;
import p000.ld3;
import p000.mb3;
import p000.ub3;

/* loaded from: classes.dex */
public final class zzny extends mb3 {

    /* renamed from: b */
    public final zznx f14337b;

    /* renamed from: c */
    public zzgl f14338c;

    /* renamed from: d */
    public volatile Boolean f14339d;

    /* renamed from: e */
    public final C0800g0 f14340e;

    /* renamed from: f */
    public ScheduledExecutorService f14341f;

    /* renamed from: g */
    public final C1972x6 f14342g;

    /* renamed from: h */
    public final ArrayList f14343h;

    /* renamed from: i */
    public final C0800g0 f14344i;

    public zzny(zzio zzioVar) {
        super(zzioVar);
        this.f14343h = new ArrayList();
        this.f14342g = new C1972x6(zzioVar.zzaU());
        this.f14337b = new zznx(this);
        this.f14340e = new C0800g0(this, zzioVar, 0);
        this.f14344i = new C0800g0(this, zzioVar, 1);
    }

    /* renamed from: j */
    public static /* bridge */ /* synthetic */ void m3582j(zzny zznyVar, ComponentName componentName) {
        zznyVar.zzg();
        if (zznyVar.f14338c != null) {
            zznyVar.f14338c = null;
            zznyVar.zzu.zzaW().zzj().zzb("Disconnected from device MeasurementService", componentName);
            zznyVar.zzg();
            zznyVar.m3583a();
        }
    }

    public static /* synthetic */ void zzp(zzny zznyVar) {
        zzgl zzglVar = zznyVar.f14338c;
        if (zzglVar == null) {
            AbstractC1726qj.m7039D(zznyVar.zzu, "Failed to send storage consent settings to service");
            return;
        }
        try {
            zzr m3587e = zznyVar.m3587e(false);
            Preconditions.checkNotNull(m3587e);
            zzglVar.zzA(m3587e);
            zznyVar.m3589g();
        } catch (RemoteException e) {
            zznyVar.zzu.zzaW().zze().zzb("Failed to send storage consent settings to the service", e);
        }
    }

    public static /* synthetic */ void zzq(zzny zznyVar, AtomicReference atomicReference, zzr zzrVar, zzpc zzpcVar) {
        zzgl zzglVar;
        synchronized (atomicReference) {
            try {
                zzglVar = zznyVar.f14338c;
            } catch (RemoteException e) {
                zznyVar.zzu.zzaW().zze().zzb("[sgtm] Failed to get upload batches; remote exception", e);
                atomicReference.notifyAll();
            }
            if (zzglVar == null) {
                zznyVar.zzu.zzaW().zze().zza("[sgtm] Failed to get upload batches; not connected to service");
                return;
            }
            Preconditions.checkNotNull(zzrVar);
            zzglVar.zzo(zzrVar, zzpcVar, new BinderC0794d0(zznyVar, atomicReference));
            zznyVar.m3589g();
        }
    }

    public static /* synthetic */ void zzr(zzny zznyVar, AtomicReference atomicReference, zzr zzrVar, Bundle bundle) {
        zzgl zzglVar;
        synchronized (atomicReference) {
            try {
                zzglVar = zznyVar.f14338c;
            } catch (RemoteException e) {
                zznyVar.zzu.zzaW().zze().zzb("Failed to request trigger URIs; remote exception", e);
                atomicReference.notifyAll();
            }
            if (zzglVar == null) {
                zznyVar.zzu.zzaW().zze().zza("Failed to request trigger URIs; not connected to service");
                return;
            }
            Preconditions.checkNotNull(zzrVar);
            zzglVar.zzr(zzrVar, bundle, new ld3(atomicReference));
            zznyVar.m3589g();
        }
    }

    public static /* synthetic */ void zzs(zzny zznyVar, zzr zzrVar, zzag zzagVar) {
        zzgl zzglVar = zznyVar.f14338c;
        if (zzglVar == null) {
            AbstractC1726qj.m7039D(zznyVar.zzu, "[sgtm] Discarding data. Failed to update batch upload status.");
            return;
        }
        try {
            zzglVar.zzC(zzrVar, zzagVar);
            zznyVar.m3589g();
        } catch (RemoteException e) {
            zznyVar.zzu.zzaW().zze().zzc("[sgtm] Failed to update batch upload status, rowId, exception", Long.valueOf(zzagVar.zza), e);
        }
    }

    public static /* synthetic */ void zzt(zzny zznyVar) {
        zzgl zzglVar = zznyVar.f14338c;
        if (zzglVar == null) {
            AbstractC1726qj.m7039D(zznyVar.zzu, "Failed to send Dma consent settings to service");
            return;
        }
        try {
            zzr m3587e = zznyVar.m3587e(false);
            Preconditions.checkNotNull(m3587e);
            zzglVar.zzy(m3587e);
            zznyVar.m3589g();
        } catch (RemoteException e) {
            zznyVar.zzu.zzaW().zze().zzb("Failed to send Dma consent settings to the service", e);
        }
    }

    /* renamed from: a */
    public final void m3583a() {
        zzg();
        zza();
        if (!zzaa()) {
            boolean m3586d = m3586d();
            zznx zznxVar = this.f14337b;
            if (!m3586d) {
                zzio zzioVar = this.zzu;
                if (!zzioVar.zzf().m3509a()) {
                    zzioVar.zzaV();
                    List<ResolveInfo> queryIntentServices = zzioVar.zzaT().getPackageManager().queryIntentServices(new Intent().setClassName(zzioVar.zzaT(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
                    if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
                        Intent intent = new Intent("com.google.android.gms.measurement.START");
                        Context zzaT = zzioVar.zzaT();
                        zzioVar.zzaV();
                        intent.setComponent(new ComponentName(zzaT, "com.google.android.gms.measurement.AppMeasurementService"));
                        zznxVar.zzb(intent);
                        return;
                    }
                    AbstractC1726qj.m7039D(zzioVar, "Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
                    return;
                }
                return;
            }
            zznxVar.zzc();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01c9  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m3584b(zzgl zzglVar, AbstractSafeParcelable abstractSafeParcelable, zzr zzrVar) {
        int i;
        String str;
        long j;
        long j2;
        zzio zzioVar;
        long currentTimeMillis;
        long j3;
        zzg();
        zza();
        m3591i();
        zzio zzioVar2 = this.zzu;
        zzioVar2.zzf();
        zzr zzrVar2 = zzrVar;
        int i2 = 100;
        int i3 = 0;
        for (int i4 = 100; i3 < 1001 && i2 == i4; i4 = 100) {
            zzio zzioVar3 = this.zzu;
            ArrayList arrayList = new ArrayList();
            List zzi = zzioVar3.zzi().zzi(i4);
            if (zzi != null) {
                arrayList.addAll(zzi);
                i2 = zzi.size();
            } else {
                i2 = 0;
            }
            if (abstractSafeParcelable != null && i2 < i4) {
                arrayList.add(new zzgu(abstractSafeParcelable, zzrVar2.zzc, zzrVar2.zzj));
            }
            String str2 = null;
            boolean zzx = zzioVar2.zzf().zzx(null, zzgi.zzaU);
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                zzgu zzguVar = (zzgu) arrayList.get(i5);
                AbstractSafeParcelable abstractSafeParcelable2 = zzguVar.zza;
                zzam zzf = zzioVar2.zzf();
                zzgg zzggVar = zzgi.zzbl;
                if (zzf.zzx(str2, zzggVar)) {
                    String str3 = zzguVar.zzb;
                    if (!TextUtils.isEmpty(str3)) {
                        i = i5;
                        zzrVar2 = new zzr(zzrVar2.zza, zzrVar2.zzb, str3, zzguVar.zzc, zzrVar2.zzd, zzrVar2.zze, zzrVar2.zzf, zzrVar2.zzg, zzrVar2.zzh, zzrVar2.zzi, zzrVar2.zzk, zzrVar2.zzl, zzrVar2.zzm, zzrVar2.zzn, zzrVar2.zzo, zzrVar2.zzp, zzrVar2.zzq, zzrVar2.zzr, zzrVar2.zzs, zzrVar2.zzt, zzrVar2.zzu, zzrVar2.zzv, zzrVar2.zzw, zzrVar2.zzx, zzrVar2.zzy, zzrVar2.zzz, zzrVar2.zzA, zzrVar2.zzB, zzrVar2.zzC, zzrVar2.zzD, zzrVar2.zzE, zzrVar2.zzF, zzrVar2.zzG);
                        zzr zzrVar3 = zzrVar2;
                        if (!(abstractSafeParcelable2 instanceof zzbh)) {
                            if (zzx) {
                                try {
                                    zzioVar = this.zzu;
                                    currentTimeMillis = zzioVar.zzaU().currentTimeMillis();
                                } catch (RemoteException e) {
                                    e = e;
                                    j = 0;
                                    j2 = 0;
                                }
                                try {
                                    j3 = currentTimeMillis;
                                    j2 = zzioVar.zzaU().elapsedRealtime();
                                } catch (RemoteException e2) {
                                    e = e2;
                                    j2 = 0;
                                    j = currentTimeMillis;
                                    this.zzu.zzaW().zze().zzb("Failed to send event to the service", e);
                                    if (zzx) {
                                        zzio zzioVar4 = this.zzu;
                                        if (zzha.f14179d == null) {
                                        }
                                        zzha.f14179d.zzc(36301, 13, j, zzioVar4.zzaU().currentTimeMillis(), (int) (zzioVar4.zzaU().elapsedRealtime() - j2));
                                    }
                                    str = null;
                                    str2 = str;
                                    i5 = i + 1;
                                    zzrVar2 = zzrVar3;
                                }
                            } else {
                                j3 = 0;
                                j2 = 0;
                            }
                            try {
                                zzglVar.zzp((zzbh) abstractSafeParcelable2, zzrVar3);
                                if (zzx) {
                                    zzioVar2.zzaW().zzj().zza("Logging telemetry for logEvent from database");
                                    zzio zzioVar5 = this.zzu;
                                    if (zzha.f14179d == null) {
                                        zzha.f14179d = new zzha(zzioVar5.zzaT(), zzioVar5);
                                    }
                                    zzha.f14179d.zzc(36301, 0, j3, zzioVar5.zzaU().currentTimeMillis(), (int) (zzioVar5.zzaU().elapsedRealtime() - j2));
                                }
                            } catch (RemoteException e3) {
                                e = e3;
                                j = j3;
                                this.zzu.zzaW().zze().zzb("Failed to send event to the service", e);
                                if (zzx && j != 0) {
                                    zzio zzioVar42 = this.zzu;
                                    if (zzha.f14179d == null) {
                                        zzha.f14179d = new zzha(zzioVar42.zzaT(), zzioVar42);
                                    }
                                    zzha.f14179d.zzc(36301, 13, j, zzioVar42.zzaU().currentTimeMillis(), (int) (zzioVar42.zzaU().elapsedRealtime() - j2));
                                }
                                str = null;
                                str2 = str;
                                i5 = i + 1;
                                zzrVar2 = zzrVar3;
                            }
                        } else if (abstractSafeParcelable2 instanceof zzqb) {
                            try {
                                zzglVar.zzB((zzqb) abstractSafeParcelable2, zzrVar3);
                            } catch (RemoteException e4) {
                                this.zzu.zzaW().zze().zzb("Failed to send user property to the service", e4);
                            }
                        } else if (abstractSafeParcelable2 instanceof zzai) {
                            try {
                                zzglVar.zzt((zzai) abstractSafeParcelable2, zzrVar3);
                            } catch (RemoteException e5) {
                                this.zzu.zzaW().zze().zzb("Failed to send conditional user property to the service", e5);
                            }
                        } else {
                            zzio zzioVar6 = this.zzu;
                            str = null;
                            if (zzioVar6.zzf().zzx(null, zzggVar) && (abstractSafeParcelable2 instanceof zzbf)) {
                                try {
                                    zzglVar.zzx(((zzbf) abstractSafeParcelable2).zzc(), zzrVar3);
                                } catch (RemoteException e6) {
                                    this.zzu.zzaW().zze().zzb("Failed to send default event parameters to the service", e6);
                                }
                            } else {
                                AbstractC1726qj.m7039D(zzioVar6, "Discarding data. Unrecognized parcel type.");
                            }
                            str2 = str;
                            i5 = i + 1;
                            zzrVar2 = zzrVar3;
                        }
                        str = null;
                        str2 = str;
                        i5 = i + 1;
                        zzrVar2 = zzrVar3;
                    }
                }
                i = i5;
                zzr zzrVar32 = zzrVar2;
                if (!(abstractSafeParcelable2 instanceof zzbh)) {
                }
                str = null;
                str2 = str;
                i5 = i + 1;
                zzrVar2 = zzrVar32;
            }
            i3++;
        }
    }

    /* renamed from: c */
    public final boolean m3585c() {
        zzg();
        zza();
        if (!m3586d() || this.zzu.zzw().zzm() >= ((Integer) zzgi.zzaI.zza(null)).intValue()) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00f4  */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean m3586d() {
        Boolean valueOf;
        zzg();
        zza();
        if (this.f14339d == null) {
            zzg();
            zza();
            zzio zzioVar = this.zzu;
            ub3 zzm = zzioVar.zzm();
            zzm.zzg();
            boolean z = false;
            if (!zzm.m7692b().contains("use_service")) {
                valueOf = null;
            } else {
                valueOf = Boolean.valueOf(zzm.m7692b().getBoolean("use_service", false));
            }
            boolean z2 = true;
            if (valueOf == null || !valueOf.booleanValue()) {
                zzioVar.zzaV();
                zzgs zzh = this.zzu.zzh();
                zzh.zza();
                if (zzh.f14169l != 1) {
                    zzioVar.zzaW().zzj().zza("Checking service availability");
                    int zzp = zzioVar.zzw().zzp(GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
                    if (zzp != 0) {
                        if (zzp != 1) {
                            if (zzp != 2) {
                                if (zzp != 3) {
                                    if (zzp != 9) {
                                        if (zzp != 18) {
                                            zzioVar.zzaW().zzk().zzb("Unexpected service status", Integer.valueOf(zzp));
                                        } else {
                                            AbstractC1726qj.m7037B(zzioVar, "Service updating");
                                        }
                                    } else {
                                        AbstractC1726qj.m7037B(zzioVar, "Service invalid");
                                    }
                                } else {
                                    AbstractC1726qj.m7037B(zzioVar, "Service disabled");
                                }
                                z2 = false;
                            } else {
                                zzioVar.zzaW().zzd().zza("Service container out of date");
                                if (zzioVar.zzw().zzm() >= 17443) {
                                    if (valueOf != null) {
                                        z2 = false;
                                    }
                                    z = z2;
                                    z2 = false;
                                }
                            }
                        } else {
                            zzioVar.zzaW().zzj().zza("Service missing");
                        }
                        if (z && zzioVar.zzf().m3509a()) {
                            AbstractC1726qj.m7039D(zzioVar, "No way to upload. Consider using the full version of Analytics");
                        } else if (z2) {
                            ub3 zzm2 = zzioVar.zzm();
                            zzm2.zzg();
                            SharedPreferences.Editor edit = zzm2.m7692b().edit();
                            edit.putBoolean("use_service", z);
                            edit.apply();
                        }
                        z2 = z;
                    } else {
                        zzioVar.zzaW().zzj().zza("Service available");
                    }
                }
                z = true;
                if (z) {
                }
                if (z2) {
                }
                z2 = z;
            }
            this.f14339d = Boolean.valueOf(z2);
        }
        return this.f14339d.booleanValue();
    }

    /* renamed from: e */
    public final zzr m3587e(boolean z) {
        Pair zza;
        zzio zzioVar = this.zzu;
        zzioVar.zzaV();
        zzgs zzh = this.zzu.zzh();
        String str = null;
        if (z) {
            zzio zzioVar2 = zzioVar.zzaW().zzu;
            if (zzioVar2.zzm().f27196e != null && (zza = zzioVar2.zzm().f27196e.zza()) != null && zza != ub3.f27192z) {
                str = AbstractC1726qj.m7058n(String.valueOf(zza.second), ":", (String) zza.first);
            }
        }
        return zzh.m3525a(str);
    }

    /* renamed from: f */
    public final void m3588f() {
        zzg();
        zzhc zzj = this.zzu.zzaW().zzj();
        ArrayList arrayList = this.f14343h;
        zzj.zzb("Processing queued up service tasks", Integer.valueOf(arrayList.size()));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            try {
                ((Runnable) it.next()).run();
            } catch (RuntimeException e) {
                this.zzu.zzaW().zze().zzb("Task exception while flushing queue", e);
            }
        }
        arrayList.clear();
        this.f14344i.m8015a();
    }

    /* renamed from: g */
    public final void m3589g() {
        zzg();
        C1972x6 c1972x6 = this.f14342g;
        c1972x6.f28446b = ((Clock) c1972x6.f28447c).elapsedRealtime();
        this.zzu.zzf();
        this.f14340e.m8016c(((Long) zzgi.zzX.zza(null)).longValue());
    }

    /* renamed from: h */
    public final void m3590h(Runnable runnable) {
        zzg();
        if (zzaa()) {
            runnable.run();
            return;
        }
        ArrayList arrayList = this.f14343h;
        long size = arrayList.size();
        zzio zzioVar = this.zzu;
        zzioVar.zzf();
        if (size >= 1000) {
            AbstractC1726qj.m7039D(zzioVar, "Discarding data. Max runnable queue size reached");
            return;
        }
        arrayList.add(runnable);
        this.f14344i.m8016c(60000L);
        m3583a();
    }

    /* renamed from: i */
    public final void m3591i() {
        this.zzu.zzaV();
    }

    @WorkerThread
    public final void zzA() {
        zzg();
        zza();
        zzr m3587e = m3587e(true);
        m3591i();
        this.zzu.zzf().zzx(null, zzgi.zzbl);
        this.zzu.zzi().zzk();
        m3590h(new RunnableC0796e0(this, m3587e, 1));
    }

    @WorkerThread
    public final void zzC() {
        zzg();
        zza();
        zznx zznxVar = this.f14337b;
        zznxVar.zzd();
        try {
            ConnectionTracker.getInstance().unbindService(this.zzu.zzaT(), zznxVar);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.f14338c = null;
    }

    @WorkerThread
    public final void zzD(com.google.android.gms.internal.measurement.zzcy zzcyVar) {
        zzg();
        zza();
        m3590h(new RunnableC0798f0(this, m3587e(false), zzcyVar));
    }

    @WorkerThread
    public final void zzE(AtomicReference atomicReference) {
        zzg();
        zza();
        m3590h(new RunnableC0798f0(this, atomicReference, m3587e(false)));
    }

    @WorkerThread
    public final void zzF(com.google.android.gms.internal.measurement.zzcy zzcyVar, String str, String str2) {
        zzg();
        zza();
        m3590h(new RunnableC0802h0(this, str, str2, m3587e(false), zzcyVar));
    }

    @WorkerThread
    public final void zzG(AtomicReference atomicReference, String str, String str2, String str3) {
        zzg();
        zza();
        m3590h(new RunnableC0802h0(this, atomicReference, str2, str3, m3587e(false)));
    }

    @WorkerThread
    public final void zzH(final AtomicReference atomicReference, final Bundle bundle) {
        zzg();
        zza();
        final zzr m3587e = m3587e(false);
        m3590h(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzms
            @Override // java.lang.Runnable
            public final void run() {
                zzny.zzr(zzny.this, atomicReference, m3587e, bundle);
            }
        });
    }

    @WorkerThread
    public final void zzI(final AtomicReference atomicReference, final zzpc zzpcVar) {
        zzg();
        zza();
        final zzr m3587e = m3587e(false);
        m3590h(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzmt
            @Override // java.lang.Runnable
            public final void run() {
                zzny.zzq(zzny.this, atomicReference, m3587e, zzpcVar);
            }
        });
    }

    @WorkerThread
    public final void zzJ(AtomicReference atomicReference, boolean z) {
        zzg();
        zza();
        m3590h(new RunnableC0792c0(this, atomicReference, m3587e(false), z));
    }

    @WorkerThread
    public final void zzK(com.google.android.gms.internal.measurement.zzcy zzcyVar, String str, String str2, boolean z) {
        zzg();
        zza();
        m3590h(new RunnableC0790b0(this, str, str2, m3587e(false), z, zzcyVar));
    }

    @WorkerThread
    public final void zzL(AtomicReference atomicReference, String str, String str2, String str3, boolean z) {
        zzg();
        zza();
        m3590h(new RunnableC0790b0(this, atomicReference, str2, str3, m3587e(false), z));
    }

    @WorkerThread
    public final void zzM(zzbh zzbhVar, String str) {
        Preconditions.checkNotNull(zzbhVar);
        zzg();
        zza();
        m3591i();
        m3590h(new RunnableC0792c0(this, m3587e(true), this.zzu.zzi().zzp(zzbhVar), zzbhVar, 2));
    }

    @WorkerThread
    public final void zzN(com.google.android.gms.internal.measurement.zzcy zzcyVar, zzbh zzbhVar, String str) {
        zzg();
        zza();
        zzio zzioVar = this.zzu;
        if (zzioVar.zzw().zzp(GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE) != 0) {
            zzioVar.zzaW().zzk().zza("Not bundling data. Service unavailable or out of date");
            zzioVar.zzw().zzW(zzcyVar, new byte[0]);
        } else {
            m3590h(new RunnableC0826v(this, zzbhVar, str, zzcyVar, 1));
        }
    }

    @WorkerThread
    public final void zzO() {
        zzg();
        zza();
        zzr m3587e = m3587e(false);
        m3591i();
        this.zzu.zzi().zzj();
        m3590h(new RunnableC0796e0(this, m3587e, 0));
    }

    @WorkerThread
    public final void zzQ(zzai zzaiVar) {
        Preconditions.checkNotNull(zzaiVar);
        zzg();
        zza();
        this.zzu.zzaV();
        m3590h(new RunnableC0792c0(this, m3587e(true), this.zzu.zzi().zzn(zzaiVar), new zzai(zzaiVar), 3));
    }

    @WorkerThread
    public final void zzR(boolean z) {
        zzg();
        zza();
        if (m3585c()) {
            m3590h(new RunnableC0796e0(this, m3587e(false), 4));
        }
    }

    @WorkerThread
    public final void zzS(zzmh zzmhVar) {
        zzg();
        zza();
        m3590h(new RunnableC0807k(3, zzmhVar, this));
    }

    @WorkerThread
    public final void zzT(Bundle bundle) {
        boolean z;
        zzg();
        zza();
        zzbf zzbfVar = new zzbf(bundle);
        m3591i();
        if (this.zzu.zzf().zzx(null, zzgi.zzbl) && this.zzu.zzi().zzo(zzbfVar)) {
            z = true;
        } else {
            z = false;
        }
        m3590h(new RunnableC0827w(this, m3587e(false), z, zzbfVar, bundle));
    }

    @WorkerThread
    public final void zzU() {
        zzg();
        zza();
        m3590h(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzmq
            @Override // java.lang.Runnable
            public final void run() {
                zzny.zzt(zzny.this);
            }
        });
    }

    @WorkerThread
    public final void zzV() {
        zzg();
        zza();
        m3590h(new RunnableC0796e0(this, m3587e(true), 3));
    }

    @WorkerThread
    public final void zzW(zzgl zzglVar) {
        zzg();
        Preconditions.checkNotNull(zzglVar);
        this.f14338c = zzglVar;
        m3589g();
        m3588f();
    }

    @WorkerThread
    public final void zzX(boolean z) {
        zzg();
        zza();
        m3590h(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzmp
            @Override // java.lang.Runnable
            public final void run() {
                zzny.zzp(zzny.this);
            }
        });
    }

    @WorkerThread
    public final void zzY(zzqb zzqbVar) {
        zzg();
        zza();
        m3591i();
        m3590h(new RunnableC0792c0(this, m3587e(true), this.zzu.zzi().zzq(zzqbVar), zzqbVar, 1));
    }

    @WorkerThread
    public final void zzZ(final zzag zzagVar) {
        zzg();
        zza();
        final zzr m3587e = m3587e(true);
        Preconditions.checkNotNull(m3587e);
        m3590h(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzmr
            @Override // java.lang.Runnable
            public final void run() {
                zzny.zzs(zzny.this, m3587e, zzagVar);
            }
        });
    }

    @WorkerThread
    public final boolean zzaa() {
        zzg();
        zza();
        if (this.f14338c != null) {
            return true;
        }
        return false;
    }

    @Override // p000.mb3
    public final boolean zzf() {
        return false;
    }

    @WorkerThread
    public final zzap zzh() {
        zzg();
        zza();
        zzgl zzglVar = this.f14338c;
        if (zzglVar == null) {
            m3583a();
            this.zzu.zzaW().zzd().zza("Failed to get consents; not connected to service yet.");
            return null;
        }
        zzr m3587e = m3587e(false);
        Preconditions.checkNotNull(m3587e);
        try {
            zzap zze = zzglVar.zze(m3587e);
            m3589g();
            return zze;
        } catch (RemoteException e) {
            this.zzu.zzaW().zze().zzb("Failed to get consents; remote exception", e);
            return null;
        }
    }

    @WorkerThread
    public final void zzz() {
        zzg();
        zza();
        m3590h(new RunnableC0796e0(this, m3587e(true), 2));
    }
}
