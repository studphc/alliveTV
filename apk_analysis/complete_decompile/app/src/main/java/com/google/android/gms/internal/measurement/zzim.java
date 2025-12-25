package com.google.android.gms.internal.measurement;

import p000.lb3;

/* loaded from: classes.dex */
public final class zzim extends zzmd implements zzni {
    private static final zzim zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.measurement.zzim, com.google.android.gms.internal.measurement.zzmd] */
    static {
        ?? zzmdVar = new zzmd();
        zzb = zzmdVar;
        zzmd.zzct(zzim.class, zzmdVar);
    }

    /* renamed from: h */
    public static /* synthetic */ void m3444h(zzim zzimVar, zzih zzihVar) {
        zzimVar.zzf = zzihVar.zza();
        zzimVar.zzd |= 2;
    }

    /* renamed from: i */
    public static /* synthetic */ void m3445i(zzim zzimVar, int i) {
        zzimVar.zzg = i - 1;
        zzimVar.zzd |= 4;
    }

    /* renamed from: j */
    public static /* synthetic */ void m3446j(zzim zzimVar, int i) {
        zzimVar.zze = i - 1;
        zzimVar.zzd |= 1;
    }

    public static zzif zza() {
        return (zzif) zzb.zzcg();
    }

    public static zzim zzd() {
        return zzb;
    }

    public final zzih zzb() {
        zzih zzb2 = zzih.zzb(this.zzf);
        return zzb2 == null ? zzih.CLIENT_UPLOAD_ELIGIBILITY_UNKNOWN : zzb2;
    }

    public final int zzf() {
        int zza = zzij.zza(this.zzg);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }

    public final int zzg() {
        int zza = zzil.zza(this.zze);
        if (zza == 0) {
            return 1;
        }
        return zza;
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
            return zzmd.zzcq(zzb, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003᠌\u0002", new Object[]{"zzd", "zze", lb3.f22446k, "zzf", lb3.f22444i, "zzg", lb3.f22445j});
        }
        return (byte) 1;
    }
}
