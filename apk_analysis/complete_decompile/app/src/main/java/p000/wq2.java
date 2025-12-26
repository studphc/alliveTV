package p000;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class wq2 implements Supplier, Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final Supplier f28296a;

    public wq2(Supplier supplier) {
        this.f28296a = (Supplier) Preconditions.checkNotNull(supplier);
    }

    @Override // com.google.common.base.Supplier
    public final Object get() {
        Object obj;
        synchronized (this.f28296a) {
            obj = this.f28296a.get();
        }
        return obj;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f28296a);
        return AbstractC1726qj.m7059o("Suppliers.synchronizedSupplier(", valueOf, ")", valueOf.length() + 32);
    }
}
