package com.google.common.collect;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.Set;
import p000.gh2;

/* renamed from: com.google.common.collect.r2 */
/* loaded from: classes.dex */
public final class C0928r2 extends Sets.SetView {

    /* renamed from: a */
    public final /* synthetic */ Set f14948a;

    /* renamed from: b */
    public final /* synthetic */ Set f14949b;

    public C0928r2(Set set, Set set2) {
        this.f14948a = set;
        this.f14949b = set2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (!this.f14948a.contains(obj) && !this.f14949b.contains(obj)) {
            return false;
        }
        return true;
    }

    @Override // com.google.common.collect.Sets.SetView
    public final Set copyInto(Set set) {
        set.addAll(this.f14948a);
        set.addAll(this.f14949b);
        return set;
    }

    @Override // com.google.common.collect.Sets.SetView
    public final ImmutableSet immutableCopy() {
        return new ImmutableSet.Builder().addAll((Iterable) this.f14948a).addAll((Iterable) this.f14949b).build();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        if (this.f14948a.isEmpty() && this.f14949b.isEmpty()) {
            return true;
        }
        return false;
    }

    @Override // com.google.common.collect.Sets.SetView, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final UnmodifiableIterator iterator() {
        return new gh2(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        Set set = this.f14948a;
        int size = set.size();
        Iterator it = this.f14949b.iterator();
        while (it.hasNext()) {
            if (!set.contains(it.next())) {
                size++;
            }
        }
        return size;
    }

    @Override // com.google.common.collect.Sets.SetView, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new gh2(this);
    }
}
