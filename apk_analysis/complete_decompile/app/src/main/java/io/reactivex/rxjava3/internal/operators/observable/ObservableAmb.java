package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.concurrent.atomic.AtomicInteger;
import p000.mt1;
import p000.nt1;

/* loaded from: classes2.dex */
public final class ObservableAmb<T> extends Observable<T> {

    /* renamed from: a */
    public final ObservableSource[] f19325a;

    /* renamed from: b */
    public final Iterable f19326b;

    public ObservableAmb(ObservableSource<? extends T>[] observableSourceArr, Iterable<? extends ObservableSource<? extends T>> iterable) {
        this.f19325a = observableSourceArr;
        this.f19326b = iterable;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        int length;
        Observer observer2;
        ObservableSource[] observableSourceArr = this.f19325a;
        if (observableSourceArr == null) {
            observableSourceArr = new ObservableSource[8];
            try {
                length = 0;
                for (ObservableSource observableSource : this.f19326b) {
                    if (observableSource == null) {
                        EmptyDisposable.error(new NullPointerException("One of the sources is null"), observer);
                        return;
                    }
                    if (length == observableSourceArr.length) {
                        ObservableSource[] observableSourceArr2 = new ObservableSource[(length >> 2) + length];
                        System.arraycopy(observableSourceArr, 0, observableSourceArr2, 0, length);
                        observableSourceArr = observableSourceArr2;
                    }
                    int i = length + 1;
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
        if (length == 1) {
            observableSourceArr[0].subscribe(observer);
            return;
        }
        mt1 mt1Var = new mt1(observer, length);
        nt1[] nt1VarArr = mt1Var.f23104b;
        int length2 = nt1VarArr.length;
        int i2 = 0;
        while (true) {
            observer2 = mt1Var.f23103a;
            if (i2 >= length2) {
                break;
            }
            int i3 = i2 + 1;
            nt1VarArr[i2] = new nt1(mt1Var, i3, observer2);
            i2 = i3;
        }
        AtomicInteger atomicInteger = mt1Var.f23105c;
        atomicInteger.lazySet(0);
        observer2.onSubscribe(mt1Var);
        for (int i4 = 0; i4 < length2 && atomicInteger.get() == 0; i4++) {
            observableSourceArr[i4].subscribe(nt1VarArr[i4]);
        }
    }
}
