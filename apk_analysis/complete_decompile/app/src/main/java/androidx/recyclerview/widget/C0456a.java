package androidx.recyclerview.widget;

import androidx.core.util.Pools;
import java.util.ArrayList;
import p000.C1935w6;
import p000.b01;

/* renamed from: androidx.recyclerview.widget.a */
/* loaded from: classes.dex */
public final class C0456a {

    /* renamed from: d */
    public final C0503r0 f7316d;

    /* renamed from: a */
    public final Pools.SimplePool f7313a = new Pools.SimplePool(30);

    /* renamed from: b */
    public final ArrayList f7314b = new ArrayList();

    /* renamed from: c */
    public final ArrayList f7315c = new ArrayList();

    /* renamed from: f */
    public int f7318f = 0;

    /* renamed from: e */
    public final b01 f7317e = new b01(27, this);

    public C0456a(C0503r0 c0503r0) {
        this.f7316d = c0503r0;
    }

    /* renamed from: a */
    public final boolean m1808a(int i) {
        ArrayList arrayList = this.f7315c;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            C1935w6 c1935w6 = (C1935w6) arrayList.get(i2);
            int i3 = c1935w6.f28079a;
            if (i3 == 8) {
                if (m1813f(c1935w6.f28082d, i2 + 1) == i) {
                    return true;
                }
            } else if (i3 == 1) {
                int i4 = c1935w6.f28080b;
                int i5 = c1935w6.f28082d + i4;
                while (i4 < i5) {
                    if (m1813f(i4, i2 + 1) == i) {
                        return true;
                    }
                    i4++;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    /* renamed from: b */
    public final void m1809b() {
        ArrayList arrayList = this.f7315c;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            this.f7316d.m1879a((C1935w6) arrayList.get(i));
        }
        m1818k(arrayList);
        this.f7318f = 0;
    }

    /* renamed from: c */
    public final void m1810c() {
        m1809b();
        ArrayList arrayList = this.f7314b;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            C1935w6 c1935w6 = (C1935w6) arrayList.get(i);
            int i2 = c1935w6.f28079a;
            C0503r0 c0503r0 = this.f7316d;
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 4) {
                        if (i2 == 8) {
                            c0503r0.m1879a(c1935w6);
                            c0503r0.m1883e(c1935w6.f28080b, c1935w6.f28082d);
                        }
                    } else {
                        c0503r0.m1879a(c1935w6);
                        c0503r0.m1881c(c1935w6.f28080b, c1935w6.f28082d, c1935w6.f28081c);
                    }
                } else {
                    c0503r0.m1879a(c1935w6);
                    int i3 = c1935w6.f28080b;
                    int i4 = c1935w6.f28082d;
                    RecyclerView recyclerView = c0503r0.f7468a;
                    recyclerView.m1691M(i3, i4, true);
                    recyclerView.f7123l0 = true;
                    recyclerView.f7117i0.f7213d += i4;
                }
            } else {
                c0503r0.m1879a(c1935w6);
                c0503r0.m1882d(c1935w6.f28080b, c1935w6.f28082d);
            }
        }
        m1818k(arrayList);
        this.f7318f = 0;
    }

    /* renamed from: d */
    public final void m1811d(C1935w6 c1935w6) {
        int i;
        Pools.SimplePool simplePool;
        int i2 = c1935w6.f28079a;
        if (i2 != 1 && i2 != 8) {
            int m1819l = m1819l(c1935w6.f28080b, i2);
            int i3 = c1935w6.f28080b;
            int i4 = c1935w6.f28079a;
            if (i4 != 2) {
                if (i4 == 4) {
                    i = 1;
                } else {
                    throw new IllegalArgumentException("op should be remove or update." + c1935w6);
                }
            } else {
                i = 0;
            }
            int i5 = 1;
            int i6 = 1;
            while (true) {
                int i7 = c1935w6.f28082d;
                simplePool = this.f7313a;
                if (i5 >= i7) {
                    break;
                }
                int m1819l2 = m1819l((i * i5) + c1935w6.f28080b, c1935w6.f28079a);
                int i8 = c1935w6.f28079a;
                if (i8 == 2 ? m1819l2 == m1819l : !(i8 != 4 || m1819l2 != m1819l + 1)) {
                    i6++;
                } else {
                    C1935w6 m1815h = m1815h(i8, m1819l, i6, c1935w6.f28081c);
                    m1812e(m1815h, i3);
                    m1815h.f28081c = null;
                    simplePool.release(m1815h);
                    if (c1935w6.f28079a == 4) {
                        i3 += i6;
                    }
                    i6 = 1;
                    m1819l = m1819l2;
                }
                i5++;
            }
            Object obj = c1935w6.f28081c;
            c1935w6.f28081c = null;
            simplePool.release(c1935w6);
            if (i6 > 0) {
                C1935w6 m1815h2 = m1815h(c1935w6.f28079a, m1819l, i6, obj);
                m1812e(m1815h2, i3);
                m1815h2.f28081c = null;
                simplePool.release(m1815h2);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("should not dispatch add or move for pre layout");
    }

    /* renamed from: e */
    public final void m1812e(C1935w6 c1935w6, int i) {
        C0503r0 c0503r0 = this.f7316d;
        c0503r0.m1879a(c1935w6);
        int i2 = c1935w6.f28079a;
        if (i2 != 2) {
            if (i2 == 4) {
                c0503r0.m1881c(i, c1935w6.f28082d, c1935w6.f28081c);
                return;
            }
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
        int i3 = c1935w6.f28082d;
        RecyclerView recyclerView = c0503r0.f7468a;
        recyclerView.m1691M(i, i3, true);
        recyclerView.f7123l0 = true;
        recyclerView.f7117i0.f7213d += i3;
    }

    /* renamed from: f */
    public final int m1813f(int i, int i2) {
        ArrayList arrayList = this.f7315c;
        int size = arrayList.size();
        while (i2 < size) {
            C1935w6 c1935w6 = (C1935w6) arrayList.get(i2);
            int i3 = c1935w6.f28079a;
            if (i3 == 8) {
                int i4 = c1935w6.f28080b;
                if (i4 == i) {
                    i = c1935w6.f28082d;
                } else {
                    if (i4 < i) {
                        i--;
                    }
                    if (c1935w6.f28082d <= i) {
                        i++;
                    }
                }
            } else {
                int i5 = c1935w6.f28080b;
                if (i5 > i) {
                    continue;
                } else if (i3 == 2) {
                    int i6 = c1935w6.f28082d;
                    if (i < i5 + i6) {
                        return -1;
                    }
                    i -= i6;
                } else if (i3 == 1) {
                    i += c1935w6.f28082d;
                }
            }
            i2++;
        }
        return i;
    }

    /* renamed from: g */
    public final boolean m1814g() {
        if (this.f7314b.size() > 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Object, w6] */
    /* renamed from: h */
    public final C1935w6 m1815h(int i, int i2, int i3, Object obj) {
        C1935w6 c1935w6 = (C1935w6) this.f7313a.acquire();
        if (c1935w6 == null) {
            ?? obj2 = new Object();
            obj2.f28079a = i;
            obj2.f28080b = i2;
            obj2.f28082d = i3;
            obj2.f28081c = obj;
            return obj2;
        }
        c1935w6.f28079a = i;
        c1935w6.f28080b = i2;
        c1935w6.f28082d = i3;
        c1935w6.f28081c = obj;
        return c1935w6;
    }

    /* renamed from: i */
    public final void m1816i(C1935w6 c1935w6) {
        this.f7315c.add(c1935w6);
        int i = c1935w6.f28079a;
        C0503r0 c0503r0 = this.f7316d;
        if (i != 1) {
            if (i != 2) {
                if (i != 4) {
                    if (i == 8) {
                        c0503r0.m1883e(c1935w6.f28080b, c1935w6.f28082d);
                        return;
                    } else {
                        throw new IllegalArgumentException("Unknown update op type for " + c1935w6);
                    }
                }
                c0503r0.m1881c(c1935w6.f28080b, c1935w6.f28082d, c1935w6.f28081c);
                return;
            }
            int i2 = c1935w6.f28080b;
            int i3 = c1935w6.f28082d;
            RecyclerView recyclerView = c0503r0.f7468a;
            recyclerView.m1691M(i2, i3, false);
            recyclerView.f7123l0 = true;
            return;
        }
        c0503r0.m1882d(c1935w6.f28080b, c1935w6.f28082d);
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x00a1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0009 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0122 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0113 A[SYNTHETIC] */
    /* renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m1817j() {
        char c;
        int i;
        boolean z;
        char c2;
        C1935w6 m1815h;
        int i2;
        int i3;
        C1935w6 m1815h2;
        boolean z2;
        boolean z3;
        C1935w6 m1815h3;
        int i4;
        ArrayList arrayList = this.f7314b;
        b01 b01Var = this.f7317e;
        b01Var.getClass();
        while (true) {
            int size = arrayList.size() - 1;
            boolean z4 = false;
            while (true) {
                c = 65535;
                i = 8;
                if (size >= 0) {
                    if (((C1935w6) arrayList.get(size)).f28079a == 8) {
                        if (z4) {
                            break;
                        }
                    } else {
                        z4 = true;
                    }
                    size--;
                } else {
                    size = -1;
                    break;
                }
            }
            if (size == -1) {
                break;
            }
            int i5 = size + 1;
            C1935w6 c1935w6 = (C1935w6) arrayList.get(size);
            C1935w6 c1935w62 = (C1935w6) arrayList.get(i5);
            int i6 = c1935w62.f28079a;
            if (i6 != 1) {
                C0456a c0456a = (C0456a) b01Var.f7833b;
                if (i6 != 2) {
                    if (i6 == 4) {
                        int i7 = c1935w6.f28082d;
                        int i8 = c1935w62.f28080b;
                        if (i7 < i8) {
                            c1935w62.f28080b = i8 - 1;
                        } else {
                            int i9 = c1935w62.f28082d;
                            if (i7 < i8 + i9) {
                                c1935w62.f28082d = i9 - 1;
                                m1815h = c0456a.m1815h(4, c1935w6.f28080b, 1, c1935w62.f28081c);
                                i2 = c1935w6.f28080b;
                                i3 = c1935w62.f28080b;
                                if (i2 > i3) {
                                    c1935w62.f28080b = i3 + 1;
                                } else {
                                    int i10 = i3 + c1935w62.f28082d;
                                    if (i2 < i10) {
                                        int i11 = i10 - i2;
                                        m1815h2 = c0456a.m1815h(4, i2 + 1, i11, c1935w62.f28081c);
                                        c1935w62.f28082d -= i11;
                                        arrayList.set(i5, c1935w6);
                                        if (c1935w62.f28082d > 0) {
                                            arrayList.set(size, c1935w62);
                                        } else {
                                            arrayList.remove(size);
                                            c1935w62.f28081c = null;
                                            c0456a.f7313a.release(c1935w62);
                                        }
                                        if (m1815h != null) {
                                            arrayList.add(size, m1815h);
                                        }
                                        if (m1815h2 != null) {
                                            arrayList.add(size, m1815h2);
                                        }
                                    }
                                }
                                m1815h2 = null;
                                arrayList.set(i5, c1935w6);
                                if (c1935w62.f28082d > 0) {
                                }
                                if (m1815h != null) {
                                }
                                if (m1815h2 != null) {
                                }
                            }
                        }
                        m1815h = null;
                        i2 = c1935w6.f28080b;
                        i3 = c1935w62.f28080b;
                        if (i2 > i3) {
                        }
                        m1815h2 = null;
                        arrayList.set(i5, c1935w6);
                        if (c1935w62.f28082d > 0) {
                        }
                        if (m1815h != null) {
                        }
                        if (m1815h2 != null) {
                        }
                    }
                } else {
                    int i12 = c1935w6.f28080b;
                    int i13 = c1935w6.f28082d;
                    if (i12 < i13) {
                        if (c1935w62.f28080b == i12 && c1935w62.f28082d == i13 - i12) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        z2 = false;
                    } else if (c1935w62.f28080b == i13 + 1 && c1935w62.f28082d == i12 - i13) {
                        z3 = true;
                        z2 = true;
                    } else {
                        z2 = true;
                        z3 = false;
                    }
                    int i14 = c1935w62.f28080b;
                    if (i13 < i14) {
                        c1935w62.f28080b = i14 - 1;
                    } else {
                        int i15 = c1935w62.f28082d;
                        if (i13 < i14 + i15) {
                            c1935w62.f28082d = i15 - 1;
                            c1935w6.f28079a = 2;
                            c1935w6.f28082d = 1;
                            if (c1935w62.f28082d == 0) {
                                arrayList.remove(i5);
                                c1935w62.f28081c = null;
                                c0456a.f7313a.release(c1935w62);
                            }
                        }
                    }
                    int i16 = c1935w6.f28080b;
                    int i17 = c1935w62.f28080b;
                    if (i16 <= i17) {
                        c1935w62.f28080b = i17 + 1;
                    } else {
                        int i18 = i17 + c1935w62.f28082d;
                        if (i16 < i18) {
                            m1815h3 = c0456a.m1815h(2, i16 + 1, i18 - i16, null);
                            c1935w62.f28082d = c1935w6.f28080b - c1935w62.f28080b;
                            if (!z3) {
                                arrayList.set(size, c1935w62);
                                arrayList.remove(i5);
                                c1935w6.f28081c = null;
                                c0456a.f7313a.release(c1935w6);
                            } else {
                                if (z2) {
                                    if (m1815h3 != null) {
                                        int i19 = c1935w6.f28080b;
                                        if (i19 > m1815h3.f28080b) {
                                            c1935w6.f28080b = i19 - m1815h3.f28082d;
                                        }
                                        int i20 = c1935w6.f28082d;
                                        if (i20 > m1815h3.f28080b) {
                                            c1935w6.f28082d = i20 - m1815h3.f28082d;
                                        }
                                    }
                                    int i21 = c1935w6.f28080b;
                                    if (i21 > c1935w62.f28080b) {
                                        c1935w6.f28080b = i21 - c1935w62.f28082d;
                                    }
                                    int i22 = c1935w6.f28082d;
                                    if (i22 > c1935w62.f28080b) {
                                        c1935w6.f28082d = i22 - c1935w62.f28082d;
                                    }
                                } else {
                                    if (m1815h3 != null) {
                                        int i23 = c1935w6.f28080b;
                                        if (i23 >= m1815h3.f28080b) {
                                            c1935w6.f28080b = i23 - m1815h3.f28082d;
                                        }
                                        int i24 = c1935w6.f28082d;
                                        if (i24 >= m1815h3.f28080b) {
                                            c1935w6.f28082d = i24 - m1815h3.f28082d;
                                        }
                                    }
                                    int i25 = c1935w6.f28080b;
                                    if (i25 >= c1935w62.f28080b) {
                                        c1935w6.f28080b = i25 - c1935w62.f28082d;
                                    }
                                    int i26 = c1935w6.f28082d;
                                    if (i26 >= c1935w62.f28080b) {
                                        c1935w6.f28082d = i26 - c1935w62.f28082d;
                                    }
                                }
                                arrayList.set(size, c1935w62);
                                if (c1935w6.f28080b != c1935w6.f28082d) {
                                    arrayList.set(i5, c1935w6);
                                } else {
                                    arrayList.remove(i5);
                                }
                                if (m1815h3 != null) {
                                    arrayList.add(size, m1815h3);
                                }
                            }
                        }
                    }
                    m1815h3 = null;
                    if (!z3) {
                    }
                }
            } else {
                int i27 = c1935w6.f28082d;
                int i28 = c1935w62.f28080b;
                if (i27 < i28) {
                    i4 = -1;
                } else {
                    i4 = 0;
                }
                int i29 = c1935w6.f28080b;
                if (i29 < i28) {
                    i4++;
                }
                if (i28 <= i29) {
                    c1935w6.f28080b = i29 + c1935w62.f28082d;
                }
                int i30 = c1935w62.f28080b;
                if (i30 <= i27) {
                    c1935w6.f28082d = i27 + c1935w62.f28082d;
                }
                c1935w62.f28080b = i30 + i4;
                arrayList.set(size, c1935w62);
                arrayList.set(i5, c1935w6);
            }
        }
        int size2 = arrayList.size();
        int i31 = 0;
        while (i31 < size2) {
            C1935w6 c1935w63 = (C1935w6) arrayList.get(i31);
            int i32 = c1935w63.f28079a;
            if (i32 != 1) {
                Pools.SimplePool simplePool = this.f7313a;
                C0503r0 c0503r0 = this.f7316d;
                if (i32 != 2) {
                    if (i32 != 4) {
                        if (i32 == i) {
                            m1816i(c1935w63);
                        }
                    } else {
                        int i33 = c1935w63.f28080b;
                        int i34 = c1935w63.f28082d + i33;
                        char c3 = c;
                        int i35 = i33;
                        int i36 = 0;
                        while (i33 < i34) {
                            if (c0503r0.m1880b(i33) == null && !m1808a(i33)) {
                                if (c3 == 1) {
                                    m1816i(m1815h(4, i35, i36, c1935w63.f28081c));
                                    i35 = i33;
                                    i36 = 0;
                                }
                                c3 = 0;
                            } else {
                                if (c3 == 0) {
                                    m1811d(m1815h(4, i35, i36, c1935w63.f28081c));
                                    i35 = i33;
                                    i36 = 0;
                                }
                                c3 = 1;
                            }
                            i36++;
                            i33++;
                        }
                        if (i36 != c1935w63.f28082d) {
                            Object obj = c1935w63.f28081c;
                            c1935w63.f28081c = null;
                            simplePool.release(c1935w63);
                            c1935w63 = m1815h(4, i35, i36, obj);
                        }
                        if (c3 == 0) {
                            m1811d(c1935w63);
                        } else {
                            m1816i(c1935w63);
                        }
                    }
                } else {
                    int i37 = c1935w63.f28080b;
                    int i38 = c1935w63.f28082d + i37;
                    int i39 = i37;
                    int i40 = 0;
                    char c4 = 65535;
                    while (i39 < i38) {
                        if (c0503r0.m1880b(i39) == null && !m1808a(i39)) {
                            if (c4 == 1) {
                                m1816i(m1815h(2, i37, i40, null));
                                z = true;
                            } else {
                                z = false;
                            }
                            c2 = 0;
                        } else {
                            if (c4 == 0) {
                                m1811d(m1815h(2, i37, i40, null));
                                z = true;
                            } else {
                                z = false;
                            }
                            c2 = 1;
                        }
                        if (z) {
                            i39 -= i40;
                            i38 -= i40;
                            i40 = 1;
                        } else {
                            i40++;
                        }
                        i39++;
                        c4 = c2;
                    }
                    if (i40 != c1935w63.f28082d) {
                        c1935w63.f28081c = null;
                        simplePool.release(c1935w63);
                        c1935w63 = m1815h(2, i37, i40, null);
                    }
                    if (c4 == 0) {
                        m1811d(c1935w63);
                    } else {
                        m1816i(c1935w63);
                    }
                }
            } else {
                m1816i(c1935w63);
            }
            i31++;
            c = 65535;
            i = 8;
        }
        arrayList.clear();
    }

    /* renamed from: k */
    public final void m1818k(ArrayList arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            C1935w6 c1935w6 = (C1935w6) arrayList.get(i);
            c1935w6.f28081c = null;
            this.f7313a.release(c1935w6);
        }
        arrayList.clear();
    }

    /* renamed from: l */
    public final int m1819l(int i, int i2) {
        int i3;
        int i4;
        ArrayList arrayList = this.f7315c;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            C1935w6 c1935w6 = (C1935w6) arrayList.get(size);
            int i5 = c1935w6.f28079a;
            if (i5 == 8) {
                int i6 = c1935w6.f28080b;
                int i7 = c1935w6.f28082d;
                if (i6 < i7) {
                    i4 = i6;
                    i3 = i7;
                } else {
                    i3 = i6;
                    i4 = i7;
                }
                if (i >= i4 && i <= i3) {
                    if (i4 == i6) {
                        if (i2 == 1) {
                            c1935w6.f28082d = i7 + 1;
                        } else if (i2 == 2) {
                            c1935w6.f28082d = i7 - 1;
                        }
                        i++;
                    } else {
                        if (i2 == 1) {
                            c1935w6.f28080b = i6 + 1;
                        } else if (i2 == 2) {
                            c1935w6.f28080b = i6 - 1;
                        }
                        i--;
                    }
                } else if (i < i6) {
                    if (i2 == 1) {
                        c1935w6.f28080b = i6 + 1;
                        c1935w6.f28082d = i7 + 1;
                    } else if (i2 == 2) {
                        c1935w6.f28080b = i6 - 1;
                        c1935w6.f28082d = i7 - 1;
                    }
                }
            } else {
                int i8 = c1935w6.f28080b;
                if (i8 <= i) {
                    if (i5 == 1) {
                        i -= c1935w6.f28082d;
                    } else if (i5 == 2) {
                        i += c1935w6.f28082d;
                    }
                } else if (i2 == 1) {
                    c1935w6.f28080b = i8 + 1;
                } else if (i2 == 2) {
                    c1935w6.f28080b = i8 - 1;
                }
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            C1935w6 c1935w62 = (C1935w6) arrayList.get(size2);
            int i9 = c1935w62.f28079a;
            Pools.SimplePool simplePool = this.f7313a;
            if (i9 == 8) {
                int i10 = c1935w62.f28082d;
                if (i10 == c1935w62.f28080b || i10 < 0) {
                    arrayList.remove(size2);
                    c1935w62.f28081c = null;
                    simplePool.release(c1935w62);
                }
            } else if (c1935w62.f28082d <= 0) {
                arrayList.remove(size2);
                c1935w62.f28081c = null;
                simplePool.release(c1935w62);
            }
        }
        return i;
    }
}
