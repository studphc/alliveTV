package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Longs;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@GwtIncompatible
/* loaded from: classes2.dex */
public final class Monitor {

    /* renamed from: a */
    public final boolean f15325a;

    /* renamed from: b */
    public final ReentrantLock f15326b;

    /* renamed from: c */
    public Guard f15327c;

    /* loaded from: classes2.dex */
    public static abstract class Guard {

        /* renamed from: a */
        public final Monitor f15328a;

        /* renamed from: b */
        public final Condition f15329b;

        /* renamed from: c */
        public int f15330c = 0;

        /* renamed from: d */
        public Guard f15331d;

        public Guard(Monitor monitor) {
            this.f15328a = (Monitor) Preconditions.checkNotNull(monitor, "monitor");
            this.f15329b = monitor.f15326b.newCondition();
        }

        public abstract boolean isSatisfied();
    }

    public Monitor() {
        this(false);
    }

    /* renamed from: f */
    public static long m4327f(long j) {
        if (j <= 0) {
            return 0L;
        }
        long nanoTime = System.nanoTime();
        if (nanoTime == 0) {
            return 1L;
        }
        return nanoTime;
    }

    /* renamed from: g */
    public static long m4328g(long j, long j2) {
        if (j2 <= 0) {
            return 0L;
        }
        return j2 - (System.nanoTime() - j);
    }

    /* renamed from: i */
    public static long m4329i(long j, TimeUnit timeUnit) {
        return Longs.constrainToRange(timeUnit.toNanos(j), 0L, 6917529027641081853L);
    }

    /* renamed from: a */
    public final void m4330a(Guard guard, boolean z) {
        if (z) {
            m4335h();
        }
        m4333d(guard);
        do {
            try {
                guard.f15329b.await();
            } finally {
                m4334e(guard);
            }
        } while (!guard.isSatisfied());
    }

    /* renamed from: b */
    public final boolean m4331b(Guard guard, long j, boolean z) {
        boolean z2 = true;
        while (j > 0) {
            if (z2) {
                if (z) {
                    try {
                        m4335h();
                    } catch (Throwable th) {
                        if (!z2) {
                            m4334e(guard);
                        }
                        throw th;
                    }
                }
                m4333d(guard);
                z2 = false;
            }
            j = guard.f15329b.awaitNanos(j);
            if (guard.isSatisfied()) {
                if (!z2) {
                    m4334e(guard);
                }
                return true;
            }
        }
        if (!z2) {
            m4334e(guard);
        }
        return false;
    }

    /* renamed from: c */
    public final void m4332c(Guard guard, boolean z) {
        if (z) {
            m4335h();
        }
        m4333d(guard);
        do {
            try {
                guard.f15329b.awaitUninterruptibly();
            } finally {
                m4334e(guard);
            }
        } while (!guard.isSatisfied());
    }

    /* renamed from: d */
    public final void m4333d(Guard guard) {
        int i = guard.f15330c;
        guard.f15330c = i + 1;
        if (i == 0) {
            guard.f15331d = this.f15327c;
            this.f15327c = guard;
        }
    }

    /* renamed from: e */
    public final void m4334e(Guard guard) {
        int i = guard.f15330c - 1;
        guard.f15330c = i;
        if (i == 0) {
            Guard guard2 = this.f15327c;
            Guard guard3 = null;
            while (guard2 != guard) {
                guard3 = guard2;
                guard2 = guard2.f15331d;
            }
            if (guard3 == null) {
                this.f15327c = guard2.f15331d;
            } else {
                guard3.f15331d = guard2.f15331d;
            }
            guard2.f15331d = null;
        }
    }

    public void enter() {
        this.f15326b.lock();
    }

    public boolean enterIf(Guard guard) {
        if (guard.f15328a == this) {
            ReentrantLock reentrantLock = this.f15326b;
            reentrantLock.lock();
            try {
                boolean isSatisfied = guard.isSatisfied();
                if (!isSatisfied) {
                }
                return isSatisfied;
            } finally {
                reentrantLock.unlock();
            }
        }
        throw new IllegalMonitorStateException();
    }

    public boolean enterIfInterruptibly(Guard guard) {
        if (guard.f15328a == this) {
            ReentrantLock reentrantLock = this.f15326b;
            reentrantLock.lockInterruptibly();
            try {
                boolean isSatisfied = guard.isSatisfied();
                if (!isSatisfied) {
                }
                return isSatisfied;
            } finally {
                reentrantLock.unlock();
            }
        }
        throw new IllegalMonitorStateException();
    }

    public void enterInterruptibly() {
        this.f15326b.lockInterruptibly();
    }

    public void enterWhen(Guard guard) {
        if (guard.f15328a == this) {
            ReentrantLock reentrantLock = this.f15326b;
            boolean isHeldByCurrentThread = reentrantLock.isHeldByCurrentThread();
            reentrantLock.lockInterruptibly();
            try {
                if (guard.isSatisfied()) {
                    return;
                }
                m4330a(guard, isHeldByCurrentThread);
                return;
            } catch (Throwable th) {
                leave();
                throw th;
            }
        }
        throw new IllegalMonitorStateException();
    }

    public void enterWhenUninterruptibly(Guard guard) {
        if (guard.f15328a == this) {
            ReentrantLock reentrantLock = this.f15326b;
            boolean isHeldByCurrentThread = reentrantLock.isHeldByCurrentThread();
            reentrantLock.lock();
            try {
                if (guard.isSatisfied()) {
                    return;
                }
                m4332c(guard, isHeldByCurrentThread);
                return;
            } catch (Throwable th) {
                leave();
                throw th;
            }
        }
        throw new IllegalMonitorStateException();
    }

    public int getOccupiedDepth() {
        return this.f15326b.getHoldCount();
    }

    public int getQueueLength() {
        return this.f15326b.getQueueLength();
    }

    public int getWaitQueueLength(Guard guard) {
        if (guard.f15328a == this) {
            ReentrantLock reentrantLock = this.f15326b;
            reentrantLock.lock();
            try {
                return guard.f15330c;
            } finally {
                reentrantLock.unlock();
            }
        }
        throw new IllegalMonitorStateException();
    }

    /* renamed from: h */
    public final void m4335h() {
        for (Guard guard = this.f15327c; guard != null; guard = guard.f15331d) {
            try {
                if (guard.isSatisfied()) {
                    guard.f15329b.signal();
                    return;
                }
            } catch (Throwable th) {
                for (Guard guard2 = this.f15327c; guard2 != null; guard2 = guard2.f15331d) {
                    guard2.f15329b.signalAll();
                }
                throw th;
            }
        }
    }

    public boolean hasQueuedThread(Thread thread) {
        return this.f15326b.hasQueuedThread(thread);
    }

    public boolean hasQueuedThreads() {
        return this.f15326b.hasQueuedThreads();
    }

    public boolean hasWaiters(Guard guard) {
        if (getWaitQueueLength(guard) > 0) {
            return true;
        }
        return false;
    }

    public boolean isFair() {
        return this.f15325a;
    }

    public boolean isOccupied() {
        return this.f15326b.isLocked();
    }

    public boolean isOccupiedByCurrentThread() {
        return this.f15326b.isHeldByCurrentThread();
    }

    public void leave() {
        ReentrantLock reentrantLock = this.f15326b;
        try {
            if (reentrantLock.getHoldCount() == 1) {
                m4335h();
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean tryEnter() {
        return this.f15326b.tryLock();
    }

    public boolean tryEnterIf(Guard guard) {
        if (guard.f15328a == this) {
            ReentrantLock reentrantLock = this.f15326b;
            if (!reentrantLock.tryLock()) {
                return false;
            }
            try {
                boolean isSatisfied = guard.isSatisfied();
                if (!isSatisfied) {
                }
                return isSatisfied;
            } finally {
                reentrantLock.unlock();
            }
        }
        throw new IllegalMonitorStateException();
    }

    public void waitFor(Guard guard) {
        if (guard.f15328a == this && this.f15326b.isHeldByCurrentThread()) {
            if (guard.isSatisfied()) {
                return;
            }
            m4330a(guard, true);
            return;
        }
        throw new IllegalMonitorStateException();
    }

    public void waitForUninterruptibly(Guard guard) {
        if (guard.f15328a == this && this.f15326b.isHeldByCurrentThread()) {
            if (guard.isSatisfied()) {
                return;
            }
            m4332c(guard, true);
            return;
        }
        throw new IllegalMonitorStateException();
    }

    public Monitor(boolean z) {
        this.f15327c = null;
        this.f15325a = z;
        this.f15326b = new ReentrantLock(z);
    }

    public boolean enter(long j, TimeUnit timeUnit) {
        boolean tryLock;
        long m4329i = m4329i(j, timeUnit);
        ReentrantLock reentrantLock = this.f15326b;
        boolean z = true;
        if (!this.f15325a && reentrantLock.tryLock()) {
            return true;
        }
        boolean interrupted = Thread.interrupted();
        try {
            long nanoTime = System.nanoTime();
            long j2 = m4329i;
            while (true) {
                try {
                    try {
                        tryLock = reentrantLock.tryLock(j2, TimeUnit.NANOSECONDS);
                        break;
                    } catch (Throwable th) {
                        th = th;
                        if (z) {
                            Thread.currentThread().interrupt();
                        }
                        throw th;
                    }
                } catch (InterruptedException unused) {
                    j2 = m4328g(nanoTime, m4329i);
                    interrupted = true;
                }
            }
            if (interrupted) {
                Thread.currentThread().interrupt();
            }
            return tryLock;
        } catch (Throwable th2) {
            th = th2;
            z = interrupted;
        }
    }

    public boolean enterInterruptibly(long j, TimeUnit timeUnit) {
        return this.f15326b.tryLock(j, timeUnit);
    }

    public boolean waitFor(Guard guard, long j, TimeUnit timeUnit) {
        long m4329i = m4329i(j, timeUnit);
        if (guard.f15328a == this && this.f15326b.isHeldByCurrentThread()) {
            if (guard.isSatisfied()) {
                return true;
            }
            if (!Thread.interrupted()) {
                return m4331b(guard, m4329i, true);
            }
            throw new InterruptedException();
        }
        throw new IllegalMonitorStateException();
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean waitForUninterruptibly(Guard guard, long j, TimeUnit timeUnit) {
        long m4329i = m4329i(j, timeUnit);
        if (guard.f15328a == this && this.f15326b.isHeldByCurrentThread()) {
            boolean z = true;
            if (guard.isSatisfied()) {
                return true;
            }
            long m4327f = m4327f(m4329i);
            boolean interrupted = Thread.interrupted();
            long j2 = m4329i;
            boolean z2 = true;
            while (true) {
                try {
                    try {
                        boolean m4331b = m4331b(guard, j2, z2);
                        if (interrupted) {
                            Thread.currentThread().interrupt();
                        }
                        return m4331b;
                    } catch (Throwable th) {
                        th = th;
                        if (z) {
                            Thread.currentThread().interrupt();
                        }
                        throw th;
                    }
                } catch (InterruptedException unused) {
                    if (guard.isSatisfied()) {
                        Thread.currentThread().interrupt();
                        return true;
                    }
                    j2 = m4328g(m4327f, m4329i);
                    z2 = false;
                    interrupted = true;
                } catch (Throwable th2) {
                    th = th2;
                    z = interrupted;
                    if (z) {
                    }
                    throw th;
                }
            }
        } else {
            throw new IllegalMonitorStateException();
        }
    }

    public boolean enterIf(Guard guard, long j, TimeUnit timeUnit) {
        ReentrantLock reentrantLock = this.f15326b;
        if (guard.f15328a == this) {
            if (!enter(j, timeUnit)) {
                return false;
            }
            try {
                boolean isSatisfied = guard.isSatisfied();
                if (!isSatisfied) {
                }
                return isSatisfied;
            } finally {
                reentrantLock.unlock();
            }
        }
        throw new IllegalMonitorStateException();
    }

    public boolean enterIfInterruptibly(Guard guard, long j, TimeUnit timeUnit) {
        if (guard.f15328a == this) {
            ReentrantLock reentrantLock = this.f15326b;
            if (!reentrantLock.tryLock(j, timeUnit)) {
                return false;
            }
            try {
                boolean isSatisfied = guard.isSatisfied();
                if (!isSatisfied) {
                }
                return isSatisfied;
            } finally {
                reentrantLock.unlock();
            }
        }
        throw new IllegalMonitorStateException();
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0047, code lost:
    
        if (m4331b(r11, r0, r3) != false) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004f A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean enterWhen(Guard guard, long j, TimeUnit timeUnit) {
        long m4327f;
        long m4329i = m4329i(j, timeUnit);
        if (guard.f15328a == this) {
            ReentrantLock reentrantLock = this.f15326b;
            boolean isHeldByCurrentThread = reentrantLock.isHeldByCurrentThread();
            boolean z = false;
            try {
                if (!this.f15325a) {
                    if (!Thread.interrupted()) {
                        if (reentrantLock.tryLock()) {
                            m4327f = 0;
                            if (!guard.isSatisfied()) {
                                if (m4327f != 0) {
                                    m4329i = m4328g(m4327f, m4329i);
                                }
                            }
                            z = true;
                            if (!z) {
                            }
                            return z;
                        }
                    } else {
                        throw new InterruptedException();
                    }
                }
                if (!guard.isSatisfied()) {
                }
                z = true;
                if (!z) {
                }
                return z;
            } catch (Throwable th) {
                if (!isHeldByCurrentThread) {
                    try {
                        m4335h();
                    } finally {
                        reentrantLock.unlock();
                    }
                }
                throw th;
            }
            m4327f = m4327f(m4329i);
            if (!reentrantLock.tryLock(j, timeUnit)) {
                return false;
            }
        } else {
            throw new IllegalMonitorStateException();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004f A[Catch: all -> 0x0023, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x0023, blocks: (B:5:0x0012, B:7:0x001a, B:22:0x004f, B:33:0x005c, B:34:0x005f, B:35:0x0025, B:38:0x002a, B:13:0x0032, B:17:0x003d, B:18:0x0049, B:27:0x0045), top: B:4:0x0012, inners: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean enterWhenUninterruptibly(Guard guard, long j, TimeUnit timeUnit) {
        long m4327f;
        long m4328g;
        long m4329i = m4329i(j, timeUnit);
        if (guard.f15328a == this) {
            ReentrantLock reentrantLock = this.f15326b;
            boolean isHeldByCurrentThread = reentrantLock.isHeldByCurrentThread();
            boolean interrupted = Thread.interrupted();
            try {
                boolean z = true;
                if (!this.f15325a && reentrantLock.tryLock()) {
                    m4327f = 0;
                    while (!guard.isSatisfied()) {
                        try {
                            if (m4327f == 0) {
                                m4327f = m4327f(m4329i);
                                m4328g = m4329i;
                            } else {
                                m4328g = m4328g(m4327f, m4329i);
                            }
                            z = m4331b(guard, m4328g, isHeldByCurrentThread);
                        } catch (InterruptedException unused) {
                            isHeldByCurrentThread = false;
                            interrupted = z;
                        } catch (Throwable th) {
                            reentrantLock.unlock();
                            throw th;
                        }
                    }
                    if (!z) {
                        reentrantLock.unlock();
                    }
                    if (interrupted) {
                        Thread.currentThread().interrupt();
                    }
                    return z;
                }
                m4327f = m4327f(m4329i);
                long j2 = m4329i;
                while (true) {
                    try {
                        try {
                            break;
                        } catch (Throwable th2) {
                            th = th2;
                            interrupted = true;
                            if (interrupted) {
                                Thread.currentThread().interrupt();
                            }
                            throw th;
                        }
                    } catch (InterruptedException unused2) {
                        j2 = m4328g(m4327f, m4329i);
                        interrupted = true;
                    }
                }
                if (!reentrantLock.tryLock(j2, TimeUnit.NANOSECONDS)) {
                    if (interrupted) {
                        Thread.currentThread().interrupt();
                    }
                    return false;
                }
                while (!guard.isSatisfied()) {
                }
                if (!z) {
                }
                if (interrupted) {
                }
                return z;
            } catch (Throwable th3) {
                th = th3;
            }
        } else {
            throw new IllegalMonitorStateException();
        }
    }
}
