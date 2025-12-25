package p000;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes.dex */
public final class la1 extends AbstractSequentialList implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final List f22425a;

    /* renamed from: b */
    public final Function f22426b;

    public la1(List list, Function function) {
        this.f22425a = (List) Preconditions.checkNotNull(list);
        this.f22426b = (Function) Preconditions.checkNotNull(function);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        this.f22425a.clear();
    }

    @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        return new w81(this, this.f22425a.listIterator(i), 2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f22425a.size();
    }
}
