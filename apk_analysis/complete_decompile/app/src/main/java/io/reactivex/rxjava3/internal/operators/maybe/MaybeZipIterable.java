package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.Arrays;
import p000.ck1;
import p000.gi1;
import p000.nj0;

/* loaded from: classes2.dex */
public final class MaybeZipIterable<T, R> extends Maybe<R> {

    /* renamed from: a */
    public final Iterable f19228a;

    /* renamed from: b */
    public final Function f19229b;

    public MaybeZipIterable(Iterable<? extends MaybeSource<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        this.f19228a = iterable;
        this.f19229b = function;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super R> maybeObserver) {
        MaybeSource[] maybeSourceArr = new MaybeSource[8];
        try {
            int i = 0;
            for (MaybeSource maybeSource : this.f19228a) {
                if (maybeSource == null) {
                    EmptyDisposable.error(new NullPointerException("One of the sources is null"), maybeObserver);
                    return;
                }
                if (i == maybeSourceArr.length) {
                    maybeSourceArr = (MaybeSource[]) Arrays.copyOf(maybeSourceArr, (i >> 2) + i);
                }
                int i2 = i + 1;
                maybeSourceArr[i] = maybeSource;
                i = i2;
            }
            if (i == 0) {
                EmptyDisposable.complete(maybeObserver);
                return;
            }
            if (i == 1) {
                maybeSourceArr[0].subscribe(new gi1(1, maybeObserver, new nj0(13, this)));
                return;
            }
            ck1 ck1Var = new ck1(i, maybeObserver, this.f19229b);
            maybeObserver.onSubscribe(ck1Var);
            for (int i3 = 0; i3 < i && !ck1Var.isDisposed(); i3++) {
                maybeSourceArr[i3].subscribe(ck1Var.f8405c[i3]);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, maybeObserver);
        }
    }
}
