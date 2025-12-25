package p000;

import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class ok0 extends nk0 {
    private static final long serialVersionUID = 2427151001689639875L;

    /* renamed from: c */
    public final SpscLinkedArrayQueue f23837c;

    /* renamed from: d */
    public Throwable f23838d;

    /* renamed from: e */
    public volatile boolean f23839e;

    /* renamed from: f */
    public final AtomicInteger f23840f;

    public ok0(Subscriber subscriber, int i) {
        super(subscriber);
        this.f23837c = new SpscLinkedArrayQueue(i);
        this.f23840f = new AtomicInteger();
    }

    @Override // p000.nk0
    /* renamed from: c */
    public final void mo6352c() {
        m6579f();
    }

    @Override // p000.nk0
    /* renamed from: d */
    public final void mo6353d() {
        if (this.f23840f.getAndIncrement() == 0) {
            this.f23837c.clear();
        }
    }

    @Override // p000.nk0
    /* renamed from: e */
    public final boolean mo6354e(Throwable th) {
        if (!this.f23839e && !this.f23386b.isDisposed()) {
            this.f23838d = th;
            this.f23839e = true;
            m6579f();
            return true;
        }
        return false;
    }

    /* renamed from: f */
    public final void m6579f() {
        boolean z;
        if (this.f23840f.getAndIncrement() != 0) {
            return;
        }
        Subscriber subscriber = this.f23385a;
        SpscLinkedArrayQueue spscLinkedArrayQueue = this.f23837c;
        int i = 1;
        do {
            long j = get();
            long j2 = 0;
            while (j2 != j) {
                if (this.f23386b.isDisposed()) {
                    spscLinkedArrayQueue.clear();
                    return;
                }
                boolean z2 = this.f23839e;
                Object poll = spscLinkedArrayQueue.poll();
                if (poll == null) {
                    z = true;
                } else {
                    z = false;
                }
                if (z2 && z) {
                    Throwable th = this.f23838d;
                    if (th != null) {
                        m6351b(th);
                        return;
                    } else {
                        m6350a();
                        return;
                    }
                }
                if (z) {
                    break;
                }
                subscriber.onNext(poll);
                j2++;
            }
            if (j2 == j) {
                if (this.f23386b.isDisposed()) {
                    spscLinkedArrayQueue.clear();
                    return;
                }
                boolean z3 = this.f23839e;
                boolean isEmpty = spscLinkedArrayQueue.isEmpty();
                if (z3 && isEmpty) {
                    Throwable th2 = this.f23838d;
                    if (th2 != null) {
                        m6351b(th2);
                        return;
                    } else {
                        m6350a();
                        return;
                    }
                }
            }
            if (j2 != 0) {
                BackpressureHelper.produced(this, j2);
            }
            i = this.f23840f.addAndGet(-i);
        } while (i != 0);
    }

    @Override // p000.nk0, io.reactivex.rxjava3.core.Emitter
    public final void onComplete() {
        this.f23839e = true;
        m6579f();
    }

    @Override // io.reactivex.rxjava3.core.Emitter
    public final void onNext(Object obj) {
        if (!this.f23839e && !this.f23386b.isDisposed()) {
            if (obj == null) {
                onError(ExceptionHelper.createNullPointerException("onNext called with a null value."));
            } else {
                this.f23837c.offer(obj);
                m6579f();
            }
        }
    }
}
