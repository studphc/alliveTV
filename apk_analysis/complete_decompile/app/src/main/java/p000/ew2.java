package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import java.util.Collections;
import java.util.Map;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class ew2 implements RangeMap {
    @Override // com.google.common.collect.RangeMap
    public final Map asDescendingMapOfRanges() {
        return Collections.emptyMap();
    }

    @Override // com.google.common.collect.RangeMap
    public final Map asMapOfRanges() {
        return Collections.emptyMap();
    }

    @Override // com.google.common.collect.RangeMap
    public final Object get(Comparable comparable) {
        return null;
    }

    @Override // com.google.common.collect.RangeMap
    public final Map.Entry getEntry(Comparable comparable) {
        return null;
    }

    @Override // com.google.common.collect.RangeMap
    public final void put(Range range, Object obj) {
        Preconditions.checkNotNull(range);
        String valueOf = String.valueOf(range);
        throw new IllegalArgumentException(AbstractC1726qj.m7059o("Cannot insert range ", valueOf, " into an empty subRangeMap", valueOf.length() + 46));
    }

    @Override // com.google.common.collect.RangeMap
    public final void putAll(RangeMap rangeMap) {
        if (rangeMap.asMapOfRanges().isEmpty()) {
        } else {
            throw new IllegalArgumentException("Cannot putAll(nonEmptyRangeMap) into an empty subRangeMap");
        }
    }

    @Override // com.google.common.collect.RangeMap
    public final void putCoalescing(Range range, Object obj) {
        Preconditions.checkNotNull(range);
        String valueOf = String.valueOf(range);
        throw new IllegalArgumentException(AbstractC1726qj.m7059o("Cannot insert range ", valueOf, " into an empty subRangeMap", valueOf.length() + 46));
    }

    @Override // com.google.common.collect.RangeMap
    public final void remove(Range range) {
        Preconditions.checkNotNull(range);
    }

    @Override // com.google.common.collect.RangeMap
    public final Range span() {
        throw new NoSuchElementException();
    }

    @Override // com.google.common.collect.RangeMap
    public final RangeMap subRangeMap(Range range) {
        Preconditions.checkNotNull(range);
        return this;
    }

    @Override // com.google.common.collect.RangeMap
    public final void clear() {
    }
}
