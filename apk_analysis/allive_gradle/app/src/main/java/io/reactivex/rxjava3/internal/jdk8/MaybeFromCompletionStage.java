package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.atomic.AtomicReference;
import p000.C1661os;

/* loaded from: classes2.dex */
public final class MaybeFromCompletionStage<T> extends Maybe<T> {

    /* renamed from: a */
    public final CompletionStage f18551a;

    public MaybeFromCompletionStage(CompletionStage<T> completionStage) {
        this.f18551a = completionStage;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [jm0, java.util.concurrent.atomic.AtomicReference] */
    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        ?? atomicReference = new AtomicReference();
        C1661os c1661os = new C1661os(maybeObserver, atomicReference, 1);
        atomicReference.lazySet(c1661os);
        maybeObserver.onSubscribe(c1661os);
        this.f18551a.whenComplete(atomicReference);
    }
}
