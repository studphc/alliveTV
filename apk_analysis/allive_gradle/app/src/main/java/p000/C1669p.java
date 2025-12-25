package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingSet;
import com.google.common.collect.MutableClassToInstanceMap;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: p */
/* loaded from: classes.dex */
public final class C1669p extends ForwardingSet {

    /* renamed from: a */
    public final /* synthetic */ int f24968a;

    /* renamed from: b */
    public final Object f24969b;

    public /* synthetic */ C1669p(Map map, int i) {
        this.f24968a = i;
        this.f24969b = map;
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Queue
    public boolean add(Object obj) {
        switch (this.f24968a) {
            case 1:
                String valueOf = String.valueOf(this.f24969b);
                throw new IllegalArgumentException(AbstractC1726qj.m7054j(valueOf.length() + 32, "Key does not satisfy predicate: ", valueOf));
            default:
                return super.add(obj);
        }
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
    public boolean addAll(Collection collection) {
        switch (this.f24968a) {
            case 1:
                Preconditions.checkNotNull(collection);
                String valueOf = String.valueOf(this.f24969b);
                throw new IllegalArgumentException(AbstractC1726qj.m7054j(valueOf.length() + 32, "Key does not satisfy predicate: ", valueOf));
            default:
                return super.addAll(collection);
        }
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
    public void clear() {
        switch (this.f24968a) {
            case 0:
                ((AbstractC1706q) this.f24969b).clear();
                return;
            default:
                super.clear();
                return;
        }
    }

    @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public final Object delegate() {
        switch (this.f24968a) {
            case 0:
                return delegate();
            case 1:
                return Collections.emptySet();
            case 2:
                return (Set) ((sg1) this.f24969b).f26418g;
            default:
                return delegate();
        }
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        switch (this.f24968a) {
            case 0:
                return new fg1(((AbstractC1706q) this.f24969b).entrySet().iterator(), 0);
            case 1:
            default:
                return super.iterator();
            case 2:
                return new rg1(this, ((Set) ((sg1) this.f24969b).f26418g).iterator(), 0);
            case 3:
                return new fg1(delegate().iterator(), 2);
        }
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
    public boolean remove(Object obj) {
        switch (this.f24968a) {
            case 0:
                if (!contains(obj)) {
                    return false;
                }
                AbstractC1706q abstractC1706q = (AbstractC1706q) this.f24969b;
                abstractC1706q.f25353b.f25352a.remove(abstractC1706q.f25352a.remove(obj));
                return true;
            default:
                return super.remove(obj);
        }
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
    public boolean removeAll(Collection collection) {
        switch (this.f24968a) {
            case 0:
                return standardRemoveAll(collection);
            default:
                return super.removeAll(collection);
        }
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
    public boolean retainAll(Collection collection) {
        switch (this.f24968a) {
            case 0:
                return standardRetainAll(collection);
            default:
                return super.retainAll(collection);
        }
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
    public Object[] toArray() {
        switch (this.f24968a) {
            case 3:
                return standardToArray();
            default:
                return super.toArray();
        }
    }

    public C1669p(Object obj) {
        this.f24968a = 1;
        this.f24969b = obj;
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
    public Object[] toArray(Object[] objArr) {
        switch (this.f24968a) {
            case 3:
                return standardToArray(objArr);
            default:
                return super.toArray(objArr);
        }
    }

    @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public final Collection delegate() {
        switch (this.f24968a) {
            case 0:
                return delegate();
            case 1:
                return Collections.emptySet();
            case 2:
                return (Set) ((sg1) this.f24969b).f26418g;
            default:
                return delegate();
        }
    }

    @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public final Set delegate() {
        switch (this.f24968a) {
            case 0:
                return ((AbstractC1706q) this.f24969b).f25352a.keySet();
            case 1:
                return Collections.emptySet();
            case 2:
                return (Set) ((sg1) this.f24969b).f26418g;
            default:
                return ((MutableClassToInstanceMap) this.f24969b).delegate().entrySet();
        }
    }
}
