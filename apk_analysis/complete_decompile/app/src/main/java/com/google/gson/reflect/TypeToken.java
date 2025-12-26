package com.google.gson.reflect;

import com.google.gson.internal.C$Gson$Types;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Objects;

/* loaded from: classes2.dex */
public class TypeToken<T> {

    /* renamed from: a */
    public final Class f15788a;

    /* renamed from: b */
    public final Type f15789b;

    /* renamed from: c */
    public final int f15790c;

    public TypeToken() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
            if (parameterizedType.getRawType() == TypeToken.class) {
                Type canonicalize = C$Gson$Types.canonicalize(parameterizedType.getActualTypeArguments()[0]);
                this.f15789b = canonicalize;
                this.f15788a = C$Gson$Types.getRawType(canonicalize);
                this.f15790c = canonicalize.hashCode();
                return;
            }
        } else if (genericSuperclass == TypeToken.class) {
            throw new IllegalStateException("TypeToken must be created with a type argument: new TypeToken<...>() {}; When using code shrinkers (ProGuard, R8, ...) make sure that generic signatures are preserved.");
        }
        throw new IllegalStateException("Must only create direct subclasses of TypeToken");
    }

    /* renamed from: a */
    public static boolean m4448a(Type type, ParameterizedType parameterizedType, HashMap hashMap) {
        ParameterizedType parameterizedType2;
        if (type == null) {
            return false;
        }
        if (parameterizedType.equals(type)) {
            return true;
        }
        Class<?> rawType = C$Gson$Types.getRawType(type);
        if (type instanceof ParameterizedType) {
            parameterizedType2 = (ParameterizedType) type;
        } else {
            parameterizedType2 = null;
        }
        if (parameterizedType2 != null) {
            Type[] actualTypeArguments = parameterizedType2.getActualTypeArguments();
            TypeVariable<Class<?>>[] typeParameters = rawType.getTypeParameters();
            for (int i = 0; i < actualTypeArguments.length; i++) {
                Type type2 = actualTypeArguments[i];
                TypeVariable<Class<?>> typeVariable = typeParameters[i];
                while (type2 instanceof TypeVariable) {
                    type2 = (Type) hashMap.get(((TypeVariable) type2).getName());
                }
                hashMap.put(typeVariable.getName(), type2);
            }
            if (parameterizedType2.getRawType().equals(parameterizedType.getRawType())) {
                Type[] actualTypeArguments2 = parameterizedType2.getActualTypeArguments();
                Type[] actualTypeArguments3 = parameterizedType.getActualTypeArguments();
                for (int i2 = 0; i2 < actualTypeArguments2.length; i2++) {
                    Type type3 = actualTypeArguments2[i2];
                    Type type4 = actualTypeArguments3[i2];
                    if (type4.equals(type3) || ((type3 instanceof TypeVariable) && type4.equals(hashMap.get(((TypeVariable) type3).getName())))) {
                    }
                }
                return true;
            }
        }
        for (Type type5 : rawType.getGenericInterfaces()) {
            if (m4448a(type5, parameterizedType, new HashMap(hashMap))) {
                return true;
            }
        }
        return m4448a(rawType.getGenericSuperclass(), parameterizedType, new HashMap(hashMap));
    }

    public static TypeToken<?> get(Type type) {
        return new TypeToken<>(type);
    }

    public static TypeToken<?> getArray(Type type) {
        return new TypeToken<>(C$Gson$Types.arrayOf(type));
    }

    public static TypeToken<?> getParameterized(Type type, Type... typeArr) {
        Objects.requireNonNull(type);
        Objects.requireNonNull(typeArr);
        if (type instanceof Class) {
            Class cls = (Class) type;
            TypeVariable<Class<T>>[] typeParameters = cls.getTypeParameters();
            int length = typeParameters.length;
            int length2 = typeArr.length;
            if (length2 == length) {
                for (int i = 0; i < length; i++) {
                    Type type2 = typeArr[i];
                    Class<?> rawType = C$Gson$Types.getRawType(type2);
                    TypeVariable<Class<T>> typeVariable = typeParameters[i];
                    for (Type type3 : typeVariable.getBounds()) {
                        if (!C$Gson$Types.getRawType(type3).isAssignableFrom(rawType)) {
                            throw new IllegalArgumentException("Type argument " + type2 + " does not satisfy bounds for type variable " + typeVariable + " declared by " + type);
                        }
                    }
                }
                return new TypeToken<>(C$Gson$Types.newParameterizedTypeWithOwner(null, type, typeArr));
            }
            throw new IllegalArgumentException(cls.getName() + " requires " + length + " type arguments, but got " + length2);
        }
        throw new IllegalArgumentException("rawType must be of type Class, but was " + type);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof TypeToken) {
            if (C$Gson$Types.equals(this.f15789b, ((TypeToken) obj).f15789b)) {
                return true;
            }
        }
        return false;
    }

    public final Class<? super T> getRawType() {
        return this.f15788a;
    }

    public final Type getType() {
        return this.f15789b;
    }

    public final int hashCode() {
        return this.f15790c;
    }

    @Deprecated
    public boolean isAssignableFrom(Class<?> cls) {
        return isAssignableFrom((Type) cls);
    }

    public final String toString() {
        return C$Gson$Types.typeToString(this.f15789b);
    }

    public static <T> TypeToken<T> get(Class<T> cls) {
        return new TypeToken<>(cls);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.reflect.Type, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v12, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r7v14, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r7v17, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v22 */
    @Deprecated
    public boolean isAssignableFrom(Type type) {
        boolean z;
        if (type == 0) {
            return false;
        }
        Type type2 = this.f15789b;
        if (type2.equals(type)) {
            return true;
        }
        boolean z2 = type2 instanceof Class;
        Class cls = this.f15788a;
        if (z2) {
            return cls.isAssignableFrom(C$Gson$Types.getRawType(type));
        }
        if (type2 instanceof ParameterizedType) {
            return m4448a(type, (ParameterizedType) type2, new HashMap());
        }
        if (type2 instanceof GenericArrayType) {
            if (cls.isAssignableFrom(C$Gson$Types.getRawType(type))) {
                Type genericComponentType = ((GenericArrayType) type2).getGenericComponentType();
                if (genericComponentType instanceof ParameterizedType) {
                    if (type instanceof GenericArrayType) {
                        type = ((GenericArrayType) type).getGenericComponentType();
                    } else if (type instanceof Class) {
                        type = (Class) type;
                        while (type.isArray()) {
                            type = type.getComponentType();
                        }
                    }
                    z = m4448a(type, (ParameterizedType) genericComponentType, new HashMap());
                } else {
                    z = true;
                }
                if (z) {
                    return true;
                }
            }
            return false;
        }
        Class[] clsArr = {Class.class, ParameterizedType.class, GenericArrayType.class};
        StringBuilder sb = new StringBuilder("Unexpected type. Expected one of: ");
        for (int i = 0; i < 3; i++) {
            sb.append(clsArr[i].getName());
            sb.append(", ");
        }
        sb.append("but got: ");
        sb.append(type2.getClass().getName());
        sb.append(", for type token: ");
        sb.append(type2.toString());
        sb.append('.');
        throw new AssertionError(sb.toString());
    }

    public TypeToken(Type type) {
        Objects.requireNonNull(type);
        Type canonicalize = C$Gson$Types.canonicalize(type);
        this.f15789b = canonicalize;
        this.f15788a = C$Gson$Types.getRawType(canonicalize);
        this.f15790c = canonicalize.hashCode();
    }

    @Deprecated
    public boolean isAssignableFrom(TypeToken<?> typeToken) {
        return isAssignableFrom(typeToken.getType());
    }
}
