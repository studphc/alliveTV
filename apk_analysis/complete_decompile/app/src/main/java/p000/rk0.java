package p000;

import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class rk0 extends nk0 {
    private static final long serialVersionUID = 4023437720691792495L;

    /* renamed from: c */
    public final AtomicReference f26000c;

    /* renamed from: d */
    public Throwable f26001d;

    /* renamed from: e */
    public volatile boolean f26002e;

    /* renamed from: f */
    public final AtomicInteger f26003f;

    public rk0(Subscriber subscriber) {
        super(subscriber);
        this.f26000c = new AtomicReference();
        this.f26003f = new AtomicInteger();
    }

    @Override // p000.nk0
    /* renamed from: c */
    public final void mo6352c() {
        m7280f();
    }

    @Override // p000.nk0
    /* renamed from: d */
    public final void mo6353d() {
        if (this.f26003f.getAndIncrement() == 0) {
            this.f26000c.lazySet(null);
        }
    }

    @Override // p000.nk0
    /* renamed from: e */
    public final boolean mo6354e(Throwable th) {
        if (!this.f26002e && !this.f23386b.isDisposed()) {
            this.f26001d = th;
            this.f26002e = true;
            m7280f();
            return true;
        }
        return false;
    }

    /* renamed from: f */
    public final void m7280f() {
        boolean z;
        boolean z2;
        if (this.f26003f.getAndIncrement() != 0) {
            return;
        }
        Subscriber subscriber = this.f23385a;
        AtomicReference atomicReference = this.f26000c;
        int i = 1;
        do {
            long j = get();
            long j2 = 0;
            while (true) {
                z = false;
                if (j2 == j) {
                    break;
                }
                if (this.f23386b.isDisposed()) {
                    atomicReference.lazySet(null);
                    return;
                }
                boolean z3 = this.f26002e;
                Object andSet = atomicReference.getAndSet(null);
                if (andSet == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z3 && z2) {
                    Throwable th = this.f26001d;
                    if (th != null) {
                        m6351b(th);
                        return;
                    } else {
                        m6350a();
                        return;
                    }
                }
                if (z2) {
                    break;
                }
                subscriber.onNext(andSet);
                j2++;
            }
            if (j2 == j) {
                if (this.f23386b.isDisposed()) {
                    atomicReference.lazySet(null);
                    return;
                }
                boolean z4 = this.f26002e;
                if (atomicReference.get() == null) {
                    z = true;
                }
                if (z4 && z) {
                    Throwable th2 = this.f26001d;
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
            i = this.f26003f.addAndGet(-i);
        } while (i != 0);
    }

    @Override // p000.nk0, io.reactivex.rxjava3.core.Emitter
    public final void onComplete() {
        this.f26002e = true;
        m7280f();
    }

    @Override // io.reactivex.rxjava3.core.Emitter
    public final void onNext(Object obj) {
        if (!this.f26002e && !this.f23386b.isDisposed()) {
            if (obj == null) {
                onError(ExceptionHelper.createNullPointerException("onNext called with a null value."));
            } else {
                this.f26000c.set(obj);
                m7280f();
            }
        }
    }
}
