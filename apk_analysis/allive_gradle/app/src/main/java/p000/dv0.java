package p000;

import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class dv0 extends Equivalence implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final Function f16557a;

    /* renamed from: b */
    public final Equivalence f16558b;

    public dv0(Function function, Equivalence equivalence) {
        this.f16557a = (Function) Preconditions.checkNotNull(function);
        this.f16558b = (Equivalence) Preconditions.checkNotNull(equivalence);
    }

    @Override // com.google.common.base.Equivalence
    public final boolean doEquivalent(Object obj, Object obj2) {
        Function function = this.f16557a;
        return this.f16558b.equivalent(function.apply(obj), function.apply(obj2));
    }

    @Override // com.google.common.base.Equivalence
    public final int doHash(Object obj) {
        return this.f16558b.hash(this.f16557a.apply(obj));
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof dv0)) {
            return false;
        }
        dv0 dv0Var = (dv0) obj;
        if (this.f16557a.equals(dv0Var.f16557a) && this.f16558b.equals(dv0Var.f16558b)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.f16557a, this.f16558b);
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f16558b);
        String valueOf2 = String.valueOf(this.f16557a);
        return AbstractC1726qj.m7055k(valueOf2.length() + valueOf.length() + 13, valueOf, ".onResultOf(", valueOf2, ")");
    }
}
