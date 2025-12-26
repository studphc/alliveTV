package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import javax.annotation.CheckForNull;
import p000.AbstractC1726qj;
import p000.AbstractC1814sx;
import p000.C1666ox;
import p000.C1703px;
import p000.C1740qx;
import p000.m82;
import p000.p82;

@GwtCompatible
/* loaded from: classes.dex */
public final class Range<C extends Comparable> extends p82 implements Predicate<C>, Serializable {

    /* renamed from: c */
    public static final Range f14746c = new Range(C1740qx.f25786b, C1666ox.f24940b);
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final AbstractC1814sx f14747a;

    /* renamed from: b */
    public final AbstractC1814sx f14748b;

    public Range(AbstractC1814sx abstractC1814sx, AbstractC1814sx abstractC1814sx2) {
        String str;
        this.f14747a = (AbstractC1814sx) Preconditions.checkNotNull(abstractC1814sx);
        this.f14748b = (AbstractC1814sx) Preconditions.checkNotNull(abstractC1814sx2);
        if (abstractC1814sx.compareTo(abstractC1814sx2) <= 0 && abstractC1814sx != C1666ox.f24940b && abstractC1814sx2 != C1740qx.f25786b) {
            return;
        }
        StringBuilder sb = new StringBuilder(16);
        abstractC1814sx.mo6737d(sb);
        sb.append("..");
        abstractC1814sx2.mo6738e(sb);
        String valueOf = String.valueOf(sb.toString());
        if (valueOf.length() != 0) {
            str = "Invalid range: ".concat(valueOf);
        } else {
            str = new String("Invalid range: ");
        }
        throw new IllegalArgumentException(str);
    }

    /* renamed from: a */
    public static Range m4068a(AbstractC1814sx abstractC1814sx, AbstractC1814sx abstractC1814sx2) {
        return new Range(abstractC1814sx, abstractC1814sx2);
    }

    public static <C extends Comparable<?>> Range<C> all() {
        return f14746c;
    }

    public static <C extends Comparable<?>> Range<C> atLeast(C c) {
        return new Range<>(AbstractC1814sx.m7422a(c), C1666ox.f24940b);
    }

    public static <C extends Comparable<?>> Range<C> atMost(C c) {
        return new Range<>(C1740qx.f25786b, new C1703px(c));
    }

    public static <C extends Comparable<?>> Range<C> closed(C c, C c2) {
        return new Range<>(AbstractC1814sx.m7422a(c), new C1703px(c2));
    }

    public static <C extends Comparable<?>> Range<C> closedOpen(C c, C c2) {
        return new Range<>(AbstractC1814sx.m7422a(c), AbstractC1814sx.m7422a(c2));
    }

    public static <C extends Comparable<?>> Range<C> downTo(C c, BoundType boundType) {
        int i = m82.f22848a[boundType.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return atLeast(c);
            }
            throw new AssertionError();
        }
        return greaterThan(c);
    }

    public static <C extends Comparable<?>> Range<C> encloseAll(Iterable<C> iterable) {
        Preconditions.checkNotNull(iterable);
        if (iterable instanceof SortedSet) {
            SortedSet sortedSet = (SortedSet) iterable;
            Comparator comparator = sortedSet.comparator();
            if (Ordering.natural().equals(comparator) || comparator == null) {
                return closed((Comparable) sortedSet.first(), (Comparable) sortedSet.last());
            }
        }
        Iterator<C> it = iterable.iterator();
        Comparable comparable = (Comparable) Preconditions.checkNotNull(it.next());
        Comparable comparable2 = comparable;
        while (it.hasNext()) {
            Comparable comparable3 = (Comparable) Preconditions.checkNotNull(it.next());
            comparable = (Comparable) Ordering.natural().min(comparable, comparable3);
            comparable2 = (Comparable) Ordering.natural().max(comparable2, comparable3);
        }
        return closed(comparable, comparable2);
    }

    public static <C extends Comparable<?>> Range<C> greaterThan(C c) {
        return new Range<>(new C1703px(c), C1666ox.f24940b);
    }

    public static <C extends Comparable<?>> Range<C> lessThan(C c) {
        return new Range<>(C1740qx.f25786b, AbstractC1814sx.m7422a(c));
    }

    public static <C extends Comparable<?>> Range<C> open(C c, C c2) {
        return new Range<>(new C1703px(c), AbstractC1814sx.m7422a(c2));
    }

    public static <C extends Comparable<?>> Range<C> openClosed(C c, C c2) {
        return new Range<>(new C1703px(c), new C1703px(c2));
    }

    public static <C extends Comparable<?>> Range<C> range(C c, BoundType boundType, C c2, BoundType boundType2) {
        AbstractC1814sx m7422a;
        AbstractC1814sx c1703px;
        Preconditions.checkNotNull(boundType);
        Preconditions.checkNotNull(boundType2);
        BoundType boundType3 = BoundType.OPEN;
        if (boundType == boundType3) {
            m7422a = new C1703px(c);
        } else {
            m7422a = AbstractC1814sx.m7422a(c);
        }
        if (boundType2 == boundType3) {
            c1703px = AbstractC1814sx.m7422a(c2);
        } else {
            c1703px = new C1703px(c2);
        }
        return new Range<>(m7422a, c1703px);
    }

    public static <C extends Comparable<?>> Range<C> singleton(C c) {
        return closed(c, c);
    }

    public static <C extends Comparable<?>> Range<C> upTo(C c, BoundType boundType) {
        int i = m82.f22848a[boundType.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return atMost(c);
            }
            throw new AssertionError();
        }
        return lessThan(c);
    }

    public Range<C> canonical(DiscreteDomain<C> discreteDomain) {
        Preconditions.checkNotNull(discreteDomain);
        AbstractC1814sx abstractC1814sx = this.f14747a;
        AbstractC1814sx mo6933b = abstractC1814sx.mo6933b(discreteDomain);
        AbstractC1814sx abstractC1814sx2 = this.f14748b;
        AbstractC1814sx mo6933b2 = abstractC1814sx2.mo6933b(discreteDomain);
        if (mo6933b == abstractC1814sx && mo6933b2 == abstractC1814sx2) {
            return this;
        }
        return new Range<>(mo6933b, mo6933b2);
    }

    public boolean contains(C c) {
        Preconditions.checkNotNull(c);
        if (this.f14747a.mo6741h(c) && !this.f14748b.mo6741h(c)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean containsAll(Iterable<? extends C> iterable) {
        if (Iterables.isEmpty(iterable)) {
            return true;
        }
        if (iterable instanceof SortedSet) {
            SortedSet sortedSet = (SortedSet) iterable;
            Comparator comparator = sortedSet.comparator();
            if (Ordering.natural().equals(comparator) || comparator == null) {
                if (contains((Comparable) sortedSet.first()) && contains((Comparable) sortedSet.last())) {
                    return true;
                }
                return false;
            }
        }
        Iterator<? extends C> it = iterable.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public boolean encloses(Range<C> range) {
        if (this.f14747a.compareTo(range.f14747a) <= 0 && this.f14748b.compareTo(range.f14748b) >= 0) {
            return true;
        }
        return false;
    }

    @Override // com.google.common.base.Predicate
    public boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof Range)) {
            return false;
        }
        Range range = (Range) obj;
        if (!this.f14747a.equals(range.f14747a) || !this.f14748b.equals(range.f14748b)) {
            return false;
        }
        return true;
    }

    public Range<C> gap(Range<C> range) {
        boolean z;
        Range<C> range2;
        AbstractC1814sx abstractC1814sx = range.f14748b;
        AbstractC1814sx abstractC1814sx2 = this.f14747a;
        int compareTo = abstractC1814sx2.compareTo(abstractC1814sx);
        AbstractC1814sx abstractC1814sx3 = range.f14747a;
        if (compareTo < 0 && abstractC1814sx3.compareTo(this.f14748b) < 0) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(range);
            throw new IllegalArgumentException(AbstractC1726qj.m7055k(valueOf2.length() + valueOf.length() + 39, "Ranges have a nonempty intersection: ", valueOf, ", ", valueOf2));
        }
        if (abstractC1814sx2.compareTo(abstractC1814sx3) < 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            range2 = this;
        } else {
            range2 = range;
        }
        if (!z) {
            range = this;
        }
        return new Range<>(range2.f14748b, range.f14747a);
    }

    public boolean hasLowerBound() {
        if (this.f14747a != C1740qx.f25786b) {
            return true;
        }
        return false;
    }

    public boolean hasUpperBound() {
        if (this.f14748b != C1666ox.f24940b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f14748b.hashCode() + (this.f14747a.hashCode() * 31);
    }

    public Range<C> intersection(Range<C> range) {
        boolean z;
        AbstractC1814sx abstractC1814sx = range.f14747a;
        AbstractC1814sx abstractC1814sx2 = this.f14747a;
        int compareTo = abstractC1814sx2.compareTo(abstractC1814sx);
        AbstractC1814sx abstractC1814sx3 = this.f14748b;
        AbstractC1814sx abstractC1814sx4 = range.f14748b;
        int compareTo2 = abstractC1814sx3.compareTo(abstractC1814sx4);
        if (compareTo >= 0 && compareTo2 <= 0) {
            return this;
        }
        if (compareTo <= 0 && compareTo2 >= 0) {
            return range;
        }
        if (compareTo < 0) {
            abstractC1814sx2 = range.f14747a;
        }
        if (compareTo2 > 0) {
            abstractC1814sx3 = abstractC1814sx4;
        }
        if (abstractC1814sx2.compareTo(abstractC1814sx3) <= 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "intersection is undefined for disconnected ranges %s and %s", this, range);
        return new Range<>(abstractC1814sx2, abstractC1814sx3);
    }

    public boolean isConnected(Range<C> range) {
        if (this.f14747a.compareTo(range.f14748b) <= 0 && range.f14747a.compareTo(this.f14748b) <= 0) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        return this.f14747a.equals(this.f14748b);
    }

    public BoundType lowerBoundType() {
        return this.f14747a.mo6743j();
    }

    public C lowerEndpoint() {
        return (C) this.f14747a.mo6739f();
    }

    public Object readResolve() {
        if (equals(f14746c)) {
            return all();
        }
        return this;
    }

    public Range<C> span(Range<C> range) {
        AbstractC1814sx abstractC1814sx = range.f14747a;
        AbstractC1814sx abstractC1814sx2 = this.f14747a;
        int compareTo = abstractC1814sx2.compareTo(abstractC1814sx);
        AbstractC1814sx abstractC1814sx3 = this.f14748b;
        AbstractC1814sx abstractC1814sx4 = range.f14748b;
        int compareTo2 = abstractC1814sx3.compareTo(abstractC1814sx4);
        if (compareTo <= 0 && compareTo2 >= 0) {
            return this;
        }
        if (compareTo >= 0 && compareTo2 <= 0) {
            return range;
        }
        if (compareTo > 0) {
            abstractC1814sx2 = range.f14747a;
        }
        if (compareTo2 < 0) {
            abstractC1814sx3 = abstractC1814sx4;
        }
        return new Range<>(abstractC1814sx2, abstractC1814sx3);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(16);
        this.f14747a.mo6737d(sb);
        sb.append("..");
        this.f14748b.mo6738e(sb);
        return sb.toString();
    }

    public BoundType upperBoundType() {
        return this.f14748b.mo6744k();
    }

    public C upperEndpoint() {
        return (C) this.f14748b.mo6739f();
    }

    @Override // com.google.common.base.Predicate
    @Deprecated
    public boolean apply(C c) {
        return contains(c);
    }
}
