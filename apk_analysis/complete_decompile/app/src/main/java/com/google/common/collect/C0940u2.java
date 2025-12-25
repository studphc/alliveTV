package com.google.common.collect;

import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.Set;
import p000.gh2;

/* renamed from: com.google.common.collect.u2 */
/* loaded from: classes.dex */
public final class C0940u2 extends Sets.SetView {

    /* renamed from: a */
    public final /* synthetic */ Set f14973a;

    /* renamed from: b */
    public final /* synthetic */ Set f14974b;

    public C0940u2(Set set, Set set2) {
        this.f14973a = set;
        this.f14974b = set2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.f14974b.contains(obj) ^ this.f14973a.contains(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.f14973a.equals(this.f14974b);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        Set set;
        Set set2 = this.f14973a;
        Iterator it = set2.iterator();
        int i = 0;
        while (true) {
            boolean hasNext = it.hasNext();
            set = this.f14974b;
            if (!hasNext) {
                break;
            }
            if (!set.contains(it.next())) {
                i++;
            }
        }
        Iterator it2 = set.iterator();
        while (it2.hasNext()) {
            if (!set2.contains(it2.next())) {
                i++;
            }
        }
        return i;
    }

    @Override // com.google.common.collect.Sets.SetView, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final UnmodifiableIterator iterator() {
        return new gh2(this, this.f14973a.iterator(), this.f14974b.iterator(), 1);
    }
}
