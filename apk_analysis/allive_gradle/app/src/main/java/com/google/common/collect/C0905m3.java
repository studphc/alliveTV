package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import p000.ow0;

/* renamed from: com.google.common.collect.m3 */
/* loaded from: classes.dex */
public final class C0905m3 implements Iterator {

    /* renamed from: a */
    public C0915o3 f14896a;

    /* renamed from: b */
    public C0900l3 f14897b;

    /* renamed from: c */
    public final /* synthetic */ TreeMultiset f14898c;

    public C0905m3(TreeMultiset treeMultiset) {
        C0915o3 c0915o3;
        this.f14898c = treeMultiset;
        C0915o3 c0915o32 = (C0915o3) treeMultiset.f14754e.f216b;
        C0915o3 c0915o33 = null;
        if (c0915o32 != null) {
            ow0 ow0Var = treeMultiset.f14755f;
            boolean z = ow0Var.f24930b;
            C0915o3 c0915o34 = treeMultiset.f14756g;
            if (z) {
                Comparator comparator = treeMultiset.comparator();
                Object obj = ow0Var.f24931c;
                c0915o3 = c0915o32.m4142d(comparator, obj);
                if (c0915o3 != null) {
                    if (ow0Var.f24932d == BoundType.OPEN && treeMultiset.comparator().compare(obj, c0915o3.f14917a) == 0) {
                        c0915o3 = c0915o3.f14925i;
                        Objects.requireNonNull(c0915o3);
                    }
                }
            } else {
                c0915o3 = c0915o34.f14925i;
                Objects.requireNonNull(c0915o3);
            }
            if (c0915o3 != c0915o34 && ow0Var.m6732a(c0915o3.f14917a)) {
                c0915o33 = c0915o3;
            }
        }
        this.f14896a = c0915o33;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        C0915o3 c0915o3 = this.f14896a;
        if (c0915o3 == null) {
            return false;
        }
        if (this.f14898c.f14755f.m6734c(c0915o3.f14917a)) {
            this.f14896a = null;
            return false;
        }
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (hasNext()) {
            C0915o3 c0915o3 = this.f14896a;
            Objects.requireNonNull(c0915o3);
            int i = TreeMultiset.f14753h;
            TreeMultiset treeMultiset = this.f14898c;
            treeMultiset.getClass();
            C0900l3 c0900l3 = new C0900l3(treeMultiset, c0915o3);
            this.f14897b = c0900l3;
            C0915o3 c0915o32 = this.f14896a.f14925i;
            Objects.requireNonNull(c0915o32);
            if (c0915o32 == treeMultiset.f14756g) {
                this.f14896a = null;
            } else {
                C0915o3 c0915o33 = this.f14896a.f14925i;
                Objects.requireNonNull(c0915o33);
                this.f14896a = c0915o33;
            }
            return c0900l3;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        boolean z;
        if (this.f14897b != null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "no calls to next() since the last call to remove()");
        this.f14898c.setCount(this.f14897b.f14881a.f14917a, 0);
        this.f14897b = null;
    }
}
