package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.util.concurrent.internal.InternalFutureFailureAccess;
import com.google.common.util.concurrent.internal.InternalFutures;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.ForOverride;
import com.google.j2objc.annotations.ReflectionSupport;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;
import p000.AbstractC1726qj;
import p000.C1252h0;
import p000.C1337j0;
import p000.C1374k0;
import p000.C1494l0;
import p000.C1892v0;
import p000.InterfaceC1605o0;
import p000.RunnableC1531m0;
import p000.e40;
import p000.yy2;

@ReflectionSupport(ReflectionSupport.Level.FULL)
@GwtCompatible(emulated = true)
/* loaded from: classes2.dex */
public abstract class AbstractFuture<V> extends InternalFutureFailureAccess implements ListenableFuture<V> {

    /* renamed from: d */
    public static final boolean f15251d;

    /* renamed from: e */
    public static final Logger f15252e;

    /* renamed from: f */
    public static final yy2 f15253f;

    /* renamed from: g */
    public static final Object f15254g;

    /* renamed from: a */
    public volatile Object f15255a;

    /* renamed from: b */
    public volatile C1374k0 f15256b;

    /* renamed from: c */
    public volatile C1892v0 f15257c;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [yy2] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    static {
        boolean z;
        ?? c1494l0;
        try {
            z = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z = false;
        }
        f15251d = z;
        f15252e = Logger.getLogger(AbstractFuture.class.getName());
        Throwable th = null;
        try {
            c1494l0 = new Object();
            th = null;
        } catch (Throwable th2) {
            th = th2;
            try {
                c1494l0 = new C1494l0(AtomicReferenceFieldUpdater.newUpdater(C1892v0.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(C1892v0.class, C1892v0.class, "b"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, C1892v0.class, "c"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, C1374k0.class, "b"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Object.class, "a"));
            } catch (Throwable th3) {
                th = th3;
                c1494l0 = new Object();
            }
        }
        f15253f = c1494l0;
        if (th != null) {
            Logger logger = f15252e;
            Level level = Level.SEVERE;
            logger.log(level, "UnsafeAtomicHelper is broken!", th);
            logger.log(level, "SafeAtomicHelper is broken!", th);
        }
        f15254g = new Object();
    }

    /* renamed from: c */
    public static void m4305c(AbstractFuture abstractFuture) {
        C1374k0 c1374k0 = null;
        while (true) {
            abstractFuture.getClass();
            for (C1892v0 mo5810p = f15253f.mo5810p(abstractFuture); mo5810p != null; mo5810p = mo5810p.f27561b) {
                Thread thread = mo5810p.f27560a;
                if (thread != null) {
                    mo5810p.f27560a = null;
                    LockSupport.unpark(thread);
                }
            }
            abstractFuture.afterDone();
            C1374k0 c1374k02 = c1374k0;
            C1374k0 mo5809o = f15253f.mo5809o(abstractFuture);
            C1374k0 c1374k03 = c1374k02;
            while (mo5809o != null) {
                C1374k0 c1374k04 = mo5809o.f20704c;
                mo5809o.f20704c = c1374k03;
                c1374k03 = mo5809o;
                mo5809o = c1374k04;
            }
            while (c1374k03 != null) {
                c1374k0 = c1374k03.f20704c;
                Runnable runnable = c1374k03.f20702a;
                Objects.requireNonNull(runnable);
                if (runnable instanceof RunnableC1531m0) {
                    RunnableC1531m0 runnableC1531m0 = (RunnableC1531m0) runnable;
                    abstractFuture = runnableC1531m0.f22736a;
                    if (abstractFuture.f15255a == runnableC1531m0) {
                        if (f15253f.mo5807j(abstractFuture, runnableC1531m0, m4308f(runnableC1531m0.f22737b))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    Executor executor = c1374k03.f20703b;
                    Objects.requireNonNull(executor);
                    m4306d(runnable, executor);
                }
                c1374k03 = c1374k0;
            }
            return;
        }
    }

    /* renamed from: d */
    public static void m4306d(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e) {
            Level level = Level.SEVERE;
            String valueOf = String.valueOf(runnable);
            String valueOf2 = String.valueOf(executor);
            f15252e.log(level, AbstractC1726qj.m7055k(valueOf2.length() + valueOf.length() + 57, "RuntimeException while executing runnable ", valueOf, " with executor ", valueOf2), (Throwable) e);
        }
    }

    /* renamed from: e */
    public static Object m4307e(Object obj) {
        if (!(obj instanceof C1252h0)) {
            if (!(obj instanceof C1337j0)) {
                if (obj == f15254g) {
                    return null;
                }
                return obj;
            }
            throw new ExecutionException(((C1337j0) obj).f20326a);
        }
        RuntimeException runtimeException = ((C1252h0) obj).f17900b;
        CancellationException cancellationException = new CancellationException("Task was cancelled.");
        cancellationException.initCause(runtimeException);
        throw cancellationException;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: f */
    public static Object m4308f(ListenableFuture listenableFuture) {
        Throwable tryInternalFastPathGetFailure;
        if (listenableFuture instanceof InterfaceC1605o0) {
            Object obj = ((AbstractFuture) listenableFuture).f15255a;
            if (obj instanceof C1252h0) {
                C1252h0 c1252h0 = (C1252h0) obj;
                if (c1252h0.f17899a) {
                    obj = c1252h0.f17900b != null ? new C1252h0(false, c1252h0.f17900b) : C1252h0.f17898d;
                }
            }
            Objects.requireNonNull(obj);
            return obj;
        }
        if ((listenableFuture instanceof InternalFutureFailureAccess) && (tryInternalFastPathGetFailure = InternalFutures.tryInternalFastPathGetFailure((InternalFutureFailureAccess) listenableFuture)) != null) {
            return new C1337j0(tryInternalFastPathGetFailure);
        }
        boolean isCancelled = listenableFuture.isCancelled();
        if ((!f15251d) & isCancelled) {
            C1252h0 c1252h02 = C1252h0.f17898d;
            Objects.requireNonNull(c1252h02);
            return c1252h02;
        }
        try {
            Object m4309g = m4309g(listenableFuture);
            if (isCancelled) {
                String valueOf = String.valueOf(listenableFuture);
                StringBuilder sb = new StringBuilder(valueOf.length() + 84);
                sb.append("get() did not throw CancellationException, despite reporting isCancelled() == true: ");
                sb.append(valueOf);
                return new C1252h0(false, new IllegalArgumentException(sb.toString()));
            }
            if (m4309g == null) {
                return f15254g;
            }
            return m4309g;
        } catch (CancellationException e) {
            if (!isCancelled) {
                String valueOf2 = String.valueOf(listenableFuture);
                return new C1337j0(new IllegalArgumentException(AbstractC1726qj.m7054j(valueOf2.length() + 77, "get() threw CancellationException, despite reporting isCancelled() == false: ", valueOf2), e));
            }
            return new C1252h0(false, e);
        } catch (ExecutionException e2) {
            if (isCancelled) {
                String valueOf3 = String.valueOf(listenableFuture);
                return new C1252h0(false, new IllegalArgumentException(AbstractC1726qj.m7054j(valueOf3.length() + 84, "get() did not throw CancellationException, despite reporting isCancelled() == true: ", valueOf3), e2));
            }
            return new C1337j0(e2.getCause());
        } catch (Throwable th) {
            return new C1337j0(th);
        }
    }

    /* renamed from: g */
    public static Object m4309g(ListenableFuture listenableFuture) {
        V v;
        boolean z = false;
        while (true) {
            try {
                v = listenableFuture.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return v;
    }

    /* renamed from: a */
    public final void m4310a(StringBuilder sb) {
        try {
            Object m4309g = m4309g(this);
            sb.append("SUCCESS, result=[");
            m4311b(m4309g, sb);
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e.getClass());
            sb.append(" thrown from get()]");
        } catch (ExecutionException e2) {
            sb.append("FAILURE, cause=[");
            sb.append(e2.getCause());
            sb.append("]");
        }
    }

    public void addListener(Runnable runnable, Executor executor) {
        C1374k0 c1374k0;
        C1374k0 c1374k02;
        Preconditions.checkNotNull(runnable, "Runnable was null.");
        Preconditions.checkNotNull(executor, "Executor was null.");
        if (!isDone() && (c1374k0 = this.f15256b) != (c1374k02 = C1374k0.f20701d)) {
            C1374k0 c1374k03 = new C1374k0(runnable, executor);
            do {
                c1374k03.f20704c = c1374k0;
                if (f15253f.mo5806i(this, c1374k0, c1374k03)) {
                    return;
                } else {
                    c1374k0 = this.f15256b;
                }
            } while (c1374k0 != c1374k02);
        }
        m4306d(runnable, executor);
    }

    @Beta
    @ForOverride
    public void afterDone() {
    }

    /* renamed from: b */
    public final void m4311b(Object obj, StringBuilder sb) {
        if (obj == null) {
            sb.append("null");
        } else {
            if (obj == this) {
                sb.append("this future");
                return;
            }
            sb.append(obj.getClass().getName());
            sb.append("@");
            sb.append(Integer.toHexString(System.identityHashCode(obj)));
        }
    }

    @CanIgnoreReturnValue
    public boolean cancel(boolean z) {
        boolean z2;
        C1252h0 c1252h0;
        boolean z3;
        Object obj = this.f15255a;
        if (obj == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!(z2 | (obj instanceof RunnableC1531m0))) {
            return false;
        }
        if (f15251d) {
            c1252h0 = new C1252h0(z, new CancellationException("Future.cancel() was called."));
        } else {
            if (z) {
                c1252h0 = C1252h0.f17897c;
            } else {
                c1252h0 = C1252h0.f17898d;
            }
            Objects.requireNonNull(c1252h0);
        }
        AbstractFuture<V> abstractFuture = this;
        boolean z4 = false;
        while (true) {
            if (f15253f.mo5807j(abstractFuture, obj, c1252h0)) {
                if (z) {
                    abstractFuture.interruptTask();
                }
                m4305c(abstractFuture);
                if (!(obj instanceof RunnableC1531m0)) {
                    return true;
                }
                ListenableFuture listenableFuture = ((RunnableC1531m0) obj).f22737b;
                if (listenableFuture instanceof InterfaceC1605o0) {
                    abstractFuture = (AbstractFuture) listenableFuture;
                    obj = abstractFuture.f15255a;
                    if (obj == null) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (!(z3 | (obj instanceof RunnableC1531m0))) {
                        return true;
                    }
                    z4 = true;
                } else {
                    listenableFuture.cancel(z);
                    return true;
                }
            } else {
                obj = abstractFuture.f15255a;
                if (!(obj instanceof RunnableC1531m0)) {
                    return z4;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00c1  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00b4 -> B:33:0x007d). Please report as a decompilation issue!!! */
    @CanIgnoreReturnValue
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public V get(long j, TimeUnit timeUnit) {
        long j2;
        long nanos = timeUnit.toNanos(j);
        if (!Thread.interrupted()) {
            Object obj = this.f15255a;
            if ((obj != null) & (!(obj instanceof RunnableC1531m0))) {
                return (V) m4307e(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
            if (nanos >= 1000) {
                C1892v0 c1892v0 = this.f15257c;
                C1892v0 c1892v02 = C1892v0.f27559c;
                if (c1892v0 != c1892v02) {
                    C1892v0 c1892v03 = new C1892v0();
                    do {
                        yy2 yy2Var = f15253f;
                        yy2Var.mo5804H(c1892v03, c1892v0);
                        if (yy2Var.mo5808k(this, c1892v0, c1892v03)) {
                            do {
                                LockSupport.parkNanos(this, Math.min(nanos, 2147483647999999999L));
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.f15255a;
                                    if ((obj2 != null) & (!(obj2 instanceof RunnableC1531m0))) {
                                        return (V) m4307e(obj2);
                                    }
                                    nanos = nanoTime - System.nanoTime();
                                } else {
                                    m4313i(c1892v03);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            m4313i(c1892v03);
                            j2 = 0;
                            if (nanos > j2) {
                                Object obj3 = this.f15255a;
                                if ((obj3 != null) & (!(obj3 instanceof RunnableC1531m0))) {
                                    return (V) m4307e(obj3);
                                }
                                if (!Thread.interrupted()) {
                                    nanos = nanoTime - System.nanoTime();
                                    j2 = 0;
                                    if (nanos > j2) {
                                    }
                                } else {
                                    throw new InterruptedException();
                                }
                            } else {
                                String abstractFuture = toString();
                                String obj4 = timeUnit.toString();
                                Locale locale = Locale.ROOT;
                                String lowerCase = obj4.toLowerCase(locale);
                                String lowerCase2 = timeUnit.toString().toLowerCase(locale);
                                StringBuilder sb = new StringBuilder(AbstractC1726qj.m7052h(28, lowerCase2));
                                sb.append("Waited ");
                                sb.append(j);
                                sb.append(" ");
                                sb.append(lowerCase2);
                                String sb2 = sb.toString();
                                if (nanos + 1000 < 0) {
                                    String concat = String.valueOf(sb2).concat(" (plus ");
                                    long j3 = -nanos;
                                    long convert = timeUnit.convert(j3, TimeUnit.NANOSECONDS);
                                    long nanos2 = j3 - timeUnit.toNanos(convert);
                                    boolean z = convert == 0 || nanos2 > 1000;
                                    if (convert > 0) {
                                        String valueOf = String.valueOf(concat);
                                        StringBuilder sb3 = new StringBuilder(AbstractC1726qj.m7052h(valueOf.length() + 21, lowerCase));
                                        sb3.append(valueOf);
                                        sb3.append(convert);
                                        sb3.append(" ");
                                        sb3.append(lowerCase);
                                        String sb4 = sb3.toString();
                                        if (z) {
                                            sb4 = String.valueOf(sb4).concat(",");
                                        }
                                        concat = String.valueOf(sb4).concat(" ");
                                    }
                                    if (z) {
                                        String valueOf2 = String.valueOf(concat);
                                        StringBuilder sb5 = new StringBuilder(valueOf2.length() + 33);
                                        sb5.append(valueOf2);
                                        sb5.append(nanos2);
                                        sb5.append(" nanoseconds ");
                                        concat = sb5.toString();
                                    }
                                    sb2 = String.valueOf(concat).concat("delay)");
                                }
                                if (isDone()) {
                                    throw new TimeoutException(String.valueOf(sb2).concat(" but future completed as timeout expired"));
                                }
                                throw new TimeoutException(AbstractC1726qj.m7059o(sb2, " for ", abstractFuture, AbstractC1726qj.m7052h(AbstractC1726qj.m7052h(5, sb2), abstractFuture)));
                            }
                        } else {
                            c1892v0 = this.f15257c;
                        }
                    } while (c1892v0 != c1892v02);
                }
                Object obj5 = this.f15255a;
                Objects.requireNonNull(obj5);
                return (V) m4307e(obj5);
            }
            j2 = 0;
            if (nanos > j2) {
            }
        } else {
            throw new InterruptedException();
        }
    }

    /* renamed from: h */
    public final void m4312h(Future future) {
        boolean z;
        if (future != null) {
            z = true;
        } else {
            z = false;
        }
        if (z & isCancelled()) {
            future.cancel(wasInterrupted());
        }
    }

    /* renamed from: i */
    public final void m4313i(C1892v0 c1892v0) {
        c1892v0.f27560a = null;
        while (true) {
            C1892v0 c1892v02 = this.f15257c;
            if (c1892v02 == C1892v0.f27559c) {
                return;
            }
            C1892v0 c1892v03 = null;
            while (c1892v02 != null) {
                C1892v0 c1892v04 = c1892v02.f27561b;
                if (c1892v02.f27560a != null) {
                    c1892v03 = c1892v02;
                } else if (c1892v03 != null) {
                    c1892v03.f27561b = c1892v04;
                    if (c1892v03.f27560a == null) {
                        break;
                    }
                } else if (!f15253f.mo5808k(this, c1892v02, c1892v04)) {
                    break;
                }
                c1892v02 = c1892v04;
            }
            return;
        }
    }

    public void interruptTask() {
    }

    public boolean isCancelled() {
        return this.f15255a instanceof C1252h0;
    }

    public boolean isDone() {
        boolean z;
        if (this.f15255a != null) {
            z = true;
        } else {
            z = false;
        }
        return (!(r0 instanceof RunnableC1531m0)) & z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @CheckForNull
    public String pendingToString() {
        if (this instanceof ScheduledFuture) {
            long delay = ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS);
            StringBuilder sb = new StringBuilder(41);
            sb.append("remaining delay=[");
            sb.append(delay);
            sb.append(" ms]");
            return sb.toString();
        }
        return null;
    }

    @CanIgnoreReturnValue
    public boolean set(V v) {
        if (v == null) {
            v = (V) f15254g;
        }
        if (f15253f.mo5807j(this, null, v)) {
            m4305c(this);
            return true;
        }
        return false;
    }

    @CanIgnoreReturnValue
    public boolean setException(Throwable th) {
        if (f15253f.mo5807j(this, null, new C1337j0((Throwable) Preconditions.checkNotNull(th)))) {
            m4305c(this);
            return true;
        }
        return false;
    }

    @CanIgnoreReturnValue
    public boolean setFuture(ListenableFuture<? extends V> listenableFuture) {
        C1337j0 c1337j0;
        Preconditions.checkNotNull(listenableFuture);
        Object obj = this.f15255a;
        if (obj == null) {
            if (listenableFuture.isDone()) {
                if (!f15253f.mo5807j(this, null, m4308f(listenableFuture))) {
                    return false;
                }
                m4305c(this);
                return true;
            }
            RunnableC1531m0 runnableC1531m0 = new RunnableC1531m0(this, listenableFuture);
            if (f15253f.mo5807j(this, null, runnableC1531m0)) {
                try {
                    listenableFuture.addListener(runnableC1531m0, e40.f16668a);
                } catch (Throwable th) {
                    try {
                        c1337j0 = new C1337j0(th);
                    } catch (Throwable unused) {
                        c1337j0 = C1337j0.f20325b;
                    }
                    f15253f.mo5807j(this, runnableC1531m0, c1337j0);
                }
                return true;
            }
            obj = this.f15255a;
        }
        if (obj instanceof C1252h0) {
            listenableFuture.cancel(((C1252h0) obj).f17899a);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String toString() {
        String m7054j;
        StringBuilder sb = new StringBuilder();
        if (getClass().getName().startsWith("com.google.common.util.concurrent.")) {
            sb.append(getClass().getSimpleName());
        } else {
            sb.append(getClass().getName());
        }
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            m4310a(sb);
        } else {
            int length = sb.length();
            sb.append("PENDING");
            Object obj = this.f15255a;
            if (obj instanceof RunnableC1531m0) {
                sb.append(", setFuture=[");
                ListenableFuture listenableFuture = ((RunnableC1531m0) obj).f22737b;
                try {
                    if (listenableFuture == this) {
                        sb.append("this future");
                    } else {
                        sb.append(listenableFuture);
                    }
                } catch (RuntimeException e) {
                    e = e;
                    sb.append("Exception thrown from implementation: ");
                    sb.append(e.getClass());
                    sb.append("]");
                    if (isDone()) {
                    }
                    sb.append("]");
                    return sb.toString();
                } catch (StackOverflowError e2) {
                    e = e2;
                    sb.append("Exception thrown from implementation: ");
                    sb.append(e.getClass());
                    sb.append("]");
                    if (isDone()) {
                    }
                    sb.append("]");
                    return sb.toString();
                }
                sb.append("]");
            } else {
                try {
                    m7054j = Strings.emptyToNull(pendingToString());
                } catch (RuntimeException | StackOverflowError e3) {
                    String valueOf = String.valueOf(e3.getClass());
                    m7054j = AbstractC1726qj.m7054j(valueOf.length() + 38, "Exception thrown from implementation: ", valueOf);
                }
                if (m7054j != null) {
                    sb.append(", info=[");
                    sb.append(m7054j);
                    sb.append("]");
                }
            }
            if (isDone()) {
                sb.delete(length, sb.length());
                m4310a(sb);
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // com.google.common.util.concurrent.internal.InternalFutureFailureAccess
    @CheckForNull
    public final Throwable tryInternalFastPathGetFailure() {
        if (this instanceof InterfaceC1605o0) {
            Object obj = this.f15255a;
            if (obj instanceof C1337j0) {
                return ((C1337j0) obj).f20326a;
            }
            return null;
        }
        return null;
    }

    public final boolean wasInterrupted() {
        Object obj = this.f15255a;
        if ((obj instanceof C1252h0) && ((C1252h0) obj).f17899a) {
            return true;
        }
        return false;
    }

    @CanIgnoreReturnValue
    public V get() {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.f15255a;
            if ((obj2 != null) & (!(obj2 instanceof RunnableC1531m0))) {
                return (V) m4307e(obj2);
            }
            C1892v0 c1892v0 = this.f15257c;
            C1892v0 c1892v02 = C1892v0.f27559c;
            if (c1892v0 != c1892v02) {
                C1892v0 c1892v03 = new C1892v0();
                do {
                    yy2 yy2Var = f15253f;
                    yy2Var.mo5804H(c1892v03, c1892v0);
                    if (yy2Var.mo5808k(this, c1892v0, c1892v03)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f15255a;
                            } else {
                                m4313i(c1892v03);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof RunnableC1531m0))));
                        return (V) m4307e(obj);
                    }
                    c1892v0 = this.f15257c;
                } while (c1892v0 != c1892v02);
            }
            Object obj3 = this.f15255a;
            Objects.requireNonNull(obj3);
            return (V) m4307e(obj3);
        }
        throw new InterruptedException();
    }
}
