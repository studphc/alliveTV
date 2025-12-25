package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public final class iz1 extends AtomicBoolean implements Observer, Disposable {
    private static final long serialVersionUID = -5677354903406201275L;

    /* renamed from: a */
    public final Observer f20312a;

    /* renamed from: b */
    public final long f20313b;

    /* renamed from: c */
    public final long f20314c;

    /* renamed from: d */
    public final TimeUnit f20315d;

    /* renamed from: e */
    public final Scheduler f20316e;

    /* renamed from: f */
    public final SpscLinkedArrayQueue f20317f;

    /* renamed from: g */
    public final boolean f20318g;

    /* renamed from: h */
    public Disposable f20319h;

    /* renamed from: i */
    public volatile boolean f20320i;

    /* renamed from: j */
    public Throwable f20321j;

    public iz1(int i, long j, long j2, Observer observer, Scheduler scheduler, TimeUnit timeUnit, boolean z) {
        this.f20312a = observer;
        this.f20313b = j;
        this.f20314c = j2;
        this.f20315d = timeUnit;
        this.f20316e = scheduler;
        this.f20317f = new SpscLinkedArrayQueue(i);
        this.f20318g = z;
    }

    /* renamed from: a */
    public final void m5369a() {
        Throwable th;
        if (!compareAndSet(false, true)) {
            return;
        }
        Observer observer = this.f20312a;
        SpscLinkedArrayQueue spscLinkedArrayQueue = this.f20317f;
        boolean z = this.f20318g;
        long now = this.f20316e.now(this.f20315d) - this.f20314c;
        while (!this.f20320i) {
            if (!z && (th = this.f20321j) != null) {
                spscLinkedArrayQueue.clear();
                observer.onError(th);
                return;
            }
            Object poll = spscLinkedArrayQueue.poll();
            if (poll == null) {
                Throwable th2 = this.f20321j;
                if (th2 != null) {
                    observer.onError(th2);
                    return;
                } else {
                    observer.onComplete();
                    return;
                }
            }
            Object poll2 = spscLinkedArrayQueue.poll();
            if (((Long) poll).longValue() >= now) {
                observer.onNext(poll2);
            }
        }
        spscLinkedArrayQueue.clear();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        if (!this.f20320i) {
            this.f20320i = true;
            this.f20319h.dispose();
            if (compareAndSet(false, true)) {
                this.f20317f.clear();
            }
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f20320i;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        m5369a();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        this.f20321j = th;
        m5369a();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        boolean z;
        long now = this.f20316e.now(this.f20315d);
        long j = this.f20313b;
        if (j == Long.MAX_VALUE) {
            z = true;
        } else {
            z = false;
        }
        Long valueOf = Long.valueOf(now);
        SpscLinkedArrayQueue spscLinkedArrayQueue = this.f20317f;
        spscLinkedArrayQueue.offer(valueOf, obj);
        while (!spscLinkedArrayQueue.isEmpty()) {
            if (((Long) spscLinkedArrayQueue.peek()).longValue() <= now - this.f20314c || (!z && (spscLinkedArrayQueue.size() >> 1) > j)) {
                spscLinkedArrayQueue.poll();
                spscLinkedArrayQueue.poll();
            } else {
                return;
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f20319h, disposable)) {
            this.f20319h = disposable;
            this.f20312a.onSubscribe(this);
        }
    }
}
