package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.Collections2;
import com.google.common.collect.ForwardingSet;
import com.google.common.collect.Iterators;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* renamed from: su */
/* loaded from: classes.dex */
public final class C1811su extends ForwardingSet {

    /* renamed from: a */
    public final /* synthetic */ int f26555a;

    /* renamed from: b */
    public final /* synthetic */ Set f26556b;

    public /* synthetic */ C1811su(Set set, int i) {
        this.f26555a = i;
        this.f26556b = set;
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Queue
    public boolean add(Object obj) {
        switch (this.f26555a) {
            case 1:
                throw new UnsupportedOperationException();
            default:
                return super.add(obj);
        }
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
    public boolean addAll(Collection collection) {
        switch (this.f26555a) {
            case 1:
                throw new UnsupportedOperationException();
            default:
                return super.addAll(collection);
        }
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
    public boolean contains(Object obj) {
        switch (this.f26555a) {
            case 0:
                if (obj != null && Collections2.m3836c(this.f26556b, obj)) {
                    return true;
                }
                return false;
            default:
                return super.contains(obj);
        }
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
    public boolean containsAll(Collection collection) {
        switch (this.f26555a) {
            case 0:
                return standardContainsAll(collection);
            default:
                return super.containsAll(collection);
        }
    }

    @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public final Object delegate() {
        switch (this.f26555a) {
            case 0:
                return this.f26556b;
            case 1:
                return this.f26556b;
            default:
                return this.f26556b;
        }
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        switch (this.f26555a) {
            case 2:
                return Iterators.transform(super.iterator(), new cb0(4));
            default:
                return super.iterator();
        }
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
    public boolean remove(Object obj) {
        boolean z;
        switch (this.f26555a) {
            case 0:
                if (obj == null) {
                    return false;
                }
                Set set = this.f26556b;
                Preconditions.checkNotNull(set);
                try {
                    z = set.remove(obj);
                } catch (ClassCastException | NullPointerException unused) {
                    z = false;
                }
                if (!z) {
                    return false;
                }
                return true;
            default:
                return super.remove(obj);
        }
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
    public boolean removeAll(Collection collection) {
        switch (this.f26555a) {
            case 0:
                return standardRemoveAll(collection);
            default:
                return super.removeAll(collection);
        }
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
    public Object[] toArray() {
        switch (this.f26555a) {
            case 2:
                return standardToArray();
            default:
                return super.toArray();
        }
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
    public Object[] toArray(Object[] objArr) {
        switch (this.f26555a) {
            case 2:
                return standardToArray(objArr);
            default:
                return super.toArray(objArr);
        }
    }

    @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public final Collection delegate() {
        switch (this.f26555a) {
            case 0:
                return this.f26556b;
            case 1:
                return this.f26556b;
            default:
                return this.f26556b;
        }
    }

    @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public final Set delegate() {
        switch (this.f26555a) {
            case 0:
                return this.f26556b;
            case 1:
                return this.f26556b;
            default:
                return this.f26556b;
        }
    }
}
