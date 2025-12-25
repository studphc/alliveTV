package p000;

import com.google.common.base.Preconditions;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class a61 implements Iterator {

    /* renamed from: a */
    public Iterator f52a;

    /* renamed from: b */
    public Iterator f53b;

    /* renamed from: c */
    public Iterator f54c;

    /* renamed from: d */
    public ArrayDeque f55d;

    @Override // java.util.Iterator
    public final boolean hasNext() {
        Iterator it;
        while (!((Iterator) Preconditions.checkNotNull(this.f53b)).hasNext()) {
            while (true) {
                Iterator it2 = this.f54c;
                if (it2 != null && it2.hasNext()) {
                    it = this.f54c;
                    break;
                }
                ArrayDeque arrayDeque = this.f55d;
                if (arrayDeque == null || arrayDeque.isEmpty()) {
                    break;
                }
                this.f54c = (Iterator) this.f55d.removeFirst();
            }
            it = null;
            this.f54c = it;
            if (it == null) {
                return false;
            }
            Iterator it3 = (Iterator) it.next();
            this.f53b = it3;
            if (it3 instanceof a61) {
                a61 a61Var = (a61) it3;
                this.f53b = a61Var.f53b;
                if (this.f55d == null) {
                    this.f55d = new ArrayDeque();
                }
                this.f55d.addFirst(this.f54c);
                if (a61Var.f55d != null) {
                    while (!a61Var.f55d.isEmpty()) {
                        this.f55d.addFirst((Iterator) a61Var.f55d.removeLast());
                    }
                }
                this.f54c = a61Var.f54c;
            }
        }
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (hasNext()) {
            Iterator it = this.f53b;
            this.f52a = it;
            return it.next();
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        Iterator it = this.f52a;
        if (it != null) {
            it.remove();
            this.f52a = null;
            return;
        }
        throw new IllegalStateException("no calls to next() since the last call to remove()");
    }
}
