package p000;

/* loaded from: classes.dex */
public final class x72 {

    /* renamed from: a */
    public final int f28456a;

    /* renamed from: b */
    public final boolean f28457b;

    public x72(int i, boolean z) {
        this.f28456a = i;
        this.f28457b = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || x72.class != obj.getClass()) {
            return false;
        }
        x72 x72Var = (x72) obj;
        if (this.f28456a == x72Var.f28456a && this.f28457b == x72Var.f28457b) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (this.f28456a * 31) + (this.f28457b ? 1 : 0);
    }
}
