package p000;

import com.google.common.base.Throwables;
import com.google.common.util.concurrent.AbstractFuture;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import sun.misc.Unsafe;

/* renamed from: u0 */
/* loaded from: classes2.dex */
public final class C1855u0 extends yy2 {

    /* renamed from: p */
    public static final Unsafe f27048p;

    /* renamed from: q */
    public static final long f27049q;

    /* renamed from: r */
    public static final long f27050r;

    /* renamed from: s */
    public static final long f27051s;

    /* renamed from: t */
    public static final long f27052t;

    /* renamed from: u */
    public static final long f27053u;

    static {
        Unsafe unsafe;
        try {
            try {
                unsafe = Unsafe.getUnsafe();
            } catch (PrivilegedActionException e) {
                throw new RuntimeException("Could not initialize intrinsics", e.getCause());
            }
        } catch (SecurityException unused) {
            unsafe = (Unsafe) AccessController.doPrivileged(new C1818t0());
        }
        try {
            f27050r = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField("c"));
            f27049q = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField("b"));
            f27051s = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField("a"));
            f27052t = unsafe.objectFieldOffset(C1892v0.class.getDeclaredField("a"));
            f27053u = unsafe.objectFieldOffset(C1892v0.class.getDeclaredField("b"));
            f27048p = unsafe;
        } catch (Exception e2) {
            Throwables.throwIfUnchecked(e2);
            throw new RuntimeException(e2);
        }
    }

    @Override // p000.yy2
    /* renamed from: H */
    public final void mo5804H(C1892v0 c1892v0, C1892v0 c1892v02) {
        f27048p.putObject(c1892v0, f27053u, c1892v02);
    }

    @Override // p000.yy2
    /* renamed from: I */
    public final void mo5805I(C1892v0 c1892v0, Thread thread) {
        f27048p.putObject(c1892v0, f27052t, thread);
    }

    @Override // p000.yy2
    /* renamed from: i */
    public final boolean mo5806i(AbstractFuture abstractFuture, C1374k0 c1374k0, C1374k0 c1374k02) {
        return AbstractC1744r0.m7156a(f27048p, abstractFuture, f27049q, c1374k0, c1374k02);
    }

    @Override // p000.yy2
    /* renamed from: j */
    public final boolean mo5807j(AbstractFuture abstractFuture, Object obj, Object obj2) {
        return AbstractC1781s0.m7315a(f27048p, abstractFuture, f27051s, obj, obj2);
    }

    @Override // p000.yy2
    /* renamed from: k */
    public final boolean mo5808k(AbstractFuture abstractFuture, C1892v0 c1892v0, C1892v0 c1892v02) {
        return AbstractC1707q0.m6940a(f27048p, abstractFuture, f27050r, c1892v0, c1892v02);
    }

    @Override // p000.yy2
    /* renamed from: o */
    public final C1374k0 mo5809o(AbstractFuture abstractFuture) {
        C1374k0 c1374k0;
        C1374k0 c1374k02 = C1374k0.f20701d;
        do {
            c1374k0 = abstractFuture.f15256b;
            if (c1374k02 == c1374k0) {
                return c1374k0;
            }
        } while (!mo5806i(abstractFuture, c1374k0, c1374k02));
        return c1374k0;
    }

    @Override // p000.yy2
    /* renamed from: p */
    public final C1892v0 mo5810p(AbstractFuture abstractFuture) {
        C1892v0 c1892v0;
        C1892v0 c1892v02 = C1892v0.f27559c;
        do {
            c1892v0 = abstractFuture.f15257c;
            if (c1892v02 == c1892v0) {
                return c1892v0;
            }
        } while (!mo5808k(abstractFuture, c1892v0, c1892v02));
        return c1892v0;
    }
}
