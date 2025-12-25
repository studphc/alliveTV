package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.b51;
import p000.ut2;
import p000.xt2;

@Metadata(m5568d1 = {"\u0000<\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aW\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003¢\u0006\u0002\b\u0007H\u0086@ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\b\t\u0010\n\u001a]\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\f\u001a\u00020\u000b2'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003¢\u0006\u0002\b\u0007H\u0086@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\b\r\u0010\n\u001aL\u0010\u000e\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003¢\u0006\u0002\b\u0007H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\n\u001aR\u0010\u000e\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\f\u001a\u00020\u000b2'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003¢\u0006\u0002\b\u0007H\u0086@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\n\u001a'\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0018"}, m5569d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "timeMillis", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "block", "withTimeout", "(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/time/Duration;", "timeout", "withTimeout-KLykuaI", "withTimeoutOrNull", "withTimeoutOrNull-KLykuaI", "time", "Lkotlinx/coroutines/Delay;", "delay", "Lkotlinx/coroutines/Job;", "coroutine", "Lkotlinx/coroutines/TimeoutCancellationException;", "TimeoutCancellationException", "(JLkotlinx/coroutines/Delay;Lkotlinx/coroutines/Job;)Lkotlinx/coroutines/TimeoutCancellationException;", "kotlinx-coroutines-core"}, m5570k = 2, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class TimeoutKt {
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0016, code lost:
    
        if (r4 == null) goto L9;
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final TimeoutCancellationException TimeoutCancellationException(long j, @NotNull Delay delay, @NotNull Job job) {
        DelayWithTimeoutDiagnostics delayWithTimeoutDiagnostics;
        String str;
        if (delay instanceof DelayWithTimeoutDiagnostics) {
            delayWithTimeoutDiagnostics = (DelayWithTimeoutDiagnostics) delay;
        } else {
            delayWithTimeoutDiagnostics = null;
        }
        if (delayWithTimeoutDiagnostics != null) {
            Duration.Companion companion = Duration.INSTANCE;
            str = delayWithTimeoutDiagnostics.m8851timeoutMessageLRDsOJo(DurationKt.toDuration(j, DurationUnit.MILLISECONDS));
        }
        str = "Timed out waiting for " + j + " ms";
        return new TimeoutCancellationException(str, job);
    }

    @Nullable
    public static final <T> Object withTimeout(long j, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        if (j > 0) {
            ut2 ut2Var = new ut2(j, continuation);
            JobKt.disposeOnCompletion(ut2Var, DelayKt.getDelay(ut2Var.uCont.getF20923a()).invokeOnTimeout(ut2Var.f27441d, ut2Var, ut2Var.getF20923a()));
            Object startUndispatchedOrReturnIgnoreTimeout = UndispatchedKt.startUndispatchedOrReturnIgnoreTimeout(ut2Var, ut2Var, function2);
            if (startUndispatchedOrReturnIgnoreTimeout == b51.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return startUndispatchedOrReturnIgnoreTimeout;
        }
        throw new TimeoutCancellationException("Timed out immediately");
    }

    @Nullable
    /* renamed from: withTimeout-KLykuaI, reason: not valid java name */
    public static final <T> Object m8856withTimeoutKLykuaI(long j, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        return withTimeout(DelayKt.m8850toDelayMillisLRDsOJo(j), function2, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0089 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Type inference failed for: r2v1, types: [ut2, kotlinx.coroutines.AbstractCoroutine, T, kotlinx.coroutines.Job, kotlinx.coroutines.internal.ScopeCoroutine, java.lang.Object, java.lang.Runnable] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object withTimeoutOrNull(long j, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        xt2 xt2Var;
        int i;
        Ref.ObjectRef objectRef;
        if (continuation instanceof xt2) {
            xt2 xt2Var2 = (xt2) continuation;
            int i2 = xt2Var2.f28736g;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                xt2Var2.f28736g = i2 - Integer.MIN_VALUE;
                xt2Var = xt2Var2;
                Object obj = xt2Var.f28735f;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = xt2Var.f28736g;
                if (i == 0) {
                    if (i == 1) {
                        objectRef = xt2Var.f28734e;
                        try {
                            ResultKt.throwOnFailure(obj);
                            return obj;
                        } catch (TimeoutCancellationException e) {
                            e = e;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    if (j <= 0) {
                        return null;
                    }
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    try {
                        xt2Var.f28733d = function2;
                        xt2Var.f28734e = objectRef2;
                        xt2Var.f28736g = 1;
                        ?? r2 = (T) new ut2(j, xt2Var);
                        objectRef2.element = r2;
                        try {
                            JobKt.disposeOnCompletion(r2, DelayKt.getDelay(r2.uCont.getF20923a()).invokeOnTimeout(r2.f27441d, r2, r2.getF20923a()));
                            Object startUndispatchedOrReturnIgnoreTimeout = UndispatchedKt.startUndispatchedOrReturnIgnoreTimeout(r2, r2, function2);
                            if (startUndispatchedOrReturnIgnoreTimeout == b51.getCOROUTINE_SUSPENDED()) {
                                DebugProbesKt.probeCoroutineSuspended(xt2Var);
                            }
                            if (startUndispatchedOrReturnIgnoreTimeout == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return startUndispatchedOrReturnIgnoreTimeout;
                        } catch (TimeoutCancellationException e2) {
                            e = e2;
                            objectRef = objectRef2;
                            if (e.coroutine == objectRef.element) {
                            }
                        }
                    } catch (TimeoutCancellationException e3) {
                        e = e3;
                    }
                }
                if (e.coroutine == objectRef.element) {
                    return null;
                }
                throw e;
            }
        }
        xt2Var = new ContinuationImpl(continuation);
        Object obj2 = xt2Var.f28735f;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = xt2Var.f28736g;
        if (i == 0) {
        }
        if (e.coroutine == objectRef.element) {
        }
    }

    @Nullable
    /* renamed from: withTimeoutOrNull-KLykuaI, reason: not valid java name */
    public static final <T> Object m8857withTimeoutOrNullKLykuaI(long j, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        return withTimeoutOrNull(DelayKt.m8850toDelayMillisLRDsOJo(j), function2, continuation);
    }
}
