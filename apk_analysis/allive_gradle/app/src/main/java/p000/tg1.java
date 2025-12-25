package p000;

import java.util.Collection;

/* loaded from: classes.dex */
public final class tg1 extends bh1 {

    /* renamed from: b */
    public final /* synthetic */ ug1 f26808b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tg1(ug1 ug1Var, ug1 ug1Var2) {
        super(ug1Var2);
        this.f26808b = ug1Var;
    }

    @Override // p000.oh2, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        ug1 ug1Var = this.f26808b;
        return sg1.m7370h(ug1Var.f27256a, ug1Var.f27257b, collection);
    }

    @Override // p000.oh2, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean retainAll(Collection collection) {
        ug1 ug1Var = this.f26808b;
        return sg1.m7371i(ug1Var.f27256a, ug1Var.f27257b, collection);
    }
}
