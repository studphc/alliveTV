package kotlinx.coroutines;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;
import p000.b50;

@Metadata(m5568d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0011\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007¢\u0006\u0002\b\u0003\u001a\u0011\u0010\u0000\u001a\u00020\u0004*\u00020\u0005H\u0007¢\u0006\u0002\b\u0003\u001a\n\u0010\u0006\u001a\u00020\u0002*\u00020\u0001*\u0010\b\u0007\u0010\u0007\"\u00020\u00042\u00020\u0004B\u0002\b\b¨\u0006\t"}, m5569d2 = {"asCoroutineDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "Ljava/util/concurrent/Executor;", TypedValues.TransitionType.S_FROM, "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Ljava/util/concurrent/ExecutorService;", "asExecutor", "CloseableCoroutineDispatcher", "Lkotlinx/coroutines/ExperimentalCoroutinesApi;", "kotlinx-coroutines-core"}, m5570k = 2, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class ExecutorsKt {
    @ExperimentalCoroutinesApi
    public static /* synthetic */ void CloseableCoroutineDispatcher$annotations() {
    }

    @NotNull
    public static final Executor asExecutor(@NotNull CoroutineDispatcher coroutineDispatcher) {
        ExecutorCoroutineDispatcher executorCoroutineDispatcher;
        Executor executor;
        if (coroutineDispatcher instanceof ExecutorCoroutineDispatcher) {
            executorCoroutineDispatcher = (ExecutorCoroutineDispatcher) coroutineDispatcher;
        } else {
            executorCoroutineDispatcher = null;
        }
        if (executorCoroutineDispatcher == null || (executor = executorCoroutineDispatcher.getExecutor()) == null) {
            return new b50(coroutineDispatcher);
        }
        return executor;
    }

    @JvmName(name = TypedValues.TransitionType.S_FROM)
    @NotNull
    public static final ExecutorCoroutineDispatcher from(@NotNull ExecutorService executorService) {
        return new ExecutorCoroutineDispatcherImpl(executorService);
    }

    @JvmName(name = TypedValues.TransitionType.S_FROM)
    @NotNull
    public static final CoroutineDispatcher from(@NotNull Executor executor) {
        CoroutineDispatcher coroutineDispatcher;
        b50 b50Var = executor instanceof b50 ? (b50) executor : null;
        return (b50Var == null || (coroutineDispatcher = b50Var.f7901a) == null) ? new ExecutorCoroutineDispatcherImpl(executor) : coroutineDispatcher;
    }
}
