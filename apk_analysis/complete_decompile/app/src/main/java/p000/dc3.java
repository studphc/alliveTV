package p000;

import android.content.Context;
import com.google.common.base.Supplier;

/* loaded from: classes.dex */
public final class dc3 {

    /* renamed from: a */
    public final Context f16344a;

    /* renamed from: b */
    public final Supplier f16345b;

    public dc3(Context context, Supplier supplier) {
        this.f16344a = context;
        this.f16345b = supplier;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof dc3) {
            dc3 dc3Var = (dc3) obj;
            if (this.f16344a.equals(dc3Var.f16344a)) {
                Supplier supplier = dc3Var.f16345b;
                Supplier supplier2 = this.f16345b;
                if (supplier2 != null ? supplier2.equals(supplier) : supplier == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2 = this.f16344a.hashCode() ^ 1000003;
        Supplier supplier = this.f16345b;
        if (supplier == null) {
            hashCode = 0;
        } else {
            hashCode = supplier.hashCode();
        }
        return (hashCode2 * 1000003) ^ hashCode;
    }

    public final String toString() {
        return "FlagsContext{context=" + this.f16344a.toString() + ", hermeticFileOverrides=" + String.valueOf(this.f16345b) + "}";
    }
}
