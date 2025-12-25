package com.google.common.collect;

import com.google.common.collect.Multiset;
import java.util.Iterator;

/* renamed from: com.google.common.collect.q1 */
/* loaded from: classes.dex */
public final class C0923q1 extends AbstractIterator {

    /* renamed from: c */
    public final /* synthetic */ Iterator f14942c;

    /* renamed from: d */
    public final /* synthetic */ C0927r1 f14943d;

    public C0923q1(C0927r1 c0927r1, Iterator it) {
        this.f14943d = c0927r1;
        this.f14942c = it;
    }

    @Override // com.google.common.collect.AbstractIterator
    public final Object computeNext() {
        Object element;
        int min;
        do {
            Iterator it = this.f14942c;
            if (it.hasNext()) {
                Multiset.Entry entry = (Multiset.Entry) it.next();
                element = entry.getElement();
                min = Math.min(entry.getCount(), this.f14943d.f14947d.count(element));
            } else {
                return (Multiset.Entry) endOfData();
            }
        } while (min <= 0);
        return Multisets.immutableEntry(element, min);
    }
}
