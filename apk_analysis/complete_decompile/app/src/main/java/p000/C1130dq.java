package p000;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Iterators;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

/* renamed from: dq */
/* loaded from: classes.dex */
public final class C1130dq extends AbstractCollection {

    /* renamed from: a */
    public final Collection f16482a;

    /* renamed from: b */
    public final Function f16483b;

    public C1130dq(Collection collection, Function function) {
        this.f16482a = (Collection) Preconditions.checkNotNull(collection);
        this.f16483b = (Function) Preconditions.checkNotNull(function);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.f16482a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return this.f16482a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return Iterators.transform(this.f16482a.iterator(), this.f16483b);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.f16482a.size();
    }
}
