package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: classes.dex */
public final class zzir extends zzmd implements zzni {
    private static final zzir zzb;
    private zzmj zzd = zzmd.zzcn();

    static {
        zzir zzirVar = new zzir();
        zzb = zzirVar;
        zzmd.zzct(zzir.class, zzirVar);
    }

    public static zzir zzc() {
        return zzb;
    }

    public final int zza() {
        return this.zzd.size();
    }

    public final List zzd() {
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
                return new zzir();
            }
            return zzmd.zzcq(zzb, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", zzit.class});
        }
        return (byte) 1;
    }
}
