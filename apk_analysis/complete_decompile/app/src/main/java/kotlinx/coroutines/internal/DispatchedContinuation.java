package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmField;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletedWithCancellation;
import kotlinx.coroutines.CompletionStateKt;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.DispatchedTask;
import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.ThreadLocalEventLoop;
import kotlinx.coroutines.UndispatchedCoroutine;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m5568d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u00042\b\u0012\u0004\u0012\u00028\u00000\u0005B\u001d\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0012\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0016\u001a\u00020\u0013H\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0018\u001a\u00020\u0013H\u0000¢\u0006\u0004\b\u0017\u0010\u0015J\u0017\u0010\u001c\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0019H\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010!\u001a\u0004\u0018\u00010\u001e2\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u001dH\u0000¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010%\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u001eH\u0000¢\u0006\u0004\b#\u0010$J\u0011\u0010)\u001a\u0004\u0018\u00010&H\u0010¢\u0006\u0004\b'\u0010(J \u0010,\u001a\u00020\u00132\f\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000*H\u0016ø\u0001\u0000¢\u0006\u0004\b,\u0010-JH\u00104\u001a\u00020\u00132\f\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000*2%\b\b\u00101\u001a\u001f\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u0013\u0018\u00010.H\u0080\bø\u0001\u0000¢\u0006\u0004\b2\u00103J!\u00108\u001a\u00020\u00132\b\u00105\u001a\u0004\u0018\u00010&2\u0006\u0010\"\u001a\u00020\u001eH\u0010¢\u0006\u0004\b6\u00107J\u001a\u0010<\u001a\u00020\u000f2\b\u00109\u001a\u0004\u0018\u00010&H\u0080\b¢\u0006\u0004\b:\u0010;J!\u0010>\u001a\u00020\u00132\f\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000*H\u0080\bø\u0001\u0000¢\u0006\u0004\b=\u0010-J\u001f\u0010D\u001a\u00020\u00132\u0006\u0010@\u001a\u00020?2\u0006\u0010A\u001a\u00028\u0000H\u0000¢\u0006\u0004\bB\u0010CJ\u000f\u0010F\u001a\u00020EH\u0016¢\u0006\u0004\bF\u0010GR\u0014\u0010\u0007\u001a\u00020\u00068\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010HR\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\b\u0010IR\u001e\u0010J\u001a\u0004\u0018\u00010&8\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\bJ\u0010K\u0012\u0004\bL\u0010\u0015R\u0014\u0010M\u001a\u00020&8\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\bM\u0010KR\u0014\u0010@\u001a\u00020?8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bN\u0010OR\u001c\u0010R\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bP\u0010QR\u001a\u0010U\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058PX\u0090\u0004¢\u0006\u0006\u001a\u0004\bS\u0010TR\u0013\u0010W\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010&0V8\u0002X\u0082\u0004\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006X"}, m5569d2 = {"Lkotlinx/coroutines/internal/DispatchedContinuation;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/DispatchedTask;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "Lkotlin/coroutines/Continuation;", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "continuation", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/coroutines/Continuation;)V", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "", "isReusable$kotlinx_coroutines_core", "()Z", "isReusable", "", "awaitReusability$kotlinx_coroutines_core", "()V", "awaitReusability", "release$kotlinx_coroutines_core", "release", "Lkotlinx/coroutines/CancellableContinuationImpl;", "claimReusableCancellableContinuation$kotlinx_coroutines_core", "()Lkotlinx/coroutines/CancellableContinuationImpl;", "claimReusableCancellableContinuation", "Lkotlinx/coroutines/CancellableContinuation;", "", "tryReleaseClaimedContinuation$kotlinx_coroutines_core", "(Lkotlinx/coroutines/CancellableContinuation;)Ljava/lang/Throwable;", "tryReleaseClaimedContinuation", "cause", "postponeCancellation$kotlinx_coroutines_core", "(Ljava/lang/Throwable;)Z", "postponeCancellation", "", "takeState$kotlinx_coroutines_core", "()Ljava/lang/Object;", "takeState", "Lkotlin/Result;", "result", "resumeWith", "(Ljava/lang/Object;)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "onCancellation", "resumeCancellableWith$kotlinx_coroutines_core", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "resumeCancellableWith", "takenState", "cancelCompletedResult$kotlinx_coroutines_core", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "cancelCompletedResult", "state", "resumeCancelled$kotlinx_coroutines_core", "(Ljava/lang/Object;)Z", "resumeCancelled", "resumeUndispatchedWith$kotlinx_coroutines_core", "resumeUndispatchedWith", "Lkotlin/coroutines/CoroutineContext;", "context", "value", "dispatchYield$kotlinx_coroutines_core", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V", "dispatchYield", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlin/coroutines/Continuation;", "_state", "Ljava/lang/Object;", "get_state$kotlinx_coroutines_core$annotations", "countOrElement", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "delegate", "Lkotlinx/atomicfu/AtomicRef;", "_reusableCancellableContinuation", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@PublishedApi
@SourceDebugExtension({"SMAP\nDispatchedContinuation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DispatchedContinuation.kt\nkotlinx/coroutines/internal/DispatchedContinuation\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 DispatchedContinuation.kt\nkotlinx/coroutines/internal/DispatchedContinuationKt\n+ 4 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTaskKt\n+ 5 CoroutineContext.kt\nkotlinx/coroutines/CoroutineContextKt\n*L\n1#1,317:1\n243#1,8:381\n255#1:389\n256#1,2:400\n258#1:404\n1#2:318\n1#2:324\n1#2:365\n297#3,5:319\n302#3,12:325\n314#3:359\n297#3,5:360\n302#3,12:366\n314#3:419\n200#4,3:337\n203#4,14:345\n200#4,3:378\n203#4,14:405\n95#5,5:340\n107#5,10:390\n118#5,2:402\n107#5,13:420\n*S KotlinDebug\n*F\n+ 1 DispatchedContinuation.kt\nkotlinx/coroutines/internal/DispatchedContinuation\n*L\n224#1:381,8\n225#1:389\n225#1:400,2\n225#1:404\n202#1:324\n223#1:365\n202#1:319,5\n202#1:325,12\n202#1:359\n223#1:360,5\n223#1:366,12\n223#1:419\n202#1:337,3\n202#1:345,14\n223#1:378,3\n223#1:405,14\n203#1:340,5\n225#1:390,10\n225#1:402,2\n255#1:420,13\n*E\n"})
/* loaded from: classes2.dex */
public final class DispatchedContinuation<T> extends DispatchedTask<T> implements CoroutineStackFrame, Continuation<T> {

    /* renamed from: a */
    public static final AtomicReferenceFieldUpdater f22011a = AtomicReferenceFieldUpdater.newUpdater(DispatchedContinuation.class, Object.class, "_reusableCancellableContinuation");

    @Volatile
    @Nullable
    private volatile Object _reusableCancellableContinuation;

    @JvmField
    @Nullable
    public Object _state;

    @JvmField
    @NotNull
    public final Continuation<T> continuation;

    @JvmField
    @NotNull
    public final Object countOrElement;

    @JvmField
    @NotNull
    public final CoroutineDispatcher dispatcher;

    /* JADX WARN: Multi-variable type inference failed */
    public DispatchedContinuation(@NotNull CoroutineDispatcher coroutineDispatcher, @NotNull Continuation<? super T> continuation) {
        super(-1);
        this.dispatcher = coroutineDispatcher;
        this.continuation = continuation;
        this._state = DispatchedContinuationKt.access$getUNDEFINED$p();
        this.countOrElement = ThreadContextKt.threadContextElements(getContext());
    }

    public static /* synthetic */ void get_state$kotlinx_coroutines_core$annotations() {
    }

    public final void awaitReusability$kotlinx_coroutines_core() {
        do {
        } while (f22011a.get(this) == DispatchedContinuationKt.REUSABLE_CLAIMED);
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public void cancelCompletedResult$kotlinx_coroutines_core(@Nullable Object takenState, @NotNull Throwable cause) {
        if (takenState instanceof CompletedWithCancellation) {
            ((CompletedWithCancellation) takenState).onCancellation.invoke(cause);
        }
    }

    @Nullable
    public final CancellableContinuationImpl<T> claimReusableCancellableContinuation$kotlinx_coroutines_core() {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f22011a;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                atomicReferenceFieldUpdater.set(this, DispatchedContinuationKt.REUSABLE_CLAIMED);
                return null;
            }
            if (obj instanceof CancellableContinuationImpl) {
                Symbol symbol = DispatchedContinuationKt.REUSABLE_CLAIMED;
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, symbol)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                        break;
                    }
                }
                return (CancellableContinuationImpl) obj;
            }
            if (obj != DispatchedContinuationKt.REUSABLE_CLAIMED && !(obj instanceof Throwable)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        }
    }

    public final void dispatchYield$kotlinx_coroutines_core(@NotNull CoroutineContext context, T value) {
        this._state = value;
        this.resumeMode = 1;
        this.dispatcher.dispatchYield(context, this);
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @Nullable
    public CoroutineStackFrame getCallerFrame() {
        Continuation<T> continuation = this.continuation;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    @NotNull
    public CoroutineContext getContext() {
        return this.continuation.getContext();
    }

    @Override // kotlinx.coroutines.DispatchedTask
    @NotNull
    public Continuation<T> getDelegate$kotlinx_coroutines_core() {
        return this;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @Nullable
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    public final boolean isReusable$kotlinx_coroutines_core() {
        if (f22011a.get(this) != null) {
            return true;
        }
        return false;
    }

    public final boolean postponeCancellation$kotlinx_coroutines_core(@NotNull Throwable cause) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f22011a;
            Object obj = atomicReferenceFieldUpdater.get(this);
            Symbol symbol = DispatchedContinuationKt.REUSABLE_CLAIMED;
            if (Intrinsics.areEqual(obj, symbol)) {
                while (!atomicReferenceFieldUpdater.compareAndSet(this, symbol, cause)) {
                    if (atomicReferenceFieldUpdater.get(this) != symbol) {
                        break;
                    }
                }
                return true;
            }
            if (obj instanceof Throwable) {
                return true;
            }
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, null)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    break;
                }
            }
            return false;
        }
    }

    public final void release$kotlinx_coroutines_core() {
        CancellableContinuationImpl cancellableContinuationImpl;
        awaitReusability$kotlinx_coroutines_core();
        Object obj = f22011a.get(this);
        if (obj instanceof CancellableContinuationImpl) {
            cancellableContinuationImpl = (CancellableContinuationImpl) obj;
        } else {
            cancellableContinuationImpl = null;
        }
        if (cancellableContinuationImpl != null) {
            cancellableContinuationImpl.detachChild$kotlinx_coroutines_core();
        }
    }

    public final void resumeCancellableWith$kotlinx_coroutines_core(@NotNull Object result, @Nullable Function1<? super Throwable, Unit> onCancellation) {
        UndispatchedCoroutine<?> undispatchedCoroutine;
        Object state = CompletionStateKt.toState(result, onCancellation);
        if (this.dispatcher.isDispatchNeeded(getContext())) {
            this._state = state;
            this.resumeMode = 1;
            this.dispatcher.dispatch(getContext(), this);
            return;
        }
        EventLoop eventLoop$kotlinx_coroutines_core = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if (eventLoop$kotlinx_coroutines_core.isUnconfinedLoopActive()) {
            this._state = state;
            this.resumeMode = 1;
            eventLoop$kotlinx_coroutines_core.dispatchUnconfined(this);
            return;
        }
        eventLoop$kotlinx_coroutines_core.incrementUseCount(true);
        try {
            Job job = (Job) getContext().get(Job.INSTANCE);
            if (job != null && !job.isActive()) {
                CancellationException cancellationException = job.getCancellationException();
                cancelCompletedResult$kotlinx_coroutines_core(state, cancellationException);
                Result.Companion companion = Result.INSTANCE;
                resumeWith(Result.m8512constructorimpl(ResultKt.createFailure(cancellationException)));
            } else {
                Continuation<T> continuation = this.continuation;
                Object obj = this.countOrElement;
                CoroutineContext context = continuation.getContext();
                Object updateThreadContext = ThreadContextKt.updateThreadContext(context, obj);
                if (updateThreadContext != ThreadContextKt.NO_THREAD_ELEMENTS) {
                    undispatchedCoroutine = CoroutineContextKt.updateUndispatchedCompletion(continuation, context, updateThreadContext);
                } else {
                    undispatchedCoroutine = null;
                }
                try {
                    this.continuation.resumeWith(result);
                } finally {
                    InlineMarker.finallyStart(1);
                    if (undispatchedCoroutine == null || undispatchedCoroutine.clearThreadContext()) {
                        ThreadContextKt.restoreThreadContext(context, updateThreadContext);
                    }
                    InlineMarker.finallyEnd(1);
                }
            }
            do {
            } while (eventLoop$kotlinx_coroutines_core.processUnconfinedEvent());
            InlineMarker.finallyStart(1);
        } catch (Throwable th) {
            try {
                handleFatalException$kotlinx_coroutines_core(th, null);
                InlineMarker.finallyStart(1);
            } catch (Throwable th2) {
                InlineMarker.finallyStart(1);
                eventLoop$kotlinx_coroutines_core.decrementUseCount(true);
                InlineMarker.finallyEnd(1);
                throw th2;
            }
        }
        eventLoop$kotlinx_coroutines_core.decrementUseCount(true);
        InlineMarker.finallyEnd(1);
    }

    public final boolean resumeCancelled$kotlinx_coroutines_core(@Nullable Object state) {
        Job job = (Job) getContext().get(Job.INSTANCE);
        if (job != null && !job.isActive()) {
            CancellationException cancellationException = job.getCancellationException();
            cancelCompletedResult$kotlinx_coroutines_core(state, cancellationException);
            Result.Companion companion = Result.INSTANCE;
            resumeWith(Result.m8512constructorimpl(ResultKt.createFailure(cancellationException)));
            return true;
        }
        return false;
    }

    public final void resumeUndispatchedWith$kotlinx_coroutines_core(@NotNull Object result) {
        UndispatchedCoroutine<?> undispatchedCoroutine;
        Continuation<T> continuation = this.continuation;
        Object obj = this.countOrElement;
        CoroutineContext context = continuation.getContext();
        Object updateThreadContext = ThreadContextKt.updateThreadContext(context, obj);
        if (updateThreadContext != ThreadContextKt.NO_THREAD_ELEMENTS) {
            undispatchedCoroutine = CoroutineContextKt.updateUndispatchedCompletion(continuation, context, updateThreadContext);
        } else {
            undispatchedCoroutine = null;
        }
        try {
            this.continuation.resumeWith(result);
        } finally {
            InlineMarker.finallyStart(1);
            if (undispatchedCoroutine == null || undispatchedCoroutine.clearThreadContext()) {
                ThreadContextKt.restoreThreadContext(context, updateThreadContext);
            }
            InlineMarker.finallyEnd(1);
        }
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(@NotNull Object result) {
        CoroutineContext context = this.continuation.getContext();
        Object state$default = CompletionStateKt.toState$default(result, null, 1, null);
        if (this.dispatcher.isDispatchNeeded(context)) {
            this._state = state$default;
            this.resumeMode = 0;
            this.dispatcher.dispatch(context, this);
            return;
        }
        EventLoop eventLoop$kotlinx_coroutines_core = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if (eventLoop$kotlinx_coroutines_core.isUnconfinedLoopActive()) {
            this._state = state$default;
            this.resumeMode = 0;
            eventLoop$kotlinx_coroutines_core.dispatchUnconfined(this);
            return;
        }
        eventLoop$kotlinx_coroutines_core.incrementUseCount(true);
        try {
            CoroutineContext context2 = getContext();
            Object updateThreadContext = ThreadContextKt.updateThreadContext(context2, this.countOrElement);
            try {
                this.continuation.resumeWith(result);
                do {
                } while (eventLoop$kotlinx_coroutines_core.processUnconfinedEvent());
            } finally {
                ThreadContextKt.restoreThreadContext(context2, updateThreadContext);
            }
        } catch (Throwable th) {
            try {
                handleFatalException$kotlinx_coroutines_core(th, null);
            } finally {
                eventLoop$kotlinx_coroutines_core.decrementUseCount(true);
            }
        }
    }

    @Override // kotlinx.coroutines.DispatchedTask
    @Nullable
    public Object takeState$kotlinx_coroutines_core() {
        Object obj = this._state;
        this._state = DispatchedContinuationKt.access$getUNDEFINED$p();
        return obj;
    }

    @NotNull
    public String toString() {
        return "DispatchedContinuation[" + this.dispatcher + ", " + DebugStringsKt.toDebugString(this.continuation) + ']';
    }

    @Nullable
    public final Throwable tryReleaseClaimedContinuation$kotlinx_coroutines_core(@NotNull CancellableContinuation<?> continuation) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f22011a;
            Object obj = atomicReferenceFieldUpdater.get(this);
            Symbol symbol = DispatchedContinuationKt.REUSABLE_CLAIMED;
            if (obj != symbol) {
                if (!(obj instanceof Throwable)) {
                    throw new IllegalStateException(("Inconsistent state " + obj).toString());
                }
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, null)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                        throw new IllegalArgumentException("Failed requirement.");
                    }
                }
                return (Throwable) obj;
            }
            while (!atomicReferenceFieldUpdater.compareAndSet(this, symbol, continuation)) {
                if (atomicReferenceFieldUpdater.get(this) != symbol) {
                    break;
                }
            }
            return null;
        }
    }
}
