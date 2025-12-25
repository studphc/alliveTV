package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class zzfr extends zzmd implements zzni {
    private static final zzfr zzb;
    private int zzd;
    private int zze;
    private String zzf = "";
    private zzfl zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;

    static {
        zzfr zzfrVar = new zzfr();
        zzb = zzfrVar;
        zzmd.zzct(zzfr.class, zzfrVar);
    }

    /* renamed from: h */
    public static /* synthetic */ void m3300h(zzfr zzfrVar, String str) {
        zzfrVar.zzd |= 2;
        zzfrVar.zzf = str;
    }

    public static zzfq zzc() {
        return (zzfq) zzb.zzcg();
    }

    public final int zza() {
        return this.zze;
    }

    public final zzfl zzb() {
        zzfl zzflVar = this.zzg;
        if (zzflVar == null) {
            return zzfl.zzb();
        }
        return zzflVar;
    }

    public final String zze() {
        return this.zzf;
    }

    public final boolean zzg() {
        return this.zzh;
    }

    public final boolean zzh() {
        return this.zzi;
    }

    public final boolean zzi() {
        return this.zzj;
    }

    public final boolean zzj() {
        return (this.zzd & 1) != 0;
    }

    public final boolean zzk() {
        return (this.zzd & 32) != 0;
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
                return new zzfr();
            }
            return zzmd.zzcq(zzb, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0003ဉ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        }
        return (byte) 1;
    }
}
