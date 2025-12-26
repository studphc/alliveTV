package p000;

import com.google.common.base.Preconditions;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

/* renamed from: q1 */
/* loaded from: classes.dex */
public class C1708q1 extends AbstractCollection {

    /* renamed from: a */
    public final Object f25400a;

    /* renamed from: b */
    public Collection f25401b;

    /* renamed from: c */
    public final C1708q1 f25402c;

    /* renamed from: d */
    public final Collection f25403d;

    /* renamed from: e */
    public final /* synthetic */ AbstractC1930w1 f25404e;

    public C1708q1(AbstractC1930w1 abstractC1930w1, Object obj, Collection collection, C1708q1 c1708q1) {
        Collection collection2;
        this.f25404e = abstractC1930w1;
        this.f25400a = obj;
        this.f25401b = collection;
        this.f25402c = c1708q1;
        if (c1708q1 == null) {
            collection2 = null;
        } else {
            collection2 = c1708q1.f25401b;
        }
        this.f25403d = collection2;
    }

    /* renamed from: a */
    public final void m6947a() {
        C1708q1 c1708q1 = this.f25402c;
        if (c1708q1 != null) {
            c1708q1.m6947a();
        } else {
            this.f25404e.f28031f.put(this.f25400a, this.f25401b);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean add(Object obj) {
        m6948b();
        boolean isEmpty = this.f25401b.isEmpty();
        boolean add = this.f25401b.add(obj);
        if (add) {
            this.f25404e.f28032g++;
            if (isEmpty) {
                m6947a();
            }
        }
        return add;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean addAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean addAll = this.f25401b.addAll(collection);
        if (addAll) {
            this.f25404e.f28032g += this.f25401b.size() - size;
            if (size == 0) {
                m6947a();
            }
        }
        return addAll;
    }

    /* renamed from: b */
    public final void m6948b() {
        Collection collection;
        C1708q1 c1708q1 = this.f25402c;
        if (c1708q1 != null) {
            c1708q1.m6948b();
            if (c1708q1.f25401b != this.f25403d) {
                throw new ConcurrentModificationException();
            }
        } else if (this.f25401b.isEmpty() && (collection = (Collection) this.f25404e.f28031f.get(this.f25400a)) != null) {
            this.f25401b = collection;
        }
    }

    /* renamed from: c */
    public final void m6949c() {
        C1708q1 c1708q1 = this.f25402c;
        if (c1708q1 != null) {
            c1708q1.m6949c();
        } else if (this.f25401b.isEmpty()) {
            this.f25404e.f28031f.remove(this.f25400a);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        int size = size();
        if (size == 0) {
            return;
        }
        this.f25401b.clear();
        this.f25404e.f28032g -= size;
        m6949c();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        m6948b();
        return this.f25401b.contains(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean containsAll(Collection collection) {
        m6948b();
        return this.f25401b.containsAll(collection);
    }

    @Override // java.util.Collection
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        m6948b();
        return this.f25401b.equals(obj);
    }

    @Override // java.util.Collection
    public final int hashCode() {
        m6948b();
        return this.f25401b.hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        m6948b();
        return new C1493l(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean remove(Object obj) {
        m6948b();
        boolean remove = this.f25401b.remove(obj);
        if (remove) {
            AbstractC1930w1 abstractC1930w1 = this.f25404e;
            abstractC1930w1.f28032g--;
            m6949c();
        }
        return remove;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean removeAll = this.f25401b.removeAll(collection);
        if (removeAll) {
            this.f25404e.f28032g += this.f25401b.size() - size;
            m6949c();
        }
        return removeAll;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean retainAll(Collection collection) {
        Preconditions.checkNotNull(collection);
        int size = size();
        boolean retainAll = this.f25401b.retainAll(collection);
        if (retainAll) {
            this.f25404e.f28032g += this.f25401b.size() - size;
            m6949c();
        }
        return retainAll;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        m6948b();
        return this.f25401b.size();
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        m6948b();
        return this.f25401b.toString();
    }
}
