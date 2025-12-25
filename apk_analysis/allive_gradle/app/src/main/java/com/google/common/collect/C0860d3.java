package com.google.common.collect;

import java.util.Collection;
import java.util.Set;
import p000.gr2;
import p000.sr2;
import p000.yy2;

/* renamed from: com.google.common.collect.d3 */
/* loaded from: classes.dex */
public final class C0860d3 extends gr2 implements Multiset {
    private static final long serialVersionUID = 0;

    /* renamed from: c */
    public transient sr2 f14805c;

    /* renamed from: d */
    public transient sr2 f14806d;

    @Override // com.google.common.collect.Multiset
    public final int add(Object obj, int i) {
        int add;
        synchronized (this.f25273b) {
            add = mo4086e().add(obj, i);
        }
        return add;
    }

    @Override // com.google.common.collect.Multiset
    public final int count(Object obj) {
        int count;
        synchronized (this.f25273b) {
            count = mo4086e().count(obj);
        }
        return count;
    }

    @Override // com.google.common.collect.Multiset
    public final Set elementSet() {
        sr2 sr2Var;
        synchronized (this.f25273b) {
            try {
                if (this.f14805c == null) {
                    this.f14805c = yy2.m8354c(mo4086e().elementSet(), this.f25273b);
                }
                sr2Var = this.f14805c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return sr2Var;
    }

    @Override // com.google.common.collect.Multiset
    public final Set entrySet() {
        sr2 sr2Var;
        synchronized (this.f25273b) {
            try {
                if (this.f14806d == null) {
                    this.f14806d = yy2.m8354c(mo4086e().entrySet(), this.f25273b);
                }
                sr2Var = this.f14806d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return sr2Var;
    }

    @Override // java.util.Collection, com.google.common.collect.Multiset
    public final boolean equals(Object obj) {
        boolean equals;
        if (obj == this) {
            return true;
        }
        synchronized (this.f25273b) {
            equals = mo4086e().equals(obj);
        }
        return equals;
    }

    @Override // p000.gr2
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final Multiset mo4086e() {
        return (Multiset) ((Collection) this.f25272a);
    }

    @Override // java.util.Collection, com.google.common.collect.Multiset
    public final int hashCode() {
        int hashCode;
        synchronized (this.f25273b) {
            hashCode = mo4086e().hashCode();
        }
        return hashCode;
    }

    @Override // com.google.common.collect.Multiset
    public final int remove(Object obj, int i) {
        int remove;
        synchronized (this.f25273b) {
            remove = mo4086e().remove(obj, i);
        }
        return remove;
    }

    @Override // com.google.common.collect.Multiset
    public final int setCount(Object obj, int i) {
        int count;
        synchronized (this.f25273b) {
            count = mo4086e().setCount(obj, i);
        }
        return count;
    }

    @Override // com.google.common.collect.Multiset
    public final boolean setCount(Object obj, int i, int i2) {
        boolean count;
        synchronized (this.f25273b) {
            count = mo4086e().setCount(obj, i, i2);
        }
        return count;
    }
}
