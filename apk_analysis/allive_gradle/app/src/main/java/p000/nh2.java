package p000;

import com.google.common.collect.Iterators;
import java.util.Comparator;
import java.util.SortedSet;

/* loaded from: classes.dex */
public class nh2 extends mh2 implements SortedSet {
    @Override // java.util.SortedSet
    public final Comparator comparator() {
        return ((SortedSet) this.f29458a).comparator();
    }

    @Override // java.util.SortedSet
    public final Object first() {
        return Iterators.find(this.f29458a.iterator(), this.f29459b);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.SortedSet, zp] */
    @Override // java.util.SortedSet
    public final SortedSet headSet(Object obj) {
        return new C2065zp(((SortedSet) this.f29458a).headSet(obj), this.f29459b);
    }

    public Object last() {
        SortedSet sortedSet = (SortedSet) this.f29458a;
        while (true) {
            Object last = sortedSet.last();
            if (this.f29459b.apply(last)) {
                return last;
            }
            sortedSet = sortedSet.headSet(last);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.SortedSet, zp] */
    @Override // java.util.SortedSet
    public final SortedSet subSet(Object obj, Object obj2) {
        return new C2065zp(((SortedSet) this.f29458a).subSet(obj, obj2), this.f29459b);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.SortedSet, zp] */
    @Override // java.util.SortedSet
    public final SortedSet tailSet(Object obj) {
        return new C2065zp(((SortedSet) this.f29458a).tailSet(obj), this.f29459b);
    }
}
