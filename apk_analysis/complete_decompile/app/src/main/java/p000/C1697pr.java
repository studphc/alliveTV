package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.Ordering;
import java.io.Serializable;
import java.util.Comparator;

/* renamed from: pr */
/* loaded from: classes.dex */
public final class C1697pr extends Ordering implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final Comparator f25264a;

    public C1697pr(Comparator comparator) {
        this.f25264a = (Comparator) Preconditions.checkNotNull(comparator);
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return this.f25264a.compare(obj, obj2);
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C1697pr) {
            return this.f25264a.equals(((C1697pr) obj).f25264a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f25264a.hashCode();
    }

    public final String toString() {
        return this.f25264a.toString();
    }
}
