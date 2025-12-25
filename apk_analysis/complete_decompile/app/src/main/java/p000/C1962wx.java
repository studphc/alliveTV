package p000;

import com.google.common.util.concurrent.CycleDetectingLockFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* renamed from: wx */
/* loaded from: classes2.dex */
public final class C1962wx extends ReentrantReadWriteLock.ReadLock {

    /* renamed from: a */
    public final C1999xx f28373a;

    /* renamed from: b */
    public final /* synthetic */ CycleDetectingLockFactory f28374b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1962wx(CycleDetectingLockFactory cycleDetectingLockFactory, C1999xx c1999xx) {
        super(c1999xx);
        this.f28374b = cycleDetectingLockFactory;
        this.f28373a = c1999xx;
    }

    @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
    public final void lock() {
        CycleDetectingLockFactory cycleDetectingLockFactory = this.f28374b;
        C1999xx c1999xx = this.f28373a;
        CycleDetectingLockFactory.m4324a(cycleDetectingLockFactory, c1999xx);
        try {
            super.lock();
        } finally {
            CycleDetectingLockFactory.m4325b(c1999xx);
        }
    }

    @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
    public final void lockInterruptibly() {
        CycleDetectingLockFactory cycleDetectingLockFactory = this.f28374b;
        C1999xx c1999xx = this.f28373a;
        CycleDetectingLockFactory.m4324a(cycleDetectingLockFactory, c1999xx);
        try {
            super.lockInterruptibly();
        } finally {
            CycleDetectingLockFactory.m4325b(c1999xx);
        }
    }

    @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
    public final boolean tryLock() {
        CycleDetectingLockFactory cycleDetectingLockFactory = this.f28374b;
        C1999xx c1999xx = this.f28373a;
        CycleDetectingLockFactory.m4324a(cycleDetectingLockFactory, c1999xx);
        try {
            return super.tryLock();
        } finally {
            CycleDetectingLockFactory.m4325b(c1999xx);
        }
    }

    @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
    public final void unlock() {
        C1999xx c1999xx = this.f28373a;
        try {
            super.unlock();
        } finally {
            CycleDetectingLockFactory.m4325b(c1999xx);
        }
    }

    @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
    public final boolean tryLock(long j, TimeUnit timeUnit) {
        CycleDetectingLockFactory cycleDetectingLockFactory = this.f28374b;
        C1999xx c1999xx = this.f28373a;
        CycleDetectingLockFactory.m4324a(cycleDetectingLockFactory, c1999xx);
        try {
            return super.tryLock(j, timeUnit);
        } finally {
            CycleDetectingLockFactory.m4325b(c1999xx);
        }
    }
}
