package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import p000.AbstractC1607o2;
import p000.m02;
import p000.n02;
import p000.nj0;

/* loaded from: classes2.dex */
public final class ObservableWithLatestFromMany<T, R> extends AbstractC1607o2 {

    /* renamed from: a */
    public final ObservableSource[] f19628a;

    /* renamed from: b */
    public final Iterable f19629b;

    /* renamed from: c */
    public final Function f19630c;

    public ObservableWithLatestFromMany(@NonNull ObservableSource<T> observableSource, @NonNull ObservableSource<?>[] observableSourceArr, @NonNull Function<? super Object[], R> function) {
        super(observableSource);
        this.f19628a = observableSourceArr;
        this.f19629b = null;
        this.f19630c = function;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super R> observer) {
        int length;
        ObservableSource[] observableSourceArr = this.f19628a;
        if (observableSourceArr == null) {
            observableSourceArr = new ObservableSource[8];
            try {
                length = 0;
                for (ObservableSource observableSource : this.f19629b) {
                    if (length == observableSourceArr.length) {
                        observableSourceArr = (ObservableSource[]) Arrays.copyOf(observableSourceArr, (length >> 1) + length);
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
            new ObservableMap(this.source, new nj0(14, this)).subscribeActual(observer);
            return;
        }
        m02 m02Var = new m02(observer, this.f19630c, length);
        observer.onSubscribe(m02Var);
        n02[] n02VarArr = m02Var.f22748c;
        AtomicReference atomicReference = m02Var.f22750e;
        for (int i2 = 0; i2 < length && !DisposableHelper.isDisposed((Disposable) atomicReference.get()) && !m02Var.f22752g; i2++) {
            observableSourceArr[i2].subscribe(n02VarArr[i2]);
        }
        this.source.subscribe(m02Var);
    }

    public ObservableWithLatestFromMany(@NonNull ObservableSource<T> observableSource, @NonNull Iterable<? extends ObservableSource<?>> iterable, @NonNull Function<? super Object[], R> function) {
        super(observableSource);
        this.f19628a = null;
        this.f19629b = iterable;
        this.f19630c = function;
    }
}
