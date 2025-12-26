package p000;

import com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: b1 */
/* loaded from: classes.dex */
public abstract class AbstractC0541b1 implements Iterator {

    /* renamed from: a */
    public int f7846a = 2;

    /* renamed from: b */
    public Object f7847b;

    /* renamed from: a */
    public abstract Object mo2003a();

    @Override // java.util.Iterator
    public final boolean hasNext() {
        boolean z;
        if (this.f7846a != 4) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        int m7041F = AbstractC1726qj.m7041F(this.f7846a);
        if (m7041F == 0) {
            return true;
        }
        if (m7041F == 2) {
            return false;
        }
        this.f7846a = 4;
        this.f7847b = mo2003a();
        if (this.f7846a == 3) {
            return false;
        }
        this.f7846a = 1;
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (hasNext()) {
            this.f7846a = 2;
            Object obj = this.f7847b;
            this.f7847b = null;
            return obj;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
