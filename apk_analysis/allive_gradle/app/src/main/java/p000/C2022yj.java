package p000;

import com.google.common.base.Preconditions;
import com.google.common.cache.CacheBuilderSpec;
import java.util.concurrent.TimeUnit;

/* renamed from: yj */
/* loaded from: classes.dex */
public final class C2022yj extends AbstractC0021ak {

    /* renamed from: b */
    public final /* synthetic */ int f28973b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C2022yj(int i) {
        super(0);
        this.f28973b = i;
    }

    @Override // p000.AbstractC0021ak
    /* renamed from: b */
    public final void mo106b(CacheBuilderSpec cacheBuilderSpec, long j, TimeUnit timeUnit) {
        boolean z;
        boolean z2;
        boolean z3;
        switch (this.f28973b) {
            case 0:
                if (cacheBuilderSpec.f14555k == null) {
                    z = true;
                } else {
                    z = false;
                }
                Preconditions.checkArgument(z, "expireAfterAccess already set");
                cacheBuilderSpec.f14554j = j;
                cacheBuilderSpec.f14555k = timeUnit;
                return;
            case 1:
                if (cacheBuilderSpec.f14557m == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Preconditions.checkArgument(z2, "refreshAfterWrite already set");
                cacheBuilderSpec.f14556l = j;
                cacheBuilderSpec.f14557m = timeUnit;
                return;
            default:
                if (cacheBuilderSpec.f14553i == null) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Preconditions.checkArgument(z3, "expireAfterWrite already set");
                cacheBuilderSpec.f14552h = j;
                cacheBuilderSpec.f14553i = timeUnit;
                return;
        }
    }
}
