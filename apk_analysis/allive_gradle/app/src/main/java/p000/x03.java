package p000;

import com.google.common.collect.Ordering;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class x03 extends Ordering implements Serializable {

    /* renamed from: a */
    public static final x03 f28417a = new Ordering();
    private static final long serialVersionUID = 0;

    private Object readResolve() {
        return f28417a;
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return obj.toString().compareTo(obj2.toString());
    }

    public final String toString() {
        return "Ordering.usingToString()";
    }
}
