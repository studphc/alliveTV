package p000;

import com.google.common.util.concurrent.AbstractFuture;

/* renamed from: n0 */
/* loaded from: classes2.dex */
public final class C1568n0 extends yy2 {
    @Override // p000.yy2
    /* renamed from: H */
    public final void mo5804H(C1892v0 c1892v0, C1892v0 c1892v02) {
        c1892v0.f27561b = c1892v02;
    }

    @Override // p000.yy2
    /* renamed from: I */
    public final void mo5805I(C1892v0 c1892v0, Thread thread) {
        c1892v0.f27560a = thread;
    }

    @Override // p000.yy2
    /* renamed from: i */
    public final boolean mo5806i(AbstractFuture abstractFuture, C1374k0 c1374k0, C1374k0 c1374k02) {
        synchronized (abstractFuture) {
            try {
                if (abstractFuture.f15256b == c1374k0) {
                    abstractFuture.f15256b = c1374k02;
                    return true;
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // p000.yy2
    /* renamed from: j */
    public final boolean mo5807j(AbstractFuture abstractFuture, Object obj, Object obj2) {
        synchronized (abstractFuture) {
            try {
                if (abstractFuture.f15255a == obj) {
                    abstractFuture.f15255a = obj2;
                    return true;
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // p000.yy2
    /* renamed from: k */
    public final boolean mo5808k(AbstractFuture abstractFuture, C1892v0 c1892v0, C1892v0 c1892v02) {
        synchronized (abstractFuture) {
            try {
                if (abstractFuture.f15257c == c1892v0) {
                    abstractFuture.f15257c = c1892v02;
                    return true;
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // p000.yy2
    /* renamed from: o */
    public final C1374k0 mo5809o(AbstractFuture abstractFuture) {
        C1374k0 c1374k0;
        C1374k0 c1374k02 = C1374k0.f20701d;
        synchronized (abstractFuture) {
            c1374k0 = abstractFuture.f15256b;
            if (c1374k0 != c1374k02) {
                abstractFuture.f15256b = c1374k02;
            }
        }
        return c1374k0;
    }

    @Override // p000.yy2
    /* renamed from: p */
    public final C1892v0 mo5810p(AbstractFuture abstractFuture) {
        C1892v0 c1892v0;
        C1892v0 c1892v02 = C1892v0.f27559c;
        synchronized (abstractFuture) {
            c1892v0 = abstractFuture.f15257c;
            if (c1892v0 != c1892v02) {
                abstractFuture.f15257c = c1892v02;
            }
        }
        return c1892v0;
    }
}
