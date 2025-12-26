package kotlinx.coroutines;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.Delay;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.b51;

@InternalCoroutinesApi
@Metadata(m5568d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u001d\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\b"}, m5569d2 = {"Lkotlinx/coroutines/DelayWithTimeoutDiagnostics;", "Lkotlinx/coroutines/Delay;", "timeoutMessage", "", "timeout", "Lkotlin/time/Duration;", "timeoutMessage-LRDsOJo", "(J)Ljava/lang/String;", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public interface DelayWithTimeoutDiagnostics extends Delay {

    @Metadata(m5570k = 3, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated without replacement as an internal method never intended for public use")
        @Nullable
        public static Object delay(@NotNull DelayWithTimeoutDiagnostics delayWithTimeoutDiagnostics, long j, @NotNull Continuation<? super Unit> continuation) {
            Object delay = Delay.DefaultImpls.delay(delayWithTimeoutDiagnostics, j, continuation);
            if (delay == b51.getCOROUTINE_SUSPENDED()) {
                return delay;
            }
            return Unit.INSTANCE;
        }

        @NotNull
        public static DisposableHandle invokeOnTimeout(@NotNull DelayWithTimeoutDiagnostics delayWithTimeoutDiagnostics, long j, @NotNull Runnable runnable, @NotNull CoroutineContext coroutineContext) {
            return Delay.DefaultImpls.invokeOnTimeout(delayWithTimeoutDiagnostics, j, runnable, coroutineContext);
        }
    }

    @NotNull
    /* renamed from: timeoutMessage-LRDsOJo, reason: not valid java name */
    String m8851timeoutMessageLRDsOJo(long timeout);
}
