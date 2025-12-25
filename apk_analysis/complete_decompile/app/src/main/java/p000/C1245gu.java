package p000;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

/* renamed from: gu */
/* loaded from: classes.dex */
public final class C1245gu extends Ordering implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final Comparator[] f17839a;

    public C1245gu(Ordering ordering, Comparator comparator) {
        this.f17839a = new Comparator[]{ordering, comparator};
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int i = 0;
        while (true) {
            Comparator[] comparatorArr = this.f17839a;
            if (i >= comparatorArr.length) {
                return 0;
            }
            int compare = comparatorArr[i].compare(obj, obj2);
            if (compare != 0) {
                return compare;
            }
            i++;
        }
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C1245gu) {
            return Arrays.equals(this.f17839a, ((C1245gu) obj).f17839a);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f17839a);
    }

    public final String toString() {
        String arrays = Arrays.toString(this.f17839a);
        return AbstractC1726qj.m7059o("Ordering.compound(", arrays, ")", AbstractC1726qj.m7052h(19, arrays));
    }

    public C1245gu(Iterable iterable) {
        Collection newArrayList;
        Comparator[] comparatorArr = new Comparator[0];
        if (iterable instanceof Collection) {
            newArrayList = (Collection) iterable;
        } else {
            newArrayList = Lists.newArrayList(iterable.iterator());
        }
        this.f17839a = (Comparator[]) newArrayList.toArray(comparatorArr);
    }
}
