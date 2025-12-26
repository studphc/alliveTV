package com.google.common.collect;

import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import p000.C0566bq;

/* renamed from: com.google.common.collect.s2 */
/* loaded from: classes.dex */
public final class C0932s2 extends Sets.SetView {

    /* renamed from: a */
    public final /* synthetic */ Set f14960a;

    /* renamed from: b */
    public final /* synthetic */ Set f14961b;

    public C0932s2(Set set, Set set2) {
        this.f14960a = set;
        this.f14961b = set2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (this.f14960a.contains(obj) && this.f14961b.contains(obj)) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean containsAll(Collection collection) {
        if (this.f14960a.containsAll(collection) && this.f14961b.containsAll(collection)) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return Collections.disjoint(this.f14961b, this.f14960a);
    }

    @Override // com.google.common.collect.Sets.SetView, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final UnmodifiableIterator iterator() {
        return new C0566bq(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        Iterator it = this.f14960a.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (this.f14961b.contains(it.next())) {
                i++;
            }
        }
        return i;
    }

    @Override // com.google.common.collect.Sets.SetView, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new C0566bq(this);
    }
}
