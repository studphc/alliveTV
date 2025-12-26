package p000;

import androidx.collection.CircularIntArray;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class rj2 extends ux0 {

    /* renamed from: j */
    public final tx0 f25996j = new tx0(0);

    public rj2() {
        m7787n(1);
    }

    @Override // p000.ux0
    /* renamed from: b */
    public final boolean mo7272b(int i, boolean z) {
        int i2;
        int i3;
        if (this.f27513b.m7948c() == 0) {
            return false;
        }
        if (!z && m7783c(i)) {
            return false;
        }
        int i4 = this.f27518g;
        if (i4 >= 0) {
            i2 = i4 + 1;
        } else {
            int i5 = this.f27520i;
            if (i5 != -1) {
                i2 = Math.min(i5, this.f27513b.m7948c() - 1);
            } else {
                i2 = 0;
            }
        }
        boolean z2 = false;
        while (i2 < this.f27513b.m7948c()) {
            vx0 vx0Var = this.f27513b;
            Object[] objArr = this.f27512a;
            int m7947b = vx0Var.m7947b(i2, true, objArr, false);
            if (this.f27517f >= 0 && this.f27518g >= 0) {
                if (this.f27514c) {
                    int i6 = i2 - 1;
                    i3 = (this.f27513b.m7949d(i6) - this.f27513b.m7950e(i6)) - this.f27515d;
                } else {
                    int i7 = i2 - 1;
                    i3 = this.f27515d + this.f27513b.m7950e(i7) + this.f27513b.m7949d(i7);
                }
                this.f27518g = i2;
            } else {
                if (this.f27514c) {
                    i3 = Integer.MAX_VALUE;
                } else {
                    i3 = Integer.MIN_VALUE;
                }
                this.f27517f = i2;
                this.f27518g = i2;
            }
            this.f27513b.m7946a(objArr[0], i2, m7947b, 0, i3);
            if (z || m7783c(i)) {
                return true;
            }
            i2++;
            z2 = true;
        }
        return z2;
    }

    @Override // p000.ux0
    /* renamed from: e */
    public final void mo7273e(int i, int i2, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int m7279o;
        int i3;
        int i4;
        if (!this.f27514c ? i2 < 0 : i2 > 0) {
            if (this.f27517f == 0) {
                return;
            }
            m7279o = m7279o();
            int m7949d = this.f27513b.m7949d(this.f27517f);
            if (this.f27514c) {
                i3 = this.f27515d;
            } else {
                i3 = -this.f27515d;
            }
            i4 = m7949d + i3;
        } else {
            if (this.f27518g == this.f27513b.m7948c() - 1) {
                return;
            }
            int i5 = this.f27518g;
            if (i5 >= 0) {
                m7279o = i5 + 1;
            } else {
                int i6 = this.f27520i;
                if (i6 != -1) {
                    m7279o = Math.min(i6, this.f27513b.m7948c() - 1);
                } else {
                    m7279o = 0;
                }
            }
            int m7950e = this.f27513b.m7950e(this.f27518g) + this.f27515d;
            int m7949d2 = this.f27513b.m7949d(this.f27518g);
            if (this.f27514c) {
                m7950e = -m7950e;
            }
            i4 = m7950e + m7949d2;
        }
        layoutPrefetchRegistry.addPosition(m7279o, Math.abs(i4 - i));
    }

    @Override // p000.ux0
    /* renamed from: f */
    public final int mo7274f(int i, boolean z, int[] iArr) {
        if (iArr != null) {
            iArr[0] = 0;
            iArr[1] = i;
        }
        if (this.f27514c) {
            return this.f27513b.m7949d(i);
        }
        return this.f27513b.m7950e(i) + this.f27513b.m7949d(i);
    }

    @Override // p000.ux0
    /* renamed from: h */
    public final int mo7275h(int i, boolean z, int[] iArr) {
        if (iArr != null) {
            iArr[0] = 0;
            iArr[1] = i;
        }
        if (this.f27514c) {
            return this.f27513b.m7949d(i) - this.f27513b.m7950e(i);
        }
        return this.f27513b.m7949d(i);
    }

    @Override // p000.ux0
    /* renamed from: j */
    public final CircularIntArray[] mo7276j(int i, int i2) {
        this.f27519h[0].clear();
        this.f27519h[0].addLast(i);
        this.f27519h[0].addLast(i2);
        return this.f27519h;
    }

    @Override // p000.ux0
    /* renamed from: k */
    public final tx0 mo7277k(int i) {
        return this.f25996j;
    }

    @Override // p000.ux0
    /* renamed from: m */
    public final boolean mo7278m(int i, boolean z) {
        int i2;
        if (this.f27513b.m7948c() == 0) {
            return false;
        }
        if (!z && m7784d(i)) {
            return false;
        }
        int i3 = this.f27513b.f27986a.f5719x;
        boolean z2 = false;
        for (int m7279o = m7279o(); m7279o >= i3; m7279o--) {
            vx0 vx0Var = this.f27513b;
            Object[] objArr = this.f27512a;
            int m7947b = vx0Var.m7947b(m7279o, false, objArr, false);
            if (this.f27517f >= 0 && this.f27518g >= 0) {
                if (this.f27514c) {
                    i2 = this.f27513b.m7949d(m7279o + 1) + this.f27515d + m7947b;
                } else {
                    i2 = (this.f27513b.m7949d(m7279o + 1) - this.f27515d) - m7947b;
                }
                this.f27517f = m7279o;
            } else {
                if (this.f27514c) {
                    i2 = Integer.MIN_VALUE;
                } else {
                    i2 = Integer.MAX_VALUE;
                }
                this.f27517f = m7279o;
                this.f27518g = m7279o;
            }
            this.f27513b.m7946a(objArr[0], m7279o, m7947b, 0, i2);
            z2 = true;
            if (z || m7784d(i)) {
                break;
            }
        }
        return z2;
    }

    /* renamed from: o */
    public final int m7279o() {
        int i = this.f27517f;
        if (i >= 0) {
            return i - 1;
        }
        int i2 = this.f27520i;
        if (i2 != -1) {
            return Math.min(i2, this.f27513b.m7948c() - 1);
        }
        return this.f27513b.m7948c() - 1;
    }
}
