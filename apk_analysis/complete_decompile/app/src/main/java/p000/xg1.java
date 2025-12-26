package p000;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class xg1 extends hh1 {

    /* renamed from: b */
    public final Map f28548b;

    /* renamed from: c */
    public final Predicate f28549c;

    public xg1(AbstractMap abstractMap, Map map, Predicate predicate) {
        super(abstractMap);
        this.f28548b = map;
        this.f28549c = predicate;
    }

    @Override // p000.hh1, java.util.AbstractCollection, java.util.Collection
    public final boolean remove(Object obj) {
        Iterator it = this.f28548b.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (this.f28549c.apply(entry) && Objects.equal(entry.getValue(), obj)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    @Override // p000.hh1, java.util.AbstractCollection, java.util.Collection
    public final boolean removeAll(Collection collection) {
        Iterator it = this.f28548b.entrySet().iterator();
        boolean z = false;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (this.f28549c.apply(entry) && collection.contains(entry.getValue())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    @Override // p000.hh1, java.util.AbstractCollection, java.util.Collection
    public final boolean retainAll(Collection collection) {
        Iterator it = this.f28548b.entrySet().iterator();
        boolean z = false;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (this.f28549c.apply(entry) && !collection.contains(entry.getValue())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        return Lists.newArrayList(iterator()).toArray();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        return Lists.newArrayList(iterator()).toArray(objArr);
    }
}
