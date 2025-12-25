package p000;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class kv0 implements Function, Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final Function f22213a;

    /* renamed from: b */
    public final Function f22214b;

    public kv0(Function function, Function function2) {
        this.f22213a = (Function) Preconditions.checkNotNull(function);
        this.f22214b = (Function) Preconditions.checkNotNull(function2);
    }

    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        return this.f22213a.apply(this.f22214b.apply(obj));
    }

    @Override // com.google.common.base.Function
    public final boolean equals(Object obj) {
        if (!(obj instanceof kv0)) {
            return false;
        }
        kv0 kv0Var = (kv0) obj;
        if (!this.f22214b.equals(kv0Var.f22214b) || !this.f22213a.equals(kv0Var.f22213a)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.f22214b.hashCode() ^ this.f22213a.hashCode();
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f22213a);
        String valueOf2 = String.valueOf(this.f22214b);
        return AbstractC1726qj.m7055k(valueOf2.length() + valueOf.length() + 2, valueOf, "(", valueOf2, ")");
    }
}
