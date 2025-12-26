package p000;

import com.google.common.collect.LinkedListMultimap;
import java.util.AbstractSequentialList;
import java.util.ListIterator;

/* loaded from: classes.dex */
public final class t81 extends AbstractSequentialList {

    /* renamed from: a */
    public final /* synthetic */ Object f26718a;

    /* renamed from: b */
    public final /* synthetic */ LinkedListMultimap f26719b;

    public t81(LinkedListMultimap linkedListMultimap, Object obj) {
        this.f26719b = linkedListMultimap;
        this.f26718a = obj;
    }

    @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        return new b91(this.f26719b, this.f26718a, i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        y81 y81Var = (y81) this.f26719b.f14727h.get(this.f26718a);
        if (y81Var == null) {
            return 0;
        }
        return y81Var.f28865c;
    }
}
