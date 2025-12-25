package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class p02 implements Observer {

    /* renamed from: a */
    public final o02 f24991a;

    /* renamed from: b */
    public final SpscLinkedArrayQueue f24992b;

    /* renamed from: c */
    public volatile boolean f24993c;

    /* renamed from: d */
    public Throwable f24994d;

    /* renamed from: e */
    public final AtomicReference f24995e = new AtomicReference();

    public p02(o02 o02Var, int i) {
        this.f24991a = o02Var;
        this.f24992b = new SpscLinkedArrayQueue(i);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        this.f24993c = true;
        this.f24991a.m6403b();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        this.f24994d = th;
        this.f24993c = true;
        this.f24991a.m6403b();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        this.f24992b.offer(obj);
        this.f24991a.m6403b();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this.f24995e, disposable);
    }
}
