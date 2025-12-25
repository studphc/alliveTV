package p000;

import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
import com.google.common.math.IntMath;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* renamed from: y */
/* loaded from: classes2.dex */
public final class C2002y extends AbstractSet {

    /* renamed from: a */
    public final /* synthetic */ AbstractC2039z f28778a;

    public C2002y(AbstractC2039z abstractC2039z) {
        this.f28778a = abstractC2039z;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        AbstractC2039z abstractC2039z = this.f28778a;
        if (!abstractC2039z.f29203a.containsKey(obj) && !abstractC2039z.f29204b.containsKey(obj)) {
            return false;
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        Iterable union;
        AbstractC2039z abstractC2039z = this.f28778a;
        int i = abstractC2039z.f29205c;
        Map map = abstractC2039z.f29204b;
        Map map2 = abstractC2039z.f29203a;
        if (i == 0) {
            union = Iterables.concat(map2.keySet(), map.keySet());
        } else {
            union = Sets.union(map2.keySet(), map.keySet());
        }
        return Iterators.unmodifiableIterator(union.iterator());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        AbstractC2039z abstractC2039z = this.f28778a;
        return IntMath.saturatedAdd(abstractC2039z.f29203a.size(), abstractC2039z.f29204b.size() - abstractC2039z.f29205c);
    }
}
