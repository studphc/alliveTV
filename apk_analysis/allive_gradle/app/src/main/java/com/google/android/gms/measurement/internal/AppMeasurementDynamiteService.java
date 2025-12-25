package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import p000.AbstractC1726qj;
import p000.RunnableC1199fl;
import p000.ac3;
import p000.bd3;
import p000.ed3;
import p000.pe3;
import p000.tc3;
import p000.we3;

@DynamiteApi
/* loaded from: classes.dex */
public class AppMeasurementDynamiteService extends com.google.android.gms.internal.measurement.zzcu {

    /* renamed from: a */
    public zzio f13971a = null;

    /* renamed from: b */
    public final ArrayMap f13972b = new ArrayMap();

    public static /* synthetic */ void $r8$lambda$W3cgi1t5N0SU6fYxM9Fsh5qQfPc(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.zzdb zzdbVar) {
        try {
            zzdbVar.zze();
        } catch (RemoteException e) {
            ((zzio) Preconditions.checkNotNull(appMeasurementDynamiteService.f13971a)).zzaW().zzk().zzb("Failed to call IDynamiteUploadBatchesCallback", e);
        }
    }

    /* renamed from: a */
    public final void m3482a() {
        if (this.f13971a != null) {
        } else {
            throw new IllegalStateException("Attempting to perform action before initialize.");
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public void beginAdUnitExposure(@NonNull String str, long j) {
        m3482a();
        this.f13971a.zzd().zzd(str, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public void clearConditionalUserProperty(@NonNull String str, @NonNull String str2, @NonNull Bundle bundle) {
        m3482a();
        this.f13971a.zzq().zzJ(str, str2, bundle);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public void clearMeasurementEnabled(long j) {
        m3482a();
        this.f13971a.zzq().zzai(null);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public void endAdUnitExposure(@NonNull String str, long j) {
        m3482a();
        this.f13971a.zzd().zze(str, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public void generateEventId(com.google.android.gms.internal.measurement.zzcy zzcyVar) {
        m3482a();
        long zzs = this.f13971a.zzw().zzs();
        m3482a();
        this.f13971a.zzw().zzY(zzcyVar, zzs);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public void getAppInstanceId(com.google.android.gms.internal.measurement.zzcy zzcyVar) {
        m3482a();
        this.f13971a.zzaX().zzq(new ac3(this, zzcyVar, 0));
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public void getCachedAppInstanceId(com.google.android.gms.internal.measurement.zzcy zzcyVar) {
        m3482a();
        String zzr = this.f13971a.zzq().zzr();
        m3482a();
        this.f13971a.zzw().zzZ(zzcyVar, zzr);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public void getConditionalUserProperties(String str, String str2, com.google.android.gms.internal.measurement.zzcy zzcyVar) {
        m3482a();
        this.f13971a.zzaX().zzq(new RunnableC1199fl(5, this, zzcyVar, str, str2));
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public void getCurrentScreenClass(com.google.android.gms.internal.measurement.zzcy zzcyVar) {
        m3482a();
        String zzs = this.f13971a.zzq().zzs();
        m3482a();
        this.f13971a.zzw().zzZ(zzcyVar, zzs);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public void getCurrentScreenName(com.google.android.gms.internal.measurement.zzcy zzcyVar) {
        m3482a();
        String zzt = this.f13971a.zzq().zzt();
        m3482a();
        this.f13971a.zzw().zzZ(zzcyVar, zzt);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public void getGmpAppId(com.google.android.gms.internal.measurement.zzcy zzcyVar) {
        m3482a();
        zzlw zzq = this.f13971a.zzq();
        zzio zzioVar = zzq.zzu;
        String str = null;
        if (!zzioVar.zzf().zzx(null, zzgi.zzbp) && zzq.zzu.zzx() != null) {
            str = zzq.zzu.zzx();
        } else {
            try {
                str = zzmg.zzc(zzioVar.zzaT(), "google_app_id", zzq.zzu.zzA());
            } catch (IllegalStateException e) {
                zzq.zzu.zzaW().zze().zzb("getGoogleAppId failed with exception", e);
            }
        }
        m3482a();
        this.f13971a.zzw().zzZ(zzcyVar, str);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public void getMaxUserProperties(String str, com.google.android.gms.internal.measurement.zzcy zzcyVar) {
        m3482a();
        this.f13971a.zzq().zzi(str);
        m3482a();
        this.f13971a.zzw().zzX(zzcyVar, 25);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public void getSessionId(com.google.android.gms.internal.measurement.zzcy zzcyVar) {
        m3482a();
        zzlw zzq = this.f13971a.zzq();
        zzq.zzu.zzaX().zzq(new RunnableC0807k(1, zzcyVar, zzq));
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public void getTestFlag(com.google.android.gms.internal.measurement.zzcy zzcyVar, int i) {
        m3482a();
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return;
                        }
                        this.f13971a.zzw().zzT(zzcyVar, this.f13971a.zzq().zzl().booleanValue());
                        return;
                    }
                    this.f13971a.zzw().zzX(zzcyVar, this.f13971a.zzq().zzp().intValue());
                    return;
                }
                zzqf zzw = this.f13971a.zzw();
                double doubleValue = this.f13971a.zzq().zzm().doubleValue();
                Bundle bundle = new Bundle();
                bundle.putDouble("r", doubleValue);
                try {
                    zzcyVar.zze(bundle);
                    return;
                } catch (RemoteException e) {
                    zzw.zzu.zzaW().zzk().zzb("Error returning double value to wrapper", e);
                    return;
                }
            }
            this.f13971a.zzw().zzY(zzcyVar, this.f13971a.zzq().zzq().longValue());
            return;
        }
        this.f13971a.zzw().zzZ(zzcyVar, this.f13971a.zzq().zzu());
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public void getUserProperties(String str, String str2, boolean z, com.google.android.gms.internal.measurement.zzcy zzcyVar) {
        m3482a();
        this.f13971a.zzaX().zzq(new tc3(this, zzcyVar, str, str2, z));
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public void initForTests(@NonNull Map map) {
        m3482a();
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public void initialize(IObjectWrapper iObjectWrapper, com.google.android.gms.internal.measurement.zzdh zzdhVar, long j) {
        zzio zzioVar = this.f13971a;
        if (zzioVar == null) {
            this.f13971a = zzio.zzp((Context) Preconditions.checkNotNull((Context) ObjectWrapper.unwrap(iObjectWrapper)), zzdhVar, Long.valueOf(j));
        } else {
            AbstractC1726qj.m7037B(zzioVar, "Attempting to initialize multiple times");
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public void isDataCollectionEnabled(com.google.android.gms.internal.measurement.zzcy zzcyVar) {
        m3482a();
        this.f13971a.zzaX().zzq(new ac3(this, zzcyVar, 1));
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public void logEvent(@NonNull String str, @NonNull String str2, @NonNull Bundle bundle, boolean z, boolean z2, long j) {
        m3482a();
        this.f13971a.zzq().zzP(str, str2, bundle, z, z2, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public void logEventAndBundle(String str, String str2, Bundle bundle, com.google.android.gms.internal.measurement.zzcy zzcyVar, long j) {
        Bundle bundle2;
        m3482a();
        Preconditions.checkNotEmpty(str2);
        if (bundle != null) {
            bundle2 = new Bundle(bundle);
        } else {
            bundle2 = new Bundle();
        }
        bundle2.putString("_o", "app");
        this.f13971a.zzaX().zzq(new RunnableC1199fl(4, this, zzcyVar, new zzbh(str2, new zzbf(bundle), "app", j), str));
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public void logHealthData(int i, @NonNull String str, @NonNull IObjectWrapper iObjectWrapper, @NonNull IObjectWrapper iObjectWrapper2, @NonNull IObjectWrapper iObjectWrapper3) {
        Object unwrap;
        Object unwrap2;
        m3482a();
        Object obj = null;
        if (iObjectWrapper == null) {
            unwrap = null;
        } else {
            unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        }
        if (iObjectWrapper2 == null) {
            unwrap2 = null;
        } else {
            unwrap2 = ObjectWrapper.unwrap(iObjectWrapper2);
        }
        if (iObjectWrapper3 != null) {
            obj = ObjectWrapper.unwrap(iObjectWrapper3);
        }
        this.f13971a.zzaW().zzu(i, true, false, str, unwrap, unwrap2, obj);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public void onActivityCreated(@NonNull IObjectWrapper iObjectWrapper, @NonNull Bundle bundle, long j) {
        m3482a();
        onActivityCreatedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdj.zza((Activity) Preconditions.checkNotNull((Activity) ObjectWrapper.unwrap(iObjectWrapper))), bundle, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public void onActivityCreatedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdj zzdjVar, Bundle bundle, long j) {
        m3482a();
        C0828x c0828x = this.f13971a.zzq().zza;
        if (c0828x != null) {
            this.f13971a.zzq().zzK();
            c0828x.zza(zzdjVar, bundle);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public void onActivityDestroyed(@NonNull IObjectWrapper iObjectWrapper, long j) {
        m3482a();
        onActivityDestroyedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdj.zza((Activity) Preconditions.checkNotNull((Activity) ObjectWrapper.unwrap(iObjectWrapper))), j);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public void onActivityDestroyedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdj zzdjVar, long j) {
        m3482a();
        C0828x c0828x = this.f13971a.zzq().zza;
        if (c0828x != null) {
            this.f13971a.zzq().zzK();
            c0828x.zzb(zzdjVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public void onActivityPaused(@NonNull IObjectWrapper iObjectWrapper, long j) {
        m3482a();
        onActivityPausedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdj.zza((Activity) Preconditions.checkNotNull((Activity) ObjectWrapper.unwrap(iObjectWrapper))), j);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public void onActivityPausedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdj zzdjVar, long j) {
        m3482a();
        C0828x c0828x = this.f13971a.zzq().zza;
        if (c0828x != null) {
            this.f13971a.zzq().zzK();
            c0828x.zzc(zzdjVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public void onActivityResumed(@NonNull IObjectWrapper iObjectWrapper, long j) {
        m3482a();
        onActivityResumedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdj.zza((Activity) Preconditions.checkNotNull((Activity) ObjectWrapper.unwrap(iObjectWrapper))), j);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public void onActivityResumedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdj zzdjVar, long j) {
        m3482a();
        C0828x c0828x = this.f13971a.zzq().zza;
        if (c0828x != null) {
            this.f13971a.zzq().zzK();
            c0828x.zzd(zzdjVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, com.google.android.gms.internal.measurement.zzcy zzcyVar, long j) {
        m3482a();
        onActivitySaveInstanceStateByScionActivityInfo(com.google.android.gms.internal.measurement.zzdj.zza((Activity) Preconditions.checkNotNull((Activity) ObjectWrapper.unwrap(iObjectWrapper))), zzcyVar, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public void onActivitySaveInstanceStateByScionActivityInfo(com.google.android.gms.internal.measurement.zzdj zzdjVar, com.google.android.gms.internal.measurement.zzcy zzcyVar, long j) {
        m3482a();
        C0828x c0828x = this.f13971a.zzq().zza;
        Bundle bundle = new Bundle();
        if (c0828x != null) {
            this.f13971a.zzq().zzK();
            c0828x.zze(zzdjVar, bundle);
        }
        try {
            zzcyVar.zze(bundle);
        } catch (RemoteException e) {
            this.f13971a.zzaW().zzk().zzb("Error returning bundle value to wrapper", e);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public void onActivityStarted(@NonNull IObjectWrapper iObjectWrapper, long j) {
        m3482a();
        onActivityStartedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdj.zza((Activity) Preconditions.checkNotNull((Activity) ObjectWrapper.unwrap(iObjectWrapper))), j);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public void onActivityStartedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdj zzdjVar, long j) {
        m3482a();
        if (this.f13971a.zzq().zza != null) {
            this.f13971a.zzq().zzK();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public void onActivityStopped(@NonNull IObjectWrapper iObjectWrapper, long j) {
        m3482a();
        onActivityStoppedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdj.zza((Activity) Preconditions.checkNotNull((Activity) ObjectWrapper.unwrap(iObjectWrapper))), j);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public void onActivityStoppedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdj zzdjVar, long j) {
        m3482a();
        if (this.f13971a.zzq().zza != null) {
            this.f13971a.zzq().zzK();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public void performAction(Bundle bundle, com.google.android.gms.internal.measurement.zzcy zzcyVar, long j) {
        m3482a();
        zzcyVar.zze(null);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public void registerOnMeasurementEventListener(com.google.android.gms.internal.measurement.zzde zzdeVar) {
        zzkc zzkcVar;
        m3482a();
        ArrayMap arrayMap = this.f13972b;
        synchronized (arrayMap) {
            try {
                zzkcVar = (zzkc) arrayMap.get(Integer.valueOf(zzdeVar.zze()));
                if (zzkcVar == null) {
                    zzkcVar = new we3(this, zzdeVar);
                    arrayMap.put(Integer.valueOf(zzdeVar.zze()), zzkcVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f13971a.zzq().zzV(zzkcVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public void resetAnalyticsData(long j) {
        m3482a();
        this.f13971a.zzq().zzX(j);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public void retrieveAndUploadBatches(final com.google.android.gms.internal.measurement.zzdb zzdbVar) {
        int i;
        zzme zzmeVar;
        m3482a();
        zzam zzf = this.f13971a.zzf();
        zzgg zzggVar = zzgi.zzaR;
        if (!zzf.zzx(null, zzggVar)) {
            return;
        }
        final zzlw zzq = this.f13971a.zzq();
        Runnable runnable = new Runnable() { // from class: com.google.android.gms.measurement.internal.zzi
            @Override // java.lang.Runnable
            public final void run() {
                AppMeasurementDynamiteService.$r8$lambda$W3cgi1t5N0SU6fYxM9Fsh5qQfPc(AppMeasurementDynamiteService.this, zzdbVar);
            }
        };
        zzio zzioVar = zzq.zzu;
        if (zzioVar.zzf().zzx(null, zzggVar)) {
            zzq.zza();
            if (!zzioVar.zzaX().zzu()) {
                if (!zzioVar.zzaX().zzt()) {
                    zzioVar.zzaV();
                    if (!zzaf.zza()) {
                        zzioVar.zzaW().zzj().zza("[sgtm] Started client-side batch upload work.");
                        boolean z = false;
                        int i2 = 0;
                        int i3 = 0;
                        loop0: while (!z) {
                            zzioVar.zzaW().zzj().zza("[sgtm] Getting upload batches from service (FE)");
                            final AtomicReference atomicReference = new AtomicReference();
                            zzioVar.zzaX().m3551a(atomicReference, 10000L, "[sgtm] Getting upload batches", new Runnable() { // from class: com.google.android.gms.measurement.internal.zzkl
                                @Override // java.lang.Runnable
                                public final void run() {
                                    zzlw.this.zzu.zzu().zzI(atomicReference, zzpc.zza(zzmf.SGTM_CLIENT));
                                }
                            });
                            zzpe zzpeVar = (zzpe) atomicReference.get();
                            if (zzpeVar == null) {
                                break;
                            }
                            List list = zzpeVar.zza;
                            if (list.isEmpty()) {
                                break;
                            }
                            zzioVar.zzaW().zzj().zzb("[sgtm] Retrieved upload batches. count", Integer.valueOf(list.size()));
                            i2 += list.size();
                            Iterator it = list.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    final zzpa zzpaVar = (zzpa) it.next();
                                    try {
                                        URL url = new URI(zzpaVar.zzc).toURL();
                                        final AtomicReference atomicReference2 = new AtomicReference();
                                        zzgs zzh = zzq.zzu.zzh();
                                        zzh.zza();
                                        Preconditions.checkNotNull(zzh.f14163f);
                                        String str = zzh.f14163f;
                                        zzio zzioVar2 = zzq.zzu;
                                        zzhc zzj = zzioVar2.zzaW().zzj();
                                        i = i2;
                                        Long valueOf = Long.valueOf(zzpaVar.zza);
                                        zzj.zzd("[sgtm] Uploading data from app. row_id, url, uncompressed size", valueOf, zzpaVar.zzc, Integer.valueOf(zzpaVar.zzb.length));
                                        if (!TextUtils.isEmpty(zzpaVar.zzg)) {
                                            zzioVar2.zzaW().zzj().zzc("[sgtm] Uploading data from app. row_id", valueOf, zzpaVar.zzg);
                                        }
                                        HashMap hashMap = new HashMap();
                                        Bundle bundle = zzpaVar.zzd;
                                        for (String str2 : bundle.keySet()) {
                                            String string = bundle.getString(str2);
                                            if (!TextUtils.isEmpty(string)) {
                                                hashMap.put(str2, string);
                                            }
                                        }
                                        zzmb zzr = zzioVar2.zzr();
                                        byte[] bArr = zzpaVar.zzb;
                                        bd3 bd3Var = new bd3() { // from class: com.google.android.gms.measurement.internal.zzkn
                                            /* JADX WARN: Removed duplicated region for block: B:10:0x0064  */
                                            /* JADX WARN: Removed duplicated region for block: B:13:0x0097 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                                            /* JADX WARN: Removed duplicated region for block: B:22:0x0067  */
                                            @Override // p000.bd3
                                            /*
                                                Code decompiled incorrectly, please refer to instructions dump.
                                            */
                                            public final void zza(String str3, int i4, Throwable th, byte[] bArr2, Map map) {
                                                zzme zzmeVar2;
                                                AtomicReference atomicReference3;
                                                zzlw zzlwVar = zzlw.this;
                                                zzlwVar.zzg();
                                                zzpa zzpaVar2 = zzpaVar;
                                                if (i4 != 200 && i4 != 204) {
                                                    if (i4 == 304) {
                                                        i4 = 304;
                                                    }
                                                    zzlwVar.zzu.zzaW().zzk().zzd("[sgtm] Upload failed for row_id. response, exception", Long.valueOf(zzpaVar2.zza), Integer.valueOf(i4), th);
                                                    if (!Arrays.asList(((String) zzgi.zzt.zza(null)).split(",")).contains(String.valueOf(i4))) {
                                                        zzmeVar2 = zzme.BACKOFF;
                                                    } else {
                                                        zzmeVar2 = zzme.FAILURE;
                                                    }
                                                    atomicReference3 = atomicReference2;
                                                    zzny zzu = zzlwVar.zzu.zzu();
                                                    long j = zzpaVar2.zza;
                                                    zzu.zzZ(new zzag(zzmeVar2.zza(), j, zzpaVar2.zzf));
                                                    zzlwVar.zzu.zzaW().zzj().zzc("[sgtm] Updated status for row_id", Long.valueOf(j), zzmeVar2);
                                                    synchronized (atomicReference3) {
                                                        atomicReference3.set(zzmeVar2);
                                                        atomicReference3.notifyAll();
                                                    }
                                                    return;
                                                }
                                                if (th == null) {
                                                    zzlwVar.zzu.zzaW().zzj().zzb("[sgtm] Upload succeeded for row_id", Long.valueOf(zzpaVar2.zza));
                                                    zzmeVar2 = zzme.SUCCESS;
                                                    atomicReference3 = atomicReference2;
                                                    zzny zzu2 = zzlwVar.zzu.zzu();
                                                    long j2 = zzpaVar2.zza;
                                                    zzu2.zzZ(new zzag(zzmeVar2.zza(), j2, zzpaVar2.zzf));
                                                    zzlwVar.zzu.zzaW().zzj().zzc("[sgtm] Updated status for row_id", Long.valueOf(j2), zzmeVar2);
                                                    synchronized (atomicReference3) {
                                                    }
                                                }
                                                zzlwVar.zzu.zzaW().zzk().zzd("[sgtm] Upload failed for row_id. response, exception", Long.valueOf(zzpaVar2.zza), Integer.valueOf(i4), th);
                                                if (!Arrays.asList(((String) zzgi.zzt.zza(null)).split(",")).contains(String.valueOf(i4))) {
                                                }
                                                atomicReference3 = atomicReference2;
                                                zzny zzu22 = zzlwVar.zzu.zzu();
                                                long j22 = zzpaVar2.zza;
                                                zzu22.zzZ(new zzag(zzmeVar2.zza(), j22, zzpaVar2.zzf));
                                                zzlwVar.zzu.zzaW().zzj().zzc("[sgtm] Updated status for row_id", Long.valueOf(j22), zzmeVar2);
                                                synchronized (atomicReference3) {
                                                }
                                            }
                                        };
                                        zzr.zzv();
                                        Preconditions.checkNotNull(url);
                                        Preconditions.checkNotNull(bArr);
                                        Preconditions.checkNotNull(bd3Var);
                                        zzr.zzu.zzaX().zzp(new RunnableC0829y(zzr, str, url, bArr, hashMap, bd3Var));
                                        try {
                                            zzio zzioVar3 = zzioVar2.zzw().zzu;
                                            long currentTimeMillis = zzioVar3.zzaU().currentTimeMillis() + 60000;
                                            synchronized (atomicReference2) {
                                                for (long j = 60000; atomicReference2.get() == null && j > 0; j = currentTimeMillis - zzioVar3.zzaU().currentTimeMillis()) {
                                                    try {
                                                        atomicReference2.wait(j);
                                                    } catch (Throwable th) {
                                                        throw th;
                                                        break loop0;
                                                    }
                                                }
                                            }
                                        } catch (InterruptedException unused) {
                                            AbstractC1726qj.m7037B(zzq.zzu, "[sgtm] Interrupted waiting for uploading batch");
                                        }
                                        if (atomicReference2.get() == null) {
                                            zzmeVar = zzme.UNKNOWN;
                                        } else {
                                            zzmeVar = (zzme) atomicReference2.get();
                                        }
                                    } catch (MalformedURLException | URISyntaxException e) {
                                        i = i2;
                                        zzq.zzu.zzaW().zze().zzd("[sgtm] Bad upload url for row_id", zzpaVar.zzc, Long.valueOf(zzpaVar.zza), e);
                                        zzmeVar = zzme.FAILURE;
                                    }
                                    if (zzmeVar == zzme.SUCCESS) {
                                        i3++;
                                    } else if (zzmeVar == zzme.BACKOFF) {
                                        z = true;
                                        i2 = i;
                                        break;
                                    }
                                    i2 = i;
                                } else {
                                    z = false;
                                    break;
                                }
                            }
                        }
                        zzioVar.zzaW().zzj().zzc("[sgtm] Completed client-side batch upload work. total, success", Integer.valueOf(i2), Integer.valueOf(i3));
                        runnable.run();
                        return;
                    }
                    AbstractC1726qj.m7039D(zzioVar, "Cannot retrieve and upload batches from main thread");
                    return;
                }
                AbstractC1726qj.m7039D(zzioVar, "Cannot retrieve and upload batches from analytics network thread");
                return;
            }
            AbstractC1726qj.m7039D(zzioVar, "Cannot retrieve and upload batches from analytics worker thread");
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public void setConditionalUserProperty(@NonNull Bundle bundle, long j) {
        m3482a();
        if (bundle == null) {
            AbstractC1726qj.m7039D(this.f13971a, "Conditional user property must not be null");
        } else {
            this.f13971a.zzq().zzae(bundle, j);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public void setConsent(@NonNull final Bundle bundle, final long j) {
        m3482a();
        final zzlw zzq = this.f13971a.zzq();
        zzq.zzu.zzaX().zzr(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzkm
            @Override // java.lang.Runnable
            public final void run() {
                zzlw zzlwVar = zzlw.this;
                if (TextUtils.isEmpty(zzlwVar.zzu.zzh().zzo())) {
                    zzlwVar.m3569e(bundle, 0, j);
                } else {
                    zzlwVar.zzu.zzaW().zzl().zza("Using developer consent only; google app id found");
                }
            }
        });
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public void setConsentThirdParty(@NonNull Bundle bundle, long j) {
        m3482a();
        this.f13971a.zzq().m3569e(bundle, -20, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public void setCurrentScreen(@NonNull IObjectWrapper iObjectWrapper, @NonNull String str, @NonNull String str2, long j) {
        m3482a();
        setCurrentScreenByScionActivityInfo(com.google.android.gms.internal.measurement.zzdj.zza((Activity) Preconditions.checkNotNull((Activity) ObjectWrapper.unwrap(iObjectWrapper))), str, str2, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public void setCurrentScreenByScionActivityInfo(com.google.android.gms.internal.measurement.zzdj zzdjVar, String str, String str2, long j) {
        m3482a();
        this.f13971a.zzt().zzx(zzdjVar, str, str2);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public void setDataCollectionEnabled(boolean z) {
        m3482a();
        zzlw zzq = this.f13971a.zzq();
        zzq.zza();
        zzq.zzu.zzaX().zzq(new RunnableC0819q(zzq, z));
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public void setDefaultEventParameters(@NonNull Bundle bundle) {
        final Bundle bundle2;
        m3482a();
        final zzlw zzq = this.f13971a.zzq();
        if (bundle == null) {
            bundle2 = new Bundle();
        } else {
            bundle2 = new Bundle(bundle);
        }
        zzq.zzu.zzaX().zzq(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzkk
            @Override // java.lang.Runnable
            public final void run() {
                zzlw.zzz(zzlw.this, bundle2);
            }
        });
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public void setEventInterceptor(com.google.android.gms.internal.measurement.zzde zzdeVar) {
        m3482a();
        pe3 pe3Var = new pe3(this, zzdeVar);
        if (this.f13971a.zzaX().zzu()) {
            this.f13971a.zzq().zzah(pe3Var);
        } else {
            this.f13971a.zzaX().zzq(new ed3(0, this, pe3Var));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public void setInstanceIdProvider(com.google.android.gms.internal.measurement.zzdg zzdgVar) {
        m3482a();
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public void setMeasurementEnabled(boolean z, long j) {
        m3482a();
        this.f13971a.zzq().zzai(Boolean.valueOf(z));
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public void setMinimumSessionDuration(long j) {
        m3482a();
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public void setSessionTimeoutDuration(long j) {
        m3482a();
        zzlw zzq = this.f13971a.zzq();
        zzq.zzu.zzaX().zzq(new RunnableC0821r(zzq, j, 0));
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public void setSgtmDebugInfo(@NonNull Intent intent) {
        m3482a();
        zzlw zzq = this.f13971a.zzq();
        Uri data = intent.getData();
        if (data == null) {
            zzq.zzu.zzaW().zzi().zza("Activity intent has no data. Preview Mode was not enabled.");
            return;
        }
        String queryParameter = data.getQueryParameter("sgtm_debug_enable");
        if (queryParameter != null && queryParameter.equals(IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE)) {
            String queryParameter2 = data.getQueryParameter("sgtm_preview_key");
            if (!TextUtils.isEmpty(queryParameter2)) {
                zzio zzioVar = zzq.zzu;
                zzioVar.zzaW().zzi().zzb("[sgtm] Preview Mode was enabled. Using the sgtmPreviewKey: ", queryParameter2);
                zzioVar.zzf().zzv(queryParameter2);
                return;
            }
            return;
        }
        zzio zzioVar2 = zzq.zzu;
        zzioVar2.zzaW().zzi().zza("[sgtm] Preview Mode was not enabled.");
        zzioVar2.zzf().zzv(null);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public void setUserId(@NonNull final String str, long j) {
        m3482a();
        final zzlw zzq = this.f13971a.zzq();
        if (str != null && TextUtils.isEmpty(str)) {
            AbstractC1726qj.m7037B(zzq.zzu, "User ID must be non-empty or null");
        } else {
            zzq.zzu.zzaX().zzq(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzkg
                @Override // java.lang.Runnable
                public final void run() {
                    zzio zzioVar = zzlw.this.zzu;
                    zzgs zzh = zzioVar.zzh();
                    String str2 = str;
                    String str3 = zzh.f14174q;
                    boolean z = false;
                    if (str3 != null && !str3.equals(str2)) {
                        z = true;
                    }
                    zzh.f14174q = str2;
                    if (z) {
                        zzioVar.zzh().m3528d();
                    }
                }
            });
            zzq.zzam(null, "_id", str, true, j);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public void setUserProperty(@NonNull String str, @NonNull String str2, @NonNull IObjectWrapper iObjectWrapper, boolean z, long j) {
        m3482a();
        this.f13971a.zzq().zzam(str, str2, ObjectWrapper.unwrap(iObjectWrapper), z, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public void unregisterOnMeasurementEventListener(com.google.android.gms.internal.measurement.zzde zzdeVar) {
        zzkc zzkcVar;
        m3482a();
        ArrayMap arrayMap = this.f13972b;
        synchronized (arrayMap) {
            zzkcVar = (zzkc) arrayMap.remove(Integer.valueOf(zzdeVar.zze()));
        }
        if (zzkcVar == null) {
            zzkcVar = new we3(this, zzdeVar);
        }
        this.f13971a.zzq().zzao(zzkcVar);
    }
}
