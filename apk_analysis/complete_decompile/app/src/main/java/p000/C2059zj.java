package p000;

import com.google.common.base.Preconditions;
import com.google.common.cache.CacheBuilderSpec;

/* renamed from: zj */
/* loaded from: classes.dex */
public final class C2059zj extends AbstractC0021ak {

    /* renamed from: b */
    public final /* synthetic */ int f29399b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C2059zj(int i) {
        super(1);
        this.f29399b = i;
    }

    @Override // p000.AbstractC0021ak
    /* renamed from: c */
    public final void mo107c(CacheBuilderSpec cacheBuilderSpec, int i) {
        boolean z;
        boolean z2;
        switch (this.f29399b) {
            case 0:
                Integer num = cacheBuilderSpec.f14548d;
                if (num == null) {
                    z = true;
                } else {
                    z = false;
                }
                Preconditions.checkArgument(z, "concurrency level was already set to ", num);
                cacheBuilderSpec.f14548d = Integer.valueOf(i);
                return;
            default:
                Integer num2 = cacheBuilderSpec.f14545a;
                if (num2 == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Preconditions.checkArgument(z2, "initial capacity was already set to ", num2);
                cacheBuilderSpec.f14545a = Integer.valueOf(i);
                return;
        }
    }
}
