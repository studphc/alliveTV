package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.util.Log;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class zzcs extends zzcx {

    /* renamed from: a */
    public final AtomicReference f13807a = new AtomicReference();

    /* renamed from: b */
    public boolean f13808b;

    public static final Object zzf(Bundle bundle, Class cls) {
        Object obj;
        if (bundle == null || (obj = bundle.get("r")) == null) {
            return null;
        }
        try {
            return cls.cast(obj);
        } catch (ClassCastException e) {
            Log.w("AM", "Unexpected object type. Expected, Received: " + cls.getCanonicalName() + ", " + obj.getClass().getCanonicalName(), e);
            throw e;
        }
    }

    public final Bundle zzb(long j) {
        Bundle bundle;
        AtomicReference atomicReference = this.f13807a;
        synchronized (atomicReference) {
            if (!this.f13808b) {
                try {
                    atomicReference.wait(j);
                } catch (InterruptedException unused) {
                    return null;
                }
            }
            bundle = (Bundle) this.f13807a.get();
        }
        return bundle;
    }

    public final Long zzc(long j) {
        return (Long) zzf(zzb(j), Long.class);
    }

    public final String zzd(long j) {
        return (String) zzf(zzb(j), String.class);
    }

    @Override // com.google.android.gms.internal.measurement.zzcy
    public final void zze(Bundle bundle) {
        AtomicReference atomicReference = this.f13807a;
        synchronized (atomicReference) {
            try {
                try {
                    atomicReference.set(bundle);
                    this.f13808b = true;
                } finally {
                    this.f13807a.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
