package p000;

import sun.misc.Unsafe;

/* loaded from: classes.dex */
public final class jp2 {

    /* renamed from: b */
    public static final Unsafe f20580b;

    /* renamed from: c */
    public static final long f20581c;

    /* renamed from: a */
    public volatile long f20582a;

    static {
        Unsafe m5971g;
        try {
            m5971g = lp2.m5971g();
            f20580b = m5971g;
            f20581c = m5971g.objectFieldOffset(jp2.class.getDeclaredField("a"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    public jp2(long j) {
        this.f20582a = j;
    }

    /* renamed from: a */
    public final boolean m5449a(long j, long j2) {
        return f20580b.compareAndSwapLong(this, f20581c, j, j2);
    }
}
