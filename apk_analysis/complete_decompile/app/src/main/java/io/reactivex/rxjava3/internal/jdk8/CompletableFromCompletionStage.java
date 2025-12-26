package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.atomic.AtomicReference;
import p000.C1661os;

/* loaded from: classes2.dex */
public final class CompletableFromCompletionStage<T> extends Completable {

    /* renamed from: a */
    public final CompletionStage f18525a;

    public CompletableFromCompletionStage(CompletionStage<T> completionStage) {
        this.f18525a = completionStage;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [jm0, java.util.concurrent.atomic.AtomicReference] */
    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        ?? atomicReference = new AtomicReference();
        C1661os c1661os = new C1661os(completableObserver, atomicReference, 0);
        atomicReference.lazySet(c1661os);
        completableObserver.onSubscribe(c1661os);
        this.f18525a.whenComplete(atomicReference);
    }
}
