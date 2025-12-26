package p000;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableRefCount;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class xo0 extends AtomicReference implements Runnable, Consumer {
    private static final long serialVersionUID = -4552101107598366241L;

    /* renamed from: a */
    public final FlowableRefCount f28666a;

    /* renamed from: b */
    public SequentialDisposable f28667b;

    /* renamed from: c */
    public long f28668c;

    /* renamed from: d */
    public boolean f28669d;

    /* renamed from: e */
    public boolean f28670e;

    public xo0(FlowableRefCount flowableRefCount) {
        this.f28666a = flowableRefCount;
    }

    @Override // io.reactivex.rxjava3.functions.Consumer
    public final void accept(Object obj) {
        DisposableHelper.replace(this, (Disposable) obj);
        synchronized (this.f28666a) {
            try {
                if (this.f28670e) {
                    this.f28666a.f18976b.reset();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f28666a.m5278f(this);
    }
}
