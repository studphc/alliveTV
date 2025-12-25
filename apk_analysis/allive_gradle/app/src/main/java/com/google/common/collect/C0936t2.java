package com.google.common.collect;

import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.Set;
import p000.C0566bq;

/* renamed from: com.google.common.collect.t2 */
/* loaded from: classes.dex */
public final class C0936t2 extends Sets.SetView {

    /* renamed from: a */
    public final /* synthetic */ Set f14966a;

    /* renamed from: b */
    public final /* synthetic */ Set f14967b;

    public C0936t2(Set set, Set set2) {
        this.f14966a = set;
        this.f14967b = set2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (this.f14966a.contains(obj) && !this.f14967b.contains(obj)) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.f14967b.containsAll(this.f14966a);
    }

    @Override // com.google.common.collect.Sets.SetView, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final UnmodifiableIterator iterator() {
        return new C0566bq(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        Iterator it = this.f14966a.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (!this.f14967b.contains(it.next())) {
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
