package okhttp3;

import androidx.core.app.NotificationCompat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.connection.RealCall;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.AbstractC1204fq;
import p000.ye0;

@Metadata(m5568d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0002\u0010\u0006J\u001b\u0010\r\u001a\u00020\n2\n\u0010\t\u001a\u00060\u0007R\u00020\bH\u0000¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u0003J\u0017\u0010\u0011\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0013\u001a\u00020\n2\n\u0010\t\u001a\u00060\u0007R\u00020\bH\u0000¢\u0006\u0004\b\u0012\u0010\fJ\u0017\u0010\u0013\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b\u0012\u0010\u0010J\u0013\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0013\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\u0004\b\u0018\u0010\u0017J\r\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\u0019¢\u0006\u0004\b\u001c\u0010\u001bJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u001d\u0010\u001eR*\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u00198F@FX\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010$R*\u0010%\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u00198F@FX\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010!\u001a\u0004\b'\u0010\u001b\"\u0004\b(\u0010$R.\u00101\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010)8F@FX\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0011\u0010\u0005\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u001e¨\u00062"}, m5569d2 = {"Lokhttp3/Dispatcher;", "", "<init>", "()V", "Ljava/util/concurrent/ExecutorService;", "executorService", "(Ljava/util/concurrent/ExecutorService;)V", "Lokhttp3/internal/connection/RealCall$AsyncCall;", "Lokhttp3/internal/connection/RealCall;", NotificationCompat.CATEGORY_CALL, "", "enqueue$okhttp", "(Lokhttp3/internal/connection/RealCall$AsyncCall;)V", "enqueue", "cancelAll", "executed$okhttp", "(Lokhttp3/internal/connection/RealCall;)V", "executed", "finished$okhttp", "finished", "", "Lokhttp3/Call;", "queuedCalls", "()Ljava/util/List;", "runningCalls", "", "queuedCallsCount", "()I", "runningCallsCount", "-deprecated_executorService", "()Ljava/util/concurrent/ExecutorService;", "maxRequests", "a", "I", "getMaxRequests", "setMaxRequests", "(I)V", "maxRequestsPerHost", "b", "getMaxRequestsPerHost", "setMaxRequestsPerHost", "Ljava/lang/Runnable;", "<set-?>", "c", "Ljava/lang/Runnable;", "getIdleCallback", "()Ljava/lang/Runnable;", "setIdleCallback", "(Ljava/lang/Runnable;)V", "idleCallback", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class Dispatcher {

    /* renamed from: a, reason: from kotlin metadata */
    public int maxRequests;

    /* renamed from: b, reason: from kotlin metadata */
    public int maxRequestsPerHost;

    /* renamed from: c, reason: from kotlin metadata */
    public Runnable idleCallback;

    /* renamed from: d */
    public ExecutorService f23942d;

    /* renamed from: e */
    public final ArrayDeque f23943e;

    /* renamed from: f */
    public final ArrayDeque f23944f;

    /* renamed from: g */
    public final ArrayDeque f23945g;

    public Dispatcher() {
        this.maxRequests = 64;
        this.maxRequestsPerHost = 5;
        this.f23943e = new ArrayDeque();
        this.f23944f = new ArrayDeque();
        this.f23945g = new ArrayDeque();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "executorService", imports = {}))
    @JvmName(name = "-deprecated_executorService")
    @NotNull
    /* renamed from: -deprecated_executorService, reason: not valid java name */
    public final ExecutorService m8954deprecated_executorService() {
        return executorService();
    }

    /* renamed from: a */
    public final void m6585a(ArrayDeque arrayDeque, Object obj) {
        Runnable runnable;
        synchronized (this) {
            if (arrayDeque.remove(obj)) {
                runnable = this.idleCallback;
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        if (!m6586b() && runnable != null) {
            runnable.run();
        }
    }

    /* renamed from: b */
    public final boolean m6586b() {
        int i;
        boolean z;
        if (_UtilJvmKt.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            try {
                Iterator it = this.f23943e.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "readyAsyncCalls.iterator()");
                while (it.hasNext()) {
                    RealCall.AsyncCall asyncCall = (RealCall.AsyncCall) it.next();
                    if (this.f23944f.size() >= this.maxRequests) {
                        break;
                    }
                    if (asyncCall.getCallsPerHost().get() < this.maxRequestsPerHost) {
                        it.remove();
                        asyncCall.getCallsPerHost().incrementAndGet();
                        Intrinsics.checkNotNullExpressionValue(asyncCall, "asyncCall");
                        arrayList.add(asyncCall);
                        this.f23944f.add(asyncCall);
                    }
                }
                if (runningCallsCount() > 0) {
                    z = true;
                } else {
                    z = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        int size = arrayList.size();
        for (i = 0; i < size; i++) {
            ((RealCall.AsyncCall) arrayList.get(i)).executeOn(executorService());
        }
        return z;
    }

    public final synchronized void cancelAll() {
        try {
            Iterator it = this.f23943e.iterator();
            while (it.hasNext()) {
                ((RealCall.AsyncCall) it.next()).getF24329c().cancel();
            }
            Iterator it2 = this.f23944f.iterator();
            while (it2.hasNext()) {
                ((RealCall.AsyncCall) it2.next()).getF24329c().cancel();
            }
            Iterator it3 = this.f23945g.iterator();
            while (it3.hasNext()) {
                ((RealCall) it3.next()).cancel();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void enqueue$okhttp(@NotNull RealCall.AsyncCall call) {
        RealCall.AsyncCall asyncCall;
        Intrinsics.checkNotNullParameter(call, "call");
        synchronized (this) {
            this.f23943e.add(call);
            if (!call.getF24329c().getForWebSocket()) {
                String host = call.getHost();
                Iterator it = this.f23944f.iterator();
                while (true) {
                    if (it.hasNext()) {
                        asyncCall = (RealCall.AsyncCall) it.next();
                        if (Intrinsics.areEqual(asyncCall.getHost(), host)) {
                            break;
                        }
                    } else {
                        Iterator it2 = this.f23943e.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                asyncCall = (RealCall.AsyncCall) it2.next();
                                if (Intrinsics.areEqual(asyncCall.getHost(), host)) {
                                    break;
                                }
                            } else {
                                asyncCall = null;
                                break;
                            }
                        }
                    }
                }
                if (asyncCall != null) {
                    call.reuseCallsPerHostFrom(asyncCall);
                }
            }
        }
        m6586b();
    }

    public final synchronized void executed$okhttp(@NotNull RealCall call) {
        Intrinsics.checkNotNullParameter(call, "call");
        this.f23945g.add(call);
    }

    @JvmName(name = "executorService")
    @NotNull
    public final synchronized ExecutorService executorService() {
        ExecutorService executorService;
        try {
            if (this.f23942d == null) {
                this.f23942d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), _UtilJvmKt.threadFactory(_UtilJvmKt.okHttpName + " Dispatcher", false));
            }
            executorService = this.f23942d;
            Intrinsics.checkNotNull(executorService);
        } catch (Throwable th) {
            throw th;
        }
        return executorService;
    }

    public final void finished$okhttp(@NotNull RealCall.AsyncCall call) {
        Intrinsics.checkNotNullParameter(call, "call");
        call.getCallsPerHost().decrementAndGet();
        m6585a(this.f23944f, call);
    }

    @Nullable
    public final synchronized Runnable getIdleCallback() {
        return this.idleCallback;
    }

    public final synchronized int getMaxRequests() {
        return this.maxRequests;
    }

    public final synchronized int getMaxRequestsPerHost() {
        return this.maxRequestsPerHost;
    }

    @NotNull
    public final synchronized List<Call> queuedCalls() {
        List<Call> unmodifiableList;
        try {
            ArrayDeque arrayDeque = this.f23943e;
            ArrayList arrayList = new ArrayList(AbstractC1204fq.collectionSizeOrDefault(arrayDeque, 10));
            Iterator it = arrayDeque.iterator();
            while (it.hasNext()) {
                arrayList.add(((RealCall.AsyncCall) it.next()).getF24329c());
            }
            unmodifiableList = Collections.unmodifiableList(arrayList);
            Intrinsics.checkNotNullExpressionValue(unmodifiableList, "unmodifiableList(readyAsyncCalls.map { it.call })");
        } catch (Throwable th) {
            throw th;
        }
        return unmodifiableList;
    }

    public final synchronized int queuedCallsCount() {
        return this.f23943e.size();
    }

    @NotNull
    public final synchronized List<Call> runningCalls() {
        List<Call> unmodifiableList;
        try {
            ArrayDeque arrayDeque = this.f23945g;
            ArrayDeque arrayDeque2 = this.f23944f;
            ArrayList arrayList = new ArrayList(AbstractC1204fq.collectionSizeOrDefault(arrayDeque2, 10));
            Iterator it = arrayDeque2.iterator();
            while (it.hasNext()) {
                arrayList.add(((RealCall.AsyncCall) it.next()).getF24329c());
            }
            unmodifiableList = Collections.unmodifiableList(CollectionsKt___CollectionsKt.plus((Collection) arrayDeque, (Iterable) arrayList));
            Intrinsics.checkNotNullExpressionValue(unmodifiableList, "unmodifiableList(running…yncCalls.map { it.call })");
        } catch (Throwable th) {
            throw th;
        }
        return unmodifiableList;
    }

    public final synchronized int runningCallsCount() {
        return this.f23944f.size() + this.f23945g.size();
    }

    public final synchronized void setIdleCallback(@Nullable Runnable runnable) {
        this.idleCallback = runnable;
    }

    public final void setMaxRequests(int i) {
        if (i >= 1) {
            synchronized (this) {
                this.maxRequests = i;
            }
            m6586b();
            return;
        }
        throw new IllegalArgumentException(ye0.m8291k(i, "max < 1: ").toString());
    }

    public final void setMaxRequestsPerHost(int i) {
        if (i >= 1) {
            synchronized (this) {
                this.maxRequestsPerHost = i;
            }
            m6586b();
            return;
        }
        throw new IllegalArgumentException(ye0.m8291k(i, "max < 1: ").toString());
    }

    public final void finished$okhttp(@NotNull RealCall call) {
        Intrinsics.checkNotNullParameter(call, "call");
        m6585a(this.f23945g, call);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Dispatcher(@NotNull ExecutorService executorService) {
        this();
        Intrinsics.checkNotNullParameter(executorService, "executorService");
        this.f23942d = executorService;
    }
}
