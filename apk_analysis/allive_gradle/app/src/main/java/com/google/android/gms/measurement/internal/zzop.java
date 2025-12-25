package com.google.android.gms.measurement.internal;

import android.os.Looper;
import p000.he3;
import p000.mb3;

/* loaded from: classes.dex */
public final class zzop extends mb3 {

    /* renamed from: b */
    public com.google.android.gms.internal.measurement.zzcr f14347b;

    /* renamed from: c */
    public boolean f14348c;
    protected final C0816o0 zza;
    protected final C0814n0 zzb;
    protected final he3 zzc;

    public zzop(zzio zzioVar) {
        super(zzioVar);
        this.f14348c = true;
        this.zza = new C0816o0(this);
        this.zzb = new C0814n0(this);
        this.zzc = new he3(this);
    }

    /* renamed from: a */
    public final void m3594a() {
        zzg();
        if (this.f14347b == null) {
            this.f14347b = new com.google.android.gms.internal.measurement.zzcr(Looper.getMainLooper());
        }
    }

    @Override // p000.mb3
    public final boolean zzf() {
        return false;
    }
}
