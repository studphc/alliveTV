package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.BiPredicate;
import p000.xi1;

/* loaded from: classes2.dex */
public final class SingleContains<T> extends Single<Boolean> {

    /* renamed from: a */
    public final SingleSource f19716a;

    /* renamed from: b */
    public final Object f19717b;

    /* renamed from: c */
    public final BiPredicate f19718c;

    public SingleContains(SingleSource<T> singleSource, Object obj, BiPredicate<Object, Object> biPredicate) {
        this.f19716a = singleSource;
        this.f19717b = obj;
        this.f19718c = biPredicate;
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        this.f19716a.subscribe(new xi1(this, singleObserver, 2));
    }
}
