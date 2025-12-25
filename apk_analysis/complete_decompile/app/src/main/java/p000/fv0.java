package p000;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class fv0 implements Function, Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final Object f17410a;

    public fv0(Object obj) {
        this.f17410a = obj;
    }

    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        return this.f17410a;
    }

    @Override // com.google.common.base.Function
    public final boolean equals(Object obj) {
        if (obj instanceof fv0) {
            return Objects.equal(this.f17410a, ((fv0) obj).f17410a);
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.f17410a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f17410a);
        return AbstractC1726qj.m7059o("Functions.constant(", valueOf, ")", valueOf.length() + 20);
    }
}
