package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class zzgk extends zzmd implements zzni {
    private static final zzgk zzb;
    private int zzd;
    private String zze = "";
    private zzmj zzf = zzmd.zzcn();
    private boolean zzg;

    static {
        zzgk zzgkVar = new zzgk();
        zzb = zzgkVar;
        zzmd.zzct(zzgk.class, zzgkVar);
    }

    public final String zzb() {
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
                return new zzgk();
            }
            return zzmd.zzcq(zzb, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b\u0003ဇ\u0001", new Object[]{"zzd", "zze", "zzf", zzgu.class, "zzg"});
        }
        return (byte) 1;
    }
}
