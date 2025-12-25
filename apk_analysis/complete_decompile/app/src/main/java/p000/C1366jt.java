package p000;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: jt */
/* loaded from: classes2.dex */
public final class C1366jt extends AtomicReference implements CompletableObserver, Disposable {
    private static final long serialVersionUID = -674404550052917487L;

    /* renamed from: a */
    public final CompletableObserver f20599a;

    /* renamed from: b */
    public final Consumer f20600b;

    /* renamed from: c */
    public final boolean f20601c;

    /* renamed from: d */
    public Disposable f20602d;

    public C1366jt(CompletableObserver completableObserver, Object obj, Consumer consumer, boolean z) {
        super(obj);
        this.f20599a = completableObserver;
        this.f20600b = consumer;
        this.f20601c = z;
    }

    /* renamed from: a */
    public final void m5459a() {
        Object andSet = getAndSet(this);
        if (andSet != this) {
            try {
                this.f20600b.accept(andSet);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        if (this.f20601c) {
            m5459a();
            this.f20602d.dispose();
            this.f20602d = DisposableHelper.DISPOSED;
        } else {
            this.f20602d.dispose();
            this.f20602d = DisposableHelper.DISPOSED;
            m5459a();
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f20602d.isDisposed();
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onComplete() {
        this.f20602d = DisposableHelper.DISPOSED;
        CompletableObserver completableObserver = this.f20599a;
        boolean z = this.f20601c;
        if (z) {
            Object andSet = getAndSet(this);
            if (andSet != this) {
                try {
                    this.f20600b.accept(andSet);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    completableObserver.onError(th);
                    return;
                }
            } else {
                return;
            }
        }
        completableObserver.onComplete();
        if (!z) {
            m5459a();
        }
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onError(Throwable th) {
        this.f20602d = DisposableHelper.DISPOSED;
        boolean z = this.f20601c;
        if (z) {
            Object andSet = getAndSet(this);
            if (andSet != this) {
                try {
                    this.f20600b.accept(andSet);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    th = new CompositeException(th, th2);
                }
            } else {
                return;
            }
        }
        this.f20599a.onError(th);
        if (!z) {
            m5459a();
        }
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f20602d, disposable)) {
            this.f20602d = disposable;
            this.f20599a.onSubscribe(this);
        }
    }
}
