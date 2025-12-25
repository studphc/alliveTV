package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import p000.ck1;
import p000.gi1;
import p000.nj0;

/* loaded from: classes2.dex */
public final class MaybeZipArray<T, R> extends Maybe<R> {

    /* renamed from: a */
    public final MaybeSource[] f19226a;

    /* renamed from: b */
    public final Function f19227b;

    public MaybeZipArray(MaybeSource<? extends T>[] maybeSourceArr, Function<? super Object[], ? extends R> function) {
        this.f19226a = maybeSourceArr;
        this.f19227b = function;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super R> maybeObserver) {
        MaybeSource[] maybeSourceArr = this.f19226a;
        int length = maybeSourceArr.length;
        if (length == 1) {
            maybeSourceArr[0].subscribe(new gi1(1, maybeObserver, new nj0(12, this)));
            return;
        }
        ck1 ck1Var = new ck1(length, maybeObserver, this.f19227b);
        maybeObserver.onSubscribe(ck1Var);
        for (int i = 0; i < length && !ck1Var.isDisposed(); i++) {
            MaybeSource maybeSource = maybeSourceArr[i];
            if (maybeSource == null) {
                NullPointerException nullPointerException = new NullPointerException("One of the sources is null");
                if (ck1Var.getAndSet(0) > 0) {
                    ck1Var.m2263a(i);
                    ck1Var.f8406d = null;
                    ck1Var.f8403a.onError(nullPointerException);
                    return;
                }
                RxJavaPlugins.onError(nullPointerException);
                return;
            }
            maybeSource.subscribe(ck1Var.f8405c[i]);
        }
    }
}
