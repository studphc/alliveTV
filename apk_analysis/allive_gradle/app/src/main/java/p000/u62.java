package p000;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class u62 implements Predicate, Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final Predicate f27127a;

    /* renamed from: b */
    public final Function f27128b;

    public u62(Predicate predicate, Function function) {
        this.f27127a = (Predicate) Preconditions.checkNotNull(predicate);
        this.f27128b = (Function) Preconditions.checkNotNull(function);
    }

    @Override // com.google.common.base.Predicate
    public final boolean apply(Object obj) {
        return this.f27127a.apply(this.f27128b.apply(obj));
    }

    @Override // com.google.common.base.Predicate
    public final boolean equals(Object obj) {
        if (!(obj instanceof u62)) {
            return false;
        }
        u62 u62Var = (u62) obj;
        if (!this.f27128b.equals(u62Var.f27128b) || !this.f27127a.equals(u62Var.f27127a)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.f27128b.hashCode() ^ this.f27127a.hashCode();
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f27127a);
        String valueOf2 = String.valueOf(this.f27128b);
        return AbstractC1726qj.m7055k(valueOf2.length() + valueOf.length() + 2, valueOf, "(", valueOf2, ")");
    }
}
