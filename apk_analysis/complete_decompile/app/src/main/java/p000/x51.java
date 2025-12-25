package p000;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class x51 implements Iterator {

    /* renamed from: a */
    public int f28441a;

    /* renamed from: b */
    public final /* synthetic */ int f28442b;

    /* renamed from: c */
    public final /* synthetic */ Iterator f28443c;

    public x51(Iterator it, int i) {
        this.f28442b = i;
        this.f28443c = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f28441a < this.f28442b && this.f28443c.hasNext()) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (hasNext()) {
            this.f28441a++;
            return this.f28443c.next();
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f28443c.remove();
    }
}
