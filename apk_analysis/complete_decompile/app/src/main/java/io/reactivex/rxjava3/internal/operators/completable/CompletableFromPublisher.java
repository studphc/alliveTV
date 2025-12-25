package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import org.reactivestreams.Publisher;
import p000.C1735qs;

/* loaded from: classes2.dex */
public final class CompletableFromPublisher<T> extends Completable {

    /* renamed from: a */
    public final Publisher f18672a;

    public CompletableFromPublisher(Publisher<T> publisher) {
        this.f18672a = publisher;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.f18672a.subscribe(new C1735qs(0, completableObserver));
    }
}
