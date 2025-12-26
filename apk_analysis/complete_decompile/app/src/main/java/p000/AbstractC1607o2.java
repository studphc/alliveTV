package p000;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamObservableSource;

/* renamed from: o2 */
/* loaded from: classes2.dex */
public abstract class AbstractC1607o2 extends Observable implements HasUpstreamObservableSource {
    protected final ObservableSource<Object> source;

    public AbstractC1607o2(ObservableSource observableSource) {
        this.source = observableSource;
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.HasUpstreamObservableSource
    public final ObservableSource<Object> source() {
        return this.source;
    }
}
