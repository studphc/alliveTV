package p000;

import com.google.common.graph.EndpointPair;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class b90 extends d90 {
    @Override // com.google.common.collect.AbstractIterator
    public final Object computeNext() {
        while (!this.f16299f.hasNext()) {
            if (!m4556a()) {
                return (EndpointPair) endOfData();
            }
        }
        Object obj = this.f16298e;
        Objects.requireNonNull(obj);
        return EndpointPair.ordered(obj, this.f16299f.next());
    }
}
