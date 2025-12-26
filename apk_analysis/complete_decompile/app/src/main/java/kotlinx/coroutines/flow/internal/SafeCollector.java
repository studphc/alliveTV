package kotlinx.coroutines.flow.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.b51;
import p000.mo2;
import p000.or1;
import p000.rd2;

@Metadata(m5568d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\t\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00020\u00032\u00020\u0004B\u001d\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\"\u0010\u0010\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0018R\u0014\u0010\u0007\u001a\u00020\u00068\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u001a8\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\"\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010!\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006#"}, m5569d2 = {"Lkotlinx/coroutines/flow/internal/SafeCollector;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "collector", "Lkotlin/coroutines/CoroutineContext;", "collectContext", "<init>", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/CoroutineContext;)V", "Ljava/lang/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "Lkotlin/Result;", "", "result", "invokeSuspend", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "releaseIntercepted", "()V", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/coroutines/CoroutineContext;", "", "collectContextSize", "I", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "context", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nSafeCollector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.kt\nkotlinx/coroutines/flow/internal/SafeCollector\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,156:1\n1#2:157\n*E\n"})
/* loaded from: classes2.dex */
public final class SafeCollector<T> extends ContinuationImpl implements FlowCollector<T>, CoroutineStackFrame {

    @JvmField
    @NotNull
    public final CoroutineContext collectContext;

    @JvmField
    public final int collectContextSize;

    @JvmField
    @NotNull
    public final FlowCollector<T> collector;

    /* renamed from: d */
    public CoroutineContext f21992d;

    /* renamed from: e */
    public Continuation f21993e;

    /* JADX WARN: Multi-variable type inference failed */
    public SafeCollector(@NotNull FlowCollector<? super T> flowCollector, @NotNull CoroutineContext coroutineContext) {
        super(or1.f24880a, EmptyCoroutineContext.INSTANCE);
        this.collector = flowCollector;
        this.collectContext = coroutineContext;
        this.collectContextSize = ((Number) coroutineContext.fold(0, rd2.f25940b)).intValue();
    }

    /* renamed from: a */
    public final Object m5726a(Continuation continuation, Object obj) {
        CoroutineContext f20923a = continuation.getF20923a();
        JobKt.ensureActive(f20923a);
        CoroutineContext coroutineContext = this.f21992d;
        if (coroutineContext != f20923a) {
            if (!(coroutineContext instanceof DownstreamExceptionContext)) {
                SafeCollector_commonKt.checkContext(this, f20923a);
                this.f21992d = f20923a;
            } else {
                throw new IllegalStateException(mo2.trimIndent("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + ((DownstreamExceptionContext) coroutineContext).e + ", but then emission attempt of value '" + obj + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ").toString());
            }
        }
        this.f21993e = continuation;
        Function3 access$getEmitFun$p = SafeCollectorKt.access$getEmitFun$p();
        FlowCollector<T> flowCollector = this.collector;
        Intrinsics.checkNotNull(flowCollector, "null cannot be cast to non-null type kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>");
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Unit>");
        Object invoke = access$getEmitFun$p.invoke(flowCollector, obj, this);
        if (!Intrinsics.areEqual(invoke, b51.getCOROUTINE_SUSPENDED())) {
            this.f21993e = null;
        }
        return invoke;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    @Nullable
    public Object emit(T t, @NotNull Continuation<? super Unit> continuation) {
        try {
            Object m5726a = m5726a(continuation, t);
            if (m5726a == b51.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            if (m5726a == b51.getCOROUTINE_SUSPENDED()) {
                return m5726a;
            }
            return Unit.INSTANCE;
        } catch (Throwable th) {
            this.f21992d = new DownstreamExceptionContext(th, continuation.getF20923a());
            throw th;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl, kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @Nullable
    public CoroutineStackFrame getCallerFrame() {
        Continuation continuation = this.f21993e;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl, kotlin.coroutines.Continuation
    @NotNull
    /* renamed from: getContext */
    public CoroutineContext getF20923a() {
        CoroutineContext coroutineContext = this.f21992d;
        if (coroutineContext == null) {
            return EmptyCoroutineContext.INSTANCE;
        }
        return coroutineContext;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl, kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @Nullable
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public Object invokeSuspend(@NotNull Object result) {
        Throwable m8515exceptionOrNullimpl = Result.m8515exceptionOrNullimpl(result);
        if (m8515exceptionOrNullimpl != null) {
            this.f21992d = new DownstreamExceptionContext(m8515exceptionOrNullimpl, getF20923a());
        }
        Continuation continuation = this.f21993e;
        if (continuation != null) {
            continuation.resumeWith(result);
        }
        return b51.getCOROUTINE_SUSPENDED();
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl, kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public void releaseIntercepted() {
        super.releaseIntercepted();
    }
}
