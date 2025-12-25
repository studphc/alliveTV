package com.google.common.collect;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import java.util.Comparator;
import java.util.Objects;

/* renamed from: com.google.common.collect.o3 */
/* loaded from: classes.dex */
public final class C0915o3 {

    /* renamed from: a */
    public final Object f14917a;

    /* renamed from: b */
    public int f14918b;

    /* renamed from: c */
    public int f14919c;

    /* renamed from: d */
    public long f14920d;

    /* renamed from: e */
    public int f14921e;

    /* renamed from: f */
    public C0915o3 f14922f;

    /* renamed from: g */
    public C0915o3 f14923g;

    /* renamed from: h */
    public C0915o3 f14924h;

    /* renamed from: i */
    public C0915o3 f14925i;

    public C0915o3(int i, Object obj) {
        Preconditions.checkArgument(i > 0);
        this.f14917a = obj;
        this.f14918b = i;
        this.f14920d = i;
        this.f14919c = 1;
        this.f14921e = 1;
        this.f14922f = null;
        this.f14923g = null;
    }

    /* renamed from: a */
    public final C0915o3 m4139a(Comparator comparator, Object obj, int i, int[] iArr) {
        int compare = comparator.compare(obj, this.f14917a);
        boolean z = true;
        if (compare < 0) {
            C0915o3 c0915o3 = this.f14922f;
            if (c0915o3 == null) {
                iArr[0] = 0;
                m4140b(i, obj);
                return this;
            }
            int i2 = c0915o3.f14921e;
            C0915o3 m4139a = c0915o3.m4139a(comparator, obj, i, iArr);
            this.f14922f = m4139a;
            if (iArr[0] == 0) {
                this.f14919c++;
            }
            this.f14920d += i;
            if (m4139a.f14921e == i2) {
                return this;
            }
            return m4146h();
        }
        if (compare > 0) {
            C0915o3 c0915o32 = this.f14923g;
            if (c0915o32 == null) {
                iArr[0] = 0;
                m4141c(i, obj);
                return this;
            }
            int i3 = c0915o32.f14921e;
            C0915o3 m4139a2 = c0915o32.m4139a(comparator, obj, i, iArr);
            this.f14923g = m4139a2;
            if (iArr[0] == 0) {
                this.f14919c++;
            }
            this.f14920d += i;
            if (m4139a2.f14921e == i3) {
                return this;
            }
            return m4146h();
        }
        int i4 = this.f14918b;
        iArr[0] = i4;
        long j = i;
        if (i4 + j > 2147483647L) {
            z = false;
        }
        Preconditions.checkArgument(z);
        this.f14918b += i;
        this.f14920d += j;
        return this;
    }

    /* renamed from: b */
    public final void m4140b(int i, Object obj) {
        this.f14922f = new C0915o3(i, obj);
        C0915o3 c0915o3 = this.f14924h;
        Objects.requireNonNull(c0915o3);
        C0915o3 c0915o32 = this.f14922f;
        int i2 = TreeMultiset.f14753h;
        c0915o3.f14925i = c0915o32;
        c0915o32.f14924h = c0915o3;
        c0915o32.f14925i = this;
        this.f14924h = c0915o32;
        this.f14921e = Math.max(2, this.f14921e);
        this.f14919c++;
        this.f14920d += i;
    }

    /* renamed from: c */
    public final void m4141c(int i, Object obj) {
        C0915o3 c0915o3 = new C0915o3(i, obj);
        this.f14923g = c0915o3;
        C0915o3 c0915o32 = this.f14925i;
        Objects.requireNonNull(c0915o32);
        int i2 = TreeMultiset.f14753h;
        this.f14925i = c0915o3;
        c0915o3.f14924h = this;
        c0915o3.f14925i = c0915o32;
        c0915o32.f14924h = c0915o3;
        this.f14921e = Math.max(2, this.f14921e);
        this.f14919c++;
        this.f14920d += i;
    }

    /* renamed from: d */
    public final C0915o3 m4142d(Comparator comparator, Object obj) {
        int compare = comparator.compare(obj, this.f14917a);
        if (compare < 0) {
            C0915o3 c0915o3 = this.f14922f;
            if (c0915o3 == null) {
                return this;
            }
            return (C0915o3) MoreObjects.firstNonNull(c0915o3.m4142d(comparator, obj), this);
        }
        if (compare == 0) {
            return this;
        }
        C0915o3 c0915o32 = this.f14923g;
        if (c0915o32 == null) {
            return null;
        }
        return c0915o32.m4142d(comparator, obj);
    }

    /* renamed from: e */
    public final int m4143e(Comparator comparator, Object obj) {
        int compare = comparator.compare(obj, this.f14917a);
        if (compare < 0) {
            C0915o3 c0915o3 = this.f14922f;
            if (c0915o3 == null) {
                return 0;
            }
            return c0915o3.m4143e(comparator, obj);
        }
        if (compare > 0) {
            C0915o3 c0915o32 = this.f14923g;
            if (c0915o32 == null) {
                return 0;
            }
            return c0915o32.m4143e(comparator, obj);
        }
        return this.f14918b;
    }

    /* renamed from: f */
    public final C0915o3 m4144f() {
        int i = this.f14918b;
        this.f14918b = 0;
        C0915o3 c0915o3 = this.f14924h;
        Objects.requireNonNull(c0915o3);
        C0915o3 c0915o32 = this.f14925i;
        Objects.requireNonNull(c0915o32);
        int i2 = TreeMultiset.f14753h;
        c0915o3.f14925i = c0915o32;
        c0915o32.f14924h = c0915o3;
        C0915o3 c0915o33 = this.f14922f;
        if (c0915o33 == null) {
            return this.f14923g;
        }
        C0915o3 c0915o34 = this.f14923g;
        if (c0915o34 == null) {
            return c0915o33;
        }
        if (c0915o33.f14921e >= c0915o34.f14921e) {
            C0915o3 c0915o35 = this.f14924h;
            Objects.requireNonNull(c0915o35);
            c0915o35.f14922f = this.f14922f.m4150l(c0915o35);
            c0915o35.f14923g = this.f14923g;
            c0915o35.f14919c = this.f14919c - 1;
            c0915o35.f14920d = this.f14920d - i;
            return c0915o35.m4146h();
        }
        C0915o3 c0915o36 = this.f14925i;
        Objects.requireNonNull(c0915o36);
        c0915o36.f14923g = this.f14923g.m4151m(c0915o36);
        c0915o36.f14922f = this.f14922f;
        c0915o36.f14919c = this.f14919c - 1;
        c0915o36.f14920d = this.f14920d - i;
        return c0915o36.m4146h();
    }

    /* renamed from: g */
    public final C0915o3 m4145g(Comparator comparator, Object obj) {
        int compare = comparator.compare(obj, this.f14917a);
        if (compare > 0) {
            C0915o3 c0915o3 = this.f14923g;
            if (c0915o3 == null) {
                return this;
            }
            return (C0915o3) MoreObjects.firstNonNull(c0915o3.m4145g(comparator, obj), this);
        }
        if (compare == 0) {
            return this;
        }
        C0915o3 c0915o32 = this.f14922f;
        if (c0915o32 == null) {
            return null;
        }
        return c0915o32.m4145g(comparator, obj);
    }

    /* renamed from: h */
    public final C0915o3 m4146h() {
        int i;
        int i2;
        int i3;
        int i4;
        C0915o3 c0915o3 = this.f14922f;
        int i5 = 0;
        if (c0915o3 == null) {
            i = 0;
        } else {
            i = c0915o3.f14921e;
        }
        C0915o3 c0915o32 = this.f14923g;
        if (c0915o32 == null) {
            i2 = 0;
        } else {
            i2 = c0915o32.f14921e;
        }
        int i6 = i - i2;
        if (i6 != -2) {
            if (i6 != 2) {
                m4148j();
                return this;
            }
            Objects.requireNonNull(c0915o3);
            C0915o3 c0915o33 = this.f14922f;
            C0915o3 c0915o34 = c0915o33.f14922f;
            if (c0915o34 == null) {
                i4 = 0;
            } else {
                i4 = c0915o34.f14921e;
            }
            C0915o3 c0915o35 = c0915o33.f14923g;
            if (c0915o35 != null) {
                i5 = c0915o35.f14921e;
            }
            if (i4 - i5 < 0) {
                this.f14922f = c0915o33.m4152n();
            }
            return m4153o();
        }
        Objects.requireNonNull(c0915o32);
        C0915o3 c0915o36 = this.f14923g;
        C0915o3 c0915o37 = c0915o36.f14922f;
        if (c0915o37 == null) {
            i3 = 0;
        } else {
            i3 = c0915o37.f14921e;
        }
        C0915o3 c0915o38 = c0915o36.f14923g;
        if (c0915o38 != null) {
            i5 = c0915o38.f14921e;
        }
        if (i3 - i5 > 0) {
            this.f14923g = c0915o36.m4153o();
        }
        return m4152n();
    }

    /* renamed from: i */
    public final void m4147i() {
        int i;
        long j;
        C0915o3 c0915o3 = this.f14922f;
        int i2 = TreeMultiset.f14753h;
        int i3 = 0;
        if (c0915o3 == null) {
            i = 0;
        } else {
            i = c0915o3.f14919c;
        }
        int i4 = i + 1;
        C0915o3 c0915o32 = this.f14923g;
        if (c0915o32 != null) {
            i3 = c0915o32.f14919c;
        }
        this.f14919c = i3 + i4;
        long j2 = this.f14918b;
        long j3 = 0;
        if (c0915o3 == null) {
            j = 0;
        } else {
            j = c0915o3.f14920d;
        }
        long j4 = j + j2;
        if (c0915o32 != null) {
            j3 = c0915o32.f14920d;
        }
        this.f14920d = j3 + j4;
        m4148j();
    }

    /* renamed from: j */
    public final void m4148j() {
        int i;
        C0915o3 c0915o3 = this.f14922f;
        int i2 = 0;
        if (c0915o3 == null) {
            i = 0;
        } else {
            i = c0915o3.f14921e;
        }
        C0915o3 c0915o32 = this.f14923g;
        if (c0915o32 != null) {
            i2 = c0915o32.f14921e;
        }
        this.f14921e = Math.max(i, i2) + 1;
    }

    /* renamed from: k */
    public final C0915o3 m4149k(Comparator comparator, Object obj, int i, int[] iArr) {
        int compare = comparator.compare(obj, this.f14917a);
        if (compare < 0) {
            C0915o3 c0915o3 = this.f14922f;
            if (c0915o3 == null) {
                iArr[0] = 0;
                return this;
            }
            this.f14922f = c0915o3.m4149k(comparator, obj, i, iArr);
            int i2 = iArr[0];
            if (i2 > 0) {
                if (i >= i2) {
                    this.f14919c--;
                    this.f14920d -= i2;
                } else {
                    this.f14920d -= i;
                }
            }
            if (i2 == 0) {
                return this;
            }
            return m4146h();
        }
        if (compare > 0) {
            C0915o3 c0915o32 = this.f14923g;
            if (c0915o32 == null) {
                iArr[0] = 0;
                return this;
            }
            this.f14923g = c0915o32.m4149k(comparator, obj, i, iArr);
            int i3 = iArr[0];
            if (i3 > 0) {
                if (i >= i3) {
                    this.f14919c--;
                    this.f14920d -= i3;
                } else {
                    this.f14920d -= i;
                }
            }
            return m4146h();
        }
        int i4 = this.f14918b;
        iArr[0] = i4;
        if (i >= i4) {
            return m4144f();
        }
        this.f14918b = i4 - i;
        this.f14920d -= i;
        return this;
    }

    /* renamed from: l */
    public final C0915o3 m4150l(C0915o3 c0915o3) {
        C0915o3 c0915o32 = this.f14923g;
        if (c0915o32 == null) {
            return this.f14922f;
        }
        this.f14923g = c0915o32.m4150l(c0915o3);
        this.f14919c--;
        this.f14920d -= c0915o3.f14918b;
        return m4146h();
    }

    /* renamed from: m */
    public final C0915o3 m4151m(C0915o3 c0915o3) {
        C0915o3 c0915o32 = this.f14922f;
        if (c0915o32 == null) {
            return this.f14923g;
        }
        this.f14922f = c0915o32.m4151m(c0915o3);
        this.f14919c--;
        this.f14920d -= c0915o3.f14918b;
        return m4146h();
    }

    /* renamed from: n */
    public final C0915o3 m4152n() {
        boolean z;
        if (this.f14923g != null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        C0915o3 c0915o3 = this.f14923g;
        this.f14923g = c0915o3.f14922f;
        c0915o3.f14922f = this;
        c0915o3.f14920d = this.f14920d;
        c0915o3.f14919c = this.f14919c;
        m4147i();
        c0915o3.m4148j();
        return c0915o3;
    }

    /* renamed from: o */
    public final C0915o3 m4153o() {
        boolean z;
        if (this.f14922f != null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        C0915o3 c0915o3 = this.f14922f;
        this.f14922f = c0915o3.f14923g;
        c0915o3.f14923g = this;
        c0915o3.f14920d = this.f14920d;
        c0915o3.f14919c = this.f14919c;
        m4147i();
        c0915o3.m4148j();
        return c0915o3;
    }

    /* renamed from: p */
    public final C0915o3 m4154p(Comparator comparator, Object obj, int i, int i2, int[] iArr) {
        int compare = comparator.compare(obj, this.f14917a);
        if (compare < 0) {
            C0915o3 c0915o3 = this.f14922f;
            if (c0915o3 == null) {
                iArr[0] = 0;
                if (i == 0 && i2 > 0) {
                    m4140b(i2, obj);
                }
                return this;
            }
            this.f14922f = c0915o3.m4154p(comparator, obj, i, i2, iArr);
            int i3 = iArr[0];
            if (i3 == i) {
                if (i2 == 0 && i3 != 0) {
                    this.f14919c--;
                } else if (i2 > 0 && i3 == 0) {
                    this.f14919c++;
                }
                this.f14920d += i2 - i3;
            }
            return m4146h();
        }
        if (compare > 0) {
            C0915o3 c0915o32 = this.f14923g;
            if (c0915o32 == null) {
                iArr[0] = 0;
                if (i == 0 && i2 > 0) {
                    m4141c(i2, obj);
                }
                return this;
            }
            this.f14923g = c0915o32.m4154p(comparator, obj, i, i2, iArr);
            int i4 = iArr[0];
            if (i4 == i) {
                if (i2 == 0 && i4 != 0) {
                    this.f14919c--;
                } else if (i2 > 0 && i4 == 0) {
                    this.f14919c++;
                }
                this.f14920d += i2 - i4;
            }
            return m4146h();
        }
        int i5 = this.f14918b;
        iArr[0] = i5;
        if (i == i5) {
            if (i2 == 0) {
                return m4144f();
            }
            this.f14920d += i2 - i5;
            this.f14918b = i2;
        }
        return this;
    }

    /* renamed from: q */
    public final C0915o3 m4155q(Comparator comparator, Object obj, int i, int[] iArr) {
        int compare = comparator.compare(obj, this.f14917a);
        if (compare < 0) {
            C0915o3 c0915o3 = this.f14922f;
            if (c0915o3 == null) {
                iArr[0] = 0;
                if (i > 0) {
                    m4140b(i, obj);
                }
                return this;
            }
            this.f14922f = c0915o3.m4155q(comparator, obj, i, iArr);
            if (i == 0 && iArr[0] != 0) {
                this.f14919c--;
            } else if (i > 0 && iArr[0] == 0) {
                this.f14919c++;
            }
            this.f14920d += i - iArr[0];
            return m4146h();
        }
        if (compare > 0) {
            C0915o3 c0915o32 = this.f14923g;
            if (c0915o32 == null) {
                iArr[0] = 0;
                if (i > 0) {
                    m4141c(i, obj);
                }
                return this;
            }
            this.f14923g = c0915o32.m4155q(comparator, obj, i, iArr);
            if (i == 0 && iArr[0] != 0) {
                this.f14919c--;
            } else if (i > 0 && iArr[0] == 0) {
                this.f14919c++;
            }
            this.f14920d += i - iArr[0];
            return m4146h();
        }
        iArr[0] = this.f14918b;
        if (i == 0) {
            return m4144f();
        }
        this.f14920d += i - r3;
        this.f14918b = i;
        return this;
    }

    public final String toString() {
        return Multisets.immutableEntry(this.f14917a, this.f14918b).toString();
    }

    public C0915o3() {
        this.f14917a = null;
        this.f14918b = 1;
    }
}
