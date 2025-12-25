package com.google.android.gms.internal.measurement;

import p000.lb3;

/* loaded from: classes.dex */
public final class zzia extends zzmd implements zzni {
    private static final zzia zzb;
    private int zzd;
    private int zze = 1;
    private zzmj zzf = zzmd.zzcn();

    static {
        zzia zziaVar = new zzia();
        zzb = zziaVar;
        zzmd.zzct(zzia.class, zziaVar);
    }

    /* renamed from: h */
    public static /* synthetic */ void m3433h(zzia zziaVar, zzho zzhoVar) {
        zzhoVar.getClass();
        zzmj zzmjVar = zziaVar.zzf;
        if (!zzmjVar.zzc()) {
            zziaVar.zzf = zzmd.zzco(zzmjVar);
        }
        zziaVar.zzf.add(zzhoVar);
    }

    public static zzhy zza() {
        return (zzhy) zzb.zzcg();
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
                return new zzia();
            }
            return zzmd.zzcq(zzb, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001᠌\u0000\u0002\u001b", new Object[]{"zzd", "zze", lb3.f22443h, "zzf", zzho.class});
        }
        return (byte) 1;
    }
}
