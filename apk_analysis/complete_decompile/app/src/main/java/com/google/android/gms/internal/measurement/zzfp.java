package com.google.android.gms.internal.measurement;

import p000.lb3;

/* loaded from: classes.dex */
public final class zzfp extends zzmd implements zzni {
    private static final zzfp zzb;
    private int zzd;
    private int zze;
    private boolean zzf;
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";

    static {
        zzfp zzfpVar = new zzfp();
        zzb = zzfpVar;
        zzmd.zzct(zzfp.class, zzfpVar);
    }

    public static zzfp zzb() {
        return zzb;
    }

    public final String zzc() {
        return this.zzg;
    }

    public final String zzd() {
        return this.zzi;
    }

    public final String zze() {
        return this.zzh;
    }

    public final boolean zzf() {
        return this.zzf;
    }

    public final boolean zzg() {
        return (this.zzd & 1) != 0;
    }

    public final boolean zzh() {
        return (this.zzd & 4) != 0;
    }

    public final boolean zzi() {
        return (this.zzd & 2) != 0;
    }

    public final boolean zzj() {
        return (this.zzd & 16) != 0;
    }

    public final boolean zzk() {
        return (this.zzd & 8) != 0;
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
                return new zzfp();
            }
            return zzmd.zzcq(zzb, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001᠌\u0000\u0002ဇ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004", new Object[]{"zzd", "zze", lb3.f22437b, "zzf", "zzg", "zzh", "zzi"});
        }
        return (byte) 1;
    }

    public final int zzm() {
        int zza = zzfo.zza(this.zze);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }
}
