package com.google.common.collect;

import com.google.common.collect.Multiset;
import java.util.Iterator;

/* renamed from: com.google.common.collect.u1 */
/* loaded from: classes.dex */
public final class C0939u1 extends AbstractIterator {

    /* renamed from: c */
    public final /* synthetic */ Iterator f14971c;

    /* renamed from: d */
    public final /* synthetic */ C0947w1 f14972d;

    public C0939u1(C0947w1 c0947w1, Iterator it) {
        this.f14972d = c0947w1;
        this.f14971c = it;
    }

    @Override // com.google.common.collect.AbstractIterator
    public final Object computeNext() {
        Multiset.Entry entry;
        Object element;
        do {
            Iterator it = this.f14971c;
            if (it.hasNext()) {
                entry = (Multiset.Entry) it.next();
                element = entry.getElement();
            } else {
                return endOfData();
            }
        } while (entry.getCount() <= this.f14972d.f14982d.count(element));
        return element;
    }
}
