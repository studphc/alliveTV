package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public abstract class g02 extends AtomicInteger implements Observer, Disposable {
    private static final long serialVersionUID = 5724293814035355511L;

    /* renamed from: a */
    public final Observer f17502a;

    /* renamed from: c */
    public final long f17504c;

    /* renamed from: d */
    public final TimeUnit f17505d;

    /* renamed from: e */
    public final int f17506e;

    /* renamed from: f */
    public long f17507f;

    /* renamed from: g */
    public volatile boolean f17508g;

    /* renamed from: h */
    public Throwable f17509h;

    /* renamed from: i */
    public Disposable f17510i;

    /* renamed from: k */
    public volatile boolean f17512k;

    /* renamed from: b */
    public final MpscLinkedQueue f17503b = new MpscLinkedQueue();

    /* renamed from: j */
    public final AtomicBoolean f17511j = new AtomicBoolean();

    /* renamed from: l */
    public final AtomicInteger f17513l = new AtomicInteger(1);

    public g02(Observer observer, long j, TimeUnit timeUnit, int i) {
        this.f17502a = observer;
        this.f17504c = j;
        this.f17505d = timeUnit;
        this.f17506e = i;
    }

    /* renamed from: a */
    public abstract void mo4896a();

    /* renamed from: b */
    public abstract void mo4897b();

    /* renamed from: c */
    public abstract void mo4898c();

    /* renamed from: d */
    public final void m4899d() {
        if (this.f17513l.decrementAndGet() == 0) {
            mo4896a();
            this.f17510i.dispose();
            this.f17512k = true;
            mo4898c();
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        if (this.f17511j.compareAndSet(false, true)) {
            m4899d();
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f17511j.get();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        this.f17508g = true;
        mo4898c();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        this.f17509h = th;
        this.f17508g = true;
        mo4898c();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        this.f17503b.offer(obj);
        mo4898c();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f17510i, disposable)) {
            this.f17510i = disposable;
            this.f17502a.onSubscribe(this);
            mo4897b();
        }
    }

    public void run() {
        m4899d();
    }
}
