package com.google.android.gms.internal.measurement;

import java.util.List;
import p000.lb3;

/* loaded from: classes.dex */
public final class zzhv extends zzmd implements zzni {
    private static final zzhv zzb;
    private int zzd;
    private zzmj zze = zzmd.zzcn();
    private String zzf = "";
    private String zzg = "";
    private int zzh;

    static {
        zzhv zzhvVar = new zzhv();
        zzb = zzhvVar;
        zzmd.zzct(zzhv.class, zzhvVar);
    }

    /* renamed from: h */
    public static void m3353h(zzhv zzhvVar, Iterable iterable) {
        zzmj zzmjVar = zzhvVar.zze;
        if (!zzmjVar.zzc()) {
            zzhvVar.zze = zzmd.zzco(zzmjVar);
        }
        zzko.zzcc(iterable, zzhvVar.zze);
    }

    /* renamed from: i */
    public static void m3354i(zzhv zzhvVar, zzhx zzhxVar) {
        zzhxVar.getClass();
        zzmj zzmjVar = zzhvVar.zze;
        if (!zzmjVar.zzc()) {
            zzhvVar.zze = zzmd.zzco(zzmjVar);
        }
        zzhvVar.zze.add(zzhxVar);
    }

    /* renamed from: k */
    public static void m3356k(zzhv zzhvVar, int i, zzhx zzhxVar) {
        zzhxVar.getClass();
        zzmj zzmjVar = zzhvVar.zze;
        if (!zzmjVar.zzc()) {
            zzhvVar.zze = zzmd.zzco(zzmjVar);
        }
        zzhvVar.zze.set(i, zzhxVar);
    }

    /* renamed from: l */
    public static /* synthetic */ void m3357l(zzhv zzhvVar, String str) {
        str.getClass();
        zzhvVar.zzd |= 1;
        zzhvVar.zzf = str;
    }

    /* renamed from: m */
    public static /* synthetic */ void m3358m(zzhv zzhvVar, String str) {
        str.getClass();
        zzhvVar.zzd |= 2;
        zzhvVar.zzg = str;
    }

    public static zzht zzb() {
        return (zzht) zzb.zzcg();
    }

    public static zzht zzc(zzhv zzhvVar) {
        zzlz zzcg = zzb.zzcg();
        zzcg.zzaY(zzhvVar);
        return (zzht) zzcg;
    }

    public final int zza() {
        return this.zze.size();
    }

    public final zzhx zze(int i) {
        return (zzhx) this.zze.get(i);
    }

    public final String zzf() {
        return this.zzf;
    }

    public final String zzg() {
        return this.zzg;
    }

    public final List zzh() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.measurement.zzmd
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 == 5) {
                            return zzb;
                        }
                        throw null;
                    }
                    return new zzlz(zzb);
                }
                return new zzhv();
            }
            return zzmd.zzcq(zzb, "\u0004\u0004\u0000\u0001\u0001\t\u0004\u0000\u0001\u0000\u0001\u001b\u0007ဈ\u0000\bဈ\u0001\t᠌\u0002", new Object[]{"zzd", "zze", zzhx.class, "zzf", "zzg", "zzh", lb3.f22442g});
        }
        return (byte) 1;
    }

    public final boolean zzp() {
        return (this.zzd & 1) != 0;
    }

    public final boolean zzq() {
        return (this.zzd & 2) != 0;
    }
}
