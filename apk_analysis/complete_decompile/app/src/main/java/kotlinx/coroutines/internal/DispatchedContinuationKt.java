package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CompletionStateKt;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.ThreadLocalEventLoop;
import kotlinx.coroutines.UndispatchedCoroutine;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m5568d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aW\u0010\u000b\u001a\u00020\t\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022%\b\u0002\u0010\n\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u0019\u0010\u000f\u001a\u00020\u000e*\b\u0012\u0004\u0012\u00020\t0\rH\u0000¢\u0006\u0004\b\u000f\u0010\u0010\"\u0014\u0010\u0012\u001a\u00020\u00118\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, m5569d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/coroutines/Continuation;", "Lkotlin/Result;", "result", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "cause", "", "onCancellation", "resumeCancellableWith", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/internal/DispatchedContinuation;", "", "yieldUndispatched", "(Lkotlinx/coroutines/internal/DispatchedContinuation;)Z", "Lkotlinx/coroutines/internal/Symbol;", "REUSABLE_CLAIMED", "Lkotlinx/coroutines/internal/Symbol;", "kotlinx-coroutines-core"}, m5570k = 2, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nDispatchedContinuation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DispatchedContinuation.kt\nkotlinx/coroutines/internal/DispatchedContinuationKt\n+ 2 DispatchedContinuation.kt\nkotlinx/coroutines/internal/DispatchedContinuation\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTaskKt\n+ 5 CoroutineContext.kt\nkotlinx/coroutines/CoroutineContextKt\n*L\n1#1,317:1\n297#1,5:325\n302#1,12:331\n314#1:387\n301#1:389\n302#1,12:391\n314#1:420\n217#2,7:318\n224#2:346\n243#2,8:347\n225#2:355\n255#2:356\n256#2,2:367\n258#2:371\n227#2:372\n229#2:388\n1#3:330\n1#3:390\n1#3:421\n200#4,3:343\n203#4,14:373\n200#4,17:403\n200#4,17:422\n107#5,10:357\n118#5,2:369\n*S KotlinDebug\n*F\n+ 1 DispatchedContinuation.kt\nkotlinx/coroutines/internal/DispatchedContinuationKt\n*L\n282#1:325,5\n282#1:331,12\n282#1:387\n287#1:389\n287#1:391,12\n287#1:420\n282#1:318,7\n282#1:346\n282#1:347,8\n282#1:355\n282#1:356\n282#1:367,2\n282#1:371\n282#1:372\n282#1:388\n282#1:330\n287#1:390\n282#1:343,3\n282#1:373,14\n287#1:403,17\n313#1:422,17\n282#1:357,10\n282#1:369,2\n*E\n"})
/* loaded from: classes2.dex */
public final class DispatchedContinuationKt {

    /* renamed from: a */
    public static final Symbol f22012a = new Symbol("UNDEFINED");

    @JvmField
    @NotNull
    public static final Symbol REUSABLE_CLAIMED = new Symbol("REUSABLE_CLAIMED");

    public static final /* synthetic */ Symbol access$getUNDEFINED$p() {
        return f22012a;
    }

    @InternalCoroutinesApi
    public static final <T> void resumeCancellableWith(@NotNull Continuation<? super T> continuation, @NotNull Object obj, @Nullable Function1<? super Throwable, Unit> function1) {
        UndispatchedCoroutine<?> undispatchedCoroutine;
        if (continuation instanceof DispatchedContinuation) {
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
            Object state = CompletionStateKt.toState(obj, function1);
            if (dispatchedContinuation.dispatcher.isDispatchNeeded(dispatchedContinuation.getContext())) {
                dispatchedContinuation._state = state;
                dispatchedContinuation.resumeMode = 1;
                dispatchedContinuation.dispatcher.dispatch(dispatchedContinuation.getContext(), dispatchedContinuation);
                return;
            }
            EventLoop eventLoop$kotlinx_coroutines_core = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
            if (eventLoop$kotlinx_coroutines_core.isUnconfinedLoopActive()) {
                dispatchedContinuation._state = state;
                dispatchedContinuation.resumeMode = 1;
                eventLoop$kotlinx_coroutines_core.dispatchUnconfined(dispatchedContinuation);
                return;
            }
            eventLoop$kotlinx_coroutines_core.incrementUseCount(true);
            try {
                Job job = (Job) dispatchedContinuation.getContext().get(Job.INSTANCE);
                if (job != null && !job.isActive()) {
                    CancellationException cancellationException = job.getCancellationException();
                    dispatchedContinuation.cancelCompletedResult$kotlinx_coroutines_core(state, cancellationException);
                    Result.Companion companion = Result.INSTANCE;
                    dispatchedContinuation.resumeWith(Result.m8512constructorimpl(ResultKt.createFailure(cancellationException)));
                } else {
                    Continuation<T> continuation2 = dispatchedContinuation.continuation;
                    Object obj2 = dispatchedContinuation.countOrElement;
                    CoroutineContext context = continuation2.getContext();
                    Object updateThreadContext = ThreadContextKt.updateThreadContext(context, obj2);
                    if (updateThreadContext != ThreadContextKt.NO_THREAD_ELEMENTS) {
                        undispatchedCoroutine = CoroutineContextKt.updateUndispatchedCompletion(continuation2, context, updateThreadContext);
                    } else {
                        undispatchedCoroutine = null;
                    }
                    try {
                        dispatchedContinuation.continuation.resumeWith(obj);
                    } finally {
                        if (undispatchedCoroutine == null || undispatchedCoroutine.clearThreadContext()) {
                            ThreadContextKt.restoreThreadContext(context, updateThreadContext);
                        }
                    }
                }
                do {
                } while (eventLoop$kotlinx_coroutines_core.processUnconfinedEvent());
            } finally {
                try {
                    return;
                } finally {
                }
            }
            return;
        }
        continuation.resumeWith(obj);
    }

    public static /* synthetic */ void resumeCancellableWith$default(Continuation continuation, Object obj, Function1 function1, int i, Object obj2) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        resumeCancellableWith(continuation, obj, function1);
    }

    public static final boolean yieldUndispatched(@NotNull DispatchedContinuation<? super Unit> dispatchedContinuation) {
        Unit unit = Unit.INSTANCE;
        EventLoop eventLoop$kotlinx_coroutines_core = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if (eventLoop$kotlinx_coroutines_core.isUnconfinedQueueEmpty()) {
            return false;
        }
        if (eventLoop$kotlinx_coroutines_core.isUnconfinedLoopActive()) {
            dispatchedContinuation._state = unit;
            dispatchedContinuation.resumeMode = 1;
            eventLoop$kotlinx_coroutines_core.dispatchUnconfined(dispatchedContinuation);
            return true;
        }
        eventLoop$kotlinx_coroutines_core.incrementUseCount(true);
        try {
            dispatchedContinuation.run();
            do {
            } while (eventLoop$kotlinx_coroutines_core.processUnconfinedEvent());
        } finally {
            try {
                return false;
            } finally {
            }
        }
        return false;
    }
}
