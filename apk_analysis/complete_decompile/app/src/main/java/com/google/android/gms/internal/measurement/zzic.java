package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: classes.dex */
public final class zzic extends zzmd implements zzni {
    private static final zzic zzb;
    private zzmi zzd = zzmd.zzcl();
    private zzmi zze = zzmd.zzcl();
    private zzmj zzf = zzmd.zzcn();
    private zzmj zzg = zzmd.zzcn();

    static {
        zzic zzicVar = new zzic();
        zzb = zzicVar;
        zzmd.zzct(zzic.class, zzicVar);
    }

    /* renamed from: h */
    public static /* synthetic */ void m3434h(zzic zzicVar, Iterable iterable) {
        zzmj zzmjVar = zzicVar.zzf;
        if (!zzmjVar.zzc()) {
            zzicVar.zzf = zzmd.zzco(zzmjVar);
        }
        zzko.zzcc(iterable, zzicVar.zzf);
    }

    /* renamed from: i */
    public static /* synthetic */ void m3435i(zzic zzicVar, Iterable iterable) {
        zzmi zzmiVar = zzicVar.zze;
        if (!zzmiVar.zzc()) {
            zzicVar.zze = zzmd.zzcm(zzmiVar);
        }
        zzko.zzcc(iterable, zzicVar.zze);
    }

    /* renamed from: j */
    public static /* synthetic */ void m3436j(zzic zzicVar, Iterable iterable) {
        zzmj zzmjVar = zzicVar.zzg;
        if (!zzmjVar.zzc()) {
            zzicVar.zzg = zzmd.zzco(zzmjVar);
        }
        zzko.zzcc(iterable, zzicVar.zzg);
    }

    /* renamed from: k */
    public static /* synthetic */ void m3437k(zzic zzicVar, Iterable iterable) {
        zzmi zzmiVar = zzicVar.zzd;
        if (!zzmiVar.zzc()) {
            zzicVar.zzd = zzmd.zzcm(zzmiVar);
        }
        zzko.zzcc(iterable, zzicVar.zzd);
    }

    public static zzib zze() {
        return (zzib) zzb.zzcg();
    }

    public static zzic zzg() {
        return zzb;
    }

    public final int zza() {
        return this.zzf.size();
    }

    public final int zzb() {
        return this.zze.size();
    }

    public final int zzc() {
        return this.zzg.size();
    }

    public final int zzd() {
        return this.zzd.size();
    }

    public final List zzh() {
        return this.zzf;
    }

    public final List zzi() {
        return this.zze;
    }

    public final List zzj() {
        return this.zzg;
    }

    public final List zzk() {
        return this.zzd;
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
                return new zzic();
            }
            return zzmd.zzcq(zzb, "\u0004\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0000\u0001\u0015\u0002\u0015\u0003\u001b\u0004\u001b", new Object[]{"zzd", "zze", "zzf", zzhk.class, "zzg", zzie.class});
        }
        return (byte) 1;
    }
}
