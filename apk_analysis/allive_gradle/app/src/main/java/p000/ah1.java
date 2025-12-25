package p000;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.BoundType;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.common.collect.PeekingIterator;
import com.google.common.collect.Range;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;

/* loaded from: classes.dex */
public final class ah1 extends AbstractC1254h2 {

    /* renamed from: a */
    public final /* synthetic */ int f188a;

    /* renamed from: b */
    public final Object f189b;

    /* renamed from: c */
    public final Object f190c;

    public ah1(NavigableMap navigableMap) {
        this.f188a = 1;
        this.f189b = navigableMap;
        this.f190c = Range.all();
    }

    @Override // p000.yg1
    /* renamed from: a */
    public final Iterator mo84a() {
        Iterator it;
        switch (this.f188a) {
            case 0:
                return new w51(((NavigableSet) this.f189b).iterator(), (Function) this.f190c, 1);
            default:
                Range range = (Range) this.f190c;
                boolean hasLowerBound = range.hasLowerBound();
                NavigableMap navigableMap = (NavigableMap) this.f189b;
                if (!hasLowerBound) {
                    it = navigableMap.values().iterator();
                } else {
                    Map.Entry lowerEntry = navigableMap.lowerEntry((AbstractC1814sx) range.lowerEndpoint());
                    if (lowerEntry == null) {
                        it = navigableMap.values().iterator();
                    } else {
                        if (range.f14747a.mo6741h(((Range) lowerEntry.getValue()).f14748b)) {
                            it = navigableMap.tailMap((AbstractC1814sx) lowerEntry.getKey(), true).values().iterator();
                        } else {
                            it = navigableMap.tailMap((AbstractC1814sx) range.lowerEndpoint(), true).values().iterator();
                        }
                    }
                }
                return new C0566bq(this, it, 12);
        }
    }

    @Override // p000.AbstractC1254h2
    /* renamed from: c */
    public final Iterator mo85c() {
        Collection values;
        switch (this.f188a) {
            case 0:
                return descendingMap().entrySet().iterator();
            default:
                Range range = (Range) this.f190c;
                boolean hasUpperBound = range.hasUpperBound();
                NavigableMap navigableMap = (NavigableMap) this.f189b;
                if (hasUpperBound) {
                    values = navigableMap.headMap((AbstractC1814sx) range.upperEndpoint(), false).descendingMap().values();
                } else {
                    values = navigableMap.descendingMap().values();
                }
                PeekingIterator peekingIterator = Iterators.peekingIterator(values.iterator());
                if (peekingIterator.hasNext()) {
                    if (range.f14748b.mo6741h(((Range) peekingIterator.peek()).f14748b)) {
                        peekingIterator.next();
                    }
                }
                return new C0566bq(this, peekingIterator, 13);
        }
    }

    @Override // p000.yg1, java.util.AbstractMap, java.util.Map
    public void clear() {
        switch (this.f188a) {
            case 0:
                ((NavigableSet) this.f189b).clear();
                return;
            default:
                super.clear();
                return;
        }
    }

    @Override // java.util.SortedMap
    public final Comparator comparator() {
        switch (this.f188a) {
            case 0:
                return ((NavigableSet) this.f189b).comparator();
            default:
                return Ordering.natural();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        switch (this.f188a) {
            case 1:
                if (m86e(obj) != null) {
                    return true;
                }
                return false;
            default:
                return super.containsKey(obj);
        }
    }

    @Override // p000.AbstractC1254h2, java.util.NavigableMap
    public NavigableMap descendingMap() {
        switch (this.f188a) {
            case 0:
                return Maps.asMap(((NavigableSet) this.f189b).descendingSet(), (Function) this.f190c);
            default:
                return super.descendingMap();
        }
    }

    /* renamed from: e */
    public Range m86e(Object obj) {
        Map.Entry lowerEntry;
        if (obj instanceof AbstractC1814sx) {
            try {
                AbstractC1814sx abstractC1814sx = (AbstractC1814sx) obj;
                if (((Range) this.f190c).contains(abstractC1814sx) && (lowerEntry = ((NavigableMap) this.f189b).lowerEntry(abstractC1814sx)) != null && ((Range) lowerEntry.getValue()).f14748b.equals(abstractC1814sx)) {
                    return (Range) lowerEntry.getValue();
                }
            } catch (ClassCastException unused) {
            }
        }
        return null;
    }

    /* renamed from: f */
    public NavigableMap m87f(Range range) {
        Range range2 = (Range) this.f190c;
        if (range.isConnected(range2)) {
            return new ah1((NavigableMap) this.f189b, range.intersection(range2));
        }
        return ImmutableSortedMap.m3991of();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        switch (this.f188a) {
            case 0:
                if (Collections2.m3836c((NavigableSet) this.f189b, obj)) {
                    return ((Function) this.f190c).apply(obj);
                }
                return null;
            default:
                return m86e(obj);
        }
    }

    @Override // java.util.NavigableMap
    public final NavigableMap headMap(Object obj, boolean z) {
        switch (this.f188a) {
            case 0:
                return Maps.asMap(((NavigableSet) this.f189b).headSet(obj, z), (Function) this.f190c);
            default:
                return m87f(Range.upTo((AbstractC1814sx) obj, BoundType.m3833a(z)));
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        switch (this.f188a) {
            case 1:
                if (((Range) this.f190c).equals(Range.all())) {
                    return ((NavigableMap) this.f189b).isEmpty();
                }
                if (!mo84a().hasNext()) {
                    return true;
                }
                return false;
            default:
                return super.isEmpty();
        }
    }

    @Override // p000.AbstractC1254h2, java.util.NavigableMap
    public NavigableSet navigableKeySet() {
        switch (this.f188a) {
            case 0:
                return new hg1((NavigableSet) this.f189b);
            default:
                return super.navigableKeySet();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        switch (this.f188a) {
            case 0:
                return ((NavigableSet) this.f189b).size();
            default:
                if (((Range) this.f190c).equals(Range.all())) {
                    return ((NavigableMap) this.f189b).size();
                }
                return Iterators.size(mo84a());
        }
    }

    @Override // java.util.NavigableMap
    public final NavigableMap subMap(Object obj, boolean z, Object obj2, boolean z2) {
        switch (this.f188a) {
            case 0:
                return Maps.asMap(((NavigableSet) this.f189b).subSet(obj, z, obj2, z2), (Function) this.f190c);
            default:
                return m87f(Range.range((AbstractC1814sx) obj, BoundType.m3833a(z), (AbstractC1814sx) obj2, BoundType.m3833a(z2)));
        }
    }

    @Override // java.util.NavigableMap
    public final NavigableMap tailMap(Object obj, boolean z) {
        switch (this.f188a) {
            case 0:
                return Maps.asMap(((NavigableSet) this.f189b).tailSet(obj, z), (Function) this.f190c);
            default:
                return m87f(Range.downTo((AbstractC1814sx) obj, BoundType.m3833a(z)));
        }
    }

    public ah1(NavigableMap navigableMap, Range range) {
        this.f188a = 1;
        this.f189b = navigableMap;
        this.f190c = range;
    }

    public ah1(NavigableSet navigableSet, Function function) {
        this.f188a = 0;
        this.f189b = (NavigableSet) Preconditions.checkNotNull(navigableSet);
        this.f190c = (Function) Preconditions.checkNotNull(function);
    }
}
