package okhttp3.internal.connection;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.CertificatePinner;
import okhttp3.Dispatcher;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.cache.CacheInterceptor;
import okhttp3.internal.connection.RoutePlanner;
import okhttp3.internal.http.BridgeInterceptor;
import okhttp3.internal.http.CallServerInterceptor;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.RetryAndFollowUpInterceptor;
import okhttp3.internal.platform.Platform;
import okio.AsyncTimeout;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.AbstractC1327iq;
import p000.ha0;

@Metadata(m5568d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0002hiB\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001e\u0010\u0016J\u000f\u0010 \u001a\u00020\u0017H\u0000¢\u0006\u0004\b\u001f\u0010\u0019J%\u0010$\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b$\u0010%J\u0017\u0010)\u001a\u00020&2\u0006\u0010#\u001a\u00020\"H\u0000¢\u0006\u0004\b'\u0010(J\u0015\u0010,\u001a\u00020\u00122\u0006\u0010+\u001a\u00020*¢\u0006\u0004\b,\u0010-J;\u00106\u001a\u00028\u0000\"\n\b\u0000\u0010/*\u0004\u0018\u00010.2\u0006\u00100\u001a\u00020&2\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00028\u0000H\u0000¢\u0006\u0004\b4\u00105J\u001b\u00109\u001a\u0004\u0018\u00010.2\b\u00103\u001a\u0004\u0018\u00010.H\u0000¢\u0006\u0004\b7\u00108J\u0011\u0010=\u001a\u0004\u0018\u00010:H\u0000¢\u0006\u0004\b;\u0010<J\r\u0010>\u001a\u00020\u0012¢\u0006\u0004\b>\u0010\u0014J\u0017\u0010B\u001a\u00020\u00122\u0006\u0010?\u001a\u00020\u0007H\u0000¢\u0006\u0004\b@\u0010AJ\r\u0010C\u001a\u00020\u0007¢\u0006\u0004\bC\u0010\u0016J\u000f\u0010G\u001a\u00020DH\u0000¢\u0006\u0004\bE\u0010FR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010KR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010\u0011R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010\u0016R\u001a\u0010V\u001a\u00020R8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b3\u0010S\u001a\u0004\bT\u0010UR(\u0010+\u001a\u0004\u0018\u00010*2\b\u0010W\u001a\u0004\u0018\u00010*8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[R(\u0010`\u001a\u0004\u0018\u00010&2\b\u0010W\u001a\u0004\u0018\u00010&8\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_R \u0010g\u001a\b\u0012\u0004\u0012\u00020b0a8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bc\u0010d\u001a\u0004\be\u0010f¨\u0006j"}, m5569d2 = {"Lokhttp3/internal/connection/RealCall;", "Lokhttp3/Call;", "", "Lokhttp3/OkHttpClient;", "client", "Lokhttp3/Request;", "originalRequest", "", "forWebSocket", "<init>", "(Lokhttp3/OkHttpClient;Lokhttp3/Request;Z)V", "Lokio/Timeout;", "timeout", "()Lokio/Timeout;", "clone", "()Lokhttp3/Call;", "request", "()Lokhttp3/Request;", "", "cancel", "()V", "isCanceled", "()Z", "Lokhttp3/Response;", "execute", "()Lokhttp3/Response;", "Lokhttp3/Callback;", "responseCallback", "enqueue", "(Lokhttp3/Callback;)V", "isExecuted", "getResponseWithInterceptorChain$okhttp", "getResponseWithInterceptorChain", "newRoutePlanner", "Lokhttp3/internal/http/RealInterceptorChain;", "chain", "enterNetworkInterceptorExchange", "(Lokhttp3/Request;ZLokhttp3/internal/http/RealInterceptorChain;)V", "Lokhttp3/internal/connection/Exchange;", "initExchange$okhttp", "(Lokhttp3/internal/http/RealInterceptorChain;)Lokhttp3/internal/connection/Exchange;", "initExchange", "Lokhttp3/internal/connection/RealConnection;", "connection", "acquireConnectionNoEvents", "(Lokhttp3/internal/connection/RealConnection;)V", "Ljava/io/IOException;", ExifInterface.LONGITUDE_EAST, "exchange", "requestDone", "responseDone", "e", "messageDone$okhttp", "(Lokhttp3/internal/connection/Exchange;ZZLjava/io/IOException;)Ljava/io/IOException;", "messageDone", "noMoreExchanges$okhttp", "(Ljava/io/IOException;)Ljava/io/IOException;", "noMoreExchanges", "Ljava/net/Socket;", "releaseConnectionNoEvents$okhttp", "()Ljava/net/Socket;", "releaseConnectionNoEvents", "timeoutEarlyExit", "closeExchange", "exitNetworkInterceptorExchange$okhttp", "(Z)V", "exitNetworkInterceptorExchange", "retryAfterFailure", "", "redactedUrl$okhttp", "()Ljava/lang/String;", "redactedUrl", "a", "Lokhttp3/OkHttpClient;", "getClient", "()Lokhttp3/OkHttpClient;", "b", "Lokhttp3/Request;", "getOriginalRequest", "c", "Z", "getForWebSocket", "Lokhttp3/EventListener;", "Lokhttp3/EventListener;", "getEventListener$okhttp", "()Lokhttp3/EventListener;", "eventListener", "<set-?>", "j", "Lokhttp3/internal/connection/RealConnection;", "getConnection", "()Lokhttp3/internal/connection/RealConnection;", "l", "Lokhttp3/internal/connection/Exchange;", "getInterceptorScopedExchange$okhttp", "()Lokhttp3/internal/connection/Exchange;", "interceptorScopedExchange", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lokhttp3/internal/connection/RoutePlanner$Plan;", "r", "Ljava/util/concurrent/CopyOnWriteArrayList;", "getPlansToCancel$okhttp", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "plansToCancel", "AsyncCall", "CallReference", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class RealCall implements Call, Cloneable {

    /* renamed from: a, reason: from kotlin metadata */
    public final OkHttpClient client;

    /* renamed from: b, reason: from kotlin metadata */
    public final Request originalRequest;

    /* renamed from: c, reason: from kotlin metadata */
    public final boolean forWebSocket;

    /* renamed from: d */
    public final RealConnectionPool f24312d;

    /* renamed from: e, reason: from kotlin metadata */
    public final EventListener eventListener;

    /* renamed from: f */
    public final RealCall$timeout$1 f24314f;

    /* renamed from: g */
    public final AtomicBoolean f24315g;

    /* renamed from: h */
    public Object f24316h;

    /* renamed from: i */
    public ExchangeFinder f24317i;

    /* renamed from: j, reason: from kotlin metadata */
    public RealConnection connection;

    /* renamed from: k */
    public boolean f24319k;

    /* renamed from: l, reason: from kotlin metadata */
    public Exchange interceptorScopedExchange;

    /* renamed from: m */
    public boolean f24321m;

    /* renamed from: n */
    public boolean f24322n;

    /* renamed from: o */
    public boolean f24323o;

    /* renamed from: p */
    public volatile boolean f24324p;

    /* renamed from: q */
    public volatile Exchange f24325q;

    /* renamed from: r, reason: from kotlin metadata */
    public final CopyOnWriteArrayList plansToCancel;

    @Metadata(m5568d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\n\u0010\u0007\u001a\u00060\u0000R\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R$\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00118\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u001b\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001f\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\"\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006#"}, m5569d2 = {"Lokhttp3/internal/connection/RealCall$AsyncCall;", "Ljava/lang/Runnable;", "Lokhttp3/Callback;", "responseCallback", "<init>", "(Lokhttp3/internal/connection/RealCall;Lokhttp3/Callback;)V", "Lokhttp3/internal/connection/RealCall;", "other", "", "reuseCallsPerHostFrom", "(Lokhttp3/internal/connection/RealCall$AsyncCall;)V", "Ljava/util/concurrent/ExecutorService;", "executorService", "executeOn", "(Ljava/util/concurrent/ExecutorService;)V", "run", "()V", "Ljava/util/concurrent/atomic/AtomicInteger;", "<set-?>", "b", "Ljava/util/concurrent/atomic/AtomicInteger;", "getCallsPerHost", "()Ljava/util/concurrent/atomic/AtomicInteger;", "callsPerHost", "", "getHost", "()Ljava/lang/String;", "host", "Lokhttp3/Request;", "getRequest", "()Lokhttp3/Request;", "request", "getCall", "()Lokhttp3/internal/connection/RealCall;", NotificationCompat.CATEGORY_CALL, "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public final class AsyncCall implements Runnable {

        /* renamed from: a */
        public final Callback f24327a;

        /* renamed from: b, reason: from kotlin metadata */
        public volatile AtomicInteger callsPerHost;

        /* renamed from: c */
        public final /* synthetic */ RealCall f24329c;

        public AsyncCall(@NotNull RealCall realCall, Callback responseCallback) {
            Intrinsics.checkNotNullParameter(responseCallback, "responseCallback");
            this.f24329c = realCall;
            this.f24327a = responseCallback;
            this.callsPerHost = new AtomicInteger(0);
        }

        public final void executeOn(@NotNull ExecutorService executorService) {
            Intrinsics.checkNotNullParameter(executorService, "executorService");
            RealCall realCall = this.f24329c;
            Dispatcher dispatcher = realCall.getClient().dispatcher();
            if (_UtilJvmKt.assertionsEnabled && Thread.holdsLock(dispatcher)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + dispatcher);
            }
            try {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e);
                    realCall.noMoreExchanges$okhttp(interruptedIOException);
                    this.f24327a.onFailure(realCall, interruptedIOException);
                    realCall.getClient().dispatcher().finished$okhttp(this);
                }
            } catch (Throwable th) {
                realCall.getClient().dispatcher().finished$okhttp(this);
                throw th;
            }
        }

        @NotNull
        /* renamed from: getCall, reason: from getter */
        public final RealCall getF24329c() {
            return this.f24329c;
        }

        @NotNull
        public final AtomicInteger getCallsPerHost() {
            return this.callsPerHost;
        }

        @NotNull
        public final String getHost() {
            return this.f24329c.getOriginalRequest().url().host();
        }

        @NotNull
        public final Request getRequest() {
            return this.f24329c.getOriginalRequest();
        }

        public final void reuseCallsPerHostFrom(@NotNull AsyncCall other) {
            Intrinsics.checkNotNullParameter(other, "other");
            this.callsPerHost = other.callsPerHost;
        }

        @Override // java.lang.Runnable
        public void run() {
            Dispatcher dispatcher;
            Callback callback = this.f24327a;
            StringBuilder sb = new StringBuilder("OkHttp ");
            RealCall realCall = this.f24329c;
            sb.append(realCall.redactedUrl$okhttp());
            String sb2 = sb.toString();
            Thread currentThread = Thread.currentThread();
            String name = currentThread.getName();
            currentThread.setName(sb2);
            try {
                realCall.f24314f.enter();
                boolean z = false;
                try {
                    try {
                    } catch (Throwable th) {
                        realCall.getClient().dispatcher().finished$okhttp(this);
                        throw th;
                    }
                } catch (IOException e) {
                    e = e;
                } catch (Throwable th2) {
                    th = th2;
                }
                try {
                    callback.onResponse(realCall, realCall.getResponseWithInterceptorChain$okhttp());
                    dispatcher = realCall.getClient().dispatcher();
                } catch (IOException e2) {
                    e = e2;
                    z = true;
                    if (z) {
                        Platform.INSTANCE.get().log("Callback failure for " + RealCall.access$toLoggableString(realCall), 4, e);
                    } else {
                        callback.onFailure(realCall, e);
                    }
                    dispatcher = realCall.getClient().dispatcher();
                    dispatcher.finished$okhttp(this);
                } catch (Throwable th3) {
                    th = th3;
                    z = true;
                    realCall.cancel();
                    if (!z) {
                        IOException iOException = new IOException("canceled due to " + th);
                        ha0.addSuppressed(iOException, th);
                        callback.onFailure(realCall, iOException);
                    }
                    throw th;
                }
                dispatcher.finished$okhttp(this);
            } finally {
                currentThread.setName(name);
            }
        }
    }

    @Metadata(m5568d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, m5569d2 = {"Lokhttp3/internal/connection/RealCall$CallReference;", "Ljava/lang/ref/WeakReference;", "Lokhttp3/internal/connection/RealCall;", "referent", "", "callStackTrace", "<init>", "(Lokhttp3/internal/connection/RealCall;Ljava/lang/Object;)V", "a", "Ljava/lang/Object;", "getCallStackTrace", "()Ljava/lang/Object;", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class CallReference extends WeakReference<RealCall> {

        /* renamed from: a, reason: from kotlin metadata */
        public final Object callStackTrace;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CallReference(@NotNull RealCall referent, @Nullable Object obj) {
            super(referent);
            Intrinsics.checkNotNullParameter(referent, "referent");
            this.callStackTrace = obj;
        }

        @Nullable
        public final Object getCallStackTrace() {
            return this.callStackTrace;
        }
    }

    /* JADX WARN: Type inference failed for: r4v5, types: [okio.Timeout, okhttp3.internal.connection.RealCall$timeout$1] */
    public RealCall(@NotNull OkHttpClient client, @NotNull Request originalRequest, boolean z) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(originalRequest, "originalRequest");
        this.client = client;
        this.originalRequest = originalRequest;
        this.forWebSocket = z;
        this.f24312d = client.connectionPool().getDelegate();
        this.eventListener = client.eventListenerFactory().create(this);
        ?? r4 = new AsyncTimeout() { // from class: okhttp3.internal.connection.RealCall$timeout$1
            @Override // okio.AsyncTimeout
            public void timedOut() {
                RealCall.this.cancel();
            }
        };
        r4.timeout(client.callTimeoutMillis(), TimeUnit.MILLISECONDS);
        this.f24314f = r4;
        this.f24315g = new AtomicBoolean();
        this.f24323o = true;
        this.plansToCancel = new CopyOnWriteArrayList();
    }

    public static final String access$toLoggableString(RealCall realCall) {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        if (realCall.getF24324p()) {
            str = "canceled ";
        } else {
            str = "";
        }
        sb.append(str);
        if (realCall.forWebSocket) {
            str2 = "web socket";
        } else {
            str2 = NotificationCompat.CATEGORY_CALL;
        }
        sb.append(str2);
        sb.append(" to ");
        sb.append(realCall.redactedUrl$okhttp());
        return sb.toString();
    }

    /* renamed from: a */
    public final IOException m6618a(IOException iOException) {
        IOException interruptedIOException;
        Socket releaseConnectionNoEvents$okhttp;
        boolean z = _UtilJvmKt.assertionsEnabled;
        if (z && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        RealConnection realConnection = this.connection;
        if (realConnection != null) {
            if (z && Thread.holdsLock(realConnection)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + realConnection);
            }
            synchronized (realConnection) {
                releaseConnectionNoEvents$okhttp = releaseConnectionNoEvents$okhttp();
            }
            if (this.connection == null) {
                if (releaseConnectionNoEvents$okhttp != null) {
                    _UtilJvmKt.closeQuietly(releaseConnectionNoEvents$okhttp);
                }
                this.eventListener.connectionReleased(this, realConnection);
            } else if (releaseConnectionNoEvents$okhttp != null) {
                throw new IllegalStateException("Check failed.");
            }
        }
        if (this.f24319k || !exit()) {
            interruptedIOException = iOException;
        } else {
            interruptedIOException = new InterruptedIOException("timeout");
            if (iOException != null) {
                interruptedIOException.initCause(iOException);
            }
        }
        if (iOException != null) {
            EventListener eventListener = this.eventListener;
            Intrinsics.checkNotNull(interruptedIOException);
            eventListener.callFailed(this, interruptedIOException);
        } else {
            this.eventListener.callEnd(this);
        }
        return interruptedIOException;
    }

    public final void acquireConnectionNoEvents(@NotNull RealConnection connection) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        if (_UtilJvmKt.assertionsEnabled && !Thread.holdsLock(connection)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + connection);
        }
        if (this.connection == null) {
            this.connection = connection;
            connection.getCalls().add(new CallReference(this, this.f24316h));
            return;
        }
        throw new IllegalStateException("Check failed.");
    }

    @Override // okhttp3.Call
    public void cancel() {
        if (this.f24324p) {
            return;
        }
        this.f24324p = true;
        Exchange exchange = this.f24325q;
        if (exchange != null) {
            exchange.cancel();
        }
        Iterator it = this.plansToCancel.iterator();
        while (it.hasNext()) {
            ((RoutePlanner.Plan) it.next()).mo9049cancel();
        }
        this.eventListener.canceled(this);
    }

    @Override // okhttp3.Call
    public void enqueue(@NotNull Callback responseCallback) {
        Intrinsics.checkNotNullParameter(responseCallback, "responseCallback");
        if (this.f24315g.compareAndSet(false, true)) {
            this.f24316h = Platform.INSTANCE.get().getStackTraceForCloseable("response.body().close()");
            this.eventListener.callStart(this);
            this.client.dispatcher().enqueue$okhttp(new AsyncCall(this, responseCallback));
            return;
        }
        throw new IllegalStateException("Already Executed");
    }

    public final void enterNetworkInterceptorExchange(@NotNull Request request, boolean newRoutePlanner, @NotNull RealInterceptorChain chain) {
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        CertificatePinner certificatePinner;
        ExchangeFinder sequentialExchangeFinder;
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(chain, "chain");
        if (this.interceptorScopedExchange == null) {
            synchronized (this) {
                try {
                    if (!this.f24322n) {
                        if (this.f24321m) {
                            throw new IllegalStateException("Check failed.");
                        }
                    } else {
                        throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (newRoutePlanner) {
                OkHttpClient okHttpClient = this.client;
                HttpUrl url = request.url();
                boolean isHttps = url.getIsHttps();
                OkHttpClient okHttpClient2 = this.client;
                if (isHttps) {
                    sSLSocketFactory = okHttpClient2.sslSocketFactory();
                    hostnameVerifier = okHttpClient2.hostnameVerifier();
                    certificatePinner = okHttpClient2.certificatePinner();
                } else {
                    sSLSocketFactory = null;
                    hostnameVerifier = null;
                    certificatePinner = null;
                }
                RealRoutePlanner realRoutePlanner = new RealRoutePlanner(okHttpClient, new Address(url.host(), url.port(), okHttpClient2.dns(), okHttpClient2.socketFactory(), sSLSocketFactory, hostnameVerifier, certificatePinner, okHttpClient2.proxyAuthenticator(), okHttpClient2.proxy(), okHttpClient2.protocols(), okHttpClient2.connectionSpecs(), okHttpClient2.proxySelector()), this, chain);
                if (this.client.getFastFallback()) {
                    sequentialExchangeFinder = new FastFallbackExchangeFinder(realRoutePlanner, this.client.getTaskRunner());
                } else {
                    sequentialExchangeFinder = new SequentialExchangeFinder(realRoutePlanner);
                }
                this.f24317i = sequentialExchangeFinder;
                return;
            }
            return;
        }
        throw new IllegalStateException("Check failed.");
    }

    @Override // okhttp3.Call
    @NotNull
    public Response execute() {
        OkHttpClient okHttpClient = this.client;
        if (this.f24315g.compareAndSet(false, true)) {
            enter();
            this.f24316h = Platform.INSTANCE.get().getStackTraceForCloseable("response.body().close()");
            this.eventListener.callStart(this);
            try {
                okHttpClient.dispatcher().executed$okhttp(this);
                return getResponseWithInterceptorChain$okhttp();
            } finally {
                okHttpClient.dispatcher().finished$okhttp(this);
            }
        }
        throw new IllegalStateException("Already Executed");
    }

    public final void exitNetworkInterceptorExchange$okhttp(boolean closeExchange) {
        Exchange exchange;
        synchronized (this) {
            if (!this.f24323o) {
                throw new IllegalStateException("released");
            }
        }
        if (closeExchange && (exchange = this.f24325q) != null) {
            exchange.detachWithViolence();
        }
        this.interceptorScopedExchange = null;
    }

    @NotNull
    public final OkHttpClient getClient() {
        return this.client;
    }

    @Nullable
    public final RealConnection getConnection() {
        return this.connection;
    }

    @NotNull
    /* renamed from: getEventListener$okhttp, reason: from getter */
    public final EventListener getEventListener() {
        return this.eventListener;
    }

    public final boolean getForWebSocket() {
        return this.forWebSocket;
    }

    @Nullable
    /* renamed from: getInterceptorScopedExchange$okhttp, reason: from getter */
    public final Exchange getInterceptorScopedExchange() {
        return this.interceptorScopedExchange;
    }

    @NotNull
    public final Request getOriginalRequest() {
        return this.originalRequest;
    }

    @NotNull
    public final CopyOnWriteArrayList<RoutePlanner.Plan> getPlansToCancel$okhttp() {
        return this.plansToCancel;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0094  */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Response getResponseWithInterceptorChain$okhttp() {
        ArrayList arrayList = new ArrayList();
        OkHttpClient okHttpClient = this.client;
        AbstractC1327iq.addAll(arrayList, okHttpClient.interceptors());
        arrayList.add(new RetryAndFollowUpInterceptor(okHttpClient));
        arrayList.add(new BridgeInterceptor(okHttpClient.cookieJar()));
        arrayList.add(new CacheInterceptor(okHttpClient.cache()));
        arrayList.add(ConnectInterceptor.INSTANCE);
        boolean z = this.forWebSocket;
        if (!z) {
            AbstractC1327iq.addAll(arrayList, okHttpClient.networkInterceptors());
        }
        arrayList.add(new CallServerInterceptor(z));
        boolean z2 = false;
        try {
            Response proceed = new RealInterceptorChain(this, arrayList, 0, null, this.originalRequest, okHttpClient.connectTimeoutMillis(), okHttpClient.readTimeoutMillis(), okHttpClient.writeTimeoutMillis()).proceed(this.originalRequest);
            if (!getF24324p()) {
                noMoreExchanges$okhttp(null);
                return proceed;
            }
            _UtilCommonKt.closeQuietly(proceed);
            throw new IOException("Canceled");
        } catch (IOException e) {
            try {
                IOException noMoreExchanges$okhttp = noMoreExchanges$okhttp(e);
                if (noMoreExchanges$okhttp == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                }
                throw noMoreExchanges$okhttp;
            } catch (Throwable th) {
                th = th;
                z2 = true;
                if (!z2) {
                    noMoreExchanges$okhttp(null);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            if (!z2) {
            }
            throw th;
        }
    }

    @NotNull
    public final Exchange initExchange$okhttp(@NotNull RealInterceptorChain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        synchronized (this) {
            try {
                if (this.f24323o) {
                    if (!this.f24322n) {
                        if (this.f24321m) {
                            throw new IllegalStateException("Check failed.");
                        }
                    } else {
                        throw new IllegalStateException("Check failed.");
                    }
                } else {
                    throw new IllegalStateException("released");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        ExchangeFinder exchangeFinder = this.f24317i;
        Intrinsics.checkNotNull(exchangeFinder);
        Exchange exchange = new Exchange(this, this.eventListener, exchangeFinder, exchangeFinder.find().newCodec$okhttp(this.client, chain));
        this.interceptorScopedExchange = exchange;
        this.f24325q = exchange;
        synchronized (this) {
            this.f24321m = true;
            this.f24322n = true;
        }
        if (!this.f24324p) {
            return exchange;
        }
        throw new IOException("Canceled");
    }

    @Override // okhttp3.Call
    /* renamed from: isCanceled, reason: from getter */
    public boolean getF24324p() {
        return this.f24324p;
    }

    @Override // okhttp3.Call
    public boolean isExecuted() {
        return this.f24315g.get();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0021 A[Catch: all -> 0x0017, TryCatch #0 {all -> 0x0017, blocks: (B:43:0x0012, B:12:0x0021, B:14:0x0025, B:15:0x0027, B:17:0x002c, B:21:0x0035, B:23:0x0039, B:9:0x001b), top: B:42:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0025 A[Catch: all -> 0x0017, TryCatch #0 {all -> 0x0017, blocks: (B:43:0x0012, B:12:0x0021, B:14:0x0025, B:15:0x0027, B:17:0x002c, B:21:0x0035, B:23:0x0039, B:9:0x001b), top: B:42:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <E extends IOException> E messageDone$okhttp(@NotNull Exchange exchange, boolean requestDone, boolean responseDone, E e) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        Intrinsics.checkNotNullParameter(exchange, "exchange");
        if (!Intrinsics.areEqual(exchange, this.f24325q)) {
            return e;
        }
        synchronized (this) {
            z = false;
            if (requestDone) {
                try {
                    if (!this.f24321m) {
                    }
                    if (requestDone) {
                        this.f24321m = false;
                    }
                    if (responseDone) {
                        this.f24322n = false;
                    }
                    z3 = this.f24321m;
                    if (z3 && !this.f24322n) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (!z3 && !this.f24322n) {
                        if (!this.f24323o) {
                            z = true;
                        }
                    }
                    z2 = z;
                    z = z4;
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (!responseDone || !this.f24322n) {
                z2 = false;
            }
            if (requestDone) {
            }
            if (responseDone) {
            }
            z3 = this.f24321m;
            if (z3) {
            }
            z4 = false;
            if (!z3) {
                if (!this.f24323o) {
                }
            }
            z2 = z;
            z = z4;
        }
        if (z) {
            this.f24325q = null;
            RealConnection realConnection = this.connection;
            if (realConnection != null) {
                realConnection.incrementSuccessCount$okhttp();
            }
        }
        if (z2) {
            return (E) m6618a(e);
        }
        return e;
    }

    @Nullable
    public final IOException noMoreExchanges$okhttp(@Nullable IOException e) {
        boolean z;
        synchronized (this) {
            z = false;
            if (this.f24323o) {
                this.f24323o = false;
                if (!this.f24321m) {
                    if (!this.f24322n) {
                        z = true;
                    }
                }
            }
        }
        if (z) {
            return m6618a(e);
        }
        return e;
    }

    @NotNull
    public final String redactedUrl$okhttp() {
        return this.originalRequest.url().redact();
    }

    @Nullable
    public final Socket releaseConnectionNoEvents$okhttp() {
        RealConnection realConnection = this.connection;
        Intrinsics.checkNotNull(realConnection);
        if (_UtilJvmKt.assertionsEnabled && !Thread.holdsLock(realConnection)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + realConnection);
        }
        List<Reference<RealCall>> calls = realConnection.getCalls();
        Iterator<Reference<RealCall>> it = calls.iterator();
        int i = 0;
        while (true) {
            if (it.hasNext()) {
                if (Intrinsics.areEqual(it.next().get(), this)) {
                    break;
                }
                i++;
            } else {
                i = -1;
                break;
            }
        }
        if (i != -1) {
            calls.remove(i);
            this.connection = null;
            if (calls.isEmpty()) {
                realConnection.setIdleAtNs(System.nanoTime());
                if (this.f24312d.connectionBecameIdle(realConnection)) {
                    return realConnection.socket();
                }
            }
            return null;
        }
        throw new IllegalStateException("Check failed.");
    }

    @Override // okhttp3.Call
    @NotNull
    public Request request() {
        return this.originalRequest;
    }

    public final boolean retryAfterFailure() {
        RealConnection realConnection;
        Exchange exchange = this.f24325q;
        if (exchange != null && exchange.getHasFailure()) {
            ExchangeFinder exchangeFinder = this.f24317i;
            Intrinsics.checkNotNull(exchangeFinder);
            RoutePlanner routePlanner = exchangeFinder.getRoutePlanner();
            Exchange exchange2 = this.f24325q;
            if (exchange2 != null) {
                realConnection = exchange2.getConnection$okhttp();
            } else {
                realConnection = null;
            }
            if (routePlanner.hasNext(realConnection)) {
                return true;
            }
        }
        return false;
    }

    @Override // okhttp3.Call
    @NotNull
    public Timeout timeout() {
        return this.f24314f;
    }

    public final void timeoutEarlyExit() {
        if (!this.f24319k) {
            this.f24319k = true;
            exit();
            return;
        }
        throw new IllegalStateException("Check failed.");
    }

    @Override // okhttp3.Call
    @NotNull
    public Call clone() {
        return new RealCall(this.client, this.originalRequest, this.forWebSocket);
    }
}
