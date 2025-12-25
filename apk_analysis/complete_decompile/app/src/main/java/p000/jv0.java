package p000;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Map;

/* loaded from: classes.dex */
public final class jv0 implements Function, Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final Map f20644a;

    /* renamed from: b */
    public final Object f20645b;

    public jv0(Map map, Object obj) {
        this.f20644a = (Map) Preconditions.checkNotNull(map);
        this.f20645b = obj;
    }

    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        Map map = this.f20644a;
        Object obj2 = map.get(obj);
        if (obj2 == null && !map.containsKey(obj)) {
            return this.f20645b;
        }
        return obj2;
    }

    @Override // com.google.common.base.Function
    public final boolean equals(Object obj) {
        if (!(obj instanceof jv0)) {
            return false;
        }
        jv0 jv0Var = (jv0) obj;
        if (!this.f20644a.equals(jv0Var.f20644a) || !Objects.equal(this.f20645b, jv0Var.f20645b)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hashCode(this.f20644a, this.f20645b);
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f20644a);
        String valueOf2 = String.valueOf(this.f20645b);
        StringBuilder m7062r = AbstractC1726qj.m7062r(valueOf2.length() + valueOf.length() + 33, "Functions.forMap(", valueOf, ", defaultValue=", valueOf2);
        m7062r.append(")");
        return m7062r.toString();
    }
}
