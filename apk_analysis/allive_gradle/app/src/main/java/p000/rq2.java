package p000;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class rq2 implements Supplier, Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final Supplier f26114a;

    /* renamed from: b */
    public volatile transient boolean f26115b;

    /* renamed from: c */
    public transient Object f26116c;

    public rq2(Supplier supplier) {
        this.f26114a = (Supplier) Preconditions.checkNotNull(supplier);
    }

    @Override // com.google.common.base.Supplier
    public final Object get() {
        if (!this.f26115b) {
            synchronized (this) {
                try {
                    if (!this.f26115b) {
                        Object obj = this.f26114a.get();
                        this.f26116c = obj;
                        this.f26115b = true;
                        return obj;
                    }
                } finally {
                }
            }
        }
        return this.f26116c;
    }

    public final String toString() {
        Object obj;
        if (this.f26115b) {
            String valueOf = String.valueOf(this.f26116c);
            obj = AbstractC1726qj.m7059o("<supplier that returned ", valueOf, ">", valueOf.length() + 25);
        } else {
            obj = this.f26114a;
        }
        String valueOf2 = String.valueOf(obj);
        return AbstractC1726qj.m7059o("Suppliers.memoize(", valueOf2, ")", valueOf2.length() + 19);
    }
}
