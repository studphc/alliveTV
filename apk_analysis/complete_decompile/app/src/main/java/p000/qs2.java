package p000;

/* loaded from: classes2.dex */
public final class qs2 implements Comparable {

    /* renamed from: a */
    public final long f25736a;

    /* renamed from: b */
    public final Runnable f25737b;

    /* renamed from: c */
    public final ps2 f25738c;

    /* renamed from: d */
    public final long f25739d;

    public qs2(ps2 ps2Var, long j, Runnable runnable, long j2) {
        this.f25736a = j;
        this.f25737b = runnable;
        this.f25738c = ps2Var;
        this.f25739d = j2;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        qs2 qs2Var = (qs2) obj;
        long j = qs2Var.f25736a;
        long j2 = this.f25736a;
        if (j2 == j) {
            return Long.compare(this.f25739d, qs2Var.f25739d);
        }
        return Long.compare(j2, j);
    }

    public final String toString() {
        return String.format("TimedRunnable(time = %d, run = %s)", Long.valueOf(this.f25736a), this.f25737b.toString());
    }
}
