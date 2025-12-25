package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class zzhs extends zzmd implements zzni {
    private static final zzhs zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private zzhe zzg;

    static {
        zzhs zzhsVar = new zzhs();
        zzb = zzhsVar;
        zzmd.zzct(zzhs.class, zzhsVar);
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
                return new zzhs();
            }
            return zzmd.zzcq(zzb, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဉ\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        return (byte) 1;
    }
}
