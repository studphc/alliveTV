package kotlinx.coroutines.debug.internal;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m5568d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0001\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0017\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010$\u001a\u00020\u001f8\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0019\u0010*\u001a\u0004\u0018\u00010%8\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0019\u0010-\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b+\u0010\u000e\u001a\u0004\b,\u0010\u0010R\u001d\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188G¢\u0006\f\n\u0004\b.\u0010\u001b\u001a\u0004\b/\u0010\u001d¨\u00060"}, m5569d2 = {"Lkotlinx/coroutines/debug/internal/DebugCoroutineInfo;", "", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", FirebaseAnalytics.Param.SOURCE, "Lkotlin/coroutines/CoroutineContext;", "context", "<init>", "(Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;Lkotlin/coroutines/CoroutineContext;)V", "a", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "b", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getCreationStackBottom$kotlinx_coroutines_core", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "creationStackBottom", "", "c", "J", "getSequenceNumber", "()J", "sequenceNumber", "", "Ljava/lang/StackTraceElement;", "d", "Ljava/util/List;", "getCreationStackTrace", "()Ljava/util/List;", "creationStackTrace", "", "e", "Ljava/lang/String;", "getState", "()Ljava/lang/String;", "state", "Ljava/lang/Thread;", "f", "Ljava/lang/Thread;", "getLastObservedThread", "()Ljava/lang/Thread;", "lastObservedThread", "g", "getLastObservedFrame", "lastObservedFrame", "h", "lastObservedStackTrace", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@PublishedApi
/* loaded from: classes2.dex */
public final class DebugCoroutineInfo {

    /* renamed from: a, reason: from kotlin metadata */
    public final CoroutineContext context;

    /* renamed from: b */
    public final StackTraceFrame f21513b;

    /* renamed from: c, reason: from kotlin metadata */
    public final long sequenceNumber;

    /* renamed from: d, reason: from kotlin metadata */
    public final List creationStackTrace;

    /* renamed from: e, reason: from kotlin metadata */
    public final String state;

    /* renamed from: f, reason: from kotlin metadata */
    public final Thread lastObservedThread;

    /* renamed from: g, reason: from kotlin metadata */
    public final CoroutineStackFrame lastObservedFrame;

    /* renamed from: h, reason: from kotlin metadata */
    public final List lastObservedStackTrace;

    public DebugCoroutineInfo(@NotNull DebugCoroutineInfoImpl debugCoroutineInfoImpl, @NotNull CoroutineContext coroutineContext) {
        this.context = coroutineContext;
        this.f21513b = debugCoroutineInfoImpl.getCreationStackBottom();
        this.sequenceNumber = debugCoroutineInfoImpl.sequenceNumber;
        this.creationStackTrace = debugCoroutineInfoImpl.getCreationStackTrace();
        this.state = debugCoroutineInfoImpl.get_state();
        this.lastObservedThread = debugCoroutineInfoImpl.lastObservedThread;
        this.lastObservedFrame = debugCoroutineInfoImpl.getLastObservedFrame$kotlinx_coroutines_core();
        this.lastObservedStackTrace = debugCoroutineInfoImpl.lastObservedStackTrace$kotlinx_coroutines_core();
    }

    @NotNull
    public final CoroutineContext getContext() {
        return this.context;
    }

    @Nullable
    public final CoroutineStackFrame getCreationStackBottom$kotlinx_coroutines_core() {
        return this.f21513b;
    }

    @NotNull
    public final List<StackTraceElement> getCreationStackTrace() {
        return this.creationStackTrace;
    }

    @Nullable
    public final CoroutineStackFrame getLastObservedFrame() {
        return this.lastObservedFrame;
    }

    @Nullable
    public final Thread getLastObservedThread() {
        return this.lastObservedThread;
    }

    public final long getSequenceNumber() {
        return this.sequenceNumber;
    }

    @NotNull
    public final String getState() {
        return this.state;
    }

    @JvmName(name = "lastObservedStackTrace")
    @NotNull
    public final List<StackTraceElement> lastObservedStackTrace() {
        return this.lastObservedStackTrace;
    }
}
