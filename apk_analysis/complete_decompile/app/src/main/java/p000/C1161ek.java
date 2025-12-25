package p000;

import com.google.common.base.Preconditions;
import com.google.common.cache.CacheBuilderSpec;

/* renamed from: ek */
/* loaded from: classes.dex */
public final class C1161ek implements InterfaceC1125dk {

    /* renamed from: a */
    public final ub1 f16853a;

    public C1161ek(ub1 ub1Var) {
        this.f16853a = ub1Var;
    }

    @Override // p000.InterfaceC1125dk
    /* renamed from: a */
    public final void mo105a(CacheBuilderSpec cacheBuilderSpec, String str, String str2) {
        boolean z;
        boolean z2 = false;
        if (str2 == null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "key %s does not take values", str);
        ub1 ub1Var = cacheBuilderSpec.f14550f;
        if (ub1Var == null) {
            z2 = true;
        }
        Preconditions.checkArgument(z2, "%s was already set to %s", str, ub1Var);
        cacheBuilderSpec.f14550f = this.f16853a;
    }
}
