package p000;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.operators.observable.ObserverResourceWrapper;
import io.reactivex.rxjava3.observables.ConnectableObservable;
import io.reactivex.rxjava3.subjects.UnicastSubject;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public final class ux1 extends Observable {

    /* renamed from: a */
    public final /* synthetic */ int f27521a;

    /* renamed from: b */
    public final Object f27522b;

    /* renamed from: c */
    public final Object f27523c;

    public ux1(UnicastSubject unicastSubject) {
        this.f27521a = 1;
        this.f27522b = unicastSubject;
        this.f27523c = new AtomicBoolean();
    }

    /* renamed from: d */
    public boolean m7788d() {
        AtomicBoolean atomicBoolean = (AtomicBoolean) this.f27523c;
        if (atomicBoolean.get() || !atomicBoolean.compareAndSet(false, true)) {
            return false;
        }
        return true;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public final void subscribeActual(Observer observer) {
        switch (this.f27521a) {
            case 0:
                try {
                    Object obj = ((Supplier) this.f27522b).get();
                    Objects.requireNonNull(obj, "The connectableFactory returned a null ConnectableObservable");
                    ConnectableObservable connectableObservable = (ConnectableObservable) obj;
                    Object apply = ((Function) this.f27523c).apply(connectableObservable);
                    Objects.requireNonNull(apply, "The selector returned a null ObservableSource");
                    ObservableSource observableSource = (ObservableSource) apply;
                    ObserverResourceWrapper observerResourceWrapper = new ObserverResourceWrapper(observer);
                    observableSource.subscribe(observerResourceWrapper);
                    connectableObservable.connect(new tm0(3, observerResourceWrapper));
                    return;
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    EmptyDisposable.error(th, (Observer<?>) observer);
                    return;
                }
            default:
                ((UnicastSubject) this.f27522b).subscribe(observer);
                ((AtomicBoolean) this.f27523c).set(true);
                return;
        }
    }

    public ux1(Supplier supplier, Function function) {
        this.f27521a = 0;
        this.f27522b = supplier;
        this.f27523c = function;
    }
}
