package com.google.common.collect;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

/* renamed from: com.google.common.collect.e2 */
/* loaded from: classes.dex */
public class C0864e2 extends ForwardingMultiset implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final Multiset f14811a;

    /* renamed from: b */
    public transient Set f14812b;

    /* renamed from: c */
    public transient Set f14813c;

    public C0864e2(Multiset multiset) {
        this.f14811a = multiset;
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Queue
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: e */
    public Set mo4088e() {
        return Collections.unmodifiableSet(this.f14811a.elementSet());
    }

    @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
    public Set elementSet() {
        Set set = this.f14812b;
        if (set == null) {
            Set mo4088e = mo4088e();
            this.f14812b = mo4088e;
            return mo4088e;
        }
        return set;
    }

    @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
    public final Set entrySet() {
        Set set = this.f14813c;
        if (set == null) {
            Set unmodifiableSet = Collections.unmodifiableSet(this.f14811a.entrySet());
            this.f14813c = unmodifiableSet;
            return unmodifiableSet;
        }
        return set;
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return Iterators.unmodifiableIterator(this.f14811a.iterator());
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
    public final int setCount(Object obj, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
    public final int add(Object obj, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
    public final int remove(Object obj, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
    public final boolean setCount(Object obj, int i, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public Multiset delegate() {
        return this.f14811a;
    }
}
