package com.google.common.collect;

import com.google.common.collect.Multiset;
import java.util.Iterator;

/* renamed from: com.google.common.collect.o1 */
/* loaded from: classes.dex */
public final class C0913o1 extends AbstractIterator {

    /* renamed from: c */
    public final /* synthetic */ Iterator f14913c;

    /* renamed from: d */
    public final /* synthetic */ Iterator f14914d;

    /* renamed from: e */
    public final /* synthetic */ C0918p1 f14915e;

    public C0913o1(C0918p1 c0918p1, Iterator it, Iterator it2) {
        this.f14915e = c0918p1;
        this.f14913c = it;
        this.f14914d = it2;
    }

    @Override // com.google.common.collect.AbstractIterator
    public final Object computeNext() {
        Multiset.Entry entry;
        Object element;
        Iterator it = this.f14913c;
        boolean hasNext = it.hasNext();
        C0918p1 c0918p1 = this.f14915e;
        if (hasNext) {
            Multiset.Entry entry2 = (Multiset.Entry) it.next();
            Object element2 = entry2.getElement();
            return Multisets.immutableEntry(element2, Math.max(entry2.getCount(), c0918p1.f14938d.count(element2)));
        }
        do {
            Iterator it2 = this.f14914d;
            if (it2.hasNext()) {
                entry = (Multiset.Entry) it2.next();
                element = entry.getElement();
            } else {
                return (Multiset.Entry) endOfData();
            }
        } while (c0918p1.f14937c.contains(element));
        return Multisets.immutableEntry(element, entry.getCount());
    }
}
