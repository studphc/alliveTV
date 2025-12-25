package kotlinx.coroutines.debug.internal;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.Serializable;
import java.lang.Thread;
import java.util.List;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineId;
import kotlinx.coroutines.CoroutineName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m5568d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\r\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012R\u0017\u0010\u0019\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0018\u0010\u0012R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u001b\u0010\u0012R\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0010\u001a\u0004\b\u001e\u0010\u0012R\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00020!0 8\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010+\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*¨\u0006,"}, m5569d2 = {"Lkotlinx/coroutines/debug/internal/DebuggerInfo;", "Ljava/io/Serializable;", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", FirebaseAnalytics.Param.SOURCE, "Lkotlin/coroutines/CoroutineContext;", "context", "<init>", "(Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;Lkotlin/coroutines/CoroutineContext;)V", "", "a", "Ljava/lang/Long;", "getCoroutineId", "()Ljava/lang/Long;", "coroutineId", "", "b", "Ljava/lang/String;", "getDispatcher", "()Ljava/lang/String;", "dispatcher", "c", "getName", AppMeasurementSdk.ConditionalUserProperty.NAME, "d", "getState", "state", "e", "getLastObservedThreadState", "lastObservedThreadState", "f", "getLastObservedThreadName", "lastObservedThreadName", "", "Ljava/lang/StackTraceElement;", "g", "Ljava/util/List;", "getLastObservedStackTrace", "()Ljava/util/List;", "lastObservedStackTrace", "h", "J", "getSequenceNumber", "()J", "sequenceNumber", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@PublishedApi
/* loaded from: classes2.dex */
public final class DebuggerInfo implements Serializable {

    /* renamed from: a, reason: from kotlin metadata */
    public final Long coroutineId;

    /* renamed from: b, reason: from kotlin metadata */
    public final String dispatcher;

    /* renamed from: c, reason: from kotlin metadata */
    public final String name;

    /* renamed from: d, reason: from kotlin metadata */
    public final String state;

    /* renamed from: e, reason: from kotlin metadata */
    public final String lastObservedThreadState;

    /* renamed from: f, reason: from kotlin metadata */
    public final String lastObservedThreadName;

    /* renamed from: g, reason: from kotlin metadata */
    public final List lastObservedStackTrace;

    /* renamed from: h, reason: from kotlin metadata */
    public final long sequenceNumber;

    public DebuggerInfo(@NotNull DebugCoroutineInfoImpl debugCoroutineInfoImpl, @NotNull CoroutineContext coroutineContext) {
        Long l;
        String str;
        String str2;
        String str3;
        Thread.State state;
        CoroutineId coroutineId = (CoroutineId) coroutineContext.get(CoroutineId.INSTANCE);
        if (coroutineId != null) {
            l = Long.valueOf(coroutineId.getId());
        } else {
            l = null;
        }
        this.coroutineId = l;
        ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) coroutineContext.get(ContinuationInterceptor.INSTANCE);
        if (continuationInterceptor != null) {
            str = continuationInterceptor.toString();
        } else {
            str = null;
        }
        this.dispatcher = str;
        CoroutineName coroutineName = (CoroutineName) coroutineContext.get(CoroutineName.INSTANCE);
        if (coroutineName != null) {
            str2 = coroutineName.getName();
        } else {
            str2 = null;
        }
        this.name = str2;
        this.state = debugCoroutineInfoImpl.get_state();
        Thread thread = debugCoroutineInfoImpl.lastObservedThread;
        if (thread != null && (state = thread.getState()) != null) {
            str3 = state.toString();
        } else {
            str3 = null;
        }
        this.lastObservedThreadState = str3;
        Thread thread2 = debugCoroutineInfoImpl.lastObservedThread;
        this.lastObservedThreadName = thread2 != null ? thread2.getName() : null;
        this.lastObservedStackTrace = debugCoroutineInfoImpl.lastObservedStackTrace$kotlinx_coroutines_core();
        this.sequenceNumber = debugCoroutineInfoImpl.sequenceNumber;
    }

    @Nullable
    public final Long getCoroutineId() {
        return this.coroutineId;
    }

    @Nullable
    public final String getDispatcher() {
        return this.dispatcher;
    }

    @NotNull
    public final List<StackTraceElement> getLastObservedStackTrace() {
        return this.lastObservedStackTrace;
    }

    @Nullable
    public final String getLastObservedThreadName() {
        return this.lastObservedThreadName;
    }

    @Nullable
    public final String getLastObservedThreadState() {
        return this.lastObservedThreadState;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    public final long getSequenceNumber() {
        return this.sequenceNumber;
    }

    @NotNull
    public final String getState() {
        return this.state;
    }
}
