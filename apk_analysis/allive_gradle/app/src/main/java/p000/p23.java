package p000;

/* loaded from: classes.dex */
public final class p23 {

    /* renamed from: a */
    public int f25015a;

    /* renamed from: b */
    public int f25016b;

    /* renamed from: c */
    public int f25017c;

    /* renamed from: d */
    public int f25018d;

    /* renamed from: e */
    public int f25019e;

    /* renamed from: a */
    public final boolean m6799a() {
        int i;
        int i2;
        int i3;
        int i4 = this.f25015a;
        int i5 = 2;
        if ((i4 & 7) != 0) {
            int i6 = this.f25018d;
            int i7 = this.f25016b;
            if (i6 > i7) {
                i3 = 1;
            } else if (i6 == i7) {
                i3 = 2;
            } else {
                i3 = 4;
            }
            if ((i3 & i4) == 0) {
                return false;
            }
        }
        if ((i4 & 112) != 0) {
            int i8 = this.f25018d;
            int i9 = this.f25017c;
            if (i8 > i9) {
                i2 = 1;
            } else if (i8 == i9) {
                i2 = 2;
            } else {
                i2 = 4;
            }
            if (((i2 << 4) & i4) == 0) {
                return false;
            }
        }
        if ((i4 & 1792) != 0) {
            int i10 = this.f25019e;
            int i11 = this.f25016b;
            if (i10 > i11) {
                i = 1;
            } else if (i10 == i11) {
                i = 2;
            } else {
                i = 4;
            }
            if (((i << 8) & i4) == 0) {
                return false;
            }
        }
        if ((i4 & 28672) != 0) {
            int i12 = this.f25019e;
            int i13 = this.f25017c;
            if (i12 > i13) {
                i5 = 1;
            } else if (i12 != i13) {
                i5 = 4;
            }
            if ((i4 & (i5 << 12)) == 0) {
                return false;
            }
        }
        return true;
    }
}
