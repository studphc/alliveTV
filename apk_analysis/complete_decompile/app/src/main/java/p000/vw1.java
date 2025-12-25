package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.observers.BasicFuseableObserver;
import java.util.Objects;
import java.util.Optional;

/* loaded from: classes2.dex */
public final class vw1 extends BasicFuseableObserver {

    /* renamed from: a */
    public final /* synthetic */ int f27981a;

    /* renamed from: b */
    public final Function f27982b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ vw1(Observer observer, Function function, int i) {
        super(observer);
        this.f27981a = i;
        this.f27982b = function;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        boolean isPresent;
        Object obj2;
        switch (this.f27981a) {
            case 0:
                if (!this.done) {
                    if (this.sourceMode != 0) {
                        this.downstream.onNext(null);
                        return;
                    }
                    try {
                        Object apply = this.f27982b.apply(obj);
                        Objects.requireNonNull(apply, "The mapper function returned a null value.");
                        this.downstream.onNext(apply);
                        return;
                    } catch (Throwable th) {
                        fail(th);
                        return;
                    }
                }
                return;
            default:
                if (!this.done) {
                    if (this.sourceMode != 0) {
                        this.downstream.onNext(null);
                        return;
                    }
                    try {
                        Object apply2 = this.f27982b.apply(obj);
                        Objects.requireNonNull(apply2, "The mapper returned a null Optional");
                        Optional m5540h = ki0.m5540h(apply2);
                        isPresent = m5540h.isPresent();
                        if (isPresent) {
                            Observer<? super R> observer = this.downstream;
                            obj2 = m5540h.get();
                            observer.onNext(obj2);
                            return;
                        }
                        return;
                    } catch (Throwable th2) {
                        fail(th2);
                        return;
                    }
                }
                return;
        }
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final Object poll() {
        Optional m5540h;
        boolean isPresent;
        Object obj;
        switch (this.f27981a) {
            case 0:
                Object poll = this.f18587qd.poll();
                if (poll != null) {
                    Object apply = this.f27982b.apply(poll);
                    Objects.requireNonNull(apply, "The mapper function returned a null value.");
                    return apply;
                }
                return null;
        }
        do {
            Object poll2 = this.f18587qd.poll();
            if (poll2 == null) {
                return null;
            }
            Object apply2 = this.f27982b.apply(poll2);
            Objects.requireNonNull(apply2, "The mapper returned a null Optional");
            m5540h = ki0.m5540h(apply2);
            isPresent = m5540h.isPresent();
        } while (!isPresent);
        obj = m5540h.get();
        return obj;
    }
}
