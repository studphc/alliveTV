package p000;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class n41 implements Callable, Disposable {

    /* renamed from: f */
    public static final FutureTask f23221f = new FutureTask(Functions.EMPTY_RUNNABLE, null);

    /* renamed from: a */
    public final Runnable f23222a;

    /* renamed from: d */
    public final ExecutorService f23225d;

    /* renamed from: e */
    public Thread f23226e;

    /* renamed from: c */
    public final AtomicReference f23224c = new AtomicReference();

    /* renamed from: b */
    public final AtomicReference f23223b = new AtomicReference();

    public n41(Runnable runnable, ExecutorService executorService) {
        this.f23222a = runnable;
        this.f23225d = executorService;
    }

    /* renamed from: a */
    public final void m6303a(Future future) {
        boolean z;
        while (true) {
            AtomicReference atomicReference = this.f23224c;
            Future future2 = (Future) atomicReference.get();
            if (future2 == f23221f) {
                if (this.f23226e != Thread.currentThread()) {
                    z = true;
                } else {
                    z = false;
                }
                future.cancel(z);
                return;
            }
            while (!atomicReference.compareAndSet(future2, future)) {
                if (atomicReference.get() != future2) {
                    break;
                }
            }
            return;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0026, code lost:
    
        if (r5.f23226e == java.lang.Thread.currentThread()) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0028, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002b, code lost:
    
        r1.cancel(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x002a, code lost:
    
        r2 = false;
     */
    @Override // java.util.concurrent.Callable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object call() {
        this.f23226e = Thread.currentThread();
        try {
            this.f23222a.run();
            this.f23226e = null;
            Future submit = this.f23225d.submit(this);
            loop0: while (true) {
                AtomicReference atomicReference = this.f23223b;
                Future future = (Future) atomicReference.get();
                if (future == f23221f) {
                    break;
                }
                while (!atomicReference.compareAndSet(future, submit)) {
                    if (atomicReference.get() != future) {
                        break;
                    }
                }
            }
            return null;
        } catch (Throwable th) {
            this.f23226e = null;
            RxJavaPlugins.onError(th);
            throw th;
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        boolean z;
        AtomicReference atomicReference = this.f23224c;
        FutureTask futureTask = f23221f;
        Future future = (Future) atomicReference.getAndSet(futureTask);
        boolean z2 = false;
        if (future != null && future != futureTask) {
            if (this.f23226e != Thread.currentThread()) {
                z = true;
            } else {
                z = false;
            }
            future.cancel(z);
        }
        Future future2 = (Future) this.f23223b.getAndSet(futureTask);
        if (future2 != null && future2 != futureTask) {
            if (this.f23226e != Thread.currentThread()) {
                z2 = true;
            }
            future2.cancel(z2);
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        if (this.f23224c.get() == f23221f) {
            return true;
        }
        return false;
    }
}
