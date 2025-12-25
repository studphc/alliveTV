package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.BiPredicate;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.observers.BasicFuseableObserver;

/* loaded from: classes2.dex */
public final class mv1 extends BasicFuseableObserver {

    /* renamed from: a */
    public final Function f23137a;

    /* renamed from: b */
    public final BiPredicate f23138b;

    /* renamed from: c */
    public Object f23139c;

    /* renamed from: d */
    public boolean f23140d;

    public mv1(Observer observer, Function function, BiPredicate biPredicate) {
        super(observer);
        this.f23137a = function;
        this.f23138b = biPredicate;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        if (this.done) {
            return;
        }
        if (this.sourceMode != 0) {
            this.downstream.onNext(obj);
            return;
        }
        try {
            Object apply = this.f23137a.apply(obj);
            if (this.f23140d) {
                boolean test = this.f23138b.test(this.f23139c, apply);
                this.f23139c = apply;
                if (test) {
                    return;
                }
            } else {
                this.f23140d = true;
                this.f23139c = apply;
            }
            this.downstream.onNext(obj);
        } catch (Throwable th) {
            fail(th);
        }
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final Object poll() {
        while (true) {
            Object poll = this.f18587qd.poll();
            if (poll == null) {
                return null;
            }
            Object apply = this.f23137a.apply(poll);
            if (!this.f23140d) {
                this.f23140d = true;
                this.f23139c = apply;
                return poll;
            }
            if (!this.f23138b.test(this.f23139c, apply)) {
                this.f23139c = apply;
                return poll;
            }
            this.f23139c = apply;
        }
    }
}
