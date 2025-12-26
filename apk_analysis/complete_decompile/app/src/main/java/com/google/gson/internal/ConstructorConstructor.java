package com.google.gson.internal;

import com.google.gson.InstanceCreator;
import com.google.gson.ReflectionAccessFilter;
import com.google.gson.internal.reflect.ReflectionHelper;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import p000.C1331iv;
import p000.C1368jv;
import p000.C1488kv;
import p000.C1525lv;
import p000.C1562mv;
import p000.C1599nv;
import p000.C1995xt;
import p000.dx0;
import p000.wd0;

/* loaded from: classes2.dex */
public final class ConstructorConstructor {

    /* renamed from: a */
    public final Map f15717a;

    /* renamed from: b */
    public final boolean f15718b;

    /* renamed from: c */
    public final List f15719c;

    public ConstructorConstructor(Map<Type, InstanceCreator<?>> map, boolean z, List<ReflectionAccessFilter> list) {
        this.f15717a = map;
        this.f15718b = z;
        this.f15719c = list;
    }

    /* renamed from: a */
    public static String m4417a(Class cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            return "Interfaces can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Interface name: ".concat(cls.getName());
        }
        if (Modifier.isAbstract(modifiers)) {
            return "Abstract classes can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Class name: ".concat(cls.getName());
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00a5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> ObjectConstructor<T> get(TypeToken<T> typeToken) {
        C1488kv c1488kv;
        ObjectConstructor<T> c1599nv;
        String tryMakeAccessible;
        Type type = typeToken.getType();
        Class<? super T> rawType = typeToken.getRawType();
        Map map = this.f15717a;
        InstanceCreator instanceCreator = (InstanceCreator) map.get(type);
        if (instanceCreator != null) {
            return new C1331iv(instanceCreator, type, 0);
        }
        InstanceCreator instanceCreator2 = (InstanceCreator) map.get(rawType);
        if (instanceCreator2 != null) {
            return new C1331iv(instanceCreator2, type, 1);
        }
        ObjectConstructor<T> objectConstructor = null;
        if (EnumSet.class.isAssignableFrom(rawType)) {
            c1488kv = new C1488kv(type, 0);
        } else if (rawType == EnumMap.class) {
            c1488kv = new C1488kv(type, 1);
        } else {
            c1488kv = null;
        }
        if (c1488kv != null) {
            return c1488kv;
        }
        ReflectionAccessFilter.FilterResult filterResult = ReflectionAccessFilterHelper.getFilterResult(this.f15719c, rawType);
        if (!Modifier.isAbstract(rawType.getModifiers())) {
            try {
                Constructor<? super T> declaredConstructor = rawType.getDeclaredConstructor(null);
                ReflectionAccessFilter.FilterResult filterResult2 = ReflectionAccessFilter.FilterResult.ALLOW;
                if (filterResult != filterResult2 && (!ReflectionAccessFilterHelper.canAccess(declaredConstructor, null) || (filterResult == ReflectionAccessFilter.FilterResult.BLOCK_ALL && !Modifier.isPublic(declaredConstructor.getModifiers())))) {
                    c1599nv = new C1525lv("Unable to invoke no-args constructor of " + rawType + "; constructor is not accessible and ReflectionAccessFilter does not permit making it accessible. Register an InstanceCreator or a TypeAdapter for this type, change the visibility of the constructor or adjust the access filter.");
                } else if (filterResult == filterResult2 && (tryMakeAccessible = ReflectionHelper.tryMakeAccessible(declaredConstructor)) != null) {
                    c1599nv = new C1562mv(tryMakeAccessible);
                } else {
                    c1599nv = new C1599nv(declaredConstructor);
                }
            } catch (NoSuchMethodException unused) {
            }
            if (c1599nv == null) {
                return c1599nv;
            }
            if (Collection.class.isAssignableFrom(rawType)) {
                if (SortedSet.class.isAssignableFrom(rawType)) {
                    objectConstructor = new dx0(6);
                } else if (Set.class.isAssignableFrom(rawType)) {
                    objectConstructor = new wd0(7);
                } else if (Queue.class.isAssignableFrom(rawType)) {
                    objectConstructor = new dx0(7);
                } else {
                    objectConstructor = new wd0(8);
                }
            } else if (Map.class.isAssignableFrom(rawType)) {
                if (ConcurrentNavigableMap.class.isAssignableFrom(rawType)) {
                    objectConstructor = new dx0(8);
                } else if (ConcurrentMap.class.isAssignableFrom(rawType)) {
                    objectConstructor = new wd0(9);
                } else if (SortedMap.class.isAssignableFrom(rawType)) {
                    objectConstructor = new dx0(9);
                } else if ((type instanceof ParameterizedType) && !String.class.isAssignableFrom(TypeToken.get(((ParameterizedType) type).getActualTypeArguments()[0]).getRawType())) {
                    objectConstructor = new wd0(10);
                } else {
                    objectConstructor = new dx0(10);
                }
            }
            if (objectConstructor != null) {
                return objectConstructor;
            }
            String m4417a = m4417a(rawType);
            if (m4417a != null) {
                return new C1368jv(m4417a, 1);
            }
            if (filterResult == ReflectionAccessFilter.FilterResult.ALLOW) {
                if (this.f15718b) {
                    return new C1995xt(rawType);
                }
                return new C1368jv("Unable to create instance of " + rawType + "; usage of JDK Unsafe is disabled. Registering an InstanceCreator or a TypeAdapter for this type, adding a no-args constructor, or enabling usage of JDK Unsafe may fix this problem.", 0);
            }
            return new C1368jv("Unable to create instance of " + rawType + "; ReflectionAccessFilter does not permit using reflection or Unsafe. Register an InstanceCreator or a TypeAdapter for this type or adjust the access filter to allow using reflection.", 2);
        }
        c1599nv = null;
        if (c1599nv == null) {
        }
    }

    public String toString() {
        return this.f15717a.toString();
    }
}
