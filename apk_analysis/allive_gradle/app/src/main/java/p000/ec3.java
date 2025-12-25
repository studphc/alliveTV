package p000;

import android.os.Bundle;
import com.google.android.gms.measurement.internal.zzjp;
import com.google.android.gms.measurement.internal.zzr;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class ec3 implements Callable {

    /* renamed from: a */
    public final /* synthetic */ int f16762a;

    /* renamed from: b */
    public final /* synthetic */ Object f16763b;

    /* renamed from: c */
    public final /* synthetic */ Object f16764c;

    /* renamed from: d */
    public final /* synthetic */ Object f16765d;

    public /* synthetic */ ec3(Object obj, Object obj2, Object obj3, int i) {
        this.f16762a = i;
        this.f16763b = obj2;
        this.f16764c = obj3;
        this.f16765d = obj;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f16762a) {
            case 0:
                zzjp zzjpVar = (zzjp) this.f16765d;
                zzjpVar.f14280a.m3643c();
                return zzjpVar.f14280a.m3642b((zzr) this.f16763b, (Bundle) this.f16764c);
            case 1:
                zzjp zzjpVar2 = (zzjp) this.f16765d;
                zzjpVar2.f14280a.m3643c();
                return zzjpVar2.f14280a.m3642b((zzr) this.f16763b, (Bundle) this.f16764c);
            default:
                return ((C1235gk) this.f16765d).f17728a.reload(this.f16763b, this.f16764c).get();
        }
    }
}
