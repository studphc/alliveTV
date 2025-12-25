package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class zzho extends zzmd implements zzni {
    private static final zzho zzb;
    private int zzd;
    private String zze = "";
    private long zzf;

    static {
        zzho zzhoVar = new zzho();
        zzb = zzhoVar;
        zzmd.zzct(zzho.class, zzhoVar);
    }

    /* renamed from: h */
    public static /* synthetic */ void m3341h(zzho zzhoVar, long j) {
        zzhoVar.zzd |= 2;
        zzhoVar.zzf = j;
    }

    /* renamed from: i */
    public static /* synthetic */ void m3342i(zzho zzhoVar, String str) {
        str.getClass();
        zzhoVar.zzd |= 1;
        zzhoVar.zze = str;
    }

    public static zzhn zza() {
        return (zzhn) zzb.zzcg();
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
                return new zzho();
            }
            return zzmd.zzcq(zzb, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        return (byte) 1;
    }
}
