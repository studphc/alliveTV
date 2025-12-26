package p000;

import com.google.common.collect.C0909n2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSortedMap;
import java.util.AbstractMap;

/* loaded from: classes.dex */
public final class b41 extends ImmutableList {

    /* renamed from: c */
    public final /* synthetic */ v21 f7887c;

    public b41(v21 v21Var) {
        this.f7887c = v21Var;
    }

    @Override // com.google.common.collect.ImmutableCollection
    /* renamed from: e */
    public final boolean mo7e() {
        return true;
    }

    @Override // java.util.List
    public final Object get(int i) {
        C0909n2 c0909n2;
        v21 v21Var = this.f7887c;
        c0909n2 = ((ImmutableSortedMap) v21Var.f27629d).f14703f;
        return new AbstractMap.SimpleImmutableEntry(c0909n2.asList().get(i), ((ImmutableSortedMap) v21Var.f27629d).f14704g.get(i));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return ((ImmutableSortedMap) this.f7887c.f27629d).size();
    }
}
