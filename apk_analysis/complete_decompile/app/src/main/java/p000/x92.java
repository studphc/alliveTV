package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.AbstractMap;
import java.util.Objects;

/* loaded from: classes.dex */
public final class x92 extends ImmutableList {

    /* renamed from: c */
    public final /* synthetic */ y92 f28482c;

    public x92(y92 y92Var) {
        this.f28482c = y92Var;
    }

    @Override // com.google.common.collect.ImmutableCollection
    /* renamed from: e */
    public final boolean mo7e() {
        return true;
    }

    @Override // java.util.List
    public final Object get(int i) {
        y92 y92Var = this.f28482c;
        Preconditions.checkElementIndex(i, y92Var.f28875f);
        int i2 = i * 2;
        int i3 = y92Var.f28874e;
        Object[] objArr = y92Var.f28873d;
        Object obj = objArr[i2 + i3];
        Objects.requireNonNull(obj);
        Object obj2 = objArr[i2 + (i3 ^ 1)];
        Objects.requireNonNull(obj2);
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f28482c.f28875f;
    }
}
