package p000;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.SortedSet;

/* renamed from: o1 */
/* loaded from: classes.dex */
public class C1606o1 extends C1338j1 implements SortedMap {

    /* renamed from: f */
    public SortedSet f23561f;

    /* renamed from: g */
    public final /* synthetic */ AbstractC1930w1 f23562g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1606o1(AbstractC1930w1 abstractC1930w1, SortedMap sortedMap) {
        super(abstractC1930w1, sortedMap);
        this.f23562g = abstractC1930w1;
    }

    @Override // java.util.SortedMap
    public final Comparator comparator() {
        return mo5813i().comparator();
    }

    @Override // java.util.SortedMap
    public final Object firstKey() {
        return mo5813i().firstKey();
    }

    @Override // p000.ih1
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public SortedSet mo5238c() {
        return new C1671p1(this.f23562g, mo5813i());
    }

    @Override // p000.C1338j1, p000.ih1, java.util.AbstractMap, java.util.Map, java.util.SortedMap
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public SortedSet keySet() {
        SortedSet sortedSet = this.f23561f;
        if (sortedSet == null) {
            SortedSet mo5238c = mo5238c();
            this.f23561f = mo5238c;
            return mo5238c;
        }
        return sortedSet;
    }

    public SortedMap headMap(Object obj) {
        return new C1606o1(this.f23562g, mo5813i().headMap(obj));
    }

    /* renamed from: i */
    public SortedMap mo5813i() {
        return (SortedMap) this.f20336d;
    }

    @Override // java.util.SortedMap
    public final Object lastKey() {
        return mo5813i().lastKey();
    }

    public SortedMap subMap(Object obj, Object obj2) {
        return new C1606o1(this.f23562g, mo5813i().subMap(obj, obj2));
    }

    public SortedMap tailMap(Object obj) {
        return new C1606o1(this.f23562g, mo5813i().tailMap(obj));
    }
}
