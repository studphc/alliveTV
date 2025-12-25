package p000;

import com.google.common.base.Objects;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public final class dq2 {

    /* renamed from: a */
    public final String f16491a;

    /* renamed from: b */
    public final List f16492b;

    public dq2(Method method) {
        this.f16491a = method.getName();
        this.f16492b = Arrays.asList(method.getParameterTypes());
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof dq2)) {
            return false;
        }
        dq2 dq2Var = (dq2) obj;
        if (!this.f16491a.equals(dq2Var.f16491a) || !this.f16492b.equals(dq2Var.f16492b)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hashCode(this.f16491a, this.f16492b);
    }
}
