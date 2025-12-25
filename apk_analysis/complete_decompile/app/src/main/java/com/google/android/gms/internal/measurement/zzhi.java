package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class zzhi extends zzmd implements zzni {
    private static final zzhi zzb;
    private int zzd;
    private int zze;
    private zzic zzf;
    private zzic zzg;
    private boolean zzh;

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.measurement.zzhi, com.google.android.gms.internal.measurement.zzmd] */
    static {
        ?? zzmdVar = new zzmd();
        zzb = zzmdVar;
        zzmd.zzct(zzhi.class, zzmdVar);
    }

    /* renamed from: h */
    public static /* synthetic */ void m3326h(zzhi zzhiVar, int i) {
        zzhiVar.zzd |= 1;
        zzhiVar.zze = i;
    }

    /* renamed from: i */
    public static /* synthetic */ void m3327i(zzhi zzhiVar, zzic zzicVar) {
        zzicVar.getClass();
        zzhiVar.zzf = zzicVar;
        zzhiVar.zzd |= 2;
    }

    /* renamed from: j */
    public static /* synthetic */ void m3328j(zzhi zzhiVar, boolean z) {
        zzhiVar.zzd |= 8;
        zzhiVar.zzh = z;
    }

    /* renamed from: k */
    public static /* synthetic */ void m3329k(zzhi zzhiVar, zzic zzicVar) {
        zzhiVar.zzg = zzicVar;
        zzhiVar.zzd |= 4;
    }

    public static zzhh zzb() {
        return (zzhh) zzb.zzcg();
    }

    public final int zza() {
        return this.zze;
    }

    public final zzic zzd() {
        zzic zzicVar = this.zzf;
        if (zzicVar == null) {
            return zzic.zzg();
        }
        return zzicVar;
    }

    public final zzic zze() {
        zzic zzicVar = this.zzg;
        if (zzicVar == null) {
            return zzic.zzg();
        }
        return zzicVar;
    }

    public final boolean zzj() {
        return this.zzh;
    }

    public final boolean zzk() {
        return (this.zzd & 1) != 0;
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
                return new zzmd();
            }
            return zzmd.zzcq(zzb, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဇ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        }
        return (byte) 1;
    }

    public final boolean zzm() {
        return (this.zzd & 8) != 0;
    }

    public final boolean zzn() {
        return (this.zzd & 4) != 0;
    }
}
