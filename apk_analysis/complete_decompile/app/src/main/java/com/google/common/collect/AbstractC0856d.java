package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.CheckForNull;
import p000.C1180f2;
import p000.p63;

/* renamed from: com.google.common.collect.d */
/* loaded from: classes.dex */
public abstract class AbstractC0856d extends AbstractCollection implements Multiset {

    /* renamed from: a */
    public transient Set f14793a;

    /* renamed from: b */
    public transient Set f14794b;

    /* renamed from: a */
    public Set mo3837a() {
        return new C1180f2(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public final boolean add(Object obj) {
        add(obj, 1);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    public final boolean addAll(Collection<Object> collection) {
        return Multisets.m4060a(this, collection);
    }

    /* renamed from: b */
    public abstract int mo3838b();

    /* renamed from: c */
    public abstract Iterator mo3839c();

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public boolean contains(Object obj) {
        if (count(obj) > 0) {
            return true;
        }
        return false;
    }

    public Set createEntrySet() {
        return new C0851c(this);
    }

    /* renamed from: d */
    public abstract Iterator mo3840d();

    public Set elementSet() {
        Set set = this.f14793a;
        if (set == null) {
            Set mo3837a = mo3837a();
            this.f14793a = mo3837a;
            return mo3837a;
        }
        return set;
    }

    public Set entrySet() {
        Set set = this.f14794b;
        if (set == null) {
            Set createEntrySet = createEntrySet();
            this.f14794b = createEntrySet;
            return createEntrySet;
        }
        return set;
    }

    @Override // java.util.Collection, com.google.common.collect.Multiset
    public final boolean equals(@CheckForNull Object obj) {
        return Multisets.m4061b(this, obj);
    }

    @Override // java.util.Collection, com.google.common.collect.Multiset
    public final int hashCode() {
        return entrySet().hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return entrySet().isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public final boolean remove(@CheckForNull Object obj) {
        return remove(obj, 1) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public final boolean removeAll(Collection<?> collection) {
        if (collection instanceof Multiset) {
            collection = ((Multiset) collection).elementSet();
        }
        return elementSet().removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public final boolean retainAll(Collection<?> collection) {
        Preconditions.checkNotNull(collection);
        if (collection instanceof Multiset) {
            collection = ((Multiset) collection).elementSet();
        }
        return elementSet().retainAll(collection);
    }

    public boolean setCount(Object obj, int i, int i2) {
        return Multisets.m4064e(this, obj, i, i2);
    }

    @Override // java.util.AbstractCollection, com.google.common.collect.Multiset
    public final String toString() {
        return entrySet().toString();
    }

    public int add(Object obj, int i) {
        throw new UnsupportedOperationException();
    }

    public int remove(Object obj, int i) {
        throw new UnsupportedOperationException();
    }

    public int setCount(Object obj, int i) {
        p63.m6869m(i, "count");
        int count = count(obj);
        int i2 = i - count;
        if (i2 > 0) {
            add(obj, i2);
        } else if (i2 < 0) {
            remove(obj, -i2);
        }
        return count;
    }
}
