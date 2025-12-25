package com.google.common.collect;

import com.google.common.collect.Multiset;
import java.util.Objects;

/* renamed from: com.google.common.collect.d0 */
/* loaded from: classes.dex */
public final class C0857d0 extends UnmodifiableIterator {

    /* renamed from: a */
    public int f14795a;

    /* renamed from: b */
    public Object f14796b;

    /* renamed from: c */
    public final /* synthetic */ UnmodifiableIterator f14797c;

    public C0857d0(UnmodifiableIterator unmodifiableIterator) {
        this.f14797c = unmodifiableIterator;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f14795a <= 0 && !this.f14797c.hasNext()) {
            return false;
        }
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f14795a <= 0) {
            Multiset.Entry entry = (Multiset.Entry) this.f14797c.next();
            this.f14796b = entry.getElement();
            this.f14795a = entry.getCount();
        }
        this.f14795a--;
        Object obj = this.f14796b;
        Objects.requireNonNull(obj);
        return obj;
    }
}
