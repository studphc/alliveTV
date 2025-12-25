package kotlinx.coroutines.scheduling;

import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.internal.LimitedDispatcherKt;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\n\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\tJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, m5569d2 = {"Lkotlinx/coroutines/scheduling/DefaultScheduler;", "Lkotlinx/coroutines/scheduling/SchedulerCoroutineDispatcher;", "", "parallelism", "Lkotlinx/coroutines/CoroutineDispatcher;", "limitedParallelism", "(I)Lkotlinx/coroutines/CoroutineDispatcher;", "", "shutdown$kotlinx_coroutines_core", "()V", "shutdown", "close", "", "toString", "()Ljava/lang/String;", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class DefaultScheduler extends SchedulerCoroutineDispatcher {

    @NotNull
    public static final DefaultScheduler INSTANCE = new SchedulerCoroutineDispatcher(TasksKt.CORE_POOL_SIZE, TasksKt.MAX_POOL_SIZE, TasksKt.IDLE_WORKER_KEEP_ALIVE_NS, TasksKt.DEFAULT_SCHEDULER_NAME);

    @Override // kotlinx.coroutines.scheduling.SchedulerCoroutineDispatcher, kotlinx.coroutines.ExecutorCoroutineDispatcher, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @ExperimentalCoroutinesApi
    @NotNull
    public CoroutineDispatcher limitedParallelism(int parallelism) {
        LimitedDispatcherKt.checkParallelism(parallelism);
        if (parallelism >= TasksKt.CORE_POOL_SIZE) {
            return this;
        }
        return super.limitedParallelism(parallelism);
    }

    public final void shutdown$kotlinx_coroutines_core() {
        super.close();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @NotNull
    public String toString() {
        return "Dispatchers.Default";
    }
}
