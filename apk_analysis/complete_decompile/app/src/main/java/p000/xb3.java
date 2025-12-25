package p000;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzjp;
import com.google.android.gms.measurement.internal.zzpv;
import com.google.android.gms.measurement.internal.zzr;

/* loaded from: classes.dex */
public final class xb3 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f28500a;

    /* renamed from: b */
    public final /* synthetic */ zzr f28501b;

    /* renamed from: c */
    public final /* synthetic */ zzjp f28502c;

    public /* synthetic */ xb3(zzjp zzjpVar, zzr zzrVar, int i) {
        this.f28500a = i;
        this.f28501b = zzrVar;
        this.f28502c = zzjpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f28500a) {
            case 0:
                zzjp zzjpVar = this.f28502c;
                zzjpVar.f14280a.m3643c();
                zzjpVar.f14280a.m3620G(this.f28501b);
                return;
            case 1:
                zzjp zzjpVar2 = this.f28502c;
                zzjpVar2.f14280a.m3643c();
                zzpv zzpvVar = zzjpVar2.f14280a;
                zzpvVar.zzaX().zzg();
                zzpvVar.m3644d();
                zzr zzrVar = this.f28501b;
                Preconditions.checkNotEmpty(zzrVar.zza);
                zzpvVar.m3637X(zzrVar);
                return;
            default:
                zzjp zzjpVar3 = this.f28502c;
                zzjpVar3.f14280a.m3643c();
                zzpv zzpvVar2 = zzjpVar3.f14280a;
                zzpvVar2.zzaX().zzg();
                zzpvVar2.m3644d();
                zzr zzrVar2 = this.f28501b;
                Preconditions.checkNotEmpty(zzrVar2.zza);
                zzpvVar2.m3624K(zzrVar2);
                zzpvVar2.m3623J(zzrVar2);
                return;
        }
    }
}
