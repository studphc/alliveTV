package p000;

import com.google.android.gms.internal.measurement.zznh;

/* loaded from: classes.dex */
public final class xc3 {

    /* renamed from: a */
    public final zznh f28511a;

    /* renamed from: b */
    public final int f28512b;

    public xc3(int i, zznh zznhVar) {
        this.f28511a = zznhVar;
        this.f28512b = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof xc3)) {
            return false;
        }
        xc3 xc3Var = (xc3) obj;
        if (this.f28511a != xc3Var.f28511a || this.f28512b != xc3Var.f28512b) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.f28511a) * 65535) + this.f28512b;
    }
}
