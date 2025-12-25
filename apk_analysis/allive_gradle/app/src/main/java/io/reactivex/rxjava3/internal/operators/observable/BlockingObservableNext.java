package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import java.util.Iterator;
import p000.C1158eh;
import p000.C2056zg;

/* loaded from: classes2.dex */
public final class BlockingObservableNext<T> implements Iterable<T> {

    /* renamed from: a */
    public final ObservableSource f19321a;

    public BlockingObservableNext(ObservableSource<T> observableSource) {
        this.f19321a = observableSource;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return new C2056zg(this.f19321a, new C1158eh(), 1);
    }
}
