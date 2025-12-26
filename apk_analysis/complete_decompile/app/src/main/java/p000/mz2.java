package p000;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.reflect.Reflection;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public abstract class mz2 {

    /* renamed from: a */
    public static final Joiner f23181a = Joiner.m3766on(", ").useForNull("null");

    /* renamed from: a */
    public static Type m6264a(Type[] typeArr) {
        for (Type type : typeArr) {
            Type m6267d = m6267d(type);
            if (m6267d != null) {
                if (m6267d instanceof Class) {
                    Class cls = (Class) m6267d;
                    if (cls.isPrimitive()) {
                        return cls;
                    }
                }
                return new lz2(new Type[0], new Type[]{m6267d});
            }
        }
        return null;
    }

    /* renamed from: b */
    public static void m6265b(Type[] typeArr, String str) {
        for (Type type : typeArr) {
            if (type instanceof Class) {
                Preconditions.checkArgument(!r2.isPrimitive(), "Primitive type '%s' used as %s", (Class) type, str);
            }
        }
    }

    /* renamed from: c */
    public static Type[] m6266c(Collection collection) {
        return (Type[]) collection.toArray(new Type[0]);
    }

    /* renamed from: d */
    public static Type m6267d(Type type) {
        Preconditions.checkNotNull(type);
        AtomicReference atomicReference = new AtomicReference();
        new rx2(atomicReference, 2).m4943c(type);
        return (Type) atomicReference.get();
    }

    /* renamed from: e */
    public static Type m6268e(Type type) {
        boolean z;
        boolean z2;
        if (type instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) type;
            Type[] lowerBounds = wildcardType.getLowerBounds();
            if (lowerBounds.length <= 1) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "Wildcard cannot have more than one lower bounds.");
            if (lowerBounds.length == 1) {
                return new lz2(new Type[]{m6268e(lowerBounds[0])}, new Type[]{Object.class});
            }
            Type[] upperBounds = wildcardType.getUpperBounds();
            if (upperBounds.length == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            Preconditions.checkArgument(z2, "Wildcard should have only one upper bound.");
            return new lz2(new Type[0], new Type[]{m6268e(upperBounds[0])});
        }
        return gz2.f17893c.mo2179a(type);
    }

    /* renamed from: f */
    public static TypeVariable m6269f(GenericDeclaration genericDeclaration, String str, Type... typeArr) {
        if (typeArr.length == 0) {
            typeArr = new Type[]{Object.class};
        }
        return (TypeVariable) Reflection.newProxy(TypeVariable.class, new kz2(new jz2(genericDeclaration, str, typeArr)));
    }

    /* renamed from: g */
    public static iz2 m6270g(Type type, Class cls, Type... typeArr) {
        boolean z;
        if (type == null) {
            return new iz2(zy2.f29573a.mo8083a(cls), cls, typeArr);
        }
        Preconditions.checkNotNull(typeArr);
        if (cls.getEnclosingClass() != null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "Owner type for unenclosed %s", cls);
        return new iz2(type, cls, typeArr);
    }
}
