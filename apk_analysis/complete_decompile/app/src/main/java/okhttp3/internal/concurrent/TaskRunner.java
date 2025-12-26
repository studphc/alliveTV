package okhttp3.internal.concurrent;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.ye0;

@Metadata(m5568d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0010\u0018\u0000  2\u00020\u0001:\u0003! \"B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\n¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0005\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006#"}, m5569d2 = {"Lokhttp3/internal/concurrent/TaskRunner;", "", "Lokhttp3/internal/concurrent/TaskRunner$Backend;", "backend", "Ljava/util/logging/Logger;", "logger", "<init>", "(Lokhttp3/internal/concurrent/TaskRunner$Backend;Ljava/util/logging/Logger;)V", "Lokhttp3/internal/concurrent/TaskQueue;", "taskQueue", "", "kickCoordinator$okhttp", "(Lokhttp3/internal/concurrent/TaskQueue;)V", "kickCoordinator", "Lokhttp3/internal/concurrent/Task;", "awaitTaskToRun", "()Lokhttp3/internal/concurrent/Task;", "newQueue", "()Lokhttp3/internal/concurrent/TaskQueue;", "", "activeQueues", "()Ljava/util/List;", "cancelAll", "()V", "a", "Lokhttp3/internal/concurrent/TaskRunner$Backend;", "getBackend", "()Lokhttp3/internal/concurrent/TaskRunner$Backend;", "b", "Ljava/util/logging/Logger;", "getLogger$okhttp", "()Ljava/util/logging/Logger;", "Companion", "Backend", "RealBackend", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class TaskRunner {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @JvmField
    @NotNull
    public static final TaskRunner INSTANCE;

    /* renamed from: i */
    public static final Logger f24259i;

    /* renamed from: a, reason: from kotlin metadata */
    public final Backend backend;

    /* renamed from: b, reason: from kotlin metadata */
    public final Logger logger;

    /* renamed from: c */
    public int f24262c;

    /* renamed from: d */
    public boolean f24263d;

    /* renamed from: e */
    public long f24264e;

    /* renamed from: f */
    public final ArrayList f24265f;

    /* renamed from: g */
    public final ArrayList f24266g;

    /* renamed from: h */
    public final TaskRunner$runnable$1 f24267h;

    @Metadata(m5568d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\"\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u000b0\n\"\u0004\b\u0000\u0010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\nH&J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\bH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0001"}, m5569d2 = {"Lokhttp3/internal/concurrent/TaskRunner$Backend;", "", "coordinatorNotify", "", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "coordinatorWait", "nanos", "", "decorate", "Ljava/util/concurrent/BlockingQueue;", ExifInterface.GPS_DIRECTION_TRUE, "queue", "execute", "runnable", "Ljava/lang/Runnable;", "nanoTime", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public interface Backend {
        void coordinatorNotify(@NotNull TaskRunner taskRunner);

        void coordinatorWait(@NotNull TaskRunner taskRunner, long nanos);

        @NotNull
        <T> BlockingQueue<T> decorate(@NotNull BlockingQueue<T> queue);

        void execute(@NotNull TaskRunner taskRunner, @NotNull Runnable runnable);

        long nanoTime();
    }

    @Metadata(m5568d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\n"}, m5569d2 = {"Lokhttp3/internal/concurrent/TaskRunner$Companion;", "", "Ljava/util/logging/Logger;", "logger", "Ljava/util/logging/Logger;", "getLogger", "()Ljava/util/logging/Logger;", "Lokhttp3/internal/concurrent/TaskRunner;", "INSTANCE", "Lokhttp3/internal/concurrent/TaskRunner;", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        @NotNull
        public final Logger getLogger() {
            return TaskRunner.f24259i;
        }
    }

    @Metadata(m5568d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012\"\u0004\b\u0000\u0010\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\u000b¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, m5569d2 = {"Lokhttp3/internal/concurrent/TaskRunner$RealBackend;", "Lokhttp3/internal/concurrent/TaskRunner$Backend;", "Ljava/util/concurrent/ThreadFactory;", "threadFactory", "<init>", "(Ljava/util/concurrent/ThreadFactory;)V", "", "nanoTime", "()J", "Lokhttp3/internal/concurrent/TaskRunner;", "taskRunner", "", "coordinatorNotify", "(Lokhttp3/internal/concurrent/TaskRunner;)V", "nanos", "coordinatorWait", "(Lokhttp3/internal/concurrent/TaskRunner;J)V", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/concurrent/BlockingQueue;", "queue", "decorate", "(Ljava/util/concurrent/BlockingQueue;)Ljava/util/concurrent/BlockingQueue;", "Ljava/lang/Runnable;", "runnable", "execute", "(Lokhttp3/internal/concurrent/TaskRunner;Ljava/lang/Runnable;)V", "shutdown", "()V", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class RealBackend implements Backend {

        /* renamed from: a */
        public final ThreadPoolExecutor f24268a;

        public RealBackend(@NotNull ThreadFactory threadFactory) {
            Intrinsics.checkNotNullParameter(threadFactory, "threadFactory");
            this.f24268a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), threadFactory);
        }

        @Override // okhttp3.internal.concurrent.TaskRunner.Backend
        public void coordinatorNotify(@NotNull TaskRunner taskRunner) {
            Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
            taskRunner.notify();
        }

        @Override // okhttp3.internal.concurrent.TaskRunner.Backend
        public void coordinatorWait(@NotNull TaskRunner taskRunner, long nanos) {
            Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
            long j = nanos / 1000000;
            long j2 = nanos - (1000000 * j);
            if (j > 0 || nanos > 0) {
                taskRunner.wait(j, (int) j2);
            }
        }

        @Override // okhttp3.internal.concurrent.TaskRunner.Backend
        @NotNull
        public <T> BlockingQueue<T> decorate(@NotNull BlockingQueue<T> queue) {
            Intrinsics.checkNotNullParameter(queue, "queue");
            return queue;
        }

        @Override // okhttp3.internal.concurrent.TaskRunner.Backend
        public void execute(@NotNull TaskRunner taskRunner, @NotNull Runnable runnable) {
            Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            this.f24268a.execute(runnable);
        }

        @Override // okhttp3.internal.concurrent.TaskRunner.Backend
        public long nanoTime() {
            return System.nanoTime();
        }

        public final void shutdown() {
            this.f24268a.shutdown();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Logger logger = Logger.getLogger(TaskRunner.class.getName());
        Intrinsics.checkNotNullExpressionValue(logger, "getLogger(TaskRunner::class.java.name)");
        f24259i = logger;
        INSTANCE = new TaskRunner(new RealBackend(_UtilJvmKt.threadFactory(_UtilJvmKt.okHttpName + " TaskRunner", true)), null, 2, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [okhttp3.internal.concurrent.TaskRunner$runnable$1] */
    public TaskRunner(@NotNull Backend backend, @NotNull Logger logger) {
        Intrinsics.checkNotNullParameter(backend, "backend");
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.backend = backend;
        this.logger = logger;
        this.f24262c = 10000;
        this.f24265f = new ArrayList();
        this.f24266g = new ArrayList();
        this.f24267h = new Runnable() { // from class: okhttp3.internal.concurrent.TaskRunner$runnable$1
            @Override // java.lang.Runnable
            public void run() {
                Task awaitTaskToRun;
                long j;
                while (true) {
                    TaskRunner taskRunner = TaskRunner.this;
                    synchronized (taskRunner) {
                        awaitTaskToRun = taskRunner.awaitTaskToRun();
                    }
                    if (awaitTaskToRun == null) {
                        return;
                    }
                    Logger logger2 = TaskRunner.this.getLogger();
                    TaskQueue queue = awaitTaskToRun.getQueue();
                    Intrinsics.checkNotNull(queue);
                    TaskRunner taskRunner2 = TaskRunner.this;
                    boolean isLoggable = logger2.isLoggable(Level.FINE);
                    if (isLoggable) {
                        j = queue.getTaskRunner().getBackend().nanoTime();
                        TaskLoggerKt.access$log(logger2, awaitTaskToRun, queue, "starting");
                    } else {
                        j = -1;
                    }
                    try {
                        TaskRunner.access$runTask(taskRunner2, awaitTaskToRun);
                        if (isLoggable) {
                            TaskLoggerKt.access$log(logger2, awaitTaskToRun, queue, "finished run in " + TaskLoggerKt.formatDuration(queue.getTaskRunner().getBackend().nanoTime() - j));
                        }
                    } catch (Throwable th) {
                        try {
                            synchronized (taskRunner2) {
                                taskRunner2.getBackend().execute(taskRunner2, this);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            if (isLoggable) {
                                TaskLoggerKt.access$log(logger2, awaitTaskToRun, queue, "failed a run in " + TaskLoggerKt.formatDuration(queue.getTaskRunner().getBackend().nanoTime() - j));
                            }
                            throw th2;
                        }
                    }
                }
            }
        };
    }

    public static final void access$runTask(TaskRunner taskRunner, Task task) {
        taskRunner.getClass();
        Thread currentThread = Thread.currentThread();
        String name = currentThread.getName();
        currentThread.setName(task.getCom.google.android.gms.measurement.api.AppMeasurementSdk.ConditionalUserProperty.NAME java.lang.String());
        try {
            long runOnce = task.runOnce();
            synchronized (taskRunner) {
                taskRunner.m6611a(task, runOnce);
            }
            currentThread.setName(name);
        } catch (Throwable th) {
            synchronized (taskRunner) {
                taskRunner.m6611a(task, -1L);
                currentThread.setName(name);
                throw th;
            }
        }
    }

    /* renamed from: a */
    public final void m6611a(Task task, long j) {
        if (_UtilJvmKt.assertionsEnabled && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        }
        TaskQueue queue = task.getQueue();
        Intrinsics.checkNotNull(queue);
        if (queue.getActiveTask() == task) {
            boolean cancelActiveTask = queue.getCancelActiveTask();
            queue.setCancelActiveTask$okhttp(false);
            queue.setActiveTask$okhttp(null);
            this.f24265f.remove(queue);
            if (j != -1 && !cancelActiveTask && !queue.getShutdown()) {
                queue.scheduleAndDecide$okhttp(task, j, true);
            }
            if (!queue.getFutureTasks$okhttp().isEmpty()) {
                this.f24266g.add(queue);
                return;
            }
            return;
        }
        throw new IllegalStateException("Check failed.");
    }

    @NotNull
    public final List<TaskQueue> activeQueues() {
        List<TaskQueue> plus;
        synchronized (this) {
            plus = CollectionsKt___CollectionsKt.plus((Collection) this.f24265f, (Iterable) this.f24266g);
        }
        return plus;
    }

    @Nullable
    public final Task awaitTaskToRun() {
        long j;
        boolean z;
        boolean z2;
        if (_UtilJvmKt.assertionsEnabled && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        }
        while (true) {
            ArrayList arrayList = this.f24266g;
            if (arrayList.isEmpty()) {
                return null;
            }
            Backend backend = this.backend;
            long nanoTime = backend.nanoTime();
            Iterator it = arrayList.iterator();
            long j2 = Long.MAX_VALUE;
            Task task = null;
            while (true) {
                if (it.hasNext()) {
                    Task task2 = ((TaskQueue) it.next()).getFutureTasks$okhttp().get(0);
                    j = nanoTime;
                    long max = Math.max(0L, task2.getNextExecuteNanoTime() - nanoTime);
                    if (max > 0) {
                        j2 = Math.min(max, j2);
                    } else {
                        if (task != null) {
                            z = true;
                            break;
                        }
                        task = task2;
                    }
                    nanoTime = j;
                } else {
                    j = nanoTime;
                    z = false;
                    break;
                }
            }
            if (task != null) {
                if (_UtilJvmKt.assertionsEnabled && !Thread.holdsLock(this)) {
                    throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
                }
                task.setNextExecuteNanoTime$okhttp(-1L);
                TaskQueue queue = task.getQueue();
                Intrinsics.checkNotNull(queue);
                queue.getFutureTasks$okhttp().remove(task);
                arrayList.remove(queue);
                queue.setActiveTask$okhttp(task);
                this.f24265f.add(queue);
                if (z || (!this.f24263d && !arrayList.isEmpty())) {
                    backend.execute(this, this.f24267h);
                }
                return task;
            }
            if (this.f24263d) {
                if (j2 < this.f24264e - j) {
                    backend.coordinatorNotify(this);
                    return null;
                }
                return null;
            }
            this.f24263d = true;
            this.f24264e = j + j2;
            try {
                backend.coordinatorWait(this, j2);
                z2 = false;
            } catch (InterruptedException unused) {
                z2 = false;
                try {
                    cancelAll();
                } catch (Throwable th) {
                    th = th;
                    this.f24263d = z2;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                z2 = false;
                this.f24263d = z2;
                throw th;
            }
            this.f24263d = z2;
        }
    }

    public final void cancelAll() {
        if (_UtilJvmKt.assertionsEnabled && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        }
        ArrayList arrayList = this.f24265f;
        int size = arrayList.size();
        while (true) {
            size--;
            if (-1 >= size) {
                break;
            } else {
                ((TaskQueue) arrayList.get(size)).cancelAllAndDecide$okhttp();
            }
        }
        ArrayList arrayList2 = this.f24266g;
        for (int size2 = arrayList2.size() - 1; -1 < size2; size2--) {
            TaskQueue taskQueue = (TaskQueue) arrayList2.get(size2);
            taskQueue.cancelAllAndDecide$okhttp();
            if (taskQueue.getFutureTasks$okhttp().isEmpty()) {
                arrayList2.remove(size2);
            }
        }
    }

    @NotNull
    public final Backend getBackend() {
        return this.backend;
    }

    @NotNull
    /* renamed from: getLogger$okhttp, reason: from getter */
    public final Logger getLogger() {
        return this.logger;
    }

    public final void kickCoordinator$okhttp(@NotNull TaskQueue taskQueue) {
        Intrinsics.checkNotNullParameter(taskQueue, "taskQueue");
        if (_UtilJvmKt.assertionsEnabled && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        }
        if (taskQueue.getActiveTask() == null) {
            boolean isEmpty = taskQueue.getFutureTasks$okhttp().isEmpty();
            ArrayList arrayList = this.f24266g;
            if (!isEmpty) {
                _UtilCommonKt.addIfAbsent(arrayList, taskQueue);
            } else {
                arrayList.remove(taskQueue);
            }
        }
        boolean z = this.f24263d;
        Backend backend = this.backend;
        if (z) {
            backend.coordinatorNotify(this);
        } else {
            backend.execute(this, this.f24267h);
        }
    }

    @NotNull
    public final TaskQueue newQueue() {
        int i;
        synchronized (this) {
            i = this.f24262c;
            this.f24262c = i + 1;
        }
        return new TaskQueue(this, ye0.m8291k(i, "Q"));
    }

    public /* synthetic */ TaskRunner(Backend backend, Logger logger, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(backend, (i & 2) != 0 ? f24259i : logger);
    }
}
