package p000;

import com.google.common.base.Equivalence;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class x90 implements Predicate, Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final Equivalence f28478a;

    /* renamed from: b */
    public final Object f28479b;

    public x90(Equivalence equivalence, Object obj) {
        this.f28478a = (Equivalence) Preconditions.checkNotNull(equivalence);
        this.f28479b = obj;
    }

    @Override // com.google.common.base.Predicate
    public final boolean apply(Object obj) {
        return this.f28478a.equivalent(obj, this.f28479b);
    }

    @Override // com.google.common.base.Predicate
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x90)) {
            return false;
        }
        x90 x90Var = (x90) obj;
        if (this.f28478a.equals(x90Var.f28478a) && Objects.equal(this.f28479b, x90Var.f28479b)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.f28478a, this.f28479b);
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f28478a);
        String valueOf2 = String.valueOf(this.f28479b);
        return AbstractC1726qj.m7055k(valueOf2.length() + valueOf.length() + 15, valueOf, ".equivalentTo(", valueOf2, ")");
    }
}
