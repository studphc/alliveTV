package com.google.android.gms.common.internal;

import android.util.Log;

/* loaded from: classes.dex */
public abstract class zzc {

    /* renamed from: a */
    public Object f13518a;

    /* renamed from: b */
    public boolean f13519b = false;

    /* renamed from: c */
    public final /* synthetic */ BaseGmsClient f13520c;

    public zzc(BaseGmsClient baseGmsClient, Object obj) {
        this.f13520c = baseGmsClient;
        this.f13518a = obj;
    }

    public abstract void zza(Object obj);

    public abstract void zzc();

    public final void zze() {
        Object obj;
        synchronized (this) {
            try {
                obj = this.f13518a;
                if (this.f13519b) {
                    Log.w("GmsClient", "Callback proxy " + toString() + " being reused. This is not safe.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (obj != null) {
            zza(obj);
        }
        synchronized (this) {
            this.f13519b = true;
        }
        zzg();
    }

    public final void zzf() {
        synchronized (this) {
            this.f13518a = null;
        }
    }

    public final void zzg() {
        zzf();
        synchronized (this.f13520c.f13386q) {
            this.f13520c.f13386q.remove(this);
        }
    }
}
