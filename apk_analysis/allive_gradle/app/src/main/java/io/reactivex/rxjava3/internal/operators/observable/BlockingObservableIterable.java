package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import java.util.Iterator;
import p000.C0557bh;

/* loaded from: classes2.dex */
public final class BlockingObservableIterable<T> implements Iterable<T> {

    /* renamed from: a */
    public final ObservableSource f19316a;

    /* renamed from: b */
    public final int f19317b;

    public BlockingObservableIterable(ObservableSource<? extends T> observableSource, int i) {
        this.f19316a = observableSource;
        this.f19317b = i;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        C0557bh c0557bh = new C0557bh(this.f19317b);
        this.f19316a.subscribe(c0557bh);
        return c0557bh;
    }
}
