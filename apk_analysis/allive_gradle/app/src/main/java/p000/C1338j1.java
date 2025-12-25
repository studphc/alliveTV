package p000;

import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* renamed from: j1 */
/* loaded from: classes.dex */
public class C1338j1 extends ih1 {

    /* renamed from: d */
    public final transient Map f20336d;

    /* renamed from: e */
    public final /* synthetic */ AbstractC1930w1 f20337e;

    public C1338j1(AbstractC1930w1 abstractC1930w1, Map map) {
        this.f20337e = abstractC1930w1;
        this.f20336d = map;
    }

    @Override // p000.ih1
    /* renamed from: a */
    public final Set mo4593a() {
        return new C1290i1(this, 0);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        AbstractC1930w1 abstractC1930w1 = this.f20337e;
        if (this.f20336d == abstractC1930w1.f28031f) {
            abstractC1930w1.clear();
        } else {
            Iterators.m4034b(new C1493l(this));
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        return Maps.m4051g(this.f20336d, obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (this != obj && !this.f20336d.equals(obj)) {
            return false;
        }
        return true;
    }

    /* renamed from: f */
    public final Map.Entry m5383f(Map.Entry entry) {
        Object key = entry.getKey();
        return Maps.immutableEntry(key, this.f20337e.mo5q((Collection) entry.getValue(), key));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Collection collection = (Collection) Maps.m4052h(this.f20336d, obj);
        if (collection == null) {
            return null;
        }
        return this.f20337e.mo5q(collection, obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        return this.f20336d.hashCode();
    }

    @Override // p000.ih1, java.util.AbstractMap, java.util.Map, java.util.SortedMap
    public Set keySet() {
        return this.f20337e.keySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        Collection collection = (Collection) this.f20336d.remove(obj);
        if (collection == null) {
            return null;
        }
        AbstractC1930w1 abstractC1930w1 = this.f20337e;
        Collection mo2006i = abstractC1930w1.mo2006i();
        mo2006i.addAll(collection);
        abstractC1930w1.f28032g -= collection.size();
        collection.clear();
        return mo2006i;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f20336d.size();
    }

    @Override // java.util.AbstractMap
    public final String toString() {
        return this.f20336d.toString();
    }
}
