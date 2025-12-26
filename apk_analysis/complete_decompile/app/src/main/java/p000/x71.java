package p000;

import com.google.common.collect.Ordering;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class x71 extends Ordering implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final Comparator f28455a;

    public x71(Comparator comparator) {
        this.f28455a = comparator;
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        Iterator it = ((Iterable) obj).iterator();
        Iterator it2 = ((Iterable) obj2).iterator();
        while (it.hasNext()) {
            if (!it2.hasNext()) {
                return 1;
            }
            int compare = this.f28455a.compare(it.next(), it2.next());
            if (compare != 0) {
                return compare;
            }
        }
        if (it2.hasNext()) {
            return -1;
        }
        return 0;
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof x71) {
            return this.f28455a.equals(((x71) obj).f28455a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f28455a.hashCode() ^ 2075626741;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f28455a);
        return AbstractC1726qj.m7054j(valueOf.length() + 18, valueOf, ".lexicographical()");
    }
}
