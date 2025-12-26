package p000;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import java.io.Serializable;
import java.util.List;

/* renamed from: t7 */
/* loaded from: classes.dex */
public final class C1825t7 extends Ordering implements Serializable {

    /* renamed from: a */
    public static final C1825t7 f26711a = new Ordering();
    private static final long serialVersionUID = 0;

    private Object readResolve() {
        return f26711a;
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return 0;
    }

    @Override // com.google.common.collect.Ordering
    public final ImmutableList immutableSortedCopy(Iterable iterable) {
        return ImmutableList.copyOf(iterable);
    }

    @Override // com.google.common.collect.Ordering
    public final List sortedCopy(Iterable iterable) {
        return Lists.newArrayList(iterable);
    }

    public final String toString() {
        return "Ordering.allEqual()";
    }

    @Override // com.google.common.collect.Ordering
    public final Ordering reverse() {
        return this;
    }
}
