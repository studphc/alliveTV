package p000;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class f31 extends ImmutableCollection {

    /* renamed from: b */
    public final w21 f17115b;

    public f31(w21 w21Var) {
        this.f17115b = w21Var;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final ImmutableList asList() {
        return new d31(this.f17115b.entrySet().asList());
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (obj != null && Iterators.contains(new u21(this), obj)) {
            return true;
        }
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection
    /* renamed from: e */
    public final boolean mo7e() {
        throw null;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final UnmodifiableIterator iterator() {
        return new u21(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.f17115b.size();
    }

    @Override // com.google.common.collect.ImmutableCollection
    @GwtIncompatible
    public Object writeReplace() {
        return new e31(this.f17115b);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new u21(this);
    }
}
