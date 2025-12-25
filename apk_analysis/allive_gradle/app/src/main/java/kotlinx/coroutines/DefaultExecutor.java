package kotlinx.coroutines;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.EventLoopImplBase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.r82;

@Metadata(m5568d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003J\u001b\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ+\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\b2\n\u0010\u0011\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0017\u0010\u000fJ\u000f\u0010\u0019\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u0018\u0010\u000fJ\u0015\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\b¢\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u001d8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001e\u0010!\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b!\u0010\"\u0012\u0004\b#\u0010\u000fR\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010)\u001a\u00020 8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,¨\u0006."}, m5569d2 = {"Lkotlinx/coroutines/DefaultExecutor;", "Lkotlinx/coroutines/EventLoopImplBase;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "task", "", "enqueue", "(Ljava/lang/Runnable;)V", "", "now", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "delayedTask", "reschedule", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTask;)V", "shutdown", "()V", "timeMillis", "block", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnTimeout", "(JLjava/lang/Runnable;Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/DisposableHandle;", "run", "ensureStarted$kotlinx_coroutines_core", "ensureStarted", "timeout", "shutdownForTests", "(J)V", "", "THREAD_NAME", "Ljava/lang/String;", "Ljava/lang/Thread;", "_thread", "Ljava/lang/Thread;", "get_thread$annotations", "", "debugStatus", "I", "getThread", "()Ljava/lang/Thread;", "thread", "", "isThreadPresent$kotlinx_coroutines_core", "()Z", "isThreadPresent", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nDefaultExecutor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DefaultExecutor.kt\nkotlinx/coroutines/DefaultExecutor\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,187:1\n1#2:188\n*E\n"})
/* loaded from: classes2.dex */
public final class DefaultExecutor extends EventLoopImplBase implements Runnable {

    @NotNull
    public static final DefaultExecutor INSTANCE;

    @NotNull
    public static final String THREAD_NAME = "kotlinx.coroutines.DefaultExecutor";

    @Nullable
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* renamed from: h */
    public static final long f21401h;

    /* JADX WARN: Type inference failed for: r0v0, types: [kotlinx.coroutines.DefaultExecutor, kotlinx.coroutines.EventLoopImplBase, kotlinx.coroutines.EventLoop] */
    static {
        Long l;
        ?? eventLoopImplBase = new EventLoopImplBase();
        INSTANCE = eventLoopImplBase;
        EventLoop.incrementUseCount$default(eventLoopImplBase, false, 1, null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l = 1000L;
        }
        f21401h = timeUnit.toNanos(l.longValue());
    }

    /* renamed from: d */
    public static boolean m5662d() {
        int i = debugStatus;
        if (i != 2 && i != 3) {
            return false;
        }
        return true;
    }

    /* renamed from: b */
    public final synchronized void m5663b() {
        if (!m5662d()) {
            return;
        }
        debugStatus = 3;
        resetAll();
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
        notifyAll();
    }

    /* renamed from: c */
    public final synchronized Thread m5664c() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, THREAD_NAME);
            _thread = thread;
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    @Override // kotlinx.coroutines.EventLoopImplBase
    public void enqueue(@NotNull Runnable task) {
        if (debugStatus != 4) {
            super.enqueue(task);
            return;
        }
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    public final synchronized void ensureStarted$kotlinx_coroutines_core() {
        debugStatus = 0;
        m5664c();
        while (debugStatus == 0) {
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
            wait();
        }
    }

    @Override // kotlinx.coroutines.EventLoopImplPlatform
    @NotNull
    public Thread getThread() {
        Thread thread = _thread;
        if (thread == null) {
            return m5664c();
        }
        return thread;
    }

    @Override // kotlinx.coroutines.EventLoopImplBase, kotlinx.coroutines.Delay
    @NotNull
    public DisposableHandle invokeOnTimeout(long timeMillis, @NotNull Runnable block, @NotNull CoroutineContext context) {
        return scheduleInvokeOnTimeout(timeMillis, block);
    }

    public final boolean isThreadPresent$kotlinx_coroutines_core() {
        if (_thread != null) {
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.EventLoopImplPlatform
    public void reschedule(long now, @NotNull EventLoopImplBase.DelayedTask delayedTask) {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @Override // java.lang.Runnable
    public void run() {
        Unit unit;
        long nanoTime;
        ThreadLocalEventLoop.INSTANCE.setEventLoop$kotlinx_coroutines_core(this);
        AbstractTimeSource timeSource = AbstractTimeSourceKt.getTimeSource();
        if (timeSource != null) {
            timeSource.registerTimeLoopThread();
        }
        try {
            synchronized (this) {
                if (m5662d()) {
                    _thread = null;
                    m5663b();
                    AbstractTimeSource timeSource2 = AbstractTimeSourceKt.getTimeSource();
                    if (timeSource2 != null) {
                        timeSource2.unregisterTimeLoopThread();
                    }
                    if (!isEmpty()) {
                        getThread();
                        return;
                    }
                    return;
                }
                debugStatus = 1;
                Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
                notifyAll();
                long j = Long.MAX_VALUE;
                while (true) {
                    Thread.interrupted();
                    long processNextEvent = processNextEvent();
                    if (processNextEvent == Long.MAX_VALUE) {
                        AbstractTimeSource timeSource3 = AbstractTimeSourceKt.getTimeSource();
                        if (timeSource3 != null) {
                            nanoTime = timeSource3.nanoTime();
                        } else {
                            nanoTime = System.nanoTime();
                        }
                        if (j == Long.MAX_VALUE) {
                            j = f21401h + nanoTime;
                        }
                        long j2 = j - nanoTime;
                        if (j2 <= 0) {
                            _thread = null;
                            m5663b();
                            AbstractTimeSource timeSource4 = AbstractTimeSourceKt.getTimeSource();
                            if (timeSource4 != null) {
                                timeSource4.unregisterTimeLoopThread();
                            }
                            if (!isEmpty()) {
                                getThread();
                                return;
                            }
                            return;
                        }
                        processNextEvent = r82.coerceAtMost(processNextEvent, j2);
                    } else {
                        j = Long.MAX_VALUE;
                    }
                    if (processNextEvent > 0) {
                        if (m5662d()) {
                            _thread = null;
                            m5663b();
                            AbstractTimeSource timeSource5 = AbstractTimeSourceKt.getTimeSource();
                            if (timeSource5 != null) {
                                timeSource5.unregisterTimeLoopThread();
                            }
                            if (!isEmpty()) {
                                getThread();
                                return;
                            }
                            return;
                        }
                        AbstractTimeSource timeSource6 = AbstractTimeSourceKt.getTimeSource();
                        if (timeSource6 != null) {
                            timeSource6.parkNanos(this, processNextEvent);
                            unit = Unit.INSTANCE;
                        } else {
                            unit = null;
                        }
                        if (unit == null) {
                            LockSupport.parkNanos(this, processNextEvent);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            _thread = null;
            m5663b();
            AbstractTimeSource timeSource7 = AbstractTimeSourceKt.getTimeSource();
            if (timeSource7 != null) {
                timeSource7.unregisterTimeLoopThread();
            }
            if (!isEmpty()) {
                getThread();
            }
            throw th;
        }
    }

    @Override // kotlinx.coroutines.EventLoopImplBase, kotlinx.coroutines.EventLoop
    public void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }

    public final synchronized void shutdownForTests(long timeout) {
        Unit unit;
        try {
            long currentTimeMillis = System.currentTimeMillis() + timeout;
            if (!m5662d()) {
                debugStatus = 2;
            }
            while (debugStatus != 3 && _thread != null) {
                Thread thread = _thread;
                if (thread != null) {
                    AbstractTimeSource timeSource = AbstractTimeSourceKt.getTimeSource();
                    if (timeSource != null) {
                        timeSource.unpark(thread);
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                    if (unit == null) {
                        LockSupport.unpark(thread);
                    }
                }
                if (currentTimeMillis - System.currentTimeMillis() <= 0) {
                    break;
                }
                Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
                wait(timeout);
            }
            debugStatus = 0;
        } catch (Throwable th) {
            throw th;
        }
    }
}
