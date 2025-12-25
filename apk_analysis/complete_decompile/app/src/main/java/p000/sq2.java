package p000;

import com.google.common.base.Supplier;
import java.util.Objects;

/* loaded from: classes.dex */
public final class sq2 implements Supplier {

    /* renamed from: a */
    public volatile Supplier f26535a;

    /* renamed from: b */
    public volatile boolean f26536b;

    /* renamed from: c */
    public Object f26537c;

    @Override // com.google.common.base.Supplier
    public final Object get() {
        if (!this.f26536b) {
            synchronized (this) {
                try {
                    if (!this.f26536b) {
                        Supplier supplier = this.f26535a;
                        Objects.requireNonNull(supplier);
                        Object obj = supplier.get();
                        this.f26537c = obj;
                        this.f26536b = true;
                        this.f26535a = null;
                        return obj;
                    }
                } finally {
                }
            }
        }
        return this.f26537c;
    }

    public final String toString() {
        Object obj = this.f26535a;
        if (obj == null) {
            String valueOf = String.valueOf(this.f26537c);
            obj = AbstractC1726qj.m7059o("<supplier that returned ", valueOf, ">", valueOf.length() + 25);
        }
        String valueOf2 = String.valueOf(obj);
        return AbstractC1726qj.m7059o("Suppliers.memoize(", valueOf2, ")", valueOf2.length() + 19);
    }
}
