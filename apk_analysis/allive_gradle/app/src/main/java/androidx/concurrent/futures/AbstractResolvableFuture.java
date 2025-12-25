package androidx.concurrent.futures;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import p000.AbstractC1726qj;
import p000.C1709q2;
import p000.C1746r2;
import p000.C1783s2;
import p000.C1820t2;
import p000.C1931w2;
import p000.RunnableC1857u2;
import p000.o63;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public abstract class AbstractResolvableFuture<V> implements ListenableFuture<V> {

    /* renamed from: d */
    public static final boolean f1804d = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* renamed from: e */
    public static final Logger f1805e = Logger.getLogger(AbstractResolvableFuture.class.getName());

    /* renamed from: f */
    public static final o63 f1806f;

    /* renamed from: g */
    public static final Object f1807g;

    /* renamed from: a */
    public volatile Object f1808a;

    /* renamed from: b */
    public volatile C1783s2 f1809b;

    /* renamed from: c */
    public volatile C1931w2 f1810c;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [o63] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    static {
        ?? r4;
        try {
            th = null;
            r4 = new C1820t2(AtomicReferenceFieldUpdater.newUpdater(C1931w2.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(C1931w2.class, C1931w2.class, "b"), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, C1931w2.class, "c"), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, C1783s2.class, "b"), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, Object.class, "a"));
        } catch (Throwable th) {
            th = th;
            r4 = new Object();
        }
        f1806f = r4;
        if (th != null) {
            f1805e.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        f1807g = new Object();
    }

    /* renamed from: b */
    public static void m416b(AbstractResolvableFuture abstractResolvableFuture) {
        C1783s2 c1783s2;
        C1783s2 c1783s22;
        C1783s2 c1783s23 = null;
        while (true) {
            C1931w2 c1931w2 = abstractResolvableFuture.f1810c;
            if (f1806f.mo6482f(abstractResolvableFuture, c1931w2, C1931w2.f28044c)) {
                while (c1931w2 != null) {
                    Thread thread = c1931w2.f28045a;
                    if (thread != null) {
                        c1931w2.f28045a = null;
                        LockSupport.unpark(thread);
                    }
                    c1931w2 = c1931w2.f28046b;
                }
                abstractResolvableFuture.afterDone();
                do {
                    c1783s2 = abstractResolvableFuture.f1809b;
                } while (!f1806f.mo6480d(abstractResolvableFuture, c1783s2, C1783s2.f26205d));
                while (true) {
                    c1783s22 = c1783s23;
                    c1783s23 = c1783s2;
                    if (c1783s23 == null) {
                        break;
                    }
                    c1783s2 = c1783s23.f26208c;
                    c1783s23.f26208c = c1783s22;
                }
                while (c1783s22 != null) {
                    c1783s23 = c1783s22.f26208c;
                    Runnable runnable = c1783s22.f26206a;
                    if (runnable instanceof RunnableC1857u2) {
                        RunnableC1857u2 runnableC1857u2 = (RunnableC1857u2) runnable;
                        abstractResolvableFuture = runnableC1857u2.f27070a;
                        if (abstractResolvableFuture.f1808a == runnableC1857u2) {
                            if (f1806f.mo6481e(abstractResolvableFuture, runnableC1857u2, m419e(runnableC1857u2.f27071b))) {
                                break;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        m417c(runnable, c1783s22.f26207b);
                    }
                    c1783s22 = c1783s23;
                }
                return;
            }
        }
    }

    /* renamed from: c */
    public static void m417c(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e) {
            f1805e.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e);
        }
    }

    /* renamed from: d */
    public static Object m418d(Object obj) {
        if (!(obj instanceof C1709q2)) {
            if (!(obj instanceof C1746r2)) {
                if (obj == f1807g) {
                    return null;
                }
                return obj;
            }
            throw new ExecutionException(((C1746r2) obj).f25837a);
        }
        CancellationException cancellationException = ((C1709q2) obj).f25412b;
        CancellationException cancellationException2 = new CancellationException("Task was cancelled.");
        cancellationException2.initCause(cancellationException);
        throw cancellationException2;
    }

    /* renamed from: e */
    public static Object m419e(ListenableFuture listenableFuture) {
        if (listenableFuture instanceof AbstractResolvableFuture) {
            Object obj = ((AbstractResolvableFuture) listenableFuture).f1808a;
            if (obj instanceof C1709q2) {
                C1709q2 c1709q2 = (C1709q2) obj;
                if (c1709q2.f25411a) {
                    if (c1709q2.f25412b != null) {
                        return new C1709q2(false, c1709q2.f25412b);
                    }
                    return C1709q2.f25410d;
                }
                return obj;
            }
            return obj;
        }
        boolean isCancelled = listenableFuture.isCancelled();
        if ((!f1804d) & isCancelled) {
            return C1709q2.f25410d;
        }
        try {
            Object m420f = m420f(listenableFuture);
            if (m420f == null) {
                return f1807g;
            }
            return m420f;
        } catch (CancellationException e) {
            if (!isCancelled) {
                return new C1746r2(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + listenableFuture, e));
            }
            return new C1709q2(false, e);
        } catch (ExecutionException e2) {
            return new C1746r2(e2.getCause());
        } catch (Throwable th) {
            return new C1746r2(th);
        }
    }

    /* renamed from: f */
    public static Object m420f(ListenableFuture listenableFuture) {
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
    public final void m421a(StringBuilder sb) {
        String valueOf;
        try {
            Object m420f = m420f(this);
            sb.append("SUCCESS, result=[");
            if (m420f == this) {
                valueOf = "this future";
            } else {
                valueOf = String.valueOf(m420f);
            }
            sb.append(valueOf);
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

    @Override // com.google.common.util.concurrent.ListenableFuture
    public final void addListener(Runnable runnable, Executor executor) {
        runnable.getClass();
        executor.getClass();
        C1783s2 c1783s2 = this.f1809b;
        C1783s2 c1783s22 = C1783s2.f26205d;
        if (c1783s2 != c1783s22) {
            C1783s2 c1783s23 = new C1783s2(runnable, executor);
            do {
                c1783s23.f26208c = c1783s2;
                if (f1806f.mo6480d(this, c1783s2, c1783s23)) {
                    return;
                } else {
                    c1783s2 = this.f1809b;
                }
            } while (c1783s2 != c1783s22);
        }
        m417c(runnable, executor);
    }

    public void afterDone() {
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        boolean z2;
        C1709q2 c1709q2;
        boolean z3;
        Object obj = this.f1808a;
        if (obj == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!(z2 | (obj instanceof RunnableC1857u2))) {
            return false;
        }
        if (f1804d) {
            c1709q2 = new C1709q2(z, new CancellationException("Future.cancel() was called."));
        } else if (z) {
            c1709q2 = C1709q2.f25409c;
        } else {
            c1709q2 = C1709q2.f25410d;
        }
        AbstractResolvableFuture<V> abstractResolvableFuture = this;
        boolean z4 = false;
        while (true) {
            if (f1806f.mo6481e(abstractResolvableFuture, obj, c1709q2)) {
                if (z) {
                    abstractResolvableFuture.interruptTask();
                }
                m416b(abstractResolvableFuture);
                if (!(obj instanceof RunnableC1857u2)) {
                    return true;
                }
                ListenableFuture listenableFuture = ((RunnableC1857u2) obj).f27071b;
                if (listenableFuture instanceof AbstractResolvableFuture) {
                    abstractResolvableFuture = (AbstractResolvableFuture) listenableFuture;
                    obj = abstractResolvableFuture.f1808a;
                    if (obj == null) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (!(z3 | (obj instanceof RunnableC1857u2))) {
                        return true;
                    }
                    z4 = true;
                } else {
                    listenableFuture.cancel(z);
                    return true;
                }
            } else {
                obj = abstractResolvableFuture.f1808a;
                if (!(obj instanceof RunnableC1857u2)) {
                    return z4;
                }
            }
        }
    }

    /* renamed from: g */
    public final void m422g(C1931w2 c1931w2) {
        c1931w2.f28045a = null;
        while (true) {
            C1931w2 c1931w22 = this.f1810c;
            if (c1931w22 == C1931w2.f28044c) {
                return;
            }
            C1931w2 c1931w23 = null;
            while (c1931w22 != null) {
                C1931w2 c1931w24 = c1931w22.f28046b;
                if (c1931w22.f28045a != null) {
                    c1931w23 = c1931w22;
                } else if (c1931w23 != null) {
                    c1931w23.f28046b = c1931w24;
                    if (c1931w23.f28045a == null) {
                        break;
                    }
                } else if (!f1806f.mo6482f(this, c1931w22, c1931w24)) {
                    break;
                }
                c1931w22 = c1931w24;
            }
            return;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00b5  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00a8 -> B:33:0x0074). Please report as a decompilation issue!!! */
    @Override // java.util.concurrent.Future
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final V get(long j, TimeUnit timeUnit) {
        long j2;
        long nanos = timeUnit.toNanos(j);
        if (!Thread.interrupted()) {
            Object obj = this.f1808a;
            if ((obj != null) & (!(obj instanceof RunnableC1857u2))) {
                return (V) m418d(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
            if (nanos >= 1000) {
                C1931w2 c1931w2 = this.f1810c;
                C1931w2 c1931w22 = C1931w2.f28044c;
                if (c1931w2 != c1931w22) {
                    C1931w2 c1931w23 = new C1931w2();
                    do {
                        o63 o63Var = f1806f;
                        o63Var.mo6483y(c1931w23, c1931w2);
                        if (o63Var.mo6482f(this, c1931w2, c1931w23)) {
                            do {
                                LockSupport.parkNanos(this, nanos);
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.f1808a;
                                    if ((obj2 != null) & (!(obj2 instanceof RunnableC1857u2))) {
                                        return (V) m418d(obj2);
                                    }
                                    nanos = nanoTime - System.nanoTime();
                                } else {
                                    m422g(c1931w23);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            m422g(c1931w23);
                            j2 = 0;
                            if (nanos > j2) {
                                Object obj3 = this.f1808a;
                                if ((obj3 != null) & (!(obj3 instanceof RunnableC1857u2))) {
                                    return (V) m418d(obj3);
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
                                String abstractResolvableFuture = toString();
                                String obj4 = timeUnit.toString();
                                Locale locale = Locale.ROOT;
                                String lowerCase = obj4.toLowerCase(locale);
                                String str = "Waited " + j + " " + timeUnit.toString().toLowerCase(locale);
                                if (nanos + 1000 < 0) {
                                    String m7057m = AbstractC1726qj.m7057m(str, " (plus ");
                                    long j3 = -nanos;
                                    long convert = timeUnit.convert(j3, TimeUnit.NANOSECONDS);
                                    long nanos2 = j3 - timeUnit.toNanos(convert);
                                    boolean z = convert == 0 || nanos2 > 1000;
                                    if (convert > 0) {
                                        String str2 = m7057m + convert + " " + lowerCase;
                                        if (z) {
                                            str2 = AbstractC1726qj.m7057m(str2, ",");
                                        }
                                        m7057m = AbstractC1726qj.m7057m(str2, " ");
                                    }
                                    if (z) {
                                        m7057m = m7057m + nanos2 + " nanoseconds ";
                                    }
                                    str = AbstractC1726qj.m7057m(m7057m, "delay)");
                                }
                                if (isDone()) {
                                    throw new TimeoutException(AbstractC1726qj.m7057m(str, " but future completed as timeout expired"));
                                }
                                throw new TimeoutException(AbstractC1726qj.m7058n(str, " for ", abstractResolvableFuture));
                            }
                        } else {
                            c1931w2 = this.f1810c;
                        }
                    } while (c1931w2 != c1931w22);
                }
                return (V) m418d(this.f1808a);
            }
            j2 = 0;
            if (nanos > j2) {
            }
        } else {
            throw new InterruptedException();
        }
    }

    public void interruptTask() {
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f1808a instanceof C1709q2;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        boolean z;
        if (this.f1808a != null) {
            z = true;
        } else {
            z = false;
        }
        return (!(r0 instanceof RunnableC1857u2)) & z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public String pendingToString() {
        String valueOf;
        Object obj = this.f1808a;
        if (obj instanceof RunnableC1857u2) {
            StringBuilder sb = new StringBuilder("setFuture=[");
            ListenableFuture listenableFuture = ((RunnableC1857u2) obj).f27071b;
            if (listenableFuture == this) {
                valueOf = "this future";
            } else {
                valueOf = String.valueOf(listenableFuture);
            }
            return AbstractC1726qj.m7061q(sb, valueOf, "]");
        }
        if (this instanceof ScheduledFuture) {
            return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
        }
        return null;
    }

    public boolean set(@Nullable V v) {
        if (v == null) {
            v = (V) f1807g;
        }
        if (f1806f.mo6481e(this, null, v)) {
            m416b(this);
            return true;
        }
        return false;
    }

    public boolean setException(Throwable th) {
        th.getClass();
        if (f1806f.mo6481e(this, null, new C1746r2(th))) {
            m416b(this);
            return true;
        }
        return false;
    }

    public boolean setFuture(ListenableFuture<? extends V> listenableFuture) {
        C1746r2 c1746r2;
        listenableFuture.getClass();
        Object obj = this.f1808a;
        if (obj == null) {
            if (listenableFuture.isDone()) {
                if (!f1806f.mo6481e(this, null, m419e(listenableFuture))) {
                    return false;
                }
                m416b(this);
                return true;
            }
            RunnableC1857u2 runnableC1857u2 = new RunnableC1857u2(this, listenableFuture);
            if (f1806f.mo6481e(this, null, runnableC1857u2)) {
                try {
                    listenableFuture.addListener(runnableC1857u2, DirectExecutor.INSTANCE);
                } catch (Throwable th) {
                    try {
                        c1746r2 = new C1746r2(th);
                    } catch (Throwable unused) {
                        c1746r2 = C1746r2.f25836b;
                    }
                    f1806f.mo6481e(this, runnableC1857u2, c1746r2);
                }
                return true;
            }
            obj = this.f1808a;
        }
        if (obj instanceof C1709q2) {
            listenableFuture.cancel(((C1709q2) obj).f25411a);
        }
        return false;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            m421a(sb);
        } else {
            try {
                str = pendingToString();
            } catch (RuntimeException e) {
                str = "Exception thrown from implementation: " + e.getClass();
            }
            if (str != null && !str.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(str);
                sb.append("]");
            } else if (isDone()) {
                m421a(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public final boolean wasInterrupted() {
        Object obj = this.f1808a;
        if ((obj instanceof C1709q2) && ((C1709q2) obj).f25411a) {
            return true;
        }
        return false;
    }

    @Override // java.util.concurrent.Future
    public final V get() {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.f1808a;
            if ((obj2 != null) & (!(obj2 instanceof RunnableC1857u2))) {
                return (V) m418d(obj2);
            }
            C1931w2 c1931w2 = this.f1810c;
            C1931w2 c1931w22 = C1931w2.f28044c;
            if (c1931w2 != c1931w22) {
                C1931w2 c1931w23 = new C1931w2();
                do {
                    o63 o63Var = f1806f;
                    o63Var.mo6483y(c1931w23, c1931w2);
                    if (o63Var.mo6482f(this, c1931w2, c1931w23)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f1808a;
                            } else {
                                m422g(c1931w23);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof RunnableC1857u2))));
                        return (V) m418d(obj);
                    }
                    c1931w2 = this.f1810c;
                } while (c1931w2 != c1931w22);
            }
            return (V) m418d(this.f1808a);
        }
        throw new InterruptedException();
    }
}
