package p000;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

/* loaded from: classes.dex */
public final class wg1 extends sg1 implements SortedMap {
    @Override // p000.sg1, p000.ih1
    /* renamed from: c */
    public final Set mo5238c() {
        return new vg1(this);
    }

    @Override // java.util.SortedMap
    public final Comparator comparator() {
        return ((SortedMap) this.f26415d).comparator();
    }

    @Override // java.util.SortedMap
    public final Object firstKey() {
        return ((SortedSet) super.keySet()).iterator().next();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [sg1, java.util.SortedMap] */
    @Override // java.util.SortedMap
    public final SortedMap headMap(Object obj) {
        return new sg1(((SortedMap) this.f26415d).headMap(obj), this.f26416e);
    }

    @Override // p000.ih1, java.util.AbstractMap, java.util.Map, java.util.SortedMap
    public final Set keySet() {
        return (SortedSet) super.keySet();
    }

    @Override // java.util.SortedMap
    public final Object lastKey() {
        Map map = this.f26415d;
        SortedMap sortedMap = (SortedMap) map;
        while (true) {
            Object lastKey = sortedMap.lastKey();
            if (m7372f(lastKey, map.get(lastKey))) {
                return lastKey;
            }
            sortedMap = ((SortedMap) map).headMap(lastKey);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [sg1, java.util.SortedMap] */
    @Override // java.util.SortedMap
    public final SortedMap subMap(Object obj, Object obj2) {
        return new sg1(((SortedMap) this.f26415d).subMap(obj, obj2), this.f26416e);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [sg1, java.util.SortedMap] */
    @Override // java.util.SortedMap
    public final SortedMap tailMap(Object obj) {
        return new sg1(((SortedMap) this.f26415d).tailMap(obj), this.f26416e);
    }
}
