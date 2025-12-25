package p000;

import io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable;
import io.reactivex.rxjava3.subjects.UnicastSubject;

/* loaded from: classes2.dex */
public final class d03 extends BasicIntQueueDisposable {
    private static final long serialVersionUID = 7926949470189395511L;

    /* renamed from: a */
    public final /* synthetic */ UnicastSubject f16195a;

    public d03(UnicastSubject unicastSubject) {
        this.f16195a = unicastSubject;
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final void clear() {
        this.f16195a.f20137a.clear();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        if (!this.f16195a.f20141e) {
            this.f16195a.f20141e = true;
            this.f16195a.m5327d();
            this.f16195a.f20138b.lazySet(null);
            if (this.f16195a.f20145i.getAndIncrement() == 0) {
                this.f16195a.f20138b.lazySet(null);
                UnicastSubject unicastSubject = this.f16195a;
                if (!unicastSubject.f20146j) {
                    unicastSubject.f20137a.clear();
                }
            }
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f16195a.f20141e;
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final boolean isEmpty() {
        return this.f16195a.f20137a.isEmpty();
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final Object poll() {
        return this.f16195a.f20137a.poll();
    }

    @Override // io.reactivex.rxjava3.operators.QueueFuseable
    public final int requestFusion(int i) {
        if ((i & 2) != 0) {
            this.f16195a.f20146j = true;
            return 2;
        }
        return 0;
    }
}
