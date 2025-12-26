package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.Ordering;
import java.io.Serializable;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class mc2 extends Ordering implements Serializable {

    /* renamed from: a */
    public static final mc2 f22893a = new Ordering();
    private static final long serialVersionUID = 0;

    private Object readResolve() {
        return f22893a;
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        Comparable comparable = (Comparable) obj;
        Comparable comparable2 = (Comparable) obj2;
        Preconditions.checkNotNull(comparable);
        if (comparable == comparable2) {
            return 0;
        }
        return comparable2.compareTo(comparable);
    }

    @Override // com.google.common.collect.Ordering
    public final Object max(Object obj, Object obj2) {
        return (Comparable) ir1.f20241c.min((Comparable) obj, (Comparable) obj2);
    }

    @Override // com.google.common.collect.Ordering
    public final Object min(Object obj, Object obj2) {
        return (Comparable) ir1.f20241c.max((Comparable) obj, (Comparable) obj2);
    }

    @Override // com.google.common.collect.Ordering
    public final Ordering reverse() {
        return Ordering.natural();
    }

    public final String toString() {
        return "Ordering.natural().reverse()";
    }

    @Override // com.google.common.collect.Ordering
    public final Object max(Object obj, Object obj2, Object obj3, Object[] objArr) {
        return (Comparable) ir1.f20241c.min((Comparable) obj, (Comparable) obj2, (Comparable) obj3, (Comparable[]) objArr);
    }

    @Override // com.google.common.collect.Ordering
    public final Object min(Object obj, Object obj2, Object obj3, Object[] objArr) {
        return (Comparable) ir1.f20241c.max((Comparable) obj, (Comparable) obj2, (Comparable) obj3, (Comparable[]) objArr);
    }

    @Override // com.google.common.collect.Ordering
    public final Object max(Iterator it) {
        return (Comparable) ir1.f20241c.min(it);
    }

    @Override // com.google.common.collect.Ordering
    public final Object min(Iterator it) {
        return (Comparable) ir1.f20241c.max(it);
    }

    @Override // com.google.common.collect.Ordering
    public final Object max(Iterable iterable) {
        return (Comparable) ir1.f20241c.min(iterable);
    }

    @Override // com.google.common.collect.Ordering
    public final Object min(Iterable iterable) {
        return (Comparable) ir1.f20241c.max(iterable);
    }
}
