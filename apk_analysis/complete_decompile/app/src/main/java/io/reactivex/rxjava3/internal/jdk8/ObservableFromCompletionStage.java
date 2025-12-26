package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.atomic.AtomicReference;
import p000.hw1;

/* loaded from: classes2.dex */
public final class ObservableFromCompletionStage<T> extends Observable<T> {

    /* renamed from: a */
    public final CompletionStage f18562a;

    public ObservableFromCompletionStage(CompletionStage<T> completionStage) {
        this.f18562a = completionStage;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [gw1, java.util.concurrent.atomic.AtomicReference] */
    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        ?? atomicReference = new AtomicReference();
        hw1 hw1Var = new hw1(observer, atomicReference);
        atomicReference.lazySet(hw1Var);
        observer.onSubscribe(hw1Var);
        this.f18562a.whenComplete(atomicReference);
    }
}
