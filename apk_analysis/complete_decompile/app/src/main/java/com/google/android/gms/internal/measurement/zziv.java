package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: classes.dex */
public final class zziv extends zzmd implements zzni {
    private static final zziv zzb;
    private int zzd;
    private zzmj zze = zzmd.zzcn();
    private zzir zzf;

    static {
        zziv zzivVar = new zziv();
        zzb = zzivVar;
        zzmd.zzct(zziv.class, zzivVar);
    }

    public final zzir zza() {
        zzir zzirVar = this.zzf;
        if (zzirVar == null) {
            return zzir.zzc();
        }
        return zzirVar;
    }

    public final List zzc() {
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
                return new zziv();
            }
            return zzmd.zzcq(zzb, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000", new Object[]{"zzd", "zze", zziz.class, "zzf"});
        }
        return (byte) 1;
    }
}
