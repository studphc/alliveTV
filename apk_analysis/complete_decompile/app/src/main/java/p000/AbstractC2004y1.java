package p000;

import com.google.common.collect.AbstractC0846b;
import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: y1 */
/* loaded from: classes.dex */
public abstract class AbstractC2004y1 implements Iterator {

    /* renamed from: a */
    public final /* synthetic */ int f28788a;

    /* renamed from: b */
    public int f28789b;

    /* renamed from: c */
    public int f28790c;

    /* renamed from: d */
    public int f28791d;

    /* renamed from: e */
    public final /* synthetic */ Serializable f28792e;

    public AbstractC2004y1(AbstractC0846b abstractC0846b) {
        this.f28788a = 0;
        this.f28792e = abstractC0846b;
        this.f28789b = abstractC0846b.f14773c.mo4091c();
        this.f28790c = -1;
        this.f28791d = abstractC0846b.f14773c.f14822d;
    }

    /* renamed from: a */
    public abstract Object mo4979a(int i);

    /* renamed from: b */
    public abstract Object mo4079b(int i);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f28788a) {
            case 0:
                if (((AbstractC0846b) this.f28792e).f14773c.f14822d == this.f28791d) {
                    if (this.f28789b >= 0) {
                        return true;
                    }
                    return false;
                }
                throw new ConcurrentModificationException();
            default:
                if (this.f28790c >= 0) {
                    return true;
                }
                return false;
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f28788a) {
            case 0:
                if (hasNext()) {
                    Object mo4079b = mo4079b(this.f28789b);
                    int i = this.f28789b;
                    this.f28790c = i;
                    this.f28789b = ((AbstractC0846b) this.f28792e).f14773c.mo4099k(i);
                    return mo4079b;
                }
                throw new NoSuchElementException();
            default:
                C1328ir c1328ir = (C1328ir) this.f28792e;
                if (c1328ir.f20231e == this.f28789b) {
                    if (hasNext()) {
                        int i2 = this.f28790c;
                        this.f28791d = i2;
                        Object mo4979a = mo4979a(i2);
                        this.f28790c = c1328ir.mo5348k(this.f28790c);
                        return mo4979a;
                    }
                    throw new NoSuchElementException();
                }
                throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        boolean z;
        boolean z2;
        switch (this.f28788a) {
            case 0:
                AbstractC0846b abstractC0846b = (AbstractC0846b) this.f28792e;
                if (abstractC0846b.f14773c.f14822d == this.f28791d) {
                    if (this.f28790c != -1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    p63.m6876t(z);
                    abstractC0846b.f14774d -= abstractC0846b.f14773c.m4103o(this.f28790c);
                    this.f28789b = abstractC0846b.f14773c.mo4100l(this.f28789b, this.f28790c);
                    this.f28790c = -1;
                    this.f28791d = abstractC0846b.f14773c.f14822d;
                    return;
                }
                throw new ConcurrentModificationException();
            default:
                C1328ir c1328ir = (C1328ir) this.f28792e;
                if (c1328ir.f20231e == this.f28789b) {
                    if (this.f28791d >= 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    p63.m6876t(z2);
                    this.f28789b += 32;
                    c1328ir.remove(c1328ir.m5358u()[this.f28791d]);
                    this.f28790c = c1328ir.mo5342c(this.f28790c, this.f28791d);
                    this.f28791d = -1;
                    return;
                }
                throw new ConcurrentModificationException();
        }
    }

    public AbstractC2004y1(C1328ir c1328ir) {
        this.f28788a = 1;
        this.f28792e = c1328ir;
        this.f28789b = c1328ir.f20231e;
        this.f28790c = c1328ir.mo5347j();
        this.f28791d = -1;
    }
}
