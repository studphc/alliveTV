package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import p000.AbstractC0003a2;
import p000.ti1;

/* loaded from: classes2.dex */
public final class MaybeFlatMapNotification<T, R> extends AbstractC0003a2 {

    /* renamed from: a */
    public final Function f19164a;

    /* renamed from: b */
    public final Function f19165b;

    /* renamed from: c */
    public final Supplier f19166c;

    public MaybeFlatMapNotification(MaybeSource<T> maybeSource, Function<? super T, ? extends MaybeSource<? extends R>> function, Function<? super Throwable, ? extends MaybeSource<? extends R>> function2, Supplier<? extends MaybeSource<? extends R>> supplier) {
        super(maybeSource);
        this.f19164a = function;
        this.f19165b = function2;
        this.f19166c = supplier;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super R> maybeObserver) {
        this.source.subscribe(new ti1(maybeObserver, this.f19164a, this.f19165b, this.f19166c));
    }
}
