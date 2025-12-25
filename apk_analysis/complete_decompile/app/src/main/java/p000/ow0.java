package p000;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.BoundType;
import java.io.Serializable;
import java.util.Comparator;

/* loaded from: classes.dex */
public final class ow0 implements Serializable {

    /* renamed from: a */
    public final Comparator f24929a;

    /* renamed from: b */
    public final boolean f24930b;

    /* renamed from: c */
    public final Object f24931c;

    /* renamed from: d */
    public final BoundType f24932d;

    /* renamed from: e */
    public final boolean f24933e;

    /* renamed from: f */
    public final Object f24934f;

    /* renamed from: g */
    public final BoundType f24935g;

    public ow0(Comparator comparator, boolean z, Object obj, BoundType boundType, boolean z2, Object obj2, BoundType boundType2) {
        boolean z3;
        this.f24929a = (Comparator) Preconditions.checkNotNull(comparator);
        this.f24930b = z;
        this.f24933e = z2;
        this.f24931c = obj;
        this.f24932d = (BoundType) Preconditions.checkNotNull(boundType);
        this.f24934f = obj2;
        this.f24935g = (BoundType) Preconditions.checkNotNull(boundType2);
        if (z) {
            comparator.compare(obj, obj);
        }
        if (z2) {
            comparator.compare(obj2, obj2);
        }
        if (z && z2) {
            int compare = comparator.compare(obj, obj2);
            if (compare <= 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "lowerEndpoint (%s) > upperEndpoint (%s)", obj, obj2);
            if (compare == 0) {
                BoundType boundType3 = BoundType.OPEN;
                Preconditions.checkArgument((boundType == boundType3 && boundType2 == boundType3) ? false : true);
            }
        }
    }

    /* renamed from: a */
    public final boolean m6732a(Object obj) {
        if (!m6735d(obj) && !m6734c(obj)) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public final ow0 m6733b(ow0 ow0Var) {
        boolean z;
        int compare;
        boolean z2;
        Object obj;
        int compare2;
        BoundType boundType;
        Object obj2;
        BoundType boundType2;
        int compare3;
        BoundType boundType3;
        Preconditions.checkNotNull(ow0Var);
        Comparator comparator = this.f24929a;
        Preconditions.checkArgument(comparator.equals(ow0Var.f24929a));
        boolean z3 = ow0Var.f24930b;
        BoundType boundType4 = ow0Var.f24932d;
        Object obj3 = ow0Var.f24931c;
        boolean z4 = this.f24930b;
        if (!z4) {
            z = z3;
        } else {
            Object obj4 = this.f24931c;
            if (z3 && ((compare = comparator.compare(obj4, obj3)) < 0 || (compare == 0 && boundType4 == BoundType.OPEN))) {
                z = z4;
            } else {
                boundType4 = this.f24932d;
                z = z4;
                obj3 = obj4;
            }
        }
        boolean z5 = ow0Var.f24933e;
        BoundType boundType5 = ow0Var.f24935g;
        Object obj5 = ow0Var.f24934f;
        boolean z6 = this.f24933e;
        if (!z6) {
            obj = obj5;
            z2 = z5;
        } else {
            Object obj6 = this.f24934f;
            if (z5 && ((compare2 = comparator.compare(obj6, obj5)) > 0 || (compare2 == 0 && boundType5 == BoundType.OPEN))) {
                obj = obj5;
                z2 = z6;
            } else {
                boundType5 = this.f24935g;
                z2 = z6;
                obj = obj6;
            }
        }
        if (z && z2 && ((compare3 = comparator.compare(obj3, obj)) > 0 || (compare3 == 0 && boundType4 == (boundType3 = BoundType.OPEN) && boundType5 == boundType3))) {
            boundType = BoundType.OPEN;
            boundType2 = BoundType.CLOSED;
            obj2 = obj;
        } else {
            boundType = boundType4;
            obj2 = obj3;
            boundType2 = boundType5;
        }
        return new ow0(this.f24929a, z, obj2, boundType, z2, obj, boundType2);
    }

    /* renamed from: c */
    public final boolean m6734c(Object obj) {
        boolean z;
        boolean z2;
        boolean z3 = false;
        if (!this.f24933e) {
            return false;
        }
        int compare = this.f24929a.compare(obj, this.f24934f);
        if (compare > 0) {
            z = true;
        } else {
            z = false;
        }
        if (compare == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.f24935g == BoundType.OPEN) {
            z3 = true;
        }
        return (z2 & z3) | z;
    }

    /* renamed from: d */
    public final boolean m6735d(Object obj) {
        boolean z;
        boolean z2;
        boolean z3 = false;
        if (!this.f24930b) {
            return false;
        }
        int compare = this.f24929a.compare(obj, this.f24931c);
        if (compare < 0) {
            z = true;
        } else {
            z = false;
        }
        if (compare == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.f24932d == BoundType.OPEN) {
            z3 = true;
        }
        return (z2 & z3) | z;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ow0)) {
            return false;
        }
        ow0 ow0Var = (ow0) obj;
        if (!this.f24929a.equals(ow0Var.f24929a) || this.f24930b != ow0Var.f24930b || this.f24933e != ow0Var.f24933e || !this.f24932d.equals(ow0Var.f24932d) || !this.f24935g.equals(ow0Var.f24935g) || !Objects.equal(this.f24931c, ow0Var.f24931c) || !Objects.equal(this.f24934f, ow0Var.f24934f)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hashCode(this.f24929a, this.f24931c, this.f24932d, this.f24934f, this.f24935g);
    }

    public final String toString() {
        char c;
        Object obj;
        Object obj2;
        char c2;
        String valueOf = String.valueOf(this.f24929a);
        BoundType boundType = BoundType.CLOSED;
        if (this.f24932d == boundType) {
            c = '[';
        } else {
            c = '(';
        }
        if (this.f24930b) {
            obj = this.f24931c;
        } else {
            obj = "-∞";
        }
        String valueOf2 = String.valueOf(obj);
        if (this.f24933e) {
            obj2 = this.f24934f;
        } else {
            obj2 = "∞";
        }
        String valueOf3 = String.valueOf(obj2);
        if (this.f24935g == boundType) {
            c2 = ']';
        } else {
            c2 = ')';
        }
        StringBuilder sb = new StringBuilder(valueOf3.length() + valueOf2.length() + valueOf.length() + 4);
        sb.append(valueOf);
        sb.append(":");
        sb.append(c);
        sb.append(valueOf2);
        sb.append(',');
        sb.append(valueOf3);
        sb.append(c2);
        return sb.toString();
    }
}
