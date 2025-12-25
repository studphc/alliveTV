package p000;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.C1019s0;
import com.google.common.util.concurrent.CycleDetectingLockFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: vx */
/* loaded from: classes2.dex */
public final class C1925vx extends ReentrantLock implements InterfaceC1888ux {

    /* renamed from: a */
    public final C1019s0 f27984a;

    /* renamed from: b */
    public final /* synthetic */ CycleDetectingLockFactory f27985b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1925vx(CycleDetectingLockFactory cycleDetectingLockFactory, C1019s0 c1019s0, boolean z) {
        super(z);
        this.f27985b = cycleDetectingLockFactory;
        this.f27984a = (C1019s0) Preconditions.checkNotNull(c1019s0);
    }

    @Override // p000.InterfaceC1888ux
    /* renamed from: a */
    public final C1019s0 mo7780a() {
        return this.f27984a;
    }

    @Override // p000.InterfaceC1888ux
    /* renamed from: b */
    public final boolean mo7781b() {
        return isHeldByCurrentThread();
    }

    @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
    public final void lock() {
        CycleDetectingLockFactory.m4324a(this.f27985b, this);
        try {
            super.lock();
        } finally {
            CycleDetectingLockFactory.m4325b(this);
        }
    }

    @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
    public final void lockInterruptibly() {
        CycleDetectingLockFactory.m4324a(this.f27985b, this);
        try {
            super.lockInterruptibly();
        } finally {
            CycleDetectingLockFactory.m4325b(this);
        }
    }

    @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
    public final boolean tryLock() {
        CycleDetectingLockFactory.m4324a(this.f27985b, this);
        try {
            return super.tryLock();
        } finally {
            CycleDetectingLockFactory.m4325b(this);
        }
    }

    @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
    public final void unlock() {
        try {
            super.unlock();
        } finally {
            CycleDetectingLockFactory.m4325b(this);
        }
    }

    @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
    public final boolean tryLock(long j, TimeUnit timeUnit) {
        CycleDetectingLockFactory.m4324a(this.f27985b, this);
        try {
            return super.tryLock(j, timeUnit);
        } finally {
            CycleDetectingLockFactory.m4325b(this);
        }
    }
}
