package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import java.util.Iterator;

/* renamed from: com.google.common.collect.n */
/* loaded from: classes.dex */
public final class C0906n extends ForwardingIterator {

    /* renamed from: a */
    public Multiset.Entry f14899a;

    /* renamed from: b */
    public final /* synthetic */ C0901m f14900b;

    /* renamed from: c */
    public final /* synthetic */ ConcurrentHashMultiset f14901c;

    public C0906n(ConcurrentHashMultiset concurrentHashMultiset, C0901m c0901m) {
        this.f14901c = concurrentHashMultiset;
        this.f14900b = c0901m;
    }

    @Override // com.google.common.collect.ForwardingIterator, com.google.common.collect.ForwardingObject
    public final Object delegate() {
        return this.f14900b;
    }

    @Override // com.google.common.collect.ForwardingIterator, java.util.Iterator
    public final Object next() {
        Multiset.Entry entry = (Multiset.Entry) super.next();
        this.f14899a = entry;
        return entry;
    }

    @Override // com.google.common.collect.ForwardingIterator, java.util.Iterator
    public final void remove() {
        boolean z;
        if (this.f14899a != null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "no calls to next() since the last call to remove()");
        this.f14901c.setCount(this.f14899a.getElement(), 0);
        this.f14899a = null;
    }

    @Override // com.google.common.collect.ForwardingIterator, com.google.common.collect.ForwardingObject
    public final Iterator delegate() {
        return this.f14900b;
    }
}
