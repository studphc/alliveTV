package p000;

import com.google.common.util.concurrent.CycleDetectingLockFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* renamed from: yx */
/* loaded from: classes2.dex */
public final class C2036yx extends ReentrantReadWriteLock.WriteLock {

    /* renamed from: a */
    public final C1999xx f29157a;

    /* renamed from: b */
    public final /* synthetic */ CycleDetectingLockFactory f29158b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2036yx(CycleDetectingLockFactory cycleDetectingLockFactory, C1999xx c1999xx) {
        super(c1999xx);
        this.f29158b = cycleDetectingLockFactory;
        this.f29157a = c1999xx;
    }

    @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
    public final void lock() {
        CycleDetectingLockFactory cycleDetectingLockFactory = this.f29158b;
        C1999xx c1999xx = this.f29157a;
        CycleDetectingLockFactory.m4324a(cycleDetectingLockFactory, c1999xx);
        try {
            super.lock();
        } finally {
            CycleDetectingLockFactory.m4325b(c1999xx);
        }
    }

    @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
    public final void lockInterruptibly() {
        CycleDetectingLockFactory cycleDetectingLockFactory = this.f29158b;
        C1999xx c1999xx = this.f29157a;
        CycleDetectingLockFactory.m4324a(cycleDetectingLockFactory, c1999xx);
        try {
            super.lockInterruptibly();
        } finally {
            CycleDetectingLockFactory.m4325b(c1999xx);
        }
    }

    @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
    public final boolean tryLock() {
        CycleDetectingLockFactory cycleDetectingLockFactory = this.f29158b;
        C1999xx c1999xx = this.f29157a;
        CycleDetectingLockFactory.m4324a(cycleDetectingLockFactory, c1999xx);
        try {
            return super.tryLock();
        } finally {
            CycleDetectingLockFactory.m4325b(c1999xx);
        }
    }

    @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
    public final void unlock() {
        C1999xx c1999xx = this.f29157a;
        try {
            super.unlock();
        } finally {
            CycleDetectingLockFactory.m4325b(c1999xx);
        }
    }

    @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
    public final boolean tryLock(long j, TimeUnit timeUnit) {
        CycleDetectingLockFactory cycleDetectingLockFactory = this.f29158b;
        C1999xx c1999xx = this.f29157a;
        CycleDetectingLockFactory.m4324a(cycleDetectingLockFactory, c1999xx);
        try {
            return super.tryLock(j, timeUnit);
        } finally {
            CycleDetectingLockFactory.m4325b(c1999xx);
        }
    }
}
