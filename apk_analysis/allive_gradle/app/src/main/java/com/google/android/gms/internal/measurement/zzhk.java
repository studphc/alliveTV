package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class zzhk extends zzmd implements zzni {
    private static final zzhk zzb;
    private int zzd;
    private int zze;
    private long zzf;

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.measurement.zzhk, com.google.android.gms.internal.measurement.zzmd] */
    static {
        ?? zzmdVar = new zzmd();
        zzb = zzmdVar;
        zzmd.zzct(zzhk.class, zzmdVar);
    }

    /* renamed from: h */
    public static /* synthetic */ void m3330h(zzhk zzhkVar, long j) {
        zzhkVar.zzd |= 2;
        zzhkVar.zzf = j;
    }

    /* renamed from: i */
    public static /* synthetic */ void m3331i(zzhk zzhkVar, int i) {
        zzhkVar.zzd |= 1;
        zzhkVar.zze = i;
    }

    public static zzhj zzc() {
        return (zzhj) zzb.zzcg();
    }

    public final int zza() {
        return this.zze;
    }

    public final long zzb() {
        return this.zzf;
    }

    public final boolean zzg() {
        return (this.zzd & 2) != 0;
    }

    public final boolean zzh() {
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
            return zzmd.zzcq(zzb, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဂ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        return (byte) 1;
    }
}
