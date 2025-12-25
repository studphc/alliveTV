package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class py1 implements Observer {

    /* renamed from: a */
    public final /* synthetic */ int f25337a = 0;

    /* renamed from: b */
    public final SpscLinkedArrayQueue f25338b;

    /* renamed from: c */
    public final int f25339c;

    /* renamed from: d */
    public volatile boolean f25340d;

    /* renamed from: e */
    public Throwable f25341e;

    /* renamed from: f */
    public final AtomicInteger f25342f;

    public py1(oy1 oy1Var, int i, int i2) {
        this.f25342f = oy1Var;
        this.f25339c = i;
        this.f25338b = new SpscLinkedArrayQueue(i2);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        switch (this.f25337a) {
            case 0:
                this.f25340d = true;
                ((oy1) this.f25342f).m6747a();
                return;
            default:
                this.f25340d = true;
                ((qy1) this.f25342f).m7152a();
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        switch (this.f25337a) {
            case 0:
                this.f25341e = th;
                this.f25340d = true;
                ((oy1) this.f25342f).m6747a();
                return;
            default:
                this.f25341e = th;
                this.f25340d = true;
                ((qy1) this.f25342f).m7152a();
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        switch (this.f25337a) {
            case 0:
                this.f25338b.offer(obj);
                ((oy1) this.f25342f).m6747a();
                return;
            default:
                this.f25338b.offer(obj);
                ((qy1) this.f25342f).m7152a();
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        switch (this.f25337a) {
            case 0:
                ((oy1) this.f25342f).f24954c.setResource(this.f25339c, disposable);
                return;
            default:
                ((qy1) this.f25342f).f25801c.setResource(this.f25339c, disposable);
                return;
        }
    }

    public py1(qy1 qy1Var, int i, int i2) {
        this.f25342f = qy1Var;
        this.f25339c = i;
        this.f25338b = new SpscLinkedArrayQueue(i2);
    }
}
