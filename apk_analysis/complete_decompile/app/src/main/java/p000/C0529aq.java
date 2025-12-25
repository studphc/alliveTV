package p000;

import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.math.IntMath;
import java.util.AbstractCollection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* renamed from: aq */
/* loaded from: classes.dex */
public final class C0529aq extends AbstractCollection {

    /* renamed from: a */
    public final ImmutableList f7699a;

    /* renamed from: b */
    public final Comparator f7700b;

    /* renamed from: c */
    public final int f7701c;

    public C0529aq(Iterable iterable, Comparator comparator) {
        int saturatedMultiply;
        ImmutableList sortedCopyOf = ImmutableList.sortedCopyOf(comparator, iterable);
        this.f7699a = sortedCopyOf;
        this.f7700b = comparator;
        int i = 1;
        int i2 = 1;
        int i3 = 1;
        while (true) {
            if (i < sortedCopyOf.size()) {
                if (comparator.compare(sortedCopyOf.get(i - 1), sortedCopyOf.get(i)) < 0) {
                    i2 = IntMath.saturatedMultiply(i2, IntMath.binomial(i, i3));
                    saturatedMultiply = Integer.MAX_VALUE;
                    if (i2 == Integer.MAX_VALUE) {
                        break;
                    } else {
                        i3 = 0;
                    }
                }
                i++;
                i3++;
            } else {
                saturatedMultiply = IntMath.saturatedMultiply(i2, IntMath.binomial(i, i3));
                break;
            }
        }
        this.f7701c = saturatedMultiply;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof List) {
            return Collections2.m3834a(this.f7699a, (List) obj);
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new C0566bq(this.f7699a, this.f7700b);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.f7701c;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        String valueOf = String.valueOf(this.f7699a);
        return AbstractC1726qj.m7059o("orderedPermutationCollection(", valueOf, ")", valueOf.length() + 30);
    }
}
