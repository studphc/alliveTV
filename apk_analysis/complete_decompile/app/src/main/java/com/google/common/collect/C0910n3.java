package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import p000.ow0;

/* renamed from: com.google.common.collect.n3 */
/* loaded from: classes.dex */
public final class C0910n3 implements Iterator {

    /* renamed from: a */
    public C0915o3 f14908a;

    /* renamed from: b */
    public C0900l3 f14909b;

    /* renamed from: c */
    public final /* synthetic */ TreeMultiset f14910c;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x004a, code lost:
    
        if (r2.m6732a(r0.f14917a) != false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C0910n3(TreeMultiset treeMultiset) {
        C0915o3 c0915o3;
        this.f14910c = treeMultiset;
        C0915o3 c0915o32 = (C0915o3) treeMultiset.f14754e.f216b;
        if (c0915o32 != null) {
            ow0 ow0Var = treeMultiset.f14755f;
            boolean z = ow0Var.f24933e;
            C0915o3 c0915o33 = treeMultiset.f14756g;
            if (z) {
                Comparator comparator = treeMultiset.comparator();
                Object obj = ow0Var.f24934f;
                c0915o3 = c0915o32.m4145g(comparator, obj);
                if (c0915o3 != null) {
                    if (ow0Var.f24935g == BoundType.OPEN && treeMultiset.comparator().compare(obj, c0915o3.f14917a) == 0) {
                        c0915o3 = c0915o3.f14924h;
                        Objects.requireNonNull(c0915o3);
                    }
                }
            } else {
                c0915o3 = c0915o33.f14924h;
                Objects.requireNonNull(c0915o3);
            }
            if (c0915o3 != c0915o33) {
            }
        }
        c0915o3 = null;
        this.f14908a = c0915o3;
        this.f14909b = null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        C0915o3 c0915o3 = this.f14908a;
        if (c0915o3 == null) {
            return false;
        }
        if (this.f14910c.f14755f.m6735d(c0915o3.f14917a)) {
            this.f14908a = null;
            return false;
        }
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (hasNext()) {
            Objects.requireNonNull(this.f14908a);
            C0915o3 c0915o3 = this.f14908a;
            int i = TreeMultiset.f14753h;
            TreeMultiset treeMultiset = this.f14910c;
            treeMultiset.getClass();
            C0900l3 c0900l3 = new C0900l3(treeMultiset, c0915o3);
            this.f14909b = c0900l3;
            C0915o3 c0915o32 = this.f14908a.f14924h;
            Objects.requireNonNull(c0915o32);
            if (c0915o32 == treeMultiset.f14756g) {
                this.f14908a = null;
            } else {
                C0915o3 c0915o33 = this.f14908a.f14924h;
                Objects.requireNonNull(c0915o33);
                this.f14908a = c0915o33;
            }
            return c0900l3;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        boolean z;
        if (this.f14909b != null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "no calls to next() since the last call to remove()");
        this.f14910c.setCount(this.f14909b.f14881a.f14917a, 0);
        this.f14909b = null;
    }
}
