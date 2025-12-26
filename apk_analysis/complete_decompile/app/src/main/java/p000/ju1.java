package p000;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.observers.SerializedObserver;
import io.reactivex.rxjava3.operators.QueueDisposable;
import io.reactivex.rxjava3.operators.SimpleQueue;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class ju1 extends AtomicInteger implements Observer, Disposable {
    private static final long serialVersionUID = 8828587559905699186L;

    /* renamed from: a */
    public final SerializedObserver f20631a;

    /* renamed from: b */
    public final Function f20632b;

    /* renamed from: c */
    public final iu1 f20633c;

    /* renamed from: d */
    public final int f20634d;

    /* renamed from: e */
    public SimpleQueue f20635e;

    /* renamed from: f */
    public Disposable f20636f;

    /* renamed from: g */
    public volatile boolean f20637g;

    /* renamed from: h */
    public volatile boolean f20638h;

    /* renamed from: i */
    public volatile boolean f20639i;

    /* renamed from: j */
    public int f20640j;

    public ju1(SerializedObserver serializedObserver, Function function, int i) {
        this.f20631a = serializedObserver;
        this.f20632b = function;
        this.f20634d = i;
        this.f20633c = new iu1(serializedObserver, this);
    }

    /* renamed from: a */
    public final void m5462a() {
        boolean z;
        if (getAndIncrement() != 0) {
            return;
        }
        while (!this.f20638h) {
            if (!this.f20637g) {
                boolean z2 = this.f20639i;
                try {
                    Object poll = this.f20635e.poll();
                    if (poll == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z2 && z) {
                        this.f20638h = true;
                        this.f20631a.onComplete();
                        return;
                    }
                    if (!z) {
                        try {
                            Object apply = this.f20632b.apply(poll);
                            Objects.requireNonNull(apply, "The mapper returned a null ObservableSource");
                            ObservableSource observableSource = (ObservableSource) apply;
                            this.f20637g = true;
                            observableSource.subscribe(this.f20633c);
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            dispose();
                            this.f20635e.clear();
                            this.f20631a.onError(th);
                            return;
                        }
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    dispose();
                    this.f20635e.clear();
                    this.f20631a.onError(th2);
                    return;
                }
            }
            if (decrementAndGet() == 0) {
                return;
            }
        }
        this.f20635e.clear();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        this.f20638h = true;
        iu1 iu1Var = this.f20633c;
        iu1Var.getClass();
        DisposableHelper.dispose(iu1Var);
        this.f20636f.dispose();
        if (getAndIncrement() == 0) {
            this.f20635e.clear();
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f20638h;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        if (this.f20639i) {
            return;
        }
        this.f20639i = true;
        m5462a();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        if (this.f20639i) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.f20639i = true;
        dispose();
        this.f20631a.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        if (this.f20639i) {
            return;
        }
        if (this.f20640j == 0) {
            this.f20635e.offer(obj);
        }
        m5462a();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f20636f, disposable)) {
            this.f20636f = disposable;
            if (disposable instanceof QueueDisposable) {
                QueueDisposable queueDisposable = (QueueDisposable) disposable;
                int requestFusion = queueDisposable.requestFusion(3);
                if (requestFusion == 1) {
                    this.f20640j = requestFusion;
                    this.f20635e = queueDisposable;
                    this.f20639i = true;
                    this.f20631a.onSubscribe(this);
                    m5462a();
                    return;
                }
                if (requestFusion == 2) {
                    this.f20640j = requestFusion;
                    this.f20635e = queueDisposable;
                    this.f20631a.onSubscribe(this);
                    return;
                }
            }
            this.f20635e = new SpscLinkedArrayQueue(this.f20634d);
            this.f20631a.onSubscribe(this);
        }
    }
}
