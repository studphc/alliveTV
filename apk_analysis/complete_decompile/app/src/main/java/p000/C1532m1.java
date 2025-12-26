package p000;

import com.google.common.collect.Iterators;
import java.util.Iterator;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.SortedMap;
import java.util.SortedSet;

/* renamed from: m1 */
/* loaded from: classes.dex */
public final class C1532m1 extends C1671p1 implements NavigableSet {

    /* renamed from: e */
    public final /* synthetic */ AbstractC1930w1 f22753e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1532m1(AbstractC1930w1 abstractC1930w1, NavigableMap navigableMap) {
        super(abstractC1930w1, navigableMap);
        this.f22753e = abstractC1930w1;
    }

    @Override // java.util.NavigableSet
    public final Object ceiling(Object obj) {
        return mo6002e().ceilingKey(obj);
    }

    @Override // java.util.NavigableSet
    public final Iterator descendingIterator() {
        return ((C1375k1) descendingSet()).iterator();
    }

    @Override // java.util.NavigableSet
    public final NavigableSet descendingSet() {
        return new C1532m1(this.f22753e, mo6002e().descendingMap());
    }

    @Override // p000.C1671p1
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final NavigableMap mo6002e() {
        return (NavigableMap) ((SortedMap) this.f29371a);
    }

    @Override // java.util.NavigableSet
    public final Object floor(Object obj) {
        return mo6002e().floorKey(obj);
    }

    @Override // p000.C1671p1, java.util.SortedSet, java.util.NavigableSet
    public final SortedSet headSet(Object obj) {
        return headSet(obj, false);
    }

    @Override // java.util.NavigableSet
    public final Object higher(Object obj) {
        return mo6002e().higherKey(obj);
    }

    @Override // java.util.NavigableSet
    public final Object lower(Object obj) {
        return mo6002e().lowerKey(obj);
    }

    @Override // java.util.NavigableSet
    public final Object pollFirst() {
        return Iterators.m4035c(iterator());
    }

    @Override // java.util.NavigableSet
    public final Object pollLast() {
        return Iterators.m4035c(descendingIterator());
    }

    @Override // p000.C1671p1, java.util.SortedSet, java.util.NavigableSet
    public final SortedSet subSet(Object obj, Object obj2) {
        return subSet(obj, true, obj2, false);
    }

    @Override // p000.C1671p1, java.util.SortedSet, java.util.NavigableSet
    public final SortedSet tailSet(Object obj) {
        return tailSet(obj, true);
    }

    @Override // java.util.NavigableSet
    public final NavigableSet headSet(Object obj, boolean z) {
        return new C1532m1(this.f22753e, mo6002e().headMap(obj, z));
    }

    @Override // java.util.NavigableSet
    public final NavigableSet subSet(Object obj, boolean z, Object obj2, boolean z2) {
        return new C1532m1(this.f22753e, mo6002e().subMap(obj, z, obj2, z2));
    }

    @Override // java.util.NavigableSet
    public final NavigableSet tailSet(Object obj, boolean z) {
        return new C1532m1(this.f22753e, mo6002e().tailMap(obj, z));
    }
}
