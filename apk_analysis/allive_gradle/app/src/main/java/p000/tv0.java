package p000;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class tv0 implements Function, Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final Supplier f26973a;

    public tv0(Supplier supplier) {
        this.f26973a = (Supplier) Preconditions.checkNotNull(supplier);
    }

    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        return this.f26973a.get();
    }

    @Override // com.google.common.base.Function
    public final boolean equals(Object obj) {
        if (obj instanceof tv0) {
            return this.f26973a.equals(((tv0) obj).f26973a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f26973a.hashCode();
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f26973a);
        return AbstractC1726qj.m7059o("Functions.forSupplier(", valueOf, ")", valueOf.length() + 23);
    }
}
