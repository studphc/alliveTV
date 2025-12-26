package kotlinx.coroutines.scheduling;

import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DispatchersKt;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.internal.SystemPropsKt;
import org.jetbrains.annotations.NotNull;
import p000.g03;
import p000.r82;

@Metadata(m5568d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u00012\u00020\u0002J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0017¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\n\u0010\u0010\u001a\u00060\u0003j\u0002`\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\n\u0010\u0010\u001a\u00060\u0003j\u0002`\u000fH\u0017¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, m5569d2 = {"Lkotlinx/coroutines/scheduling/DefaultIoScheduler;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Ljava/util/concurrent/Executor;", "Ljava/lang/Runnable;", "command", "", "execute", "(Ljava/lang/Runnable;)V", "", "parallelism", "Lkotlinx/coroutines/CoroutineDispatcher;", "limitedParallelism", "(I)Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlinx/coroutines/Runnable;", "block", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "dispatchYield", "close", "()V", "", "toString", "()Ljava/lang/String;", "getExecutor", "()Ljava/util/concurrent/Executor;", "executor", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class DefaultIoScheduler extends ExecutorCoroutineDispatcher implements Executor {

    @NotNull
    public static final DefaultIoScheduler INSTANCE = new ExecutorCoroutineDispatcher();

    /* renamed from: b */
    public static final CoroutineDispatcher f22062b = g03.f17514b.limitedParallelism(SystemPropsKt.systemProp$default(DispatchersKt.IO_PARALLELISM_PROPERTY_NAME, r82.coerceAtLeast(64, SystemPropsKt.getAVAILABLE_PROCESSORS()), 0, 0, 12, (Object) null));

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO");
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(@NotNull CoroutineContext context, @NotNull Runnable block) {
        f22062b.dispatch(context, block);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @InternalCoroutinesApi
    public void dispatchYield(@NotNull CoroutineContext context, @NotNull Runnable block) {
        f22062b.dispatchYield(context, block);
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NotNull Runnable command) {
        dispatch(EmptyCoroutineContext.INSTANCE, command);
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    @NotNull
    public Executor getExecutor() {
        return this;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @ExperimentalCoroutinesApi
    @NotNull
    public CoroutineDispatcher limitedParallelism(int parallelism) {
        return g03.f17514b.limitedParallelism(parallelism);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @NotNull
    public String toString() {
        return "Dispatchers.IO";
    }
}
