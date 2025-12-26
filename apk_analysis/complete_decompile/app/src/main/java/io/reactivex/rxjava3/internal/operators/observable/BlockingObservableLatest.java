package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import java.util.Iterator;
import p000.C0593ch;

/* loaded from: classes2.dex */
public final class BlockingObservableLatest<T> implements Iterable<T> {

    /* renamed from: a */
    public final ObservableSource f19318a;

    public BlockingObservableLatest(ObservableSource<T> observableSource) {
        this.f19318a = observableSource;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        C0593ch c0593ch = new C0593ch();
        Observable.wrap(this.f19318a).materialize().subscribe(c0593ch);
        return c0593ch;
    }
}
