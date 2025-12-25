package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable;

/* loaded from: classes2.dex */
public final class jx1 extends BasicIntQueueDisposable {
    private static final long serialVersionUID = 396518478098735504L;

    /* renamed from: a */
    public final Observer f20673a;

    /* renamed from: b */
    public final long f20674b;

    /* renamed from: c */
    public long f20675c;

    /* renamed from: d */
    public boolean f20676d;

    public jx1(Observer observer, long j, long j2) {
        this.f20673a = observer;
        this.f20675c = j;
        this.f20674b = j2;
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final void clear() {
        this.f20675c = this.f20674b;
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
        if (this.f20675c == this.f20674b) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final Object poll() {
        long j = this.f20675c;
        if (j != this.f20674b) {
            this.f20675c = 1 + j;
            return Integer.valueOf((int) j);
        }
        lazySet(1);
        return null;
    }

    @Override // io.reactivex.rxjava3.operators.QueueFuseable
    public final int requestFusion(int i) {
        if ((i & 1) != 0) {
            this.f20676d = true;
            return 1;
        }
        return 0;
    }
}
