package p000;

import com.google.common.collect.ImmutableList;
import java.util.Map;

/* loaded from: classes.dex */
public final class d31 extends ImmutableList {

    /* renamed from: c */
    public final /* synthetic */ ImmutableList f16226c;

    public d31(ImmutableList immutableList) {
        this.f16226c = immutableList;
    }

    @Override // com.google.common.collect.ImmutableCollection
    /* renamed from: e */
    public final boolean mo7e() {
        return true;
    }

    @Override // java.util.List
    public final Object get(int i) {
        return ((Map.Entry) this.f16226c.get(i)).getValue();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f16226c.size();
    }
}
