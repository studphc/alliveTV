package kotlinx.coroutines.scheduling;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import kotlinx.coroutines.AbstractTimeSource;
import kotlinx.coroutines.AbstractTimeSourceKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.internal.ResizableAtomicArray;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.AbstractC1726qj;
import p000.r82;
import p000.ye0;

@Metadata(m5568d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 C2\u00020\u00012\u00020\u0002:\u0003CDEB+\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\u0011\u001a\u00020\u00102\n\u0010\r\u001a\u00060\fR\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0014\u001a\u00020\u00132\n\u0010\r\u001a\u00060\fR\u00020\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0006H\u0086\b¢\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u001c\u001a\u00020\u00102\n\u0010\u001b\u001a\u00060\u0019j\u0002`\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010!\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u0006¢\u0006\u0004\b!\u0010\"J-\u0010'\u001a\u00020\u00102\n\u0010#\u001a\u00060\u0019j\u0002`\u001a2\b\b\u0002\u0010%\u001a\u00020$2\b\b\u0002\u0010&\u001a\u00020\u0013¢\u0006\u0004\b'\u0010(J!\u0010*\u001a\u00020)2\n\u0010#\u001a\u00060\u0019j\u0002`\u001a2\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b*\u0010+J\r\u0010,\u001a\u00020\u0010¢\u0006\u0004\b,\u0010\u001fJ\u000f\u0010-\u001a\u00020\bH\u0016¢\u0006\u0004\b-\u0010.J\u0015\u00100\u001a\u00020\u00102\u0006\u0010/\u001a\u00020)¢\u0006\u0004\b0\u00101R\u0014\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u00102R\u0014\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u00102R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u00103R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\t\u00104R\u0014\u00106\u001a\u0002058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0014\u00108\u001a\u0002058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b8\u00107R\u001e\u0010:\u001a\f\u0012\b\u0012\u00060\fR\u00020\u0000098\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0011\u0010<\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b<\u0010=R\u000b\u0010?\u001a\u00020>8\u0002X\u0082\u0004R\u000b\u0010A\u001a\u00020@8\u0002X\u0082\u0004R\u000b\u0010B\u001a\u00020@8\u0002X\u0082\u0004¨\u0006F"}, m5569d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "Ljava/util/concurrent/Executor;", "Ljava/io/Closeable;", "", "corePoolSize", "maxPoolSize", "", "idleWorkerKeepAliveNs", "", "schedulerName", "<init>", "(IIJLjava/lang/String;)V", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "worker", "oldIndex", "newIndex", "", "parkedWorkersStackTopUpdate", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;II)V", "", "parkedWorkersStackPush", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;)Z", "state", "availableCpuPermits", "(J)I", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "command", "execute", "(Ljava/lang/Runnable;)V", "close", "()V", "timeout", "shutdown", "(J)V", "block", "Lkotlinx/coroutines/scheduling/TaskContext;", "taskContext", "tailDispatch", "dispatch", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/TaskContext;Z)V", "Lkotlinx/coroutines/scheduling/Task;", "createTask", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/TaskContext;)Lkotlinx/coroutines/scheduling/Task;", "signalCpuWork", "toString", "()Ljava/lang/String;", "task", "runSafely", "(Lkotlinx/coroutines/scheduling/Task;)V", "I", "J", "Ljava/lang/String;", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalCpuQueue", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalBlockingQueue", "Lkotlinx/coroutines/internal/ResizableAtomicArray;", "workers", "Lkotlinx/coroutines/internal/ResizableAtomicArray;", "isTerminated", "()Z", "Lkotlinx/atomicfu/AtomicBoolean;", "_isTerminated", "Lkotlinx/atomicfu/AtomicLong;", "controlState", "parkedWorkersStack", "Companion", "Worker", "WorkerState", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nCoroutineScheduler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineScheduler.kt\nkotlinx/coroutines/scheduling/CoroutineScheduler\n+ 2 Tasks.kt\nkotlinx/coroutines/scheduling/TasksKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 5 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 6 Tasks.kt\nkotlinx/coroutines/scheduling/Task\n+ 7 CoroutineScheduler.kt\nkotlinx/coroutines/scheduling/CoroutineScheduler$Worker\n*L\n1#1,1033:1\n285#1:1036\n283#1:1037\n283#1:1038\n285#1:1039\n280#1:1045\n281#1,5:1046\n291#1:1052\n283#1:1053\n284#1:1054\n283#1:1060\n284#1:1061\n280#1:1062\n288#1:1063\n283#1:1064\n283#1:1067\n284#1:1068\n285#1:1069\n93#2:1034\n93#2:1051\n1#3:1035\n28#4,4:1040\n28#4,4:1055\n20#5:1044\n20#5:1059\n90#6:1065\n610#7:1066\n*S KotlinDebug\n*F\n+ 1 CoroutineScheduler.kt\nkotlinx/coroutines/scheduling/CoroutineScheduler\n*L\n281#1:1036\n288#1:1037\n289#1:1038\n298#1:1039\n347#1:1045\n375#1:1046,5\n398#1:1052\n445#1:1053\n446#1:1054\n482#1:1060\n483#1:1061\n489#1:1062\n498#1:1063\n498#1:1064\n576#1:1067\n577#1:1068\n578#1:1069\n119#1:1034\n395#1:1051\n347#1:1040,4\n478#1:1055,4\n347#1:1044\n478#1:1059\n515#1:1065\n522#1:1066\n*E\n"})
/* loaded from: classes2.dex */
public final class CoroutineScheduler implements Executor, Closeable {
    public static final int MAX_SUPPORTED_POOL_SIZE = 2097150;
    public static final int MIN_SUPPORTED_POOL_SIZE = 1;

    @Volatile
    private volatile int _isTerminated;

    @Volatile
    private volatile long controlState;

    @JvmField
    public final int corePoolSize;

    @JvmField
    @NotNull
    public final GlobalQueue globalBlockingQueue;

    @JvmField
    @NotNull
    public final GlobalQueue globalCpuQueue;

    @JvmField
    public final long idleWorkerKeepAliveNs;

    @JvmField
    public final int maxPoolSize;

    @Volatile
    private volatile long parkedWorkersStack;

    @JvmField
    @NotNull
    public final String schedulerName;

    @JvmField
    @NotNull
    public final ResizableAtomicArray<Worker> workers;

    /* renamed from: a */
    public static final AtomicLongFieldUpdater f22052a = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "parkedWorkersStack");

    /* renamed from: b */
    public static final AtomicLongFieldUpdater f22053b = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "controlState");

    /* renamed from: c */
    public static final AtomicIntegerFieldUpdater f22054c = AtomicIntegerFieldUpdater.newUpdater(CoroutineScheduler.class, "_isTerminated");

    @JvmField
    @NotNull
    public static final Symbol NOT_IN_STACK = new Symbol("NOT_IN_STACK");

    @Metadata(m5570k = 3, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[WorkerState.values().length];
            try {
                iArr[WorkerState.PARKING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[WorkerState.BLOCKING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[WorkerState.CPU_ACQUIRED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[WorkerState.DORMANT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[WorkerState.TERMINATED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Metadata(m5568d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0016\u001a\u00020\b¢\u0006\u0004\b\u0018\u0010\u0019R*\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020 8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010#\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b#\u0010$R$\u0010&\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0016\u0010\u0016\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010,R\u0012\u00100\u001a\u00020-8Æ\u0002¢\u0006\u0006\u001a\u0004\b.\u0010/R\b\u00102\u001a\u0002018\u0006¨\u00063"}, m5569d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "Ljava/lang/Thread;", "", FirebaseAnalytics.Param.INDEX, "<init>", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;I)V", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "newState", "", "tryReleaseCpu", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;)Z", "", "run", "()V", "", "runSingleTask", "()J", "isIo", "()Z", "upperBound", "nextInt", "(I)I", "mayHaveLocalTasks", "Lkotlinx/coroutines/scheduling/Task;", "findTask", "(Z)Lkotlinx/coroutines/scheduling/Task;", "indexInArray", "I", "getIndexInArray", "()I", "setIndexInArray", "(I)V", "Lkotlinx/coroutines/scheduling/WorkQueue;", "localQueue", "Lkotlinx/coroutines/scheduling/WorkQueue;", "state", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "", "nextParkedWorker", "Ljava/lang/Object;", "getNextParkedWorker", "()Ljava/lang/Object;", "setNextParkedWorker", "(Ljava/lang/Object;)V", "Z", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "getScheduler", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "scheduler", "Lkotlinx/atomicfu/AtomicInt;", "workerCtl", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    @SourceDebugExtension({"SMAP\nCoroutineScheduler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineScheduler.kt\nkotlinx/coroutines/scheduling/CoroutineScheduler$Worker\n+ 2 CoroutineScheduler.kt\nkotlinx/coroutines/scheduling/CoroutineScheduler\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Tasks.kt\nkotlinx/coroutines/scheduling/Task\n+ 5 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 6 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n*L\n1#1,1033:1\n298#2:1034\n285#2:1035\n299#2,4:1036\n304#2:1040\n294#2,2:1041\n294#2,2:1045\n280#2:1052\n289#2:1053\n283#2:1054\n280#2:1055\n1#3:1043\n90#4:1044\n28#5,4:1047\n20#6:1051\n*S KotlinDebug\n*F\n+ 1 CoroutineScheduler.kt\nkotlinx/coroutines/scheduling/CoroutineScheduler$Worker\n*L\n665#1:1034\n665#1:1035\n665#1:1036,4\n679#1:1040\n753#1:1041,2\n807#1:1045,2\n855#1:1052\n881#1:1053\n881#1:1054\n963#1:1055\n790#1:1044\n851#1:1047,4\n851#1:1051\n*E\n"})
    /* loaded from: classes2.dex */
    public final class Worker extends Thread {

        /* renamed from: f */
        public static final AtomicIntegerFieldUpdater f22055f = AtomicIntegerFieldUpdater.newUpdater(Worker.class, "workerCtl");

        /* renamed from: a */
        public final Ref.ObjectRef f22056a;

        /* renamed from: b */
        public long f22057b;

        /* renamed from: c */
        public long f22058c;

        /* renamed from: d */
        public int f22059d;
        private volatile int indexInArray;

        @JvmField
        @NotNull
        public final WorkQueue localQueue;

        @JvmField
        public boolean mayHaveLocalTasks;

        @Nullable
        private volatile Object nextParkedWorker;

        @JvmField
        @NotNull
        public WorkerState state;

        @Volatile
        private volatile int workerCtl;

        public Worker(int i) {
            setDaemon(true);
            this.localQueue = new WorkQueue();
            this.f22056a = new Ref.ObjectRef();
            this.state = WorkerState.DORMANT;
            this.nextParkedWorker = CoroutineScheduler.NOT_IN_STACK;
            this.f22059d = Random.INSTANCE.nextInt();
            setIndexInArray(i);
        }

        /* renamed from: a */
        public final Task m5739a() {
            int nextInt = nextInt(2);
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            if (nextInt == 0) {
                Task removeFirstOrNull = coroutineScheduler.globalCpuQueue.removeFirstOrNull();
                if (removeFirstOrNull != null) {
                    return removeFirstOrNull;
                }
                return coroutineScheduler.globalBlockingQueue.removeFirstOrNull();
            }
            Task removeFirstOrNull2 = coroutineScheduler.globalBlockingQueue.removeFirstOrNull();
            if (removeFirstOrNull2 != null) {
                return removeFirstOrNull2;
            }
            return coroutineScheduler.globalCpuQueue.removeFirstOrNull();
        }

        /* renamed from: b */
        public final Task m5740b(int i) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = CoroutineScheduler.f22053b;
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            int i2 = (int) (atomicLongFieldUpdater.get(coroutineScheduler) & 2097151);
            if (i2 < 2) {
                return null;
            }
            int nextInt = nextInt(i2);
            long j = Long.MAX_VALUE;
            for (int i3 = 0; i3 < i2; i3++) {
                nextInt++;
                if (nextInt > i2) {
                    nextInt = 1;
                }
                Worker worker = coroutineScheduler.workers.get(nextInt);
                if (worker != null && worker != this) {
                    WorkQueue workQueue = worker.localQueue;
                    Ref.ObjectRef<Task> objectRef = this.f22056a;
                    long trySteal = workQueue.trySteal(i, objectRef);
                    if (trySteal == -1) {
                        Task task = objectRef.element;
                        objectRef.element = null;
                        return task;
                    }
                    if (trySteal > 0) {
                        j = Math.min(j, trySteal);
                    }
                }
            }
            if (j == Long.MAX_VALUE) {
                j = 0;
            }
            this.f22058c = j;
            return null;
        }

        @Nullable
        public final Task findTask(boolean mayHaveLocalTasks) {
            Task m5739a;
            Task m5739a2;
            CoroutineScheduler coroutineScheduler;
            long j;
            WorkerState workerState = this.state;
            WorkerState workerState2 = WorkerState.CPU_ACQUIRED;
            boolean z = true;
            CoroutineScheduler coroutineScheduler2 = CoroutineScheduler.this;
            if (workerState != workerState2) {
                AtomicLongFieldUpdater atomicLongFieldUpdater = CoroutineScheduler.f22053b;
                do {
                    coroutineScheduler = CoroutineScheduler.this;
                    j = atomicLongFieldUpdater.get(coroutineScheduler);
                    if (((int) ((9223367638808264704L & j) >> 42)) == 0) {
                        Task pollBlocking = this.localQueue.pollBlocking();
                        if (pollBlocking == null) {
                            Task removeFirstOrNull = coroutineScheduler2.globalBlockingQueue.removeFirstOrNull();
                            if (removeFirstOrNull == null) {
                                return m5740b(1);
                            }
                            return removeFirstOrNull;
                        }
                        return pollBlocking;
                    }
                } while (!CoroutineScheduler.f22053b.compareAndSet(coroutineScheduler, j, j - 4398046511104L));
                this.state = WorkerState.CPU_ACQUIRED;
            }
            if (mayHaveLocalTasks) {
                if (nextInt(coroutineScheduler2.corePoolSize * 2) != 0) {
                    z = false;
                }
                if (!z || (m5739a2 = m5739a()) == null) {
                    Task poll = this.localQueue.poll();
                    if (poll == null) {
                        if (!z && (m5739a = m5739a()) != null) {
                            return m5739a;
                        }
                    } else {
                        return poll;
                    }
                } else {
                    return m5739a2;
                }
            } else {
                Task m5739a3 = m5739a();
                if (m5739a3 != null) {
                    return m5739a3;
                }
            }
            return m5740b(3);
        }

        public final int getIndexInArray() {
            return this.indexInArray;
        }

        @Nullable
        public final Object getNextParkedWorker() {
            return this.nextParkedWorker;
        }

        @NotNull
        public final CoroutineScheduler getScheduler() {
            return CoroutineScheduler.this;
        }

        public final int getWorkerCtl() {
            return this.workerCtl;
        }

        public final boolean isIo() {
            if (this.state == WorkerState.BLOCKING) {
                return true;
            }
            return false;
        }

        public final int nextInt(int upperBound) {
            int i = this.f22059d;
            int i2 = i ^ (i << 13);
            int i3 = i2 ^ (i2 >> 17);
            int i4 = i3 ^ (i3 << 5);
            this.f22059d = i4;
            int i5 = upperBound - 1;
            if ((i5 & upperBound) == 0) {
                return i4 & i5;
            }
            return (i4 & Integer.MAX_VALUE) % upperBound;
        }

        /* JADX WARN: Code restructure failed: missing block: B:69:0x0002, code lost:
        
            continue;
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            loop0: while (true) {
                boolean z = false;
                while (!CoroutineScheduler.this.isTerminated()) {
                    WorkerState workerState = this.state;
                    WorkerState workerState2 = WorkerState.TERMINATED;
                    if (workerState == workerState2) {
                        break loop0;
                    }
                    Task findTask = findTask(this.mayHaveLocalTasks);
                    if (findTask != null) {
                        this.f22058c = 0L;
                        int taskMode = findTask.taskContext.getTaskMode();
                        this.f22057b = 0L;
                        if (this.state == WorkerState.PARKING) {
                            this.state = WorkerState.BLOCKING;
                        }
                        CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
                        if (taskMode != 0 && tryReleaseCpu(WorkerState.BLOCKING)) {
                            coroutineScheduler.signalCpuWork();
                        }
                        coroutineScheduler.runSafely(findTask);
                        if (taskMode != 0) {
                            CoroutineScheduler.f22053b.addAndGet(coroutineScheduler, -2097152L);
                            if (this.state != workerState2) {
                                this.state = WorkerState.DORMANT;
                            }
                        }
                    } else {
                        this.mayHaveLocalTasks = false;
                        if (this.f22058c != 0) {
                            if (!z) {
                                z = true;
                            } else {
                                tryReleaseCpu(WorkerState.PARKING);
                                Thread.interrupted();
                                LockSupport.parkNanos(this.f22058c);
                                this.f22058c = 0L;
                            }
                        } else if (this.nextParkedWorker != CoroutineScheduler.NOT_IN_STACK) {
                            f22055f.set(this, -1);
                            while (this.nextParkedWorker != CoroutineScheduler.NOT_IN_STACK) {
                                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f22055f;
                                if (atomicIntegerFieldUpdater.get(this) == -1 && !CoroutineScheduler.this.isTerminated()) {
                                    WorkerState workerState3 = this.state;
                                    WorkerState workerState4 = WorkerState.TERMINATED;
                                    if (workerState3 == workerState4) {
                                        break;
                                    }
                                    tryReleaseCpu(WorkerState.PARKING);
                                    Thread.interrupted();
                                    if (this.f22057b == 0) {
                                        this.f22057b = System.nanoTime() + CoroutineScheduler.this.idleWorkerKeepAliveNs;
                                    }
                                    LockSupport.parkNanos(CoroutineScheduler.this.idleWorkerKeepAliveNs);
                                    if (System.nanoTime() - this.f22057b >= 0) {
                                        this.f22057b = 0L;
                                        CoroutineScheduler coroutineScheduler2 = CoroutineScheduler.this;
                                        synchronized (coroutineScheduler2.workers) {
                                            try {
                                                if (!coroutineScheduler2.isTerminated()) {
                                                    if (((int) (CoroutineScheduler.f22053b.get(coroutineScheduler2) & 2097151)) > coroutineScheduler2.corePoolSize) {
                                                        if (atomicIntegerFieldUpdater.compareAndSet(this, -1, 1)) {
                                                            int i = this.indexInArray;
                                                            setIndexInArray(0);
                                                            coroutineScheduler2.parkedWorkersStackTopUpdate(this, i, 0);
                                                            int andDecrement = (int) (CoroutineScheduler.f22053b.getAndDecrement(coroutineScheduler2) & 2097151);
                                                            if (andDecrement != i) {
                                                                Worker worker = coroutineScheduler2.workers.get(andDecrement);
                                                                Intrinsics.checkNotNull(worker);
                                                                Worker worker2 = worker;
                                                                coroutineScheduler2.workers.setSynchronized(i, worker2);
                                                                worker2.setIndexInArray(i);
                                                                coroutineScheduler2.parkedWorkersStackTopUpdate(worker2, andDecrement, i);
                                                            }
                                                            coroutineScheduler2.workers.setSynchronized(andDecrement, null);
                                                            this.state = workerState4;
                                                        }
                                                    }
                                                }
                                            } catch (Throwable th) {
                                                throw th;
                                            }
                                        }
                                    }
                                }
                            }
                        } else {
                            CoroutineScheduler.this.parkedWorkersStackPush(this);
                        }
                    }
                }
                break loop0;
            }
            tryReleaseCpu(WorkerState.TERMINATED);
        }

        public final long runSingleTask() {
            boolean z;
            Task task;
            if (this.state == WorkerState.CPU_ACQUIRED) {
                z = true;
            } else {
                z = false;
            }
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            if (z) {
                task = this.localQueue.pollCpu();
                if (task == null && (task = coroutineScheduler.globalBlockingQueue.removeFirstOrNull()) == null) {
                    task = m5740b(2);
                }
            } else {
                Task pollBlocking = this.localQueue.pollBlocking();
                if (pollBlocking == null && (pollBlocking = coroutineScheduler.globalBlockingQueue.removeFirstOrNull()) == null) {
                    task = m5740b(1);
                } else {
                    task = pollBlocking;
                }
            }
            if (task == null) {
                long j = this.f22058c;
                if (j == 0) {
                    return -1L;
                }
                return j;
            }
            coroutineScheduler.runSafely(task);
            if (!z) {
                CoroutineScheduler.f22053b.addAndGet(coroutineScheduler, -2097152L);
            }
            return 0L;
        }

        public final void setIndexInArray(int i) {
            String valueOf;
            StringBuilder sb = new StringBuilder();
            sb.append(CoroutineScheduler.this.schedulerName);
            sb.append("-worker-");
            if (i == 0) {
                valueOf = "TERMINATED";
            } else {
                valueOf = String.valueOf(i);
            }
            sb.append(valueOf);
            setName(sb.toString());
            this.indexInArray = i;
        }

        public final void setNextParkedWorker(@Nullable Object obj) {
            this.nextParkedWorker = obj;
        }

        public final boolean tryReleaseCpu(@NotNull WorkerState newState) {
            boolean z;
            WorkerState workerState = this.state;
            if (workerState == WorkerState.CPU_ACQUIRED) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                CoroutineScheduler.f22053b.addAndGet(CoroutineScheduler.this, 4398046511104L);
            }
            if (workerState != newState) {
                this.state = newState;
            }
            return z;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(m5568d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m5569d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "", "CPU_ACQUIRED", "BLOCKING", "PARKING", "DORMANT", "TERMINATED", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class WorkerState {
        public static final WorkerState BLOCKING;
        public static final WorkerState CPU_ACQUIRED;
        public static final WorkerState DORMANT;
        public static final WorkerState PARKING;
        public static final WorkerState TERMINATED;

        /* renamed from: a */
        public static final /* synthetic */ WorkerState[] f22061a;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Enum, kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState] */
        /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Enum, kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState] */
        /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Enum, kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState] */
        /* JADX WARN: Type inference failed for: r8v1, types: [java.lang.Enum, kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState] */
        /* JADX WARN: Type inference failed for: r9v1, types: [java.lang.Enum, kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState] */
        static {
            ?? r5 = new Enum("CPU_ACQUIRED", 0);
            CPU_ACQUIRED = r5;
            ?? r6 = new Enum("BLOCKING", 1);
            BLOCKING = r6;
            ?? r7 = new Enum("PARKING", 2);
            PARKING = r7;
            ?? r8 = new Enum("DORMANT", 3);
            DORMANT = r8;
            ?? r9 = new Enum("TERMINATED", 4);
            TERMINATED = r9;
            f22061a = new WorkerState[]{r5, r6, r7, r8, r9};
        }

        public static WorkerState valueOf(String str) {
            return (WorkerState) Enum.valueOf(WorkerState.class, str);
        }

        public static WorkerState[] values() {
            return (WorkerState[]) f22061a.clone();
        }
    }

    public CoroutineScheduler(int i, int i2, long j, @NotNull String str) {
        this.corePoolSize = i;
        this.maxPoolSize = i2;
        this.idleWorkerKeepAliveNs = j;
        this.schedulerName = str;
        if (i < 1) {
            throw new IllegalArgumentException(ye0.m8292l(i, "Core pool size ", " should be at least 1").toString());
        }
        if (i2 < i) {
            throw new IllegalArgumentException(ye0.m8293m(i2, "Max pool size ", " should be greater than or equals to core pool size ", i).toString());
        }
        if (i2 > 2097150) {
            throw new IllegalArgumentException(ye0.m8292l(i2, "Max pool size ", " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (j > 0) {
            this.globalCpuQueue = new GlobalQueue();
            this.globalBlockingQueue = new GlobalQueue();
            this.workers = new ResizableAtomicArray<>((i + 1) * 2);
            this.controlState = i << 42;
            this._isTerminated = 0;
            return;
        }
        throw new IllegalArgumentException(("Idle worker keep alive time " + j + " must be positive").toString());
    }

    public static /* synthetic */ void dispatch$default(CoroutineScheduler coroutineScheduler, Runnable runnable, TaskContext taskContext, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            taskContext = TasksKt.NonBlockingContext;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        coroutineScheduler.dispatch(runnable, taskContext, z);
    }

    /* renamed from: a */
    public final int m5736a() {
        synchronized (this.workers) {
            try {
                if (isTerminated()) {
                    return -1;
                }
                AtomicLongFieldUpdater atomicLongFieldUpdater = f22053b;
                long j = atomicLongFieldUpdater.get(this);
                int i = (int) (j & 2097151);
                int coerceAtLeast = r82.coerceAtLeast(i - ((int) ((j & 4398044413952L) >> 21)), 0);
                if (coerceAtLeast >= this.corePoolSize) {
                    return 0;
                }
                if (i >= this.maxPoolSize) {
                    return 0;
                }
                int i2 = ((int) (f22053b.get(this) & 2097151)) + 1;
                if (i2 > 0 && this.workers.get(i2) == null) {
                    Worker worker = new Worker(i2);
                    this.workers.setSynchronized(i2, worker);
                    if (i2 == ((int) (2097151 & atomicLongFieldUpdater.incrementAndGet(this)))) {
                        int i3 = coerceAtLeast + 1;
                        worker.start();
                        return i3;
                    }
                    throw new IllegalArgumentException("Failed requirement.");
                }
                throw new IllegalArgumentException("Failed requirement.");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final int availableCpuPermits(long state) {
        return (int) ((state & 9223367638808264704L) >> 42);
    }

    /* renamed from: b */
    public final boolean m5737b(long j) {
        if (r82.coerceAtLeast(((int) (2097151 & j)) - ((int) ((j & 4398044413952L) >> 21)), 0) < this.corePoolSize) {
            int m5736a = m5736a();
            if (m5736a == 1 && this.corePoolSize > 1) {
                m5736a();
            }
            if (m5736a > 0) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    public final boolean m5738c() {
        Symbol symbol;
        int i;
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f22052a;
            long j = atomicLongFieldUpdater.get(this);
            Worker worker = this.workers.get((int) (2097151 & j));
            if (worker == null) {
                worker = null;
            } else {
                long j2 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j) & (-2097152);
                Object nextParkedWorker = worker.getNextParkedWorker();
                while (true) {
                    symbol = NOT_IN_STACK;
                    if (nextParkedWorker == symbol) {
                        i = -1;
                        break;
                    }
                    if (nextParkedWorker == null) {
                        i = 0;
                        break;
                    }
                    Worker worker2 = (Worker) nextParkedWorker;
                    i = worker2.getIndexInArray();
                    if (i != 0) {
                        break;
                    }
                    nextParkedWorker = worker2.getNextParkedWorker();
                }
                if (i >= 0 && atomicLongFieldUpdater.compareAndSet(this, j, j2 | i)) {
                    worker.setNextParkedWorker(symbol);
                }
            }
            if (worker == null) {
                return false;
            }
            if (Worker.f22055f.compareAndSet(worker, -1, 0)) {
                LockSupport.unpark(worker);
                return true;
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        shutdown(10000L);
    }

    @NotNull
    public final Task createTask(@NotNull Runnable block, @NotNull TaskContext taskContext) {
        long nanoTime = TasksKt.schedulerTimeSource.nanoTime();
        if (block instanceof Task) {
            Task task = (Task) block;
            task.submissionTime = nanoTime;
            task.taskContext = taskContext;
            return task;
        }
        return new TaskImpl(block, nanoTime, taskContext);
    }

    public final void dispatch(@NotNull Runnable block, @NotNull TaskContext taskContext, boolean tailDispatch) {
        boolean z;
        long j;
        Worker worker;
        boolean addLast;
        AbstractTimeSource timeSource = AbstractTimeSourceKt.getTimeSource();
        if (timeSource != null) {
            timeSource.trackTask();
        }
        Task createTask = createTask(block, taskContext);
        boolean z2 = false;
        if (createTask.taskContext.getTaskMode() == 1) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            j = f22053b.addAndGet(this, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE);
        } else {
            j = 0;
        }
        Thread currentThread = Thread.currentThread();
        Worker worker2 = null;
        if (currentThread instanceof Worker) {
            worker = (Worker) currentThread;
        } else {
            worker = null;
        }
        if (worker != null && Intrinsics.areEqual(CoroutineScheduler.this, this)) {
            worker2 = worker;
        }
        if (worker2 != null && worker2.state != WorkerState.TERMINATED && (createTask.taskContext.getTaskMode() != 0 || worker2.state != WorkerState.BLOCKING)) {
            worker2.mayHaveLocalTasks = true;
            createTask = worker2.localQueue.add(createTask, tailDispatch);
        }
        if (createTask != null) {
            if (createTask.taskContext.getTaskMode() == 1) {
                addLast = this.globalBlockingQueue.addLast(createTask);
            } else {
                addLast = this.globalCpuQueue.addLast(createTask);
            }
            if (!addLast) {
                throw new RejectedExecutionException(AbstractC1726qj.m7061q(new StringBuilder(), this.schedulerName, " was terminated"));
            }
        }
        if (tailDispatch && worker2 != null) {
            z2 = true;
        }
        if (z) {
            if (!z2 && !m5738c() && !m5737b(j)) {
                m5738c();
                return;
            }
            return;
        }
        if (z2) {
            return;
        }
        signalCpuWork();
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NotNull Runnable command) {
        dispatch$default(this, command, null, false, 6, null);
    }

    public final boolean isTerminated() {
        if (f22054c.get(this) != 0) {
            return true;
        }
        return false;
    }

    public final boolean parkedWorkersStackPush(@NotNull Worker worker) {
        long j;
        long j2;
        int indexInArray;
        if (worker.getNextParkedWorker() != NOT_IN_STACK) {
            return false;
        }
        do {
            j = f22052a.get(this);
            j2 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j) & (-2097152);
            indexInArray = worker.getIndexInArray();
            worker.setNextParkedWorker(this.workers.get((int) (2097151 & j)));
        } while (!f22052a.compareAndSet(this, j, indexInArray | j2));
        return true;
    }

    public final void parkedWorkersStackTopUpdate(@NotNull Worker worker, int oldIndex, int newIndex) {
        while (true) {
            long j = f22052a.get(this);
            int i = (int) (2097151 & j);
            long j2 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j) & (-2097152);
            if (i == oldIndex) {
                if (newIndex == 0) {
                    Object nextParkedWorker = worker.getNextParkedWorker();
                    while (true) {
                        if (nextParkedWorker == NOT_IN_STACK) {
                            i = -1;
                            break;
                        }
                        if (nextParkedWorker == null) {
                            i = 0;
                            break;
                        }
                        Worker worker2 = (Worker) nextParkedWorker;
                        int indexInArray = worker2.getIndexInArray();
                        if (indexInArray != 0) {
                            i = indexInArray;
                            break;
                        }
                        nextParkedWorker = worker2.getNextParkedWorker();
                    }
                } else {
                    i = newIndex;
                }
            }
            if (i >= 0) {
                if (f22052a.compareAndSet(this, j, i | j2)) {
                    return;
                }
            }
        }
    }

    public final void runSafely(@NotNull Task task) {
        try {
            task.run();
        } catch (Throwable th) {
            try {
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
                AbstractTimeSource timeSource = AbstractTimeSourceKt.getTimeSource();
                if (timeSource == null) {
                }
            } finally {
                AbstractTimeSource timeSource2 = AbstractTimeSourceKt.getTimeSource();
                if (timeSource2 != null) {
                    timeSource2.unTrackTask();
                }
            }
        }
    }

    public final void shutdown(long timeout) {
        Worker worker;
        int i;
        Task removeFirstOrNull;
        if (!f22054c.compareAndSet(this, 0, 1)) {
            return;
        }
        Thread currentThread = Thread.currentThread();
        Worker worker2 = null;
        if (currentThread instanceof Worker) {
            worker = (Worker) currentThread;
        } else {
            worker = null;
        }
        if (worker != null && Intrinsics.areEqual(CoroutineScheduler.this, this)) {
            worker2 = worker;
        }
        synchronized (this.workers) {
            i = (int) (f22053b.get(this) & 2097151);
        }
        if (1 <= i) {
            int i2 = 1;
            while (true) {
                Worker worker3 = this.workers.get(i2);
                Intrinsics.checkNotNull(worker3);
                Worker worker4 = worker3;
                if (worker4 != worker2) {
                    while (worker4.isAlive()) {
                        LockSupport.unpark(worker4);
                        worker4.join(timeout);
                    }
                    worker4.localQueue.offloadAllWorkTo(this.globalBlockingQueue);
                }
                if (i2 == i) {
                    break;
                } else {
                    i2++;
                }
            }
        }
        this.globalBlockingQueue.close();
        this.globalCpuQueue.close();
        while (true) {
            if (worker2 != null) {
                removeFirstOrNull = worker2.findTask(true);
                if (removeFirstOrNull != null) {
                    continue;
                    runSafely(removeFirstOrNull);
                }
            }
            removeFirstOrNull = this.globalCpuQueue.removeFirstOrNull();
            if (removeFirstOrNull == null && (removeFirstOrNull = this.globalBlockingQueue.removeFirstOrNull()) == null) {
                break;
            }
            runSafely(removeFirstOrNull);
        }
        if (worker2 != null) {
            worker2.tryReleaseCpu(WorkerState.TERMINATED);
        }
        f22052a.set(this, 0L);
        f22053b.set(this, 0L);
    }

    public final void signalCpuWork() {
        if (m5738c() || m5737b(f22053b.get(this))) {
            return;
        }
        m5738c();
    }

    @NotNull
    public String toString() {
        ArrayList arrayList = new ArrayList();
        int currentLength = this.workers.currentLength();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 1; i6 < currentLength; i6++) {
            Worker worker = this.workers.get(i6);
            if (worker != null) {
                int size$kotlinx_coroutines_core = worker.localQueue.getSize$kotlinx_coroutines_core();
                int i7 = WhenMappings.$EnumSwitchMapping$0[worker.state.ordinal()];
                if (i7 != 1) {
                    if (i7 != 2) {
                        if (i7 != 3) {
                            if (i7 != 4) {
                                if (i7 == 5) {
                                    i5++;
                                }
                            } else {
                                i4++;
                                if (size$kotlinx_coroutines_core > 0) {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(size$kotlinx_coroutines_core);
                                    sb.append('d');
                                    arrayList.add(sb.toString());
                                }
                            }
                        } else {
                            i++;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(size$kotlinx_coroutines_core);
                            sb2.append('c');
                            arrayList.add(sb2.toString());
                        }
                    } else {
                        i2++;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(size$kotlinx_coroutines_core);
                        sb3.append('b');
                        arrayList.add(sb3.toString());
                    }
                } else {
                    i3++;
                }
            }
        }
        long j = f22053b.get(this);
        return this.schedulerName + '@' + DebugStringsKt.getHexAddress(this) + "[Pool Size {core = " + this.corePoolSize + ", max = " + this.maxPoolSize + "}, Worker States {CPU = " + i + ", blocking = " + i2 + ", parked = " + i3 + ", dormant = " + i4 + ", terminated = " + i5 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.globalCpuQueue.getSize() + ", global blocking queue size = " + this.globalBlockingQueue.getSize() + ", Control State {created workers= " + ((int) (2097151 & j)) + ", blocking tasks = " + ((int) ((4398044413952L & j) >> 21)) + ", CPUs acquired = " + (this.corePoolSize - ((int) ((9223367638808264704L & j) >> 42))) + "}]";
    }

    public /* synthetic */ CoroutineScheduler(int i, int i2, long j, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, (i3 & 4) != 0 ? TasksKt.IDLE_WORKER_KEEP_ALIVE_NS : j, (i3 & 8) != 0 ? TasksKt.DEFAULT_SCHEDULER_NAME : str);
    }
}
