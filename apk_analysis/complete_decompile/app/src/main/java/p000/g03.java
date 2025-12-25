package p000;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.internal.LimitedDispatcherKt;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import kotlinx.coroutines.scheduling.TasksKt;

/* loaded from: classes2.dex */
public final class g03 extends CoroutineDispatcher {

    /* renamed from: b */
    public static final g03 f17514b = new CoroutineDispatcher();

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        DefaultScheduler.INSTANCE.dispatchWithContext$kotlinx_coroutines_core(runnable, TasksKt.BlockingContext, false);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        DefaultScheduler.INSTANCE.dispatchWithContext$kotlinx_coroutines_core(runnable, TasksKt.BlockingContext, true);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final CoroutineDispatcher limitedParallelism(int i) {
        LimitedDispatcherKt.checkParallelism(i);
        if (i >= TasksKt.MAX_POOL_SIZE) {
            return this;
        }
        return super.limitedParallelism(i);
    }
}
