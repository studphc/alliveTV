package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.functions.Function;
import p000.vq0;

/* loaded from: classes2.dex */
public final class FlowableSwitchMapCompletable<T> extends Completable {

    /* renamed from: a */
    public final Flowable f19269a;

    /* renamed from: b */
    public final Function f19270b;

    /* renamed from: c */
    public final boolean f19271c;

    public FlowableSwitchMapCompletable(Flowable<T> flowable, Function<? super T, ? extends CompletableSource> function, boolean z) {
        this.f19269a = flowable;
        this.f19270b = function;
        this.f19271c = z;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.f19269a.subscribe((FlowableSubscriber) new vq0(completableObserver, this.f19270b, this.f19271c));
    }
}
