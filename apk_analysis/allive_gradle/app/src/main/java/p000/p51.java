package p000;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class p51 implements Iterator {

    /* renamed from: a */
    public boolean f25042a = true;

    /* renamed from: b */
    public final /* synthetic */ Iterator f25043b;

    public p51(Iterator it) {
        this.f25043b = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f25043b.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        Object next = this.f25043b.next();
        this.f25042a = false;
        return next;
    }

    @Override // java.util.Iterator
    public final void remove() {
        p63.m6876t(!this.f25042a);
        this.f25043b.remove();
    }
}
