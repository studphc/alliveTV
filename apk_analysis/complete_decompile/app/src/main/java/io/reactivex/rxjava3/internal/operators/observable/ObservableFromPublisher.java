package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import org.reactivestreams.Publisher;
import p000.C1735qs;

/* loaded from: classes2.dex */
public final class ObservableFromPublisher<T> extends Observable<T> {

    /* renamed from: a */
    public final Publisher f19444a;

    public ObservableFromPublisher(Publisher<? extends T> publisher) {
        this.f19444a = publisher;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.f19444a.subscribe(new C1735qs(2, observer));
    }
}
