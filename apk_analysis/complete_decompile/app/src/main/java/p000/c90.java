package p000;

import com.google.common.graph.EndpointPair;
import java.util.HashSet;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class c90 extends d90 {

    /* renamed from: g */
    public HashSet f8293g;

    @Override // com.google.common.collect.AbstractIterator
    public final Object computeNext() {
        do {
            Objects.requireNonNull(this.f8293g);
            while (this.f16299f.hasNext()) {
                Object next = this.f16299f.next();
                if (!this.f8293g.contains(next)) {
                    Object obj = this.f16298e;
                    Objects.requireNonNull(obj);
                    return EndpointPair.unordered(obj, next);
                }
            }
            this.f8293g.add(this.f16298e);
        } while (m4556a());
        this.f8293g = null;
        return (EndpointPair) endOfData();
    }
}
