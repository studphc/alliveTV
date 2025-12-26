package p000;

import com.google.common.base.MoreObjects;
import com.google.common.collect.BoundType;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.Iterators;
import com.google.common.collect.Ordering;
import com.google.common.collect.PeekingIterator;
import com.google.common.collect.Range;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;

/* loaded from: classes.dex */
public final class nw2 extends AbstractC1254h2 {

    /* renamed from: a */
    public final AbstractMap f23516a;

    /* renamed from: b */
    public final ah1 f23517b;

    /* renamed from: c */
    public final Range f23518c;

    /* JADX WARN: Multi-variable type inference failed */
    public nw2(NavigableMap navigableMap, Range range) {
        this.f23516a = (AbstractMap) navigableMap;
        this.f23517b = new ah1(navigableMap);
        this.f23518c = range;
    }

    @Override // p000.yg1
    /* renamed from: a */
    public final Iterator mo84a() {
        Collection values;
        boolean z;
        Range range = this.f23518c;
        boolean hasLowerBound = range.hasLowerBound();
        ah1 ah1Var = this.f23517b;
        if (hasLowerBound) {
            AbstractC1814sx abstractC1814sx = (AbstractC1814sx) range.lowerEndpoint();
            if (range.lowerBoundType() == BoundType.CLOSED) {
                z = true;
            } else {
                z = false;
            }
            values = ah1Var.tailMap(abstractC1814sx, z).values();
        } else {
            values = ah1Var.values();
        }
        PeekingIterator peekingIterator = Iterators.peekingIterator(values.iterator());
        AbstractC1814sx abstractC1814sx2 = C1740qx.f25786b;
        if (!range.contains(abstractC1814sx2) || (peekingIterator.hasNext() && ((Range) peekingIterator.peek()).f14747a == abstractC1814sx2)) {
            if (peekingIterator.hasNext()) {
                abstractC1814sx2 = ((Range) peekingIterator.next()).f14748b;
            } else {
                return z51.f29250d;
            }
        }
        return new mw2(this, abstractC1814sx2, peekingIterator, 0);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.util.AbstractMap, java.util.Map, java.util.NavigableMap] */
    @Override // p000.AbstractC1254h2
    /* renamed from: c */
    public final Iterator mo85c() {
        AbstractC1814sx abstractC1814sx;
        boolean z;
        AbstractC1814sx abstractC1814sx2;
        Range range = this.f23518c;
        boolean hasUpperBound = range.hasUpperBound();
        C1666ox c1666ox = C1666ox.f24940b;
        if (hasUpperBound) {
            abstractC1814sx = (AbstractC1814sx) range.upperEndpoint();
        } else {
            abstractC1814sx = c1666ox;
        }
        if (range.hasUpperBound() && range.upperBoundType() == BoundType.CLOSED) {
            z = true;
        } else {
            z = false;
        }
        PeekingIterator peekingIterator = Iterators.peekingIterator(this.f23517b.headMap(abstractC1814sx, z).descendingMap().values().iterator());
        boolean hasNext = peekingIterator.hasNext();
        ?? r4 = this.f23516a;
        if (hasNext) {
            if (((Range) peekingIterator.peek()).f14748b == c1666ox) {
                abstractC1814sx2 = ((Range) peekingIterator.next()).f14747a;
            } else {
                abstractC1814sx2 = (AbstractC1814sx) r4.higherKey(((Range) peekingIterator.peek()).f14748b);
            }
        } else {
            C1740qx c1740qx = C1740qx.f25786b;
            if (range.contains(c1740qx) && !r4.containsKey(c1740qx)) {
                abstractC1814sx2 = (AbstractC1814sx) r4.higherKey(c1740qx);
            } else {
                return z51.f29250d;
            }
        }
        return new mw2(this, (AbstractC1814sx) MoreObjects.firstNonNull(abstractC1814sx2, c1666ox), peekingIterator, 1);
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
        if (obj instanceof AbstractC1814sx) {
            try {
                AbstractC1814sx abstractC1814sx = (AbstractC1814sx) obj;
                Map.Entry firstEntry = m6398f(Range.downTo(abstractC1814sx, BoundType.m3833a(true))).firstEntry();
                if (firstEntry != null && ((AbstractC1814sx) firstEntry.getKey()).equals(abstractC1814sx)) {
                    return (Range) firstEntry.getValue();
                }
            } catch (ClassCastException unused) {
            }
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.AbstractMap, java.util.NavigableMap] */
    /* renamed from: f */
    public final NavigableMap m6398f(Range range) {
        Range range2 = this.f23518c;
        if (!range2.isConnected(range)) {
            return ImmutableSortedMap.m3991of();
        }
        return new nw2(this.f23516a, range.intersection(range2));
    }

    @Override // java.util.NavigableMap
    public final NavigableMap headMap(Object obj, boolean z) {
        return m6398f(Range.upTo((AbstractC1814sx) obj, BoundType.m3833a(z)));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return Iterators.size(mo84a());
    }

    @Override // java.util.NavigableMap
    public final NavigableMap subMap(Object obj, boolean z, Object obj2, boolean z2) {
        return m6398f(Range.range((AbstractC1814sx) obj, BoundType.m3833a(z), (AbstractC1814sx) obj2, BoundType.m3833a(z2)));
    }

    @Override // java.util.NavigableMap
    public final NavigableMap tailMap(Object obj, boolean z) {
        return m6398f(Range.downTo((AbstractC1814sx) obj, BoundType.m3833a(z)));
    }
}
