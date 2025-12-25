package p000;

import com.google.android.gms.measurement.internal.zzjx;
import com.google.android.gms.measurement.internal.zzlw;

/* loaded from: classes.dex */
public final class yc3 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f28899a;

    /* renamed from: b */
    public final /* synthetic */ zzjx f28900b;

    /* renamed from: c */
    public final /* synthetic */ long f28901c;

    /* renamed from: d */
    public final /* synthetic */ boolean f28902d;

    /* renamed from: e */
    public final /* synthetic */ zzlw f28903e;

    public /* synthetic */ yc3(zzlw zzlwVar, zzjx zzjxVar, long j, boolean z, int i) {
        this.f28899a = i;
        this.f28900b = zzjxVar;
        this.f28901c = j;
        this.f28902d = z;
        this.f28903e = zzlwVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f28899a) {
            case 0:
                zzlw zzlwVar = this.f28903e;
                zzjx zzjxVar = this.f28900b;
                zzlwVar.m3571g(zzjxVar);
                zzlw.m3565a(zzlwVar, zzjxVar, this.f28901c, true, this.f28902d);
                return;
            default:
                zzlw zzlwVar2 = this.f28903e;
                zzjx zzjxVar2 = this.f28900b;
                zzlwVar2.m3571g(zzjxVar2);
                zzlw.m3565a(zzlwVar2, zzjxVar2, this.f28901c, false, this.f28902d);
                return;
        }
    }
}
