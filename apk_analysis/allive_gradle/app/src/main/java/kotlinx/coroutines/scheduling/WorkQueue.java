package kotlinx.coroutines.scheduling;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m5568d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\u0012\u001a\u00020\u00112\n\u0010\u000e\u001a\u00060\fj\u0002`\r2\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0014\u0010\u0006J\u000f\u0010\u0015\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0015\u0010\u0006J\u0015\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u000b\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004R\u000b\u0010 \u001a\u00020\u001e8\u0002X\u0082\u0004R\u0013\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040!8\u0002X\u0082\u0004R\u000b\u0010#\u001a\u00020\u001e8\u0002X\u0082\u0004¨\u0006$"}, m5569d2 = {"Lkotlinx/coroutines/scheduling/WorkQueue;", "", "<init>", "()V", "Lkotlinx/coroutines/scheduling/Task;", "poll", "()Lkotlinx/coroutines/scheduling/Task;", "task", "", "fair", "add", "(Lkotlinx/coroutines/scheduling/Task;Z)Lkotlinx/coroutines/scheduling/Task;", "", "Lkotlinx/coroutines/scheduling/StealingMode;", "stealingMode", "Lkotlin/jvm/internal/Ref$ObjectRef;", "stolenTaskRef", "", "trySteal", "(ILkotlin/jvm/internal/Ref$ObjectRef;)J", "pollBlocking", "pollCpu", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalQueue", "", "offloadAllWorkTo", "(Lkotlinx/coroutines/scheduling/GlobalQueue;)V", "getSize$kotlinx_coroutines_core", "()I", "size", "Lkotlinx/atomicfu/AtomicInt;", "blockingTasksInBuffer", "consumerIndex", "Lkotlinx/atomicfu/AtomicRef;", "lastScheduledTask", "producerIndex", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nWorkQueue.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WorkQueue.kt\nkotlinx/coroutines/scheduling/WorkQueue\n+ 2 Tasks.kt\nkotlinx/coroutines/scheduling/TasksKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 WorkQueue.kt\nkotlinx/coroutines/scheduling/WorkQueueKt\n*L\n1#1,255:1\n93#2:256\n93#2:257\n93#2:258\n93#2:261\n93#2:262\n1#3:259\n25#4:260\n*S KotlinDebug\n*F\n+ 1 WorkQueue.kt\nkotlinx/coroutines/scheduling/WorkQueue\n*L\n95#1:256\n162#1:257\n185#1:258\n205#1:261\n249#1:262\n205#1:260\n*E\n"})
/* loaded from: classes2.dex */
public final class WorkQueue {

    /* renamed from: b */
    public static final AtomicReferenceFieldUpdater f22070b = AtomicReferenceFieldUpdater.newUpdater(WorkQueue.class, Object.class, "lastScheduledTask");

    /* renamed from: c */
    public static final AtomicIntegerFieldUpdater f22071c = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "producerIndex");

    /* renamed from: d */
    public static final AtomicIntegerFieldUpdater f22072d = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "consumerIndex");

    /* renamed from: e */
    public static final AtomicIntegerFieldUpdater f22073e = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "blockingTasksInBuffer");

    /* renamed from: a */
    public final AtomicReferenceArray f22074a = new AtomicReferenceArray(128);

    @Volatile
    private volatile int blockingTasksInBuffer;

    @Volatile
    private volatile int consumerIndex;

    @Volatile
    @Nullable
    private volatile Object lastScheduledTask;

    @Volatile
    private volatile int producerIndex;

    public static /* synthetic */ Task add$default(WorkQueue workQueue, Task task, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return workQueue.add(task, z);
    }

    /* renamed from: a */
    public final Task m5741a(Task task) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f22071c;
        if (atomicIntegerFieldUpdater.get(this) - f22072d.get(this) == 127) {
            return task;
        }
        if (task.taskContext.getTaskMode() == 1) {
            f22073e.incrementAndGet(this);
        }
        int i = atomicIntegerFieldUpdater.get(this) & 127;
        while (true) {
            AtomicReferenceArray atomicReferenceArray = this.f22074a;
            if (atomicReferenceArray.get(i) != null) {
                Thread.yield();
            } else {
                atomicReferenceArray.lazySet(i, task);
                atomicIntegerFieldUpdater.incrementAndGet(this);
                return null;
            }
        }
    }

    @Nullable
    public final Task add(@NotNull Task task, boolean fair) {
        if (fair) {
            return m5741a(task);
        }
        Task task2 = (Task) f22070b.getAndSet(this, task);
        if (task2 == null) {
            return null;
        }
        return m5741a(task2);
    }

    /* renamed from: b */
    public final Task m5742b() {
        Task task;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f22072d;
            int i = atomicIntegerFieldUpdater.get(this);
            if (i - f22071c.get(this) == 0) {
                return null;
            }
            int i2 = i & 127;
            if (atomicIntegerFieldUpdater.compareAndSet(this, i, i + 1) && (task = (Task) this.f22074a.getAndSet(i2, null)) != null) {
                if (task.taskContext.getTaskMode() == 1) {
                    f22073e.decrementAndGet(this);
                }
                return task;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0027, code lost:
    
        r0 = kotlinx.coroutines.scheduling.WorkQueue.f22072d.get(r5);
        r1 = kotlinx.coroutines.scheduling.WorkQueue.f22071c.get(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0033, code lost:
    
        if (r0 == r1) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0035, code lost:
    
        if (r6 == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003d, code lost:
    
        if (kotlinx.coroutines.scheduling.WorkQueue.f22073e.get(r5) != 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003f, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0040, code lost:
    
        r1 = r1 - 1;
        r3 = m5744d(r1, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0046, code lost:
    
        if (r3 == null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0048, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0049, code lost:
    
        return null;
     */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Task m5743c(boolean z) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f22070b;
            Task task = (Task) atomicReferenceFieldUpdater.get(this);
            if (task == null) {
                break;
            }
            boolean z2 = true;
            if (task.taskContext.getTaskMode() != 1) {
                z2 = false;
            }
            if (z2 != z) {
                break;
            }
            while (!atomicReferenceFieldUpdater.compareAndSet(this, task, null)) {
                if (atomicReferenceFieldUpdater.get(this) != task) {
                    break;
                }
            }
            return task;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002c, code lost:
    
        if (r0.get(r6) == r1) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0020, code lost:
    
        if (r7 == false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0022, code lost:
    
        kotlinx.coroutines.scheduling.WorkQueue.f22073e.decrementAndGet(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0027, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0018, code lost:
    
        if (r4 == r7) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
    
        if (r0.compareAndSet(r6, r1, null) == false) goto L14;
     */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Task m5744d(int i, boolean z) {
        int i2 = i & 127;
        AtomicReferenceArray atomicReferenceArray = this.f22074a;
        Task task = (Task) atomicReferenceArray.get(i2);
        if (task != null) {
            boolean z2 = true;
            if (task.taskContext.getTaskMode() != 1) {
                z2 = false;
            }
        }
        return null;
    }

    public final int getSize$kotlinx_coroutines_core() {
        Object obj = f22070b.get(this);
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f22072d;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater2 = f22071c;
        if (obj != null) {
            return (atomicIntegerFieldUpdater2.get(this) - atomicIntegerFieldUpdater.get(this)) + 1;
        }
        return atomicIntegerFieldUpdater2.get(this) - atomicIntegerFieldUpdater.get(this);
    }

    public final void offloadAllWorkTo(@NotNull GlobalQueue globalQueue) {
        Task task = (Task) f22070b.getAndSet(this, null);
        if (task != null) {
            globalQueue.addLast(task);
        }
        while (true) {
            Task m5742b = m5742b();
            if (m5742b == null) {
                return;
            } else {
                globalQueue.addLast(m5742b);
            }
        }
    }

    @Nullable
    public final Task poll() {
        Task task = (Task) f22070b.getAndSet(this, null);
        if (task == null) {
            return m5742b();
        }
        return task;
    }

    @Nullable
    public final Task pollBlocking() {
        return m5743c(true);
    }

    @Nullable
    public final Task pollCpu() {
        return m5743c(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [kotlinx.coroutines.scheduling.Task] */
    /* JADX WARN: Type inference failed for: r0v9, types: [kotlinx.coroutines.scheduling.Task] */
    /* JADX WARN: Type inference failed for: r5v4, types: [T, kotlinx.coroutines.scheduling.Task, java.lang.Object] */
    public final long trySteal(int stealingMode, @NotNull Ref.ObjectRef<Task> stolenTaskRef) {
        boolean z;
        T t;
        int i;
        if (stealingMode == 3) {
            t = m5742b();
        } else {
            int i2 = f22072d.get(this);
            int i3 = f22071c.get(this);
            if (stealingMode == 1) {
                z = true;
            } else {
                z = false;
            }
            while (i2 != i3 && (!z || f22073e.get(this) != 0)) {
                int i4 = i2 + 1;
                t = m5744d(i2, z);
                if (t != 0) {
                    break;
                }
                i2 = i4;
            }
            t = 0;
        }
        if (t != 0) {
            stolenTaskRef.element = t;
            return -1L;
        }
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f22070b;
            ?? r5 = (Task) atomicReferenceFieldUpdater.get(this);
            if (r5 == 0) {
                break;
            }
            if (r5.taskContext.getTaskMode() == 1) {
                i = 1;
            } else {
                i = 2;
            }
            if ((i & stealingMode) == 0) {
                break;
            }
            long nanoTime = TasksKt.schedulerTimeSource.nanoTime() - r5.submissionTime;
            long j = TasksKt.WORK_STEALING_TIME_RESOLUTION_NS;
            if (nanoTime < j) {
                return j - nanoTime;
            }
            while (!atomicReferenceFieldUpdater.compareAndSet(this, r5, null)) {
                if (atomicReferenceFieldUpdater.get(this) != r5) {
                    break;
                }
            }
            stolenTaskRef.element = r5;
            return -1L;
        }
        return -2L;
    }
}
