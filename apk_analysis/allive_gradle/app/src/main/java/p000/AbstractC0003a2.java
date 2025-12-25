package p000;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamMaybeSource;

/* renamed from: a2 */
/* loaded from: classes2.dex */
public abstract class AbstractC0003a2 extends Maybe implements HasUpstreamMaybeSource {
    protected final MaybeSource<Object> source;

    public AbstractC0003a2(MaybeSource maybeSource) {
        this.source = maybeSource;
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.HasUpstreamMaybeSource
    public final MaybeSource<Object> source() {
        return this.source;
    }
}
