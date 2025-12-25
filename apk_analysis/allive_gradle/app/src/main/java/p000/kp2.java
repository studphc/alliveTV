package p000;

import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.util.Random;
import sun.misc.Unsafe;

/* loaded from: classes2.dex */
public abstract class kp2 extends Number {

    /* renamed from: d */
    public static final ThreadLocal f22140d = new ThreadLocal();

    /* renamed from: e */
    public static final Random f22141e = new Random();

    /* renamed from: f */
    public static final int f22142f = Runtime.getRuntime().availableProcessors();

    /* renamed from: g */
    public static final Unsafe f22143g;

    /* renamed from: h */
    public static final long f22144h;

    /* renamed from: i */
    public static final long f22145i;

    /* renamed from: a */
    public volatile transient ip2[] f22146a;

    /* renamed from: b */
    public volatile transient long f22147b;

    /* renamed from: c */
    public volatile transient int f22148c;

    static {
        try {
            Unsafe m5759g = m5759g();
            f22143g = m5759g;
            f22144h = m5759g.objectFieldOffset(kp2.class.getDeclaredField("b"));
            f22145i = m5759g.objectFieldOffset(kp2.class.getDeclaredField("c"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    /* renamed from: g */
    public static Unsafe m5759g() {
        try {
            try {
                return Unsafe.getUnsafe();
            } catch (PrivilegedActionException e) {
                throw new RuntimeException("Could not initialize intrinsics", e.getCause());
            }
        } catch (SecurityException unused) {
            return (Unsafe) AccessController.doPrivileged(new gp2());
        }
    }

    /* renamed from: e */
    public final boolean m5760e(long j, long j2) {
        return f22143g.compareAndSwapLong(this, f22144h, j, j2);
    }

    /* renamed from: f */
    public final boolean m5761f() {
        return f22143g.compareAndSwapInt(this, f22145i, 0, 1);
    }
}
