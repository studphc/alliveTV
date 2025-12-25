package p000;

import com.google.android.gms.internal.measurement.AbstractC0786f;
import com.google.android.gms.internal.measurement.C0782b;
import com.google.android.gms.internal.measurement.C0784d;
import com.google.android.gms.internal.measurement.C0785e;
import com.google.android.gms.internal.measurement.zzmd;
import com.google.android.gms.internal.measurement.zzmk;
import java.nio.charset.Charset;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class ud3 {

    /* renamed from: c */
    public static final ud3 f27230c = new ud3();

    /* renamed from: b */
    public final ConcurrentHashMap f27232b = new ConcurrentHashMap();

    /* renamed from: a */
    public final b01 f27231a = new b01(1);

    /* renamed from: a */
    public final xd3 m7701a(Class cls) {
        C0782b c0782b;
        Charset charset = zzmk.f13887a;
        if (cls != null) {
            ConcurrentHashMap concurrentHashMap = this.f27232b;
            xd3 xd3Var = (xd3) concurrentHashMap.get(cls);
            if (xd3Var == null) {
                b01 b01Var = this.f27231a;
                b01Var.getClass();
                C0782b c0782b2 = AbstractC0786f.f13768a;
                zzmd.class.isAssignableFrom(cls);
                wd3 mo101m = ((ai2) b01Var.f7833b).mo101m(cls);
                if ((mo101m.f28154d & 2) == 2) {
                    C0782b c0782b3 = AbstractC0786f.f13768a;
                    C0782b c0782b4 = zc3.f29312a;
                    xd3Var = new C0785e(c0782b3, mo101m.f28151a);
                } else {
                    int i = sd3.f26390a;
                    int i2 = kd3.f20831a;
                    C0782b c0782b5 = AbstractC0786f.f13768a;
                    if (mo101m.m8050b() - 1 != 1) {
                        c0782b = zc3.f29312a;
                    } else {
                        c0782b = null;
                    }
                    int i3 = pd3.f25127a;
                    xd3Var = C0784d.m3226u(mo101m, c0782b5, c0782b);
                }
                xd3 xd3Var2 = (xd3) concurrentHashMap.putIfAbsent(cls, xd3Var);
                if (xd3Var2 != null) {
                    return xd3Var2;
                }
            }
            return xd3Var;
        }
        throw new NullPointerException("messageType");
    }
}
