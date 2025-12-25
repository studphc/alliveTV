package p000;

import com.google.common.base.Preconditions;
import com.google.common.cache.CacheBuilderSpec;

/* renamed from: bk */
/* loaded from: classes.dex */
public final class C0560bk implements InterfaceC1125dk {

    /* renamed from: a */
    public final /* synthetic */ int f8051a;

    public /* synthetic */ C0560bk(int i) {
        this.f8051a = i;
    }

    @Override // p000.InterfaceC1125dk
    /* renamed from: a */
    public final void mo105a(CacheBuilderSpec cacheBuilderSpec, String str, String str2) {
        boolean z;
        boolean z2;
        switch (this.f8051a) {
            case 0:
                boolean z3 = false;
                if (str2 == null) {
                    z = true;
                } else {
                    z = false;
                }
                Preconditions.checkArgument(z, "key %s does not take values", str);
                tb1 tb1Var = cacheBuilderSpec.f14549e;
                if (tb1Var == null) {
                    z3 = true;
                }
                Preconditions.checkArgument(z3, "%s was already set to %s", str, tb1Var);
                cacheBuilderSpec.f14549e = ub1.f27187c;
                return;
            default:
                boolean z4 = false;
                if (str2 == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Preconditions.checkArgument(z2, "recordStats does not take values");
                if (cacheBuilderSpec.f14551g == null) {
                    z4 = true;
                }
                Preconditions.checkArgument(z4, "recordStats already set");
                cacheBuilderSpec.f14551g = Boolean.TRUE;
                return;
        }
    }
}
