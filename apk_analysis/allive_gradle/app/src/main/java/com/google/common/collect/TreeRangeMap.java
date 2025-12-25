package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.lang.Comparable;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.TreeMap;
import javax.annotation.CheckForNull;
import p000.AbstractC1814sx;
import p000.ew2;
import p000.fw2;
import p000.gw2;
import p000.jw2;

@Beta
@GwtIncompatible
/* loaded from: classes.dex */
public final class TreeRangeMap<K extends Comparable, V> implements RangeMap<K, V> {

    /* renamed from: b */
    public static final ew2 f14757b = new Object();

    /* renamed from: a */
    public final TreeMap f14758a = Maps.newTreeMap();

    /* renamed from: a */
    public static Range m4077a(Range range, Object obj, Map.Entry entry) {
        if (entry != null && ((gw2) entry.getValue()).f17854a.isConnected(range) && ((gw2) entry.getValue()).f17855b.equals(obj)) {
            return range.span(((gw2) entry.getValue()).f17854a);
        }
        return range;
    }

    public static <K extends Comparable, V> TreeRangeMap<K, V> create() {
        return new TreeRangeMap<>();
    }

    @Override // com.google.common.collect.RangeMap
    public Map<Range<K>, V> asDescendingMapOfRanges() {
        return new fw2(this, this.f14758a.descendingMap().values());
    }

    @Override // com.google.common.collect.RangeMap
    public Map<Range<K>, V> asMapOfRanges() {
        return new fw2(this, this.f14758a.values());
    }

    @Override // com.google.common.collect.RangeMap
    public void clear() {
        this.f14758a.clear();
    }

    @Override // com.google.common.collect.RangeMap
    public boolean equals(@CheckForNull Object obj) {
        if (obj instanceof RangeMap) {
            return asMapOfRanges().equals(((RangeMap) obj).asMapOfRanges());
        }
        return false;
    }

    @Override // com.google.common.collect.RangeMap
    @CheckForNull
    public V get(K k) {
        Map.Entry<Range<K>, V> entry = getEntry(k);
        if (entry == null) {
            return null;
        }
        return entry.getValue();
    }

    @Override // com.google.common.collect.RangeMap
    @CheckForNull
    public Map.Entry<Range<K>, V> getEntry(K k) {
        Map.Entry floorEntry = this.f14758a.floorEntry(AbstractC1814sx.m7422a(k));
        if (floorEntry != null && ((gw2) floorEntry.getValue()).f17854a.contains(k)) {
            return (Map.Entry) floorEntry.getValue();
        }
        return null;
    }

    @Override // com.google.common.collect.RangeMap
    public int hashCode() {
        return asMapOfRanges().hashCode();
    }

    @Override // com.google.common.collect.RangeMap
    public void put(Range<K> range, V v) {
        if (!range.isEmpty()) {
            Preconditions.checkNotNull(v);
            remove(range);
            gw2 gw2Var = new gw2(range, v);
            this.f14758a.put(range.f14747a, gw2Var);
        }
    }

    @Override // com.google.common.collect.RangeMap
    public void putAll(RangeMap<K, V> rangeMap) {
        for (Map.Entry<Range<K>, V> entry : rangeMap.asMapOfRanges().entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.common.collect.RangeMap
    public void putCoalescing(Range<K> range, V v) {
        TreeMap treeMap = this.f14758a;
        if (treeMap.isEmpty()) {
            put(range, v);
        } else {
            Object checkNotNull = Preconditions.checkNotNull(v);
            put(m4077a(m4077a(range, checkNotNull, treeMap.lowerEntry(range.f14747a)), checkNotNull, treeMap.floorEntry(range.f14748b)), v);
        }
    }

    @Override // com.google.common.collect.RangeMap
    public void remove(Range<K> range) {
        if (range.isEmpty()) {
            return;
        }
        TreeMap treeMap = this.f14758a;
        AbstractC1814sx abstractC1814sx = range.f14747a;
        Map.Entry lowerEntry = treeMap.lowerEntry(abstractC1814sx);
        AbstractC1814sx abstractC1814sx2 = range.f14748b;
        if (lowerEntry != null) {
            gw2 gw2Var = (gw2) lowerEntry.getValue();
            if (gw2Var.f17854a.f14748b.compareTo(abstractC1814sx) > 0) {
                Range range2 = gw2Var.f17854a;
                if (range2.f14748b.compareTo(abstractC1814sx2) > 0) {
                    treeMap.put(abstractC1814sx2, new gw2(new Range(abstractC1814sx2, range2.f14748b), ((gw2) lowerEntry.getValue()).f17855b));
                }
                Object obj = ((gw2) lowerEntry.getValue()).f17855b;
                AbstractC1814sx abstractC1814sx3 = range2.f14747a;
                treeMap.put(abstractC1814sx3, new gw2(new Range(abstractC1814sx3, abstractC1814sx), obj));
            }
        }
        Map.Entry lowerEntry2 = treeMap.lowerEntry(abstractC1814sx2);
        if (lowerEntry2 != null) {
            gw2 gw2Var2 = (gw2) lowerEntry2.getValue();
            if (gw2Var2.f17854a.f14748b.compareTo(abstractC1814sx2) > 0) {
                AbstractC1814sx abstractC1814sx4 = gw2Var2.f17854a.f14748b;
                treeMap.put(abstractC1814sx2, new gw2(new Range(abstractC1814sx2, abstractC1814sx4), ((gw2) lowerEntry2.getValue()).f17855b));
            }
        }
        treeMap.subMap(abstractC1814sx, abstractC1814sx2).clear();
    }

    @Override // com.google.common.collect.RangeMap
    public Range<K> span() {
        TreeMap treeMap = this.f14758a;
        Map.Entry firstEntry = treeMap.firstEntry();
        Map.Entry lastEntry = treeMap.lastEntry();
        if (firstEntry != null && lastEntry != null) {
            return new Range<>(((gw2) firstEntry.getValue()).f17854a.f14747a, ((gw2) lastEntry.getValue()).f17854a.f14748b);
        }
        throw new NoSuchElementException();
    }

    @Override // com.google.common.collect.RangeMap
    public RangeMap<K, V> subRangeMap(Range<K> range) {
        if (range.equals(Range.all())) {
            return this;
        }
        return new jw2(this, range);
    }

    @Override // com.google.common.collect.RangeMap
    public String toString() {
        return this.f14758a.values().toString();
    }
}
