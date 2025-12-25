package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.operators.QueueDisposable;
import io.reactivex.rxjava3.operators.SimpleQueue;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class yy1 extends AtomicReference implements Observer {
    private static final long serialVersionUID = 3837284832786408377L;

    /* renamed from: a */
    public final zy1 f29172a;

    /* renamed from: b */
    public final long f29173b;

    /* renamed from: c */
    public final int f29174c;

    /* renamed from: d */
    public volatile SimpleQueue f29175d;

    /* renamed from: e */
    public volatile boolean f29176e;

    public yy1(zy1 zy1Var, long j, int i) {
        this.f29172a = zy1Var;
        this.f29173b = j;
        this.f29174c = i;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        if (this.f29173b == this.f29172a.f29572j) {
            this.f29176e = true;
            this.f29172a.m8446a();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        zy1 zy1Var = this.f29172a;
        zy1Var.getClass();
        if (this.f29173b == zy1Var.f29572j && zy1Var.f29567e.tryAddThrowable(th)) {
            if (!zy1Var.f29566d) {
                zy1Var.f29570h.dispose();
                zy1Var.f29568f = true;
            }
            this.f29176e = true;
            zy1Var.m8446a();
            return;
        }
        RxJavaPlugins.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        if (this.f29173b == this.f29172a.f29572j) {
            if (obj != null) {
                this.f29175d.offer(obj);
            }
            this.f29172a.m8446a();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.setOnce(this, disposable)) {
            if (disposable instanceof QueueDisposable) {
                QueueDisposable queueDisposable = (QueueDisposable) disposable;
                int requestFusion = queueDisposable.requestFusion(7);
                if (requestFusion == 1) {
                    this.f29175d = queueDisposable;
                    this.f29176e = true;
                    this.f29172a.m8446a();
                    return;
                } else if (requestFusion == 2) {
                    this.f29175d = queueDisposable;
                    return;
                }
            }
            this.f29175d = new SpscLinkedArrayQueue(this.f29174c);
        }
    }
}
