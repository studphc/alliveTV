package p000;

import sun.misc.Unsafe;

/* loaded from: classes2.dex */
public final class ip2 {

    /* renamed from: b */
    public static final Unsafe f20184b;

    /* renamed from: c */
    public static final long f20185c;

    /* renamed from: a */
    public volatile long f20186a;

    static {
        Unsafe m5759g;
        try {
            m5759g = kp2.m5759g();
            f20184b = m5759g;
            f20185c = m5759g.objectFieldOffset(ip2.class.getDeclaredField("a"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    public ip2(long j) {
        this.f20186a = j;
    }

    /* renamed from: a */
    public final boolean m5336a(long j, long j2) {
        return f20184b.compareAndSwapLong(this, f20185c, j, j2);
    }
}
