package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public final class ph2 extends AbstractSet {

    /* renamed from: a */
    public final ImmutableMap f25181a;

    public ph2(Set set) {
        boolean z;
        if (set.size() <= 30) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "Too many elements to create power set: %s > 30", set.size());
        this.f25181a = Maps.m4049e(set);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (obj instanceof Set) {
            return this.f25181a.keySet().containsAll((Set) obj);
        }
        return false;
    }

    @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj instanceof ph2) {
            return this.f25181a.keySet().equals(((ph2) obj).f25181a.keySet());
        }
        return super.equals(obj);
    }

    @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.f25181a.keySet().hashCode() << (r0.size() - 1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new C1505lb(size(), 4, this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 1 << this.f25181a.size();
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        String valueOf = String.valueOf(this.f25181a);
        return AbstractC1726qj.m7059o("powerSet(", valueOf, ")", valueOf.length() + 10);
    }
}
