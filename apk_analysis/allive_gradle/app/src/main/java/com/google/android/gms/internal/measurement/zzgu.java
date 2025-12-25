package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class zzgu extends zzmd implements zzni {
    private static final zzgu zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";

    static {
        zzgu zzguVar = new zzgu();
        zzb = zzguVar;
        zzmd.zzct(zzgu.class, zzguVar);
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
                return new zzgu();
            }
            return zzmd.zzcq(zzb, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        return (byte) 1;
    }
}
