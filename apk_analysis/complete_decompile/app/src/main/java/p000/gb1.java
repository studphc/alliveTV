package p000;

import com.google.common.cache.ConcurrentMapC0840e;
import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public final class gb1 extends AbstractQueue {

    /* renamed from: a */
    public final /* synthetic */ int f17630a;

    /* renamed from: b */
    public final db1 f17631b;

    public gb1(int i) {
        this.f17630a = i;
        switch (i) {
            case 1:
                eb1 eb1Var = new eb1(1);
                eb1Var.f16750b = eb1Var;
                eb1Var.f16751c = eb1Var;
                this.f17631b = eb1Var;
                return;
            default:
                eb1 eb1Var2 = new eb1(0);
                eb1Var2.f16750b = eb1Var2;
                eb1Var2.f16751c = eb1Var2;
                this.f17631b = eb1Var2;
                return;
        }
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        pb1 pb1Var = pb1.f25104a;
        db1 db1Var = this.f17631b;
        switch (this.f17630a) {
            case 0:
                eb1 eb1Var = (eb1) db1Var;
                j92 j92Var = eb1Var.f16750b;
                while (j92Var != eb1Var) {
                    j92 mo59n = j92Var.mo59n();
                    Logger logger = ConcurrentMapC0840e.f14584w;
                    j92Var.mo60o(pb1Var);
                    j92Var.mo55j(pb1Var);
                    j92Var = mo59n;
                }
                eb1Var.f16750b = eb1Var;
                eb1Var.f16751c = eb1Var;
                return;
            default:
                eb1 eb1Var2 = (eb1) db1Var;
                j92 j92Var2 = eb1Var2.f16750b;
                while (j92Var2 != eb1Var2) {
                    j92 mo56k = j92Var2.mo56k();
                    Logger logger2 = ConcurrentMapC0840e.f14584w;
                    j92Var2.mo53h(pb1Var);
                    j92Var2.mo52g(pb1Var);
                    j92Var2 = mo56k;
                }
                eb1Var2.f16750b = eb1Var2;
                eb1Var2.f16751c = eb1Var2;
                return;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        switch (this.f17630a) {
            case 0:
                if (((j92) obj).mo59n() != pb1.f25104a) {
                    return true;
                }
                return false;
            default:
                if (((j92) obj).mo56k() != pb1.f25104a) {
                    return true;
                }
                return false;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        switch (this.f17630a) {
            case 0:
                eb1 eb1Var = (eb1) this.f17631b;
                if (eb1Var.f16750b == eb1Var) {
                    return true;
                }
                return false;
            default:
                eb1 eb1Var2 = (eb1) this.f17631b;
                if (eb1Var2.f16750b == eb1Var2) {
                    return true;
                }
                return false;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        switch (this.f17630a) {
            case 0:
                eb1 eb1Var = (eb1) this.f17631b;
                j92 j92Var = eb1Var.f16750b;
                if (j92Var == eb1Var) {
                    j92Var = null;
                }
                return new fb1(this, j92Var, 0);
            default:
                eb1 eb1Var2 = (eb1) this.f17631b;
                j92 j92Var2 = eb1Var2.f16750b;
                if (j92Var2 == eb1Var2) {
                    j92Var2 = null;
                }
                return new fb1(this, j92Var2, 1);
        }
    }

    @Override // java.util.Queue
    public final boolean offer(Object obj) {
        db1 db1Var = this.f17631b;
        switch (this.f17630a) {
            case 0:
                j92 j92Var = (j92) obj;
                j92 mo50d = j92Var.mo50d();
                j92 mo59n = j92Var.mo59n();
                Logger logger = ConcurrentMapC0840e.f14584w;
                mo50d.mo60o(mo59n);
                mo59n.mo55j(mo50d);
                eb1 eb1Var = (eb1) db1Var;
                j92 j92Var2 = eb1Var.f16751c;
                j92Var2.mo60o(j92Var);
                j92Var.mo55j(j92Var2);
                j92Var.mo60o(eb1Var);
                eb1Var.f16751c = j92Var;
                return true;
            default:
                j92 j92Var3 = (j92) obj;
                j92 mo61p = j92Var3.mo61p();
                j92 mo56k = j92Var3.mo56k();
                Logger logger2 = ConcurrentMapC0840e.f14584w;
                mo61p.mo53h(mo56k);
                mo56k.mo52g(mo61p);
                eb1 eb1Var2 = (eb1) db1Var;
                j92 j92Var4 = eb1Var2.f16751c;
                j92Var4.mo53h(j92Var3);
                j92Var3.mo52g(j92Var4);
                j92Var3.mo53h(eb1Var2);
                eb1Var2.f16751c = j92Var3;
                return true;
        }
    }

    @Override // java.util.Queue
    public final Object peek() {
        switch (this.f17630a) {
            case 0:
                eb1 eb1Var = (eb1) this.f17631b;
                j92 j92Var = eb1Var.f16750b;
                if (j92Var == eb1Var) {
                    return null;
                }
                return j92Var;
            default:
                eb1 eb1Var2 = (eb1) this.f17631b;
                j92 j92Var2 = eb1Var2.f16750b;
                if (j92Var2 == eb1Var2) {
                    return null;
                }
                return j92Var2;
        }
    }

    @Override // java.util.Queue
    public final Object poll() {
        switch (this.f17630a) {
            case 0:
                eb1 eb1Var = (eb1) this.f17631b;
                j92 j92Var = eb1Var.f16750b;
                if (j92Var == eb1Var) {
                    return null;
                }
                remove(j92Var);
                return j92Var;
            default:
                eb1 eb1Var2 = (eb1) this.f17631b;
                j92 j92Var2 = eb1Var2.f16750b;
                if (j92Var2 == eb1Var2) {
                    return null;
                }
                remove(j92Var2);
                return j92Var2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean remove(Object obj) {
        pb1 pb1Var = pb1.f25104a;
        switch (this.f17630a) {
            case 0:
                j92 j92Var = (j92) obj;
                j92 mo50d = j92Var.mo50d();
                j92 mo59n = j92Var.mo59n();
                Logger logger = ConcurrentMapC0840e.f14584w;
                mo50d.mo60o(mo59n);
                mo59n.mo55j(mo50d);
                j92Var.mo60o(pb1Var);
                j92Var.mo55j(pb1Var);
                if (mo59n == pb1Var) {
                    return false;
                }
                return true;
            default:
                j92 j92Var2 = (j92) obj;
                j92 mo61p = j92Var2.mo61p();
                j92 mo56k = j92Var2.mo56k();
                Logger logger2 = ConcurrentMapC0840e.f14584w;
                mo61p.mo53h(mo56k);
                mo56k.mo52g(mo61p);
                j92Var2.mo53h(pb1Var);
                j92Var2.mo52g(pb1Var);
                if (mo56k == pb1Var) {
                    return false;
                }
                return true;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        switch (this.f17630a) {
            case 0:
                eb1 eb1Var = (eb1) this.f17631b;
                int i = 0;
                for (j92 j92Var = eb1Var.f16750b; j92Var != eb1Var; j92Var = j92Var.mo59n()) {
                    i++;
                }
                return i;
            default:
                eb1 eb1Var2 = (eb1) this.f17631b;
                int i2 = 0;
                for (j92 j92Var2 = eb1Var2.f16750b; j92Var2 != eb1Var2; j92Var2 = j92Var2.mo56k()) {
                    i2++;
                }
                return i2;
        }
    }
}
