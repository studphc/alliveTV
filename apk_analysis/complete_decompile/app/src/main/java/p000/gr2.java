package p000;

import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes.dex */
public class gr2 extends pr2 implements Collection {
    private static final long serialVersionUID = 0;

    @Override // java.util.Collection
    public final boolean add(Object obj) {
        boolean add;
        synchronized (this.f25273b) {
            add = mo4086e().add(obj);
        }
        return add;
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection collection) {
        boolean addAll;
        synchronized (this.f25273b) {
            addAll = mo4086e().addAll(collection);
        }
        return addAll;
    }

    @Override // java.util.Collection
    public final void clear() {
        synchronized (this.f25273b) {
            mo4086e().clear();
        }
    }

    public boolean contains(Object obj) {
        boolean contains;
        synchronized (this.f25273b) {
            contains = mo4086e().contains(obj);
        }
        return contains;
    }

    public boolean containsAll(Collection collection) {
        boolean containsAll;
        synchronized (this.f25273b) {
            containsAll = mo4086e().containsAll(collection);
        }
        return containsAll;
    }

    /* renamed from: e */
    public Collection mo4086e() {
        return (Collection) this.f25272a;
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.f25273b) {
            isEmpty = mo4086e().isEmpty();
        }
        return isEmpty;
    }

    public Iterator iterator() {
        return mo4086e().iterator();
    }

    public boolean remove(Object obj) {
        boolean remove;
        synchronized (this.f25273b) {
            remove = mo4086e().remove(obj);
        }
        return remove;
    }

    public boolean removeAll(Collection collection) {
        boolean removeAll;
        synchronized (this.f25273b) {
            removeAll = mo4086e().removeAll(collection);
        }
        return removeAll;
    }

    public boolean retainAll(Collection collection) {
        boolean retainAll;
        synchronized (this.f25273b) {
            retainAll = mo4086e().retainAll(collection);
        }
        return retainAll;
    }

    @Override // java.util.Collection
    public final int size() {
        int size;
        synchronized (this.f25273b) {
            size = mo4086e().size();
        }
        return size;
    }

    public Object[] toArray() {
        Object[] array;
        synchronized (this.f25273b) {
            array = mo4086e().toArray();
        }
        return array;
    }

    public Object[] toArray(Object[] objArr) {
        Object[] array;
        synchronized (this.f25273b) {
            array = mo4086e().toArray(objArr);
        }
        return array;
    }
}
