package p000;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.schedulers.SchedulerRunnableIntrospection;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class pa0 extends AtomicReference implements Runnable, Disposable, SchedulerRunnableIntrospection {
    private static final long serialVersionUID = -4101336210206799084L;

    /* renamed from: a */
    public final SequentialDisposable f25093a;

    /* renamed from: b */
    public final SequentialDisposable f25094b;

    public pa0(Runnable runnable) {
        super(runnable);
        this.f25093a = new SequentialDisposable();
        this.f25094b = new SequentialDisposable();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        if (getAndSet(null) != null) {
            this.f25093a.dispose();
            this.f25094b.dispose();
        }
    }

    @Override // io.reactivex.rxjava3.schedulers.SchedulerRunnableIntrospection
    public final Runnable getWrappedRunnable() {
        Runnable runnable = (Runnable) get();
        if (runnable == null) {
            return Functions.EMPTY_RUNNABLE;
        }
        return runnable;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        if (get() == null) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SequentialDisposable sequentialDisposable = this.f25094b;
        SequentialDisposable sequentialDisposable2 = this.f25093a;
        Runnable runnable = (Runnable) get();
        if (runnable != null) {
            try {
                try {
                    runnable.run();
                    lazySet(null);
                    DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
                    sequentialDisposable2.lazySet(disposableHelper);
                    sequentialDisposable.lazySet(disposableHelper);
                } catch (Throwable th) {
                    lazySet(null);
                    sequentialDisposable2.lazySet(DisposableHelper.DISPOSED);
                    sequentialDisposable.lazySet(DisposableHelper.DISPOSED);
                    throw th;
                }
            } catch (Throwable th2) {
                RxJavaPlugins.onError(th2);
                throw th2;
            }
        }
    }
}
