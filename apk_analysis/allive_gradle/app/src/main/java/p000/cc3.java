package p000;

import com.google.android.gms.measurement.internal.zzjp;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class cc3 implements Callable {

    /* renamed from: a */
    public final /* synthetic */ int f8328a;

    /* renamed from: b */
    public final /* synthetic */ String f8329b;

    /* renamed from: c */
    public final /* synthetic */ String f8330c;

    /* renamed from: d */
    public final /* synthetic */ String f8331d;

    /* renamed from: e */
    public final /* synthetic */ zzjp f8332e;

    public /* synthetic */ cc3(zzjp zzjpVar, String str, String str2, String str3, int i) {
        this.f8328a = i;
        this.f8329b = str;
        this.f8330c = str2;
        this.f8331d = str3;
        this.f8332e = zzjpVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        switch (this.f8328a) {
            case 0:
                zzjp zzjpVar = this.f8332e;
                zzjpVar.f14280a.m3643c();
                return zzjpVar.f14280a.zzj().m7858f(this.f8329b, this.f8330c, this.f8331d);
            case 1:
                zzjp zzjpVar2 = this.f8332e;
                zzjpVar2.f14280a.m3643c();
                return zzjpVar2.f14280a.zzj().m7858f(this.f8329b, this.f8330c, this.f8331d);
            case 2:
                zzjp zzjpVar3 = this.f8332e;
                zzjpVar3.f14280a.m3643c();
                return zzjpVar3.f14280a.zzj().m7853b(this.f8329b, this.f8330c, this.f8331d);
            default:
                zzjp zzjpVar4 = this.f8332e;
                zzjpVar4.f14280a.m3643c();
                return zzjpVar4.f14280a.zzj().m7853b(this.f8329b, this.f8330c, this.f8331d);
        }
    }
}
