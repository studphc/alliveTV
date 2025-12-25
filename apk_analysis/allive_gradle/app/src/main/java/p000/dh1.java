package p000;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

/* loaded from: classes.dex */
public class dh1 extends zg1 implements SortedSet {
    @Override // java.util.SortedSet
    @CheckForNull
    public Comparator<Object> comparator() {
        return mo2097d().comparator();
    }

    @Override // p000.zg1
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public SortedMap mo2097d() {
        return (SortedMap) this.f29371a;
    }

    @Override // java.util.SortedSet
    public Object first() {
        return mo2097d().firstKey();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.SortedSet<java.lang.Object>, zg1] */
    public SortedSet<Object> headSet(Object obj) {
        return new zg1(mo2097d().headMap(obj));
    }

    @Override // java.util.SortedSet
    public Object last() {
        return mo2097d().lastKey();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.SortedSet<java.lang.Object>, zg1] */
    public SortedSet<Object> subSet(Object obj, Object obj2) {
        return new zg1(mo2097d().subMap(obj, obj2));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.SortedSet<java.lang.Object>, zg1] */
    public SortedSet<Object> tailSet(Object obj) {
        return new zg1(mo2097d().tailMap(obj));
    }
}
