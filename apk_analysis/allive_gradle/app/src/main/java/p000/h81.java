package p000;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.Volatile;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.scheduling.ExperimentalCoroutineDispatcher;
import kotlinx.coroutines.scheduling.TaskContext;

/* loaded from: classes2.dex */
public final class h81 extends ExecutorCoroutineDispatcher implements TaskContext, Executor {

    /* renamed from: f */
    public static final AtomicIntegerFieldUpdater f17970f = AtomicIntegerFieldUpdater.newUpdater(h81.class, "inFlightTasks");

    /* renamed from: b */
    public final ExperimentalCoroutineDispatcher f17971b;

    /* renamed from: c */
    public final int f17972c;

    /* renamed from: d */
    public final int f17973d;

    /* renamed from: e */
    public final ConcurrentLinkedQueue f17974e = new ConcurrentLinkedQueue();

    @Volatile
    private volatile int inFlightTasks;

    public h81(ExperimentalCoroutineDispatcher experimentalCoroutineDispatcher, int i, int i2) {
        this.f17971b = experimentalCoroutineDispatcher;
        this.f17972c = i;
        this.f17973d = i2;
    }

    /* renamed from: a */
    public final void m5045a(Runnable runnable, boolean z) {
        do {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f17970f;
            int incrementAndGet = atomicIntegerFieldUpdater.incrementAndGet(this);
            int i = this.f17972c;
            if (incrementAndGet <= i) {
                this.f17971b.dispatchWithContext$kotlinx_coroutines_core(runnable, this, z);
                return;
            }
            ConcurrentLinkedQueue concurrentLinkedQueue = this.f17974e;
            concurrentLinkedQueue.add(runnable);
            if (atomicIntegerFieldUpdater.decrementAndGet(this) >= i) {
                return;
            } else {
                runnable = (Runnable) concurrentLinkedQueue.poll();
            }
        } while (runnable != null);
    }

    @Override // kotlinx.coroutines.scheduling.TaskContext
    public final void afterTask() {
        ConcurrentLinkedQueue concurrentLinkedQueue = this.f17974e;
        Runnable runnable = (Runnable) concurrentLinkedQueue.poll();
        if (runnable != null) {
            this.f17971b.dispatchWithContext$kotlinx_coroutines_core(runnable, this, true);
            return;
        }
        f17970f.decrementAndGet(this);
        Runnable runnable2 = (Runnable) concurrentLinkedQueue.poll();
        if (runnable2 == null) {
            return;
        }
        m5045a(runnable2, true);
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new IllegalStateException("Close cannot be invoked on LimitingBlockingDispatcher");
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        m5045a(runnable, false);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        m5045a(runnable, true);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        m5045a(runnable, false);
    }

    @Override // kotlinx.coroutines.scheduling.TaskContext
    public final int getTaskMode() {
        return this.f17973d;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final String toString() {
        return super.toString() + "[dispatcher = " + this.f17971b + ']';
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    public final Executor getExecutor() {
        return this;
    }
}
