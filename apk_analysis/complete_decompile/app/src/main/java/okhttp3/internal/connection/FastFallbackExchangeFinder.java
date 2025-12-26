package okhttp3.internal.connection;

import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RoutePlanner;
import org.jetbrains.annotations.NotNull;
import p000.ha0;
import p000.vc2;

@Metadata(m5568d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, m5569d2 = {"Lokhttp3/internal/connection/FastFallbackExchangeFinder;", "Lokhttp3/internal/connection/ExchangeFinder;", "Lokhttp3/internal/connection/RoutePlanner;", "routePlanner", "Lokhttp3/internal/concurrent/TaskRunner;", "taskRunner", "<init>", "(Lokhttp3/internal/connection/RoutePlanner;Lokhttp3/internal/concurrent/TaskRunner;)V", "Lokhttp3/internal/connection/RealConnection;", "find", "()Lokhttp3/internal/connection/RealConnection;", "a", "Lokhttp3/internal/connection/RoutePlanner;", "getRoutePlanner", "()Lokhttp3/internal/connection/RoutePlanner;", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class FastFallbackExchangeFinder implements ExchangeFinder {

    /* renamed from: a, reason: from kotlin metadata */
    public final RoutePlanner routePlanner;

    /* renamed from: b */
    public final TaskRunner f24302b;

    /* renamed from: c */
    public final long f24303c;

    /* renamed from: d */
    public long f24304d;

    /* renamed from: e */
    public final CopyOnWriteArrayList f24305e;

    /* renamed from: f */
    public final BlockingQueue f24306f;

    public FastFallbackExchangeFinder(@NotNull RoutePlanner routePlanner, @NotNull TaskRunner taskRunner) {
        Intrinsics.checkNotNullParameter(routePlanner, "routePlanner");
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        this.routePlanner = routePlanner;
        this.f24302b = taskRunner;
        this.f24303c = TimeUnit.MILLISECONDS.toNanos(250L);
        this.f24304d = Long.MIN_VALUE;
        this.f24305e = new CopyOnWriteArrayList();
        this.f24306f = taskRunner.getBackend().decorate(new LinkedBlockingDeque());
    }

    /* renamed from: a */
    public final void m6616a() {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f24305e;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            RoutePlanner.Plan plan = (RoutePlanner.Plan) it.next();
            plan.mo9049cancel();
            RoutePlanner.Plan mo9051retry = plan.mo9051retry();
            if (mo9051retry != null) {
                getRoutePlanner().getDeferredPlans().addLast(mo9051retry);
            }
        }
        copyOnWriteArrayList.clear();
    }

    /* renamed from: b */
    public final RoutePlanner.ConnectResult m6617b() {
        final RoutePlanner.Plan failedPlan;
        if (vc2.m7907a(getRoutePlanner(), null, 1, null)) {
            try {
                failedPlan = getRoutePlanner().plan();
            } catch (Throwable th) {
                failedPlan = new FailedPlan(th);
            }
            if (failedPlan.isReady()) {
                return new RoutePlanner.ConnectResult(failedPlan, null, null, 6, null);
            }
            if (failedPlan instanceof FailedPlan) {
                return ((FailedPlan) failedPlan).getResult();
            }
            this.f24305e.add(failedPlan);
            final String str = _UtilJvmKt.okHttpName + " connect " + getRoutePlanner().getAddress().url().redact();
            TaskQueue.schedule$default(this.f24302b.newQueue(), new Task(str) { // from class: okhttp3.internal.connection.FastFallbackExchangeFinder$launchTcpConnect$1
                @Override // okhttp3.internal.concurrent.Task
                public long runOnce() {
                    RoutePlanner.ConnectResult connectResult;
                    CopyOnWriteArrayList copyOnWriteArrayList;
                    BlockingQueue blockingQueue;
                    RoutePlanner.Plan plan = failedPlan;
                    try {
                        connectResult = plan.getResult();
                    } catch (Throwable th2) {
                        connectResult = new RoutePlanner.ConnectResult(failedPlan, null, th2, 2, null);
                    }
                    FastFallbackExchangeFinder fastFallbackExchangeFinder = this;
                    copyOnWriteArrayList = fastFallbackExchangeFinder.f24305e;
                    if (copyOnWriteArrayList.contains(plan)) {
                        blockingQueue = fastFallbackExchangeFinder.f24306f;
                        blockingQueue.put(connectResult);
                        return -1L;
                    }
                    return -1L;
                }
            }, 0L, 2, null);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0052 A[Catch: all -> 0x001d, TryCatch #0 {all -> 0x001d, blocks: (B:4:0x0004, B:6:0x000a, B:12:0x0020, B:14:0x002a, B:21:0x0052, B:56:0x005c, B:59:0x0067, B:26:0x0072, B:28:0x0078, B:30:0x0085, B:31:0x008d, B:34:0x0093, B:37:0x009f, B:39:0x00a5, B:42:0x00ab, B:43:0x00af, B:45:0x00b3, B:46:0x00b4, B:49:0x00ba, B:61:0x0047, B:63:0x00c7, B:64:0x00ce), top: B:3:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0072 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0078 A[Catch: all -> 0x001d, TryCatch #0 {all -> 0x001d, blocks: (B:4:0x0004, B:6:0x000a, B:12:0x0020, B:14:0x002a, B:21:0x0052, B:56:0x005c, B:59:0x0067, B:26:0x0072, B:28:0x0078, B:30:0x0085, B:31:0x008d, B:34:0x0093, B:37:0x009f, B:39:0x00a5, B:42:0x00ab, B:43:0x00af, B:45:0x00b3, B:46:0x00b4, B:49:0x00ba, B:61:0x0047, B:63:0x00c7, B:64:0x00ce), top: B:3:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a5 A[Catch: all -> 0x001d, TryCatch #0 {all -> 0x001d, blocks: (B:4:0x0004, B:6:0x000a, B:12:0x0020, B:14:0x002a, B:21:0x0052, B:56:0x005c, B:59:0x0067, B:26:0x0072, B:28:0x0078, B:30:0x0085, B:31:0x008d, B:34:0x0093, B:37:0x009f, B:39:0x00a5, B:42:0x00ab, B:43:0x00af, B:45:0x00b3, B:46:0x00b4, B:49:0x00ba, B:61:0x0047, B:63:0x00c7, B:64:0x00ce), top: B:3:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ba A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0002 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0071 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0072 A[SYNTHETIC] */
    @Override // okhttp3.internal.connection.ExchangeFinder
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public RealConnection find() {
        RoutePlanner.ConnectResult m6617b;
        long j;
        Throwable throwable;
        RoutePlanner.Plan nextPlan;
        RoutePlanner.ConnectResult connectResult;
        IOException iOException = null;
        while (true) {
            CopyOnWriteArrayList copyOnWriteArrayList = this.f24305e;
            try {
                if (copyOnWriteArrayList.isEmpty() && !vc2.m7907a(getRoutePlanner(), null, 1, null)) {
                    m6616a();
                    Intrinsics.checkNotNull(iOException);
                    throw iOException;
                }
                if (!getRoutePlanner().isCanceled()) {
                    long nanoTime = this.f24302b.getBackend().nanoTime();
                    long j2 = this.f24304d - nanoTime;
                    if (!copyOnWriteArrayList.isEmpty() && j2 > 0) {
                        j = j2;
                        m6617b = null;
                        if (m6617b != null) {
                            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                            if (!copyOnWriteArrayList.isEmpty() && (connectResult = (RoutePlanner.ConnectResult) this.f24306f.poll(j, timeUnit)) != null) {
                                copyOnWriteArrayList.remove(connectResult.getPlan());
                                m6617b = connectResult;
                                if (m6617b != null) {
                                }
                            }
                            m6617b = null;
                            if (m6617b != null) {
                            }
                        }
                        if (m6617b.isSuccess()) {
                            m6616a();
                            if (!m6617b.getPlan().isReady()) {
                                m6617b = m6617b.getPlan().mo9054connectTlsEtc();
                            }
                            if (m6617b.isSuccess()) {
                                return m6617b.getPlan().mo9050handleSuccess();
                            }
                        }
                        throwable = m6617b.getThrowable();
                        if (throwable != null) {
                            if (throwable instanceof IOException) {
                                if (iOException == null) {
                                    iOException = (IOException) throwable;
                                } else {
                                    ha0.addSuppressed(iOException, throwable);
                                }
                            } else {
                                throw throwable;
                            }
                        }
                        nextPlan = m6617b.getNextPlan();
                        if (nextPlan == null) {
                            getRoutePlanner().getDeferredPlans().addFirst(nextPlan);
                        }
                    }
                    m6617b = m6617b();
                    j = this.f24303c;
                    this.f24304d = nanoTime + j;
                    if (m6617b != null) {
                    }
                    if (m6617b.isSuccess()) {
                    }
                    throwable = m6617b.getThrowable();
                    if (throwable != null) {
                    }
                    nextPlan = m6617b.getNextPlan();
                    if (nextPlan == null) {
                    }
                } else {
                    throw new IOException("Canceled");
                }
            } finally {
                m6616a();
            }
        }
    }

    @Override // okhttp3.internal.connection.ExchangeFinder
    @NotNull
    public RoutePlanner getRoutePlanner() {
        return this.routePlanner;
    }
}
