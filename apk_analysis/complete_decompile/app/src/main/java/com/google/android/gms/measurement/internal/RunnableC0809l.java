package com.google.android.gms.measurement.internal;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzih;
import java.util.ArrayList;
import p000.v93;

/* renamed from: com.google.android.gms.measurement.internal.l */
/* loaded from: classes.dex */
public final class RunnableC0809l implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f14054a;

    /* renamed from: b */
    public final /* synthetic */ zzr f14055b;

    /* renamed from: c */
    public final /* synthetic */ zzjp f14056c;

    public /* synthetic */ RunnableC0809l(zzjp zzjpVar, zzr zzrVar, int i) {
        this.f14054a = i;
        this.f14055b = zzrVar;
        this.f14056c = zzjpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.internal.measurement.zzgo zzj;
        switch (this.f14054a) {
            case 0:
                zzjp zzjpVar = this.f14056c;
                zzjpVar.f14280a.m3643c();
                zzpv zzpvVar = zzjpVar.f14280a;
                zzpvVar.zzaX().zzg();
                zzpvVar.m3644d();
                zzr zzrVar = this.f14055b;
                Preconditions.checkNotNull(zzrVar);
                String str = zzrVar.zza;
                Preconditions.checkNotEmpty(str);
                int i = 0;
                if (zzpvVar.zzi().zzx(null, zzgi.zzay)) {
                    long currentTimeMillis = zzpvVar.zzaU().currentTimeMillis();
                    int zzh = zzpvVar.zzi().zzh(null, zzgi.zzah);
                    zzpvVar.zzi();
                    long zzF = currentTimeMillis - zzam.zzF();
                    while (i < zzh && zzpvVar.m3662y(zzF, null)) {
                        i++;
                    }
                } else {
                    zzpvVar.zzi();
                    long zzH = zzam.zzH();
                    while (i < zzH && zzpvVar.m3662y(0L, str)) {
                        i++;
                    }
                }
                if (zzpvVar.zzi().zzx(null, zzgi.zzaz)) {
                    zzpvVar.zzaX().zzg();
                    zzpvVar.m3660w();
                }
                if (zzpvVar.zzi().zzx(null, zzgi.zzaQ)) {
                    zzih zzb = zzih.zzb(zzrVar.zzG);
                    zzpi zzpiVar = zzpvVar.f14378j;
                    zzpiVar.zzg();
                    if (zzpiVar.zzu.zzf().zzx(null, zzgi.zzaP) && zzb == zzih.CLIENT_UPLOAD_ELIGIBLE && !zzpi.m3608c(str) && (zzj = zzpiVar.zzg.zzr().zzj(str)) != null && zzj.zzv() && !zzj.zzi().zze().isEmpty()) {
                        zzpvVar.zzaW().zzj().zzb("[sgtm] Going background, trigger client side upload. appId", str);
                        zzpvVar.m3630Q(zzpvVar.zzaU().currentTimeMillis(), str);
                        return;
                    }
                    return;
                }
                return;
            default:
                zzjp zzjpVar2 = this.f14056c;
                zzjpVar2.f14280a.m3643c();
                zzpv zzpvVar2 = zzjpVar2.f14280a;
                if (zzpvVar2.f14393y != null) {
                    ArrayList arrayList = new ArrayList();
                    zzpvVar2.f14394z = arrayList;
                    arrayList.addAll(zzpvVar2.f14393y);
                }
                v93 zzj2 = zzpvVar2.zzj();
                zzr zzrVar2 = this.f14055b;
                String str2 = (String) Preconditions.checkNotNull(zzrVar2.zza);
                Preconditions.checkNotEmpty(str2);
                zzj2.zzg();
                zzj2.zzav();
                try {
                    SQLiteDatabase m7841Q = zzj2.m7841Q();
                    String[] strArr = {str2};
                    int delete = m7841Q.delete("apps", "app_id=?", strArr) + m7841Q.delete("events", "app_id=?", strArr) + m7841Q.delete("events_snapshot", "app_id=?", strArr) + m7841Q.delete("user_attributes", "app_id=?", strArr) + m7841Q.delete("conditional_properties", "app_id=?", strArr) + m7841Q.delete("raw_events", "app_id=?", strArr) + m7841Q.delete("raw_events_metadata", "app_id=?", strArr) + m7841Q.delete("queue", "app_id=?", strArr) + m7841Q.delete("audience_filter_values", "app_id=?", strArr) + m7841Q.delete("main_event_params", "app_id=?", strArr) + m7841Q.delete("default_event_params", "app_id=?", strArr) + m7841Q.delete("trigger_uris", "app_id=?", strArr) + m7841Q.delete("upload_queue", "app_id=?", strArr);
                    if (delete > 0) {
                        zzj2.zzu.zzaW().zzj().zzc("Reset analytics data. app, records", str2, Integer.valueOf(delete));
                    }
                } catch (SQLiteException e) {
                    zzj2.zzu.zzaW().zze().zzc("Error resetting analytics data. appId, error", zzhe.zzn(str2), e);
                }
                if (zzrVar2.zzh) {
                    zzpvVar2.m3620G(zzrVar2);
                    return;
                }
                return;
        }
    }
}
