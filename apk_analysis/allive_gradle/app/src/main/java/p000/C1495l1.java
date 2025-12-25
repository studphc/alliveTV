package p000;

import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

/* renamed from: l1 */
/* loaded from: classes.dex */
public final class C1495l1 extends C1606o1 implements NavigableMap {

    /* renamed from: h */
    public final /* synthetic */ AbstractC1930w1 f22276h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1495l1(AbstractC1930w1 abstractC1930w1, NavigableMap navigableMap) {
        super(abstractC1930w1, navigableMap);
        this.f22276h = abstractC1930w1;
    }

    @Override // p000.C1606o1, p000.ih1
    /* renamed from: c */
    public final Set mo5238c() {
        return new C1532m1(this.f22276h, mo5813i());
    }

    @Override // java.util.NavigableMap
    public final Map.Entry ceilingEntry(Object obj) {
        Map.Entry ceilingEntry = mo5813i().ceilingEntry(obj);
        if (ceilingEntry == null) {
            return null;
        }
        return m5383f(ceilingEntry);
    }

    @Override // java.util.NavigableMap
    public final Object ceilingKey(Object obj) {
        return mo5813i().ceilingKey(obj);
    }

    @Override // java.util.NavigableMap
    public final NavigableSet descendingKeySet() {
        return (NavigableSet) super.keySet();
    }

    @Override // java.util.NavigableMap
    public final NavigableMap descendingMap() {
        return new C1495l1(this.f22276h, mo5813i().descendingMap());
    }

    @Override // java.util.NavigableMap
    public final Map.Entry firstEntry() {
        Map.Entry firstEntry = mo5813i().firstEntry();
        if (firstEntry == null) {
            return null;
        }
        return m5383f(firstEntry);
    }

    @Override // java.util.NavigableMap
    public final Map.Entry floorEntry(Object obj) {
        Map.Entry floorEntry = mo5813i().floorEntry(obj);
        if (floorEntry == null) {
            return null;
        }
        return m5383f(floorEntry);
    }

    @Override // java.util.NavigableMap
    public final Object floorKey(Object obj) {
        return mo5813i().floorKey(obj);
    }

    @Override // p000.C1606o1
    /* renamed from: g */
    public final SortedSet mo5238c() {
        return new C1532m1(this.f22276h, mo5813i());
    }

    @Override // p000.C1606o1
    /* renamed from: h */
    public final SortedSet keySet() {
        return (NavigableSet) super.keySet();
    }

    @Override // p000.C1606o1, java.util.SortedMap, java.util.NavigableMap
    public final SortedMap headMap(Object obj) {
        return headMap(obj, false);
    }

    @Override // java.util.NavigableMap
    public final Map.Entry higherEntry(Object obj) {
        Map.Entry higherEntry = mo5813i().higherEntry(obj);
        if (higherEntry == null) {
            return null;
        }
        return m5383f(higherEntry);
    }

    @Override // java.util.NavigableMap
    public final Object higherKey(Object obj) {
        return mo5813i().higherKey(obj);
    }

    /* renamed from: j */
    public final Map.Entry m5814j(Iterator it) {
        if (!it.hasNext()) {
            return null;
        }
        Map.Entry entry = (Map.Entry) it.next();
        AbstractC1930w1 abstractC1930w1 = this.f22276h;
        Collection mo2006i = abstractC1930w1.mo2006i();
        mo2006i.addAll((Collection) entry.getValue());
        it.remove();
        return Maps.immutableEntry(entry.getKey(), abstractC1930w1.mo4o(mo2006i));
    }

    @Override // p000.C1606o1
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public final NavigableMap mo5813i() {
        return (NavigableMap) ((SortedMap) this.f20336d);
    }

    @Override // p000.C1606o1, p000.C1338j1, p000.ih1, java.util.AbstractMap, java.util.Map, java.util.SortedMap
    public final Set keySet() {
        return (NavigableSet) super.keySet();
    }

    @Override // java.util.NavigableMap
    public final Map.Entry lastEntry() {
        Map.Entry lastEntry = mo5813i().lastEntry();
        if (lastEntry == null) {
            return null;
        }
        return m5383f(lastEntry);
    }

    @Override // java.util.NavigableMap
    public final Map.Entry lowerEntry(Object obj) {
        Map.Entry lowerEntry = mo5813i().lowerEntry(obj);
        if (lowerEntry == null) {
            return null;
        }
        return m5383f(lowerEntry);
    }

    @Override // java.util.NavigableMap
    public final Object lowerKey(Object obj) {
        return mo5813i().lowerKey(obj);
    }

    @Override // java.util.NavigableMap
    public final NavigableSet navigableKeySet() {
        return (NavigableSet) super.keySet();
    }

    @Override // java.util.NavigableMap
    public final Map.Entry pollFirstEntry() {
        return m5814j(entrySet().iterator());
    }

    @Override // java.util.NavigableMap
    public final Map.Entry pollLastEntry() {
        return m5814j(((ih1) descendingMap()).entrySet().iterator());
    }

    @Override // p000.C1606o1, java.util.SortedMap, java.util.NavigableMap
    public final SortedMap subMap(Object obj, Object obj2) {
        return subMap(obj, true, obj2, false);
    }

    @Override // p000.C1606o1, java.util.SortedMap, java.util.NavigableMap
    public final SortedMap tailMap(Object obj) {
        return tailMap(obj, true);
    }

    @Override // java.util.NavigableMap
    public final NavigableMap headMap(Object obj, boolean z) {
        return new C1495l1(this.f22276h, mo5813i().headMap(obj, z));
    }

    @Override // java.util.NavigableMap
    public final NavigableMap subMap(Object obj, boolean z, Object obj2, boolean z2) {
        return new C1495l1(this.f22276h, mo5813i().subMap(obj, z, obj2, z2));
    }

    @Override // java.util.NavigableMap
    public final NavigableMap tailMap(Object obj, boolean z) {
        return new C1495l1(this.f22276h, mo5813i().tailMap(obj, z));
    }
}
