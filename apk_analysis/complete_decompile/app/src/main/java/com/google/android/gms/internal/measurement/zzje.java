package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class zzje {

    /* renamed from: a */
    public static zzjd f13828a;

    public static synchronized zzjd zza() {
        zzjd zzjdVar;
        synchronized (zzje.class) {
            try {
                if (f13828a == null) {
                    zzb(new zzjh());
                }
                zzjdVar = f13828a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzjdVar;
    }

    public static synchronized void zzb(zzjd zzjdVar) {
        synchronized (zzje.class) {
            if (f13828a == null) {
                f13828a = zzjdVar;
            } else {
                throw new IllegalStateException("init() already called");
            }
        }
    }
}
