package p000;

import java.util.ListIterator;
import java.util.NoSuchElementException;
import kotlin.collections.AbstractList;

/* renamed from: d1 */
/* loaded from: classes2.dex */
public final class C1106d1 extends C0577c1 implements ListIterator {

    /* renamed from: d */
    public final /* synthetic */ AbstractList f16196d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1106d1(AbstractList abstractList, int i) {
        super(abstractList);
        this.f16196d = abstractList;
        AbstractList.INSTANCE.checkPositionIndex$kotlin_stdlib(i, abstractList.size());
        this.f8223b = i;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        if (this.f8223b > 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f8223b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (hasPrevious()) {
            int i = this.f8223b - 1;
            this.f8223b = i;
            return this.f16196d.get(i);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f8223b - 1;
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
