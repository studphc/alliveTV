package p000;

import com.google.common.base.Preconditions;
import com.google.common.cache.CacheBuilderSpec;

/* renamed from: ck */
/* loaded from: classes.dex */
public final class C0596ck extends AbstractC0021ak {

    /* renamed from: b */
    public final /* synthetic */ int f8389b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0596ck(int i) {
        super(2);
        this.f8389b = i;
    }

    @Override // p000.AbstractC0021ak
    /* renamed from: d */
    public final void mo108d(CacheBuilderSpec cacheBuilderSpec, long j) {
        boolean z;
        boolean z2;
        switch (this.f8389b) {
            case 0:
                Long l = cacheBuilderSpec.f14546b;
                boolean z3 = false;
                if (l == null) {
                    z = true;
                } else {
                    z = false;
                }
                Preconditions.checkArgument(z, "maximum size was already set to ", l);
                Long l2 = cacheBuilderSpec.f14547c;
                if (l2 == null) {
                    z3 = true;
                }
                Preconditions.checkArgument(z3, "maximum weight was already set to ", l2);
                cacheBuilderSpec.f14546b = Long.valueOf(j);
                return;
            default:
                Long l3 = cacheBuilderSpec.f14547c;
                boolean z4 = false;
                if (l3 == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Preconditions.checkArgument(z2, "maximum weight was already set to ", l3);
                Long l4 = cacheBuilderSpec.f14546b;
                if (l4 == null) {
                    z4 = true;
                }
                Preconditions.checkArgument(z4, "maximum size was already set to ", l4);
                cacheBuilderSpec.f14547c = Long.valueOf(j);
                return;
        }
    }
}
