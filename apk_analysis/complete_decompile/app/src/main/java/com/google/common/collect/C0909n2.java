package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import p000.o63;

/* renamed from: com.google.common.collect.n2 */
/* loaded from: classes.dex */
public final class C0909n2 extends ImmutableSortedSet {

    /* renamed from: f */
    public static final C0909n2 f14906f = new C0909n2(ImmutableList.m3902of(), Ordering.natural());

    /* renamed from: e */
    public final transient ImmutableList f14907e;

    public C0909n2(ImmutableList immutableList, Comparator comparator) {
        super(comparator);
        this.f14907e = immutableList;
    }

    @Override // com.google.common.collect.ImmutableCollection
    /* renamed from: a */
    public final int mo3896a(Object[] objArr, int i) {
        return this.f14907e.mo3896a(objArr, i);
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    public final ImmutableList asList() {
        return this.f14907e;
    }

    @Override // com.google.common.collect.ImmutableCollection
    /* renamed from: b */
    public final Object[] mo3897b() {
        return this.f14907e.mo3897b();
    }

    @Override // com.google.common.collect.ImmutableCollection
    /* renamed from: c */
    public final int mo3898c() {
        return this.f14907e.mo3898c();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public final Object ceiling(Object obj) {
        int m4138r = m4138r(obj, true);
        ImmutableList immutableList = this.f14907e;
        if (m4138r == immutableList.size()) {
            return null;
        }
        return immutableList.get(m4138r);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            if (Collections.binarySearch(this.f14907e, obj, this.f14715c) < 0) {
                return false;
            }
            return true;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean containsAll(Collection collection) {
        if (collection instanceof Multiset) {
            collection = ((Multiset) collection).elementSet();
        }
        if (o63.m6473q(collection, comparator()) && collection.size() > 1) {
            UnmodifiableIterator it = this.f14907e.iterator();
            Iterator it2 = collection.iterator();
            if (!it.hasNext()) {
                return false;
            }
            Object next = it2.next();
            E next2 = it.next();
            while (true) {
                try {
                    int compare = this.f14715c.compare(next2, next);
                    if (compare < 0) {
                        if (!it.hasNext()) {
                            return false;
                        }
                        next2 = it.next();
                    } else if (compare == 0) {
                        if (!it2.hasNext()) {
                            return true;
                        }
                        next = it2.next();
                    } else if (compare > 0) {
                        break;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return false;
        }
        return super.containsAll(collection);
    }

    @Override // com.google.common.collect.ImmutableCollection
    /* renamed from: d */
    public final int mo3899d() {
        return this.f14907e.mo3899d();
    }

    @Override // com.google.common.collect.ImmutableCollection
    /* renamed from: e */
    public final boolean mo7e() {
        return this.f14907e.mo7e();
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        ImmutableList immutableList = this.f14907e;
        if (immutableList.size() != set.size()) {
            return false;
        }
        if (isEmpty()) {
            return true;
        }
        Comparator comparator = this.f14715c;
        if (o63.m6473q(set, comparator)) {
            Iterator it = set.iterator();
            try {
                UnmodifiableIterator it2 = immutableList.iterator();
                while (it2.hasNext()) {
                    E next = it2.next();
                    Object next2 = it.next();
                    if (next2 == null || comparator.compare(next, next2) != 0) {
                        return false;
                    }
                }
                return true;
            } catch (ClassCastException | NoSuchElementException unused) {
                return false;
            }
        }
        return containsAll(set);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public final Object first() {
        if (!isEmpty()) {
            return this.f14907e.get(0);
        }
        throw new NoSuchElementException();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public final Object floor(Object obj) {
        int m4137q = m4137q(obj, true) - 1;
        if (m4137q == -1) {
            return null;
        }
        return this.f14907e.get(m4137q);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public final Object higher(Object obj) {
        int m4138r = m4138r(obj, false);
        ImmutableList immutableList = this.f14907e;
        if (m4138r == immutableList.size()) {
            return null;
        }
        return immutableList.get(m4138r);
    }

    public final int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        try {
            int binarySearch = Collections.binarySearch(this.f14907e, obj, this.f14715c);
            if (binarySearch < 0) {
                return -1;
            }
            return binarySearch;
        } catch (ClassCastException unused) {
            return -1;
        }
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final UnmodifiableIterator iterator() {
        return this.f14907e.iterator();
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    /* renamed from: k */
    public final ImmutableSortedSet mo3842k() {
        Comparator reverseOrder = Collections.reverseOrder(this.f14715c);
        if (isEmpty()) {
            return ImmutableSortedSet.m4015l(reverseOrder);
        }
        return new C0909n2(this.f14907e.reverse(), reverseOrder);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public final Object last() {
        if (!isEmpty()) {
            return this.f14907e.get(r0.size() - 1);
        }
        throw new NoSuchElementException();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public final Object lower(Object obj) {
        int m4137q = m4137q(obj, false) - 1;
        if (m4137q == -1) {
            return null;
        }
        return this.f14907e.get(m4137q);
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    /* renamed from: m */
    public final ImmutableSortedSet mo3843m(Object obj, boolean z) {
        return m4136p(0, m4137q(obj, z));
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    /* renamed from: n */
    public final ImmutableSortedSet mo3844n(Object obj, boolean z, Object obj2, boolean z2) {
        return mo3845o(obj, z).mo3843m(obj2, z2);
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    /* renamed from: o */
    public final ImmutableSortedSet mo3845o(Object obj, boolean z) {
        return m4136p(m4138r(obj, z), this.f14907e.size());
    }

    /* renamed from: p */
    public final C0909n2 m4136p(int i, int i2) {
        ImmutableList immutableList = this.f14907e;
        if (i == 0 && i2 == immutableList.size()) {
            return this;
        }
        Comparator comparator = this.f14715c;
        if (i < i2) {
            return new C0909n2(immutableList.subList(i, i2), comparator);
        }
        return ImmutableSortedSet.m4015l(comparator);
    }

    /* renamed from: q */
    public final int m4137q(Object obj, boolean z) {
        int binarySearch = Collections.binarySearch(this.f14907e, Preconditions.checkNotNull(obj), comparator());
        if (binarySearch >= 0) {
            if (z) {
                return binarySearch + 1;
            }
            return binarySearch;
        }
        return ~binarySearch;
    }

    /* renamed from: r */
    public final int m4138r(Object obj, boolean z) {
        int binarySearch = Collections.binarySearch(this.f14907e, Preconditions.checkNotNull(obj), comparator());
        if (binarySearch >= 0) {
            if (!z) {
                return binarySearch + 1;
            }
            return binarySearch;
        }
        return ~binarySearch;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f14907e.size();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public final UnmodifiableIterator descendingIterator() {
        return this.f14907e.reverse().iterator();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return this.f14907e.iterator();
    }
}
