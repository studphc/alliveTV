package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: classes.dex */
public final class zzie extends zzmd implements zzni {
    private static final zzie zzb;
    private int zzd;
    private int zze;
    private zzmi zzf = zzmd.zzcl();

    static {
        zzie zzieVar = new zzie();
        zzb = zzieVar;
        zzmd.zzct(zzie.class, zzieVar);
    }

    /* renamed from: h */
    public static /* synthetic */ void m3442h(zzie zzieVar, Iterable iterable) {
        zzmi zzmiVar = zzieVar.zzf;
        if (!zzmiVar.zzc()) {
            zzieVar.zzf = zzmd.zzcm(zzmiVar);
        }
        zzko.zzcc(iterable, zzieVar.zzf);
    }

    /* renamed from: i */
    public static /* synthetic */ void m3443i(zzie zzieVar, int i) {
        zzieVar.zzd |= 1;
        zzieVar.zze = i;
    }

    public static zzid zzd() {
        return (zzid) zzb.zzcg();
    }

    public final int zza() {
        return this.zzf.size();
    }

    public final int zzb() {
        return this.zze;
    }

    public final long zzc(int i) {
        return this.zzf.zza(i);
    }

    public final List zzf() {
        return this.zzf;
    }

    public final boolean zzi() {
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
                return new zzie();
            }
            return zzmd.zzcq(zzb, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001င\u0000\u0002\u0014", new Object[]{"zzd", "zze", "zzf"});
        }
        return (byte) 1;
    }
}
