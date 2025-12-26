package p000;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class cj1 extends ConcurrentLinkedQueue implements fj1 {
    private static final long serialVersionUID = -4025173261791142821L;

    /* renamed from: a */
    public int f8385a;

    /* renamed from: b */
    public final AtomicInteger f8386b = new AtomicInteger();

    @Override // p000.fj1
    /* renamed from: b */
    public final int mo2257b() {
        return this.f8386b.get();
    }

    @Override // p000.fj1
    /* renamed from: c */
    public final void mo2258c() {
        poll();
    }

    @Override // p000.fj1
    /* renamed from: d */
    public final int mo2259d() {
        return this.f8385a;
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final boolean offer(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.Queue, io.reactivex.rxjava3.operators.SimpleQueue
    public final Object poll() {
        Object poll = super.poll();
        if (poll != null) {
            this.f8385a++;
        }
        return poll;
    }

    @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.Queue, io.reactivex.rxjava3.operators.SimpleQueue
    public final boolean offer(Object obj) {
        this.f8386b.getAndIncrement();
        return super.offer(obj);
    }
}
