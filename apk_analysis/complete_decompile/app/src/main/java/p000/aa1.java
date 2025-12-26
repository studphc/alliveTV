package p000;

import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public final class aa1 extends ca1 implements RandomAccess {
    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        return ((List) this.f8306b).listIterator(i);
    }
}
