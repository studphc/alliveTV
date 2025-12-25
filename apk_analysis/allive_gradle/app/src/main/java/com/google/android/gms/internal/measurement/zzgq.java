package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class zzgq extends zzmd implements zzni {
    private static final zzgq zzb;
    private zzmj zzd = zzmd.zzcn();

    static {
        zzgq zzgqVar = new zzgq();
        zzb = zzgqVar;
        zzmd.zzct(zzgq.class, zzgqVar);
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
                return new zzgq();
            }
            return zzmd.zzcq(zzb, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"zzd"});
        }
        return (byte) 1;
    }
}
