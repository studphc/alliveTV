package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.Iterators;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: e2 */
/* loaded from: classes.dex */
public abstract class AbstractC1143e2 implements Multimap {

    /* renamed from: a */
    public transient Collection f16652a;

    /* renamed from: b */
    public transient Set f16653b;

    /* renamed from: c */
    public transient Multiset f16654c;

    /* renamed from: d */
    public transient Collection f16655d;

    /* renamed from: e */
    public transient Map f16656e;

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public Map asMap() {
        Map map = this.f16656e;
        if (map == null) {
            Map mo3947b = mo3947b();
            this.f16656e = mo3947b;
            return mo3947b;
        }
        return map;
    }

    /* renamed from: b */
    public abstract Map mo3947b();

    @Override // com.google.common.collect.Multimap
    public boolean containsEntry(Object obj, Object obj2) {
        Collection collection = (Collection) asMap().get(obj);
        if (collection != null && collection.contains(obj2)) {
            return true;
        }
        return false;
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsValue(Object obj) {
        Iterator it = asMap().values().iterator();
        while (it.hasNext()) {
            if (((Collection) it.next()).contains(obj)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: d */
    public abstract Collection mo3948d();

    /* renamed from: e */
    public abstract Set mo3949e();

    @Override // com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public Collection entries() {
        Collection collection = this.f16652a;
        if (collection == null) {
            Collection mo3948d = mo3948d();
            this.f16652a = mo3948d;
            return mo3948d;
        }
        return collection;
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Multimap) {
            return asMap().equals(((Multimap) obj).asMap());
        }
        return false;
    }

    /* renamed from: f */
    public abstract Multiset mo3950f();

    /* renamed from: g */
    public abstract Collection mo3951g();

    /* renamed from: h */
    public abstract Iterator mo3952h();

    @Override // com.google.common.collect.Multimap
    public int hashCode() {
        return asMap().hashCode();
    }

    @Override // com.google.common.collect.Multimap
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    @Override // com.google.common.collect.Multimap
    public Set keySet() {
        Set set = this.f16653b;
        if (set == null) {
            Set mo3949e = mo3949e();
            this.f16653b = mo3949e;
            return mo3949e;
        }
        return set;
    }

    @Override // com.google.common.collect.Multimap
    public Multiset keys() {
        Multiset multiset = this.f16654c;
        if (multiset == null) {
            Multiset mo3950f = mo3950f();
            this.f16654c = mo3950f;
            return mo3950f;
        }
        return multiset;
    }

    @Override // com.google.common.collect.Multimap
    public boolean put(Object obj, Object obj2) {
        return get(obj).add(obj2);
    }

    @Override // com.google.common.collect.Multimap
    public boolean putAll(Object obj, Iterable iterable) {
        Preconditions.checkNotNull(iterable);
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            return !collection.isEmpty() && get(obj).addAll(collection);
        }
        Iterator it = iterable.iterator();
        return it.hasNext() && Iterators.addAll(get(obj), it);
    }

    @Override // com.google.common.collect.Multimap
    public boolean remove(Object obj, Object obj2) {
        Collection collection = (Collection) asMap().get(obj);
        if (collection != null && collection.remove(obj2)) {
            return true;
        }
        return false;
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public Collection replaceValues(Object obj, Iterable iterable) {
        Preconditions.checkNotNull(iterable);
        Collection removeAll = removeAll(obj);
        putAll(obj, iterable);
        return removeAll;
    }

    public String toString() {
        return asMap().toString();
    }

    @Override // com.google.common.collect.Multimap
    public Collection values() {
        Collection collection = this.f16655d;
        if (collection == null) {
            Collection mo3951g = mo3951g();
            this.f16655d = mo3951g;
            return mo3951g;
        }
        return collection;
    }

    @Override // com.google.common.collect.Multimap
    public boolean putAll(Multimap multimap) {
        boolean z = false;
        for (Map.Entry entry : multimap.entries()) {
            z |= put(entry.getKey(), entry.getValue());
        }
        return z;
    }
}
