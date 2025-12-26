package p000;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamPublisher;
import java.util.Objects;
import org.reactivestreams.Publisher;

/* renamed from: g0 */
/* loaded from: classes2.dex */
public abstract class AbstractC1215g0 extends Flowable implements HasUpstreamPublisher {
    protected final Flowable<Object> source;

    public AbstractC1215g0(Flowable flowable) {
        Objects.requireNonNull(flowable, "source is null");
        this.source = flowable;
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.HasUpstreamPublisher
    public final Publisher<Object> source() {
        return this.source;
    }
}
