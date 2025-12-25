package okhttp3.internal.connection;

import androidx.core.app.NotificationCompat;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Address;
import okhttp3.ConnectionPool;
import okhttp3.Route;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.platform.Platform;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.AbstractC1726qj;
import p000.ye0;

@Metadata(m5568d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u0000 '2\u00020\u0001:\u0001'B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\rJ?\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u000f¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u0019¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010 \u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u0019¢\u0006\u0004\b \u0010!J\r\u0010\"\u001a\u00020\u001d¢\u0006\u0004\b\"\u0010#J\u0015\u0010%\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u0006¢\u0006\u0004\b%\u0010&¨\u0006("}, m5569d2 = {"Lokhttp3/internal/connection/RealConnectionPool;", "", "Lokhttp3/internal/concurrent/TaskRunner;", "taskRunner", "", "maxIdleConnections", "", "keepAliveDuration", "Ljava/util/concurrent/TimeUnit;", "timeUnit", "<init>", "(Lokhttp3/internal/concurrent/TaskRunner;IJLjava/util/concurrent/TimeUnit;)V", "idleConnectionCount", "()I", "connectionCount", "", "doExtensiveHealthChecks", "Lokhttp3/Address;", "address", "Lokhttp3/internal/connection/RealCall;", NotificationCompat.CATEGORY_CALL, "", "Lokhttp3/Route;", "routes", "requireMultiplexed", "Lokhttp3/internal/connection/RealConnection;", "callAcquirePooledConnection", "(ZLokhttp3/Address;Lokhttp3/internal/connection/RealCall;Ljava/util/List;Z)Lokhttp3/internal/connection/RealConnection;", "connection", "", "put", "(Lokhttp3/internal/connection/RealConnection;)V", "connectionBecameIdle", "(Lokhttp3/internal/connection/RealConnection;)Z", "evictAll", "()V", "now", "cleanup", "(J)J", "Companion", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class RealConnectionPool {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a */
    public final int f24352a;

    /* renamed from: b */
    public final long f24353b;

    /* renamed from: c */
    public final TaskQueue f24354c;

    /* renamed from: d */
    public final RealConnectionPool$cleanupTask$1 f24355d;

    /* renamed from: e */
    public final ConcurrentLinkedQueue f24356e;

    @Metadata(m5568d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m5569d2 = {"Lokhttp3/internal/connection/RealConnectionPool$Companion;", "", "Lokhttp3/ConnectionPool;", "connectionPool", "Lokhttp3/internal/connection/RealConnectionPool;", "get", "(Lokhttp3/ConnectionPool;)Lokhttp3/internal/connection/RealConnectionPool;", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        @NotNull
        public final RealConnectionPool get(@NotNull ConnectionPool connectionPool) {
            Intrinsics.checkNotNullParameter(connectionPool, "connectionPool");
            return connectionPool.getDelegate();
        }
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [okhttp3.internal.connection.RealConnectionPool$cleanupTask$1] */
    public RealConnectionPool(@NotNull TaskRunner taskRunner, int i, long j, @NotNull TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        this.f24352a = i;
        this.f24353b = timeUnit.toNanos(j);
        this.f24354c = taskRunner.newQueue();
        final String m7061q = AbstractC1726qj.m7061q(new StringBuilder(), _UtilJvmKt.okHttpName, " ConnectionPool");
        this.f24355d = new Task(m7061q) { // from class: okhttp3.internal.connection.RealConnectionPool$cleanupTask$1
            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() {
                return RealConnectionPool.this.cleanup(System.nanoTime());
            }
        };
        this.f24356e = new ConcurrentLinkedQueue();
        if (j > 0) {
        } else {
            throw new IllegalArgumentException(ye0.m8294n(j, "keepAliveDuration <= 0: ").toString());
        }
    }

    /* renamed from: a */
    public final int m6619a(RealConnection realConnection, long j) {
        if (_UtilJvmKt.assertionsEnabled && !Thread.holdsLock(realConnection)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + realConnection);
        }
        List<Reference<RealCall>> calls = realConnection.getCalls();
        int i = 0;
        while (i < calls.size()) {
            Reference<RealCall> reference = calls.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                Platform.INSTANCE.get().logCloseableLeak("A connection to " + realConnection.route().address().url() + " was leaked. Did you forget to close a response body?", ((RealCall.CallReference) reference).getCallStackTrace());
                calls.remove(i);
                realConnection.setNoNewExchanges(true);
                if (calls.isEmpty()) {
                    realConnection.setIdleAtNs(j - this.f24353b);
                    return 0;
                }
            }
        }
        return calls.size();
    }

    @Nullable
    public final RealConnection callAcquirePooledConnection(boolean doExtensiveHealthChecks, @NotNull Address address, @NotNull RealCall call, @Nullable List<Route> routes, boolean requireMultiplexed) {
        boolean z;
        Socket releaseConnectionNoEvents$okhttp;
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(call, "call");
        Iterator it = this.f24356e.iterator();
        while (it.hasNext()) {
            RealConnection connection = (RealConnection) it.next();
            Intrinsics.checkNotNullExpressionValue(connection, "connection");
            synchronized (connection) {
                z = false;
                if (requireMultiplexed) {
                    try {
                        if (!connection.isMultiplexed$okhttp()) {
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (connection.isEligible$okhttp(address, routes)) {
                    call.acquireConnectionNoEvents(connection);
                    z = true;
                }
            }
            if (z) {
                if (connection.isHealthy(doExtensiveHealthChecks)) {
                    return connection;
                }
                synchronized (connection) {
                    connection.setNoNewExchanges(true);
                    releaseConnectionNoEvents$okhttp = call.releaseConnectionNoEvents$okhttp();
                }
                if (releaseConnectionNoEvents$okhttp != null) {
                    _UtilJvmKt.closeQuietly(releaseConnectionNoEvents$okhttp);
                }
            }
        }
        return null;
    }

    public final long cleanup(long now) {
        Iterator it = this.f24356e.iterator();
        int i = 0;
        long j = Long.MIN_VALUE;
        RealConnection realConnection = null;
        int i2 = 0;
        while (it.hasNext()) {
            RealConnection connection = (RealConnection) it.next();
            Intrinsics.checkNotNullExpressionValue(connection, "connection");
            synchronized (connection) {
                if (m6619a(connection, now) > 0) {
                    i2++;
                } else {
                    i++;
                    long idleAtNs = now - connection.getIdleAtNs();
                    if (idleAtNs > j) {
                        realConnection = connection;
                        j = idleAtNs;
                    }
                }
            }
        }
        long j2 = this.f24353b;
        if (j < j2 && i <= this.f24352a) {
            if (i > 0) {
                return j2 - j;
            }
            if (i2 > 0) {
                return j2;
            }
            return -1L;
        }
        Intrinsics.checkNotNull(realConnection);
        synchronized (realConnection) {
            if (!realConnection.getCalls().isEmpty()) {
                return 0L;
            }
            if (realConnection.getIdleAtNs() + j != now) {
                return 0L;
            }
            realConnection.setNoNewExchanges(true);
            this.f24356e.remove(realConnection);
            _UtilJvmKt.closeQuietly(realConnection.socket());
            if (this.f24356e.isEmpty()) {
                this.f24354c.cancelAll();
            }
            return 0L;
        }
    }

    public final boolean connectionBecameIdle(@NotNull RealConnection connection) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        if (_UtilJvmKt.assertionsEnabled && !Thread.holdsLock(connection)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + connection);
        }
        if (!connection.getNoNewExchanges() && this.f24352a != 0) {
            TaskQueue.schedule$default(this.f24354c, this.f24355d, 0L, 2, null);
            return false;
        }
        connection.setNoNewExchanges(true);
        ConcurrentLinkedQueue concurrentLinkedQueue = this.f24356e;
        concurrentLinkedQueue.remove(connection);
        if (concurrentLinkedQueue.isEmpty()) {
            this.f24354c.cancelAll();
        }
        return true;
    }

    public final int connectionCount() {
        return this.f24356e.size();
    }

    public final void evictAll() {
        Socket socket;
        Iterator it = this.f24356e.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "connections.iterator()");
        while (it.hasNext()) {
            RealConnection connection = (RealConnection) it.next();
            Intrinsics.checkNotNullExpressionValue(connection, "connection");
            synchronized (connection) {
                if (connection.getCalls().isEmpty()) {
                    it.remove();
                    connection.setNoNewExchanges(true);
                    socket = connection.socket();
                } else {
                    socket = null;
                }
            }
            if (socket != null) {
                _UtilJvmKt.closeQuietly(socket);
            }
        }
        if (this.f24356e.isEmpty()) {
            this.f24354c.cancelAll();
        }
    }

    public final int idleConnectionCount() {
        boolean isEmpty;
        ConcurrentLinkedQueue<RealConnection> concurrentLinkedQueue = this.f24356e;
        int i = 0;
        if (!(concurrentLinkedQueue instanceof Collection) || !concurrentLinkedQueue.isEmpty()) {
            for (RealConnection it : concurrentLinkedQueue) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                synchronized (it) {
                    isEmpty = it.getCalls().isEmpty();
                }
                if (isEmpty && (i = i + 1) < 0) {
                    CollectionsKt__CollectionsKt.throwCountOverflow();
                }
            }
        }
        return i;
    }

    public final void put(@NotNull RealConnection connection) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        if (_UtilJvmKt.assertionsEnabled && !Thread.holdsLock(connection)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + connection);
        }
        this.f24356e.add(connection);
        TaskQueue.schedule$default(this.f24354c, this.f24355d, 0L, 2, null);
    }
}
