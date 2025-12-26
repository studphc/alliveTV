package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: classes.dex */
public final class zzhm extends zzmd implements zzni {
    private static final zzhm zzb;
    private int zzd;
    private zzmj zze = zzmd.zzcn();
    private String zzf = "";
    private long zzg;
    private long zzh;
    private int zzi;

    static {
        zzhm zzhmVar = new zzhm();
        zzb = zzhmVar;
        zzmd.zzct(zzhm.class, zzhmVar);
    }

    /* renamed from: h */
    public static /* synthetic */ void m3332h(zzhm zzhmVar, Iterable iterable) {
        zzhmVar.m3340p();
        zzko.zzcc(iterable, zzhmVar.zze);
    }

    /* renamed from: i */
    public static /* synthetic */ void m3333i(zzhm zzhmVar, zzhq zzhqVar) {
        zzhqVar.getClass();
        zzhmVar.m3340p();
        zzhmVar.zze.add(zzhqVar);
    }

    /* renamed from: k */
    public static /* synthetic */ void m3335k(int i, zzhm zzhmVar) {
        zzhmVar.m3340p();
        zzhmVar.zze.remove(i);
    }

    /* renamed from: l */
    public static /* synthetic */ void m3336l(zzhm zzhmVar, String str) {
        str.getClass();
        zzhmVar.zzd |= 1;
        zzhmVar.zzf = str;
    }

    /* renamed from: m */
    public static /* synthetic */ void m3337m(zzhm zzhmVar, int i, zzhq zzhqVar) {
        zzhqVar.getClass();
        zzhmVar.m3340p();
        zzhmVar.zze.set(i, zzhqVar);
    }

    /* renamed from: n */
    public static /* synthetic */ void m3338n(long j, zzhm zzhmVar) {
        zzhmVar.zzd |= 4;
        zzhmVar.zzh = j;
    }

    /* renamed from: o */
    public static /* synthetic */ void m3339o(long j, zzhm zzhmVar) {
        zzhmVar.zzd |= 2;
        zzhmVar.zzg = j;
    }

    public static zzhl zze() {
        return (zzhl) zzb.zzcg();
    }

    /* renamed from: p */
    public final void m3340p() {
        zzmj zzmjVar = this.zze;
        if (!zzmjVar.zzc()) {
            this.zze = zzmd.zzco(zzmjVar);
        }
    }

    public final int zza() {
        return this.zzi;
    }

    public final int zzb() {
        return this.zze.size();
    }

    public final long zzc() {
        return this.zzh;
    }

    public final long zzd() {
        return this.zzg;
    }

    public final zzhq zzg(int i) {
        return (zzhq) this.zze.get(i);
    }

    public final String zzh() {
        return this.zzf;
    }

    public final List zzi() {
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
                return new zzhm();
            }
            return zzmd.zzcq(zzb, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u001b\u0002ဈ\u0000\u0003ဂ\u0001\u0004ဂ\u0002\u0005င\u0003", new Object[]{"zzd", "zze", zzhq.class, "zzf", "zzg", "zzh", "zzi"});
        }
        return (byte) 1;
    }

    public final boolean zzs() {
        return (this.zzd & 8) != 0;
    }

    public final boolean zzt() {
        return (this.zzd & 4) != 0;
    }

    public final boolean zzu() {
        return (this.zzd & 2) != 0;
    }
}
