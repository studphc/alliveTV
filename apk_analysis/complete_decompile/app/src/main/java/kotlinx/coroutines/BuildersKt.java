package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.C1871ug;
import p000.b51;
import p000.r71;
import p000.w71;

@Metadata(m5568d1 = {}, m5569d2 = {}, m5570k = 4, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class BuildersKt {
    @NotNull
    public static final <T> Deferred<T> async(@NotNull CoroutineScope coroutineScope, @NotNull CoroutineContext coroutineContext, @NotNull CoroutineStart coroutineStart, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) {
        r71 r71Var;
        CoroutineContext newCoroutineContext = CoroutineContextKt.newCoroutineContext(coroutineScope, coroutineContext);
        if (coroutineStart.isLazy()) {
            r71Var = new r71(newCoroutineContext, function2);
        } else {
            r71Var = (Deferred<T>) new AbstractCoroutine(newCoroutineContext, true, true);
        }
        ((AbstractCoroutine) r71Var).start(coroutineStart, r71Var, function2);
        return (Deferred<T>) r71Var;
    }

    public static /* synthetic */ Deferred async$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return async(coroutineScope, coroutineContext, coroutineStart, function2);
    }

    @Nullable
    public static final <T> Object invoke(@NotNull CoroutineDispatcher coroutineDispatcher, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        return withContext(coroutineDispatcher, function2, continuation);
    }

    @NotNull
    public static final Job launch(@NotNull CoroutineScope coroutineScope, @NotNull CoroutineContext coroutineContext, @NotNull CoroutineStart coroutineStart, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        AbstractCoroutine abstractCoroutine;
        CoroutineContext newCoroutineContext = CoroutineContextKt.newCoroutineContext(coroutineScope, coroutineContext);
        if (coroutineStart.isLazy()) {
            abstractCoroutine = new w71(newCoroutineContext, function2);
        } else {
            abstractCoroutine = new AbstractCoroutine(newCoroutineContext, true, true);
        }
        abstractCoroutine.start(coroutineStart, abstractCoroutine, function2);
        return abstractCoroutine;
    }

    public static /* synthetic */ Job launch$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return launch(coroutineScope, coroutineContext, coroutineStart, function2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x0032, code lost:
    
        if (r1 == null) goto L88;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> T runBlocking(@NotNull CoroutineContext coroutineContext, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) {
        EventLoop eventLoop;
        CoroutineContext newCoroutineContext;
        long j;
        Unit unit;
        Thread currentThread = Thread.currentThread();
        ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) coroutineContext.get(ContinuationInterceptor.INSTANCE);
        CompletedExceptionally completedExceptionally = null;
        if (continuationInterceptor == null) {
            eventLoop = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
            newCoroutineContext = CoroutineContextKt.newCoroutineContext(GlobalScope.INSTANCE, coroutineContext.plus(eventLoop));
        } else {
            if (continuationInterceptor instanceof EventLoop) {
                eventLoop = (EventLoop) continuationInterceptor;
            } else {
                eventLoop = null;
            }
            if (eventLoop != null) {
                if (!eventLoop.shouldBeProcessedFromContext()) {
                    eventLoop = null;
                }
            }
            eventLoop = ThreadLocalEventLoop.INSTANCE.currentOrNull$kotlinx_coroutines_core();
            newCoroutineContext = CoroutineContextKt.newCoroutineContext(GlobalScope.INSTANCE, coroutineContext);
        }
        C1871ug c1871ug = new C1871ug(newCoroutineContext, currentThread, eventLoop);
        c1871ug.start(CoroutineStart.DEFAULT, c1871ug, function2);
        AbstractTimeSource timeSource = AbstractTimeSourceKt.getTimeSource();
        if (timeSource != null) {
            timeSource.registerTimeLoopThread();
        }
        EventLoop eventLoop2 = c1871ug.f27252e;
        if (eventLoop2 != null) {
            try {
                EventLoop.incrementUseCount$default(eventLoop2, false, 1, null);
            } finally {
                AbstractTimeSource timeSource2 = AbstractTimeSourceKt.getTimeSource();
                if (timeSource2 != null) {
                    timeSource2.unregisterTimeLoopThread();
                }
            }
        }
        while (!Thread.interrupted()) {
            try {
                if (eventLoop2 != null) {
                    j = eventLoop2.processNextEvent();
                } else {
                    j = Long.MAX_VALUE;
                }
                if (!c1871ug.isCompleted()) {
                    AbstractTimeSource timeSource3 = AbstractTimeSourceKt.getTimeSource();
                    if (timeSource3 != null) {
                        timeSource3.parkNanos(c1871ug, j);
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                    if (unit == null) {
                        LockSupport.parkNanos(c1871ug, j);
                    }
                } else {
                    if (eventLoop2 != null) {
                        EventLoop.decrementUseCount$default(eventLoop2, false, 1, null);
                    }
                    T t = (T) JobSupportKt.unboxState(c1871ug.getState$kotlinx_coroutines_core());
                    if (t instanceof CompletedExceptionally) {
                        completedExceptionally = (CompletedExceptionally) t;
                    }
                    if (completedExceptionally == null) {
                        return t;
                    }
                    throw completedExceptionally.cause;
                }
            } catch (Throwable th) {
                if (eventLoop2 != null) {
                    EventLoop.decrementUseCount$default(eventLoop2, false, 1, null);
                }
                throw th;
            }
        }
        InterruptedException interruptedException = new InterruptedException();
        c1871ug.cancelCoroutine(interruptedException);
        throw interruptedException;
    }

    public static /* synthetic */ Object runBlocking$default(CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return runBlocking(coroutineContext, function2);
    }

    @Nullable
    public static final <T> Object withContext(@NotNull CoroutineContext coroutineContext, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        Object result$kotlinx_coroutines_core;
        CoroutineContext context = continuation.getContext();
        CoroutineContext newCoroutineContext = CoroutineContextKt.newCoroutineContext(context, coroutineContext);
        JobKt.ensureActive(newCoroutineContext);
        if (newCoroutineContext == context) {
            ScopeCoroutine scopeCoroutine = new ScopeCoroutine(newCoroutineContext, continuation);
            result$kotlinx_coroutines_core = UndispatchedKt.startUndispatchedOrReturn(scopeCoroutine, scopeCoroutine, function2);
        } else {
            ContinuationInterceptor.Companion companion = ContinuationInterceptor.INSTANCE;
            if (Intrinsics.areEqual(newCoroutineContext.get(companion), context.get(companion))) {
                UndispatchedCoroutine undispatchedCoroutine = new UndispatchedCoroutine(newCoroutineContext, continuation);
                CoroutineContext context2 = undispatchedCoroutine.getContext();
                Object updateThreadContext = ThreadContextKt.updateThreadContext(context2, null);
                try {
                    Object startUndispatchedOrReturn = UndispatchedKt.startUndispatchedOrReturn(undispatchedCoroutine, undispatchedCoroutine, function2);
                    ThreadContextKt.restoreThreadContext(context2, updateThreadContext);
                    result$kotlinx_coroutines_core = startUndispatchedOrReturn;
                } catch (Throwable th) {
                    ThreadContextKt.restoreThreadContext(context2, updateThreadContext);
                    throw th;
                }
            } else {
                DispatchedCoroutine dispatchedCoroutine = new DispatchedCoroutine(newCoroutineContext, continuation);
                CancellableKt.startCoroutineCancellable$default(function2, dispatchedCoroutine, dispatchedCoroutine, null, 4, null);
                result$kotlinx_coroutines_core = dispatchedCoroutine.getResult$kotlinx_coroutines_core();
            }
        }
        if (result$kotlinx_coroutines_core == b51.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result$kotlinx_coroutines_core;
    }
}
