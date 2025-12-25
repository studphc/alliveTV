package p000;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes.dex */
public class jr2 extends gr2 implements List {
    private static final long serialVersionUID = 0;

    @Override // java.util.List
    public final void add(int i, Object obj) {
        synchronized (this.f25273b) {
            mo4086e().add(i, obj);
        }
    }

    @Override // java.util.List
    public final boolean addAll(int i, Collection collection) {
        boolean addAll;
        synchronized (this.f25273b) {
            addAll = mo4086e().addAll(i, collection);
        }
        return addAll;
    }

    @Override // java.util.Collection, java.util.List
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
    public final List mo4086e() {
        return (List) ((Collection) this.f25272a);
    }

    @Override // java.util.List
    public final Object get(int i) {
        Object obj;
        synchronized (this.f25273b) {
            obj = mo4086e().get(i);
        }
        return obj;
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        int hashCode;
        synchronized (this.f25273b) {
            hashCode = mo4086e().hashCode();
        }
        return hashCode;
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        int indexOf;
        synchronized (this.f25273b) {
            indexOf = mo4086e().indexOf(obj);
        }
        return indexOf;
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        int lastIndexOf;
        synchronized (this.f25273b) {
            lastIndexOf = mo4086e().lastIndexOf(obj);
        }
        return lastIndexOf;
    }

    @Override // java.util.List
    public final ListIterator listIterator() {
        return mo4086e().listIterator();
    }

    @Override // java.util.List
    public final Object remove(int i) {
        Object remove;
        synchronized (this.f25273b) {
            remove = mo4086e().remove(i);
        }
        return remove;
    }

    @Override // java.util.List
    public final Object set(int i, Object obj) {
        Object obj2;
        synchronized (this.f25273b) {
            obj2 = mo4086e().set(i, obj);
        }
        return obj2;
    }

    @Override // java.util.List
    public final List subList(int i, int i2) {
        jr2 m8333C;
        synchronized (this.f25273b) {
            m8333C = yy2.m8333C(mo4086e().subList(i, i2), this.f25273b);
        }
        return m8333C;
    }

    @Override // java.util.List
    public final ListIterator listIterator(int i) {
        return mo4086e().listIterator(i);
    }
}
