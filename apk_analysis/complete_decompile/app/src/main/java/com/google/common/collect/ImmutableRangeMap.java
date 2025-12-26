package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import com.google.errorprone.annotations.DoNotMock;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;
import p000.AbstractC1726qj;
import p000.AbstractC1814sx;
import p000.C1777rx;
import p000.gl2;
import p000.hl2;
import p000.jl2;
import p000.kl2;
import p000.n82;
import p000.ng1;
import p000.nl2;
import p000.o82;
import p000.p63;
import p000.pl2;
import p000.q31;
import p000.r31;

@Beta
@GwtIncompatible
/* loaded from: classes.dex */
public class ImmutableRangeMap<K extends Comparable<?>, V> implements RangeMap<K, V>, Serializable {

    /* renamed from: c */
    public static final ImmutableRangeMap f14686c = new ImmutableRangeMap(ImmutableList.m3902of(), ImmutableList.m3902of());
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final transient ImmutableList f14687a;

    /* renamed from: b */
    public final transient ImmutableList f14688b;

    @DoNotMock
    /* loaded from: classes.dex */
    public static final class Builder<K extends Comparable<?>, V> {

        /* renamed from: a */
        public final ArrayList f14689a = Lists.newArrayList();

        public ImmutableRangeMap<K, V> build() {
            Range range = Range.f14746c;
            Ordering onResultOf = o82.f23661a.onResultOf(ng1.f23353a);
            ArrayList arrayList = this.f14689a;
            Collections.sort(arrayList, onResultOf);
            AbstractC0957z abstractC0957z = new AbstractC0957z(arrayList.size());
            AbstractC0957z abstractC0957z2 = new AbstractC0957z(arrayList.size());
            for (int i = 0; i < arrayList.size(); i++) {
                Range range2 = (Range) ((Map.Entry) arrayList.get(i)).getKey();
                if (i > 0) {
                    Range range3 = (Range) ((Map.Entry) arrayList.get(i - 1)).getKey();
                    if (range2.isConnected(range3) && !range2.intersection(range3).isEmpty()) {
                        String valueOf = String.valueOf(range3);
                        String valueOf2 = String.valueOf(range2);
                        throw new IllegalArgumentException(AbstractC1726qj.m7055k(valueOf2.length() + valueOf.length() + 47, "Overlapping ranges: range ", valueOf, " overlaps with entry ", valueOf2));
                    }
                }
                abstractC0957z.add((AbstractC0957z) range2);
                abstractC0957z2.add((AbstractC0957z) ((Map.Entry) arrayList.get(i)).getValue());
            }
            return new ImmutableRangeMap<>(abstractC0957z.build(), abstractC0957z2.build());
        }

        @CanIgnoreReturnValue
        public Builder<K, V> put(Range<K> range, V v) {
            Preconditions.checkNotNull(range);
            Preconditions.checkNotNull(v);
            Preconditions.checkArgument(!range.isEmpty(), "Range must not be empty, but was %s", range);
            this.f14689a.add(Maps.immutableEntry(range, v));
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<K, V> putAll(RangeMap<K, ? extends V> rangeMap) {
            for (Map.Entry<Range<K>, ? extends V> entry : rangeMap.asMapOfRanges().entrySet()) {
                put(entry.getKey(), entry.getValue());
            }
            return this;
        }
    }

    public ImmutableRangeMap(ImmutableList immutableList, ImmutableList immutableList2) {
        this.f14687a = immutableList;
        this.f14688b = immutableList2;
    }

    public static <K extends Comparable<?>, V> Builder<K, V> builder() {
        return new Builder<>();
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> copyOf(RangeMap<K, ? extends V> rangeMap) {
        if (rangeMap instanceof ImmutableRangeMap) {
            return (ImmutableRangeMap) rangeMap;
        }
        Map<Range<K>, ? extends V> asMapOfRanges = rangeMap.asMapOfRanges();
        AbstractC0957z abstractC0957z = new AbstractC0957z(asMapOfRanges.size());
        AbstractC0957z abstractC0957z2 = new AbstractC0957z(asMapOfRanges.size());
        for (Map.Entry<Range<K>, ? extends V> entry : asMapOfRanges.entrySet()) {
            abstractC0957z.add((AbstractC0957z) entry.getKey());
            abstractC0957z2.add((AbstractC0957z) entry.getValue());
        }
        return new ImmutableRangeMap<>(abstractC0957z.build(), abstractC0957z2.build());
    }

    /* renamed from: of */
    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> m3964of() {
        return f14686c;
    }

    @Override // com.google.common.collect.RangeMap
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeMap
    public boolean equals(@CheckForNull Object obj) {
        if (obj instanceof RangeMap) {
            return asMapOfRanges().equals(((RangeMap) obj).asMapOfRanges());
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.RangeMap
    @CheckForNull
    public V get(K k) {
        Range range = Range.f14746c;
        n82 n82Var = n82.f23285b;
        C1777rx m7422a = AbstractC1814sx.m7422a(k);
        kl2 kl2Var = pl2.f25216a;
        gl2 gl2Var = jl2.f20540a;
        ImmutableList immutableList = this.f14687a;
        int m6861e = p63.m6861e(immutableList, n82Var, m7422a, kl2Var, gl2Var);
        if (m6861e == -1 || !((Range) immutableList.get(m6861e)).contains(k)) {
            return null;
        }
        return (V) this.f14688b.get(m6861e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.RangeMap
    @CheckForNull
    public Map.Entry<Range<K>, V> getEntry(K k) {
        Range range = Range.f14746c;
        n82 n82Var = n82.f23285b;
        C1777rx m7422a = AbstractC1814sx.m7422a(k);
        kl2 kl2Var = pl2.f25216a;
        gl2 gl2Var = jl2.f20540a;
        ImmutableList immutableList = this.f14687a;
        int m6861e = p63.m6861e(immutableList, n82Var, m7422a, kl2Var, gl2Var);
        if (m6861e == -1) {
            return null;
        }
        Range range2 = (Range) immutableList.get(m6861e);
        if (!range2.contains(k)) {
            return null;
        }
        return Maps.immutableEntry(range2, this.f14688b.get(m6861e));
    }

    @Override // com.google.common.collect.RangeMap
    public int hashCode() {
        return asMapOfRanges().hashCode();
    }

    @Override // com.google.common.collect.RangeMap
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final void put(Range<K> range, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeMap
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final void putAll(RangeMap<K, V> rangeMap) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeMap
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final void putCoalescing(Range<K> range, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeMap
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final void remove(Range<K> range) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.RangeMap
    public Range<K> span() {
        ImmutableList immutableList = this.f14687a;
        if (!immutableList.isEmpty()) {
            return Range.m4068a(((Range) immutableList.get(0)).f14747a, ((Range) immutableList.get(immutableList.size() - 1)).f14748b);
        }
        throw new NoSuchElementException();
    }

    @Override // com.google.common.collect.RangeMap
    public String toString() {
        return asMapOfRanges().toString();
    }

    public Object writeReplace() {
        return new C0867f0(asMapOfRanges());
    }

    /* renamed from: of */
    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> m3965of(Range<K> range, V v) {
        return new ImmutableRangeMap<>(ImmutableList.m3903of(range), ImmutableList.m3903of(v));
    }

    @Override // com.google.common.collect.RangeMap
    public ImmutableMap<Range<K>, V> asDescendingMapOfRanges() {
        ImmutableList immutableList = this.f14687a;
        if (immutableList.isEmpty()) {
            return ImmutableMap.m3923of();
        }
        ImmutableList reverse = immutableList.reverse();
        Range range = Range.f14746c;
        return new ImmutableSortedMap(new C0909n2(reverse, o82.f23661a.reverse()), this.f14688b.reverse(), null);
    }

    @Override // com.google.common.collect.RangeMap
    public ImmutableMap<Range<K>, V> asMapOfRanges() {
        ImmutableList immutableList = this.f14687a;
        if (immutableList.isEmpty()) {
            return ImmutableMap.m3923of();
        }
        Range range = Range.f14746c;
        return new ImmutableSortedMap(new C0909n2(immutableList, o82.f23661a), this.f14688b, null);
    }

    @Override // com.google.common.collect.RangeMap
    public ImmutableRangeMap<K, V> subRangeMap(Range<K> range) {
        if (((Range) Preconditions.checkNotNull(range)).isEmpty()) {
            return m3964of();
        }
        ImmutableList immutableList = this.f14687a;
        if (immutableList.isEmpty() || range.encloses(span())) {
            return this;
        }
        Range range2 = Range.f14746c;
        n82 n82Var = n82.f23286c;
        nl2 nl2Var = pl2.f25219d;
        hl2 hl2Var = jl2.f20541b;
        int m6861e = p63.m6861e(immutableList, n82Var, range.f14747a, nl2Var, hl2Var);
        int m6861e2 = p63.m6861e(immutableList, n82.f23285b, range.f14748b, pl2.f25216a, hl2Var);
        if (m6861e >= m6861e2) {
            return m3964of();
        }
        return new r31(new q31(this, m6861e2 - m6861e, m6861e, range), this.f14688b.subList(m6861e, m6861e2), range, this);
    }
}
