package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.C0893k1;
import com.google.common.collect.Multiset;
import com.google.common.collect.SetMultimap;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;

/* renamed from: w1 */
/* loaded from: classes.dex */
public abstract class AbstractC1930w1 extends AbstractC1143e2 implements Serializable {
    private static final long serialVersionUID = 2447537837011683357L;

    /* renamed from: f */
    public transient Map f28031f;

    /* renamed from: g */
    public transient int f28032g;

    public AbstractC1930w1(Map map) {
        Preconditions.checkArgument(map.isEmpty());
        this.f28031f = map;
    }

    @Override // p000.AbstractC1143e2
    /* renamed from: b */
    public Map mo3947b() {
        return new C1338j1(this, this.f28031f);
    }

    @Override // com.google.common.collect.Multimap
    public void clear() {
        Iterator it = this.f28031f.values().iterator();
        while (it.hasNext()) {
            ((Collection) it.next()).clear();
        }
        this.f28031f.clear();
        this.f28032g = 0;
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsKey(Object obj) {
        return this.f28031f.containsKey(obj);
    }

    @Override // p000.AbstractC1143e2
    /* renamed from: d */
    public final Collection mo3948d() {
        if (this instanceof SetMultimap) {
            return new C0578c2(0, this);
        }
        return new C0578c2(0, this);
    }

    @Override // p000.AbstractC1143e2
    /* renamed from: e */
    public Set mo3949e() {
        return new C1375k1(this, this.f28031f, 0);
    }

    @Override // p000.AbstractC1143e2
    /* renamed from: f */
    public final Multiset mo3950f() {
        return new C0893k1(this);
    }

    @Override // p000.AbstractC1143e2
    /* renamed from: g */
    public final Collection mo3951g() {
        return new C0578c2(1, this);
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public Collection get(Object obj) {
        Collection collection = (Collection) this.f28031f.get(obj);
        if (collection == null) {
            collection = mo4036j(obj);
        }
        return mo5q(collection, obj);
    }

    @Override // p000.AbstractC1143e2
    /* renamed from: h */
    public Iterator mo3952h() {
        return new C1253h1(this, 1);
    }

    /* renamed from: i */
    public abstract Collection mo2006i();

    /* renamed from: j */
    public Collection mo4036j(Object obj) {
        return mo2006i();
    }

    /* renamed from: k */
    public final C1338j1 m7961k() {
        Map map = this.f28031f;
        if (map instanceof NavigableMap) {
            return new C1495l1(this, (NavigableMap) this.f28031f);
        }
        if (map instanceof SortedMap) {
            return new C1606o1(this, (SortedMap) this.f28031f);
        }
        return new C1338j1(this, this.f28031f);
    }

    /* renamed from: l */
    public final C1375k1 m7962l() {
        Map map = this.f28031f;
        if (map instanceof NavigableMap) {
            return new C1532m1(this, (NavigableMap) this.f28031f);
        }
        if (map instanceof SortedMap) {
            return new C1671p1(this, (SortedMap) this.f28031f);
        }
        return new C1375k1(this, this.f28031f, 0);
    }

    /* renamed from: m */
    public Collection mo3m() {
        return mo4o(mo2006i());
    }

    /* renamed from: n */
    public final void m7963n(Map map) {
        this.f28031f = map;
        this.f28032g = 0;
        for (Collection collection : map.values()) {
            Preconditions.checkArgument(!collection.isEmpty());
            this.f28032g = collection.size() + this.f28032g;
        }
    }

    /* renamed from: o */
    public abstract Collection mo4o(Collection collection);

    /* renamed from: p */
    public Iterator mo4037p() {
        return new C1253h1(this, 0);
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap
    public boolean put(Object obj, Object obj2) {
        Collection collection = (Collection) this.f28031f.get(obj);
        if (collection == null) {
            Collection mo4036j = mo4036j(obj);
            if (mo4036j.add(obj2)) {
                this.f28032g++;
                this.f28031f.put(obj, mo4036j);
                return true;
            }
            throw new AssertionError("New Collection violated the Collection spec");
        }
        if (collection.add(obj2)) {
            this.f28032g++;
            return true;
        }
        return false;
    }

    /* renamed from: q */
    public abstract Collection mo5q(Collection collection, Object obj);

    /* renamed from: r */
    public final C1782s1 m7964r(Object obj, List list, C1708q1 c1708q1) {
        if (list instanceof RandomAccess) {
            return new C1782s1(this, obj, list, c1708q1);
        }
        return new C1782s1(this, obj, list, c1708q1);
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public Collection removeAll(Object obj) {
        Collection collection = (Collection) this.f28031f.remove(obj);
        if (collection == null) {
            return mo3m();
        }
        Collection mo2006i = mo2006i();
        mo2006i.addAll(collection);
        this.f28032g -= collection.size();
        collection.clear();
        return mo4o(mo2006i);
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public Collection replaceValues(Object obj, Iterable iterable) {
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return removeAll(obj);
        }
        Collection collection = (Collection) this.f28031f.get(obj);
        if (collection == null) {
            collection = mo4036j(obj);
            this.f28031f.put(obj, collection);
        }
        Collection mo2006i = mo2006i();
        mo2006i.addAll(collection);
        this.f28032g -= collection.size();
        collection.clear();
        while (it.hasNext()) {
            if (collection.add(it.next())) {
                this.f28032g++;
            }
        }
        return mo4o(mo2006i);
    }

    @Override // com.google.common.collect.Multimap
    public int size() {
        return this.f28032g;
    }
}
