package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable;

/* loaded from: classes2.dex */
public final class kx1 extends BasicIntQueueDisposable {
    private static final long serialVersionUID = 396518478098735504L;

    /* renamed from: a */
    public final Observer f22239a;

    /* renamed from: b */
    public final long f22240b;

    /* renamed from: c */
    public long f22241c;

    /* renamed from: d */
    public boolean f22242d;

    public kx1(Observer observer, long j, long j2) {
        this.f22239a = observer;
        this.f22241c = j;
        this.f22240b = j2;
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final void clear() {
        this.f22241c = this.f22240b;
        lazySet(1);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        set(1);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        if (get() != 0) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final boolean isEmpty() {
        if (this.f22241c == this.f22240b) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final Object poll() {
        long j = this.f22241c;
        if (j != this.f22240b) {
            this.f22241c = 1 + j;
            return Long.valueOf(j);
        }
        lazySet(1);
        return null;
    }

    @Override // io.reactivex.rxjava3.operators.QueueFuseable
    public final int requestFusion(int i) {
        if ((i & 1) != 0) {
            this.f22242d = true;
            return 1;
        }
        return 0;
    }
}
