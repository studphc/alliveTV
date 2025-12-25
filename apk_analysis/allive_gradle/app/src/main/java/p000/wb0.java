package p000;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes.dex */
public final class wb0 extends Ordering implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final ImmutableMap f28125a;

    public wb0(List list) {
        this.f28125a = Maps.m4049e(list);
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        ImmutableMap immutableMap = this.f28125a;
        Integer num = (Integer) immutableMap.get(obj);
        if (num != null) {
            int intValue = num.intValue();
            Integer num2 = (Integer) immutableMap.get(obj2);
            if (num2 != null) {
                return intValue - num2.intValue();
            }
            throw new n12(obj2);
        }
        throw new n12(obj);
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (obj instanceof wb0) {
            return this.f28125a.equals(((wb0) obj).f28125a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f28125a.hashCode();
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f28125a.keySet());
        return AbstractC1726qj.m7059o("Ordering.explicit(", valueOf, ")", valueOf.length() + 19);
    }
}
