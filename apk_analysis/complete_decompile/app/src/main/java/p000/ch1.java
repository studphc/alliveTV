package p000;

import com.google.common.base.Function;
import com.google.common.collect.Maps;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

/* loaded from: classes.dex */
public final class ch1 extends ig1 implements SortedMap {
    @Override // java.util.SortedMap
    public final Comparator comparator() {
        return ((SortedSet) ((Set) this.f18404e)).comparator();
    }

    @Override // p000.ig1
    /* renamed from: f */
    public final Set mo2233f() {
        return (SortedSet) ((Set) this.f18404e);
    }

    @Override // java.util.SortedMap
    public final Object firstKey() {
        return ((SortedSet) ((Set) this.f18404e)).first();
    }

    @Override // java.util.SortedMap
    public final SortedMap headMap(Object obj) {
        return Maps.asMap(((SortedSet) ((Set) this.f18404e)).headSet(obj), (Function) this.f18405f);
    }

    @Override // p000.ih1, java.util.AbstractMap, java.util.Map, java.util.SortedMap
    public final Set keySet() {
        return new gg1((SortedSet) ((Set) this.f18404e));
    }

    @Override // java.util.SortedMap
    public final Object lastKey() {
        return ((SortedSet) ((Set) this.f18404e)).last();
    }

    @Override // java.util.SortedMap
    public final SortedMap subMap(Object obj, Object obj2) {
        return Maps.asMap(((SortedSet) ((Set) this.f18404e)).subSet(obj, obj2), (Function) this.f18405f);
    }

    @Override // java.util.SortedMap
    public final SortedMap tailMap(Object obj) {
        return Maps.asMap(((SortedSet) ((Set) this.f18404e)).tailSet(obj), (Function) this.f18405f);
    }
}
