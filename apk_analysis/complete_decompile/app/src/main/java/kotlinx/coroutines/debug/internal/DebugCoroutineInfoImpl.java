package kotlinx.coroutines.debug.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt__SequenceBuilderKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.C1926vy;
import p000.C1963wy;
import p000.b51;

@Metadata(m5568d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0001\u0018\u00002\u00020\u0001B%\b\u0000\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ+\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001fR\u0016\u0010 \u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010#\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u001e\u0010'\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0017\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148F¢\u0006\u0006\u001a\u0004\b+\u0010\u0017R\u0014\u0010\u000b\u001a\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b-\u0010\u001aR(\u00103\u001a\u0004\u0018\u00010&2\b\u0010.\u001a\u0004\u0018\u00010&8@@@X\u0080\u000e¢\u0006\f\u001a\u0004\b/\u00100\"\u0004\b1\u00102¨\u00064"}, m5569d2 = {"Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "creationStackBottom", "", "sequenceNumber", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/debug/internal/StackTraceFrame;J)V", "", "state", "Lkotlin/coroutines/Continuation;", TypedValues.AttributesType.S_FRAME, "", "shouldBeMatched", "", "updateState$kotlinx_coroutines_core", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;Z)V", "updateState", "", "Ljava/lang/StackTraceElement;", "lastObservedStackTrace$kotlinx_coroutines_core", "()Ljava/util/List;", "lastObservedStackTrace", "toString", "()Ljava/lang/String;", "a", "Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "getCreationStackBottom$kotlinx_coroutines_core", "()Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "J", "_state", "Ljava/lang/String;", "Ljava/lang/Thread;", "lastObservedThread", "Ljava/lang/Thread;", "Ljava/lang/ref/WeakReference;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "_lastObservedFrame", "Ljava/lang/ref/WeakReference;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "getCreationStackTrace", "creationStackTrace", "getState$kotlinx_coroutines_core", "value", "getLastObservedFrame$kotlinx_coroutines_core", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "setLastObservedFrame$kotlinx_coroutines_core", "(Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)V", "lastObservedFrame", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@PublishedApi
@SourceDebugExtension({"SMAP\nDebugCoroutineInfoImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DebugCoroutineInfoImpl.kt\nkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,180:1\n1#2:181\n*E\n"})
/* loaded from: classes2.dex */
public final class DebugCoroutineInfoImpl {

    @JvmField
    @Nullable
    public volatile WeakReference<CoroutineStackFrame> _lastObservedFrame;

    @JvmField
    @NotNull
    public volatile String _state = DebugCoroutineInfoImplKt.CREATED;

    /* renamed from: a, reason: from kotlin metadata */
    public final StackTraceFrame creationStackBottom;

    /* renamed from: b */
    public final WeakReference f21521b;

    /* renamed from: c */
    public int f21522c;

    @JvmField
    @Nullable
    public volatile Thread lastObservedThread;

    @JvmField
    public final long sequenceNumber;

    public DebugCoroutineInfoImpl(@Nullable CoroutineContext coroutineContext, @Nullable StackTraceFrame stackTraceFrame, long j) {
        this.creationStackBottom = stackTraceFrame;
        this.sequenceNumber = j;
        this.f21521b = new WeakReference(coroutineContext);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0046 -> B:11:0x005d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0057 -> B:10:0x005a). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object access$yieldFrames(DebugCoroutineInfoImpl debugCoroutineInfoImpl, SequenceScope sequenceScope, CoroutineStackFrame coroutineStackFrame, Continuation continuation) {
        C1963wy c1963wy;
        int i;
        debugCoroutineInfoImpl.getClass();
        if (continuation instanceof C1963wy) {
            c1963wy = (C1963wy) continuation;
            int i2 = c1963wy.f28383i;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c1963wy.f28383i = i2 - Integer.MIN_VALUE;
                Object obj = c1963wy.f28381g;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = c1963wy.f28383i;
                if (i == 0) {
                    if (i == 1) {
                        CoroutineStackFrame coroutineStackFrame2 = c1963wy.f28380f;
                        sequenceScope = c1963wy.f28379e;
                        DebugCoroutineInfoImpl debugCoroutineInfoImpl2 = c1963wy.f28378d;
                        ResultKt.throwOnFailure(obj);
                        DebugCoroutineInfoImpl debugCoroutineInfoImpl3 = debugCoroutineInfoImpl2;
                        coroutineStackFrame = coroutineStackFrame2;
                        debugCoroutineInfoImpl = debugCoroutineInfoImpl3;
                        coroutineStackFrame = coroutineStackFrame.getCallerFrame();
                        if (coroutineStackFrame == null) {
                            return Unit.INSTANCE;
                        }
                        if (coroutineStackFrame == null) {
                            StackTraceElement stackTraceElement = coroutineStackFrame.getStackTraceElement();
                            if (stackTraceElement != null) {
                                c1963wy.f28378d = debugCoroutineInfoImpl;
                                c1963wy.f28379e = sequenceScope;
                                c1963wy.f28380f = coroutineStackFrame;
                                c1963wy.f28383i = 1;
                                if (sequenceScope.yield(stackTraceElement, c1963wy) != coroutine_suspended) {
                                    CoroutineStackFrame coroutineStackFrame3 = coroutineStackFrame;
                                    debugCoroutineInfoImpl2 = debugCoroutineInfoImpl;
                                    coroutineStackFrame2 = coroutineStackFrame3;
                                    DebugCoroutineInfoImpl debugCoroutineInfoImpl32 = debugCoroutineInfoImpl2;
                                    coroutineStackFrame = coroutineStackFrame2;
                                    debugCoroutineInfoImpl = debugCoroutineInfoImpl32;
                                } else {
                                    return coroutine_suspended;
                                }
                            }
                            coroutineStackFrame = coroutineStackFrame.getCallerFrame();
                            if (coroutineStackFrame == null) {
                            }
                            if (coroutineStackFrame == null) {
                                return Unit.INSTANCE;
                            }
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    if (coroutineStackFrame == null) {
                    }
                }
            }
        }
        c1963wy = new C1963wy(continuation, debugCoroutineInfoImpl);
        Object obj2 = c1963wy.f28381g;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = c1963wy.f28383i;
        if (i == 0) {
        }
    }

    @Nullable
    public final CoroutineContext getContext() {
        return (CoroutineContext) this.f21521b.get();
    }

    @Nullable
    /* renamed from: getCreationStackBottom$kotlinx_coroutines_core, reason: from getter */
    public final StackTraceFrame getCreationStackBottom() {
        return this.creationStackBottom;
    }

    @NotNull
    public final List<StackTraceElement> getCreationStackTrace() {
        StackTraceFrame stackTraceFrame = this.creationStackBottom;
        if (stackTraceFrame == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return SequencesKt___SequencesKt.toList(SequencesKt__SequenceBuilderKt.sequence(new C1926vy(this, stackTraceFrame, null)));
    }

    @Nullable
    public final CoroutineStackFrame getLastObservedFrame$kotlinx_coroutines_core() {
        WeakReference<CoroutineStackFrame> weakReference = this._lastObservedFrame;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @NotNull
    /* renamed from: getState$kotlinx_coroutines_core, reason: from getter */
    public final String get_state() {
        return this._state;
    }

    @NotNull
    public final List<StackTraceElement> lastObservedStackTrace$kotlinx_coroutines_core() {
        CoroutineStackFrame lastObservedFrame$kotlinx_coroutines_core = getLastObservedFrame$kotlinx_coroutines_core();
        if (lastObservedFrame$kotlinx_coroutines_core == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        while (lastObservedFrame$kotlinx_coroutines_core != null) {
            StackTraceElement stackTraceElement = lastObservedFrame$kotlinx_coroutines_core.getStackTraceElement();
            if (stackTraceElement != null) {
                arrayList.add(stackTraceElement);
            }
            lastObservedFrame$kotlinx_coroutines_core = lastObservedFrame$kotlinx_coroutines_core.getCallerFrame();
        }
        return arrayList;
    }

    public final void setLastObservedFrame$kotlinx_coroutines_core(@Nullable CoroutineStackFrame coroutineStackFrame) {
        WeakReference<CoroutineStackFrame> weakReference;
        if (coroutineStackFrame != null) {
            weakReference = new WeakReference<>(coroutineStackFrame);
        } else {
            weakReference = null;
        }
        this._lastObservedFrame = weakReference;
    }

    @NotNull
    public String toString() {
        return "DebugCoroutineInfo(state=" + get_state() + ",context=" + getContext() + ')';
    }

    public final synchronized void updateState$kotlinx_coroutines_core(@NotNull String state, @NotNull Continuation<?> frame, boolean shouldBeMatched) {
        CoroutineStackFrame coroutineStackFrame;
        try {
            if (Intrinsics.areEqual(this._state, DebugCoroutineInfoImplKt.RUNNING) && Intrinsics.areEqual(state, DebugCoroutineInfoImplKt.RUNNING) && shouldBeMatched) {
                this.f21522c++;
            } else if (this.f21522c > 0 && Intrinsics.areEqual(state, DebugCoroutineInfoImplKt.SUSPENDED)) {
                this.f21522c--;
                return;
            }
            if (Intrinsics.areEqual(this._state, state) && Intrinsics.areEqual(state, DebugCoroutineInfoImplKt.SUSPENDED) && getLastObservedFrame$kotlinx_coroutines_core() != null) {
                return;
            }
            this._state = state;
            Thread thread = null;
            if (frame instanceof CoroutineStackFrame) {
                coroutineStackFrame = (CoroutineStackFrame) frame;
            } else {
                coroutineStackFrame = null;
            }
            setLastObservedFrame$kotlinx_coroutines_core(coroutineStackFrame);
            if (Intrinsics.areEqual(state, DebugCoroutineInfoImplKt.RUNNING)) {
                thread = Thread.currentThread();
            }
            this.lastObservedThread = thread;
        } catch (Throwable th) {
            throw th;
        }
    }
}
