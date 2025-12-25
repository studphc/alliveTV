package kotlinx.coroutines;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.DurationKt;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.ThreadSafeHeap;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.r82;

@Metadata(m5568d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\b \u0018\u00002\u00020\u00012\u00020\u0002:\u0004./01B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J%\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u0011\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00072\n\u0010\u000f\u001a\u00060\rj\u0002`\u000eH\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00152\n\u0010\u000f\u001a\u00060\rj\u0002`\u000e¢\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u001a\u001a\u00020\u00052\n\u0010\u0019\u001a\u00060\rj\u0002`\u000eH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0005H\u0004¢\u0006\u0004\b!\u0010\u0004R\u0014\u0010#\u001a\u00020\"8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010&\u001a\u00020\u00078TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u0014R\u0013\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010(0'8\u0002X\u0082\u0004R\u000b\u0010+\u001a\u00020*8\u0002X\u0082\u0004R\u0013\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010,0'8\u0002X\u0082\u0004¨\u00062"}, m5569d2 = {"Lkotlinx/coroutines/EventLoopImplBase;", "Lkotlinx/coroutines/EventLoopImplPlatform;", "Lkotlinx/coroutines/Delay;", "<init>", "()V", "", "shutdown", "", "timeMillis", "Lkotlinx/coroutines/CancellableContinuation;", "continuation", "scheduleResumeAfterDelay", "(JLkotlinx/coroutines/CancellableContinuation;)V", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lkotlinx/coroutines/DisposableHandle;", "scheduleInvokeOnTimeout", "(JLjava/lang/Runnable;)Lkotlinx/coroutines/DisposableHandle;", "processNextEvent", "()J", "Lkotlin/coroutines/CoroutineContext;", "context", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "task", "enqueue", "(Ljava/lang/Runnable;)V", "now", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "delayedTask", "schedule", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTask;)V", "resetAll", "", "isEmpty", "()Z", "getNextTime", "nextTime", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "_delayed", "Lkotlinx/atomicfu/AtomicBoolean;", "_isCompleted", "", "_queue", "kotlinx/coroutines/b", "kotlinx/coroutines/c", "DelayedTask", "DelayedTaskQueue", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nEventLoop.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EventLoop.common.kt\nkotlinx/coroutines/EventLoopImplBase\n+ 2 ThreadSafeHeap.kt\nkotlinx/coroutines/internal/ThreadSafeHeap\n+ 3 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 4 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 5 EventLoop.kt\nkotlinx/coroutines/EventLoopKt\n+ 6 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,543:1\n60#2:544\n61#2,7:550\n28#3,4:545\n20#4:549\n56#5:557\n1#6:558\n*S KotlinDebug\n*F\n+ 1 EventLoop.common.kt\nkotlinx/coroutines/EventLoopImplBase\n*L\n269#1:544\n269#1:550,7\n269#1:545,4\n269#1:549\n280#1:557\n*E\n"})
/* loaded from: classes2.dex */
public abstract class EventLoopImplBase extends EventLoopImplPlatform implements Delay {

    /* renamed from: e */
    public static final AtomicReferenceFieldUpdater f21411e = AtomicReferenceFieldUpdater.newUpdater(EventLoopImplBase.class, Object.class, "_queue");

    /* renamed from: f */
    public static final AtomicReferenceFieldUpdater f21412f = AtomicReferenceFieldUpdater.newUpdater(EventLoopImplBase.class, Object.class, "_delayed");

    /* renamed from: g */
    public static final AtomicIntegerFieldUpdater f21413g = AtomicIntegerFieldUpdater.newUpdater(EventLoopImplBase.class, "_isCompleted");

    @Volatile
    @Nullable
    private volatile Object _delayed;

    @Volatile
    private volatile int _isCompleted = 0;

    @Volatile
    @Nullable
    private volatile Object _queue;

    @Metadata(m5568d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\b \u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u00032\u00020\u00042\u00020\u00052\u00060\u0006j\u0002`\u0007B\u000f\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\b¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\u0016\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010 R\u0018\u0010!\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\"\u0010)\u001a\u00020\r8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R0\u00100\u001a\b\u0012\u0002\b\u0003\u0018\u00010*2\f\u0010+\u001a\b\u0012\u0002\b\u0003\u0018\u00010*8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u00061"}, m5569d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "", "nanoTime", "<init>", "(J)V", "other", "", "compareTo", "(Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;)I", "now", "", "timeToExecute", "(J)Z", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "delayed", "Lkotlinx/coroutines/EventLoopImplBase;", "eventLoop", "scheduleTask", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;Lkotlinx/coroutines/EventLoopImplBase;)I", "", "dispose", "()V", "", "toString", "()Ljava/lang/String;", "J", "_heap", "Ljava/lang/Object;", "a", "I", "getIndex", "()I", "setIndex", "(I)V", FirebaseAnalytics.Param.INDEX, "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "value", "getHeap", "()Lkotlinx/coroutines/internal/ThreadSafeHeap;", "setHeap", "(Lkotlinx/coroutines/internal/ThreadSafeHeap;)V", "heap", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    @SourceDebugExtension({"SMAP\nEventLoop.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EventLoop.common.kt\nkotlinx/coroutines/EventLoopImplBase$DelayedTask\n+ 2 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 3 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 4 ThreadSafeHeap.kt\nkotlinx/coroutines/internal/ThreadSafeHeap\n*L\n1#1,543:1\n28#2,4:544\n28#2,4:550\n28#2,4:562\n20#3:548\n20#3:554\n20#3:566\n72#4:549\n73#4,7:555\n*S KotlinDebug\n*F\n+ 1 EventLoop.common.kt\nkotlinx/coroutines/EventLoopImplBase$DelayedTask\n*L\n437#1:544,4\n439#1:550,4\n479#1:562,4\n437#1:548\n439#1:554\n479#1:566\n439#1:549\n439#1:555,7\n*E\n"})
    /* loaded from: classes2.dex */
    public static abstract class DelayedTask implements Runnable, Comparable<DelayedTask>, DisposableHandle, ThreadSafeHeapNode {

        @Nullable
        private volatile Object _heap;

        /* renamed from: a, reason: from kotlin metadata */
        public int index = -1;

        @JvmField
        public long nanoTime;

        public DelayedTask(long j) {
            this.nanoTime = j;
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public final void dispose() {
            Symbol symbol;
            DelayedTaskQueue delayedTaskQueue;
            Symbol symbol2;
            synchronized (this) {
                try {
                    Object obj = this._heap;
                    symbol = EventLoop_commonKt.f21415a;
                    if (obj == symbol) {
                        return;
                    }
                    if (obj instanceof DelayedTaskQueue) {
                        delayedTaskQueue = (DelayedTaskQueue) obj;
                    } else {
                        delayedTaskQueue = null;
                    }
                    if (delayedTaskQueue != null) {
                        delayedTaskQueue.remove(this);
                    }
                    symbol2 = EventLoop_commonKt.f21415a;
                    this._heap = symbol2;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        @Nullable
        public ThreadSafeHeap<?> getHeap() {
            Object obj = this._heap;
            if (obj instanceof ThreadSafeHeap) {
                return (ThreadSafeHeap) obj;
            }
            return null;
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public int getIndex() {
            return this.index;
        }

        public final int scheduleTask(long now, @NotNull DelayedTaskQueue delayed, @NotNull EventLoopImplBase eventLoop) {
            Symbol symbol;
            synchronized (this) {
                Object obj = this._heap;
                symbol = EventLoop_commonKt.f21415a;
                if (obj == symbol) {
                    return 2;
                }
                synchronized (delayed) {
                    try {
                        DelayedTask firstImpl = delayed.firstImpl();
                        if (EventLoopImplBase.access$isCompleted(eventLoop)) {
                            return 1;
                        }
                        if (firstImpl == null) {
                            delayed.timeNow = now;
                        } else {
                            long j = firstImpl.nanoTime;
                            if (j - now < 0) {
                                now = j;
                            }
                            if (now - delayed.timeNow > 0) {
                                delayed.timeNow = now;
                            }
                        }
                        long j2 = this.nanoTime;
                        long j3 = delayed.timeNow;
                        if (j2 - j3 < 0) {
                            this.nanoTime = j3;
                        }
                        delayed.addImpl(this);
                        return 0;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public void setHeap(@Nullable ThreadSafeHeap<?> threadSafeHeap) {
            Symbol symbol;
            Object obj = this._heap;
            symbol = EventLoop_commonKt.f21415a;
            if (obj != symbol) {
                this._heap = threadSafeHeap;
                return;
            }
            throw new IllegalArgumentException("Failed requirement.");
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public void setIndex(int i) {
            this.index = i;
        }

        public final boolean timeToExecute(long now) {
            if (now - this.nanoTime >= 0) {
                return true;
            }
            return false;
        }

        @NotNull
        public String toString() {
            return "Delayed[nanos=" + this.nanoTime + ']';
        }

        @Override // java.lang.Comparable
        public int compareTo(@NotNull DelayedTask other) {
            long j = this.nanoTime - other.nanoTime;
            if (j > 0) {
                return 1;
            }
            return j < 0 ? -1 : 0;
        }
    }

    @Metadata(m5568d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m5569d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "timeNow", "", "(J)V", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class DelayedTaskQueue extends ThreadSafeHeap<DelayedTask> {

        @JvmField
        public long timeNow;

        public DelayedTaskQueue(long j) {
            this.timeNow = j;
        }
    }

    public static final boolean access$isCompleted(EventLoopImplBase eventLoopImplBase) {
        eventLoopImplBase.getClass();
        if (f21413g.get(eventLoopImplBase) != 0) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public final boolean m5665a(Runnable runnable) {
        boolean z;
        Symbol symbol;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f21411e;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (f21413g.get(this) != 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return false;
            }
            if (obj == null) {
                while (!atomicReferenceFieldUpdater.compareAndSet(this, null, runnable)) {
                    if (atomicReferenceFieldUpdater.get(this) != null) {
                        break;
                    }
                }
                return true;
            }
            if (!(obj instanceof LockFreeTaskQueueCore)) {
                symbol = EventLoop_commonKt.f21416b;
                if (obj == symbol) {
                    return false;
                }
                LockFreeTaskQueueCore lockFreeTaskQueueCore = new LockFreeTaskQueueCore(8, true);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                lockFreeTaskQueueCore.addLast((Runnable) obj);
                lockFreeTaskQueueCore.addLast(runnable);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, lockFreeTaskQueueCore)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                        break;
                    }
                }
                return true;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
            LockFreeTaskQueueCore lockFreeTaskQueueCore2 = (LockFreeTaskQueueCore) obj;
            int addLast = lockFreeTaskQueueCore2.addLast(runnable);
            if (addLast == 0) {
                return true;
            }
            if (addLast != 1) {
                if (addLast == 2) {
                    return false;
                }
            } else {
                LockFreeTaskQueueCore next = lockFreeTaskQueueCore2.next();
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, next) && atomicReferenceFieldUpdater.get(this) == obj) {
                }
            }
        }
    }

    @Override // kotlinx.coroutines.Delay
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated without replacement as an internal method never intended for public use")
    @Nullable
    public Object delay(long j, @NotNull Continuation<? super Unit> continuation) {
        return Delay.DefaultImpls.delay(this, j, continuation);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatch(@NotNull CoroutineContext context, @NotNull Runnable block) {
        enqueue(block);
    }

    public void enqueue(@NotNull Runnable task) {
        if (m5665a(task)) {
            unpark();
        } else {
            DefaultExecutor.INSTANCE.enqueue(task);
        }
    }

    @Override // kotlinx.coroutines.EventLoop
    public long getNextTime() {
        DelayedTask peek;
        long nanoTime;
        Symbol symbol;
        if (super.getNextTime() == 0) {
            return 0L;
        }
        Object obj = f21411e.get(this);
        if (obj != null) {
            if (!(obj instanceof LockFreeTaskQueueCore)) {
                symbol = EventLoop_commonKt.f21416b;
                if (obj != symbol) {
                    return 0L;
                }
                return Long.MAX_VALUE;
            }
            if (!((LockFreeTaskQueueCore) obj).isEmpty()) {
                return 0L;
            }
        }
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) f21412f.get(this);
        if (delayedTaskQueue == null || (peek = delayedTaskQueue.peek()) == null) {
            return Long.MAX_VALUE;
        }
        long j = peek.nanoTime;
        AbstractTimeSource timeSource = AbstractTimeSourceKt.getTimeSource();
        if (timeSource != null) {
            nanoTime = timeSource.nanoTime();
        } else {
            nanoTime = System.nanoTime();
        }
        return r82.coerceAtLeast(j - nanoTime, 0L);
    }

    @NotNull
    public DisposableHandle invokeOnTimeout(long j, @NotNull Runnable runnable, @NotNull CoroutineContext coroutineContext) {
        return Delay.DefaultImpls.invokeOnTimeout(this, j, runnable, coroutineContext);
    }

    @Override // kotlinx.coroutines.EventLoop
    public boolean isEmpty() {
        Symbol symbol;
        if (!isUnconfinedQueueEmpty()) {
            return false;
        }
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) f21412f.get(this);
        if (delayedTaskQueue != null && !delayedTaskQueue.isEmpty()) {
            return false;
        }
        Object obj = f21411e.get(this);
        if (obj != null) {
            if (!(obj instanceof LockFreeTaskQueueCore)) {
                symbol = EventLoop_commonKt.f21416b;
                if (obj != symbol) {
                    return false;
                }
            } else {
                return ((LockFreeTaskQueueCore) obj).isEmpty();
            }
        }
        return true;
    }

    @Override // kotlinx.coroutines.EventLoop
    public long processNextEvent() {
        Symbol symbol;
        long nanoTime;
        boolean z;
        DelayedTask delayedTask;
        if (processUnconfinedEvent()) {
            return 0L;
        }
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) f21412f.get(this);
        Runnable runnable = null;
        if (delayedTaskQueue != null && !delayedTaskQueue.isEmpty()) {
            AbstractTimeSource timeSource = AbstractTimeSourceKt.getTimeSource();
            if (timeSource != null) {
                nanoTime = timeSource.nanoTime();
            } else {
                nanoTime = System.nanoTime();
            }
            do {
                synchronized (delayedTaskQueue) {
                    try {
                        DelayedTask firstImpl = delayedTaskQueue.firstImpl();
                        if (firstImpl == null) {
                            delayedTask = null;
                        } else {
                            DelayedTask delayedTask2 = firstImpl;
                            if (delayedTask2.timeToExecute(nanoTime)) {
                                z = m5665a(delayedTask2);
                            } else {
                                z = false;
                            }
                            if (z) {
                                delayedTask = delayedTaskQueue.removeAtImpl(0);
                            } else {
                                delayedTask = null;
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } while (delayedTask != null);
        }
        loop1: while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f21411e;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                break;
            }
            if (!(obj instanceof LockFreeTaskQueueCore)) {
                symbol = EventLoop_commonKt.f21416b;
                if (obj == symbol) {
                    break;
                }
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, null)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                        break;
                    }
                }
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                runnable = (Runnable) obj;
                break loop1;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
            LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) obj;
            Object removeFirstOrNull = lockFreeTaskQueueCore.removeFirstOrNull();
            if (removeFirstOrNull != LockFreeTaskQueueCore.REMOVE_FROZEN) {
                runnable = (Runnable) removeFirstOrNull;
                break;
            }
            LockFreeTaskQueueCore next = lockFreeTaskQueueCore.next();
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, next) && atomicReferenceFieldUpdater.get(this) == obj) {
            }
        }
        if (runnable != null) {
            runnable.run();
            return 0L;
        }
        return getNextTime();
    }

    public final void resetAll() {
        f21411e.set(this, null);
        f21412f.set(this, null);
    }

    public final void schedule(long now, @NotNull DelayedTask delayedTask) {
        boolean z;
        int scheduleTask;
        if (f21413g.get(this) != 0) {
            z = true;
        } else {
            z = false;
        }
        DelayedTask delayedTask2 = null;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f21412f;
        if (z) {
            scheduleTask = 1;
        } else {
            DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) atomicReferenceFieldUpdater.get(this);
            if (delayedTaskQueue == null) {
                DelayedTaskQueue delayedTaskQueue2 = new DelayedTaskQueue(now);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, null, delayedTaskQueue2) && atomicReferenceFieldUpdater.get(this) == null) {
                }
                Object obj = atomicReferenceFieldUpdater.get(this);
                Intrinsics.checkNotNull(obj);
                delayedTaskQueue = (DelayedTaskQueue) obj;
            }
            scheduleTask = delayedTask.scheduleTask(now, delayedTaskQueue, this);
        }
        if (scheduleTask != 0) {
            if (scheduleTask != 1) {
                if (scheduleTask != 2) {
                    throw new IllegalStateException("unexpected result");
                }
                return;
            } else {
                reschedule(now, delayedTask);
                return;
            }
        }
        DelayedTaskQueue delayedTaskQueue3 = (DelayedTaskQueue) atomicReferenceFieldUpdater.get(this);
        if (delayedTaskQueue3 != null) {
            delayedTask2 = delayedTaskQueue3.peek();
        }
        if (delayedTask2 == delayedTask) {
            unpark();
        }
    }

    @NotNull
    public final DisposableHandle scheduleInvokeOnTimeout(long timeMillis, @NotNull Runnable block) {
        long nanoTime;
        long delayToNanos = EventLoop_commonKt.delayToNanos(timeMillis);
        if (delayToNanos < DurationKt.MAX_MILLIS) {
            AbstractTimeSource timeSource = AbstractTimeSourceKt.getTimeSource();
            if (timeSource != null) {
                nanoTime = timeSource.nanoTime();
            } else {
                nanoTime = System.nanoTime();
            }
            C1411c c1411c = new C1411c(delayToNanos + nanoTime, block);
            schedule(nanoTime, c1411c);
            return c1411c;
        }
        return NonDisposableHandle.INSTANCE;
    }

    @Override // kotlinx.coroutines.Delay
    public void scheduleResumeAfterDelay(long timeMillis, @NotNull CancellableContinuation<? super Unit> continuation) {
        long nanoTime;
        long delayToNanos = EventLoop_commonKt.delayToNanos(timeMillis);
        if (delayToNanos < DurationKt.MAX_MILLIS) {
            AbstractTimeSource timeSource = AbstractTimeSourceKt.getTimeSource();
            if (timeSource != null) {
                nanoTime = timeSource.nanoTime();
            } else {
                nanoTime = System.nanoTime();
            }
            C1410b c1410b = new C1410b(this, delayToNanos + nanoTime, continuation);
            schedule(nanoTime, c1410b);
            CancellableContinuationKt.disposeOnCancellation(continuation, c1410b);
        }
    }

    @Override // kotlinx.coroutines.EventLoop
    public void shutdown() {
        Symbol symbol;
        long nanoTime;
        DelayedTask removeFirstOrNull;
        Symbol symbol2;
        ThreadLocalEventLoop.INSTANCE.resetEventLoop$kotlinx_coroutines_core();
        f21413g.set(this, 1);
        loop0: while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f21411e;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                symbol = EventLoop_commonKt.f21416b;
                while (!atomicReferenceFieldUpdater.compareAndSet(this, null, symbol)) {
                    if (atomicReferenceFieldUpdater.get(this) != null) {
                        break;
                    }
                }
                break loop0;
            }
            if (!(obj instanceof LockFreeTaskQueueCore)) {
                symbol2 = EventLoop_commonKt.f21416b;
                if (obj != symbol2) {
                    LockFreeTaskQueueCore lockFreeTaskQueueCore = new LockFreeTaskQueueCore(8, true);
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                    lockFreeTaskQueueCore.addLast((Runnable) obj);
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, lockFreeTaskQueueCore)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj) {
                            break;
                        }
                    }
                    break loop0;
                }
                break;
            }
            ((LockFreeTaskQueueCore) obj).close();
            break;
        }
        do {
        } while (processNextEvent() <= 0);
        AbstractTimeSource timeSource = AbstractTimeSourceKt.getTimeSource();
        if (timeSource != null) {
            nanoTime = timeSource.nanoTime();
        } else {
            nanoTime = System.nanoTime();
        }
        while (true) {
            DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) f21412f.get(this);
            if (delayedTaskQueue != null && (removeFirstOrNull = delayedTaskQueue.removeFirstOrNull()) != null) {
                reschedule(nanoTime, removeFirstOrNull);
            } else {
                return;
            }
        }
    }
}
