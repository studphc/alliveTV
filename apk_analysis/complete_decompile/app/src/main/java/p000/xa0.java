package p000;

/* loaded from: classes.dex */
public final class xa0 {

    /* renamed from: a */
    public final long f28485a;

    /* renamed from: b */
    public final long f28486b;

    public xa0(double d) {
        this((long) (d * 10000.0d), 10000L);
    }

    public final String toString() {
        return this.f28485a + "/" + this.f28486b;
    }

    public xa0(long j, long j2) {
        if (j2 == 0) {
            this.f28485a = 0L;
            this.f28486b = 1L;
        } else {
            this.f28485a = j;
            this.f28486b = j2;
        }
    }
}
