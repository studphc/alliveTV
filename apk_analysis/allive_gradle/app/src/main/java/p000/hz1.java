package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.ArrayDeque;

/* loaded from: classes2.dex */
public final class hz1 extends ArrayDeque implements Observer, Disposable {
    private static final long serialVersionUID = 7240042530241604978L;

    /* renamed from: a */
    public final Observer f18226a;

    /* renamed from: b */
    public final int f18227b;

    /* renamed from: c */
    public Disposable f18228c;

    /* renamed from: d */
    public volatile boolean f18229d;

    public hz1(Observer observer, int i) {
        this.f18226a = observer;
        this.f18227b = i;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        if (!this.f18229d) {
            this.f18229d = true;
            this.f18228c.dispose();
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f18229d;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        Observer observer = this.f18226a;
        while (!this.f18229d) {
            Object poll = poll();
            if (poll == null) {
                observer.onComplete();
                return;
            }
            observer.onNext(poll);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        this.f18226a.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        if (this.f18227b == size()) {
            poll();
        }
        offer(obj);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f18228c, disposable)) {
            this.f18228c = disposable;
            this.f18226a.onSubscribe(this);
        }
    }
}
