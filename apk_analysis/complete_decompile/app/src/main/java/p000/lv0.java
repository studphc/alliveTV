package p000;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Map;

/* loaded from: classes.dex */
public final class lv0 implements Function, Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final Map f22676a;

    public lv0(Map map) {
        this.f22676a = (Map) Preconditions.checkNotNull(map);
    }

    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        boolean z;
        Map map = this.f22676a;
        Object obj2 = map.get(obj);
        if (obj2 == null && !map.containsKey(obj)) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z, "Key '%s' not present in map", obj);
        return obj2;
    }

    @Override // com.google.common.base.Function
    public final boolean equals(Object obj) {
        if (obj instanceof lv0) {
            return this.f22676a.equals(((lv0) obj).f22676a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f22676a.hashCode();
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f22676a);
        return AbstractC1726qj.m7059o("Functions.forMap(", valueOf, ")", valueOf.length() + 18);
    }
}
