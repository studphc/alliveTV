package p000;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public final class ka1 extends AbstractList implements RandomAccess, Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final List f20802a;

    /* renamed from: b */
    public final Function f20803b;

    public ka1(List list, Function function) {
        this.f20802a = (List) Preconditions.checkNotNull(list);
        this.f20803b = (Function) Preconditions.checkNotNull(function);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        this.f20802a.clear();
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        return this.f20803b.apply(this.f20802a.get(i));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return this.f20802a.isEmpty();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return listIterator();
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        return new w81(this, this.f20802a.listIterator(i), 1);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        return this.f20803b.apply(this.f20802a.remove(i));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f20802a.size();
    }
}
