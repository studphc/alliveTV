package p000;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class me0 {

    /* renamed from: a */
    public long f22907a;

    /* renamed from: b */
    public long f22908b;

    /* renamed from: c */
    public long f22909c;

    /* renamed from: d */
    public long f22910d;

    /* renamed from: e */
    public long f22911e;

    /* renamed from: f */
    public long f22912f;

    /* renamed from: g */
    public final boolean[] f22913g = new boolean[15];

    /* renamed from: h */
    public int f22914h;

    /* renamed from: a */
    public final boolean m6142a() {
        if (this.f22910d > 15 && this.f22914h == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public final void m6143b(long j) {
        long j2 = this.f22910d;
        if (j2 == 0) {
            this.f22907a = j;
        } else if (j2 == 1) {
            long j3 = j - this.f22907a;
            this.f22908b = j3;
            this.f22912f = j3;
            this.f22911e = 1L;
        } else {
            long j4 = j - this.f22909c;
            int i = (int) (j2 % 15);
            long abs = Math.abs(j4 - this.f22908b);
            boolean[] zArr = this.f22913g;
            if (abs <= 1000000) {
                this.f22911e++;
                this.f22912f += j4;
                if (zArr[i]) {
                    zArr[i] = false;
                    this.f22914h--;
                }
            } else if (!zArr[i]) {
                zArr[i] = true;
                this.f22914h++;
            }
        }
        this.f22910d++;
        this.f22909c = j;
    }

    /* renamed from: c */
    public final void m6144c() {
        this.f22910d = 0L;
        this.f22911e = 0L;
        this.f22912f = 0L;
        this.f22914h = 0;
        Arrays.fill(this.f22913g, false);
    }
}
