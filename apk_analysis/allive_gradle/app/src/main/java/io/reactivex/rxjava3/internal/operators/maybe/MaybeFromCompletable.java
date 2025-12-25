package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamCompletableSource;
import p000.C1522ls;

/* loaded from: classes2.dex */
public final class MaybeFromCompletable<T> extends Maybe<T> implements HasUpstreamCompletableSource {

    /* renamed from: a */
    public final CompletableSource f19172a;

    public MaybeFromCompletable(CompletableSource completableSource) {
        this.f19172a = completableSource;
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.HasUpstreamCompletableSource
    public CompletableSource source() {
        return this.f19172a;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f19172a.subscribe(new C1522ls(2, maybeObserver));
    }
}
