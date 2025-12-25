package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzih;
import java.util.Collections;
import java.util.HashMap;
import p000.ob3;

/* loaded from: classes.dex */
public final class zzpi extends AbstractC0818p0 {
    /* renamed from: c */
    public static final boolean m3608c(String str) {
        String str2 = (String) zzgi.zzs.zza(null);
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        for (String str3 : str2.split(",")) {
            if (str.equalsIgnoreCase(str3.trim())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public final String m3609a(String str) {
        String m3547l = this.zzg.zzr().m3547l(str);
        if (!TextUtils.isEmpty(m3547l)) {
            Uri parse = Uri.parse((String) zzgi.zzq.zza(null));
            Uri.Builder buildUpon = parse.buildUpon();
            buildUpon.authority(m3547l + "." + parse.getAuthority());
            return buildUpon.build().toString();
        }
        return (String) zzgi.zzq.zza(null);
    }

    /* renamed from: b */
    public final boolean m3610b(String str, String str2) {
        ob3 m7842R;
        zzpv zzpvVar = this.zzg;
        com.google.android.gms.internal.measurement.zzgo zzj = zzpvVar.zzr().zzj(str);
        if (zzj == null || (m7842R = zzpvVar.zzj().m7842R(str)) == null) {
            return false;
        }
        if ((zzj.zzv() && zzj.zzi().zza() == 100) || this.zzu.zzw().m3712B(str, m7842R.m6541h())) {
            return true;
        }
        if (TextUtils.isEmpty(str2) || Math.abs(str2.hashCode() % 100) >= zzj.zzi().zza()) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0243 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0244  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzph zza(String str) {
        String str2;
        zzph zzphVar;
        zzio zzioVar = this.zzu;
        zzam zzf = zzioVar.zzf();
        zzgg zzggVar = zzgi.zzaP;
        zzph zzphVar2 = null;
        if (zzf.zzx(null, zzggVar)) {
            zzpv zzpvVar = this.zzg;
            ob3 m7842R = zzpvVar.zzj().m7842R(str);
            if (m7842R != null && m7842R.m6549p()) {
                com.google.android.gms.internal.measurement.zzif zza = com.google.android.gms.internal.measurement.zzim.zza();
                zza.zzc(2);
                zza.zza((zzih) Preconditions.checkNotNull(zzih.zzb(m7842R.m6532F())));
                if (!m3610b(str, m7842R.m6537d())) {
                    zza.zzb(3);
                    return new zzph(m3609a(str), Collections.emptyMap(), zzmf.GOOGLE_ANALYTICS, (com.google.android.gms.internal.measurement.zzim) zza.zzba());
                }
                String m6536c = m7842R.m6536c();
                zza.zzc(2);
                com.google.android.gms.internal.measurement.zzgo zzj = zzpvVar.zzr().zzj(m7842R.m6536c());
                if (zzj != null && zzj.zzv()) {
                    HashMap hashMap = new HashMap();
                    if (!TextUtils.isEmpty(m7842R.m6541h())) {
                        hashMap.put("x-gtm-server-preview", m7842R.m6541h());
                    }
                    String zze = zzj.zzi().zze();
                    zzih zzb = zzih.zzb(m7842R.m6532F());
                    if (zzb != null && zzb != zzih.CLIENT_UPLOAD_ELIGIBLE) {
                        zza.zza(zzb);
                    } else if (!zzioVar.zzf().zzx(null, zzggVar)) {
                        zza.zza(zzih.SERVICE_FLAG_OFF);
                    } else if (m3608c(m7842R.m6536c())) {
                        zza.zza(zzih.PINNED_TO_SERVICE_UPLOAD);
                    } else if (TextUtils.isEmpty(zze)) {
                        zza.zza(zzih.MISSING_SGTM_SERVER_URL);
                    } else {
                        zzioVar.zzaW().zzj().zzb("[sgtm] Eligible for client side upload. appId", m6536c);
                        zza.zzc(3);
                        zza.zza(zzih.CLIENT_UPLOAD_ELIGIBLE);
                        zzphVar2 = new zzph(zze, hashMap, zzmf.SGTM_CLIENT, (com.google.android.gms.internal.measurement.zzim) zza.zzba());
                    }
                    zzj.zzi().zzf();
                    zzj.zzi().zzd();
                    zzioVar.zzaV();
                    if (!TextUtils.isEmpty(zze)) {
                        zzioVar.zzaW().zzj().zzb("[sgtm] Eligible for local service direct upload. appId", m6536c);
                        zza.zzc(5);
                        zza.zzb(2);
                        zzphVar2 = new zzph(zze, hashMap, zzmf.SGTM, (com.google.android.gms.internal.measurement.zzim) zza.zzba());
                    } else {
                        zza.zzb(6);
                        zzioVar.zzaW().zzj().zzb("[sgtm] Local service, missing sgtm_server_url", m7842R.m6536c());
                    }
                } else {
                    zzioVar.zzaW().zzj().zzb("[sgtm] Missing sgtm_setting in remote config. appId", m6536c);
                    zza.zzb(4);
                }
                if (zzphVar2 != null) {
                    return zzphVar2;
                }
                return new zzph(m3609a(str), Collections.emptyMap(), zzmf.GOOGLE_ANALYTICS, (com.google.android.gms.internal.measurement.zzim) zza.zzba());
            }
            return new zzph(m3609a(str), Collections.emptyMap(), zzmf.GOOGLE_ANALYTICS, null);
        }
        zzpv zzpvVar2 = this.zzg;
        ob3 m7842R2 = zzpvVar2.zzj().m7842R(str);
        if (m7842R2 == null) {
            return new zzph(m3609a(str), Collections.emptyMap(), zzmf.GOOGLE_ANALYTICS, null);
        }
        if (m3610b(str, m7842R2.m6537d())) {
            if (m7842R2.m6549p()) {
                zzioVar.zzaW().zzj().zza("sgtm upload enabled in manifest.");
                com.google.android.gms.internal.measurement.zzgo zzj2 = zzpvVar2.zzr().zzj(m7842R2.m6536c());
                if (zzj2 != null && zzj2.zzv()) {
                    String zzf2 = zzj2.zzi().zzf();
                    if (!TextUtils.isEmpty(zzf2)) {
                        String zzd = zzj2.zzi().zzd();
                        zzhc zzj3 = zzioVar.zzaW().zzj();
                        if (true != TextUtils.isEmpty(zzd)) {
                            str2 = "N";
                        } else {
                            str2 = "Y";
                        }
                        zzj3.zzc("sgtm configured with upload_url, server_info", zzf2, str2);
                        if (TextUtils.isEmpty(zzd)) {
                            zzioVar.zzaV();
                            zzphVar = new zzph(zzf2, Collections.emptyMap(), zzmf.SGTM, null);
                        } else {
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("x-sgtm-server-info", zzd);
                            if (!TextUtils.isEmpty(m7842R2.m6541h())) {
                                hashMap2.put("x-gtm-server-preview", m7842R2.m6541h());
                            }
                            zzphVar = new zzph(zzf2, hashMap2, zzmf.SGTM, null);
                        }
                        if (zzphVar == null) {
                            return zzphVar;
                        }
                        return new zzph(m3609a(str), Collections.emptyMap(), zzmf.GOOGLE_ANALYTICS, null);
                    }
                }
            }
            zzphVar = null;
            if (zzphVar == null) {
            }
        } else {
            return new zzph(m3609a(str), Collections.emptyMap(), zzmf.GOOGLE_ANALYTICS, null);
        }
    }
}
