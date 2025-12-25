package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import p000.o02;
import p000.p02;

/* loaded from: classes2.dex */
public final class ObservableZip<T, R> extends Observable<R> {

    /* renamed from: a */
    public final ObservableSource[] f19631a;

    /* renamed from: b */
    public final Iterable f19632b;

    /* renamed from: c */
    public final Function f19633c;

    /* renamed from: d */
    public final int f19634d;

    /* renamed from: e */
    public final boolean f19635e;

    public ObservableZip(ObservableSource<? extends T>[] observableSourceArr, Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i, boolean z) {
        this.f19631a = observableSourceArr;
        this.f19632b = iterable;
        this.f19633c = function;
        this.f19634d = i;
        this.f19635e = z;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super R> observer) {
        int length;
        ObservableSource[] observableSourceArr = this.f19631a;
        if (observableSourceArr == null) {
            observableSourceArr = new ObservableSource[8];
            length = 0;
            for (ObservableSource observableSource : this.f19632b) {
                if (length == observableSourceArr.length) {
                    ObservableSource[] observableSourceArr2 = new ObservableSource[(length >> 2) + length];
                    System.arraycopy(observableSourceArr, 0, observableSourceArr2, 0, length);
                    observableSourceArr = observableSourceArr2;
                }
                observableSourceArr[length] = observableSource;
                length++;
            }
        } else {
            length = observableSourceArr.length;
        }
        if (length == 0) {
            EmptyDisposable.complete(observer);
            return;
        }
        o02 o02Var = new o02(observer, this.f19633c, length, this.f19635e);
        int i = this.f19634d;
        p02[] p02VarArr = o02Var.f23556c;
        int length2 = p02VarArr.length;
        for (int i2 = 0; i2 < length2; i2++) {
            p02VarArr[i2] = new p02(o02Var, i);
        }
        o02Var.lazySet(0);
        o02Var.f23554a.onSubscribe(o02Var);
        for (int i3 = 0; i3 < length2 && !o02Var.f23559f; i3++) {
            observableSourceArr[i3].subscribe(p02VarArr[i3]);
        }
    }
}
