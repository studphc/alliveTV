package com.google.common.collect;

import java.util.Iterator;

/* renamed from: com.google.common.collect.e */
/* loaded from: classes.dex */
public final class C0861e extends AbstractC0929s {

    /* renamed from: d */
    public final /* synthetic */ AbstractC0866f f14807d;

    public C0861e(AbstractC0866f abstractC0866f) {
        this.f14807d = abstractC0866f;
    }

    @Override // com.google.common.collect.AbstractC0929s
    /* renamed from: e */
    public final SortedMultiset mo3862e() {
        return this.f14807d;
    }

    @Override // com.google.common.collect.AbstractC0929s
    public final Iterator entryIterator() {
        TreeMultiset treeMultiset = (TreeMultiset) this.f14807d;
        treeMultiset.getClass();
        return new C0910n3(treeMultiset);
    }

    @Override // com.google.common.collect.AbstractC0929s, com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return Multisets.m4062c(this.f14807d.descendingMultiset());
    }
}
