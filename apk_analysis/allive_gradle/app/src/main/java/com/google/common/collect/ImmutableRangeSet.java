package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;
import p000.AbstractC1672p2;
import p000.AbstractC1814sx;
import p000.hl2;
import p000.jl2;
import p000.n82;
import p000.o82;
import p000.p63;
import p000.pl2;
import p000.s31;
import p000.u31;
import p000.w31;
import p000.x31;

@Beta
@GwtIncompatible
/* loaded from: classes.dex */
public final class ImmutableRangeSet<C extends Comparable> extends AbstractC1672p2 implements Serializable {

    /* renamed from: c */
    public static final ImmutableRangeSet f14690c = new ImmutableRangeSet(ImmutableList.m3902of());

    /* renamed from: d */
    public static final ImmutableRangeSet f14691d = new ImmutableRangeSet(ImmutableList.m3903of(Range.all()));

    /* renamed from: a */
    public final transient ImmutableList f14692a;

    /* renamed from: b */
    public transient ImmutableRangeSet f14693b;

    /* loaded from: classes.dex */
    public static class Builder<C extends Comparable<?>> {

        /* renamed from: a */
        public final ArrayList f14694a = Lists.newArrayList();

        @CanIgnoreReturnValue
        public Builder<C> add(Range<C> range) {
            Preconditions.checkArgument(!range.isEmpty(), "range must not be empty, but was %s", range);
            this.f14694a.add(range);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<C> addAll(RangeSet<C> rangeSet) {
            return addAll(rangeSet.asRanges());
        }

        public ImmutableRangeSet<C> build() {
            ArrayList arrayList = this.f14694a;
            AbstractC0957z abstractC0957z = new AbstractC0957z(arrayList.size());
            Range range = Range.f14746c;
            Collections.sort(arrayList, o82.f23661a);
            PeekingIterator peekingIterator = Iterators.peekingIterator(arrayList.iterator());
            while (peekingIterator.hasNext()) {
                Range range2 = (Range) peekingIterator.next();
                while (peekingIterator.hasNext()) {
                    Range<C> range3 = (Range) peekingIterator.peek();
                    if (range2.isConnected(range3)) {
                        Preconditions.checkArgument(range2.intersection(range3).isEmpty(), "Overlapping ranges not permitted but found %s overlapping %s", range2, range3);
                        range2 = range2.span((Range) peekingIterator.next());
                    }
                }
                abstractC0957z.add((AbstractC0957z) range2);
            }
            ImmutableList build = abstractC0957z.build();
            if (build.isEmpty()) {
                return ImmutableRangeSet.m3967of();
            }
            if (build.size() == 1 && ((Range) Iterables.getOnlyElement(build)).equals(Range.all())) {
                return ImmutableRangeSet.f14691d;
            }
            return new ImmutableRangeSet<>(build);
        }

        @CanIgnoreReturnValue
        public Builder<C> addAll(Iterable<Range<C>> iterable) {
            Iterator<Range<C>> it = iterable.iterator();
            while (it.hasNext()) {
                add(it.next());
            }
            return this;
        }
    }

    public ImmutableRangeSet(ImmutableList immutableList) {
        this.f14692a = immutableList;
    }

    public static <C extends Comparable<?>> Builder<C> builder() {
        return new Builder<>();
    }

    public static <C extends Comparable> ImmutableRangeSet<C> copyOf(RangeSet<C> rangeSet) {
        Preconditions.checkNotNull(rangeSet);
        if (rangeSet.isEmpty()) {
            return m3967of();
        }
        if (rangeSet.encloses(Range.all())) {
            return f14691d;
        }
        if (rangeSet instanceof ImmutableRangeSet) {
            ImmutableRangeSet<C> immutableRangeSet = (ImmutableRangeSet) rangeSet;
            if (!immutableRangeSet.f14692a.mo7e()) {
                return immutableRangeSet;
            }
        }
        return new ImmutableRangeSet<>(ImmutableList.copyOf((Collection) rangeSet.asRanges()));
    }

    /* renamed from: of */
    public static <C extends Comparable> ImmutableRangeSet<C> m3967of() {
        return f14690c;
    }

    public static <C extends Comparable<?>> ImmutableRangeSet<C> unionOf(Iterable<Range<C>> iterable) {
        return copyOf(TreeRangeSet.create(iterable));
    }

    @Override // com.google.common.collect.RangeSet
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public void add(Range<C> range) {
        throw new UnsupportedOperationException();
    }

    @Override // p000.AbstractC1672p2, com.google.common.collect.RangeSet
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public void addAll(RangeSet<C> rangeSet) {
        throw new UnsupportedOperationException();
    }

    public ImmutableSortedSet<C> asSet(DiscreteDomain<C> discreteDomain) {
        Preconditions.checkNotNull(discreteDomain);
        if (isEmpty()) {
            return ImmutableSortedSet.m4016of();
        }
        Range<C> canonical = span().canonical(discreteDomain);
        if (canonical.hasLowerBound()) {
            if (!canonical.hasUpperBound()) {
                try {
                    discreteDomain.maxValue();
                } catch (NoSuchElementException unused) {
                    throw new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded above");
                }
            }
            return new u31(this, discreteDomain);
        }
        throw new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded below");
    }

    @Override // p000.AbstractC1672p2, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // p000.AbstractC1672p2, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return super.contains(comparable);
    }

    public ImmutableRangeSet<C> difference(RangeSet<C> rangeSet) {
        TreeRangeSet create = TreeRangeSet.create(this);
        create.removeAll(rangeSet);
        return copyOf(create);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.RangeSet
    public boolean encloses(Range<C> range) {
        Range range2 = Range.f14746c;
        int m6862f = p63.m6862f(this.f14692a, n82.f23285b, range.f14747a, Ordering.natural(), pl2.f25216a, jl2.f20540a);
        if (m6862f != -1 && ((Range) this.f14692a.get(m6862f)).encloses(range)) {
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

    public ImmutableRangeSet<C> intersection(RangeSet<C> rangeSet) {
        TreeRangeSet create = TreeRangeSet.create(this);
        create.removeAll(rangeSet.complement());
        return copyOf(create);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.RangeSet
    public boolean intersects(Range<C> range) {
        Range range2 = Range.f14746c;
        int m6862f = p63.m6862f(this.f14692a, n82.f23285b, range.f14747a, Ordering.natural(), pl2.f25216a, jl2.f20541b);
        ImmutableList immutableList = this.f14692a;
        if (m6862f < immutableList.size() && ((Range) immutableList.get(m6862f)).isConnected(range) && !((Range) immutableList.get(m6862f)).intersection(range).isEmpty()) {
            return true;
        }
        if (m6862f > 0) {
            int i = m6862f - 1;
            if (((Range) immutableList.get(i)).isConnected(range) && !((Range) immutableList.get(i)).intersection(range).isEmpty()) {
                return true;
            }
        }
        return false;
    }

    @Override // p000.AbstractC1672p2, com.google.common.collect.RangeSet
    public boolean isEmpty() {
        return this.f14692a.isEmpty();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.RangeSet
    @CheckForNull
    public Range<C> rangeContaining(C c) {
        Range range = Range.f14746c;
        int m6862f = p63.m6862f(this.f14692a, n82.f23285b, AbstractC1814sx.m7422a(c), Ordering.natural(), pl2.f25216a, jl2.f20540a);
        if (m6862f == -1) {
            return null;
        }
        Range<C> range2 = (Range) this.f14692a.get(m6862f);
        if (!range2.contains(c)) {
            return null;
        }
        return range2;
    }

    @Override // com.google.common.collect.RangeSet
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public void remove(Range<C> range) {
        throw new UnsupportedOperationException();
    }

    @Override // p000.AbstractC1672p2, com.google.common.collect.RangeSet
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public void removeAll(RangeSet<C> rangeSet) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.RangeSet
    public Range<C> span() {
        ImmutableList immutableList = this.f14692a;
        if (!immutableList.isEmpty()) {
            return Range.m4068a(((Range) immutableList.get(0)).f14747a, ((Range) immutableList.get(immutableList.size() - 1)).f14748b);
        }
        throw new NoSuchElementException();
    }

    public ImmutableRangeSet<C> union(RangeSet<C> rangeSet) {
        return unionOf(Iterables.concat(asRanges(), rangeSet.asRanges()));
    }

    public Object writeReplace() {
        return new x31(this.f14692a);
    }

    /* renamed from: of */
    public static <C extends Comparable> ImmutableRangeSet<C> m3968of(Range<C> range) {
        Preconditions.checkNotNull(range);
        if (range.isEmpty()) {
            return m3967of();
        }
        if (range.equals(Range.all())) {
            return f14691d;
        }
        return new ImmutableRangeSet<>(ImmutableList.m3903of(range));
    }

    @Override // p000.AbstractC1672p2, com.google.common.collect.RangeSet
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public void addAll(Iterable<Range<C>> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeSet
    public ImmutableSet<Range<C>> asDescendingSetOfRanges() {
        ImmutableList immutableList = this.f14692a;
        if (immutableList.isEmpty()) {
            return ImmutableSet.m3971of();
        }
        ImmutableList reverse = immutableList.reverse();
        Range range = Range.f14746c;
        return new C0909n2(reverse, o82.f23661a.reverse());
    }

    @Override // com.google.common.collect.RangeSet
    public ImmutableSet<Range<C>> asRanges() {
        ImmutableList immutableList = this.f14692a;
        if (immutableList.isEmpty()) {
            return ImmutableSet.m3971of();
        }
        Range range = Range.f14746c;
        return new C0909n2(immutableList, o82.f23661a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.RangeSet
    public ImmutableRangeSet<C> complement() {
        ImmutableRangeSet<C> immutableRangeSet = this.f14693b;
        if (immutableRangeSet != null) {
            return immutableRangeSet;
        }
        ImmutableList immutableList = this.f14692a;
        if (immutableList.isEmpty()) {
            ImmutableRangeSet<C> immutableRangeSet2 = f14691d;
            this.f14693b = immutableRangeSet2;
            return immutableRangeSet2;
        }
        if (immutableList.size() == 1 && ((Range) immutableList.get(0)).equals(Range.all())) {
            ImmutableRangeSet<C> m3967of = m3967of();
            this.f14693b = m3967of;
            return m3967of;
        }
        ImmutableRangeSet<C> immutableRangeSet3 = new ImmutableRangeSet<>(new w31(this), this);
        this.f14693b = immutableRangeSet3;
        return immutableRangeSet3;
    }

    @Override // p000.AbstractC1672p2, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean enclosesAll(Iterable iterable) {
        return super.enclosesAll(iterable);
    }

    @Override // p000.AbstractC1672p2, com.google.common.collect.RangeSet
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public void removeAll(Iterable<Range<C>> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeSet
    public ImmutableRangeSet<C> subRangeSet(Range<C> range) {
        int i;
        int size;
        if (!isEmpty()) {
            Range<C> span = span();
            if (range.encloses(span)) {
                return this;
            }
            if (range.isConnected(span)) {
                ImmutableList immutableList = this.f14692a;
                if (!immutableList.isEmpty() && !range.isEmpty()) {
                    if (!range.encloses(span())) {
                        boolean hasLowerBound = range.hasLowerBound();
                        hl2 hl2Var = jl2.f20541b;
                        if (hasLowerBound) {
                            Range range2 = Range.f14746c;
                            i = p63.m6861e(immutableList, n82.f23286c, range.f14747a, pl2.f25219d, hl2Var);
                        } else {
                            i = 0;
                        }
                        if (range.hasUpperBound()) {
                            Range range3 = Range.f14746c;
                            size = p63.m6861e(immutableList, n82.f23285b, range.f14748b, pl2.f25218c, hl2Var);
                        } else {
                            size = immutableList.size();
                        }
                        int i2 = size - i;
                        if (i2 == 0) {
                            immutableList = ImmutableList.m3902of();
                        } else {
                            immutableList = new s31(this, i2, i, range);
                        }
                    }
                } else {
                    immutableList = ImmutableList.m3902of();
                }
                return new ImmutableRangeSet<>(immutableList);
            }
        }
        return m3967of();
    }

    public ImmutableRangeSet(w31 w31Var, ImmutableRangeSet immutableRangeSet) {
        this.f14692a = w31Var;
        this.f14693b = immutableRangeSet;
    }

    public static <C extends Comparable<?>> ImmutableRangeSet<C> copyOf(Iterable<Range<C>> iterable) {
        return new Builder().addAll(iterable).build();
    }
}
