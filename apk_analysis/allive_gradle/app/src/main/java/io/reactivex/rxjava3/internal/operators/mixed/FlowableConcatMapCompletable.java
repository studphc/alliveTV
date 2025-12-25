package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import p000.xj0;

/* loaded from: classes2.dex */
public final class FlowableConcatMapCompletable<T> extends Completable {

    /* renamed from: a */
    public final Flowable f19249a;

    /* renamed from: b */
    public final Function f19250b;

    /* renamed from: c */
    public final ErrorMode f19251c;

    /* renamed from: d */
    public final int f19252d;

    public FlowableConcatMapCompletable(Flowable<T> flowable, Function<? super T, ? extends CompletableSource> function, ErrorMode errorMode, int i) {
        this.f19249a = flowable;
        this.f19250b = function;
        this.f19251c = errorMode;
        this.f19252d = i;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.f19249a.subscribe((FlowableSubscriber) new xj0(completableObserver, this.f19250b, this.f19251c, this.f19252d));
    }
}
