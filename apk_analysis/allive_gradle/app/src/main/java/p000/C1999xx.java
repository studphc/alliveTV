package p000;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.C1019s0;
import com.google.common.util.concurrent.CycleDetectingLockFactory;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* renamed from: xx */
/* loaded from: classes2.dex */
public final class C1999xx extends ReentrantReadWriteLock implements InterfaceC1888ux {

    /* renamed from: a */
    public final C1962wx f28757a;

    /* renamed from: b */
    public final C2036yx f28758b;

    /* renamed from: c */
    public final C1019s0 f28759c;

    public C1999xx(CycleDetectingLockFactory cycleDetectingLockFactory, C1019s0 c1019s0, boolean z) {
        super(z);
        this.f28757a = new C1962wx(cycleDetectingLockFactory, this);
        this.f28758b = new C2036yx(cycleDetectingLockFactory, this);
        this.f28759c = (C1019s0) Preconditions.checkNotNull(c1019s0);
    }

    @Override // p000.InterfaceC1888ux
    /* renamed from: a */
    public final C1019s0 mo7780a() {
        return this.f28759c;
    }

    @Override // p000.InterfaceC1888ux
    /* renamed from: b */
    public final boolean mo7781b() {
        if (!isWriteLockedByCurrentThread() && getReadHoldCount() <= 0) {
            return false;
        }
        return true;
    }

    @Override // java.util.concurrent.locks.ReentrantReadWriteLock, java.util.concurrent.locks.ReadWriteLock
    public final Lock readLock() {
        return this.f28757a;
    }

    @Override // java.util.concurrent.locks.ReentrantReadWriteLock, java.util.concurrent.locks.ReadWriteLock
    public final Lock writeLock() {
        return this.f28758b;
    }

    @Override // java.util.concurrent.locks.ReentrantReadWriteLock, java.util.concurrent.locks.ReadWriteLock
    public final ReentrantReadWriteLock.ReadLock readLock() {
        return this.f28757a;
    }

    @Override // java.util.concurrent.locks.ReentrantReadWriteLock, java.util.concurrent.locks.ReadWriteLock
    public final ReentrantReadWriteLock.WriteLock writeLock() {
        return this.f28758b;
    }
}
