package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class zzbc {

    /* renamed from: a */
    public final String f14142a;

    /* renamed from: b */
    public final String f14143b;

    /* renamed from: c */
    public final String f14144c;

    /* renamed from: d */
    public final long f14145d;

    /* renamed from: e */
    public final long f14146e;

    /* renamed from: f */
    public final zzbf f14147f;

    public zzbc(zzio zzioVar, String str, String str2, String str3, long j, long j2, Bundle bundle) {
        zzbf zzbfVar;
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        this.f14142a = str2;
        this.f14143b = str3;
        this.f14144c = true == TextUtils.isEmpty(str) ? null : str;
        this.f14145d = j;
        this.f14146e = j2;
        if (j2 != 0 && j2 > j) {
            zzioVar.zzaW().zzk().zzb("Event created with reverse previous/current timestamps. appId", zzhe.zzn(str2));
        }
        if (bundle != null && !bundle.isEmpty()) {
            Bundle bundle2 = new Bundle(bundle);
            Iterator<String> it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next == null) {
                    zzioVar.zzaW().zze().zza("Param name can't be null");
                    it.remove();
                } else {
                    Object m3724c = zzioVar.zzw().m3724c(bundle2.get(next), next);
                    if (m3724c == null) {
                        zzioVar.zzaW().zzk().zzb("Param value can't be null", zzioVar.zzj().zze(next));
                        it.remove();
                    } else {
                        zzioVar.zzw().m3733n(bundle2, next, m3724c);
                    }
                }
            }
            zzbfVar = new zzbf(bundle2);
        } else {
            zzbfVar = new zzbf(new Bundle());
        }
        this.f14147f = zzbfVar;
    }

    /* renamed from: a */
    public final zzbc m3516a(zzio zzioVar, long j) {
        return new zzbc(zzioVar, this.f14144c, this.f14142a, this.f14143b, this.f14145d, j, this.f14147f);
    }

    public final String toString() {
        return "Event{appId='" + this.f14142a + "', name='" + this.f14143b + "', params=" + this.f14147f.toString() + "}";
    }

    public zzbc(zzio zzioVar, String str, String str2, String str3, long j, long j2, zzbf zzbfVar) {
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(zzbfVar);
        this.f14142a = str2;
        this.f14143b = str3;
        this.f14144c = true == TextUtils.isEmpty(str) ? null : str;
        this.f14145d = j;
        this.f14146e = j2;
        if (j2 != 0 && j2 > j) {
            zzioVar.zzaW().zzk().zzc("Event created with reverse previous/current timestamps. appId, name", zzhe.zzn(str2), zzhe.zzn(str3));
        }
        this.f14147f = zzbfVar;
    }
}
