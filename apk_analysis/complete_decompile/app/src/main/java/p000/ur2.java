package p000;

import java.util.Comparator;
import java.util.SortedMap;

/* loaded from: classes.dex */
public abstract class ur2 extends lr2 implements SortedMap {
    private static final long serialVersionUID = 0;

    @Override // java.util.SortedMap
    public final Comparator comparator() {
        Comparator comparator;
        synchronized (this.f25273b) {
            comparator = ((nr2) this).mo4828e().comparator();
        }
        return comparator;
    }

    @Override // java.util.SortedMap
    public final Object firstKey() {
        Object firstKey;
        synchronized (this.f25273b) {
            firstKey = ((nr2) this).mo4828e().firstKey();
        }
        return firstKey;
    }

    @Override // java.util.SortedMap
    public final Object lastKey() {
        Object lastKey;
        synchronized (this.f25273b) {
            lastKey = ((nr2) this).mo4828e().lastKey();
        }
        return lastKey;
    }
}
