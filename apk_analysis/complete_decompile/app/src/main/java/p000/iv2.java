package p000;

/* loaded from: classes2.dex */
public final class iv2 implements Comparable {

    /* renamed from: a */
    public final Runnable f20280a;

    /* renamed from: b */
    public final long f20281b;

    /* renamed from: c */
    public final int f20282c;

    /* renamed from: d */
    public volatile boolean f20283d;

    public iv2(Runnable runnable, Long l, int i) {
        this.f20280a = runnable;
        this.f20281b = l.longValue();
        this.f20282c = i;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        iv2 iv2Var = (iv2) obj;
        int compare = Long.compare(this.f20281b, iv2Var.f20281b);
        if (compare == 0) {
            return Integer.compare(this.f20282c, iv2Var.f20282c);
        }
        return compare;
    }
}
