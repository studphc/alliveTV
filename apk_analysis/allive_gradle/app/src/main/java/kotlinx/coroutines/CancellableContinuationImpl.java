package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmName;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.C1486kt;
import p000.C1572n4;
import p000.C1986xk;
import p000.b51;

@Metadata(m5568d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0011\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\u00060\u0004j\u0002`\u00052\u00020\u0006B\u001d\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\n\u0018\u00010\u0013j\u0004\u0018\u0001`\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0011\u0010\u001a\u001a\u0004\u0018\u00010\u0017H\u0010¢\u0006\u0004\b\u0018\u0010\u0019J!\u0010 \u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001d\u001a\u00020\u001cH\u0010¢\u0006\u0004\b\u001e\u0010\u001fJ\u0019\u0010!\u001a\u00020\u00102\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001cH\u0000¢\u0006\u0004\b#\u0010$J\u001f\u0010(\u001a\u00020\r2\u0006\u0010'\u001a\u00020&2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b(\u0010)J8\u0010.\u001a\u00020\r2!\u0010-\u001a\u001d\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\r0*2\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b.\u0010/J\u0017\u00102\u001a\u00020\u001c2\u0006\u00101\u001a\u000200H\u0016¢\u0006\u0004\b2\u00103J\u0011\u00104\u001a\u0004\u0018\u00010\u0017H\u0001¢\u0006\u0004\b4\u0010\u0019J\u000f\u00106\u001a\u00020\rH\u0000¢\u0006\u0004\b5\u0010\u000fJ \u00109\u001a\u00020\r2\f\u00108\u001a\b\u0012\u0004\u0012\u00028\u000007H\u0016ø\u0001\u0000¢\u0006\u0004\b9\u0010:J<\u0010<\u001a\u00020\r2\u0006\u0010;\u001a\u00028\u00002#\u0010-\u001a\u001f\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\r\u0018\u00010*H\u0016¢\u0006\u0004\b<\u0010=J#\u0010A\u001a\u00020\r2\n\u0010?\u001a\u0006\u0012\u0002\b\u00030>2\u0006\u0010@\u001a\u00020\tH\u0016¢\u0006\u0004\bA\u0010BJ8\u0010A\u001a\u00020\r2'\u0010'\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\r0*j\u0002`CH\u0016¢\u0006\u0004\bA\u0010DJ\u000f\u0010F\u001a\u00020\rH\u0000¢\u0006\u0004\bE\u0010\u000fJ#\u0010H\u001a\u0004\u0018\u00010\u00172\u0006\u0010;\u001a\u00028\u00002\b\u0010G\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\bH\u0010IJH\u0010H\u001a\u0004\u0018\u00010\u00172\u0006\u0010;\u001a\u00028\u00002\b\u0010G\u001a\u0004\u0018\u00010\u00172#\u0010-\u001a\u001f\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\r\u0018\u00010*H\u0016¢\u0006\u0004\bH\u0010JJ\u0019\u0010L\u001a\u0004\u0018\u00010\u00172\u0006\u0010K\u001a\u00020\u001cH\u0016¢\u0006\u0004\bL\u0010MJ\u0017\u0010O\u001a\u00020\r2\u0006\u0010N\u001a\u00020\u0017H\u0016¢\u0006\u0004\bO\u0010:J\u001b\u0010Q\u001a\u00020\r*\u00020P2\u0006\u0010;\u001a\u00028\u0000H\u0016¢\u0006\u0004\bQ\u0010RJ\u001b\u0010S\u001a\u00020\r*\u00020P2\u0006\u0010K\u001a\u00020\u001cH\u0016¢\u0006\u0004\bS\u0010TJ\u001f\u0010X\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010U\u001a\u0004\u0018\u00010\u0017H\u0010¢\u0006\u0004\bV\u0010WJ\u001b\u0010[\u001a\u0004\u0018\u00010\u001c2\b\u0010U\u001a\u0004\u0018\u00010\u0017H\u0010¢\u0006\u0004\bY\u0010ZJ\u000f\u0010]\u001a\u00020\\H\u0016¢\u0006\u0004\b]\u0010^J\u000f\u0010_\u001a\u00020\\H\u0014¢\u0006\u0004\b_\u0010^R \u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078\u0000X\u0080\u0004¢\u0006\f\n\u0004\b`\u0010a\u001a\u0004\bb\u0010cR\u001a\u0010i\u001a\u00020d8\u0016X\u0096\u0004¢\u0006\f\n\u0004\be\u0010f\u001a\u0004\bg\u0010hR\u0016\u0010U\u001a\u0004\u0018\u00010\u00178@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bj\u0010\u0019R\u0014\u0010k\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bk\u0010\u0012R\u0014\u0010l\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bl\u0010\u0012R\u0014\u0010m\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bm\u0010\u0012R\u001c\u0010p\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bn\u0010oR\u000b\u0010r\u001a\u00020q8\u0002X\u0082\u0004R\u0013\u0010u\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010t0s8\u0002X\u0082\u0004R\u0013\u0010v\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170s8\u0002X\u0082\u0004\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006w"}, m5569d2 = {"Lkotlinx/coroutines/CancellableContinuationImpl;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/DispatchedTask;", "Lkotlinx/coroutines/CancellableContinuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/Waiter;", "Lkotlin/coroutines/Continuation;", "delegate", "", "resumeMode", "<init>", "(Lkotlin/coroutines/Continuation;I)V", "", "initCancellability", "()V", "", "resetStateReusable", "()Z", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "", "takeState$kotlinx_coroutines_core", "()Ljava/lang/Object;", "takeState", "takenState", "", "cause", "cancelCompletedResult$kotlinx_coroutines_core", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "cancelCompletedResult", "cancel", "(Ljava/lang/Throwable;)Z", "parentCancelled$kotlinx_coroutines_core", "(Ljava/lang/Throwable;)V", "parentCancelled", "Lkotlinx/coroutines/CancelHandler;", "handler", "callCancelHandler", "(Lkotlinx/coroutines/CancelHandler;Ljava/lang/Throwable;)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "onCancellation", "callOnCancellation", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Throwable;)V", "Lkotlinx/coroutines/Job;", "parent", "getContinuationCancellationCause", "(Lkotlinx/coroutines/Job;)Ljava/lang/Throwable;", "getResult", "releaseClaimedReusableContinuation$kotlinx_coroutines_core", "releaseClaimedReusableContinuation", "Lkotlin/Result;", "result", "resumeWith", "(Ljava/lang/Object;)V", "value", "resume", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/internal/Segment;", "segment", FirebaseAnalytics.Param.INDEX, "invokeOnCancellation", "(Lkotlinx/coroutines/internal/Segment;I)V", "Lkotlinx/coroutines/CompletionHandler;", "(Lkotlin/jvm/functions/Function1;)V", "detachChild$kotlinx_coroutines_core", "detachChild", "idempotent", "tryResume", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "exception", "tryResumeWithException", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "token", "completeResume", "Lkotlinx/coroutines/CoroutineDispatcher;", "resumeUndispatched", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Object;)V", "resumeUndispatchedWithException", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Throwable;)V", "state", "getSuccessfulResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Object;", "getSuccessfulResult", "getExceptionalResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "getExceptionalResult", "", "toString", "()Ljava/lang/String;", "nameString", "a", "Lkotlin/coroutines/Continuation;", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "Lkotlin/coroutines/CoroutineContext;", "b", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "context", "getState$kotlinx_coroutines_core", "isActive", "isCompleted", "isCancelled", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "Lkotlinx/atomicfu/AtomicInt;", "_decisionAndIndex", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/DisposableHandle;", "_parentHandle", "_state", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@PublishedApi
@SourceDebugExtension({"SMAP\nCancellableContinuationImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CancellableContinuationImpl.kt\nkotlinx/coroutines/CancellableContinuationImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CancellableContinuationImpl.kt\nkotlinx/coroutines/CancellableContinuationImplKt\n+ 4 CompletionHandler.kt\nkotlinx/coroutines/CompletionHandlerKt\n+ 5 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n*L\n1#1,662:1\n230#1,2:666\n232#1,8:669\n230#1,10:677\n230#1,10:688\n1#2:663\n24#3:664\n24#3:665\n22#3:687\n21#3:698\n22#3,3:699\n21#3:702\n22#3,3:703\n22#3:711\n21#3,4:712\n22#4:668\n13#4:710\n61#5,2:706\n61#5,2:708\n61#5,2:716\n*S KotlinDebug\n*F\n+ 1 CancellableContinuationImpl.kt\nkotlinx/coroutines/CancellableContinuationImpl\n*L\n246#1:666,2\n246#1:669,8\n249#1:677,10\n254#1:688,10\n72#1:664\n158#1:665\n252#1:687\n277#1:698\n278#1:699,3\n287#1:702\n288#1:703,3\n389#1:711\n392#1:712,4\n246#1:668\n350#1:710\n329#1:706,2\n339#1:708,2\n613#1:716,2\n*E\n"})
/* loaded from: classes2.dex */
public class CancellableContinuationImpl<T> extends DispatchedTask<T> implements CancellableContinuation<T>, CoroutineStackFrame, Waiter {

    /* renamed from: c */
    public static final AtomicIntegerFieldUpdater f21386c = AtomicIntegerFieldUpdater.newUpdater(CancellableContinuationImpl.class, "_decisionAndIndex");

    /* renamed from: d */
    public static final AtomicReferenceFieldUpdater f21387d = AtomicReferenceFieldUpdater.newUpdater(CancellableContinuationImpl.class, Object.class, "_state");

    /* renamed from: e */
    public static final AtomicReferenceFieldUpdater f21388e = AtomicReferenceFieldUpdater.newUpdater(CancellableContinuationImpl.class, Object.class, "_parentHandle");

    @Volatile
    private volatile int _decisionAndIndex;

    @Volatile
    @Nullable
    private volatile Object _parentHandle;

    @Volatile
    @Nullable
    private volatile Object _state;

    /* renamed from: a, reason: from kotlin metadata */
    public final Continuation delegate;

    /* renamed from: b, reason: from kotlin metadata */
    public final CoroutineContext context;

    public CancellableContinuationImpl(@NotNull Continuation<? super T> continuation, int i) {
        super(i);
        this.delegate = continuation;
        this.context = continuation.getF20923a();
        this._decisionAndIndex = 536870911;
        this._state = C1572n4.f23220a;
    }

    /* renamed from: f */
    public static void m5652f(NotCompleted notCompleted, Object obj) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + notCompleted + ", already has " + obj).toString());
    }

    /* renamed from: h */
    public static Object m5653h(NotCompleted notCompleted, Object obj, int i, Function1 function1, Object obj2) {
        CancelHandler cancelHandler;
        if (!(obj instanceof CompletedExceptionally)) {
            if (DispatchedTaskKt.isCancellableMode(i) || obj2 != null) {
                if (function1 != null || (notCompleted instanceof CancelHandler) || obj2 != null) {
                    if (notCompleted instanceof CancelHandler) {
                        cancelHandler = (CancelHandler) notCompleted;
                    } else {
                        cancelHandler = null;
                    }
                    return new C1486kt(obj, cancelHandler, function1, obj2, null, 16);
                }
                return obj;
            }
            return obj;
        }
        return obj;
    }

    /* renamed from: a */
    public final void m5654a(Segment segment, Throwable th) {
        int i = f21386c.get(this) & 536870911;
        if (i != 536870911) {
            try {
                segment.onCancellation(i, th, getF20923a());
                return;
            } catch (Throwable th2) {
                CoroutineExceptionHandlerKt.handleCoroutineException(getF20923a(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th2));
                return;
            }
        }
        throw new IllegalStateException("The index for Segment.onCancellation(..) is broken");
    }

    /* renamed from: b */
    public final void m5655b(int i) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i2;
        do {
            atomicIntegerFieldUpdater = f21386c;
            i2 = atomicIntegerFieldUpdater.get(this);
            int i3 = i2 >> 29;
            if (i3 != 0) {
                if (i3 == 1) {
                    DispatchedTaskKt.dispatch(this, i);
                    return;
                }
                throw new IllegalStateException("Already resumed");
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i2, 1073741824 + (536870911 & i2)));
    }

    /* renamed from: c */
    public final DisposableHandle m5656c() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Job job = (Job) getF20923a().get(Job.INSTANCE);
        if (job == null) {
            return null;
        }
        DisposableHandle invokeOnCompletion$default = Job.DefaultImpls.invokeOnCompletion$default(job, true, false, new ChildContinuation(this), 2, null);
        do {
            atomicReferenceFieldUpdater = f21388e;
            if (atomicReferenceFieldUpdater.compareAndSet(this, null, invokeOnCompletion$default)) {
                break;
            }
        } while (atomicReferenceFieldUpdater.get(this) == null);
        return invokeOnCompletion$default;
    }

    public final void callCancelHandler(@NotNull CancelHandler handler, @Nullable Throwable cause) {
        try {
            handler.invoke(cause);
        } catch (Throwable th) {
            CoroutineExceptionHandlerKt.handleCoroutineException(getF20923a(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th));
        }
    }

    public final void callOnCancellation(@NotNull Function1<? super Throwable, Unit> onCancellation, @NotNull Throwable cause) {
        try {
            onCancellation.invoke(cause);
        } catch (Throwable th) {
            CoroutineExceptionHandlerKt.handleCoroutineException(getF20923a(), new CompletionHandlerException("Exception in resume onCancellation handler for " + this, th));
        }
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public boolean cancel(@Nullable Throwable cause) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f21387d;
            Object obj = atomicReferenceFieldUpdater.get(this);
            boolean z = false;
            if (!(obj instanceof NotCompleted)) {
                return false;
            }
            if ((obj instanceof CancelHandler) || (obj instanceof Segment)) {
                z = true;
            }
            CancelledContinuation cancelledContinuation = new CancelledContinuation(this, cause, z);
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, cancelledContinuation)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    break;
                }
            }
            NotCompleted notCompleted = (NotCompleted) obj;
            if (notCompleted instanceof CancelHandler) {
                callCancelHandler((CancelHandler) obj, cause);
            } else if (notCompleted instanceof Segment) {
                m5654a((Segment) obj, cause);
            }
            if (!m5658e()) {
                detachChild$kotlinx_coroutines_core();
            }
            m5655b(this.resumeMode);
            return true;
        }
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public void cancelCompletedResult$kotlinx_coroutines_core(@Nullable Object takenState, @NotNull Throwable cause) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f21387d;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof NotCompleted)) {
                if (obj instanceof CompletedExceptionally) {
                    return;
                }
                if (obj instanceof C1486kt) {
                    C1486kt c1486kt = (C1486kt) obj;
                    if (c1486kt.f22190e == null) {
                        C1486kt m5788a = C1486kt.m5788a(c1486kt, null, cause, 15);
                        while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, m5788a)) {
                            if (atomicReferenceFieldUpdater.get(this) != obj) {
                                break;
                            }
                        }
                        CancelHandler cancelHandler = c1486kt.f22187b;
                        if (cancelHandler != null) {
                            callCancelHandler(cancelHandler, cause);
                        }
                        Function1<? super Throwable, Unit> function1 = c1486kt.f22188c;
                        if (function1 != null) {
                            callOnCancellation(function1, cause);
                            return;
                        }
                        return;
                    }
                    throw new IllegalStateException("Must be called at most once");
                }
                C1486kt c1486kt2 = new C1486kt(obj, null, null, null, cause, 14);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, c1486kt2)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                        break;
                    }
                }
                return;
            }
            throw new IllegalStateException("Not completed");
        }
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void completeResume(@NotNull Object token) {
        m5655b(this.resumeMode);
    }

    /* renamed from: d */
    public final void m5657d(NotCompleted notCompleted) {
        boolean z;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f21387d;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj instanceof C1572n4) {
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, notCompleted)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                        break;
                    }
                }
                return;
            }
            if (obj instanceof CancelHandler) {
                z = true;
            } else {
                z = obj instanceof Segment;
            }
            Throwable th = null;
            if (!z) {
                if (obj instanceof CompletedExceptionally) {
                    CompletedExceptionally completedExceptionally = (CompletedExceptionally) obj;
                    if (completedExceptionally.makeHandled()) {
                        if (obj instanceof CancelledContinuation) {
                            if (!(obj instanceof CompletedExceptionally)) {
                                completedExceptionally = null;
                            }
                            if (completedExceptionally != null) {
                                th = completedExceptionally.cause;
                            }
                            if (notCompleted instanceof CancelHandler) {
                                callCancelHandler((CancelHandler) notCompleted, th);
                                return;
                            } else {
                                Intrinsics.checkNotNull(notCompleted, "null cannot be cast to non-null type kotlinx.coroutines.internal.Segment<*>");
                                m5654a((Segment) notCompleted, th);
                                return;
                            }
                        }
                        return;
                    }
                    m5652f(notCompleted, obj);
                    throw null;
                }
                if (obj instanceof C1486kt) {
                    C1486kt c1486kt = (C1486kt) obj;
                    if (c1486kt.f22187b == null) {
                        if (notCompleted instanceof Segment) {
                            return;
                        }
                        Intrinsics.checkNotNull(notCompleted, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                        CancelHandler cancelHandler = (CancelHandler) notCompleted;
                        Throwable th2 = c1486kt.f22190e;
                        if (th2 != null) {
                            callCancelHandler(cancelHandler, th2);
                            return;
                        }
                        C1486kt m5788a = C1486kt.m5788a(c1486kt, cancelHandler, null, 29);
                        while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, m5788a)) {
                            if (atomicReferenceFieldUpdater.get(this) != obj) {
                                break;
                            }
                        }
                        return;
                    }
                    m5652f(notCompleted, obj);
                    throw null;
                }
                if (notCompleted instanceof Segment) {
                    return;
                }
                Intrinsics.checkNotNull(notCompleted, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                C1486kt c1486kt2 = new C1486kt(obj, (CancelHandler) notCompleted, null, null, null, 28);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, c1486kt2)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                        break;
                    }
                }
                return;
            }
            m5652f(notCompleted, obj);
            throw null;
        }
    }

    public final void detachChild$kotlinx_coroutines_core() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f21388e;
        DisposableHandle disposableHandle = (DisposableHandle) atomicReferenceFieldUpdater.get(this);
        if (disposableHandle == null) {
            return;
        }
        disposableHandle.dispose();
        atomicReferenceFieldUpdater.set(this, NonDisposableHandle.INSTANCE);
    }

    /* renamed from: e */
    public final boolean m5658e() {
        if (DispatchedTaskKt.isReusableMode(this.resumeMode)) {
            Continuation continuation = this.delegate;
            Intrinsics.checkNotNull(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
            if (((DispatchedContinuation) continuation).isReusable$kotlinx_coroutines_core()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: g */
    public final void m5659g(Object obj, int i, Function1 function1) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f21387d;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof NotCompleted) {
                Object m5653h = m5653h((NotCompleted) obj2, obj, i, function1, null);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, m5653h)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj2) {
                        break;
                    }
                }
                if (!m5658e()) {
                    detachChild$kotlinx_coroutines_core();
                }
                m5655b(i);
                return;
            }
            if (obj2 instanceof CancelledContinuation) {
                CancelledContinuation cancelledContinuation = (CancelledContinuation) obj2;
                if (cancelledContinuation.makeResumed()) {
                    if (function1 != null) {
                        callOnCancellation(function1, cancelledContinuation.cause);
                        return;
                    }
                    return;
                }
            }
            throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
        }
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @Nullable
    public CoroutineStackFrame getCallerFrame() {
        Continuation continuation = this.delegate;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    @NotNull
    /* renamed from: getContext, reason: from getter */
    public CoroutineContext getF20923a() {
        return this.context;
    }

    @NotNull
    public Throwable getContinuationCancellationCause(@NotNull Job parent) {
        return parent.getCancellationException();
    }

    @Override // kotlinx.coroutines.DispatchedTask
    @NotNull
    public final Continuation<T> getDelegate$kotlinx_coroutines_core() {
        return this.delegate;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    @Nullable
    public Throwable getExceptionalResult$kotlinx_coroutines_core(@Nullable Object state) {
        Throwable exceptionalResult$kotlinx_coroutines_core = super.getExceptionalResult$kotlinx_coroutines_core(state);
        if (exceptionalResult$kotlinx_coroutines_core == null) {
            return null;
        }
        return exceptionalResult$kotlinx_coroutines_core;
    }

    @PublishedApi
    @Nullable
    public final Object getResult() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i;
        Job job;
        boolean m5658e = m5658e();
        do {
            atomicIntegerFieldUpdater = f21386c;
            i = atomicIntegerFieldUpdater.get(this);
            int i2 = i >> 29;
            if (i2 != 0) {
                if (i2 == 2) {
                    if (m5658e) {
                        releaseClaimedReusableContinuation$kotlinx_coroutines_core();
                    }
                    Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
                    if (!(state$kotlinx_coroutines_core instanceof CompletedExceptionally)) {
                        if (DispatchedTaskKt.isCancellableMode(this.resumeMode) && (job = (Job) getF20923a().get(Job.INSTANCE)) != null && !job.isActive()) {
                            CancellationException cancellationException = job.getCancellationException();
                            cancelCompletedResult$kotlinx_coroutines_core(state$kotlinx_coroutines_core, cancellationException);
                            throw cancellationException;
                        }
                        return getSuccessfulResult$kotlinx_coroutines_core(state$kotlinx_coroutines_core);
                    }
                    throw ((CompletedExceptionally) state$kotlinx_coroutines_core).cause;
                }
                throw new IllegalStateException("Already suspended");
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i, 536870912 + (536870911 & i)));
        if (((DisposableHandle) f21388e.get(this)) == null) {
            m5656c();
        }
        if (m5658e) {
            releaseClaimedReusableContinuation$kotlinx_coroutines_core();
        }
        return b51.getCOROUTINE_SUSPENDED();
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @Nullable
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Nullable
    public final Object getState$kotlinx_coroutines_core() {
        return f21387d.get(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.DispatchedTask
    public <T> T getSuccessfulResult$kotlinx_coroutines_core(@Nullable Object state) {
        if (state instanceof C1486kt) {
            return (T) ((C1486kt) state).f22186a;
        }
        return state;
    }

    /* renamed from: i */
    public final Symbol m5660i(Object obj, Object obj2, Function1 function1) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f21387d;
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            if (obj3 instanceof NotCompleted) {
                Object m5653h = m5653h((NotCompleted) obj3, obj, this.resumeMode, function1, obj2);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj3, m5653h)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj3) {
                        break;
                    }
                }
                if (!m5658e()) {
                    detachChild$kotlinx_coroutines_core();
                }
                return CancellableContinuationImplKt.RESUME_TOKEN;
            }
            if (!(obj3 instanceof C1486kt) || obj2 == null || ((C1486kt) obj3).f22189d != obj2) {
                return null;
            }
            return CancellableContinuationImplKt.RESUME_TOKEN;
        }
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void initCancellability() {
        DisposableHandle m5656c = m5656c();
        if (m5656c != null && isCompleted()) {
            m5656c.dispose();
            f21388e.set(this, NonDisposableHandle.INSTANCE);
        }
    }

    @Override // kotlinx.coroutines.Waiter
    public void invokeOnCancellation(@NotNull Segment<?> segment, int index) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i;
        do {
            atomicIntegerFieldUpdater = f21386c;
            i = atomicIntegerFieldUpdater.get(this);
            if ((i & 536870911) != 536870911) {
                throw new IllegalStateException("invokeOnCancellation should be called at most once");
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i, ((i >> 29) << 29) + index));
        m5657d(segment);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public boolean isActive() {
        return getState$kotlinx_coroutines_core() instanceof NotCompleted;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public boolean isCancelled() {
        return getState$kotlinx_coroutines_core() instanceof CancelledContinuation;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public boolean isCompleted() {
        return !(getState$kotlinx_coroutines_core() instanceof NotCompleted);
    }

    @NotNull
    public String nameString() {
        return "CancellableContinuation";
    }

    public final void parentCancelled$kotlinx_coroutines_core(@NotNull Throwable cause) {
        boolean postponeCancellation$kotlinx_coroutines_core;
        if (!m5658e()) {
            postponeCancellation$kotlinx_coroutines_core = false;
        } else {
            Continuation continuation = this.delegate;
            Intrinsics.checkNotNull(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
            postponeCancellation$kotlinx_coroutines_core = ((DispatchedContinuation) continuation).postponeCancellation$kotlinx_coroutines_core(cause);
        }
        if (postponeCancellation$kotlinx_coroutines_core) {
            return;
        }
        cancel(cause);
        if (!m5658e()) {
            detachChild$kotlinx_coroutines_core();
        }
    }

    public final void releaseClaimedReusableContinuation$kotlinx_coroutines_core() {
        DispatchedContinuation dispatchedContinuation;
        Throwable tryReleaseClaimedContinuation$kotlinx_coroutines_core;
        Continuation continuation = this.delegate;
        if (continuation instanceof DispatchedContinuation) {
            dispatchedContinuation = (DispatchedContinuation) continuation;
        } else {
            dispatchedContinuation = null;
        }
        if (dispatchedContinuation != null && (tryReleaseClaimedContinuation$kotlinx_coroutines_core = dispatchedContinuation.tryReleaseClaimedContinuation$kotlinx_coroutines_core(this)) != null) {
            detachChild$kotlinx_coroutines_core();
            cancel(tryReleaseClaimedContinuation$kotlinx_coroutines_core);
        }
    }

    @JvmName(name = "resetStateReusable")
    public final boolean resetStateReusable() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f21387d;
        Object obj = atomicReferenceFieldUpdater.get(this);
        if ((obj instanceof C1486kt) && ((C1486kt) obj).f22189d != null) {
            detachChild$kotlinx_coroutines_core();
            return false;
        }
        f21386c.set(this, 536870911);
        atomicReferenceFieldUpdater.set(this, C1572n4.f23220a);
        return true;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void resume(T value, @Nullable Function1<? super Throwable, Unit> onCancellation) {
        m5659g(value, this.resumeMode, onCancellation);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void resumeUndispatched(@NotNull CoroutineDispatcher coroutineDispatcher, T t) {
        DispatchedContinuation dispatchedContinuation;
        CoroutineDispatcher coroutineDispatcher2;
        int i;
        Continuation continuation = this.delegate;
        if (continuation instanceof DispatchedContinuation) {
            dispatchedContinuation = (DispatchedContinuation) continuation;
        } else {
            dispatchedContinuation = null;
        }
        if (dispatchedContinuation != null) {
            coroutineDispatcher2 = dispatchedContinuation.dispatcher;
        } else {
            coroutineDispatcher2 = null;
        }
        if (coroutineDispatcher2 == coroutineDispatcher) {
            i = 4;
        } else {
            i = this.resumeMode;
        }
        m5659g(t, i, null);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void resumeUndispatchedWithException(@NotNull CoroutineDispatcher coroutineDispatcher, @NotNull Throwable th) {
        DispatchedContinuation dispatchedContinuation;
        CoroutineDispatcher coroutineDispatcher2;
        int i;
        Continuation continuation = this.delegate;
        if (continuation instanceof DispatchedContinuation) {
            dispatchedContinuation = (DispatchedContinuation) continuation;
        } else {
            dispatchedContinuation = null;
        }
        CompletedExceptionally completedExceptionally = new CompletedExceptionally(th, false, 2, null);
        if (dispatchedContinuation != null) {
            coroutineDispatcher2 = dispatchedContinuation.dispatcher;
        } else {
            coroutineDispatcher2 = null;
        }
        if (coroutineDispatcher2 == coroutineDispatcher) {
            i = 4;
        } else {
            i = this.resumeMode;
        }
        m5659g(completedExceptionally, i, null);
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(@NotNull Object result) {
        m5659g(CompletionStateKt.toState(result, this), this.resumeMode, null);
    }

    @Override // kotlinx.coroutines.DispatchedTask
    @Nullable
    public Object takeState$kotlinx_coroutines_core() {
        return getState$kotlinx_coroutines_core();
    }

    @NotNull
    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(nameString());
        sb.append('(');
        sb.append(DebugStringsKt.toDebugString(this.delegate));
        sb.append("){");
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof NotCompleted) {
            str = "Active";
        } else if (state$kotlinx_coroutines_core instanceof CancelledContinuation) {
            str = "Cancelled";
        } else {
            str = "Completed";
        }
        sb.append(str);
        sb.append("}@");
        sb.append(DebugStringsKt.getHexAddress(this));
        return sb.toString();
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    @Nullable
    public Object tryResume(T value, @Nullable Object idempotent) {
        return m5660i(value, idempotent, null);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    @Nullable
    public Object tryResumeWithException(@NotNull Throwable exception) {
        return m5660i(new CompletedExceptionally(exception, false, 2, null), null, null);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    @Nullable
    public Object tryResume(T value, @Nullable Object idempotent, @Nullable Function1<? super Throwable, Unit> onCancellation) {
        return m5660i(value, idempotent, onCancellation);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void invokeOnCancellation(@NotNull Function1<? super Throwable, Unit> handler) {
        m5657d(handler instanceof CancelHandler ? (CancelHandler) handler : new C1986xk(2, handler));
    }
}
