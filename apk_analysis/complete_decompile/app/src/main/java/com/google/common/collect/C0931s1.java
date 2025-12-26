package com.google.common.collect;

import com.google.common.collect.Multiset;
import java.util.Iterator;

/* renamed from: com.google.common.collect.s1 */
/* loaded from: classes.dex */
public final class C0931s1 extends AbstractIterator {

    /* renamed from: c */
    public final /* synthetic */ Iterator f14957c;

    /* renamed from: d */
    public final /* synthetic */ Iterator f14958d;

    /* renamed from: e */
    public final /* synthetic */ C0935t1 f14959e;

    public C0931s1(C0935t1 c0935t1, Iterator it, Iterator it2) {
        this.f14959e = c0935t1;
        this.f14957c = it;
        this.f14958d = it2;
    }

    @Override // com.google.common.collect.AbstractIterator
    public final Object computeNext() {
        Multiset.Entry entry;
        Object element;
        Iterator it = this.f14957c;
        boolean hasNext = it.hasNext();
        C0935t1 c0935t1 = this.f14959e;
        if (hasNext) {
            Multiset.Entry entry2 = (Multiset.Entry) it.next();
            Object element2 = entry2.getElement();
            return Multisets.immutableEntry(element2, c0935t1.f14965d.count(element2) + entry2.getCount());
        }
        do {
            Iterator it2 = this.f14958d;
            if (it2.hasNext()) {
                entry = (Multiset.Entry) it2.next();
                element = entry.getElement();
            } else {
                return (Multiset.Entry) endOfData();
            }
        } while (c0935t1.f14964c.contains(element));
        return Multisets.immutableEntry(element, entry.getCount());
    }
}
