package okhttp3.internal.concurrent;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal._UtilJvmKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.gs2;

@Metadata(m5568d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010!\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001EB\u0019\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ-\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\n2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u000f¢\u0006\u0004\b\r\u0010\u0011J7\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\u00122\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u000f¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u001c\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0012H\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001d\u001a\u00020\f¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u001f\u001a\u00020\f¢\u0006\u0004\b\u001f\u0010\u001eJ\u000f\u0010\"\u001a\u00020\u0012H\u0000¢\u0006\u0004\b \u0010!J\u000f\u0010#\u001a\u00020\u0004H\u0016¢\u0006\u0004\b#\u0010$R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001a\u0010\u0005\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010$R\"\u0010\u001f\u001a\u00020\u00128\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010!\"\u0004\b/\u00100R$\u00107\u001a\u0004\u0018\u00010\b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R \u0010=\u001a\b\u0012\u0004\u0012\u00020\b088\u0000X\u0080\u0004¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\"\u0010A\u001a\u00020\u00128\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b>\u0010-\u001a\u0004\b?\u0010!\"\u0004\b@\u00100R\u0017\u0010D\u001a\b\u0012\u0004\u0012\u00020\b0B8F¢\u0006\u0006\u001a\u0004\bC\u0010<¨\u0006F"}, m5569d2 = {"Lokhttp3/internal/concurrent/TaskQueue;", "", "Lokhttp3/internal/concurrent/TaskRunner;", "taskRunner", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "<init>", "(Lokhttp3/internal/concurrent/TaskRunner;Ljava/lang/String;)V", "Lokhttp3/internal/concurrent/Task;", "task", "", "delayNanos", "", "schedule", "(Lokhttp3/internal/concurrent/Task;J)V", "Lkotlin/Function0;", "block", "(Ljava/lang/String;JLkotlin/jvm/functions/Function0;)V", "", "cancelable", "execute", "(Ljava/lang/String;JZLkotlin/jvm/functions/Function0;)V", "Ljava/util/concurrent/CountDownLatch;", "idleLatch", "()Ljava/util/concurrent/CountDownLatch;", "recurrence", "scheduleAndDecide$okhttp", "(Lokhttp3/internal/concurrent/Task;JZ)Z", "scheduleAndDecide", "cancelAll", "()V", "shutdown", "cancelAllAndDecide$okhttp", "()Z", "cancelAllAndDecide", "toString", "()Ljava/lang/String;", "a", "Lokhttp3/internal/concurrent/TaskRunner;", "getTaskRunner$okhttp", "()Lokhttp3/internal/concurrent/TaskRunner;", "b", "Ljava/lang/String;", "getName$okhttp", "c", "Z", "getShutdown$okhttp", "setShutdown$okhttp", "(Z)V", "d", "Lokhttp3/internal/concurrent/Task;", "getActiveTask$okhttp", "()Lokhttp3/internal/concurrent/Task;", "setActiveTask$okhttp", "(Lokhttp3/internal/concurrent/Task;)V", "activeTask", "", "e", "Ljava/util/List;", "getFutureTasks$okhttp", "()Ljava/util/List;", "futureTasks", "f", "getCancelActiveTask$okhttp", "setCancelActiveTask$okhttp", "cancelActiveTask", "", "getScheduledTasks", "scheduledTasks", "gs2", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class TaskQueue {

    /* renamed from: a, reason: from kotlin metadata */
    public final TaskRunner taskRunner;

    /* renamed from: b, reason: from kotlin metadata */
    public final String com.google.android.gms.measurement.api.AppMeasurementSdk.ConditionalUserProperty.NAME java.lang.String;

    /* renamed from: c, reason: from kotlin metadata */
    public boolean shutdown;

    /* renamed from: d, reason: from kotlin metadata */
    public Task activeTask;

    /* renamed from: e */
    public final ArrayList f24255e;

    /* renamed from: f, reason: from kotlin metadata */
    public boolean cancelActiveTask;

    public TaskQueue(@NotNull TaskRunner taskRunner, @NotNull String name) {
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        Intrinsics.checkNotNullParameter(name, "name");
        this.taskRunner = taskRunner;
        this.com.google.android.gms.measurement.api.AppMeasurementSdk.ConditionalUserProperty.NAME java.lang.String = name;
        this.f24255e = new ArrayList();
    }

    public static /* synthetic */ void execute$default(TaskQueue taskQueue, String str, long j, boolean z, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        long j2 = j;
        if ((i & 4) != 0) {
            z = true;
        }
        taskQueue.execute(str, j2, z, function0);
    }

    public static /* synthetic */ void schedule$default(TaskQueue taskQueue, Task task, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        taskQueue.schedule(task, j);
    }

    public final void cancelAll() {
        if (_UtilJvmKt.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        synchronized (this.taskRunner) {
            if (cancelAllAndDecide$okhttp()) {
                this.taskRunner.kickCoordinator$okhttp(this);
            }
        }
    }

    public final boolean cancelAllAndDecide$okhttp() {
        Task task = this.activeTask;
        if (task != null) {
            Intrinsics.checkNotNull(task);
            if (task.getCancelable()) {
                this.cancelActiveTask = true;
            }
        }
        ArrayList arrayList = this.f24255e;
        boolean z = false;
        for (int size = arrayList.size() - 1; -1 < size; size--) {
            if (((Task) arrayList.get(size)).getCancelable()) {
                Logger logger = this.taskRunner.getLogger();
                Task task2 = (Task) arrayList.get(size);
                if (logger.isLoggable(Level.FINE)) {
                    TaskLoggerKt.access$log(logger, task2, this, "canceled");
                }
                arrayList.remove(size);
                z = true;
            }
        }
        return z;
    }

    public final void execute(@NotNull String r2, long delayNanos, boolean cancelable, @NotNull final Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(block, "block");
        schedule(new Task(r2, cancelable) { // from class: okhttp3.internal.concurrent.TaskQueue$execute$1
            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() {
                block.invoke();
                return -1L;
            }
        }, delayNanos);
    }

    @Nullable
    /* renamed from: getActiveTask$okhttp, reason: from getter */
    public final Task getActiveTask() {
        return this.activeTask;
    }

    /* renamed from: getCancelActiveTask$okhttp, reason: from getter */
    public final boolean getCancelActiveTask() {
        return this.cancelActiveTask;
    }

    @NotNull
    public final List<Task> getFutureTasks$okhttp() {
        return this.f24255e;
    }

    @NotNull
    /* renamed from: getName$okhttp, reason: from getter */
    public final String getCom.google.android.gms.measurement.api.AppMeasurementSdk.ConditionalUserProperty.NAME java.lang.String() {
        return this.com.google.android.gms.measurement.api.AppMeasurementSdk.ConditionalUserProperty.NAME java.lang.String;
    }

    @NotNull
    public final List<Task> getScheduledTasks() {
        List<Task> list;
        synchronized (this.taskRunner) {
            list = CollectionsKt___CollectionsKt.toList(this.f24255e);
        }
        return list;
    }

    /* renamed from: getShutdown$okhttp, reason: from getter */
    public final boolean getShutdown() {
        return this.shutdown;
    }

    @NotNull
    /* renamed from: getTaskRunner$okhttp, reason: from getter */
    public final TaskRunner getTaskRunner() {
        return this.taskRunner;
    }

    @NotNull
    public final CountDownLatch idleLatch() {
        synchronized (this.taskRunner) {
            if (this.activeTask == null && this.f24255e.isEmpty()) {
                return new CountDownLatch(0);
            }
            Task task = this.activeTask;
            if (task instanceof gs2) {
                return ((gs2) task).f17825e;
            }
            Iterator it = this.f24255e.iterator();
            while (it.hasNext()) {
                Task task2 = (Task) it.next();
                if (task2 instanceof gs2) {
                    return ((gs2) task2).f17825e;
                }
            }
            gs2 gs2Var = new gs2();
            if (scheduleAndDecide$okhttp(gs2Var, 0L, false)) {
                this.taskRunner.kickCoordinator$okhttp(this);
            }
            return gs2Var.f17825e;
        }
    }

    public final void schedule(@NotNull Task task, long delayNanos) {
        Intrinsics.checkNotNullParameter(task, "task");
        synchronized (this.taskRunner) {
            if (this.shutdown) {
                if (task.getCancelable()) {
                    Logger logger = this.taskRunner.getLogger();
                    if (logger.isLoggable(Level.FINE)) {
                        TaskLoggerKt.access$log(logger, task, this, "schedule canceled (queue is shutdown)");
                    }
                    return;
                } else {
                    Logger logger2 = this.taskRunner.getLogger();
                    if (logger2.isLoggable(Level.FINE)) {
                        TaskLoggerKt.access$log(logger2, task, this, "schedule failed (queue is shutdown)");
                    }
                    throw new RejectedExecutionException();
                }
            }
            if (scheduleAndDecide$okhttp(task, delayNanos, false)) {
                this.taskRunner.kickCoordinator$okhttp(this);
            }
        }
    }

    public final boolean scheduleAndDecide$okhttp(@NotNull Task task, long delayNanos, boolean recurrence) {
        String str;
        Intrinsics.checkNotNullParameter(task, "task");
        task.initQueue$okhttp(this);
        TaskRunner taskRunner = this.taskRunner;
        long nanoTime = taskRunner.getBackend().nanoTime();
        long j = nanoTime + delayNanos;
        ArrayList arrayList = this.f24255e;
        int indexOf = arrayList.indexOf(task);
        if (indexOf != -1) {
            if (task.getNextExecuteNanoTime() <= j) {
                Logger logger = taskRunner.getLogger();
                if (logger.isLoggable(Level.FINE)) {
                    TaskLoggerKt.access$log(logger, task, this, "already scheduled");
                }
                return false;
            }
            arrayList.remove(indexOf);
        }
        task.setNextExecuteNanoTime$okhttp(j);
        Logger logger2 = taskRunner.getLogger();
        if (logger2.isLoggable(Level.FINE)) {
            if (recurrence) {
                str = "run again after " + TaskLoggerKt.formatDuration(j - nanoTime);
            } else {
                str = "scheduled after " + TaskLoggerKt.formatDuration(j - nanoTime);
            }
            TaskLoggerKt.access$log(logger2, task, this, str);
        }
        Iterator it = arrayList.iterator();
        int i = 0;
        while (true) {
            if (it.hasNext()) {
                if (((Task) it.next()).getNextExecuteNanoTime() - nanoTime > delayNanos) {
                    break;
                }
                i++;
            } else {
                i = -1;
                break;
            }
        }
        if (i == -1) {
            i = arrayList.size();
        }
        arrayList.add(i, task);
        if (i != 0) {
            return false;
        }
        return true;
    }

    public final void setActiveTask$okhttp(@Nullable Task task) {
        this.activeTask = task;
    }

    public final void setCancelActiveTask$okhttp(boolean z) {
        this.cancelActiveTask = z;
    }

    public final void setShutdown$okhttp(boolean z) {
        this.shutdown = z;
    }

    public final void shutdown() {
        if (_UtilJvmKt.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        synchronized (this.taskRunner) {
            this.shutdown = true;
            if (cancelAllAndDecide$okhttp()) {
                this.taskRunner.kickCoordinator$okhttp(this);
            }
        }
    }

    @NotNull
    public String toString() {
        return this.com.google.android.gms.measurement.api.AppMeasurementSdk.ConditionalUserProperty.NAME java.lang.String;
    }

    public static /* synthetic */ void schedule$default(TaskQueue taskQueue, String str, long j, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        taskQueue.schedule(str, j, function0);
    }

    public final void schedule(@NotNull String r2, long delayNanos, @NotNull final Function0<Long> block) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(block, "block");
        schedule(new Task(r2) { // from class: okhttp3.internal.concurrent.TaskQueue$schedule$2
            {
                int i = 2;
                DefaultConstructorMarker defaultConstructorMarker = null;
                boolean z = false;
            }

            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() {
                return ((Number) block.invoke()).longValue();
            }
        }, delayNanos);
    }
}
