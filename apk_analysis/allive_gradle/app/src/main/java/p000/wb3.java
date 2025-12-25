package p000;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzap;
import com.google.android.gms.measurement.internal.zzjp;
import com.google.android.gms.measurement.internal.zzjw;
import com.google.android.gms.measurement.internal.zzjx;
import com.google.android.gms.measurement.internal.zzpv;
import com.google.android.gms.measurement.internal.zzr;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class wb3 implements Callable {

    /* renamed from: a */
    public final /* synthetic */ int f28132a;

    /* renamed from: b */
    public final /* synthetic */ Object f28133b;

    /* renamed from: c */
    public final /* synthetic */ Object f28134c;

    public /* synthetic */ wb3(int i, Object obj, Object obj2) {
        this.f28132a = i;
        this.f28134c = obj2;
        this.f28133b = obj;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        switch (this.f28132a) {
            case 0:
                zzjp zzjpVar = (zzjp) this.f28133b;
                zzjpVar.f14280a.m3643c();
                return zzjpVar.f14280a.zzj().m7857e((String) this.f28134c);
            case 1:
                zzjp zzjpVar2 = (zzjp) this.f28133b;
                zzjpVar2.f14280a.m3643c();
                return new zzap(zzjpVar2.f14280a.m3635V(((zzr) this.f28134c).zza));
            default:
                zzr zzrVar = (zzr) this.f28134c;
                String str = (String) Preconditions.checkNotNull(zzrVar.zza);
                zzpv zzpvVar = (zzpv) this.f28133b;
                zzjx m3641a0 = zzpvVar.m3641a0(str);
                zzjw zzjwVar = zzjw.ANALYTICS_STORAGE;
                if (m3641a0.zzr(zzjwVar) && zzjx.zzk(zzrVar.zzu, 100).zzr(zzjwVar)) {
                    return zzpvVar.m3637X(zzrVar).m6537d();
                }
                zzpvVar.zzaW().zzj().zza("Analytics storage consent denied. Returning null app instance id");
                return null;
        }
    }
}
