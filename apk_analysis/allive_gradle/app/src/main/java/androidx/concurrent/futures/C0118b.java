package androidx.concurrent.futures;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* renamed from: androidx.concurrent.futures.b */
/* loaded from: classes.dex */
public final class C0118b implements ListenableFuture {

    /* renamed from: a */
    public final WeakReference f1817a;

    /* renamed from: b */
    public final C0117a f1818b = new C0117a(this);

    public C0118b(CallbackToFutureAdapter.Completer completer) {
        this.f1817a = new WeakReference(completer);
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public final void addListener(Runnable runnable, Executor executor) {
        this.f1818b.addListener(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        CallbackToFutureAdapter.Completer completer = (CallbackToFutureAdapter.Completer) this.f1817a.get();
        boolean cancel = this.f1818b.cancel(z);
        if (cancel && completer != null) {
            completer.f1811a = null;
            completer.f1812b = null;
            completer.f1813c.set(null);
        }
        return cancel;
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        return this.f1818b.get();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f1818b.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.f1818b.isDone();
    }

    public final String toString() {
        return this.f1818b.toString();
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) {
        return this.f1818b.get(j, timeUnit);
    }
}
