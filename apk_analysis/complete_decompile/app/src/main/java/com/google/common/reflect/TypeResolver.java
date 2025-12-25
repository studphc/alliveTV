package com.google.common.reflect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.HashMap;
import java.util.Map;
import p000.lz2;
import p000.mz2;
import p000.qx2;
import p000.sx2;
import p000.tx2;
import p000.ux2;

/* loaded from: classes2.dex */
public final class TypeResolver {

    /* renamed from: a */
    public final tx2 f15236a;

    public TypeResolver() {
        this.f15236a = new tx2();
    }

    /* renamed from: a */
    public static void m4285a(HashMap hashMap, Type type, Type type2) {
        if (type.equals(type2)) {
            return;
        }
        new qx2(hashMap, type2).m4943c(type);
    }

    /* renamed from: b */
    public final Type[] m4286b(Type[] typeArr) {
        Type[] typeArr2 = new Type[typeArr.length];
        for (int i = 0; i < typeArr.length; i++) {
            typeArr2[i] = resolveType(typeArr[i]);
        }
        return typeArr2;
    }

    /* renamed from: c */
    public final void m4287c(Type[] typeArr) {
        for (int i = 0; i < typeArr.length; i++) {
            typeArr[i] = resolveType(typeArr[i]);
        }
    }

    /* renamed from: d */
    public final TypeResolver m4288d(Map map) {
        boolean z;
        tx2 tx2Var = this.f15236a;
        tx2Var.getClass();
        ImmutableMap.Builder builder = ImmutableMap.builder();
        builder.putAll(tx2Var.f27016a);
        for (Map.Entry entry : map.entrySet()) {
            ux2 ux2Var = (ux2) entry.getKey();
            Type type = (Type) entry.getValue();
            ux2Var.getClass();
            if (type instanceof TypeVariable) {
                z = ux2Var.m7789a((TypeVariable) type);
            } else {
                z = false;
            }
            Preconditions.checkArgument(!z, "Type variable %s bound to itself", ux2Var);
            builder.put(ux2Var, type);
        }
        return new TypeResolver(new tx2(builder.buildOrThrow()));
    }

    public Type resolveType(Type type) {
        Type resolveType;
        Preconditions.checkNotNull(type);
        if (type instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable) type;
            tx2 tx2Var = this.f15236a;
            tx2Var.getClass();
            return tx2Var.mo7423a(typeVariable, new sx2(typeVariable, tx2Var));
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type ownerType = parameterizedType.getOwnerType();
            if (ownerType == null) {
                resolveType = null;
            } else {
                resolveType = resolveType(ownerType);
            }
            return mz2.m6270g(resolveType, (Class) resolveType(parameterizedType.getRawType()), m4286b(parameterizedType.getActualTypeArguments()));
        }
        if (type instanceof GenericArrayType) {
            return mz2.m6268e(resolveType(((GenericArrayType) type).getGenericComponentType()));
        }
        if (type instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) type;
            return new lz2(m4286b(wildcardType.getLowerBounds()), m4286b(wildcardType.getUpperBounds()));
        }
        return type;
    }

    public TypeResolver where(Type type, Type type2) {
        HashMap newHashMap = Maps.newHashMap();
        m4285a(newHashMap, (Type) Preconditions.checkNotNull(type), (Type) Preconditions.checkNotNull(type2));
        return m4288d(newHashMap);
    }

    public TypeResolver(tx2 tx2Var) {
        this.f15236a = tx2Var;
    }
}
