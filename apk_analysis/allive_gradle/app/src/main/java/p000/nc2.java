package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.Ordering;
import java.io.Serializable;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class nc2 extends Ordering implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final Ordering f23325a;

    public nc2(Ordering ordering) {
        this.f23325a = (Ordering) Preconditions.checkNotNull(ordering);
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return this.f23325a.compare(obj2, obj);
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof nc2) {
            return this.f23325a.equals(((nc2) obj).f23325a);
        }
        return false;
    }

    public final int hashCode() {
        return -this.f23325a.hashCode();
    }

    @Override // com.google.common.collect.Ordering
    public final Object max(Object obj, Object obj2) {
        return this.f23325a.min(obj, obj2);
    }

    @Override // com.google.common.collect.Ordering
    public final Object min(Object obj, Object obj2) {
        return this.f23325a.max(obj, obj2);
    }

    @Override // com.google.common.collect.Ordering
    public final Ordering reverse() {
        return this.f23325a;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f23325a);
        return AbstractC1726qj.m7054j(valueOf.length() + 10, valueOf, ".reverse()");
    }

    @Override // com.google.common.collect.Ordering
    public final Object max(Object obj, Object obj2, Object obj3, Object... objArr) {
        return this.f23325a.min(obj, obj2, obj3, objArr);
    }

    @Override // com.google.common.collect.Ordering
    public final Object min(Object obj, Object obj2, Object obj3, Object... objArr) {
        return this.f23325a.max(obj, obj2, obj3, objArr);
    }

    @Override // com.google.common.collect.Ordering
    public final Object max(Iterator it) {
        return this.f23325a.min(it);
    }

    @Override // com.google.common.collect.Ordering
    public final Object min(Iterator it) {
        return this.f23325a.max(it);
    }

    @Override // com.google.common.collect.Ordering
    public final Object max(Iterable iterable) {
        return this.f23325a.min(iterable);
    }

    @Override // com.google.common.collect.Ordering
    public final Object min(Iterable iterable) {
        return this.f23325a.max(iterable);
    }
}
