package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.Objects;
import p000.eu1;
import p000.fu1;

/* loaded from: classes2.dex */
public final class ObservableCombineLatest<T, R> extends Observable<R> {

    /* renamed from: a */
    public final ObservableSource[] f19365a;

    /* renamed from: b */
    public final Iterable f19366b;

    /* renamed from: c */
    public final Function f19367c;

    /* renamed from: d */
    public final int f19368d;

    /* renamed from: e */
    public final boolean f19369e;

    public ObservableCombineLatest(ObservableSource<? extends T>[] observableSourceArr, Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i, boolean z) {
        this.f19365a = observableSourceArr;
        this.f19366b = iterable;
        this.f19367c = function;
        this.f19368d = i;
        this.f19369e = z;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super R> observer) {
        int length;
        ObservableSource[] observableSourceArr = this.f19365a;
        if (observableSourceArr == null) {
            observableSourceArr = new ObservableSource[8];
            try {
                length = 0;
                for (ObservableSource observableSource : this.f19366b) {
                    if (length == observableSourceArr.length) {
                        ObservableSource[] observableSourceArr2 = new ObservableSource[(length >> 2) + length];
                        System.arraycopy(observableSourceArr, 0, observableSourceArr2, 0, length);
                        observableSourceArr = observableSourceArr2;
                    }
                    int i = length + 1;
                    Objects.requireNonNull(observableSource, "The Iterator returned a null ObservableSource");
                    observableSourceArr[length] = observableSource;
                    length = i;
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptyDisposable.error(th, observer);
                return;
            }
        } else {
            length = observableSourceArr.length;
        }
        if (length == 0) {
            EmptyDisposable.complete(observer);
            return;
        }
        fu1 fu1Var = new fu1(length, this.f19368d, observer, this.f19367c, this.f19369e);
        eu1[] eu1VarArr = fu1Var.f17401c;
        int length2 = eu1VarArr.length;
        fu1Var.f17399a.onSubscribe(fu1Var);
        for (int i2 = 0; i2 < length2 && !fu1Var.f17406h && !fu1Var.f17405g; i2++) {
            observableSourceArr[i2].subscribe(eu1VarArr[i2]);
        }
    }
}
