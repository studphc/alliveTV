package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeMap;
import javax.annotation.CheckForNull;
import p000.AbstractC1672p2;
import p000.AbstractC1814sx;
import p000.kw2;
import p000.lw2;
import p000.ow2;

@Beta
@GwtIncompatible
/* loaded from: classes.dex */
public class TreeRangeSet<C extends Comparable<?>> extends AbstractC1672p2 implements Serializable {

    /* renamed from: a */
    public final AbstractMap f14759a;

    /* renamed from: b */
    public transient kw2 f14760b;

    /* renamed from: c */
    public transient kw2 f14761c;

    /* renamed from: d */
    public transient lw2 f14762d;

    /* JADX WARN: Multi-variable type inference failed */
    public TreeRangeSet(NavigableMap navigableMap) {
        this.f14759a = (AbstractMap) navigableMap;
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create() {
        return new TreeRangeSet<>(new TreeMap());
    }

    /* renamed from: a */
    public final void m4078a(Range range) {
        boolean isEmpty = range.isEmpty();
        AbstractMap abstractMap = this.f14759a;
        AbstractC1814sx abstractC1814sx = range.f14747a;
        if (isEmpty) {
            abstractMap.remove(abstractC1814sx);
        } else {
            abstractMap.put(abstractC1814sx, range);
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.AbstractMap, java.util.NavigableMap] */
    @Override // com.google.common.collect.RangeSet
    public void add(Range<C> range) {
        Preconditions.checkNotNull(range);
        if (range.isEmpty()) {
            return;
        }
        ?? r0 = this.f14759a;
        AbstractC1814sx abstractC1814sx = range.f14747a;
        Map.Entry lowerEntry = r0.lowerEntry(abstractC1814sx);
        AbstractC1814sx abstractC1814sx2 = range.f14748b;
        if (lowerEntry != null) {
            Range range2 = (Range) lowerEntry.getValue();
            if (range2.f14748b.compareTo(abstractC1814sx) >= 0) {
                AbstractC1814sx abstractC1814sx3 = range2.f14748b;
                if (abstractC1814sx3.compareTo(abstractC1814sx2) >= 0) {
                    abstractC1814sx2 = abstractC1814sx3;
                }
                abstractC1814sx = range2.f14747a;
            }
        }
        Map.Entry floorEntry = r0.floorEntry(abstractC1814sx2);
        if (floorEntry != null) {
            Range range3 = (Range) floorEntry.getValue();
            if (range3.f14748b.compareTo(abstractC1814sx2) >= 0) {
                abstractC1814sx2 = range3.f14748b;
            }
        }
        r0.subMap(abstractC1814sx, abstractC1814sx2).clear();
        m4078a(new Range(abstractC1814sx, abstractC1814sx2));
    }

    @Override // p000.AbstractC1672p2, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ void addAll(RangeSet rangeSet) {
        super.addAll(rangeSet);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.AbstractMap, java.util.NavigableMap] */
    @Override // com.google.common.collect.RangeSet
    public Set<Range<C>> asDescendingSetOfRanges() {
        kw2 kw2Var = this.f14761c;
        if (kw2Var == null) {
            kw2 kw2Var2 = new kw2(this.f14759a.descendingMap().values());
            this.f14761c = kw2Var2;
            return kw2Var2;
        }
        return kw2Var;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.AbstractMap, java.util.SortedMap] */
    @Override // com.google.common.collect.RangeSet
    public Set<Range<C>> asRanges() {
        kw2 kw2Var = this.f14760b;
        if (kw2Var == null) {
            kw2 kw2Var2 = new kw2(this.f14759a.values());
            this.f14760b = kw2Var2;
            return kw2Var2;
        }
        return kw2Var;
    }

    @Override // p000.AbstractC1672p2, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.google.common.collect.RangeSet
    public RangeSet<C> complement() {
        lw2 lw2Var = this.f14762d;
        if (lw2Var == null) {
            lw2 lw2Var2 = new lw2(this);
            this.f14762d = lw2Var2;
            return lw2Var2;
        }
        return lw2Var;
    }

    @Override // p000.AbstractC1672p2, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return super.contains(comparable);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.AbstractMap, java.util.NavigableMap] */
    @Override // com.google.common.collect.RangeSet
    public boolean encloses(Range<C> range) {
        Preconditions.checkNotNull(range);
        Map.Entry floorEntry = this.f14759a.floorEntry(range.f14747a);
        if (floorEntry != null && ((Range) floorEntry.getValue()).encloses(range)) {
            return true;
        }
        return false;
    }

    @Override // p000.AbstractC1672p2, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean enclosesAll(RangeSet rangeSet) {
        return super.enclosesAll(rangeSet);
    }

    @Override // p000.AbstractC1672p2, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean equals(@CheckForNull Object obj) {
        return super.equals(obj);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.AbstractMap, java.util.NavigableMap] */
    @Override // com.google.common.collect.RangeSet
    public boolean intersects(Range<C> range) {
        Preconditions.checkNotNull(range);
        AbstractC1814sx abstractC1814sx = range.f14747a;
        ?? r1 = this.f14759a;
        Map.Entry ceilingEntry = r1.ceilingEntry(abstractC1814sx);
        if (ceilingEntry != null && ((Range) ceilingEntry.getValue()).isConnected(range) && !((Range) ceilingEntry.getValue()).intersection(range).isEmpty()) {
            return true;
        }
        Map.Entry lowerEntry = r1.lowerEntry(range.f14747a);
        if (lowerEntry != null && ((Range) lowerEntry.getValue()).isConnected(range) && !((Range) lowerEntry.getValue()).intersection(range).isEmpty()) {
            return true;
        }
        return false;
    }

    @Override // p000.AbstractC1672p2, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.AbstractMap, java.util.NavigableMap] */
    @Override // com.google.common.collect.RangeSet
    @CheckForNull
    public Range<C> rangeContaining(C c) {
        Preconditions.checkNotNull(c);
        Map.Entry floorEntry = this.f14759a.floorEntry(AbstractC1814sx.m7422a(c));
        if (floorEntry != null && ((Range) floorEntry.getValue()).contains(c)) {
            return (Range) floorEntry.getValue();
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.AbstractMap, java.util.NavigableMap] */
    @Override // com.google.common.collect.RangeSet
    public void remove(Range<C> range) {
        Preconditions.checkNotNull(range);
        if (range.isEmpty()) {
            return;
        }
        ?? r0 = this.f14759a;
        AbstractC1814sx abstractC1814sx = range.f14747a;
        Map.Entry lowerEntry = r0.lowerEntry(abstractC1814sx);
        AbstractC1814sx abstractC1814sx2 = range.f14748b;
        if (lowerEntry != null) {
            Range range2 = (Range) lowerEntry.getValue();
            if (range2.f14748b.compareTo(abstractC1814sx) >= 0) {
                if (range.hasUpperBound()) {
                    AbstractC1814sx abstractC1814sx3 = range2.f14748b;
                    if (abstractC1814sx3.compareTo(abstractC1814sx2) >= 0) {
                        m4078a(new Range(abstractC1814sx2, abstractC1814sx3));
                    }
                }
                m4078a(new Range(range2.f14747a, abstractC1814sx));
            }
        }
        Map.Entry floorEntry = r0.floorEntry(abstractC1814sx2);
        if (floorEntry != null) {
            Range range3 = (Range) floorEntry.getValue();
            if (range.hasUpperBound() && range3.f14748b.compareTo(abstractC1814sx2) >= 0) {
                m4078a(new Range(abstractC1814sx2, range3.f14748b));
            }
        }
        r0.subMap(abstractC1814sx, abstractC1814sx2).clear();
    }

    @Override // p000.AbstractC1672p2, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ void removeAll(RangeSet rangeSet) {
        super.removeAll(rangeSet);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.AbstractMap, java.util.NavigableMap] */
    @Override // com.google.common.collect.RangeSet
    public Range<C> span() {
        ?? r0 = this.f14759a;
        Map.Entry firstEntry = r0.firstEntry();
        Map.Entry lastEntry = r0.lastEntry();
        if (firstEntry != null && lastEntry != null) {
            return new Range<>(((Range) firstEntry.getValue()).f14747a, ((Range) lastEntry.getValue()).f14748b);
        }
        throw new NoSuchElementException();
    }

    @Override // com.google.common.collect.RangeSet
    public RangeSet<C> subRangeSet(Range<C> range) {
        if (range.equals(Range.all())) {
            return this;
        }
        return new ow2(this, range);
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create(RangeSet<C> rangeSet) {
        TreeRangeSet<C> create = create();
        create.addAll(rangeSet);
        return create;
    }

    @Override // p000.AbstractC1672p2, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ void addAll(Iterable iterable) {
        super.addAll(iterable);
    }

    @Override // p000.AbstractC1672p2, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean enclosesAll(Iterable iterable) {
        return super.enclosesAll(iterable);
    }

    @Override // p000.AbstractC1672p2, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ void removeAll(Iterable iterable) {
        super.removeAll(iterable);
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create(Iterable<Range<C>> iterable) {
        TreeRangeSet<C> create = create();
        create.addAll(iterable);
        return create;
    }
}
