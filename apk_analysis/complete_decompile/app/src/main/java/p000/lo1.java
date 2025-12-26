package p000;

import com.bumptech.glide.util.Util;
import java.util.Queue;

/* loaded from: classes.dex */
public final class lo1 {

    /* renamed from: d */
    public static final Queue f22596d = Util.createQueue(0);

    /* renamed from: a */
    public int f22597a;

    /* renamed from: b */
    public int f22598b;

    /* renamed from: c */
    public Object f22599c;

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static lo1 m5962a(int i, int i2, Object obj) {
        lo1 lo1Var;
        lo1 lo1Var2;
        Queue queue = f22596d;
        synchronized (queue) {
            lo1Var = (lo1) queue.poll();
            lo1Var2 = lo1Var;
        }
        if (lo1Var == null) {
            lo1Var2 = new Object();
        }
        lo1Var2.f22599c = obj;
        lo1Var2.f22598b = i;
        lo1Var2.f22597a = i2;
        return lo1Var2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof lo1)) {
            return false;
        }
        lo1 lo1Var = (lo1) obj;
        if (this.f22598b != lo1Var.f22598b || this.f22597a != lo1Var.f22597a || !this.f22599c.equals(lo1Var.f22599c)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.f22599c.hashCode() + (((this.f22597a * 31) + this.f22598b) * 31);
    }
}
