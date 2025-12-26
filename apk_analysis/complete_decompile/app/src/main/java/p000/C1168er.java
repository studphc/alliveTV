package p000;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AbstractC1022u;
import java.util.concurrent.RejectedExecutionException;

/* renamed from: er */
/* loaded from: classes2.dex */
public final class C1168er extends AbstractC1022u {

    /* renamed from: p */
    public C1131dr f16955p;

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final void interruptTask() {
        C1131dr c1131dr = this.f16955p;
        if (c1131dr != null) {
            c1131dr.m23c();
        }
    }

    @Override // com.google.common.util.concurrent.AbstractC1022u
    /* renamed from: l */
    public final void mo4359l() {
        C1131dr c1131dr = this.f16955p;
        if (c1131dr != null) {
            try {
                c1131dr.f16493c.execute(c1131dr);
            } catch (RejectedExecutionException e) {
                c1131dr.f16494d.setException(e);
            }
        }
    }

    @Override // com.google.common.util.concurrent.AbstractC1022u
    /* renamed from: o */
    public final void mo4362o(EnumC1222g7 enumC1222g7) {
        Preconditions.checkNotNull(enumC1222g7);
        this.f15430l = null;
        if (enumC1222g7 == EnumC1222g7.f17564a) {
            this.f16955p = null;
        }
    }

    @Override // com.google.common.util.concurrent.AbstractC1022u
    /* renamed from: j */
    public final void mo4357j(int i, Object obj) {
    }
}
