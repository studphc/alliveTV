package p000;

import com.google.common.collect.LinkedListMultimap;
import java.util.AbstractSequentialList;
import java.util.ListIterator;

/* loaded from: classes.dex */
public final class u81 extends AbstractSequentialList {

    /* renamed from: a */
    public final /* synthetic */ int f27147a;

    /* renamed from: b */
    public final /* synthetic */ LinkedListMultimap f27148b;

    public /* synthetic */ u81(LinkedListMultimap linkedListMultimap, int i) {
        this.f27147a = i;
        this.f27148b = linkedListMultimap;
    }

    @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        switch (this.f27147a) {
            case 0:
                return new a91(this.f27148b, i);
            default:
                a91 a91Var = new a91(this.f27148b, i);
                return new w81(a91Var, a91Var);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        switch (this.f27147a) {
            case 0:
                return this.f27148b.f14728i;
            default:
                return this.f27148b.f14728i;
        }
    }
}
