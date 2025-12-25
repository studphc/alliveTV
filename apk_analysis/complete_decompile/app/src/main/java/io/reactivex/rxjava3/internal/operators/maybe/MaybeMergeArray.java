package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import org.reactivestreams.Subscriber;
import p000.cj1;
import p000.dj1;
import p000.ej1;
import p000.fj1;

/* loaded from: classes2.dex */
public final class MaybeMergeArray<T> extends Flowable<T> {

    /* renamed from: b */
    public final MaybeSource[] f19185b;

    public MaybeMergeArray(MaybeSource<? extends T>[] maybeSourceArr) {
        this.f19185b = maybeSourceArr;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        fj1 cj1Var;
        MaybeSource[] maybeSourceArr = this.f19185b;
        int length = maybeSourceArr.length;
        if (length <= Flowable.bufferSize()) {
            cj1Var = new ej1(length);
        } else {
            cj1Var = new cj1();
        }
        dj1 dj1Var = new dj1(subscriber, length, cj1Var);
        subscriber.onSubscribe(dj1Var);
        AtomicThrowable atomicThrowable = dj1Var.f16389e;
        for (MaybeSource maybeSource : maybeSourceArr) {
            if (!dj1Var.f16391g && atomicThrowable.get() == null) {
                maybeSource.subscribe(dj1Var);
            } else {
                return;
            }
        }
    }
}
