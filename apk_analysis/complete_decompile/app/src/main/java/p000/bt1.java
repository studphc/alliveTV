package p000;

import com.google.common.collect.Ordering;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class bt1 extends Ordering implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final Ordering f8151a;

    public bt1(Ordering ordering) {
        this.f8151a = ordering;
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        if (obj == obj2) {
            return 0;
        }
        if (obj == null) {
            return -1;
        }
        if (obj2 == null) {
            return 1;
        }
        return this.f8151a.compare(obj, obj2);
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof bt1) {
            return this.f8151a.equals(((bt1) obj).f8151a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f8151a.hashCode() ^ 957692532;
    }

    @Override // com.google.common.collect.Ordering
    public final Ordering nullsLast() {
        return this.f8151a.nullsLast();
    }

    @Override // com.google.common.collect.Ordering
    public final Ordering reverse() {
        return this.f8151a.reverse().nullsLast();
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f8151a);
        return AbstractC1726qj.m7054j(valueOf.length() + 13, valueOf, ".nullsFirst()");
    }

    @Override // com.google.common.collect.Ordering
    public final Ordering nullsFirst() {
        return this;
    }
}
