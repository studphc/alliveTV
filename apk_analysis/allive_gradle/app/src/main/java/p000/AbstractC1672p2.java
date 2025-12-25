package p000;

import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import java.util.Iterator;

/* renamed from: p2 */
/* loaded from: classes.dex */
public abstract class AbstractC1672p2 implements RangeSet {
    @Override // com.google.common.collect.RangeSet
    public void addAll(RangeSet rangeSet) {
        addAll(rangeSet.asRanges());
    }

    @Override // com.google.common.collect.RangeSet
    public void clear() {
        remove(Range.all());
    }

    @Override // com.google.common.collect.RangeSet
    public boolean contains(Comparable comparable) {
        if (rangeContaining(comparable) != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.common.collect.RangeSet
    public boolean enclosesAll(RangeSet rangeSet) {
        return enclosesAll(rangeSet.asRanges());
    }

    @Override // com.google.common.collect.RangeSet
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof RangeSet) {
            return asRanges().equals(((RangeSet) obj).asRanges());
        }
        return false;
    }

    @Override // com.google.common.collect.RangeSet
    public final int hashCode() {
        return asRanges().hashCode();
    }

    @Override // com.google.common.collect.RangeSet
    public boolean isEmpty() {
        return asRanges().isEmpty();
    }

    @Override // com.google.common.collect.RangeSet
    public void removeAll(RangeSet rangeSet) {
        removeAll(rangeSet.asRanges());
    }

    @Override // com.google.common.collect.RangeSet
    public final String toString() {
        return asRanges().toString();
    }

    @Override // com.google.common.collect.RangeSet
    public void addAll(Iterable iterable) {
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            add((Range) it.next());
        }
    }

    @Override // com.google.common.collect.RangeSet
    public boolean enclosesAll(Iterable iterable) {
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            if (!encloses((Range) it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.common.collect.RangeSet
    public void removeAll(Iterable iterable) {
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            remove((Range) it.next());
        }
    }
}
