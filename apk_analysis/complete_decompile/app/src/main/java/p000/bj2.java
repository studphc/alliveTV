package p000;

import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class bj2 implements SingleObserver {

    /* renamed from: a */
    public final int f8046a;

    /* renamed from: b */
    public final CompositeDisposable f8047b;

    /* renamed from: c */
    public final Object[] f8048c;

    /* renamed from: d */
    public final SingleObserver f8049d;

    /* renamed from: e */
    public final AtomicInteger f8050e;

    public bj2(int i, CompositeDisposable compositeDisposable, Object[] objArr, SingleObserver singleObserver, AtomicInteger atomicInteger) {
        this.f8046a = i;
        this.f8047b = compositeDisposable;
        this.f8048c = objArr;
        this.f8049d = singleObserver;
        this.f8050e = atomicInteger;
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onError(Throwable th) {
        int andSet = this.f8050e.getAndSet(-1);
        if (andSet != 0 && andSet != 1) {
            RxJavaPlugins.onError(th);
        } else {
            this.f8047b.dispose();
            this.f8049d.onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSubscribe(Disposable disposable) {
        this.f8047b.add(disposable);
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSuccess(Object obj) {
        Object[] objArr = this.f8048c;
        objArr[this.f8046a] = obj;
        if (this.f8050e.incrementAndGet() == 2) {
            this.f8049d.onSuccess(Boolean.valueOf(Objects.equals(objArr[0], objArr[1])));
        }
    }
}
