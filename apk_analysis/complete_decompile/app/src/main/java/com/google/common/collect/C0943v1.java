package com.google.common.collect;

import com.google.common.collect.Multiset;
import java.util.Iterator;

/* renamed from: com.google.common.collect.v1 */
/* loaded from: classes.dex */
public final class C0943v1 extends AbstractIterator {

    /* renamed from: c */
    public final /* synthetic */ Iterator f14976c;

    /* renamed from: d */
    public final /* synthetic */ C0947w1 f14977d;

    public C0943v1(C0947w1 c0947w1, Iterator it) {
        this.f14977d = c0947w1;
        this.f14976c = it;
    }

    @Override // com.google.common.collect.AbstractIterator
    public final Object computeNext() {
        Object element;
        int count;
        do {
            Iterator it = this.f14976c;
            if (it.hasNext()) {
                Multiset.Entry entry = (Multiset.Entry) it.next();
                element = entry.getElement();
                count = entry.getCount() - this.f14977d.f14982d.count(element);
            } else {
                return (Multiset.Entry) endOfData();
            }
        } while (count <= 0);
        return Multisets.immutableEntry(element, count);
    }
}
