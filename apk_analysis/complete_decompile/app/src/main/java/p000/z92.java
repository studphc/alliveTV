package p000;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class z92 extends ImmutableSet {

    /* renamed from: c */
    public final transient ImmutableMap f29293c;

    /* renamed from: d */
    public final transient aa2 f29294d;

    public z92(ImmutableMap immutableMap, aa2 aa2Var) {
        this.f29293c = immutableMap;
        this.f29294d = aa2Var;
    }

    @Override // com.google.common.collect.ImmutableCollection
    /* renamed from: a */
    public final int mo3896a(Object[] objArr, int i) {
        return this.f29294d.mo3896a(objArr, i);
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    public final ImmutableList asList() {
        return this.f29294d;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (this.f29293c.get(obj) != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection
    /* renamed from: e */
    public final boolean mo7e() {
        return true;
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final UnmodifiableIterator iterator() {
        return this.f29294d.iterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f29293c.size();
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return this.f29294d.iterator();
    }
}
