package com.google.android.gms.measurement.internal;

import android.content.pm.PackageManager;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Locale;
import java.util.Objects;
import p000.be3;
import p000.re3;
import p000.ub3;

/* loaded from: classes.dex */
public final class zzoa extends re3 {

    /* renamed from: b */
    public final HashMap f14345b;
    public final zzhp zza;
    public final zzhp zzb;
    public final zzhp zzc;
    public final zzhp zzd;
    public final zzhp zze;
    public final zzhp zzf;

    public zzoa(zzpv zzpvVar) {
        super(zzpvVar);
        this.f14345b = new HashMap();
        ub3 zzm = this.zzu.zzm();
        Objects.requireNonNull(zzm);
        this.zza = new zzhp(zzm, "last_delete_stale", 0L);
        ub3 zzm2 = this.zzu.zzm();
        Objects.requireNonNull(zzm2);
        this.zzb = new zzhp(zzm2, "last_delete_stale_batch", 0L);
        ub3 zzm3 = this.zzu.zzm();
        Objects.requireNonNull(zzm3);
        this.zzc = new zzhp(zzm3, "backoff", 0L);
        ub3 zzm4 = this.zzu.zzm();
        Objects.requireNonNull(zzm4);
        this.zzd = new zzhp(zzm4, "last_upload", 0L);
        ub3 zzm5 = this.zzu.zzm();
        Objects.requireNonNull(zzm5);
        this.zze = new zzhp(zzm5, "last_upload_attempt", 0L);
        ub3 zzm6 = this.zzu.zzm();
        Objects.requireNonNull(zzm6);
        this.zzf = new zzhp(zzm6, "midnight_offset", 0L);
    }

    /* renamed from: a */
    public final Pair m3592a(String str) {
        be3 be3Var;
        AdvertisingIdClient.Info info;
        zzg();
        zzio zzioVar = this.zzu;
        long elapsedRealtime = zzioVar.zzaU().elapsedRealtime();
        HashMap hashMap = this.f14345b;
        be3 be3Var2 = (be3) hashMap.get(str);
        if (be3Var2 != null && elapsedRealtime < be3Var2.f7989c) {
            return new Pair(be3Var2.f7987a, Boolean.valueOf(be3Var2.f7988b));
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        long zzk = zzioVar.zzf().zzk(str, zzgi.zza) + elapsedRealtime;
        try {
            try {
                info = AdvertisingIdClient.getAdvertisingIdInfo(zzioVar.zzaT());
            } catch (PackageManager.NameNotFoundException unused) {
                info = null;
                if (be3Var2 != null && elapsedRealtime < be3Var2.f7989c + this.zzu.zzf().zzk(str, zzgi.zzb)) {
                    return new Pair(be3Var2.f7987a, Boolean.valueOf(be3Var2.f7988b));
                }
            }
        } catch (Exception e) {
            this.zzu.zzaW().zzd().zzb("Unable to get advertising id", e);
            be3Var = new be3(false, "", zzk);
        }
        if (info == null) {
            return new Pair("00000000-0000-0000-0000-000000000000", Boolean.FALSE);
        }
        String id = info.getId();
        if (id != null) {
            be3Var = new be3(info.isLimitAdTrackingEnabled(), id, zzk);
        } else {
            be3Var = new be3(info.isLimitAdTrackingEnabled(), "", zzk);
        }
        hashMap.put(str, be3Var);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair(be3Var.f7987a, Boolean.valueOf(be3Var.f7988b));
    }

    /* renamed from: b */
    public final String m3593b(String str, boolean z) {
        String str2;
        zzg();
        if (z) {
            str2 = (String) m3592a(str).first;
        } else {
            str2 = "00000000-0000-0000-0000-000000000000";
        }
        MessageDigest m3707f = zzqf.m3707f();
        if (m3707f == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, m3707f.digest(str2.getBytes())));
    }

    @Override // p000.re3
    public final boolean zzb() {
        return false;
    }
}
