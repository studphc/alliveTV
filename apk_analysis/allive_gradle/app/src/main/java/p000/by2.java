package p000;

import com.google.common.collect.ImmutableList;
import com.google.common.reflect.TypeToken;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class by2 extends ey2 {

    /* renamed from: c */
    public final /* synthetic */ int f8189c;

    public /* synthetic */ by2(int i) {
        this.f8189c = i;
    }

    @Override // p000.ey2
    /* renamed from: c */
    public final Iterable mo2175c(Object obj) {
        switch (this.f8189c) {
            case 0:
                TypeToken typeToken = (TypeToken) obj;
                Type type = typeToken.f15237a;
                if (type instanceof TypeVariable) {
                    return TypeToken.m4289b(((TypeVariable) type).getBounds());
                }
                if (type instanceof WildcardType) {
                    return TypeToken.m4289b(((WildcardType) type).getUpperBounds());
                }
                ImmutableList.Builder builder = ImmutableList.builder();
                for (Type type2 : typeToken.getRawType().getGenericInterfaces()) {
                    builder.add((ImmutableList.Builder) typeToken.m4300j(type2));
                }
                return builder.build();
            default:
                return Arrays.asList(((Class) obj).getInterfaces());
        }
    }

    @Override // p000.ey2
    /* renamed from: d */
    public final Class mo2176d(Object obj) {
        switch (this.f8189c) {
            case 0:
                return ((TypeToken) obj).getRawType();
            default:
                return (Class) obj;
        }
    }

    @Override // p000.ey2
    /* renamed from: e */
    public final Object mo2177e(Object obj) {
        TypeToken<?> m4294of;
        switch (this.f8189c) {
            case 0:
                TypeToken typeToken = (TypeToken) obj;
                Type type = typeToken.f15237a;
                if (type instanceof TypeVariable) {
                    m4294of = TypeToken.m4294of(((TypeVariable) type).getBounds()[0]);
                    if (m4294of.getRawType().isInterface()) {
                        return null;
                    }
                } else if (type instanceof WildcardType) {
                    m4294of = TypeToken.m4294of(((WildcardType) type).getUpperBounds()[0]);
                    if (m4294of.getRawType().isInterface()) {
                        return null;
                    }
                } else {
                    Type genericSuperclass = typeToken.getRawType().getGenericSuperclass();
                    if (genericSuperclass == null) {
                        return null;
                    }
                    return typeToken.m4300j(genericSuperclass);
                }
                return m4294of;
            default:
                return ((Class) obj).getSuperclass();
        }
    }
}
