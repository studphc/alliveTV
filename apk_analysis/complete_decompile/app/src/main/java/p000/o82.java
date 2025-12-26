package p000;

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;
import com.google.common.collect.Range;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class o82 extends Ordering implements Serializable {

    /* renamed from: a */
    public static final o82 f23661a = new Ordering();
    private static final long serialVersionUID = 0;

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        Range range = (Range) obj;
        Range range2 = (Range) obj2;
        return ComparisonChain.start().compare(range.f14747a, range2.f14747a).compare(range.f14748b, range2.f14748b).result();
    }
}
