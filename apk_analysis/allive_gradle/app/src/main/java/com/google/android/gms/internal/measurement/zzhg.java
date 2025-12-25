package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class zzhg extends zzmd implements zzni {
    private static final zzhg zzb;
    private int zzd;
    private boolean zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.measurement.zzhg, com.google.android.gms.internal.measurement.zzmd] */
    static {
        ?? zzmdVar = new zzmd();
        zzb = zzmdVar;
        zzmd.zzct(zzhg.class, zzmdVar);
    }

    /* renamed from: h */
    public static /* synthetic */ void m3319h(zzhg zzhgVar, boolean z) {
        zzhgVar.zzd |= 32;
        zzhgVar.zzj = z;
    }

    /* renamed from: i */
    public static /* synthetic */ void m3320i(zzhg zzhgVar, boolean z) {
        zzhgVar.zzd |= 16;
        zzhgVar.zzi = z;
    }

    /* renamed from: j */
    public static /* synthetic */ void m3321j(zzhg zzhgVar, boolean z) {
        zzhgVar.zzd |= 1;
        zzhgVar.zze = z;
    }

    /* renamed from: k */
    public static /* synthetic */ void m3322k(zzhg zzhgVar, boolean z) {
        zzhgVar.zzd |= 64;
        zzhgVar.zzk = z;
    }

    /* renamed from: l */
    public static /* synthetic */ void m3323l(zzhg zzhgVar, boolean z) {
        zzhgVar.zzd |= 2;
        zzhgVar.zzf = z;
    }

    /* renamed from: m */
    public static /* synthetic */ void m3324m(zzhg zzhgVar, boolean z) {
        zzhgVar.zzd |= 4;
        zzhgVar.zzg = z;
    }

    /* renamed from: n */
    public static /* synthetic */ void m3325n(zzhg zzhgVar, boolean z) {
        zzhgVar.zzd |= 8;
        zzhgVar.zzh = z;
    }

    public static zzhf zza() {
        return (zzhf) zzb.zzcg();
    }

    public static zzhg zzc() {
        return zzb;
    }

    public final boolean zzk() {
        return this.zzj;
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
            return zzmd.zzcq(zzb, "\u0004\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005\u0007ဇ\u0006", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        return (byte) 1;
    }

    public final boolean zzm() {
        return this.zzi;
    }

    public final boolean zzn() {
        return this.zze;
    }

    public final boolean zzo() {
        return this.zzk;
    }

    public final boolean zzp() {
        return this.zzf;
    }

    public final boolean zzq() {
        return this.zzg;
    }

    public final boolean zzr() {
        return this.zzh;
    }
}
