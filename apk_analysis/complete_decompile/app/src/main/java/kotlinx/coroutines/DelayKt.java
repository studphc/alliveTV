package kotlinx.coroutines;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.Duration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.b51;
import p000.r82;
import p000.t10;

@Metadata(m5568d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0011\u0010\u0005\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a\u0019\u0010\u0000\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a!\u0010\u0000\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0086@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000b\u001a\u0019\u0010\u000f\u001a\u00020\n*\u00020\rH\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0012"}, m5569d2 = {"delay", "Lkotlinx/coroutines/Delay;", "Lkotlin/coroutines/CoroutineContext;", "getDelay", "(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/Delay;", "awaitCancellation", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "timeMillis", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", TypedValues.TransitionType.S_DURATION, "Lkotlin/time/Duration;", "delay-VtjQ1oo", "toDelayMillis", "toDelayMillis-LRDsOJo", "(J)J", "kotlinx-coroutines-core"}, m5570k = 2, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/DelayKt\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,162:1\n314#2,11:163\n314#2,11:174\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/DelayKt\n*L\n106#1:163,11\n127#1:174,11\n*E\n"})
/* loaded from: classes2.dex */
public final class DelayKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object awaitCancellation(@NotNull Continuation<?> continuation) {
        t10 t10Var;
        int i;
        if (continuation instanceof t10) {
            t10 t10Var2 = (t10) continuation;
            int i2 = t10Var2.f26657e;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                t10Var2.f26657e = i2 - Integer.MIN_VALUE;
                t10Var = t10Var2;
                Object obj = t10Var.f26656d;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = t10Var.f26657e;
                if (i == 0) {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    t10Var.f26657e = 1;
                    CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(t10Var), 1);
                    cancellableContinuationImpl.initCancellability();
                    Object result = cancellableContinuationImpl.getResult();
                    if (result == b51.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended(t10Var);
                    }
                    if (result == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                throw new KotlinNothingValueException();
            }
        }
        t10Var = new ContinuationImpl(continuation);
        Object obj2 = t10Var.f26656d;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = t10Var.f26657e;
        if (i == 0) {
        }
        throw new KotlinNothingValueException();
    }

    @Nullable
    public static final Object delay(long j, @NotNull Continuation<? super Unit> continuation) {
        if (j <= 0) {
            return Unit.INSTANCE;
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        if (j < Long.MAX_VALUE) {
            getDelay(cancellableContinuationImpl.getContext()).scheduleResumeAfterDelay(j, cancellableContinuationImpl);
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == b51.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        if (result == b51.getCOROUTINE_SUSPENDED()) {
            return result;
        }
        return Unit.INSTANCE;
    }

    @Nullable
    /* renamed from: delay-VtjQ1oo, reason: not valid java name */
    public static final Object m8849delayVtjQ1oo(long j, @NotNull Continuation<? super Unit> continuation) {
        Object delay = delay(m8850toDelayMillisLRDsOJo(j), continuation);
        if (delay == b51.getCOROUTINE_SUSPENDED()) {
            return delay;
        }
        return Unit.INSTANCE;
    }

    @NotNull
    public static final Delay getDelay(@NotNull CoroutineContext coroutineContext) {
        Delay delay;
        CoroutineContext.Element element = coroutineContext.get(ContinuationInterceptor.INSTANCE);
        if (element instanceof Delay) {
            delay = (Delay) element;
        } else {
            delay = null;
        }
        if (delay == null) {
            return DefaultExecutorKt.getDefaultDelay();
        }
        return delay;
    }

    /* renamed from: toDelayMillis-LRDsOJo, reason: not valid java name */
    public static final long m8850toDelayMillisLRDsOJo(long j) {
        if (Duration.m8718compareToLRDsOJo(j, Duration.INSTANCE.m8795getZEROUwyO8pc()) > 0) {
            return r82.coerceAtLeast(Duration.m8737getInWholeMillisecondsimpl(j), 1L);
        }
        return 0L;
    }
}
