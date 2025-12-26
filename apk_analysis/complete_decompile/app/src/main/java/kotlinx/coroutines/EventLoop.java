package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.internal.LimitedDispatcherKt;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000b\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\tJ\u0019\u0010\u000e\u001a\u00020\r2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b\u0013\u0010\u0012J\u0015\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0018\u0010\u0003R\u0014\u0010\u0019\u001a\u00020\u00078TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\tR\u0014\u0010\u001b\u001a\u00020\u00048TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0006R\u0011\u0010\u001c\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\tR\u0011\u0010\u001d\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\tR\u0011\u0010\u001e\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\t¨\u0006\u001f"}, m5569d2 = {"Lkotlinx/coroutines/EventLoop;", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "()V", "", "processNextEvent", "()J", "", "processUnconfinedEvent", "()Z", "shouldBeProcessedFromContext", "Lkotlinx/coroutines/DispatchedTask;", "task", "", "dispatchUnconfined", "(Lkotlinx/coroutines/DispatchedTask;)V", "unconfined", "incrementUseCount", "(Z)V", "decrementUseCount", "", "parallelism", "limitedParallelism", "(I)Lkotlinx/coroutines/CoroutineDispatcher;", "shutdown", "isEmpty", "getNextTime", "nextTime", "isActive", "isUnconfinedLoopActive", "isUnconfinedQueueEmpty", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nEventLoop.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EventLoop.common.kt\nkotlinx/coroutines/EventLoop\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,543:1\n1#2:544\n*E\n"})
/* loaded from: classes2.dex */
public abstract class EventLoop extends CoroutineDispatcher {

    /* renamed from: b */
    public long f21408b;

    /* renamed from: c */
    public boolean f21409c;

    /* renamed from: d */
    public ArrayDeque f21410d;

    public static /* synthetic */ void decrementUseCount$default(EventLoop eventLoop, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = false;
            }
            eventLoop.decrementUseCount(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decrementUseCount");
    }

    public static /* synthetic */ void incrementUseCount$default(EventLoop eventLoop, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = false;
            }
            eventLoop.incrementUseCount(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
    }

    public final void decrementUseCount(boolean unconfined) {
        long j;
        long j2 = this.f21408b;
        if (unconfined) {
            j = 4294967296L;
        } else {
            j = 1;
        }
        long j3 = j2 - j;
        this.f21408b = j3;
        if (j3 <= 0 && this.f21409c) {
            shutdown();
        }
    }

    public final void dispatchUnconfined(@NotNull DispatchedTask<?> task) {
        ArrayDeque arrayDeque = this.f21410d;
        if (arrayDeque == null) {
            arrayDeque = new ArrayDeque();
            this.f21410d = arrayDeque;
        }
        arrayDeque.addLast(task);
    }

    public long getNextTime() {
        ArrayDeque arrayDeque = this.f21410d;
        if (arrayDeque == null || arrayDeque.isEmpty()) {
            return Long.MAX_VALUE;
        }
        return 0L;
    }

    public final void incrementUseCount(boolean unconfined) {
        long j;
        long j2 = this.f21408b;
        if (unconfined) {
            j = 4294967296L;
        } else {
            j = 1;
        }
        this.f21408b = j + j2;
        if (!unconfined) {
            this.f21409c = true;
        }
    }

    public final boolean isActive() {
        if (this.f21408b > 0) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        return isUnconfinedQueueEmpty();
    }

    public final boolean isUnconfinedLoopActive() {
        if (this.f21408b >= 4294967296L) {
            return true;
        }
        return false;
    }

    public final boolean isUnconfinedQueueEmpty() {
        ArrayDeque arrayDeque = this.f21410d;
        if (arrayDeque != null) {
            return arrayDeque.isEmpty();
        }
        return true;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @NotNull
    public final CoroutineDispatcher limitedParallelism(int parallelism) {
        LimitedDispatcherKt.checkParallelism(parallelism);
        return this;
    }

    public long processNextEvent() {
        if (!processUnconfinedEvent()) {
            return Long.MAX_VALUE;
        }
        return 0L;
    }

    public final boolean processUnconfinedEvent() {
        DispatchedTask dispatchedTask;
        ArrayDeque arrayDeque = this.f21410d;
        if (arrayDeque == null || (dispatchedTask = (DispatchedTask) arrayDeque.removeFirstOrNull()) == null) {
            return false;
        }
        dispatchedTask.run();
        return true;
    }

    public boolean shouldBeProcessedFromContext() {
        return false;
    }

    public void shutdown() {
    }
}
