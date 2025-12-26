package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import p000.fi1;

/* loaded from: classes2.dex */
public final class MaybeDelayWithCompletable<T> extends Maybe<T> {

    /* renamed from: a */
    public final MaybeSource f19138a;

    /* renamed from: b */
    public final CompletableSource f19139b;

    public MaybeDelayWithCompletable(MaybeSource<T> maybeSource, CompletableSource completableSource) {
        this.f19138a = maybeSource;
        this.f19139b = completableSource;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f19139b.subscribe(new fi1(maybeObserver, this.f19138a));
    }
}
