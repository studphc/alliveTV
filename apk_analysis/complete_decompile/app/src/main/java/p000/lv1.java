package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.observers.BasicFuseableObserver;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class lv1 extends BasicFuseableObserver {

    /* renamed from: a */
    public final Collection f22677a;

    /* renamed from: b */
    public final Function f22678b;

    public lv1(Observer observer, Function function, Collection collection) {
        super(observer);
        this.f22678b = function;
        this.f22677a = collection;
    }

    @Override // io.reactivex.rxjava3.internal.observers.BasicFuseableObserver, io.reactivex.rxjava3.operators.SimpleQueue
    public final void clear() {
        this.f22677a.clear();
        super.clear();
    }

    @Override // io.reactivex.rxjava3.internal.observers.BasicFuseableObserver, io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        if (!this.done) {
            this.done = true;
            this.f22677a.clear();
            this.downstream.onComplete();
        }
    }

    @Override // io.reactivex.rxjava3.internal.observers.BasicFuseableObserver, io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        if (this.done) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.done = true;
        this.f22677a.clear();
        this.downstream.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        if (this.done) {
            return;
        }
        if (this.sourceMode == 0) {
            try {
                Object apply = this.f22678b.apply(obj);
                Objects.requireNonNull(apply, "The keySelector returned a null key");
                if (this.f22677a.add(apply)) {
                    this.downstream.onNext(obj);
                    return;
                }
                return;
            } catch (Throwable th) {
                fail(th);
                return;
            }
        }
        this.downstream.onNext(null);
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final Object poll() {
        Object poll;
        Object apply;
        do {
            poll = this.f18587qd.poll();
            if (poll == null) {
                break;
            }
            apply = this.f22678b.apply(poll);
            Objects.requireNonNull(apply, "The keySelector returned a null key");
        } while (!this.f22677a.add(apply));
        return poll;
    }
}
