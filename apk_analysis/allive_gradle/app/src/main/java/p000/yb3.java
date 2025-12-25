package p000;

import com.google.android.gms.measurement.internal.zzjp;
import com.google.android.gms.measurement.internal.zzlw;
import com.google.android.gms.measurement.internal.zzmh;

/* loaded from: classes.dex */
public final class yb3 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f28886a;

    /* renamed from: b */
    public final /* synthetic */ String f28887b;

    /* renamed from: c */
    public final /* synthetic */ String f28888c;

    /* renamed from: d */
    public final /* synthetic */ long f28889d;

    /* renamed from: e */
    public final /* synthetic */ Object f28890e;

    /* renamed from: f */
    public final /* synthetic */ Object f28891f;

    public /* synthetic */ yb3(Object obj, String str, String str2, Object obj2, long j, int i) {
        this.f28886a = i;
        this.f28887b = str;
        this.f28888c = str2;
        this.f28890e = obj2;
        this.f28889d = j;
        this.f28891f = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f28886a) {
            case 0:
                String str = this.f28888c;
                zzjp zzjpVar = (zzjp) this.f28891f;
                String str2 = this.f28887b;
                if (str2 == null) {
                    zzjpVar.f14280a.zzaj(str, null);
                    return;
                } else {
                    zzjpVar.f14280a.zzaj(str, new zzmh((String) this.f28890e, str2, this.f28889d));
                    return;
                }
            default:
                Object obj = this.f28890e;
                ((zzlw) this.f28891f).m3572h(this.f28889d, obj, this.f28887b, this.f28888c);
                return;
        }
    }
}
