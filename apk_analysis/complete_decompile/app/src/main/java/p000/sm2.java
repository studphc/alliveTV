package p000;

import androidx.collection.CircularArray;
import androidx.collection.CircularIntArray;

/* loaded from: classes.dex */
public final class sm2 extends ux0 {

    /* renamed from: j */
    public CircularArray f26492j;

    /* renamed from: k */
    public int f26493k;

    /* renamed from: l */
    public Object f26494l;

    /* renamed from: m */
    public int f26495m;

    @Override // p000.ux0
    /* renamed from: b */
    public final boolean mo7272b(int i, boolean z) {
        Object[] objArr = this.f27512a;
        if (this.f27513b.m7948c() == 0) {
            return false;
        }
        if (!z && m7783c(i)) {
            return false;
        }
        try {
            if (m7383o(i, z)) {
                objArr[0] = null;
                this.f26494l = null;
                return true;
            }
            return m7385q(i, z);
        } finally {
            objArr[0] = null;
            this.f26494l = null;
        }
    }

    @Override // p000.ux0
    /* renamed from: f */
    public final int mo7274f(int i, boolean z, int[] iArr) {
        int i2;
        int m7949d = this.f27513b.m7949d(i);
        rm2 mo7277k = mo7277k(i);
        int i3 = mo7277k.f27011a;
        if (this.f27514c) {
            i2 = i3;
            int i4 = i2;
            int i5 = 1;
            int i6 = m7949d;
            for (int i7 = i + 1; i5 < this.f27516e && i7 <= this.f27518g; i7++) {
                rm2 mo7277k2 = mo7277k(i7);
                i6 += mo7277k2.f26030b;
                int i8 = mo7277k2.f27011a;
                if (i8 != i4) {
                    i5++;
                    if (!z ? i6 < m7949d : i6 > m7949d) {
                        m7949d = i6;
                        i = i7;
                        i2 = i8;
                        i4 = i2;
                    } else {
                        i4 = i8;
                    }
                }
            }
        } else {
            int i9 = 1;
            int i10 = i3;
            rm2 rm2Var = mo7277k;
            int i11 = m7949d;
            m7949d = this.f27513b.m7950e(i) + m7949d;
            i2 = i10;
            for (int i12 = i - 1; i9 < this.f27516e && i12 >= this.f27517f; i12--) {
                i11 -= rm2Var.f26030b;
                rm2Var = mo7277k(i12);
                int i13 = rm2Var.f27011a;
                if (i13 != i10) {
                    i9++;
                    int m7950e = this.f27513b.m7950e(i12) + i11;
                    if (!z ? m7950e < m7949d : m7950e > m7949d) {
                        m7949d = m7950e;
                        i = i12;
                        i2 = i13;
                        i10 = i2;
                    } else {
                        i10 = i13;
                    }
                }
            }
        }
        if (iArr != null) {
            iArr[0] = i2;
            iArr[1] = i;
        }
        return m7949d;
    }

    @Override // p000.ux0
    /* renamed from: h */
    public final int mo7275h(int i, boolean z, int[] iArr) {
        int i2;
        int m7949d = this.f27513b.m7949d(i);
        rm2 mo7277k = mo7277k(i);
        int i3 = mo7277k.f27011a;
        if (this.f27514c) {
            int i4 = 1;
            i2 = m7949d - this.f27513b.m7950e(i);
            int i5 = i3;
            for (int i6 = i - 1; i4 < this.f27516e && i6 >= this.f27517f; i6--) {
                m7949d -= mo7277k.f26030b;
                mo7277k = mo7277k(i6);
                int i7 = mo7277k.f27011a;
                if (i7 != i5) {
                    i4++;
                    int m7950e = m7949d - this.f27513b.m7950e(i6);
                    if (!z ? m7950e < i2 : m7950e > i2) {
                        i2 = m7950e;
                        i = i6;
                        i3 = i7;
                        i5 = i3;
                    } else {
                        i5 = i7;
                    }
                }
            }
        } else {
            int i8 = i3;
            int i9 = i8;
            int i10 = 1;
            int i11 = m7949d;
            for (int i12 = i + 1; i10 < this.f27516e && i12 <= this.f27518g; i12++) {
                rm2 mo7277k2 = mo7277k(i12);
                i11 += mo7277k2.f26030b;
                int i13 = mo7277k2.f27011a;
                if (i13 != i9) {
                    i10++;
                    if (!z ? i11 < m7949d : i11 > m7949d) {
                        m7949d = i11;
                        i = i12;
                        i8 = i13;
                        i9 = i8;
                    } else {
                        i9 = i13;
                    }
                }
            }
            i2 = m7949d;
            i3 = i8;
        }
        if (iArr != null) {
            iArr[0] = i3;
            iArr[1] = i;
        }
        return i2;
    }

    @Override // p000.ux0
    /* renamed from: j */
    public final CircularIntArray[] mo7276j(int i, int i2) {
        for (int i3 = 0; i3 < this.f27516e; i3++) {
            this.f27519h[i3].clear();
        }
        if (i >= 0) {
            while (i <= i2) {
                CircularIntArray circularIntArray = this.f27519h[mo7277k(i).f27011a];
                if (circularIntArray.size() > 0 && circularIntArray.getLast() == i - 1) {
                    circularIntArray.popLast();
                    circularIntArray.addLast(i);
                } else {
                    circularIntArray.addLast(i);
                    circularIntArray.addLast(i);
                }
                i++;
            }
        }
        return this.f27519h;
    }

    @Override // p000.ux0
    /* renamed from: l */
    public final void mo7382l(int i) {
        super.mo7382l(i);
        int m7387s = (m7387s() - i) + 1;
        CircularArray circularArray = this.f26492j;
        circularArray.removeFromEnd(m7387s);
        if (circularArray.size() == 0) {
            this.f26493k = -1;
        }
    }

    @Override // p000.ux0
    /* renamed from: m */
    public final boolean mo7278m(int i, boolean z) {
        Object[] objArr = this.f27512a;
        if (this.f27513b.m7948c() == 0) {
            return false;
        }
        if (!z && m7784d(i)) {
            return false;
        }
        try {
            if (m7391w(i, z)) {
                objArr[0] = null;
                this.f26494l = null;
                return true;
            }
            return m7393y(i, z);
        } finally {
            objArr[0] = null;
            this.f26494l = null;
        }
    }

    /* renamed from: o */
    public final boolean m7383o(int i, boolean z) {
        int i2;
        int i3;
        int i4;
        CircularArray circularArray = this.f26492j;
        if (circularArray.size() == 0) {
            return false;
        }
        int m7948c = this.f27513b.m7948c();
        int i5 = this.f27518g;
        if (i5 >= 0) {
            i2 = i5 + 1;
            i3 = this.f27513b.m7949d(i5);
        } else {
            int i6 = this.f27520i;
            if (i6 != -1) {
                i2 = i6;
            } else {
                i2 = 0;
            }
            if (i2 <= m7387s() + 1 && i2 >= this.f26493k) {
                if (i2 > m7387s()) {
                    return false;
                }
                i3 = Integer.MAX_VALUE;
            } else {
                circularArray.clear();
                return false;
            }
        }
        int m7387s = m7387s();
        int i7 = i2;
        while (i7 < m7948c && i7 <= m7387s) {
            rm2 mo7277k = mo7277k(i7);
            if (i3 != Integer.MAX_VALUE) {
                i3 += mo7277k.f26030b;
            }
            int i8 = mo7277k.f27011a;
            vx0 vx0Var = this.f27513b;
            Object[] objArr = this.f27512a;
            int m7947b = vx0Var.m7947b(i7, true, objArr, false);
            if (m7947b != mo7277k.f26031c) {
                mo7277k.f26031c = m7947b;
                circularArray.removeFromEnd(m7387s - i7);
                i4 = i7;
            } else {
                i4 = m7387s;
            }
            this.f27518g = i7;
            if (this.f27517f < 0) {
                this.f27517f = i7;
            }
            this.f27513b.m7946a(objArr[0], i7, m7947b, i8, i3);
            if (!z && m7783c(i)) {
                return true;
            }
            if (i3 == Integer.MAX_VALUE) {
                i3 = this.f27513b.m7949d(i7);
            }
            if (i8 == this.f27516e - 1 && z) {
                return true;
            }
            i7++;
            m7387s = i4;
        }
        return false;
    }

    /* renamed from: p */
    public final int m7384p(int i, int i2, int i3) {
        int m7949d;
        int i4 = this.f27518g;
        if (i4 >= 0 && (i4 != m7387s() || this.f27518g != i - 1)) {
            throw new IllegalStateException();
        }
        int i5 = this.f27518g;
        CircularArray circularArray = this.f26492j;
        if (i5 < 0) {
            if (circularArray.size() > 0 && i == m7387s() + 1) {
                int m7387s = m7387s();
                while (true) {
                    if (m7387s >= this.f26493k) {
                        if (mo7277k(m7387s).f27011a == i2) {
                            break;
                        }
                        m7387s--;
                    } else {
                        m7387s = m7387s();
                        break;
                    }
                }
                if (this.f27514c) {
                    m7949d = (-mo7277k(m7387s).f26031c) - this.f27515d;
                } else {
                    m7949d = mo7277k(m7387s).f26031c + this.f27515d;
                }
                for (int i6 = m7387s + 1; i6 <= m7387s(); i6++) {
                    m7949d -= mo7277k(i6).f26030b;
                }
            } else {
                m7949d = 0;
            }
        } else {
            m7949d = i3 - this.f27513b.m7949d(i5);
        }
        rm2 rm2Var = new rm2(i2, m7949d);
        circularArray.addLast(rm2Var);
        Object obj = this.f26494l;
        if (obj != null) {
            rm2Var.f26031c = this.f26495m;
            this.f26494l = null;
        } else {
            vx0 vx0Var = this.f27513b;
            Object[] objArr = this.f27512a;
            rm2Var.f26031c = vx0Var.m7947b(i, true, objArr, false);
            obj = objArr[0];
        }
        Object obj2 = obj;
        if (circularArray.size() == 1) {
            this.f27518g = i;
            this.f27517f = i;
            this.f26493k = i;
        } else {
            int i7 = this.f27518g;
            if (i7 < 0) {
                this.f27518g = i;
                this.f27517f = i;
            } else {
                this.f27518g = i7 + 1;
            }
        }
        this.f27513b.m7946a(obj2, i, rm2Var.f26031c, i2, i3);
        return rm2Var.f26031c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x014e, code lost:
    
        return r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0136, code lost:
    
        return true;
     */
    /* renamed from: q */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean m7385q(int i, boolean z) {
        int i2;
        int i3;
        int i4;
        boolean z2;
        int i5;
        int m7389u;
        int i6;
        int i7;
        int m7389u2;
        int i8;
        int m7785g;
        int mo7274f;
        int m7785g2;
        int m7948c = this.f27513b.m7948c();
        int i9 = this.f27518g;
        if (i9 >= 0) {
            if (i9 < m7387s()) {
                return false;
            }
            int i10 = this.f27518g;
            i2 = i10 + 1;
            i4 = mo7277k(i10).f27011a;
            int m7386r = m7386r(true);
            if (m7386r < 0) {
                i5 = Integer.MIN_VALUE;
                for (int i11 = 0; i11 < this.f27516e; i11++) {
                    if (this.f27514c) {
                        i5 = m7390v(i11);
                    } else {
                        i5 = m7389u(i11);
                    }
                    if (i5 != Integer.MIN_VALUE) {
                        break;
                    }
                }
            } else {
                if (this.f27514c) {
                    mo7274f = mo7275h(m7386r, false, null);
                } else {
                    mo7274f = mo7274f(m7386r, true, null);
                }
                i5 = mo7274f;
            }
            if (!this.f27514c ? m7389u(i4) >= i5 : m7390v(i4) <= i5) {
                i4++;
                if (i4 == this.f27516e) {
                    if (this.f27514c) {
                        m7785g2 = m7786i(false, null);
                    } else {
                        m7785g2 = m7785g(true, null);
                    }
                    i5 = m7785g2;
                    i4 = 0;
                }
            }
            z2 = true;
        } else {
            int i12 = this.f27520i;
            if (i12 != -1) {
                i2 = i12;
            } else {
                i2 = 0;
            }
            if (this.f26492j.size() > 0) {
                i3 = mo7277k(m7387s()).f27011a + 1;
            } else {
                i3 = i2;
            }
            i4 = i3 % this.f27516e;
            z2 = false;
            i5 = 0;
        }
        boolean z3 = false;
        loop1: while (true) {
            if (i4 < this.f27516e) {
                if (i2 == m7948c || (!z && m7783c(i))) {
                    break;
                }
                if (this.f27514c) {
                    m7389u = m7390v(i4);
                } else {
                    m7389u = m7389u(i4);
                }
                if (m7389u != Integer.MAX_VALUE && m7389u != Integer.MIN_VALUE) {
                    if (this.f27514c) {
                        i7 = this.f27515d;
                        i6 = -i7;
                        m7389u += i6;
                    } else {
                        i6 = this.f27515d;
                        m7389u += i6;
                    }
                } else if (i4 == 0) {
                    if (this.f27514c) {
                        m7389u = m7390v(this.f27516e - 1);
                    } else {
                        m7389u = m7389u(this.f27516e - 1);
                    }
                    if (m7389u != Integer.MAX_VALUE && m7389u != Integer.MIN_VALUE) {
                        if (this.f27514c) {
                            i7 = this.f27515d;
                            i6 = -i7;
                            m7389u += i6;
                        } else {
                            i6 = this.f27515d;
                            m7389u += i6;
                        }
                    }
                } else if (this.f27514c) {
                    m7389u = m7389u(i4 - 1);
                } else {
                    m7389u = m7390v(i4 - 1);
                }
                int i13 = i2 + 1;
                int m7384p = m7384p(i2, i4, m7389u);
                if (z2) {
                    while (true) {
                        if (this.f27514c) {
                            if (m7389u - m7384p <= i5) {
                                break;
                            }
                            if (i13 == m7948c || (!z && m7783c(i))) {
                                break loop1;
                            }
                            if (this.f27514c) {
                                i8 = (-m7384p) - this.f27515d;
                            } else {
                                i8 = m7384p + this.f27515d;
                            }
                            m7389u += i8;
                            int i14 = i13 + 1;
                            int m7384p2 = m7384p(i13, i4, m7389u);
                            i13 = i14;
                            m7384p = m7384p2;
                        } else {
                            if (m7389u + m7384p >= i5) {
                                break;
                            }
                            if (i13 == m7948c) {
                                break loop1;
                            }
                            break loop1;
                        }
                    }
                } else {
                    if (this.f27514c) {
                        m7389u2 = m7390v(i4);
                    } else {
                        m7389u2 = m7389u(i4);
                    }
                    z2 = true;
                    i5 = m7389u2;
                }
                i2 = i13;
                i4++;
                z3 = true;
            } else {
                if (z) {
                    return z3;
                }
                if (this.f27514c) {
                    m7785g = m7786i(false, null);
                } else {
                    m7785g = m7785g(true, null);
                }
                i5 = m7785g;
                i4 = 0;
            }
        }
    }

    /* renamed from: r */
    public final int m7386r(boolean z) {
        boolean z2 = false;
        if (z) {
            for (int i = this.f27518g; i >= this.f27517f; i--) {
                int i2 = mo7277k(i).f27011a;
                if (i2 == 0) {
                    z2 = true;
                } else if (z2 && i2 == this.f27516e - 1) {
                    return i;
                }
            }
            return -1;
        }
        for (int i3 = this.f27517f; i3 <= this.f27518g; i3++) {
            int i4 = mo7277k(i3).f27011a;
            if (i4 == this.f27516e - 1) {
                z2 = true;
            } else if (z2 && i4 == 0) {
                return i3;
            }
        }
        return -1;
    }

    /* renamed from: s */
    public final int m7387s() {
        return (this.f26492j.size() + this.f26493k) - 1;
    }

    @Override // p000.ux0
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public final rm2 mo7277k(int i) {
        int i2 = i - this.f26493k;
        if (i2 >= 0) {
            CircularArray circularArray = this.f26492j;
            if (i2 < circularArray.size()) {
                return (rm2) circularArray.get(i2);
            }
            return null;
        }
        return null;
    }

    /* renamed from: u */
    public final int m7389u(int i) {
        int i2;
        rm2 mo7277k;
        int i3 = this.f27517f;
        if (i3 < 0) {
            return Integer.MIN_VALUE;
        }
        if (this.f27514c) {
            int m7949d = this.f27513b.m7949d(i3);
            if (mo7277k(this.f27517f).f27011a == i) {
                return m7949d;
            }
            int i4 = this.f27517f;
            do {
                i4++;
                if (i4 <= m7387s()) {
                    mo7277k = mo7277k(i4);
                    m7949d += mo7277k.f26030b;
                }
            } while (mo7277k.f27011a != i);
            return m7949d;
        }
        int m7949d2 = this.f27513b.m7949d(this.f27518g);
        rm2 mo7277k2 = mo7277k(this.f27518g);
        if (mo7277k2.f27011a == i) {
            i2 = mo7277k2.f26031c;
        } else {
            int i5 = this.f27518g;
            do {
                i5--;
                if (i5 >= this.f26493k) {
                    m7949d2 -= mo7277k2.f26030b;
                    mo7277k2 = mo7277k(i5);
                }
            } while (mo7277k2.f27011a != i);
            i2 = mo7277k2.f26031c;
        }
        return m7949d2 + i2;
        return Integer.MIN_VALUE;
    }

    /* renamed from: v */
    public final int m7390v(int i) {
        rm2 mo7277k;
        int i2;
        int i3 = this.f27517f;
        if (i3 < 0) {
            return Integer.MAX_VALUE;
        }
        if (this.f27514c) {
            int m7949d = this.f27513b.m7949d(this.f27518g);
            rm2 mo7277k2 = mo7277k(this.f27518g);
            if (mo7277k2.f27011a == i) {
                i2 = mo7277k2.f26031c;
            } else {
                int i4 = this.f27518g;
                do {
                    i4--;
                    if (i4 >= this.f26493k) {
                        m7949d -= mo7277k2.f26030b;
                        mo7277k2 = mo7277k(i4);
                    }
                } while (mo7277k2.f27011a != i);
                i2 = mo7277k2.f26031c;
            }
            return m7949d - i2;
        }
        int m7949d2 = this.f27513b.m7949d(i3);
        if (mo7277k(this.f27517f).f27011a == i) {
            return m7949d2;
        }
        int i5 = this.f27517f;
        do {
            i5++;
            if (i5 <= m7387s()) {
                mo7277k = mo7277k(i5);
                m7949d2 += mo7277k.f26030b;
            }
        } while (mo7277k.f27011a != i);
        return m7949d2;
        return Integer.MAX_VALUE;
    }

    /* renamed from: w */
    public final boolean m7391w(int i, boolean z) {
        int i2;
        int i3;
        int i4;
        CircularArray circularArray = this.f26492j;
        if (circularArray.size() == 0) {
            return false;
        }
        int i5 = this.f27517f;
        if (i5 >= 0) {
            i3 = this.f27513b.m7949d(i5);
            i4 = mo7277k(this.f27517f).f26030b;
            i2 = this.f27517f - 1;
        } else {
            int i6 = this.f27520i;
            if (i6 != -1) {
                i2 = i6;
            } else {
                i2 = 0;
            }
            if (i2 <= m7387s()) {
                int i7 = this.f26493k;
                if (i2 >= i7 - 1) {
                    if (i2 < i7) {
                        return false;
                    }
                    i3 = Integer.MAX_VALUE;
                    i4 = 0;
                }
            }
            circularArray.clear();
            return false;
        }
        int max = Math.max(this.f27513b.f27986a.f5719x, this.f26493k);
        while (i2 >= max) {
            rm2 mo7277k = mo7277k(i2);
            int i8 = mo7277k.f27011a;
            vx0 vx0Var = this.f27513b;
            Object[] objArr = this.f27512a;
            int m7947b = vx0Var.m7947b(i2, false, objArr, false);
            if (m7947b != mo7277k.f26031c) {
                circularArray.removeFromStart((i2 + 1) - this.f26493k);
                this.f26493k = this.f27517f;
                this.f26494l = objArr[0];
                this.f26495m = m7947b;
                return false;
            }
            this.f27517f = i2;
            if (this.f27518g < 0) {
                this.f27518g = i2;
            }
            this.f27513b.m7946a(objArr[0], i2, m7947b, i8, i3 - i4);
            if (!z && m7784d(i)) {
                return true;
            }
            i3 = this.f27513b.m7949d(i2);
            i4 = mo7277k.f26030b;
            if (i8 == 0 && z) {
                return true;
            }
            i2--;
        }
        return false;
    }

    /* renamed from: x */
    public final int m7392x(int i, int i2, int i3) {
        rm2 rm2Var;
        int i4;
        int i5 = this.f27517f;
        if (i5 >= 0 && (i5 != this.f26493k || i5 != i + 1)) {
            throw new IllegalStateException();
        }
        int i6 = this.f26493k;
        if (i6 >= 0) {
            rm2Var = mo7277k(i6);
        } else {
            rm2Var = null;
        }
        int m7949d = this.f27513b.m7949d(this.f26493k);
        rm2 rm2Var2 = new rm2(i2, 0);
        this.f26492j.addFirst(rm2Var2);
        Object obj = this.f26494l;
        if (obj != null) {
            rm2Var2.f26031c = this.f26495m;
            this.f26494l = null;
        } else {
            vx0 vx0Var = this.f27513b;
            Object[] objArr = this.f27512a;
            rm2Var2.f26031c = vx0Var.m7947b(i, false, objArr, false);
            obj = objArr[0];
        }
        Object obj2 = obj;
        this.f27517f = i;
        this.f26493k = i;
        if (this.f27518g < 0) {
            this.f27518g = i;
        }
        if (!this.f27514c) {
            i4 = i3 - rm2Var2.f26031c;
        } else {
            i4 = i3 + rm2Var2.f26031c;
        }
        int i7 = i4;
        if (rm2Var != null) {
            rm2Var.f26030b = m7949d - i7;
        }
        this.f27513b.m7946a(obj2, i, rm2Var2.f26031c, i2, i7);
        return rm2Var2.f26031c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0142, code lost:
    
        return r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x012a, code lost:
    
        return true;
     */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00fb A[LOOP:2: B:55:0x00fb->B:69:0x011f, LOOP_START, PHI: r5 r8 r9
      0x00fb: PHI (r5v12 int) = (r5v6 int), (r5v17 int) binds: [B:54:0x00f9, B:69:0x011f] A[DONT_GENERATE, DONT_INLINE]
      0x00fb: PHI (r8v19 int) = (r8v17 int), (r8v20 int) binds: [B:54:0x00f9, B:69:0x011f] A[DONT_GENERATE, DONT_INLINE]
      0x00fb: PHI (r9v8 int) = (r9v6 int), (r9v10 int) binds: [B:54:0x00f9, B:69:0x011f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x012d  */
    /* renamed from: y */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean m7393y(int i, boolean z) {
        int i2;
        int i3;
        int i4;
        boolean z2;
        int i5;
        int m7390v;
        int i6;
        int i7;
        int m7390v2;
        int i8;
        int m7786i;
        int mo7275h;
        int m7786i2;
        int i9 = this.f27517f;
        if (i9 >= 0) {
            if (i9 > this.f26493k) {
                return false;
            }
            i2 = i9 - 1;
            i4 = mo7277k(i9).f27011a;
            int m7386r = m7386r(false);
            if (m7386r < 0) {
                i4--;
                i5 = Integer.MAX_VALUE;
                for (int i10 = this.f27516e - 1; i10 >= 0; i10--) {
                    if (this.f27514c) {
                        i5 = m7389u(i10);
                    } else {
                        i5 = m7390v(i10);
                    }
                    if (i5 != Integer.MAX_VALUE) {
                        break;
                    }
                }
            } else {
                if (this.f27514c) {
                    mo7275h = mo7274f(m7386r, true, null);
                } else {
                    mo7275h = mo7275h(m7386r, false, null);
                }
                i5 = mo7275h;
            }
            if (!this.f27514c ? m7390v(i4) <= i5 : m7389u(i4) >= i5) {
                i4--;
                if (i4 < 0) {
                    i4 = this.f27516e - 1;
                    if (this.f27514c) {
                        m7786i2 = m7785g(true, null);
                    } else {
                        m7786i2 = m7786i(false, null);
                    }
                    i5 = m7786i2;
                }
            }
            z2 = true;
        } else {
            int i11 = this.f27520i;
            if (i11 != -1) {
                i2 = i11;
            } else {
                i2 = 0;
            }
            if (this.f26492j.size() > 0) {
                i3 = (mo7277k(this.f26493k).f27011a + this.f27516e) - 1;
            } else {
                i3 = i2;
            }
            i4 = i3 % this.f27516e;
            z2 = false;
            i5 = 0;
        }
        boolean z3 = false;
        loop1: while (true) {
            if (i4 >= 0) {
                if (i2 < 0 || (!z && m7784d(i))) {
                    break;
                }
                if (this.f27514c) {
                    m7390v = m7389u(i4);
                } else {
                    m7390v = m7390v(i4);
                }
                if (m7390v != Integer.MAX_VALUE && m7390v != Integer.MIN_VALUE) {
                    if (this.f27514c) {
                        i7 = this.f27515d;
                        m7390v += i7;
                        int i12 = i2 - 1;
                        int m7392x = m7392x(i2, i4, m7390v);
                        if (z2) {
                        }
                        i2 = i12;
                        i4--;
                        z3 = true;
                    } else {
                        i6 = this.f27515d;
                        i7 = -i6;
                        m7390v += i7;
                        int i122 = i2 - 1;
                        int m7392x2 = m7392x(i2, i4, m7390v);
                        if (z2) {
                        }
                        i2 = i122;
                        i4--;
                        z3 = true;
                    }
                } else {
                    if (i4 == this.f27516e - 1) {
                        if (this.f27514c) {
                            m7390v = m7389u(0);
                        } else {
                            m7390v = m7390v(0);
                        }
                        if (m7390v != Integer.MAX_VALUE && m7390v != Integer.MIN_VALUE) {
                            if (this.f27514c) {
                                i7 = this.f27515d;
                                m7390v += i7;
                            } else {
                                i6 = this.f27515d;
                                i7 = -i6;
                                m7390v += i7;
                            }
                        }
                    } else if (this.f27514c) {
                        m7390v = m7390v(i4 + 1);
                    } else {
                        m7390v = m7389u(i4 + 1);
                    }
                    int i1222 = i2 - 1;
                    int m7392x22 = m7392x(i2, i4, m7390v);
                    if (z2) {
                        while (true) {
                            if (this.f27514c) {
                                if (m7390v + m7392x22 >= i5) {
                                    break;
                                }
                                if (i1222 < 0 || (!z && m7784d(i))) {
                                    break loop1;
                                }
                                if (this.f27514c) {
                                    i8 = m7392x22 + this.f27515d;
                                } else {
                                    i8 = (-m7392x22) - this.f27515d;
                                }
                                m7390v += i8;
                                int i13 = i1222 - 1;
                                int m7392x3 = m7392x(i1222, i4, m7390v);
                                i1222 = i13;
                                m7392x22 = m7392x3;
                            } else {
                                if (m7390v - m7392x22 <= i5) {
                                    break;
                                }
                                if (i1222 < 0) {
                                    break loop1;
                                }
                                break loop1;
                            }
                        }
                    } else {
                        if (this.f27514c) {
                            m7390v2 = m7389u(i4);
                        } else {
                            m7390v2 = m7390v(i4);
                        }
                        z2 = true;
                        i5 = m7390v2;
                    }
                    i2 = i1222;
                    i4--;
                    z3 = true;
                }
            } else {
                if (z) {
                    return z3;
                }
                if (this.f27514c) {
                    m7786i = m7785g(true, null);
                } else {
                    m7786i = m7786i(false, null);
                }
                i5 = m7786i;
                i4 = this.f27516e - 1;
            }
        }
    }
}
