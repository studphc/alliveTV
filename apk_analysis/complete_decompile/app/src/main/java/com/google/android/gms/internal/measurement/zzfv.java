package com.google.android.gms.internal.measurement;

import java.util.List;
import p000.lb3;

/* loaded from: classes.dex */
public final class zzfv extends zzmd implements zzni {
    private static final zzfv zzb;
    private int zzd;
    private int zze;
    private boolean zzg;
    private String zzf = "";
    private zzmj zzh = zzmd.zzcn();

    static {
        zzfv zzfvVar = new zzfv();
        zzb = zzfvVar;
        zzmd.zzct(zzfv.class, zzfvVar);
    }

    public static zzfv zzc() {
        return zzb;
    }

    public final int zza() {
        return this.zzh.size();
    }

    public final String zzd() {
        return this.zzf;
    }

    public final List zze() {
        return this.zzh;
    }

    public final boolean zzf() {
        return this.zzg;
    }

    public final boolean zzg() {
        return (this.zzd & 4) != 0;
    }

    public final boolean zzh() {
        return (this.zzd & 2) != 0;
    }

    public final boolean zzi() {
        return (this.zzd & 1) != 0;
    }

    public final int zzj() {
        int zza = zzfu.zza(this.zze);
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
                return new zzfv();
            }
            return zzmd.zzcq(zzb, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001᠌\u0000\u0002ဈ\u0001\u0003ဇ\u0002\u0004\u001a", new Object[]{"zzd", "zze", lb3.f22438c, "zzf", "zzg", "zzh"});
        }
        return (byte) 1;
    }
}
