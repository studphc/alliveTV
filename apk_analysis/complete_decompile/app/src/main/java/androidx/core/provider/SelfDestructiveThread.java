package androidx.core.provider;

import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import p000.o63;
import p000.xk1;
import p000.yw0;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
@Deprecated
/* loaded from: classes.dex */
public class SelfDestructiveThread {

    /* renamed from: b */
    public HandlerThread f3733b;

    /* renamed from: c */
    public Handler f3734c;

    /* renamed from: f */
    public final int f3737f;

    /* renamed from: g */
    public final int f3738g;

    /* renamed from: h */
    public final String f3739h;

    /* renamed from: a */
    public final Object f3732a = new Object();

    /* renamed from: e */
    public final yw0 f3736e = new yw0(1, this);

    /* renamed from: d */
    public int f3735d = 0;

    /* loaded from: classes.dex */
    public interface ReplyCallback<T> {
        void onReply(T t);
    }

    public SelfDestructiveThread(String str, int i, int i2) {
        this.f3739h = str;
        this.f3738g = i;
        this.f3737f = i2;
    }

    /* renamed from: a */
    public final void m879a() {
        synchronized (this.f3732a) {
            try {
                if (this.f3734c.hasMessages(1)) {
                    return;
                }
                this.f3733b.quit();
                this.f3733b = null;
                this.f3734c = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: b */
    public final void m880b(Runnable runnable) {
        synchronized (this.f3732a) {
            try {
                if (this.f3733b == null) {
                    HandlerThread handlerThread = new HandlerThread(this.f3739h, this.f3738g);
                    this.f3733b = handlerThread;
                    handlerThread.start();
                    this.f3734c = new Handler(this.f3733b.getLooper(), this.f3736e);
                    this.f3735d++;
                }
                this.f3734c.removeMessages(0);
                Handler handler = this.f3734c;
                handler.sendMessage(handler.obtainMessage(1, runnable));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @VisibleForTesting
    public int getGeneration() {
        int i;
        synchronized (this.f3732a) {
            i = this.f3735d;
        }
        return i;
    }

    @VisibleForTesting
    public boolean isRunning() {
        boolean z;
        synchronized (this.f3732a) {
            if (this.f3733b != null) {
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public <T> void postAndReply(Callable<T> callable, ReplyCallback<T> replyCallback) {
        m880b(new RunnableC0195j(callable, o63.m6466i(), replyCallback));
    }

    public <T> T postAndWait(Callable<T> callable, int i) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition newCondition = reentrantLock.newCondition();
        AtomicReference atomicReference = new AtomicReference();
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        m880b(new xk1(atomicReference, callable, reentrantLock, atomicBoolean, newCondition));
        reentrantLock.lock();
        try {
            if (!atomicBoolean.get()) {
                return (T) atomicReference.get();
            }
            long nanos = TimeUnit.MILLISECONDS.toNanos(i);
            do {
                try {
                    nanos = newCondition.awaitNanos(nanos);
                } catch (InterruptedException unused) {
                }
                if (!atomicBoolean.get()) {
                    return (T) atomicReference.get();
                }
            } while (nanos > 0);
            throw new InterruptedException("timeout");
        } finally {
            reentrantLock.unlock();
        }
    }
}
