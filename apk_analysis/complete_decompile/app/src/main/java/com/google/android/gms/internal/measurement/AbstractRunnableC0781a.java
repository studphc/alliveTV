package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.a */
/* loaded from: classes.dex */
public abstract class AbstractRunnableC0781a implements Runnable {

    /* renamed from: a */
    public final long f13747a;

    /* renamed from: b */
    public final long f13748b;

    /* renamed from: c */
    public final boolean f13749c;

    /* renamed from: d */
    public final /* synthetic */ zzff f13750d;

    public AbstractRunnableC0781a(zzff zzffVar, boolean z) {
        this.f13750d = zzffVar;
        this.f13747a = zzffVar.zza.currentTimeMillis();
        this.f13748b = zzffVar.zza.elapsedRealtime();
        this.f13749c = z;
    }

    /* renamed from: a */
    public abstract void mo46a();

    /* renamed from: b */
    public void mo47b() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzff zzffVar = this.f13750d;
        if (zzffVar.f13818e) {
            mo47b();
            return;
        }
        try {
            mo46a();
        } catch (Exception e) {
            zzffVar.m3293a(e, false, this.f13749c);
            mo47b();
        }
    }
}
