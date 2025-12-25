package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.Ordering;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class ir1 extends Ordering implements Serializable {

    /* renamed from: c */
    public static final ir1 f20241c = new Ordering();
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public transient Ordering f20242a;

    /* renamed from: b */
    public transient Ordering f20243b;

    private Object readResolve() {
        return f20241c;
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        Comparable comparable = (Comparable) obj;
        Comparable comparable2 = (Comparable) obj2;
        Preconditions.checkNotNull(comparable);
        Preconditions.checkNotNull(comparable2);
        return comparable.compareTo(comparable2);
    }

    @Override // com.google.common.collect.Ordering
    public final Ordering nullsFirst() {
        Ordering ordering = this.f20242a;
        if (ordering == null) {
            Ordering nullsFirst = super.nullsFirst();
            this.f20242a = nullsFirst;
            return nullsFirst;
        }
        return ordering;
    }

    @Override // com.google.common.collect.Ordering
    public final Ordering nullsLast() {
        Ordering ordering = this.f20243b;
        if (ordering == null) {
            Ordering nullsLast = super.nullsLast();
            this.f20243b = nullsLast;
            return nullsLast;
        }
        return ordering;
    }

    @Override // com.google.common.collect.Ordering
    public final Ordering reverse() {
        return mc2.f22893a;
    }

    public final String toString() {
        return "Ordering.natural()";
    }
}
