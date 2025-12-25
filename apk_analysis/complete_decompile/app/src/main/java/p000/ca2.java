package p000;

import com.google.common.collect.AbstractC0919p2;
import com.google.common.collect.ImmutableList;

/* loaded from: classes.dex */
public final class ca2 extends ImmutableList {

    /* renamed from: c */
    public final /* synthetic */ AbstractC0919p2 f8307c;

    public ca2(AbstractC0919p2 abstractC0919p2) {
        this.f8307c = abstractC0919p2;
    }

    @Override // com.google.common.collect.ImmutableCollection
    /* renamed from: e */
    public final boolean mo7e() {
        return true;
    }

    @Override // java.util.List
    public final Object get(int i) {
        return this.f8307c.mo4083l(i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f8307c.size();
    }
}
