package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.C0896l;
import com.google.common.collect.ImmutableList;
import java.util.List;

/* renamed from: dl */
/* loaded from: classes.dex */
public final class C1126dl extends ImmutableList {

    /* renamed from: c */
    public final /* synthetic */ int f16402c;

    /* renamed from: d */
    public final /* synthetic */ C0896l f16403d;

    public C1126dl(C0896l c0896l, int i) {
        this.f16403d = c0896l;
        this.f16402c = i;
    }

    @Override // com.google.common.collect.ImmutableCollection
    /* renamed from: e */
    public final boolean mo7e() {
        return true;
    }

    @Override // java.util.List
    public final Object get(int i) {
        Preconditions.checkElementIndex(i, size());
        C0896l c0896l = this.f16403d;
        return ((List) c0896l.f14872a.get(i)).get(C0896l.m4126a(c0896l, this.f16402c, i));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f16403d.f14872a.size();
    }
}
