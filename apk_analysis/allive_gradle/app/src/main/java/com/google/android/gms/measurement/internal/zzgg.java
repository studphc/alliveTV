package com.google.android.gms.measurement.internal;

import p000.nb3;
import p000.p63;

/* loaded from: classes.dex */
public final class zzgg {

    /* renamed from: f */
    public static final Object f14152f = new Object();

    /* renamed from: a */
    public final String f14153a;

    /* renamed from: b */
    public final nb3 f14154b;

    /* renamed from: c */
    public final Object f14155c;

    /* renamed from: d */
    public final Object f14156d = new Object();

    /* renamed from: e */
    public volatile Object f14157e = null;

    public /* synthetic */ zzgg(String str, Object obj, nb3 nb3Var) {
        this.f14153a = str;
        this.f14155c = obj;
        this.f14154b = nb3Var;
    }

    public final Object zza(Object obj) {
        Object obj2;
        synchronized (this.f14156d) {
        }
        if (obj != null) {
            return obj;
        }
        if (p63.f25051e == null) {
            return this.f14155c;
        }
        synchronized (f14152f) {
            try {
                if (zzaf.zza()) {
                    if (this.f14157e == null) {
                        obj2 = this.f14155c;
                    } else {
                        obj2 = this.f14157e;
                    }
                    return obj2;
                }
                try {
                    for (zzgg zzggVar : zzgi.f14158a) {
                        if (!zzaf.zza()) {
                            Object obj3 = null;
                            try {
                                nb3 nb3Var = zzggVar.f14154b;
                                if (nb3Var != null) {
                                    obj3 = nb3Var.zza();
                                }
                            } catch (IllegalStateException unused) {
                            }
                            synchronized (f14152f) {
                                zzggVar.f14157e = obj3;
                            }
                        } else {
                            throw new IllegalStateException("Refreshing flag cache must be done on a worker thread.");
                        }
                    }
                } catch (SecurityException unused2) {
                }
                nb3 nb3Var2 = this.f14154b;
                if (nb3Var2 != null) {
                    try {
                        return nb3Var2.zza();
                    } catch (IllegalStateException | SecurityException unused3) {
                    }
                }
                return this.f14155c;
            } finally {
            }
        }
    }

    public final String zzb() {
        return this.f14153a;
    }
}
