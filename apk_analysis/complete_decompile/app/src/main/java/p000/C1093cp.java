package p000;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.io.CharSource;
import java.io.Reader;
import java.util.Iterator;

/* renamed from: cp */
/* loaded from: classes2.dex */
public final class C1093cp extends CharSource {

    /* renamed from: a */
    public final Iterable f16041a;

    public C1093cp(Iterable iterable) {
        this.f16041a = (Iterable) Preconditions.checkNotNull(iterable);
    }

    @Override // com.google.common.io.CharSource
    public final boolean isEmpty() {
        Iterator it = this.f16041a.iterator();
        while (it.hasNext()) {
            if (!((CharSource) it.next()).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.common.io.CharSource
    public final long length() {
        Iterator it = this.f16041a.iterator();
        long j = 0;
        while (it.hasNext()) {
            j += ((CharSource) it.next()).length();
        }
        return j;
    }

    @Override // com.google.common.io.CharSource
    public final Optional lengthIfKnown() {
        Iterator it = this.f16041a.iterator();
        long j = 0;
        while (it.hasNext()) {
            Optional<Long> lengthIfKnown = ((CharSource) it.next()).lengthIfKnown();
            if (!lengthIfKnown.isPresent()) {
                return Optional.absent();
            }
            j += lengthIfKnown.get().longValue();
        }
        return Optional.m3770of(Long.valueOf(j));
    }

    @Override // com.google.common.io.CharSource
    public final Reader openStream() {
        return new C1943we(this.f16041a.iterator());
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f16041a);
        return AbstractC1726qj.m7059o("CharSource.concat(", valueOf, ")", valueOf.length() + 19);
    }
}
