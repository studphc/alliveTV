package p000;

import com.google.common.base.Equivalence;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class z12 extends Equivalence implements Serializable {
    private static final long serialVersionUID = 1;

    /* renamed from: a */
    public final Equivalence f29219a;

    public z12(Equivalence equivalence) {
        this.f29219a = (Equivalence) Preconditions.checkNotNull(equivalence);
    }

    @Override // com.google.common.base.Equivalence
    public final boolean doEquivalent(Object obj, Object obj2) {
        Iterator it = ((Iterable) obj).iterator();
        Iterator it2 = ((Iterable) obj2).iterator();
        while (it.hasNext() && it2.hasNext()) {
            if (!this.f29219a.equivalent(it.next(), it2.next())) {
                return false;
            }
        }
        if (it.hasNext() || it2.hasNext()) {
            return false;
        }
        return true;
    }

    @Override // com.google.common.base.Equivalence
    public final int doHash(Object obj) {
        Iterator it = ((Iterable) obj).iterator();
        int i = 78721;
        while (it.hasNext()) {
            i = (i * 24943) + this.f29219a.hash(it.next());
        }
        return i;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof z12) {
            return this.f29219a.equals(((z12) obj).f29219a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f29219a.hashCode() ^ 1185147655;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f29219a);
        return AbstractC1726qj.m7054j(valueOf.length() + 11, valueOf, ".pairwise()");
    }
}
