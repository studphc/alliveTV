package kotlinx.coroutines.scheduling;

import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ#\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b2\n\u0010\u000f\u001a\u00060\rj\u0002`\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0013\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b2\n\u0010\u000f\u001a\u00060\rj\u0002`\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0012J+\u0010\u0019\u001a\u00020\u00102\n\u0010\u000f\u001a\u00060\rj\u0002`\u000e2\u0006\u0010\f\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0015H\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u0010H\u0000¢\u0006\u0004\b\u001c\u0010\u001bJ\u0017\u0010!\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010#\u001a\u00020\u0010H\u0000¢\u0006\u0004\b\"\u0010\u001bR\u0014\u0010'\u001a\u00020$8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u0006("}, m5569d2 = {"Lkotlinx/coroutines/scheduling/SchedulerCoroutineDispatcher;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "", "corePoolSize", "maxPoolSize", "", "idleWorkerKeepAliveNs", "", "schedulerName", "<init>", "(IIJLjava/lang/String;)V", "Lkotlin/coroutines/CoroutineContext;", "context", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "dispatchYield", "Lkotlinx/coroutines/scheduling/TaskContext;", "", "tailDispatch", "dispatchWithContext$kotlinx_coroutines_core", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/TaskContext;Z)V", "dispatchWithContext", "close", "()V", "usePrivateScheduler$kotlinx_coroutines_core", "usePrivateScheduler", "timeout", "shutdown$kotlinx_coroutines_core", "(J)V", "shutdown", "restore$kotlinx_coroutines_core", "restore", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "executor", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public class SchedulerCoroutineDispatcher extends ExecutorCoroutineDispatcher {

    /* renamed from: b */
    public final int f22065b;

    /* renamed from: c */
    public final int f22066c;

    /* renamed from: d */
    public final long f22067d;

    /* renamed from: e */
    public final String f22068e;

    /* renamed from: f */
    public CoroutineScheduler f22069f;

    public SchedulerCoroutineDispatcher() {
        this(0, 0, 0L, null, 15, null);
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f22069f.close();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(@NotNull CoroutineContext context, @NotNull Runnable block) {
        CoroutineScheduler.dispatch$default(this.f22069f, block, null, false, 6, null);
    }

    public final void dispatchWithContext$kotlinx_coroutines_core(@NotNull Runnable block, @NotNull TaskContext context, boolean tailDispatch) {
        this.f22069f.dispatch(block, context, tailDispatch);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatchYield(@NotNull CoroutineContext context, @NotNull Runnable block) {
        CoroutineScheduler.dispatch$default(this.f22069f, block, null, true, 2, null);
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    @NotNull
    public Executor getExecutor() {
        return this.f22069f;
    }

    public final void restore$kotlinx_coroutines_core() {
        usePrivateScheduler$kotlinx_coroutines_core();
    }

    public final synchronized void shutdown$kotlinx_coroutines_core(long timeout) {
        this.f22069f.shutdown(timeout);
    }

    public final synchronized void usePrivateScheduler$kotlinx_coroutines_core() {
        this.f22069f.shutdown(1000L);
        this.f22069f = new CoroutineScheduler(this.f22065b, this.f22066c, this.f22067d, this.f22068e);
    }

    public /* synthetic */ SchedulerCoroutineDispatcher(int i, int i2, long j, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? TasksKt.CORE_POOL_SIZE : i, (i3 & 2) != 0 ? TasksKt.MAX_POOL_SIZE : i2, (i3 & 4) != 0 ? TasksKt.IDLE_WORKER_KEEP_ALIVE_NS : j, (i3 & 8) != 0 ? "CoroutineScheduler" : str);
    }

    public SchedulerCoroutineDispatcher(int i, int i2, long j, @NotNull String str) {
        this.f22065b = i;
        this.f22066c = i2;
        this.f22067d = j;
        this.f22068e = str;
        this.f22069f = new CoroutineScheduler(i, i2, j, str);
    }
}
