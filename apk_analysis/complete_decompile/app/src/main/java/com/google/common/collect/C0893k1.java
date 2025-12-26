package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import p000.AbstractC1143e2;
import p000.fg1;
import p000.p63;
import p000.rv2;

/* renamed from: com.google.common.collect.k1 */
/* loaded from: classes.dex */
public class C0893k1 extends AbstractC0856d {

    /* renamed from: c */
    public final AbstractC1143e2 f14865c;

    public C0893k1(AbstractC1143e2 abstractC1143e2) {
        this.f14865c = abstractC1143e2;
    }

    @Override // com.google.common.collect.AbstractC0856d
    /* renamed from: b */
    public final int mo3838b() {
        return this.f14865c.asMap().size();
    }

    @Override // com.google.common.collect.AbstractC0856d
    /* renamed from: c */
    public final Iterator mo3839c() {
        throw new AssertionError("should never be called");
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.f14865c.clear();
    }

    @Override // com.google.common.collect.AbstractC0856d, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public final boolean contains(Object obj) {
        return this.f14865c.containsKey(obj);
    }

    @Override // com.google.common.collect.Multiset
    public final int count(Object obj) {
        Collection collection = (Collection) Maps.m4052h(this.f14865c.asMap(), obj);
        if (collection == null) {
            return 0;
        }
        return collection.size();
    }

    @Override // com.google.common.collect.AbstractC0856d
    /* renamed from: d */
    public final Iterator mo3840d() {
        return new rv2(this.f14865c.asMap().entrySet().iterator());
    }

    @Override // com.google.common.collect.AbstractC0856d, com.google.common.collect.Multiset
    public final Set elementSet() {
        return this.f14865c.keySet();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
    public final Iterator iterator() {
        return new fg1(this.f14865c.entries().iterator(), 0);
    }

    @Override // com.google.common.collect.AbstractC0856d, com.google.common.collect.Multiset
    public int remove(Object obj, int i) {
        p63.m6869m(i, "occurrences");
        if (i == 0) {
            return count(obj);
        }
        Collection collection = (Collection) Maps.m4052h(this.f14865c.asMap(), obj);
        if (collection == null) {
            return 0;
        }
        int size = collection.size();
        if (i >= size) {
            collection.clear();
        } else {
            Iterator it = collection.iterator();
            for (int i2 = 0; i2 < i; i2++) {
                it.next();
                it.remove();
            }
        }
        return size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public final int size() {
        return this.f14865c.size();
    }
}
