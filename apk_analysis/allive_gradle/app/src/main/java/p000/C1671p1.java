package p000;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.SortedSet;

/* renamed from: p1 */
/* loaded from: classes.dex */
public class C1671p1 extends C1375k1 implements SortedSet {

    /* renamed from: d */
    public final /* synthetic */ AbstractC1930w1 f24998d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1671p1(AbstractC1930w1 abstractC1930w1, SortedMap sortedMap) {
        super(abstractC1930w1, sortedMap, 0);
        this.f24998d = abstractC1930w1;
    }

    @Override // java.util.SortedSet
    public final Comparator comparator() {
        return mo6002e().comparator();
    }

    /* renamed from: e */
    public SortedMap mo6002e() {
        return (SortedMap) this.f29371a;
    }

    @Override // java.util.SortedSet
    public final Object first() {
        return mo6002e().firstKey();
    }

    public SortedSet headSet(Object obj) {
        return new C1671p1(this.f24998d, mo6002e().headMap(obj));
    }

    @Override // java.util.SortedSet
    public final Object last() {
        return mo6002e().lastKey();
    }

    public SortedSet subSet(Object obj, Object obj2) {
        return new C1671p1(this.f24998d, mo6002e().subMap(obj, obj2));
    }

    public SortedSet tailSet(Object obj) {
        return new C1671p1(this.f24998d, mo6002e().tailMap(obj));
    }
}
