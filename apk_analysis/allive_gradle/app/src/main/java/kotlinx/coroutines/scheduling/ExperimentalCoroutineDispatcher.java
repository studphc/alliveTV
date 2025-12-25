package kotlinx.coroutines.scheduling;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DefaultExecutor;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import p000.h81;
import p000.ye0;

@Metadata(m5568d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0011\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nB'\b\u0016\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\u000bB\u001d\b\u0017\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\fJ#\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\r2\n\u0010\u0011\u001a\u00060\u000fj\u0002`\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\r2\n\u0010\u0011\u001a\u00060\u000fj\u0002`\u0010H\u0016¢\u0006\u0004\b\u0015\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010\u001a\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0002¢\u0006\u0004\b\u001e\u0010\u001dJ+\u0010$\u001a\u00020\u00122\n\u0010\u0011\u001a\u00060\u000fj\u0002`\u00102\u0006\u0010\u000e\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020 H\u0000¢\u0006\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u0006)"}, m5569d2 = {"Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "", "corePoolSize", "maxPoolSize", "", "idleWorkerKeepAliveNs", "", "schedulerName", "<init>", "(IIJLjava/lang/String;)V", "(IILjava/lang/String;)V", "(II)V", "Lkotlin/coroutines/CoroutineContext;", "context", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "dispatchYield", "close", "()V", "toString", "()Ljava/lang/String;", "parallelism", "Lkotlinx/coroutines/CoroutineDispatcher;", "blocking", "(I)Lkotlinx/coroutines/CoroutineDispatcher;", "limited", "Lkotlinx/coroutines/scheduling/TaskContext;", "", "tailDispatch", "dispatchWithContext$kotlinx_coroutines_core", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/TaskContext;Z)V", "dispatchWithContext", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "executor", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@PublishedApi
@SourceDebugExtension({"SMAP\nDeprecated.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Deprecated.kt\nkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,213:1\n1#2:214\n*E\n"})
/* loaded from: classes2.dex */
public class ExperimentalCoroutineDispatcher extends ExecutorCoroutineDispatcher {

    /* renamed from: b */
    public final int f22063b;

    /* renamed from: c */
    public final CoroutineScheduler f22064c;

    public /* synthetic */ ExperimentalCoroutineDispatcher(int i, int i2, long j, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, j, (i3 & 8) != 0 ? "CoroutineScheduler" : str);
    }

    public static /* synthetic */ CoroutineDispatcher blocking$default(ExperimentalCoroutineDispatcher experimentalCoroutineDispatcher, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                i = 16;
            }
            return experimentalCoroutineDispatcher.blocking(i);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: blocking");
    }

    @NotNull
    public final CoroutineDispatcher blocking(int parallelism) {
        if (parallelism > 0) {
            return new h81(this, parallelism, 1);
        }
        throw new IllegalArgumentException(ye0.m8291k(parallelism, "Expected positive parallelism level, but have ").toString());
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f22064c.close();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(@NotNull CoroutineContext context, @NotNull Runnable block) {
        try {
            CoroutineScheduler.dispatch$default(this.f22064c, block, null, false, 6, null);
        } catch (RejectedExecutionException unused) {
            DefaultExecutor.INSTANCE.dispatch(context, block);
        }
    }

    public final void dispatchWithContext$kotlinx_coroutines_core(@NotNull Runnable block, @NotNull TaskContext context, boolean tailDispatch) {
        CoroutineScheduler coroutineScheduler = this.f22064c;
        try {
            coroutineScheduler.dispatch(block, context, tailDispatch);
        } catch (RejectedExecutionException unused) {
            DefaultExecutor.INSTANCE.enqueue(coroutineScheduler.createTask(block, context));
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatchYield(@NotNull CoroutineContext context, @NotNull Runnable block) {
        try {
            CoroutineScheduler.dispatch$default(this.f22064c, block, null, true, 2, null);
        } catch (RejectedExecutionException unused) {
            DefaultExecutor.INSTANCE.dispatchYield(context, block);
        }
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    @NotNull
    public Executor getExecutor() {
        return this.f22064c;
    }

    @NotNull
    public final CoroutineDispatcher limited(int parallelism) {
        if (parallelism > 0) {
            int i = this.f22063b;
            if (parallelism <= i) {
                return new h81(this, parallelism, 0);
            }
            throw new IllegalArgumentException(ye0.m8293m(i, "Expected parallelism level lesser than core pool size (", "), but have ", parallelism).toString());
        }
        throw new IllegalArgumentException(ye0.m8291k(parallelism, "Expected positive parallelism level, but have ").toString());
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @NotNull
    public String toString() {
        return super.toString() + "[scheduler = " + this.f22064c + ']';
    }

    public ExperimentalCoroutineDispatcher(int i, int i2, long j, @NotNull String str) {
        this.f22063b = i;
        this.f22064c = new CoroutineScheduler(i, i2, j, str);
    }

    public /* synthetic */ ExperimentalCoroutineDispatcher(int i, int i2, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? TasksKt.CORE_POOL_SIZE : i, (i3 & 2) != 0 ? TasksKt.MAX_POOL_SIZE : i2, (i3 & 4) != 0 ? TasksKt.DEFAULT_SCHEDULER_NAME : str);
    }

    public ExperimentalCoroutineDispatcher(int i, int i2, @NotNull String str) {
        this(i, i2, TasksKt.IDLE_WORKER_KEEP_ALIVE_NS, str);
    }

    public /* synthetic */ ExperimentalCoroutineDispatcher(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? TasksKt.CORE_POOL_SIZE : i, (i3 & 2) != 0 ? TasksKt.MAX_POOL_SIZE : i2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility for Ktor 1.0-beta")
    public /* synthetic */ ExperimentalCoroutineDispatcher(int i, int i2) {
        this(i, i2, TasksKt.IDLE_WORKER_KEEP_ALIVE_NS, null, 8, null);
    }
}
