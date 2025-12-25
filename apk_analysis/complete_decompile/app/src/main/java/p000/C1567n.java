package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: n */
/* loaded from: classes.dex */
public final class C1567n extends ForwardingSet {

    /* renamed from: a */
    public final /* synthetic */ int f23182a;

    /* renamed from: b */
    public final Set f23183b;

    /* renamed from: c */
    public final /* synthetic */ AbstractC1706q f23184c;

    public C1567n(AbstractC1706q abstractC1706q, int i) {
        this.f23182a = i;
        switch (i) {
            case 1:
                this.f23184c = abstractC1706q;
                this.f23183b = abstractC1706q.f25353b.keySet();
                return;
            default:
                this.f23184c = abstractC1706q;
                this.f23183b = abstractC1706q.f25352a.entrySet();
                return;
        }
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
    public void clear() {
        switch (this.f23182a) {
            case 0:
                this.f23184c.clear();
                return;
            default:
                super.clear();
                return;
        }
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
    public boolean contains(Object obj) {
        switch (this.f23182a) {
            case 0:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                Preconditions.checkNotNull(entry);
                return this.f23183b.contains(new x21(entry, 1));
            default:
                return super.contains(obj);
        }
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
    public boolean containsAll(Collection collection) {
        switch (this.f23182a) {
            case 0:
                return standardContainsAll(collection);
            default:
                return super.containsAll(collection);
        }
    }

    @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public final Object delegate() {
        switch (this.f23182a) {
            case 0:
                return this.f23183b;
            default:
                return this.f23183b;
        }
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        switch (this.f23182a) {
            case 0:
                AbstractC1706q abstractC1706q = this.f23184c;
                return new C1493l(abstractC1706q, abstractC1706q.f25352a.entrySet().iterator(), 0);
            default:
                return new fg1(this.f23184c.entrySet().iterator(), 1);
        }
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
    public boolean remove(Object obj) {
        switch (this.f23182a) {
            case 0:
                Set set = this.f23183b;
                if (set.contains(obj) && (obj instanceof Map.Entry)) {
                    Map.Entry entry = (Map.Entry) obj;
                    this.f23184c.f25353b.f25352a.remove(entry.getValue());
                    set.remove(entry);
                    return true;
                }
                return false;
            default:
                return super.remove(obj);
        }
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
    public boolean removeAll(Collection collection) {
        switch (this.f23182a) {
            case 0:
                return standardRemoveAll(collection);
            default:
                return super.removeAll(collection);
        }
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
    public boolean retainAll(Collection collection) {
        switch (this.f23182a) {
            case 0:
                return standardRetainAll(collection);
            default:
                return super.retainAll(collection);
        }
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
    public final Object[] toArray() {
        switch (this.f23182a) {
            case 0:
                return standardToArray();
            default:
                return standardToArray();
        }
    }

    @Override // com.google.common.collect.ForwardingObject, com.google.common.collect.Multiset
    public String toString() {
        switch (this.f23182a) {
            case 1:
                return standardToString();
            default:
                return super.toString();
        }
    }

    @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public final Collection delegate() {
        switch (this.f23182a) {
            case 0:
                return this.f23183b;
            default:
                return this.f23183b;
        }
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        switch (this.f23182a) {
            case 0:
                return standardToArray(objArr);
            default:
                return standardToArray(objArr);
        }
    }

    @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public final Set delegate() {
        switch (this.f23182a) {
            case 0:
                return this.f23183b;
            default:
                return this.f23183b;
        }
    }
}
