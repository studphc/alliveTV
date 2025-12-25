package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterators;
import com.google.common.collect.ObjectArrays;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class dr2 extends sr2 {
    private static final long serialVersionUID = 0;

    @Override // p000.gr2, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        boolean contains;
        synchronized (this.f25273b) {
            Set mo4086e = mo4086e();
            if (!(obj instanceof Map.Entry)) {
                contains = false;
            } else {
                Map.Entry entry = (Map.Entry) obj;
                Preconditions.checkNotNull(entry);
                contains = mo4086e.contains(new x21(entry, 1));
            }
        }
        return contains;
    }

    @Override // p000.gr2, java.util.Collection, java.util.Set
    public final boolean containsAll(Collection collection) {
        boolean m3835b;
        synchronized (this.f25273b) {
            m3835b = Collections2.m3835b(mo4086e(), collection);
        }
        return m3835b;
    }

    @Override // p000.sr2, java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        boolean m4069a;
        if (obj == this) {
            return true;
        }
        synchronized (this.f25273b) {
            m4069a = Sets.m4069a(mo4086e(), obj);
        }
        return m4069a;
    }

    @Override // p000.gr2, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new rg1(this, super.iterator(), 1);
    }

    @Override // p000.gr2, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        boolean remove;
        synchronized (this.f25273b) {
            Set mo4086e = mo4086e();
            if (!(obj instanceof Map.Entry)) {
                remove = false;
            } else {
                Map.Entry entry = (Map.Entry) obj;
                Preconditions.checkNotNull(entry);
                remove = mo4086e.remove(new x21(entry, 1));
            }
        }
        return remove;
    }

    @Override // p000.gr2, java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        boolean removeAll;
        synchronized (this.f25273b) {
            removeAll = Iterators.removeAll(mo4086e().iterator(), collection);
        }
        return removeAll;
    }

    @Override // p000.gr2, java.util.Collection, java.util.Set
    public final boolean retainAll(Collection collection) {
        boolean retainAll;
        synchronized (this.f25273b) {
            retainAll = Iterators.retainAll(mo4086e().iterator(), collection);
        }
        return retainAll;
    }

    @Override // p000.gr2, java.util.Collection, java.util.Set
    public final Object[] toArray() {
        Object[] objArr;
        synchronized (this.f25273b) {
            Set mo4086e = mo4086e();
            objArr = new Object[mo4086e.size()];
            ObjectArrays.m4066b(mo4086e, objArr);
        }
        return objArr;
    }

    @Override // p000.gr2, java.util.Collection, java.util.Set
    public final Object[] toArray(Object[] objArr) {
        Object[] m4067c;
        synchronized (this.f25273b) {
            m4067c = ObjectArrays.m4067c(mo4086e(), objArr);
        }
        return m4067c;
    }
}
