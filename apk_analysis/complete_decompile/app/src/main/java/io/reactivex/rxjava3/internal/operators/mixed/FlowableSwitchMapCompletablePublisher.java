package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.functions.Function;
import org.reactivestreams.Publisher;
import p000.vq0;

/* loaded from: classes2.dex */
public final class FlowableSwitchMapCompletablePublisher<T> extends Completable {

    /* renamed from: a */
    public final Publisher f19272a;

    /* renamed from: b */
    public final Function f19273b;

    /* renamed from: c */
    public final boolean f19274c;

    public FlowableSwitchMapCompletablePublisher(Publisher<T> publisher, Function<? super T, ? extends CompletableSource> function, boolean z) {
        this.f19272a = publisher;
        this.f19273b = function;
        this.f19274c = z;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.f19272a.subscribe(new vq0(completableObserver, this.f19273b, this.f19274c));
    }
}
