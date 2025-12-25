package com.google.common.collect;

import com.google.common.collect.Multiset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import javax.annotation.CheckForNull;

/* renamed from: com.google.common.collect.s */
/* loaded from: classes.dex */
public abstract class AbstractC0929s extends ForwardingMultiset implements SortedMultiset {

    /* renamed from: a */
    public transient Ordering f14950a;

    /* renamed from: b */
    public transient C0956y2 f14951b;

    /* renamed from: c */
    public transient C0925r f14952c;

    @Override // com.google.common.collect.SortedMultiset, p000.fl2
    public Comparator<Object> comparator() {
        Ordering ordering = this.f14950a;
        if (ordering == null) {
            Ordering reverse = Ordering.from(mo3862e().comparator()).reverse();
            this.f14950a = reverse;
            return reverse;
        }
        return ordering;
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<Object> descendingMultiset() {
        return mo3862e();
    }

    /* renamed from: e */
    public abstract SortedMultiset mo3862e();

    public abstract Iterator entryIterator();

    @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
    public Set<Multiset.Entry<Object>> entrySet() {
        C0925r c0925r = this.f14952c;
        if (c0925r == null) {
            C0925r c0925r2 = new C0925r(this);
            this.f14952c = c0925r2;
            return c0925r2;
        }
        return c0925r;
    }

    @Override // com.google.common.collect.SortedMultiset
    @CheckForNull
    public Multiset.Entry<Object> firstEntry() {
        return mo3862e().lastEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<Object> headMultiset(Object obj, BoundType boundType) {
        return mo3862e().tailMultiset(obj, boundType).descendingMultiset();
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable
    public Iterator<Object> iterator() {
        return Multisets.m4062c(this);
    }

    @Override // com.google.common.collect.SortedMultiset
    @CheckForNull
    public Multiset.Entry<Object> lastEntry() {
        return mo3862e().firstEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    @CheckForNull
    public Multiset.Entry<Object> pollFirstEntry() {
        return mo3862e().pollLastEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    @CheckForNull
    public Multiset.Entry<Object> pollLastEntry() {
        return mo3862e().pollFirstEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<Object> subMultiset(Object obj, BoundType boundType, Object obj2, BoundType boundType2) {
        return mo3862e().subMultiset(obj2, boundType2, obj, boundType).descendingMultiset();
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<Object> tailMultiset(Object obj, BoundType boundType) {
        return mo3862e().headMultiset(obj, boundType).descendingMultiset();
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
    public Object[] toArray() {
        return standardToArray();
    }

    @Override // com.google.common.collect.ForwardingObject, com.google.common.collect.Multiset
    public String toString() {
        return entrySet().toString();
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) standardToArray(tArr);
    }

    @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public Multiset<Object> delegate() {
        return mo3862e();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.google.common.collect.x2, com.google.common.collect.y2, java.util.NavigableSet<java.lang.Object>] */
    @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
    public NavigableSet<Object> elementSet() {
        C0956y2 c0956y2 = this.f14951b;
        if (c0956y2 != null) {
            return c0956y2;
        }
        ?? abstractC0952x2 = new AbstractC0952x2(this);
        this.f14951b = abstractC0952x2;
        return abstractC0952x2;
    }
}
