package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.BoundType;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.Iterators;
import com.google.common.collect.Ordering;
import com.google.common.collect.Range;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;

/* loaded from: classes.dex */
public final class pw2 extends AbstractC1254h2 {

    /* renamed from: a */
    public final Range f25325a;

    /* renamed from: b */
    public final Range f25326b;

    /* renamed from: c */
    public final NavigableMap f25327c;

    /* renamed from: d */
    public final ah1 f25328d;

    public pw2(Range range, Range range2, NavigableMap navigableMap) {
        this.f25325a = (Range) Preconditions.checkNotNull(range);
        this.f25326b = (Range) Preconditions.checkNotNull(range2);
        this.f25327c = (NavigableMap) Preconditions.checkNotNull(navigableMap);
        this.f25328d = new ah1(navigableMap);
    }

    @Override // p000.yg1
    /* renamed from: a */
    public final Iterator mo84a() {
        Iterator it;
        Range range = this.f25326b;
        if (range.isEmpty()) {
            return z51.f29250d;
        }
        Range range2 = this.f25325a;
        AbstractC1814sx abstractC1814sx = range2.f14748b;
        AbstractC1814sx abstractC1814sx2 = range.f14747a;
        if (abstractC1814sx.mo6741h(abstractC1814sx2)) {
            return z51.f29250d;
        }
        AbstractC1814sx abstractC1814sx3 = range2.f14747a;
        boolean z = false;
        if (abstractC1814sx3.mo6741h(abstractC1814sx2)) {
            it = this.f25328d.tailMap(abstractC1814sx2, false).values().iterator();
        } else {
            AbstractC1814sx abstractC1814sx4 = (AbstractC1814sx) abstractC1814sx3.mo6739f();
            if (range2.lowerBoundType() == BoundType.CLOSED) {
                z = true;
            }
            it = this.f25327c.tailMap(abstractC1814sx4, z).values().iterator();
        }
        return new gh2(this, it, (AbstractC1814sx) Ordering.natural().min(range2.f14748b, AbstractC1814sx.m7422a(range.f14748b)), 5);
    }

    @Override // p000.AbstractC1254h2
    /* renamed from: c */
    public final Iterator mo85c() {
        boolean z;
        Range range = this.f25326b;
        if (range.isEmpty()) {
            return z51.f29250d;
        }
        AbstractC1814sx abstractC1814sx = (AbstractC1814sx) Ordering.natural().min(this.f25325a.f14748b, AbstractC1814sx.m7422a(range.f14748b));
        AbstractC1814sx abstractC1814sx2 = (AbstractC1814sx) abstractC1814sx.mo6739f();
        if (abstractC1814sx.mo6744k() == BoundType.CLOSED) {
            z = true;
        } else {
            z = false;
        }
        return new C0566bq(this, this.f25327c.headMap(abstractC1814sx2, z).descendingMap().values().iterator(), 14);
    }

    @Override // java.util.SortedMap
    public final Comparator comparator() {
        return Ordering.natural();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        if (get(obj) != null) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public final Range get(Object obj) {
        Object value;
        Range range = this.f25326b;
        if (obj instanceof AbstractC1814sx) {
            try {
                AbstractC1814sx abstractC1814sx = (AbstractC1814sx) obj;
                if (this.f25325a.contains(abstractC1814sx) && abstractC1814sx.compareTo(range.f14747a) >= 0 && abstractC1814sx.compareTo(range.f14748b) < 0) {
                    boolean equals = abstractC1814sx.equals(range.f14747a);
                    NavigableMap navigableMap = this.f25327c;
                    if (equals) {
                        Map.Entry floorEntry = navigableMap.floorEntry(abstractC1814sx);
                        if (floorEntry == null) {
                            value = null;
                        } else {
                            value = floorEntry.getValue();
                        }
                        Range range2 = (Range) value;
                        if (range2 != null && range2.f14748b.compareTo(range.f14747a) > 0) {
                            return range2.intersection(range);
                        }
                    } else {
                        Range range3 = (Range) navigableMap.get(abstractC1814sx);
                        if (range3 != null) {
                            return range3.intersection(range);
                        }
                    }
                }
            } catch (ClassCastException unused) {
            }
        }
        return null;
    }

    /* renamed from: f */
    public final NavigableMap m6932f(Range range) {
        Range range2 = this.f25325a;
        if (!range.isConnected(range2)) {
            return ImmutableSortedMap.m3991of();
        }
        return new pw2(range2.intersection(range), this.f25326b, this.f25327c);
    }

    @Override // java.util.NavigableMap
    public final NavigableMap headMap(Object obj, boolean z) {
        return m6932f(Range.upTo((AbstractC1814sx) obj, BoundType.m3833a(z)));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return Iterators.size(mo84a());
    }

    @Override // java.util.NavigableMap
    public final NavigableMap subMap(Object obj, boolean z, Object obj2, boolean z2) {
        return m6932f(Range.range((AbstractC1814sx) obj, BoundType.m3833a(z), (AbstractC1814sx) obj2, BoundType.m3833a(z2)));
    }

    @Override // java.util.NavigableMap
    public final NavigableMap tailMap(Object obj, boolean z) {
        return m6932f(Range.downTo((AbstractC1814sx) obj, BoundType.m3833a(z)));
    }
}
