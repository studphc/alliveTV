package p000;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes2.dex */
public final class fp2 implements ReadWriteLock {

    /* renamed from: a */
    public final ReentrantReadWriteLock f17361a = new ReentrantReadWriteLock();

    @Override // java.util.concurrent.locks.ReadWriteLock
    public final Lock readLock() {
        return new ep2(this.f17361a.readLock(), this);
    }

    @Override // java.util.concurrent.locks.ReadWriteLock
    public final Lock writeLock() {
        return new ep2(this.f17361a.writeLock(), this);
    }
}
