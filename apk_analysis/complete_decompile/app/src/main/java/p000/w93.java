package p000;

import android.os.Handler;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzcr;

/* loaded from: classes.dex */
public abstract class w93 {

    /* renamed from: d */
    public static volatile zzcr f28108d;

    /* renamed from: a */
    public final hc3 f28109a;

    /* renamed from: b */
    public final xy1 f28110b;

    /* renamed from: c */
    public volatile long f28111c;

    public w93(hc3 hc3Var) {
        Preconditions.checkNotNull(hc3Var);
        this.f28109a = hc3Var;
        this.f28110b = new xy1(22, this, hc3Var);
    }

    /* renamed from: a */
    public final void m8015a() {
        this.f28111c = 0L;
        m8017d().removeCallbacks(this.f28110b);
    }

    /* renamed from: b */
    public abstract void mo3493b();

    /* renamed from: c */
    public final void m8016c(long j) {
        m8015a();
        if (j >= 0) {
            hc3 hc3Var = this.f28109a;
            this.f28111c = hc3Var.zzaU().currentTimeMillis();
            if (!m8017d().postDelayed(this.f28110b, j)) {
                hc3Var.zzaW().zze().zzb("Failed to schedule delayed post. time", Long.valueOf(j));
            }
        }
    }

    /* renamed from: d */
    public final Handler m8017d() {
        zzcr zzcrVar;
        if (f28108d != null) {
            return f28108d;
        }
        synchronized (w93.class) {
            try {
                if (f28108d == null) {
                    f28108d = new zzcr(this.f28109a.zzaT().getMainLooper());
                }
                zzcrVar = f28108d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzcrVar;
    }
}
