package p000;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

/* loaded from: classes2.dex */
public final class cy2 extends dy2 {
    @Override // p000.ey2
    /* renamed from: b */
    public final ImmutableList mo4506b(ImmutableCollection immutableCollection) {
        ImmutableList.Builder builder = ImmutableList.builder();
        for (Object obj : immutableCollection) {
            if (!this.f16615c.mo2176d(obj).isInterface()) {
                builder.add((ImmutableList.Builder) obj);
            }
        }
        return super.mo4506b(builder.build());
    }

    @Override // p000.ey2
    /* renamed from: c */
    public final Iterable mo2175c(Object obj) {
        return ImmutableSet.m3971of();
    }
}
