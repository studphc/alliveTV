package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ForwardingSet;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.primitives.Primitives;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;
import p000.AbstractC1726qj;
import p000.ey2;
import p000.gz2;
import p000.hy2;
import p000.lz2;
import p000.mz2;
import p000.px2;
import p000.rx2;
import p000.ux2;
import p000.wx2;
import p000.xx2;
import p000.yx2;
import p000.zx2;

/* loaded from: classes2.dex */
public abstract class TypeToken<T> extends px2 implements Serializable {
    private static final long serialVersionUID = 3637540370352322684L;

    /* renamed from: a */
    public final Type f15237a;

    /* renamed from: b */
    public transient TypeResolver f15238b;

    /* renamed from: c */
    public transient TypeResolver f15239c;

    public TypeToken() {
        Type m6934a = m6934a();
        this.f15237a = m6934a;
        Preconditions.checkState(!(m6934a instanceof TypeVariable), "Cannot construct a TypeToken for a type variable.\nYou probably meant to call new TypeToken<%s>(getClass()) that can resolve the type variable for you.\nIf you do need to create a TypeToken of a type variable, please use TypeToken.of() instead.", m6934a);
    }

    /* renamed from: b */
    public static ImmutableList m4289b(Type[] typeArr) {
        ImmutableList.Builder builder = ImmutableList.builder();
        for (Type type : typeArr) {
            TypeToken<?> m4294of = m4294of(type);
            if (m4294of.getRawType().isInterface()) {
                builder.add((ImmutableList.Builder) m4294of);
            }
        }
        return builder.build();
    }

    /* renamed from: c */
    public static lz2 m4290c(TypeVariable typeVariable, WildcardType wildcardType) {
        boolean z;
        Type[] bounds = typeVariable.getBounds();
        ArrayList arrayList = new ArrayList();
        for (Type type : wildcardType.getUpperBounds()) {
            int length = bounds.length;
            int i = 0;
            while (true) {
                z = true;
                if (i >= length) {
                    z = !true;
                    break;
                }
                if (m4294of(bounds[i]).isSubtypeOf(type)) {
                    break;
                }
                i++;
            }
            if (!z) {
                arrayList.add(m4291d(type));
            }
        }
        return new lz2(wildcardType.getLowerBounds(), (Type[]) arrayList.toArray(new Type[0]));
    }

    /* renamed from: d */
    public static Type m4291d(Type type) {
        Type m4291d;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Class cls = (Class) parameterizedType.getRawType();
            TypeVariable<Class<T>>[] typeParameters = cls.getTypeParameters();
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            for (int i = 0; i < actualTypeArguments.length; i++) {
                TypeVariable<Class<T>> typeVariable = typeParameters[i];
                Type type2 = actualTypeArguments[i];
                if (type2 instanceof WildcardType) {
                    m4291d = m4290c(typeVariable, (WildcardType) type2);
                } else {
                    m4291d = m4291d(type2);
                }
                actualTypeArguments[i] = m4291d;
            }
            return mz2.m6270g(parameterizedType.getOwnerType(), cls, actualTypeArguments);
        }
        if (type instanceof GenericArrayType) {
            return mz2.m6268e(m4291d(((GenericArrayType) type).getGenericComponentType()));
        }
        return type;
    }

    /* renamed from: l */
    public static TypeToken m4292l(Class cls) {
        Type type;
        if (cls.isArray()) {
            return m4294of(mz2.m6268e(m4292l(cls.getComponentType()).f15237a));
        }
        TypeVariable<Class<T>>[] typeParameters = cls.getTypeParameters();
        if (cls.isMemberClass() && !Modifier.isStatic(cls.getModifiers())) {
            type = m4292l(cls.getEnclosingClass()).f15237a;
        } else {
            type = null;
        }
        if (typeParameters.length <= 0 && (type == null || type == cls.getEnclosingClass())) {
            return m4293of(cls);
        }
        return m4294of(mz2.m6270g(type, cls, typeParameters));
    }

    /* renamed from: of */
    public static <T> TypeToken<T> m4293of(Class<T> cls) {
        return new TypeToken<>(cls);
    }

    @Beta
    public final Invokable<T, T> constructor(Constructor<?> constructor) {
        boolean z;
        if (constructor.getDeclaringClass() == getRawType()) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "%s not declared by %s", constructor, getRawType());
        return new yx2(this, constructor);
    }

    /* renamed from: e */
    public final TypeResolver m4295e() {
        TypeResolver typeResolver = this.f15239c;
        if (typeResolver == null) {
            TypeResolver typeResolver2 = new TypeResolver();
            Type type = this.f15237a;
            Preconditions.checkNotNull(type);
            rx2 rx2Var = new rx2();
            rx2Var.m4943c(type);
            TypeResolver m4288d = typeResolver2.m4288d(ImmutableMap.copyOf((Map) rx2Var.f26179c));
            this.f15239c = m4288d;
            return m4288d;
        }
        return typeResolver;
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj instanceof TypeToken) {
            return this.f15237a.equals(((TypeToken) obj).f15237a);
        }
        return false;
    }

    /* renamed from: f */
    public final TypeResolver m4296f() {
        TypeResolver typeResolver = this.f15238b;
        if (typeResolver == null) {
            Type m8082a = wx2.f28376b.m8082a(this.f15237a);
            TypeResolver typeResolver2 = new TypeResolver();
            Preconditions.checkNotNull(m8082a);
            rx2 rx2Var = new rx2();
            rx2Var.m4943c(m8082a);
            TypeResolver m4288d = typeResolver2.m4288d(ImmutableMap.copyOf((Map) rx2Var.f26179c));
            this.f15238b = m4288d;
            return m4288d;
        }
        return typeResolver;
    }

    /* renamed from: g */
    public final ImmutableSet m4297g() {
        ImmutableSet.Builder builder = ImmutableSet.builder();
        new zx2(builder).m4943c(this.f15237a);
        return builder.build();
    }

    @CheckForNull
    public final TypeToken<?> getComponentType() {
        Type m6267d = mz2.m6267d(this.f15237a);
        if (m6267d == null) {
            return null;
        }
        return m4294of(m6267d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Class<? super T> getRawType() {
        return (Class) m4297g().iterator().next();
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a7, code lost:
    
        if (getRawType().getTypeParameters().length != 0) goto L26;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.reflect.Type] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final TypeToken<? extends T> getSubtype(Class<?> cls) {
        Class<?> cls2;
        Type type = this.f15237a;
        Preconditions.checkArgument(!(type instanceof TypeVariable), "Cannot get subtype of type variable <%s>", this);
        if (type instanceof WildcardType) {
            Type[] lowerBounds = ((WildcardType) type).getLowerBounds();
            if (lowerBounds.length > 0) {
                return (TypeToken<? extends T>) m4294of(lowerBounds[0]).getSubtype(cls);
            }
            String valueOf = String.valueOf(cls);
            String valueOf2 = String.valueOf(this);
            throw new IllegalArgumentException(AbstractC1726qj.m7059o(valueOf, " isn't a subclass of ", valueOf2, valueOf2.length() + valueOf.length() + 21));
        }
        if (isArray()) {
            Class<?> componentType = cls.getComponentType();
            if (componentType != null) {
                TypeToken<?> componentType2 = getComponentType();
                Objects.requireNonNull(componentType2);
                return (TypeToken<? extends T>) m4294of(gz2.f17891a.mo2179a(componentType2.getSubtype(componentType).f15237a));
            }
            String valueOf3 = String.valueOf(cls);
            String valueOf4 = String.valueOf(this);
            throw new IllegalArgumentException(AbstractC1726qj.m7059o(valueOf3, " does not appear to be a subtype of ", valueOf4, valueOf4.length() + valueOf3.length() + 36));
        }
        Preconditions.checkArgument(getRawType().isAssignableFrom(cls), "%s isn't a subclass of %s", cls, this);
        if (type instanceof Class) {
            int length = cls.getTypeParameters().length;
            cls2 = cls;
            if (length != 0) {
                cls2 = cls;
            }
            TypeToken<? extends T> typeToken = (TypeToken<? extends T>) m4294of((Type) cls2);
            Preconditions.checkArgument(typeToken.isSubtypeOf((TypeToken<?>) this), "%s does not appear to be a subtype of %s", typeToken, this);
            return typeToken;
        }
        TypeToken m4292l = m4292l(cls);
        cls2 = new TypeResolver().where(m4292l.getSupertype(getRawType()).f15237a, type).resolveType(m4292l.f15237a);
        TypeToken<? extends T> typeToken2 = (TypeToken<? extends T>) m4294of((Type) cls2);
        Preconditions.checkArgument(typeToken2.isSubtypeOf((TypeToken<?>) this), "%s does not appear to be a subtype of %s", typeToken2, this);
        return typeToken2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final TypeToken<? super T> getSupertype(Class<? super T> cls) {
        Preconditions.checkArgument(m4301k(cls), "%s is not a super class of %s", cls, this);
        Type type = this.f15237a;
        if (type instanceof TypeVariable) {
            return m4298h(cls, ((TypeVariable) type).getBounds());
        }
        if (type instanceof WildcardType) {
            return m4298h(cls, ((WildcardType) type).getUpperBounds());
        }
        if (cls.isArray()) {
            TypeToken<?> componentType = getComponentType();
            if (componentType != 0) {
                Class<?> componentType2 = cls.getComponentType();
                Objects.requireNonNull(componentType2);
                return (TypeToken<? super T>) m4294of(gz2.f17891a.mo2179a(componentType.getSupertype(componentType2).f15237a));
            }
            String valueOf = String.valueOf(cls);
            String valueOf2 = String.valueOf(this);
            throw new IllegalArgumentException(AbstractC1726qj.m7059o(valueOf, " isn't a super type of ", valueOf2, valueOf2.length() + valueOf.length() + 23));
        }
        return m4300j(m4292l(cls).f15237a);
    }

    public final Type getType() {
        return this.f15237a;
    }

    public final TypeToken<T>.TypeSet getTypes() {
        return new TypeSet();
    }

    /* renamed from: h */
    public final TypeToken m4298h(Class cls, Type[] typeArr) {
        for (Type type : typeArr) {
            TypeToken<?> m4294of = m4294of(type);
            if (m4294of.isSubtypeOf(cls)) {
                return m4294of.getSupertype(cls);
            }
        }
        String valueOf = String.valueOf(cls);
        String valueOf2 = String.valueOf(this);
        throw new IllegalArgumentException(AbstractC1726qj.m7059o(valueOf, " isn't a super type of ", valueOf2, valueOf2.length() + valueOf.length() + 23));
    }

    public int hashCode() {
        return this.f15237a.hashCode();
    }

    /* renamed from: i */
    public final void m4299i() {
        new rx2(this, 1).m4943c(this.f15237a);
    }

    public final boolean isArray() {
        if (getComponentType() != null) {
            return true;
        }
        return false;
    }

    public final boolean isPrimitive() {
        Type type = this.f15237a;
        if ((type instanceof Class) && ((Class) type).isPrimitive()) {
            return true;
        }
        return false;
    }

    public final boolean isSubtypeOf(TypeToken<?> typeToken) {
        return isSubtypeOf(typeToken.getType());
    }

    public final boolean isSupertypeOf(TypeToken<?> typeToken) {
        return typeToken.isSubtypeOf(getType());
    }

    /* renamed from: j */
    public final TypeToken m4300j(Type type) {
        TypeToken<?> m4294of = m4294of(m4295e().resolveType(type));
        m4294of.f15239c = this.f15239c;
        m4294of.f15238b = this.f15238b;
        return m4294of;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: k */
    public final boolean m4301k(Class cls) {
        UnmodifiableIterator it = m4297g().iterator();
        while (it.hasNext()) {
            if (cls.isAssignableFrom((Class) it.next())) {
                return true;
            }
        }
        return false;
    }

    @Beta
    public final Invokable<T, Object> method(Method method) {
        Preconditions.checkArgument(m4301k(method.getDeclaringClass()), "%s not declared by %s", method, this);
        return new xx2(this, method);
    }

    public final TypeToken<?> resolveType(Type type) {
        Preconditions.checkNotNull(type);
        return m4294of(m4296f().resolveType(type));
    }

    public String toString() {
        Joiner joiner = mz2.f23181a;
        Type type = this.f15237a;
        if (type instanceof Class) {
            return ((Class) type).getName();
        }
        return type.toString();
    }

    public final TypeToken<T> unwrap() {
        Set<Class<?>> allWrapperTypes = Primitives.allWrapperTypes();
        Type type = this.f15237a;
        if (allWrapperTypes.contains(type)) {
            return m4293of(Primitives.unwrap((Class) type));
        }
        return this;
    }

    public final <X> TypeToken<T> where(TypeParameter<X> typeParameter, TypeToken<X> typeToken) {
        return new TypeToken<>(new TypeResolver().m4288d(ImmutableMap.m3924of(new ux2(typeParameter.f15235a), typeToken.f15237a)).resolveType(this.f15237a));
    }

    public final TypeToken<T> wrap() {
        if (isPrimitive()) {
            return m4293of(Primitives.wrap((Class) this.f15237a));
        }
        return this;
    }

    public Object writeReplace() {
        return m4294of(new TypeResolver().resolveType(this.f15237a));
    }

    /* loaded from: classes2.dex */
    public class TypeSet extends ForwardingSet<TypeToken<? super T>> implements Serializable {
        private static final long serialVersionUID = 0;

        /* renamed from: a */
        public transient ImmutableSet f15240a;

        public TypeSet() {
        }

        public TypeToken<T>.TypeSet classes() {
            return new C0974b(TypeToken.this);
        }

        public TypeToken<T>.TypeSet interfaces() {
            return new C0975c(TypeToken.this, this);
        }

        public Set<Class<? super T>> rawTypes() {
            return ImmutableSet.copyOf((Collection) ey2.f17041b.mo4506b(TypeToken.this.m4297g()));
        }

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public Set<TypeToken<? super T>> delegate() {
            ImmutableSet immutableSet = this.f15240a;
            if (immutableSet != null) {
                return immutableSet;
            }
            ImmutableSet set = FluentIterable.from(ey2.f17040a.mo4506b(ImmutableList.m3903of(TypeToken.this))).filter(hy2.f18217a).toSet();
            this.f15240a = set;
            return set;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:93:0x0146, code lost:
    
        if (r5 != false) goto L62;
     */
    /* JADX WARN: Removed duplicated region for block: B:73:0x015a A[LOOP:3: B:67:0x00e1->B:73:0x015a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01b6 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean isSubtypeOf(Type type) {
        boolean z;
        Type enclosingClass;
        boolean equals;
        boolean z2;
        boolean z3;
        boolean z4;
        Preconditions.checkNotNull(type);
        boolean z5 = type instanceof WildcardType;
        int i = 0;
        Type type2 = this.f15237a;
        if (z5) {
            Type[] lowerBounds = ((WildcardType) type).getLowerBounds();
            TypeToken<?> m4294of = m4294of(type2);
            int length = lowerBounds.length;
            while (i < length) {
                if (m4294of.isSubtypeOf(lowerBounds[i])) {
                    return true;
                }
                i++;
            }
            return !true;
        }
        if (type2 instanceof WildcardType) {
            Type[] upperBounds = ((WildcardType) type2).getUpperBounds();
            int length2 = upperBounds.length;
            while (i < length2) {
                if (m4294of(upperBounds[i]).isSubtypeOf(type)) {
                    return true;
                }
                i++;
            }
            return !true;
        }
        if (type2 instanceof TypeVariable) {
            if (!type2.equals(type)) {
                Type[] bounds = ((TypeVariable) type2).getBounds();
                int length3 = bounds.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length3) {
                        z4 = !true;
                        break;
                    }
                    if (m4294of(bounds[i2]).isSubtypeOf(type)) {
                        z4 = true;
                        break;
                    }
                    i2++;
                }
                if (!z4) {
                    return false;
                }
            }
            return true;
        }
        boolean z6 = type2 instanceof GenericArrayType;
        if (z6) {
            GenericArrayType genericArrayType = (GenericArrayType) type2;
            Type type3 = m4294of(type).f15237a;
            if (type3 instanceof Class) {
                Class cls = (Class) type3;
                if (!cls.isArray()) {
                    return cls.isAssignableFrom(Object[].class);
                }
                return m4294of(genericArrayType.getGenericComponentType()).isSubtypeOf(cls.getComponentType());
            }
            if (type3 instanceof GenericArrayType) {
                return m4294of(genericArrayType.getGenericComponentType()).isSubtypeOf(((GenericArrayType) type3).getGenericComponentType());
            }
            return false;
        }
        if (type instanceof Class) {
            return m4301k((Class) type);
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Class<? super Object> rawType = m4294of(parameterizedType).getRawType();
            if (!m4301k(rawType)) {
                return false;
            }
            TypeVariable<Class<? super Object>>[] typeParameters = rawType.getTypeParameters();
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            for (int i3 = 0; i3 < typeParameters.length; i3++) {
                TypeToken<?> m4294of2 = m4294of(m4295e().resolveType(typeParameters[i3]));
                Type type4 = actualTypeArguments[i3];
                TypeVariable<Class<? super Object>> typeVariable = typeParameters[i3];
                Type type5 = m4294of2.f15237a;
                if (!type5.equals(type4)) {
                    if (type4 instanceof WildcardType) {
                        lz2 m4290c = m4290c(typeVariable, (WildcardType) type4);
                        Type[] m6266c = mz2.m6266c(m4290c.f22732b);
                        TypeToken<?> m4294of3 = m4294of(type5);
                        int length4 = m6266c.length;
                        int i4 = 0;
                        while (true) {
                            if (i4 >= length4) {
                                z2 = !false;
                                break;
                            }
                            if (!m4294of3.isSubtypeOf(m6266c[i4])) {
                                z2 = false;
                                break;
                            }
                            i4++;
                        }
                        if (z2) {
                            Type[] m6266c2 = mz2.m6266c(m4290c.f22731a);
                            int length5 = m6266c2.length;
                            int i5 = 0;
                            while (true) {
                                if (i5 >= length5) {
                                    z3 = !false;
                                    break;
                                }
                                if (!m4294of(m6266c2[i5]).isSubtypeOf(type5)) {
                                    z3 = false;
                                    break;
                                }
                                i5++;
                            }
                        }
                        equals = false;
                    } else {
                        equals = m4291d(type5).equals(m4291d(type4));
                    }
                    if (equals) {
                        return false;
                    }
                }
                equals = true;
                if (equals) {
                }
            }
            if (!Modifier.isStatic(((Class) parameterizedType.getRawType()).getModifiers()) && parameterizedType.getOwnerType() != null) {
                Type ownerType = parameterizedType.getOwnerType();
                Iterator<TypeToken<? super T>> it = getTypes().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    Type type6 = it.next().f15237a;
                    if (type6 instanceof ParameterizedType) {
                        enclosingClass = ((ParameterizedType) type6).getOwnerType();
                    } else {
                        enclosingClass = type6 instanceof Class ? ((Class) type6).getEnclosingClass() : null;
                    }
                    if (enclosingClass != null && m4294of(enclosingClass).isSubtypeOf(ownerType)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    return false;
                }
            }
            return true;
        }
        if (!(type instanceof GenericArrayType)) {
            return false;
        }
        GenericArrayType genericArrayType2 = (GenericArrayType) type;
        if (!(type2 instanceof Class)) {
            if (z6) {
                return m4294of(((GenericArrayType) type2).getGenericComponentType()).isSubtypeOf(genericArrayType2.getGenericComponentType());
            }
            return false;
        }
        Class cls2 = (Class) type2;
        if (cls2.isArray()) {
            return m4293of((Class) cls2.getComponentType()).isSubtypeOf(genericArrayType2.getGenericComponentType());
        }
        return false;
    }

    public final boolean isSupertypeOf(Type type) {
        return m4294of(type).isSubtypeOf(getType());
    }

    /* renamed from: of */
    public static TypeToken<?> m4294of(Type type) {
        return new TypeToken<>(type);
    }

    public TypeToken(Class<?> cls) {
        Type m6934a = m6934a();
        if (m6934a instanceof Class) {
            this.f15237a = m6934a;
            return;
        }
        TypeResolver typeResolver = new TypeResolver();
        Preconditions.checkNotNull(cls);
        rx2 rx2Var = new rx2();
        rx2Var.m4943c(cls);
        this.f15237a = typeResolver.m4288d(ImmutableMap.copyOf((Map) rx2Var.f26179c)).resolveType(m6934a);
    }

    public final <X> TypeToken<T> where(TypeParameter<X> typeParameter, Class<X> cls) {
        return where(typeParameter, m4293of((Class) cls));
    }

    public TypeToken(Type type) {
        this.f15237a = (Type) Preconditions.checkNotNull(type);
    }
}
