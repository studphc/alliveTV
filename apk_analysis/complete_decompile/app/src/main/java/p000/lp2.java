package p000;

import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.util.Random;
import sun.misc.Unsafe;

/* loaded from: classes.dex */
public abstract class lp2 extends Number {

    /* renamed from: d */
    public static final ThreadLocal f22625d = new ThreadLocal();

    /* renamed from: e */
    public static final Random f22626e = new Random();

    /* renamed from: f */
    public static final int f22627f = Runtime.getRuntime().availableProcessors();

    /* renamed from: g */
    public static final Unsafe f22628g;

    /* renamed from: h */
    public static final long f22629h;

    /* renamed from: i */
    public static final long f22630i;

    /* renamed from: a */
    public volatile transient jp2[] f22631a;

    /* renamed from: b */
    public volatile transient long f22632b;

    /* renamed from: c */
    public volatile transient int f22633c;

    static {
        try {
            Unsafe m5971g = m5971g();
            f22628g = m5971g;
            f22629h = m5971g.objectFieldOffset(lp2.class.getDeclaredField("b"));
            f22630i = m5971g.objectFieldOffset(lp2.class.getDeclaredField("c"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    /* renamed from: g */
    public static Unsafe m5971g() {
        try {
            try {
                return Unsafe.getUnsafe();
            } catch (PrivilegedActionException e) {
                throw new RuntimeException("Could not initialize intrinsics", e.getCause());
            }
        } catch (SecurityException unused) {
            return (Unsafe) AccessController.doPrivileged(new hp2());
        }
    }

    /* renamed from: e */
    public final boolean m5972e(long j, long j2) {
        return f22628g.compareAndSwapLong(this, f22629h, j, j2);
    }

    /* renamed from: f */
    public final boolean m5973f() {
        return f22628g.compareAndSwapInt(this, f22630i, 0, 1);
    }
}
