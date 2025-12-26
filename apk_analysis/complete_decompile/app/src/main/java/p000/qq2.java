package p000;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class qq2 implements Supplier, Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final Supplier f25729a;

    /* renamed from: b */
    public final long f25730b;

    /* renamed from: c */
    public volatile transient Object f25731c;

    /* renamed from: d */
    public volatile transient long f25732d;

    public qq2(Supplier supplier, long j, TimeUnit timeUnit) {
        boolean z;
        this.f25729a = (Supplier) Preconditions.checkNotNull(supplier);
        this.f25730b = timeUnit.toNanos(j);
        if (j > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "duration (%s %s) must be > 0", j, timeUnit);
    }

    @Override // com.google.common.base.Supplier
    public final Object get() {
        long j = this.f25732d;
        dx0 dx0Var = t42.f26692a;
        long nanoTime = System.nanoTime();
        if (j == 0 || nanoTime - j >= 0) {
            synchronized (this) {
                try {
                    if (j == this.f25732d) {
                        Object obj = this.f25729a.get();
                        this.f25731c = obj;
                        long j2 = nanoTime + this.f25730b;
                        if (j2 == 0) {
                            j2 = 1;
                        }
                        this.f25732d = j2;
                        return obj;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.f25731c;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f25729a);
        StringBuilder sb = new StringBuilder(valueOf.length() + 62);
        sb.append("Suppliers.memoizeWithExpiration(");
        sb.append(valueOf);
        sb.append(", ");
        return ye0.m8297q(sb, this.f25730b, ", NANOS)");
    }
}
