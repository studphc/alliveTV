package p000;

import com.google.common.collect.ImmutableMap;
import com.google.common.reflect.TypeResolver;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class tx2 {

    /* renamed from: a */
    public final ImmutableMap f27016a;

    public tx2() {
        this.f27016a = ImmutableMap.m3923of();
    }

    /* renamed from: a */
    public Type mo7423a(TypeVariable typeVariable, sx2 sx2Var) {
        Type type = (Type) this.f27016a.get(new ux2(typeVariable));
        if (type == null) {
            Type[] bounds = typeVariable.getBounds();
            if (bounds.length == 0) {
                return typeVariable;
            }
            Type[] m4286b = new TypeResolver(sx2Var).m4286b(bounds);
            if (hz2.f18230a && Arrays.equals(bounds, m4286b)) {
                return typeVariable;
            }
            return mz2.m6269f(typeVariable.getGenericDeclaration(), typeVariable.getName(), m4286b);
        }
        return new TypeResolver(sx2Var).resolveType(type);
    }

    public tx2(ImmutableMap immutableMap) {
        this.f27016a = immutableMap;
    }
}
