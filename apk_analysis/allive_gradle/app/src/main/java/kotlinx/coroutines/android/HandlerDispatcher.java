package kotlinx.coroutines.android;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m5568d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u00012\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00008&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0001\u0001\u0006¨\u0006\u0007"}, m5569d2 = {"Lkotlinx/coroutines/android/HandlerDispatcher;", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "getImmediate", "()Lkotlinx/coroutines/android/HandlerDispatcher;", "immediate", "Lkotlinx/coroutines/android/HandlerContext;", "kotlinx-coroutines-android"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public abstract class HandlerDispatcher extends MainCoroutineDispatcher implements Delay {
    public HandlerDispatcher(DefaultConstructorMarker defaultConstructorMarker) {
    }

    @Override // kotlinx.coroutines.Delay
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated without replacement as an internal method never intended for public use")
    @Nullable
    public Object delay(long j, @NotNull Continuation<? super Unit> continuation) {
        return Delay.DefaultImpls.delay(this, j, continuation);
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher
    @NotNull
    public abstract HandlerDispatcher getImmediate();

    @NotNull
    public DisposableHandle invokeOnTimeout(long j, @NotNull Runnable runnable, @NotNull CoroutineContext coroutineContext) {
        return Delay.DefaultImpls.invokeOnTimeout(this, j, runnable, coroutineContext);
    }
}
