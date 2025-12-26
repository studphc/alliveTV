package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable;
import io.reactivex.rxjava3.operators.QueueDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

/* loaded from: classes2.dex */
public final class ov1 extends BasicIntQueueDisposable implements Observer {
    private static final long serialVersionUID = 4109457741734051389L;

    /* renamed from: a */
    public final Observer f24922a;

    /* renamed from: b */
    public final Action f24923b;

    /* renamed from: c */
    public Disposable f24924c;

    /* renamed from: d */
    public QueueDisposable f24925d;

    /* renamed from: e */
    public boolean f24926e;

    public ov1(Observer observer, Action action) {
        this.f24922a = observer;
        this.f24923b = action;
    }

    /* renamed from: a */
    public final void m6731a() {
        if (compareAndSet(0, 1)) {
            try {
                this.f24923b.run();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
        }
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final void clear() {
        this.f24925d.clear();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        this.f24924c.dispose();
        m6731a();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f24924c.isDisposed();
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final boolean isEmpty() {
        return this.f24925d.isEmpty();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        this.f24922a.onComplete();
        m6731a();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        this.f24922a.onError(th);
        m6731a();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        this.f24922a.onNext(obj);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f24924c, disposable)) {
            this.f24924c = disposable;
            if (disposable instanceof QueueDisposable) {
                this.f24925d = (QueueDisposable) disposable;
            }
            this.f24922a.onSubscribe(this);
        }
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final Object poll() {
        T poll = this.f24925d.poll();
        if (poll == 0 && this.f24926e) {
            m6731a();
        }
        return poll;
    }

    @Override // io.reactivex.rxjava3.operators.QueueFuseable
    public final int requestFusion(int i) {
        QueueDisposable queueDisposable = this.f24925d;
        boolean z = false;
        if (queueDisposable == null || (i & 4) != 0) {
            return 0;
        }
        int requestFusion = queueDisposable.requestFusion(i);
        if (requestFusion != 0) {
            if (requestFusion == 1) {
                z = true;
            }
            this.f24926e = z;
        }
        return requestFusion;
    }
}
