package p000;

import com.google.android.gms.internal.measurement.zzld;
import com.google.android.gms.internal.measurement.zzlk;
import com.google.android.gms.internal.measurement.zzmk;
import com.google.android.gms.internal.measurement.zzmt;
import com.google.android.gms.internal.measurement.zznh;
import java.nio.charset.Charset;
import java.util.List;

/* loaded from: classes.dex */
public final class wc3 implements le3 {

    /* renamed from: a */
    public final zzlk f28137a;

    public wc3(zzlk zzlkVar) {
        Charset charset = zzmk.f13887a;
        this.f28137a = zzlkVar;
        zzlkVar.f13879a = this;
    }

    /* renamed from: a */
    public final void m8028a(int i, int i2) {
        this.f28137a.zzs(i, (i2 >> 31) ^ (i2 + i2));
    }

    /* renamed from: b */
    public final void m8029b(int i, long j) {
        this.f28137a.zzu(i, (j >> 63) ^ (j + j));
    }

    /* renamed from: c */
    public final void m8030c(int i, List list) {
        boolean z = list instanceof zzmt;
        int i2 = 0;
        zzlk zzlkVar = this.f28137a;
        if (z) {
            zzmt zzmtVar = (zzmt) list;
            while (i2 < list.size()) {
                Object zzc = zzmtVar.zzc();
                if (zzc instanceof String) {
                    zzlkVar.zzp(i, (String) zzc);
                } else {
                    zzlkVar.zze(i, (zzld) zzc);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            zzlkVar.zzp(i, (String) list.get(i2));
            i2++;
        }
    }

    /* renamed from: d */
    public final void m8031d(int i, int i2) {
        this.f28137a.zzs(i, i2);
    }

    /* renamed from: e */
    public final void m8032e(int i, long j) {
        this.f28137a.zzu(i, j);
    }

    /* renamed from: f */
    public final void m8033f(int i, boolean z) {
        this.f28137a.zzd(i, z);
    }

    /* renamed from: g */
    public final void m8034g(int i, zzld zzldVar) {
        this.f28137a.zze(i, zzldVar);
    }

    /* renamed from: h */
    public final void m8035h(int i, List list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.f28137a.zze(i, (zzld) list.get(i2));
        }
    }

    /* renamed from: i */
    public final void m8036i(double d, int i) {
        this.f28137a.zzh(i, Double.doubleToRawLongBits(d));
    }

    /* renamed from: j */
    public final void m8037j(int i, int i2) {
        this.f28137a.zzj(i, i2);
    }

    /* renamed from: k */
    public final void m8038k(int i, int i2) {
        this.f28137a.zzf(i, i2);
    }

    /* renamed from: l */
    public final void m8039l(int i, long j) {
        this.f28137a.zzh(i, j);
    }

    /* renamed from: m */
    public final void m8040m(float f, int i) {
        this.f28137a.zzf(i, Float.floatToRawIntBits(f));
    }

    /* renamed from: n */
    public final void m8041n(int i, Object obj, xd3 xd3Var) {
        zzlk zzlkVar = this.f28137a;
        zzlkVar.zzr(i, 3);
        xd3Var.mo3235b((zznh) obj, zzlkVar.f13879a);
        zzlkVar.zzr(i, 4);
    }

    /* renamed from: o */
    public final void m8042o(int i, int i2) {
        this.f28137a.zzj(i, i2);
    }

    /* renamed from: p */
    public final void m8043p(int i, long j) {
        this.f28137a.zzu(i, j);
    }

    /* renamed from: q */
    public final void m8044q(int i, Object obj, xd3 xd3Var) {
        this.f28137a.mo3467a(i, (zznh) obj, xd3Var);
    }

    /* renamed from: r */
    public final void m8045r(int i, Object obj) {
        boolean z = obj instanceof zzld;
        zzlk zzlkVar = this.f28137a;
        if (z) {
            zzlkVar.zzo(i, (zzld) obj);
        } else {
            zzlkVar.zzn(i, (zznh) obj);
        }
    }

    /* renamed from: s */
    public final void m8046s(int i, int i2) {
        this.f28137a.zzf(i, i2);
    }

    /* renamed from: t */
    public final void m8047t(int i, long j) {
        this.f28137a.zzh(i, j);
    }
}
