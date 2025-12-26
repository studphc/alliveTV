package p000;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.SortedSet;

/* loaded from: classes.dex */
public final class vg1 extends C1375k1 implements SortedSet {

    /* renamed from: d */
    public final /* synthetic */ wg1 f27775d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vg1(wg1 wg1Var) {
        super(wg1Var, 2);
        this.f27775d = wg1Var;
    }

    @Override // java.util.SortedSet
    public final Comparator comparator() {
        return ((SortedMap) this.f27775d.f26415d).comparator();
    }

    @Override // java.util.SortedSet
    public final Object first() {
        return this.f27775d.firstKey();
    }

    @Override // java.util.SortedSet
    public final SortedSet headSet(Object obj) {
        return (SortedSet) ((wg1) this.f27775d.headMap(obj)).keySet();
    }

    @Override // java.util.SortedSet
    public final Object last() {
        return this.f27775d.lastKey();
    }

    @Override // java.util.SortedSet
    public final SortedSet subSet(Object obj, Object obj2) {
        return (SortedSet) ((wg1) this.f27775d.subMap(obj, obj2)).keySet();
    }

    @Override // java.util.SortedSet
    public final SortedSet tailSet(Object obj) {
        return (SortedSet) ((wg1) this.f27775d.tailMap(obj)).keySet();
    }
}
