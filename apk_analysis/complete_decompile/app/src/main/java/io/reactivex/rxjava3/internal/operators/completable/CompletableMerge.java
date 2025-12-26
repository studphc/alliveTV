package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import org.reactivestreams.Publisher;
import p000.C1883us;

/* loaded from: classes2.dex */
public final class CompletableMerge extends Completable {

    /* renamed from: a */
    public final Publisher f18681a;

    /* renamed from: b */
    public final int f18682b;

    /* renamed from: c */
    public final boolean f18683c;

    public CompletableMerge(Publisher<? extends CompletableSource> publisher, int i, boolean z) {
        this.f18681a = publisher;
        this.f18682b = i;
        this.f18683c = z;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.f18681a.subscribe(new C1883us(completableObserver, this.f18682b, this.f18683c));
    }
}
