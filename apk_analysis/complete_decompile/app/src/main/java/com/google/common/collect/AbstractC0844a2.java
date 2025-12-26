package com.google.common.collect;

import com.google.common.collect.Multiset;
import p000.oh2;

/* renamed from: com.google.common.collect.a2 */
/* loaded from: classes.dex */
public abstract class AbstractC0844a2 extends oh2 {
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        mo4081d().clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (!(obj instanceof Multiset.Entry)) {
            return false;
        }
        Multiset.Entry entry = (Multiset.Entry) obj;
        if (entry.getCount() <= 0 || mo4081d().count(entry.getElement()) != entry.getCount()) {
            return false;
        }
        return true;
    }

    /* renamed from: d */
    public abstract Multiset mo4081d();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        if (obj instanceof Multiset.Entry) {
            Multiset.Entry entry = (Multiset.Entry) obj;
            Object element = entry.getElement();
            int count = entry.getCount();
            if (count != 0) {
                return mo4081d().setCount(element, count, 0);
            }
        }
        return false;
    }
}
