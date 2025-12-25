package p000;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.operators.observable.ObservableRefCount;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class lx1 extends AtomicReference implements Runnable, Consumer {
    private static final long serialVersionUID = -4552101107598366241L;

    /* renamed from: a */
    public final ObservableRefCount f22702a;

    /* renamed from: b */
    public SequentialDisposable f22703b;

    /* renamed from: c */
    public long f22704c;

    /* renamed from: d */
    public boolean f22705d;

    /* renamed from: e */
    public boolean f22706e;

    public lx1(ObservableRefCount observableRefCount) {
        this.f22702a = observableRefCount;
    }

    @Override // io.reactivex.rxjava3.functions.Consumer
    public final void accept(Object obj) {
        DisposableHelper.replace(this, (Disposable) obj);
        synchronized (this.f22702a) {
            try {
                if (this.f22706e) {
                    this.f22702a.f19519a.reset();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f22702a.m5293e(this);
    }
}
