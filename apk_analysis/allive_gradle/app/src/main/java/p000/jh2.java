package p000;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

/* loaded from: classes.dex */
public final class jh2 extends ImmutableList {

    /* renamed from: c */
    public final /* synthetic */ ImmutableList f20506c;

    public jh2(ImmutableList immutableList) {
        this.f20506c = immutableList;
    }

    @Override // com.google.common.collect.ImmutableCollection
    /* renamed from: e */
    public final boolean mo7e() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.List
    public final Object get(int i) {
        return ((ImmutableSet) this.f20506c.get(i)).asList();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f20506c.size();
    }
}
