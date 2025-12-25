package p000;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.text.Typography;

/* loaded from: classes2.dex */
public class wx2 {

    /* renamed from: b */
    public static final wx2 f28376b = new wx2(new AtomicInteger());

    /* renamed from: a */
    public final AtomicInteger f28377a;

    public wx2(AtomicInteger atomicInteger) {
        this.f28377a = atomicInteger;
    }

    /* renamed from: a */
    public final Type m8082a(Type type) {
        Type m8082a;
        Preconditions.checkNotNull(type);
        if (type instanceof Class) {
            return type;
        }
        if (type instanceof TypeVariable) {
            return type;
        }
        boolean z = type instanceof GenericArrayType;
        AtomicInteger atomicInteger = this.f28377a;
        if (z) {
            return mz2.m6268e(new wx2(atomicInteger).m8082a(((GenericArrayType) type).getGenericComponentType()));
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Class cls = (Class) parameterizedType.getRawType();
            TypeVariable[] typeParameters = cls.getTypeParameters();
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            for (int i = 0; i < actualTypeArguments.length; i++) {
                actualTypeArguments[i] = new vx2(atomicInteger, typeParameters[i]).m8082a(actualTypeArguments[i]);
            }
            wx2 wx2Var = new wx2(atomicInteger);
            Type ownerType = parameterizedType.getOwnerType();
            if (ownerType == null) {
                m8082a = null;
            } else {
                m8082a = wx2Var.m8082a(ownerType);
            }
            return mz2.m6270g(m8082a, cls, actualTypeArguments);
        }
        if (type instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) type;
            if (wildcardType.getLowerBounds().length == 0) {
                return mo7952b(wildcardType.getUpperBounds());
            }
            return type;
        }
        throw new AssertionError("must have been one of the known types");
    }

    /* renamed from: b */
    public TypeVariable mo7952b(Type[] typeArr) {
        int incrementAndGet = this.f28377a.incrementAndGet();
        String join = Joiner.m3765on(Typography.amp).join(typeArr);
        StringBuilder sb = new StringBuilder(AbstractC1726qj.m7052h(33, join));
        sb.append("capture#");
        sb.append(incrementAndGet);
        sb.append("-of ? extends ");
        sb.append(join);
        return mz2.m6269f(wx2.class, sb.toString(), typeArr);
    }
}
