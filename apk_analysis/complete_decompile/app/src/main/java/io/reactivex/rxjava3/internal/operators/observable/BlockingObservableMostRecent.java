package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import io.reactivex.rxjava3.observers.DefaultObserver;
import java.util.Iterator;
import p000.C1982xg;

/* loaded from: classes2.dex */
public final class BlockingObservableMostRecent<T> implements Iterable<T> {

    /* renamed from: a */
    public final ObservableSource f19319a;

    /* renamed from: b */
    public final Object f19320b;

    public BlockingObservableMostRecent(ObservableSource<T> observableSource, T t) {
        this.f19319a = observableSource;
        this.f19320b = t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [io.reactivex.rxjava3.core.Observer, dh, java.lang.Object, io.reactivex.rxjava3.observers.DefaultObserver] */
    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        Object obj = this.f19320b;
        ?? defaultObserver = new DefaultObserver();
        defaultObserver.f16374b = NotificationLite.next(obj);
        this.f19319a.subscribe(defaultObserver);
        return new C1982xg(1, (Object) defaultObserver);
    }
}
