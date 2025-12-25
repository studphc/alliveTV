package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.atomic.AtomicReference;
import p000.C1661os;

/* loaded from: classes2.dex */
public final class SingleFromCompletionStage<T> extends Single<T> {

    /* renamed from: a */
    public final CompletionStage f18584a;

    public SingleFromCompletionStage(CompletionStage<T> completionStage) {
        this.f18584a = completionStage;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [jm0, java.util.concurrent.atomic.AtomicReference] */
    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        ?? atomicReference = new AtomicReference();
        C1661os c1661os = new C1661os(singleObserver, atomicReference, 2);
        atomicReference.lazySet(c1661os);
        singleObserver.onSubscribe(c1661os);
        this.f18584a.whenComplete(atomicReference);
    }
}
