package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.Arrays;
import java.util.NoSuchElementException;
import p000.gk2;
import p000.nj0;
import p000.xi1;

/* loaded from: classes2.dex */
public final class SingleZipIterable<T, R> extends Single<R> {

    /* renamed from: a */
    public final Iterable f19825a;

    /* renamed from: b */
    public final Function f19826b;

    public SingleZipIterable(Iterable<? extends SingleSource<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        this.f19825a = iterable;
        this.f19826b = function;
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super R> singleObserver) {
        SingleSource[] singleSourceArr = new SingleSource[8];
        try {
            int i = 0;
            for (SingleSource singleSource : this.f19825a) {
                if (singleSource == null) {
                    EmptyDisposable.error(new NullPointerException("One of the sources is null"), singleObserver);
                    return;
                }
                if (i == singleSourceArr.length) {
                    singleSourceArr = (SingleSource[]) Arrays.copyOf(singleSourceArr, (i >> 2) + i);
                }
                int i2 = i + 1;
                singleSourceArr[i] = singleSource;
                i = i2;
            }
            if (i == 0) {
                EmptyDisposable.error(new NoSuchElementException(), singleObserver);
                return;
            }
            if (i == 1) {
                singleSourceArr[0].subscribe(new xi1(8, singleObserver, new nj0(16, this)));
                return;
            }
            gk2 gk2Var = new gk2(singleObserver, i, this.f19826b);
            singleObserver.onSubscribe(gk2Var);
            for (int i3 = 0; i3 < i && !gk2Var.isDisposed(); i3++) {
                singleSourceArr[i3].subscribe(gk2Var.f17744c[i3]);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, singleObserver);
        }
    }
}
