package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.os.Binder;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.BinderThread;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.internal.measurement.zzht;
import com.google.android.gms.internal.measurement.zzmm;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import p000.cc3;
import p000.ec3;
import p000.sk1;
import p000.u40;
import p000.ue3;
import p000.v93;
import p000.wb3;
import p000.xb3;
import p000.xy1;
import p000.yb3;
import p000.ye3;

/* loaded from: classes.dex */
public final class zzjp extends zzgk {

    /* renamed from: a */
    public final zzpv f14280a;

    /* renamed from: b */
    public Boolean f14281b;

    /* renamed from: c */
    public String f14282c;

    public zzjp(zzpv zzpvVar, String str) {
        Preconditions.checkNotNull(zzpvVar);
        this.f14280a = zzpvVar;
        this.f14282c = null;
    }

    public static /* synthetic */ void zzE(zzjp zzjpVar, zzr zzrVar) {
        zzpv zzpvVar = zzjpVar.f14280a;
        zzpvVar.m3643c();
        zzpvVar.m3624K(zzrVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0120  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void zzF(zzjp zzjpVar, zzr zzrVar, zzag zzagVar) {
        Cursor cursor;
        long j;
        v93 v93Var;
        Cursor cursor2;
        zzpz zzpzVar;
        Cursor cursor3;
        zzpv zzpvVar = zzjpVar.f14280a;
        zzpvVar.m3643c();
        String str = (String) Preconditions.checkNotNull(zzrVar.zza);
        zzam zzi = zzpvVar.zzi();
        zzgg zzggVar = zzgi.zzaP;
        if (zzi.zzx(null, zzggVar)) {
            zzpvVar.zzaX().zzg();
            zzpvVar.m3644d();
            v93 zzj = zzpvVar.zzj();
            long j2 = zzagVar.zza;
            if (!zzj.zzu.zzf().zzx(null, zzggVar)) {
                zzpzVar = null;
                j = j2;
            } else {
                zzj.zzg();
                zzj.zzav();
                try {
                    cursor2 = zzj.m7841Q().query("upload_queue", new String[]{"rowId", "app_id", "measurement_batch", "upload_uri", "upload_headers", "upload_type", "retry_count", AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, "associated_row_id", "last_upload_timestamp"}, "rowId=?", new String[]{String.valueOf(j2)}, null, null, null, IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE);
                    try {
                    } catch (SQLiteException e) {
                        e = e;
                        cursor3 = cursor2;
                        j = j2;
                        v93Var = zzj;
                    } catch (Throwable th) {
                        th = th;
                        cursor3 = cursor2;
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                    j = j2;
                    v93Var = zzj;
                    cursor2 = null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor = null;
                }
                if (!cursor2.moveToFirst()) {
                    j = j2;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    zzpzVar = null;
                } else {
                    cursor3 = cursor2;
                    j = j2;
                    v93Var = zzj;
                    try {
                        zzpzVar = zzj.m7876x((String) Preconditions.checkNotNull(cursor2.getString(1)), j2, cursor2.getBlob(2), cursor2.getString(3), cursor2.getString(4), cursor2.getInt(5), cursor2.getInt(6), cursor2.getLong(7), cursor2.getLong(8), cursor2.getLong(9));
                        cursor3.close();
                    } catch (SQLiteException e3) {
                        e = e3;
                        cursor2 = cursor3;
                        try {
                            v93Var.zzu.zzaW().zze().zzc("Error to querying MeasurementBatch from upload_queue. rowId", Long.valueOf(j), e);
                            if (cursor2 != null) {
                            }
                            zzpzVar = null;
                            if (zzpzVar != null) {
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            cursor = cursor2;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        cursor = cursor3;
                        if (cursor != null) {
                        }
                        throw th;
                    }
                }
            }
            if (zzpzVar != null) {
                zzpvVar.zzaW().zzk().zzc("[sgtm] Queued batch doesn't exist. appId, rowId", str, Long.valueOf(j));
                return;
            }
            String zzh = zzpzVar.zzh();
            int i = zzagVar.zzb;
            int zza = zzme.SUCCESS.zza();
            HashMap hashMap = zzpvVar.f14363E;
            if (i == zza) {
                if (hashMap.containsKey(zzh)) {
                    hashMap.remove(zzh);
                }
                v93 zzj2 = zzpvVar.zzj();
                Long valueOf = Long.valueOf(j);
                zzj2.m7862j(valueOf);
                zzpvVar.zzaW().zzj().zzc("[sgtm] queued batch deleted after successful client upload. appId, rowId", str, valueOf);
                long j3 = zzagVar.zzc;
                if (j3 > 0) {
                    v93 zzj3 = zzpvVar.zzj();
                    zzio zzioVar = zzj3.zzu;
                    if (zzioVar.zzf().zzx(null, zzggVar)) {
                        zzj3.zzg();
                        zzj3.zzav();
                        Long valueOf2 = Long.valueOf(j3);
                        Preconditions.checkNotNull(valueOf2);
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("upload_type", Integer.valueOf(zzmf.GOOGLE_SIGNAL.zza()));
                        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzioVar.zzaU().currentTimeMillis()));
                        try {
                            if (zzj3.m7841Q().update("upload_queue", contentValues, "rowid=? AND app_id=? AND upload_type=?", new String[]{String.valueOf(j3), str, String.valueOf(zzmf.GOOGLE_SIGNAL_PENDING.zza())}) != 1) {
                                zzioVar.zzaW().zzk().zzc("Google Signal pending batch not updated. appId, rowId", str, valueOf2);
                            }
                        } catch (SQLiteException e4) {
                            zzj3.zzu.zzaW().zze().zzd("Failed to update google Signal pending batch. appid, rowId", str, Long.valueOf(j3), e4);
                            throw e4;
                        }
                    }
                    zzpvVar.zzaW().zzj().zzc("[sgtm] queued Google Signal batch updated. appId, signalRowId", str, Long.valueOf(zzagVar.zzc));
                    zzpvVar.m3631R(str);
                    return;
                }
                return;
            }
            if (zzagVar.zzb == zzme.BACKOFF.zza()) {
                ue3 ue3Var = (ue3) hashMap.get(zzh);
                if (ue3Var == null) {
                    ue3Var = new ue3(zzpvVar);
                    hashMap.put(zzh, ue3Var);
                } else {
                    ue3Var.f27243b++;
                    ue3Var.f27244c = ue3Var.m7703a();
                }
                zzpvVar.zzaW().zzj().zzd("[sgtm] Putting sGTM server in backoff mode. appId, destination, nextRetryInSeconds", str, zzh, Long.valueOf((ue3Var.f27244c - zzpvVar.zzaU().currentTimeMillis()) / 1000));
            }
            v93 zzj4 = zzpvVar.zzj();
            Long valueOf3 = Long.valueOf(zzagVar.zza);
            zzj4.m7865m(valueOf3);
            zzpvVar.zzaW().zzj().zzc("[sgtm] increased batch retry count after failed client upload. appId, rowId", str, valueOf3);
        }
    }

    public static /* synthetic */ void zzG(zzjp zzjpVar, zzr zzrVar) {
        zzpv zzpvVar = zzjpVar.f14280a;
        zzpvVar.m3643c();
        zzpvVar.m3623J(zzrVar);
    }

    public static /* synthetic */ void zzH(zzjp zzjpVar, zzr zzrVar, Bundle bundle, zzgo zzgoVar, String str) {
        zzpv zzpvVar = zzjpVar.f14280a;
        zzpvVar.m3643c();
        try {
            zzgoVar.zze(zzpvVar.m3642b(zzrVar, bundle));
        } catch (RemoteException e) {
            zzjpVar.f14280a.zzaW().zze().zzc("Failed to return trigger URIs for app", str, e);
        }
    }

    public static void zzI(zzjp zzjpVar, Bundle bundle, String str, zzr zzrVar) {
        zzpv zzpvVar = zzjpVar.f14280a;
        boolean zzx = zzpvVar.zzi().zzx(null, zzgi.zzbc);
        boolean zzx2 = zzpvVar.zzi().zzx(null, zzgi.zzbe);
        boolean isEmpty = bundle.isEmpty();
        zzpv zzpvVar2 = zzjpVar.f14280a;
        if (isEmpty && zzx) {
            v93 zzj = zzpvVar2.zzj();
            zzj.zzg();
            zzj.zzav();
            try {
                zzj.m7841Q().execSQL("delete from default_event_params where app_id=?", new String[]{str});
                return;
            } catch (SQLiteException e) {
                zzj.zzu.zzaW().zze().zzb("Error clearing default event params", e);
                return;
            }
        }
        v93 zzj2 = zzpvVar.zzj();
        zzj2.zzg();
        zzj2.zzav();
        byte[] zzcd = zzj2.zzg.zzA().m3694w(new zzbc(zzj2.zzu, "", str, "dep", 0L, 0L, bundle)).zzcd();
        zzio zzioVar = zzj2.zzu;
        zzioVar.zzaW().zzj().zzc("Saving default event parameters, appId, data size", str, Integer.valueOf(zzcd.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("parameters", zzcd);
        try {
            if (zzj2.m7841Q().insertWithOnConflict("default_event_params", null, contentValues, 5) == -1) {
                zzioVar.zzaW().zze().zzb("Failed to insert default event parameters (got -1). appId", zzhe.zzn(str));
            }
        } catch (SQLiteException e2) {
            zzj2.zzu.zzaW().zze().zzc("Error storing default event parameters. appId", zzhe.zzn(str), e2);
        }
        v93 zzj3 = zzpvVar2.zzj();
        long j = zzrVar.zzF;
        zzio zzioVar2 = zzj3.zzu;
        if (zzioVar2.zzf().zzx(null, zzgi.zzbe) || zzioVar2.zzaU().currentTimeMillis() <= C0643C.DEFAULT_SEEK_FORWARD_INCREMENT_MS + j) {
            try {
                if (zzj3.m7837M("select count(*) from raw_events where app_id=? and timestamp >= ? and name not like '!_%' escape '!' limit 1;", new String[]{str, String.valueOf(j)}, 0L) <= 0) {
                    if (zzj3.m7837M("select count(*) from raw_events where app_id=? and timestamp >= ? and name like '!_%' escape '!' limit 1;", new String[]{str, String.valueOf(j)}, 0L) > 0) {
                        if (zzx2) {
                            zzpvVar2.zzj().m7859g(str, Long.valueOf(j), null, bundle);
                        } else {
                            zzpvVar2.zzj().m7859g(str, null, null, bundle);
                        }
                    }
                }
            } catch (SQLiteException e3) {
                zzj3.zzu.zzaW().zze().zzb("Error checking backfill conditions", e3);
            }
        }
    }

    public static /* synthetic */ void zzd(zzjp zzjpVar, String str, zzpc zzpcVar, zzgr zzgrVar) {
        zzpe zzpeVar;
        zzpv zzpvVar = zzjpVar.f14280a;
        zzpvVar.m3643c();
        if (!zzpvVar.zzi().zzx(null, zzgi.zzaP)) {
            zzpeVar = new zzpe(Collections.emptyList());
        } else {
            zzpvVar.zzaX().zzg();
            zzpvVar.m3644d();
            List<zzpz> m7856d = zzpvVar.zzj().m7856d(str, zzpcVar, ((Integer) zzgi.zzA.zza(null)).intValue());
            ArrayList arrayList = new ArrayList();
            for (zzpz zzpzVar : m7856d) {
                if (!zzpvVar.m3634U(str, zzpzVar.zzh())) {
                    zzpvVar.zzaW().zzj().zzd("[sgtm] batch skipped due to destination in backoff. appId, rowId, url", str, Long.valueOf(zzpzVar.zzc()), zzpzVar.zzh());
                } else {
                    int zza = zzpzVar.zza();
                    if (zza > 0) {
                        if (zza <= ((Integer) zzgi.zzy.zza(null)).intValue()) {
                            if (zzpvVar.zzaU().currentTimeMillis() >= zzpzVar.zzb() + Math.min(((Long) zzgi.zzw.zza(null)).longValue() * (1 << (zza - 1)), ((Long) zzgi.zzx.zza(null)).longValue())) {
                            }
                        }
                        zzpvVar.zzaW().zzj().zzd("[sgtm] batch skipped waiting for next retry. appId, rowId, lastUploadMillis", str, Long.valueOf(zzpzVar.zzc()), Long.valueOf(zzpzVar.zzb()));
                    }
                    zzpa zze = zzpzVar.zze();
                    try {
                        zzht zzhtVar = (zzht) zzqa.m3683x(com.google.android.gms.internal.measurement.zzhv.zzb(), zze.zzb);
                        for (int i = 0; i < zzhtVar.zza(); i++) {
                            com.google.android.gms.internal.measurement.zzhw zzhwVar = (com.google.android.gms.internal.measurement.zzhw) zzhtVar.zzh(i).zzch();
                            zzhwVar.zzaA(zzpvVar.zzaU().currentTimeMillis());
                            zzhtVar.zze(i, zzhwVar);
                        }
                        zze.zzb = ((com.google.android.gms.internal.measurement.zzhv) zzhtVar.zzba()).zzcd();
                        if (Log.isLoggable(zzpvVar.zzaW().zzr(), 2)) {
                            zze.zzg = zzpvVar.zzA().m3695y((com.google.android.gms.internal.measurement.zzhv) zzhtVar.zzba());
                        }
                        arrayList.add(zze);
                    } catch (zzmm unused) {
                        zzpvVar.zzaW().zzk().zzb("Failed to parse queued batch. appId", str);
                    }
                }
            }
            zzpeVar = new zzpe(arrayList);
        }
        try {
            zzgrVar.zze(zzpeVar);
            zzpvVar.zzaW().zzj().zzc("[sgtm] Sending queued upload batches to client. appId, count", str, Integer.valueOf(zzpeVar.zza.size()));
        } catch (RemoteException e) {
            zzpvVar.zzaW().zze().zzc("[sgtm] Failed to return upload batches for app", str, e);
        }
    }

    /* renamed from: a */
    public final void m3556a(Runnable runnable) {
        Preconditions.checkNotNull(runnable);
        zzpv zzpvVar = this.f14280a;
        if (zzpvVar.zzaX().zzu()) {
            runnable.run();
        } else {
            zzpvVar.zzaX().zzr(runnable);
        }
    }

    /* renamed from: b */
    public final void m3557b(Runnable runnable) {
        Preconditions.checkNotNull(runnable);
        zzpv zzpvVar = this.f14280a;
        if (zzpvVar.zzaX().zzu()) {
            runnable.run();
        } else {
            zzpvVar.zzaX().zzq(runnable);
        }
    }

    /* renamed from: c */
    public final void m3558c(zzr zzrVar) {
        Preconditions.checkNotNull(zzrVar);
        String str = zzrVar.zza;
        Preconditions.checkNotEmpty(str);
        m3559d(str, false);
        this.f14280a.zzB().m3738u(zzrVar.zzb, zzrVar.zzp);
    }

    /* renamed from: d */
    public final void m3559d(String str, boolean z) {
        boolean isEmpty = TextUtils.isEmpty(str);
        zzpv zzpvVar = this.f14280a;
        if (!isEmpty) {
            if (z) {
                try {
                    if (this.f14281b == null) {
                        boolean z2 = true;
                        if (!"com.google.android.gms".equals(this.f14282c) && !UidVerifier.isGooglePlayServicesUid(zzpvVar.zzaT(), Binder.getCallingUid()) && !GoogleSignatureVerifier.getInstance(zzpvVar.zzaT()).isUidGoogleSigned(Binder.getCallingUid())) {
                            z2 = false;
                        }
                        this.f14281b = Boolean.valueOf(z2);
                    }
                    if (this.f14281b.booleanValue()) {
                        return;
                    }
                } catch (SecurityException e) {
                    zzpvVar.zzaW().zze().zzb("Measurement Service called with invalid calling package. appId", zzhe.zzn(str));
                    throw e;
                }
            }
            if (this.f14282c == null && GooglePlayServicesUtilLight.uidHasPackageName(zzpvVar.zzaT(), Binder.getCallingUid(), str)) {
                this.f14282c = str;
            }
            if (str.equals(this.f14282c)) {
                return;
            }
            throw new SecurityException("Unknown calling package name '" + str + "'.");
        }
        zzpvVar.zzaW().zze().zza("Measurement Service called without app package");
        throw new SecurityException("Measurement Service called without app package");
    }

    /* renamed from: e */
    public final void m3560e(zzbh zzbhVar, zzr zzrVar) {
        zzpv zzpvVar = this.f14280a;
        zzpvVar.m3643c();
        zzpvVar.m3649i(zzbhVar, zzrVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    @BinderThread
    public final void zzA(final zzr zzrVar) {
        Preconditions.checkNotEmpty(zzrVar.zza);
        Preconditions.checkNotNull(zzrVar.zzu);
        m3556a(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzir
            @Override // java.lang.Runnable
            public final void run() {
                zzjp.zzE(zzjp.this, zzrVar);
            }
        });
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    @BinderThread
    public final void zzB(zzqb zzqbVar, zzr zzrVar) {
        Preconditions.checkNotNull(zzqbVar);
        m3558c(zzrVar);
        m3557b(new sk1(this, zzqbVar, zzrVar, 7));
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    @BinderThread
    public final void zzC(final zzr zzrVar, final zzag zzagVar) {
        if (!this.f14280a.zzi().zzx(null, zzgi.zzaP)) {
            return;
        }
        m3558c(zzrVar);
        m3557b(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzip
            @Override // java.lang.Runnable
            public final void run() {
                zzjp.zzF(zzjp.this, zzrVar, zzagVar);
            }
        });
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    @BinderThread
    public final byte[] zzD(zzbh zzbhVar, String str) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzbhVar);
        m3559d(str, true);
        zzpv zzpvVar = this.f14280a;
        zzhc zzd = zzpvVar.zzaW().zzd();
        zzgx zzo = zzpvVar.zzo();
        String str2 = zzbhVar.zza;
        zzd.zzb("Log and bundle. event", zzo.zzd(str2));
        long nanoTime = zzpvVar.zzaU().nanoTime() / 1000000;
        try {
            byte[] bArr = (byte[]) zzpvVar.zzaX().zzh(new u40(this, zzbhVar, str)).get();
            if (bArr == null) {
                zzpvVar.zzaW().zze().zzb("Log and bundle returned null. appId", zzhe.zzn(str));
                bArr = new byte[0];
            }
            zzpvVar.zzaW().zzd().zzd("Log and bundle processed. event, size, time_ms", zzpvVar.zzo().zzd(str2), Integer.valueOf(bArr.length), Long.valueOf((zzpvVar.zzaU().nanoTime() / 1000000) - nanoTime));
            return bArr;
        } catch (InterruptedException e) {
            e = e;
            zzpvVar.zzaW().zze().zzd("Failed to log and bundle. appId, event, error", zzhe.zzn(str), zzpvVar.zzo().zzd(zzbhVar.zza), e);
            return null;
        } catch (ExecutionException e2) {
            e = e2;
            zzpvVar.zzaW().zze().zzd("Failed to log and bundle. appId, event, error", zzhe.zzn(str), zzpvVar.zzo().zzd(zzbhVar.zza), e);
            return null;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    @BinderThread
    public final zzap zze(zzr zzrVar) {
        m3558c(zzrVar);
        Preconditions.checkNotEmpty(zzrVar.zza);
        zzpv zzpvVar = this.f14280a;
        try {
            return (zzap) zzpvVar.zzaX().zzh(new wb3(1, this, zzrVar)).get(10000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            zzpvVar.zzaW().zze().zzc("Failed to get consent. appId", zzhe.zzn(zzrVar.zza), e);
            return new zzap(null);
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    @BinderThread
    public final String zzf(zzr zzrVar) {
        m3558c(zzrVar);
        zzpv zzpvVar = this.f14280a;
        try {
            return (String) zzpvVar.zzaX().zzf(new wb3(2, zzpvVar, zzrVar)).get(30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            zzpvVar.zzaW().zze().zzc("Failed to get app instance id. appId", zzhe.zzn(zzrVar.zza), e);
            return null;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    @BinderThread
    public final List zzg(zzr zzrVar, Bundle bundle) {
        m3558c(zzrVar);
        Preconditions.checkNotNull(zzrVar.zza);
        zzpv zzpvVar = this.f14280a;
        if (zzpvVar.zzi().zzx(null, zzgi.zzbh)) {
            try {
                return (List) zzpvVar.zzaX().zzh(new ec3(this, zzrVar, bundle, 0)).get(10000L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException | ExecutionException | TimeoutException e) {
                zzpvVar.zzaW().zze().zzc("Failed to get trigger URIs. appId", zzhe.zzn(zzrVar.zza), e);
                return Collections.emptyList();
            }
        }
        try {
            return (List) zzpvVar.zzaX().zzf(new ec3(this, zzrVar, bundle, 1)).get();
        } catch (InterruptedException | ExecutionException e2) {
            zzpvVar.zzaW().zze().zzc("Failed to get trigger URIs. appId", zzhe.zzn(zzrVar.zza), e2);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    @BinderThread
    public final List zzh(zzr zzrVar, boolean z) {
        m3558c(zzrVar);
        String str = zzrVar.zza;
        Preconditions.checkNotNull(str);
        zzpv zzpvVar = this.f14280a;
        try {
            List<ye3> list = (List) zzpvVar.zzaX().zzf(new wb3(0, this, str)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (ye3 ye3Var : list) {
                if (!z && zzqf.m3699E(ye3Var.f28930c)) {
                }
                arrayList.add(new zzqb(ye3Var));
            }
            return arrayList;
        } catch (InterruptedException e) {
            e = e;
            zzpvVar.zzaW().zze().zzc("Failed to get user properties. appId", zzhe.zzn(zzrVar.zza), e);
            return null;
        } catch (ExecutionException e2) {
            e = e2;
            zzpvVar.zzaW().zze().zzc("Failed to get user properties. appId", zzhe.zzn(zzrVar.zza), e);
            return null;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    @BinderThread
    public final List zzi(String str, String str2, zzr zzrVar) {
        m3558c(zzrVar);
        String str3 = zzrVar.zza;
        Preconditions.checkNotNull(str3);
        zzpv zzpvVar = this.f14280a;
        try {
            return (List) zzpvVar.zzaX().zzf(new cc3(this, str3, str, str2, 2)).get();
        } catch (InterruptedException | ExecutionException e) {
            zzpvVar.zzaW().zze().zzb("Failed to get conditional user properties", e);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    @BinderThread
    public final List zzj(String str, String str2, String str3) {
        m3559d(str, true);
        zzpv zzpvVar = this.f14280a;
        try {
            return (List) zzpvVar.zzaX().zzf(new cc3(this, str, str2, str3, 3)).get();
        } catch (InterruptedException | ExecutionException e) {
            zzpvVar.zzaW().zze().zzb("Failed to get conditional user properties as", e);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    @BinderThread
    public final List zzk(String str, String str2, boolean z, zzr zzrVar) {
        m3558c(zzrVar);
        String str3 = zzrVar.zza;
        Preconditions.checkNotNull(str3);
        zzpv zzpvVar = this.f14280a;
        try {
            List<ye3> list = (List) zzpvVar.zzaX().zzf(new cc3(this, str3, str, str2, 0)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (ye3 ye3Var : list) {
                if (!z && zzqf.m3699E(ye3Var.f28930c)) {
                }
                arrayList.add(new zzqb(ye3Var));
            }
            return arrayList;
        } catch (InterruptedException e) {
            e = e;
            zzpvVar.zzaW().zze().zzc("Failed to query user properties. appId", zzhe.zzn(zzrVar.zza), e);
            return Collections.emptyList();
        } catch (ExecutionException e2) {
            e = e2;
            zzpvVar.zzaW().zze().zzc("Failed to query user properties. appId", zzhe.zzn(zzrVar.zza), e);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    @BinderThread
    public final List zzl(String str, String str2, String str3, boolean z) {
        m3559d(str, true);
        zzpv zzpvVar = this.f14280a;
        try {
            List<ye3> list = (List) zzpvVar.zzaX().zzf(new cc3(this, str, str2, str3, 1)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (ye3 ye3Var : list) {
                if (!z && zzqf.m3699E(ye3Var.f28930c)) {
                }
                arrayList.add(new zzqb(ye3Var));
            }
            return arrayList;
        } catch (InterruptedException e) {
            e = e;
            zzpvVar.zzaW().zze().zzc("Failed to get user properties as. appId", zzhe.zzn(str), e);
            return Collections.emptyList();
        } catch (ExecutionException e2) {
            e = e2;
            zzpvVar.zzaW().zze().zzc("Failed to get user properties as. appId", zzhe.zzn(str), e);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    @BinderThread
    public final void zzm(zzr zzrVar) {
        m3558c(zzrVar);
        m3557b(new RunnableC0809l(this, zzrVar, 0));
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    @BinderThread
    public final void zzn(zzr zzrVar) {
        m3558c(zzrVar);
        m3557b(new xb3(this, zzrVar, 0));
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    @BinderThread
    public final void zzo(zzr zzrVar, final zzpc zzpcVar, final zzgr zzgrVar) {
        zzpv zzpvVar = this.f14280a;
        if (!zzpvVar.zzi().zzx(null, zzgi.zzaP)) {
            try {
                zzgrVar.zze(new zzpe(Collections.emptyList()));
                zzpvVar.zzaW().zzj().zza("[sgtm] Client upload is not enabled on the service side.");
                return;
            } catch (RemoteException e) {
                zzpvVar.zzaW().zzk().zzb("[sgtm] UploadBatchesCallback failed.", e);
                return;
            }
        }
        m3558c(zzrVar);
        final String str = (String) Preconditions.checkNotNull(zzrVar.zza);
        zzpvVar.zzaX().zzq(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzis
            @Override // java.lang.Runnable
            public final void run() {
                zzjp.zzd(zzjp.this, str, zzpcVar, zzgrVar);
            }
        });
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    @BinderThread
    public final void zzp(zzbh zzbhVar, zzr zzrVar) {
        Preconditions.checkNotNull(zzbhVar);
        m3558c(zzrVar);
        m3557b(new sk1(this, zzbhVar, zzrVar, 5));
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    @BinderThread
    public final void zzq(zzbh zzbhVar, String str, String str2) {
        Preconditions.checkNotNull(zzbhVar);
        Preconditions.checkNotEmpty(str);
        m3559d(str, true);
        m3557b(new sk1(6, str, this, zzbhVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    @BinderThread
    public final void zzr(final zzr zzrVar, final Bundle bundle, final zzgo zzgoVar) {
        m3558c(zzrVar);
        final String str = (String) Preconditions.checkNotNull(zzrVar.zza);
        this.f14280a.zzaX().zzq(new Runnable() { // from class: com.google.android.gms.measurement.internal.zziq
            @Override // java.lang.Runnable
            public final void run() {
                zzjp.zzH(zzjp.this, zzrVar, bundle, zzgoVar, str);
            }
        });
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    @BinderThread
    public final void zzs(zzr zzrVar) {
        String str = zzrVar.zza;
        Preconditions.checkNotEmpty(str);
        m3559d(str, false);
        m3557b(new RunnableC0809l(this, zzrVar, 1));
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    @BinderThread
    public final void zzt(zzai zzaiVar, zzr zzrVar) {
        Preconditions.checkNotNull(zzaiVar);
        Preconditions.checkNotNull(zzaiVar.zzc);
        m3558c(zzrVar);
        zzai zzaiVar2 = new zzai(zzaiVar);
        zzaiVar2.zza = zzrVar.zza;
        m3557b(new sk1(this, zzaiVar2, zzrVar, 4));
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    @BinderThread
    public final void zzu(zzai zzaiVar) {
        Preconditions.checkNotNull(zzaiVar);
        Preconditions.checkNotNull(zzaiVar.zzc);
        Preconditions.checkNotEmpty(zzaiVar.zza);
        m3559d(zzaiVar.zza, true);
        m3557b(new xy1(27, this, new zzai(zzaiVar)));
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    @BinderThread
    public final void zzv(zzr zzrVar) {
        Preconditions.checkNotEmpty(zzrVar.zza);
        Preconditions.checkNotNull(zzrVar.zzu);
        m3556a(new xb3(this, zzrVar, 2));
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    @BinderThread
    public final void zzw(long j, String str, String str2, String str3) {
        m3557b(new yb3(this, str2, str3, str, j, 0));
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    @BinderThread
    public final void zzx(final Bundle bundle, final zzr zzrVar) {
        m3558c(zzrVar);
        final String str = zzrVar.zza;
        Preconditions.checkNotNull(str);
        m3557b(new Runnable() { // from class: com.google.android.gms.measurement.internal.zziu
            @Override // java.lang.Runnable
            public final void run() {
                zzjp.zzI(zzjp.this, bundle, str, zzrVar);
            }
        });
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    @BinderThread
    public final void zzy(final zzr zzrVar) {
        Preconditions.checkNotEmpty(zzrVar.zza);
        Preconditions.checkNotNull(zzrVar.zzu);
        m3556a(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzit
            @Override // java.lang.Runnable
            public final void run() {
                zzjp.zzG(zzjp.this, zzrVar);
            }
        });
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    @BinderThread
    public final void zzz(zzr zzrVar) {
        m3558c(zzrVar);
        m3557b(new xb3(this, zzrVar, 1));
    }
}
