package p000;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.subjects.UnicastSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes2.dex */
public final class f02 extends AtomicInteger implements Observer, Disposable, Runnable {
    private static final long serialVersionUID = 8646217640096099753L;

    /* renamed from: a */
    public final Observer f17056a;

    /* renamed from: b */
    public final ObservableSource f17057b;

    /* renamed from: c */
    public final Function f17058c;

    /* renamed from: d */
    public final int f17059d;

    /* renamed from: k */
    public volatile boolean f17066k;

    /* renamed from: l */
    public volatile boolean f17067l;

    /* renamed from: m */
    public volatile boolean f17068m;

    /* renamed from: o */
    public Disposable f17070o;

    /* renamed from: h */
    public final MpscLinkedQueue f17063h = new MpscLinkedQueue();

    /* renamed from: e */
    public final CompositeDisposable f17060e = new CompositeDisposable();

    /* renamed from: g */
    public final ArrayList f17062g = new ArrayList();

    /* renamed from: i */
    public final AtomicLong f17064i = new AtomicLong(1);

    /* renamed from: j */
    public final AtomicBoolean f17065j = new AtomicBoolean();

    /* renamed from: n */
    public final AtomicThrowable f17069n = new AtomicThrowable();

    /* renamed from: f */
    public final e02 f17061f = new e02(this);

    public f02(Observer observer, ObservableSource observableSource, Function function, int i) {
        this.f17056a = observer;
        this.f17057b = observableSource;
        this.f17058c = function;
        this.f17059d = i;
        new AtomicLong();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public final void m4764a() {
        boolean z;
        if (getAndIncrement() != 0) {
            return;
        }
        Observer observer = this.f17056a;
        MpscLinkedQueue mpscLinkedQueue = this.f17063h;
        ArrayList arrayList = this.f17062g;
        int i = 1;
        while (true) {
            if (this.f17066k) {
                mpscLinkedQueue.clear();
                arrayList.clear();
            } else {
                boolean z2 = this.f17067l;
                T poll = mpscLinkedQueue.poll();
                if (poll == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z2 && (z || this.f17069n.get() != null)) {
                    m4765b(observer);
                    this.f17066k = true;
                } else if (!z) {
                    if (poll instanceof d02) {
                        if (!this.f17065j.get()) {
                            try {
                                Object apply = this.f17058c.apply(((d02) poll).f16194a);
                                Objects.requireNonNull(apply, "The closingIndicator returned a null ObservableSource");
                                ObservableSource observableSource = (ObservableSource) apply;
                                this.f17064i.getAndIncrement();
                                UnicastSubject create = UnicastSubject.create(this.f17059d, this);
                                c02 c02Var = new c02(this, create);
                                observer.onNext(c02Var);
                                AtomicBoolean atomicBoolean = c02Var.f8220d;
                                if (!atomicBoolean.get() && atomicBoolean.compareAndSet(false, true)) {
                                    create.onComplete();
                                } else {
                                    arrayList.add(create);
                                    this.f17060e.add(c02Var);
                                    observableSource.subscribe(c02Var);
                                }
                            } catch (Throwable th) {
                                Exceptions.throwIfFatal(th);
                                this.f17070o.dispose();
                                e02 e02Var = this.f17061f;
                                e02Var.getClass();
                                DisposableHelper.dispose(e02Var);
                                this.f17060e.dispose();
                                Exceptions.throwIfFatal(th);
                                this.f17069n.tryAddThrowableOrReport(th);
                                this.f17067l = true;
                            }
                        }
                    } else if (poll instanceof c02) {
                        UnicastSubject unicastSubject = ((c02) poll).f8218b;
                        arrayList.remove(unicastSubject);
                        this.f17060e.delete((Disposable) poll);
                        unicastSubject.onComplete();
                    } else {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            ((UnicastSubject) it.next()).onNext(poll);
                        }
                    }
                } else if (this.f17068m && arrayList.size() == 0) {
                    this.f17070o.dispose();
                    e02 e02Var2 = this.f17061f;
                    e02Var2.getClass();
                    DisposableHelper.dispose(e02Var2);
                    this.f17060e.dispose();
                    m4765b(observer);
                    this.f17066k = true;
                }
            }
            i = addAndGet(-i);
            if (i == 0) {
                return;
            }
        }
    }

    /* renamed from: b */
    public final void m4765b(Observer observer) {
        Throwable terminate = this.f17069n.terminate();
        ArrayList arrayList = this.f17062g;
        if (terminate == null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((UnicastSubject) it.next()).onComplete();
            }
            observer.onComplete();
            return;
        }
        if (terminate != ExceptionHelper.TERMINATED) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ((UnicastSubject) it2.next()).onError(terminate);
            }
            observer.onError(terminate);
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        if (this.f17065j.compareAndSet(false, true)) {
            if (this.f17064i.decrementAndGet() == 0) {
                this.f17070o.dispose();
                e02 e02Var = this.f17061f;
                e02Var.getClass();
                DisposableHelper.dispose(e02Var);
                this.f17060e.dispose();
                this.f17069n.tryTerminateAndReport();
                this.f17066k = true;
                m4764a();
                return;
            }
            e02 e02Var2 = this.f17061f;
            e02Var2.getClass();
            DisposableHelper.dispose(e02Var2);
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f17065j.get();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        e02 e02Var = this.f17061f;
        e02Var.getClass();
        DisposableHelper.dispose(e02Var);
        this.f17060e.dispose();
        this.f17067l = true;
        m4764a();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        e02 e02Var = this.f17061f;
        e02Var.getClass();
        DisposableHelper.dispose(e02Var);
        this.f17060e.dispose();
        if (this.f17069n.tryAddThrowableOrReport(th)) {
            this.f17067l = true;
            m4764a();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        this.f17063h.offer(obj);
        m4764a();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f17070o, disposable)) {
            this.f17070o = disposable;
            this.f17056a.onSubscribe(this);
            this.f17057b.subscribe(this.f17061f);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f17064i.decrementAndGet() == 0) {
            this.f17070o.dispose();
            e02 e02Var = this.f17061f;
            e02Var.getClass();
            DisposableHelper.dispose(e02Var);
            this.f17060e.dispose();
            this.f17069n.tryTerminateAndReport();
            this.f17066k = true;
            m4764a();
        }
    }
}
