package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.TreeMap;

/* loaded from: classes.dex */
public final class jw2 implements RangeMap {

    /* renamed from: a */
    public final Range f20665a;

    /* renamed from: b */
    public final /* synthetic */ TreeRangeMap f20666b;

    public jw2(TreeRangeMap treeRangeMap, Range range) {
        this.f20666b = treeRangeMap;
        this.f20665a = range;
    }

    @Override // com.google.common.collect.RangeMap
    public final Map asDescendingMapOfRanges() {
        return new hw2(this);
    }

    @Override // com.google.common.collect.RangeMap
    public final Map asMapOfRanges() {
        return new iw2(this);
    }

    @Override // com.google.common.collect.RangeMap
    public final void clear() {
        this.f20666b.remove(this.f20665a);
    }

    @Override // com.google.common.collect.RangeMap
    public final boolean equals(Object obj) {
        if (obj instanceof RangeMap) {
            return new iw2(this).equals(((RangeMap) obj).asMapOfRanges());
        }
        return false;
    }

    @Override // com.google.common.collect.RangeMap
    public final Object get(Comparable comparable) {
        if (this.f20665a.contains(comparable)) {
            return this.f20666b.get(comparable);
        }
        return null;
    }

    @Override // com.google.common.collect.RangeMap
    public final Map.Entry getEntry(Comparable comparable) {
        Map.Entry entry;
        Range range = this.f20665a;
        if (range.contains(comparable) && (entry = this.f20666b.getEntry(comparable)) != null) {
            return Maps.immutableEntry(((Range) entry.getKey()).intersection(range), entry.getValue());
        }
        return null;
    }

    @Override // com.google.common.collect.RangeMap
    public final int hashCode() {
        return new iw2(this).hashCode();
    }

    @Override // com.google.common.collect.RangeMap
    public final void put(Range range, Object obj) {
        Range range2 = this.f20665a;
        Preconditions.checkArgument(range2.encloses(range), "Cannot put range %s into a subRangeMap(%s)", range, range2);
        this.f20666b.put(range, obj);
    }

    @Override // com.google.common.collect.RangeMap
    public final void putAll(RangeMap rangeMap) {
        if (rangeMap.asMapOfRanges().isEmpty()) {
            return;
        }
        Range span = rangeMap.span();
        Range range = this.f20665a;
        Preconditions.checkArgument(range.encloses(span), "Cannot putAll rangeMap with span %s into a subRangeMap(%s)", span, range);
        this.f20666b.putAll(rangeMap);
    }

    @Override // com.google.common.collect.RangeMap
    public final void putCoalescing(Range range, Object obj) {
        TreeRangeMap treeRangeMap = this.f20666b;
        if (!treeRangeMap.f14758a.isEmpty()) {
            Range range2 = this.f20665a;
            if (range2.encloses(range)) {
                Object checkNotNull = Preconditions.checkNotNull(obj);
                AbstractC1814sx abstractC1814sx = range.f14747a;
                TreeMap treeMap = treeRangeMap.f14758a;
                put(TreeRangeMap.m4077a(TreeRangeMap.m4077a(range, checkNotNull, treeMap.lowerEntry(abstractC1814sx)), checkNotNull, treeMap.floorEntry(range.f14748b)).intersection(range2), obj);
                return;
            }
        }
        put(range, obj);
    }

    @Override // com.google.common.collect.RangeMap
    public final void remove(Range range) {
        Range range2 = this.f20665a;
        if (range.isConnected(range2)) {
            this.f20666b.remove(range.intersection(range2));
        }
    }

    @Override // com.google.common.collect.RangeMap
    public final Range span() {
        TreeRangeMap treeRangeMap = this.f20666b;
        TreeMap treeMap = treeRangeMap.f14758a;
        Range range = this.f20665a;
        Map.Entry floorEntry = treeMap.floorEntry(range.f14747a);
        TreeMap treeMap2 = treeRangeMap.f14758a;
        AbstractC1814sx abstractC1814sx = range.f14747a;
        AbstractC1814sx abstractC1814sx2 = range.f14748b;
        if ((floorEntry != null && ((gw2) floorEntry.getValue()).f17854a.f14748b.compareTo(abstractC1814sx) > 0) || ((abstractC1814sx = (AbstractC1814sx) treeMap2.ceilingKey(abstractC1814sx)) != null && abstractC1814sx.compareTo(abstractC1814sx2) < 0)) {
            Map.Entry lowerEntry = treeMap2.lowerEntry(abstractC1814sx2);
            if (lowerEntry != null) {
                if (((gw2) lowerEntry.getValue()).f17854a.f14748b.compareTo(abstractC1814sx2) < 0) {
                    abstractC1814sx2 = ((gw2) lowerEntry.getValue()).f17854a.f14748b;
                }
                return new Range(abstractC1814sx, abstractC1814sx2);
            }
            throw new NoSuchElementException();
        }
        throw new NoSuchElementException();
    }

    @Override // com.google.common.collect.RangeMap
    public final RangeMap subRangeMap(Range range) {
        Range range2 = this.f20665a;
        boolean isConnected = range.isConnected(range2);
        TreeRangeMap treeRangeMap = this.f20666b;
        if (!isConnected) {
            treeRangeMap.getClass();
            return TreeRangeMap.f14757b;
        }
        return treeRangeMap.subRangeMap(range.intersection(range2));
    }

    @Override // com.google.common.collect.RangeMap
    public final String toString() {
        return new iw2(this).toString();
    }
}
