package p000;

import com.google.common.collect.Ordering;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class ct1 extends Ordering implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final Ordering f16103a;

    public ct1(Ordering ordering) {
        this.f16103a = ordering;
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        if (obj == obj2) {
            return 0;
        }
        if (obj == null) {
            return 1;
        }
        if (obj2 == null) {
            return -1;
        }
        return this.f16103a.compare(obj, obj2);
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ct1) {
            return this.f16103a.equals(((ct1) obj).f16103a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f16103a.hashCode() ^ (-921210296);
    }

    @Override // com.google.common.collect.Ordering
    public final Ordering nullsFirst() {
        return this.f16103a.nullsFirst();
    }

    @Override // com.google.common.collect.Ordering
    public final Ordering reverse() {
        return this.f16103a.reverse().nullsFirst();
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f16103a);
        return AbstractC1726qj.m7054j(valueOf.length() + 12, valueOf, ".nullsLast()");
    }

    @Override // com.google.common.collect.Ordering
    public final Ordering nullsLast() {
        return this;
    }
}
