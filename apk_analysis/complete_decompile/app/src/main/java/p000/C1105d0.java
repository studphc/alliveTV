package p000;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AbstractExecutionThreadService;
import com.google.common.util.concurrent.AbstractIdleService;
import com.google.common.util.concurrent.AbstractService;
import com.google.common.util.concurrent.C0976a;
import com.google.common.util.concurrent.Callables;
import com.google.common.util.concurrent.Service;
import java.util.concurrent.Executor;

/* renamed from: d0 */
/* loaded from: classes2.dex */
public final class C1105d0 extends AbstractService {

    /* renamed from: p */
    public final /* synthetic */ int f16189p;

    /* renamed from: q */
    public final /* synthetic */ Service f16190q;

    public /* synthetic */ C1105d0(Service service, int i) {
        this.f16189p = i;
        this.f16190q = service;
    }

    @Override // com.google.common.util.concurrent.AbstractService
    public final void doStart() {
        switch (this.f16189p) {
            case 0:
                Executor executor = ((AbstractExecutionThreadService) this.f16190q).executor();
                C0576c0 c0576c0 = new C0576c0(this);
                Preconditions.checkNotNull(executor);
                Preconditions.checkNotNull(c0576c0);
                executor.execute(Callables.m4318a(new RunnableC1104d(1, this), c0576c0));
                return;
            default:
                AbstractIdleService abstractIdleService = (AbstractIdleService) this.f16190q;
                Executor executor2 = abstractIdleService.executor();
                C0976a c0976a = abstractIdleService.f15258a;
                Preconditions.checkNotNull(executor2);
                Preconditions.checkNotNull(c0976a);
                executor2.execute(Callables.m4318a(new RunnableC2040z0(this, 0), c0976a));
                return;
        }
    }

    @Override // com.google.common.util.concurrent.AbstractService
    public final void doStop() {
        switch (this.f16189p) {
            case 0:
                ((AbstractExecutionThreadService) this.f16190q).triggerShutdown();
                return;
            default:
                AbstractIdleService abstractIdleService = (AbstractIdleService) this.f16190q;
                Executor executor = abstractIdleService.executor();
                C0976a c0976a = abstractIdleService.f15258a;
                Preconditions.checkNotNull(executor);
                Preconditions.checkNotNull(c0976a);
                executor.execute(Callables.m4318a(new RunnableC2040z0(this, 1), c0976a));
                return;
        }
    }

    @Override // com.google.common.util.concurrent.AbstractService
    public final String toString() {
        switch (this.f16189p) {
            case 0:
                return ((AbstractExecutionThreadService) this.f16190q).toString();
            default:
                return ((AbstractIdleService) this.f16190q).toString();
        }
    }
}
