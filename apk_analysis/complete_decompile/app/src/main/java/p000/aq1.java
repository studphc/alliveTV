package p000;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class aq1 implements Iterator {

    /* renamed from: a */
    public int f7709a;

    /* renamed from: b */
    public final /* synthetic */ bq1 f7710b;

    public aq1(bq1 bq1Var) {
        this.f7710b = bq1Var;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f7709a == 0) {
            bq1 bq1Var = this.f7710b;
            if (bq1Var.f8133b.f16083f.containsKey(bq1Var.f8132a)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (hasNext()) {
            this.f7709a++;
            bq1 bq1Var = this.f7710b;
            return bq1Var.f8133b.f16083f.get(bq1Var.f8132a);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        boolean z = true;
        if (this.f7709a != 1) {
            z = false;
        }
        p63.m6876t(z);
        this.f7709a = -1;
        bq1 bq1Var = this.f7710b;
        bq1Var.f8133b.f16083f.remove(bq1Var.f8132a);
    }
}
