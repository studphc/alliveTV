package com.google.common.collect;

import com.google.common.collect.Multiset;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.google.common.collect.m */
/* loaded from: classes.dex */
public final class C0901m extends AbstractIterator {

    /* renamed from: c */
    public final Iterator f14883c;

    public C0901m(ConcurrentHashMultiset concurrentHashMultiset) {
        this.f14883c = concurrentHashMultiset.f14624c.entrySet().iterator();
    }

    @Override // com.google.common.collect.AbstractIterator
    public final Object computeNext() {
        Map.Entry entry;
        int i;
        do {
            Iterator it = this.f14883c;
            if (!it.hasNext()) {
                return (Multiset.Entry) endOfData();
            }
            entry = (Map.Entry) it.next();
            i = ((AtomicInteger) entry.getValue()).get();
        } while (i == 0);
        return Multisets.immutableEntry(entry.getKey(), i);
    }
}
