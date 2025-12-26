package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeOperator;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.Objects;
import p000.AbstractC0003a2;

/* loaded from: classes2.dex */
public final class MaybeLift<T, R> extends AbstractC0003a2 {

    /* renamed from: a */
    public final MaybeOperator f19182a;

    public MaybeLift(MaybeSource<T> maybeSource, MaybeOperator<? extends R, ? super T> maybeOperator) {
        super(maybeSource);
        this.f19182a = maybeOperator;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super R> maybeObserver) {
        try {
            MaybeObserver<? super Object> apply = this.f19182a.apply(maybeObserver);
            Objects.requireNonNull(apply, "The operator returned a null MaybeObserver");
            this.source.subscribe(apply);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, maybeObserver);
        }
    }
}
