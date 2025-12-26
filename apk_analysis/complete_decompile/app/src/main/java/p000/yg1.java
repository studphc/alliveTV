package p000;

import com.google.common.collect.Iterators;
import java.util.AbstractMap;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class yg1 extends AbstractMap {
    /* renamed from: a */
    public abstract Iterator mo84a();

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Iterators.m4034b(mo84a());
    }

    @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
    public Set entrySet() {
        return new C1290i1(this, 4);
    }
}
