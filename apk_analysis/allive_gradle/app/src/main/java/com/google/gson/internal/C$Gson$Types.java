package com.google.gson.internal;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Properties;
import p000.C0000a;
import p000.C0539b;
import p000.C0575c;

/* renamed from: com.google.gson.internal.$Gson$Types, reason: invalid class name */
/* loaded from: classes2.dex */
public final class C$Gson$Types {

    /* renamed from: a */
    public static final Type[] f15716a = new Type[0];

    /* renamed from: a */
    public static void m4414a(Type type) {
        boolean z;
        if ((type instanceof Class) && ((Class) type).isPrimitive()) {
            z = false;
        } else {
            z = true;
        }
        C$Gson$Preconditions.checkArgument(z);
    }

    public static GenericArrayType arrayOf(Type type) {
        return new C0000a(type);
    }

    /* renamed from: b */
    public static Type m4415b(Type type, Class cls, Class cls2) {
        if (cls2 == cls) {
            return type;
        }
        if (cls2.isInterface()) {
            Class<?>[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            for (int i = 0; i < length; i++) {
                Class<?> cls3 = interfaces[i];
                if (cls3 == cls2) {
                    return cls.getGenericInterfaces()[i];
                }
                if (cls2.isAssignableFrom(cls3)) {
                    return m4415b(cls.getGenericInterfaces()[i], interfaces[i], cls2);
                }
            }
        }
        if (!cls.isInterface()) {
            while (cls != Object.class) {
                Class<?> superclass = cls.getSuperclass();
                if (superclass == cls2) {
                    return cls.getGenericSuperclass();
                }
                if (cls2.isAssignableFrom(superclass)) {
                    return m4415b(cls.getGenericSuperclass(), superclass, cls2);
                }
                cls = superclass;
            }
        }
        return cls2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0115, code lost:
    
        if (r1 == null) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0117, code lost:
    
        r12.put(r1, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x011a, code lost:
    
        return r11;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0115 A[EDGE_INSN: B:16:0x0115->B:17:0x0115 BREAK  A[LOOP:0: B:2:0x0002->B:21:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[LOOP:0: B:2:0x0002->B:21:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r11v10, types: [java.lang.reflect.Type, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v17, types: [java.lang.reflect.Type[]] */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v19 */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.lang.reflect.WildcardType] */
    /* JADX WARN: Type inference failed for: r11v20 */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.lang.reflect.WildcardType] */
    /* JADX WARN: Type inference failed for: r11v4, types: [java.lang.reflect.WildcardType] */
    /* JADX WARN: Type inference failed for: r11v5, types: [java.lang.reflect.ParameterizedType] */
    /* JADX WARN: Type inference failed for: r11v6, types: [java.lang.reflect.GenericArrayType] */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.util.HashMap] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Type m4416c(Type type, Class cls, Type type2, HashMap hashMap) {
        Type newParameterizedTypeWithOwner;
        Class cls2;
        TypeVariable typeVariable = null;
        while (true) {
            int i = 0;
            if (type2 instanceof TypeVariable) {
                TypeVariable typeVariable2 = type2;
                Type type3 = (Type) hashMap.get(typeVariable2);
                if (type3 != null) {
                    if (type3 != Void.TYPE) {
                        return type3;
                    }
                    return type2;
                }
                hashMap.put(typeVariable2, Void.TYPE);
                if (typeVariable == null) {
                    typeVariable = typeVariable2;
                }
                GenericDeclaration genericDeclaration = typeVariable2.getGenericDeclaration();
                if (genericDeclaration instanceof Class) {
                    cls2 = (Class) genericDeclaration;
                } else {
                    cls2 = null;
                }
                if (cls2 != null) {
                    Type m4415b = m4415b(type, cls, cls2);
                    if (m4415b instanceof ParameterizedType) {
                        TypeVariable[] typeParameters = cls2.getTypeParameters();
                        int length = typeParameters.length;
                        while (i < length) {
                            if (typeVariable2.equals(typeParameters[i])) {
                                type2 = ((ParameterizedType) m4415b).getActualTypeArguments()[i];
                                if (type2 != typeVariable2) {
                                    break;
                                }
                            } else {
                                i++;
                            }
                        }
                        throw new NoSuchElementException();
                    }
                }
                type2 = typeVariable2;
                if (type2 != typeVariable2) {
                }
            } else {
                if (type2 instanceof Class) {
                    Class cls3 = type2;
                    if (cls3.isArray()) {
                        Class<?> componentType = cls3.getComponentType();
                        Type m4416c = m4416c(type, cls, componentType, hashMap);
                        if (Objects.equals(componentType, m4416c)) {
                            type2 = cls3;
                        } else {
                            newParameterizedTypeWithOwner = arrayOf(m4416c);
                            type2 = newParameterizedTypeWithOwner;
                        }
                    }
                }
                if (type2 instanceof GenericArrayType) {
                    type2 = (GenericArrayType) type2;
                    Type genericComponentType = type2.getGenericComponentType();
                    Type m4416c2 = m4416c(type, cls, genericComponentType, hashMap);
                    if (!Objects.equals(genericComponentType, m4416c2)) {
                        newParameterizedTypeWithOwner = arrayOf(m4416c2);
                        type2 = newParameterizedTypeWithOwner;
                    }
                } else if (type2 instanceof ParameterizedType) {
                    type2 = (ParameterizedType) type2;
                    Type ownerType = type2.getOwnerType();
                    Type m4416c3 = m4416c(type, cls, ownerType, hashMap);
                    boolean z = !Objects.equals(m4416c3, ownerType);
                    Type[] actualTypeArguments = type2.getActualTypeArguments();
                    int length2 = actualTypeArguments.length;
                    while (i < length2) {
                        Type m4416c4 = m4416c(type, cls, actualTypeArguments[i], hashMap);
                        if (!Objects.equals(m4416c4, actualTypeArguments[i])) {
                            if (!z) {
                                actualTypeArguments = (Type[]) actualTypeArguments.clone();
                                z = true;
                            }
                            actualTypeArguments[i] = m4416c4;
                        }
                        i++;
                    }
                    if (z) {
                        newParameterizedTypeWithOwner = newParameterizedTypeWithOwner(m4416c3, type2.getRawType(), actualTypeArguments);
                        type2 = newParameterizedTypeWithOwner;
                    }
                } else if (type2 instanceof WildcardType) {
                    type2 = (WildcardType) type2;
                    Type[] lowerBounds = type2.getLowerBounds();
                    Type[] upperBounds = type2.getUpperBounds();
                    if (lowerBounds.length == 1) {
                        Type m4416c5 = m4416c(type, cls, lowerBounds[0], hashMap);
                        if (m4416c5 != lowerBounds[0]) {
                            type2 = supertypeOf(m4416c5);
                        }
                    } else if (upperBounds.length == 1) {
                        Type m4416c6 = m4416c(type, cls, upperBounds[0], hashMap);
                        if (m4416c6 != upperBounds[0]) {
                            type2 = subtypeOf(m4416c6);
                        }
                    }
                }
            }
        }
    }

    public static Type canonicalize(Type type) {
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (cls.isArray()) {
                return new C0000a(canonicalize(cls.getComponentType()));
            }
            return cls;
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            return new C0539b(parameterizedType.getOwnerType(), parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
        }
        if (type instanceof GenericArrayType) {
            return new C0000a(((GenericArrayType) type).getGenericComponentType());
        }
        if (type instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) type;
            return new C0575c(wildcardType.getUpperBounds(), wildcardType.getLowerBounds());
        }
        return type;
    }

    public static boolean equals(Type type, Type type2) {
        if (type == type2) {
            return true;
        }
        if (type instanceof Class) {
            return type.equals(type2);
        }
        if (type instanceof ParameterizedType) {
            if (!(type2 instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            ParameterizedType parameterizedType2 = (ParameterizedType) type2;
            if (Objects.equals(parameterizedType.getOwnerType(), parameterizedType2.getOwnerType()) && parameterizedType.getRawType().equals(parameterizedType2.getRawType()) && Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments())) {
                return true;
            }
            return false;
        }
        if (type instanceof GenericArrayType) {
            if (!(type2 instanceof GenericArrayType)) {
                return false;
            }
            return equals(((GenericArrayType) type).getGenericComponentType(), ((GenericArrayType) type2).getGenericComponentType());
        }
        if (type instanceof WildcardType) {
            if (!(type2 instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) type;
            WildcardType wildcardType2 = (WildcardType) type2;
            if (Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) && Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds())) {
                return true;
            }
            return false;
        }
        if (!(type instanceof TypeVariable) || !(type2 instanceof TypeVariable)) {
            return false;
        }
        TypeVariable typeVariable = (TypeVariable) type;
        TypeVariable typeVariable2 = (TypeVariable) type2;
        if (typeVariable.getGenericDeclaration() == typeVariable2.getGenericDeclaration() && typeVariable.getName().equals(typeVariable2.getName())) {
            return true;
        }
        return false;
    }

    public static Type getArrayComponentType(Type type) {
        if (type instanceof GenericArrayType) {
            return ((GenericArrayType) type).getGenericComponentType();
        }
        return ((Class) type).getComponentType();
    }

    public static Type getCollectionElementType(Type type, Class<?> cls) {
        if (type instanceof WildcardType) {
            type = ((WildcardType) type).getUpperBounds()[0];
        }
        C$Gson$Preconditions.checkArgument(Collection.class.isAssignableFrom(cls));
        Type resolve = resolve(type, cls, m4415b(type, cls, Collection.class));
        if (resolve instanceof ParameterizedType) {
            return ((ParameterizedType) resolve).getActualTypeArguments()[0];
        }
        return Object.class;
    }

    public static Type[] getMapKeyAndValueTypes(Type type, Class<?> cls) {
        if (type == Properties.class) {
            return new Type[]{String.class, String.class};
        }
        if (type instanceof WildcardType) {
            type = ((WildcardType) type).getUpperBounds()[0];
        }
        C$Gson$Preconditions.checkArgument(Map.class.isAssignableFrom(cls));
        Type resolve = resolve(type, cls, m4415b(type, cls, Map.class));
        if (resolve instanceof ParameterizedType) {
            return ((ParameterizedType) resolve).getActualTypeArguments();
        }
        return new Type[]{Object.class, Object.class};
    }

    public static Class<?> getRawType(Type type) {
        String name;
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            C$Gson$Preconditions.checkArgument(rawType instanceof Class);
            return (Class) rawType;
        }
        if (type instanceof GenericArrayType) {
            return Array.newInstance(getRawType(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        }
        if (type instanceof TypeVariable) {
            return Object.class;
        }
        if (type instanceof WildcardType) {
            return getRawType(((WildcardType) type).getUpperBounds()[0]);
        }
        if (type == null) {
            name = "null";
        } else {
            name = type.getClass().getName();
        }
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + name);
    }

    public static ParameterizedType newParameterizedTypeWithOwner(Type type, Type type2, Type... typeArr) {
        return new C0539b(type, type2, typeArr);
    }

    public static Type resolve(Type type, Class<?> cls, Type type2) {
        return m4416c(type, cls, type2, new HashMap());
    }

    public static WildcardType subtypeOf(Type type) {
        Type[] typeArr;
        if (type instanceof WildcardType) {
            typeArr = ((WildcardType) type).getUpperBounds();
        } else {
            typeArr = new Type[]{type};
        }
        return new C0575c(typeArr, f15716a);
    }

    public static WildcardType supertypeOf(Type type) {
        Type[] typeArr;
        if (type instanceof WildcardType) {
            typeArr = ((WildcardType) type).getLowerBounds();
        } else {
            typeArr = new Type[]{type};
        }
        return new C0575c(new Type[]{Object.class}, typeArr);
    }

    public static String typeToString(Type type) {
        if (type instanceof Class) {
            return ((Class) type).getName();
        }
        return type.toString();
    }
}
