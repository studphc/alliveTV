package com.google.common.collect;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import p000.b61;

/* renamed from: com.google.common.collect.b3 */
/* loaded from: classes.dex */
public final class C0850b3 implements Iterator {

    /* renamed from: a */
    public final Iterator f14779a;

    /* renamed from: b */
    public Map.Entry f14780b;

    /* renamed from: c */
    public Iterator f14781c = b61.f7906a;

    public C0850b3(C0855c3 c0855c3) {
        this.f14779a = c0855c3.f14788c.entrySet().iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (!this.f14779a.hasNext() && !this.f14781c.hasNext()) {
            return false;
        }
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!this.f14781c.hasNext()) {
            Map.Entry entry = (Map.Entry) this.f14779a.next();
            this.f14780b = entry;
            this.f14781c = ((Map) entry.getValue()).entrySet().iterator();
        }
        Objects.requireNonNull(this.f14780b);
        Map.Entry entry2 = (Map.Entry) this.f14781c.next();
        return Tables.immutableCell(this.f14780b.getKey(), entry2.getKey(), entry2.getValue());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f14781c.remove();
        Map.Entry entry = this.f14780b;
        Objects.requireNonNull(entry);
        if (((Map) entry.getValue()).isEmpty()) {
            this.f14779a.remove();
            this.f14780b = null;
        }
    }
}
