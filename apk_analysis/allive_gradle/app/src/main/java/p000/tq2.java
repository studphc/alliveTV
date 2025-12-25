package p000;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class tq2 implements Supplier, Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final Function f26939a;

    /* renamed from: b */
    public final Supplier f26940b;

    public tq2(Function function, Supplier supplier) {
        this.f26939a = (Function) Preconditions.checkNotNull(function);
        this.f26940b = (Supplier) Preconditions.checkNotNull(supplier);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof tq2)) {
            return false;
        }
        tq2 tq2Var = (tq2) obj;
        if (!this.f26939a.equals(tq2Var.f26939a) || !this.f26940b.equals(tq2Var.f26940b)) {
            return false;
        }
        return true;
    }

    @Override // com.google.common.base.Supplier
    public final Object get() {
        return this.f26939a.apply(this.f26940b.get());
    }

    public final int hashCode() {
        return Objects.hashCode(this.f26939a, this.f26940b);
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f26939a);
        String valueOf2 = String.valueOf(this.f26940b);
        StringBuilder m7062r = AbstractC1726qj.m7062r(valueOf2.length() + valueOf.length() + 21, "Suppliers.compose(", valueOf, ", ", valueOf2);
        m7062r.append(")");
        return m7062r.toString();
    }
}
