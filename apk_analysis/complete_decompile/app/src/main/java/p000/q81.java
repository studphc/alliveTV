package p000;

import com.google.common.base.Preconditions;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class q81 implements Iterator {

    /* renamed from: a */
    public s81 f25484a;

    /* renamed from: b */
    public p81 f25485b;

    /* renamed from: c */
    public int f25486c;

    /* renamed from: d */
    public final /* synthetic */ r81 f25487d;

    public q81(r81 r81Var) {
        this.f25487d = r81Var;
        this.f25484a = r81Var.f25899e;
        this.f25486c = r81Var.f25898d;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        r81 r81Var = this.f25487d;
        if (r81Var.f25898d == this.f25486c) {
            if (this.f25484a != r81Var) {
                return true;
            }
            return false;
        }
        throw new ConcurrentModificationException();
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (hasNext()) {
            p81 p81Var = (p81) this.f25484a;
            Object obj = p81Var.f20726b;
            this.f25485b = p81Var;
            this.f25484a = p81Var.mo6888b();
            return obj;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        boolean z;
        r81 r81Var = this.f25487d;
        if (r81Var.f25898d == this.f25486c) {
            if (this.f25485b != null) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState(z, "no calls to next() since the last call to remove()");
            r81Var.remove(this.f25485b.f20726b);
            this.f25486c = r81Var.f25898d;
            this.f25485b = null;
            return;
        }
        throw new ConcurrentModificationException();
    }
}
