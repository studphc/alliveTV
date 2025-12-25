package p000;

import com.google.common.base.Objects;
import com.google.common.base.Supplier;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class vq2 implements Supplier, Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final Object f27930a;

    public vq2(Object obj) {
        this.f27930a = obj;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof vq2) {
            return Objects.equal(this.f27930a, ((vq2) obj).f27930a);
        }
        return false;
    }

    @Override // com.google.common.base.Supplier
    public final Object get() {
        return this.f27930a;
    }

    public final int hashCode() {
        return Objects.hashCode(this.f27930a);
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f27930a);
        return AbstractC1726qj.m7059o("Suppliers.ofInstance(", valueOf, ")", valueOf.length() + 22);
    }
}
