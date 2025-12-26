package p000;

import sun.misc.Unsafe;

/* loaded from: classes.dex */
public final class ee3 extends ge3 {
    public ee3(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // p000.ge3
    /* renamed from: j */
    public final double mo4693j(Object obj, long j) {
        return Double.longBitsToDouble(((Unsafe) this.f17677a).getLong(obj, j));
    }

    @Override // p000.ge3
    /* renamed from: k */
    public final float mo4694k(Object obj, long j) {
        return Float.intBitsToFloat(((Unsafe) this.f17677a).getInt(obj, j));
    }

    @Override // p000.ge3
    /* renamed from: l */
    public final void mo4695l(Object obj, long j, boolean z) {
        if (ie3.f18392g) {
            ie3.m5213b(obj, j, z ? (byte) 1 : (byte) 0);
        } else {
            ie3.m5214c(obj, j, z ? (byte) 1 : (byte) 0);
        }
    }

    @Override // p000.ge3
    /* renamed from: m */
    public final void mo4696m(Object obj, long j, byte b) {
        if (ie3.f18392g) {
            ie3.m5213b(obj, j, b);
        } else {
            ie3.m5214c(obj, j, b);
        }
    }

    @Override // p000.ge3
    /* renamed from: n */
    public final void mo4697n(Object obj, long j, double d) {
        ((Unsafe) this.f17677a).putLong(obj, j, Double.doubleToLongBits(d));
    }

    @Override // p000.ge3
    /* renamed from: o */
    public final void mo4698o(Object obj, long j, float f) {
        ((Unsafe) this.f17677a).putInt(obj, j, Float.floatToIntBits(f));
    }

    @Override // p000.ge3
    /* renamed from: p */
    public final boolean mo4699p(Object obj, long j) {
        if (ie3.f18392g) {
            return ie3.m5228q(obj, j);
        }
        return ie3.m5229r(obj, j);
    }
}
