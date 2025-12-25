package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
public enum zzmf {
    GOOGLE_ANALYTICS(0),
    GOOGLE_SIGNAL(1),
    SGTM(2),
    SGTM_CLIENT(3),
    GOOGLE_SIGNAL_PENDING(4),
    UNKNOWN(99);


    /* renamed from: a */
    public final int f14323a;

    zzmf(int i) {
        this.f14323a = i;
    }

    public static zzmf zzb(int i) {
        for (zzmf zzmfVar : values()) {
            if (zzmfVar.f14323a == i) {
                return zzmfVar;
            }
        }
        return UNKNOWN;
    }

    public final int zza() {
        return this.f14323a;
    }
}
