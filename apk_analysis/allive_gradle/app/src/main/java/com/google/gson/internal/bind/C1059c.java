package com.google.gson.internal.bind;

import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.JsonParseException;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.internal.reflect.ReflectionHelper;
import com.google.gson.stream.JsonReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import p000.AbstractC1726qj;
import p000.p92;

/* renamed from: com.google.gson.internal.bind.c */
/* loaded from: classes2.dex */
public final class C1059c extends ReflectiveTypeAdapterFactory.Adapter {

    /* renamed from: e */
    public static final HashMap f15779e;

    /* renamed from: b */
    public final Constructor f15780b;

    /* renamed from: c */
    public final Object[] f15781c;

    /* renamed from: d */
    public final HashMap f15782d;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(Byte.TYPE, (byte) 0);
        hashMap.put(Short.TYPE, (short) 0);
        hashMap.put(Integer.TYPE, 0);
        hashMap.put(Long.TYPE, 0L);
        hashMap.put(Float.TYPE, Float.valueOf(RecyclerView.f7068F0));
        hashMap.put(Double.TYPE, Double.valueOf(0.0d));
        hashMap.put(Character.TYPE, (char) 0);
        hashMap.put(Boolean.TYPE, Boolean.FALSE);
        f15779e = hashMap;
    }

    public C1059c(Class cls, LinkedHashMap linkedHashMap, boolean z) {
        super(linkedHashMap);
        this.f15782d = new HashMap();
        Constructor canonicalRecordConstructor = ReflectionHelper.getCanonicalRecordConstructor(cls);
        this.f15780b = canonicalRecordConstructor;
        if (z) {
            ReflectiveTypeAdapterFactory.m4438a(canonicalRecordConstructor, null);
        } else {
            ReflectionHelper.makeAccessible(canonicalRecordConstructor);
        }
        String[] recordComponentNames = ReflectionHelper.getRecordComponentNames(cls);
        for (int i = 0; i < recordComponentNames.length; i++) {
            this.f15782d.put(recordComponentNames[i], Integer.valueOf(i));
        }
        Class<?>[] parameterTypes = this.f15780b.getParameterTypes();
        this.f15781c = new Object[parameterTypes.length];
        for (int i2 = 0; i2 < parameterTypes.length; i2++) {
            this.f15781c[i2] = f15779e.get(parameterTypes[i2]);
        }
    }

    @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
    /* renamed from: a */
    public final Object mo4440a() {
        return (Object[]) this.f15781c.clone();
    }

    @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
    /* renamed from: b */
    public final Object mo4441b(Object obj) {
        Object[] objArr = (Object[]) obj;
        Constructor constructor = this.f15780b;
        try {
            return constructor.newInstance(objArr);
        } catch (IllegalAccessException e) {
            throw ReflectionHelper.createExceptionForUnexpectedIllegalAccess(e);
        } catch (IllegalArgumentException e2) {
            e = e2;
            throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.constructorToString(constructor) + "' with args " + Arrays.toString(objArr), e);
        } catch (InstantiationException e3) {
            e = e3;
            throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.constructorToString(constructor) + "' with args " + Arrays.toString(objArr), e);
        } catch (InvocationTargetException e4) {
            throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.constructorToString(constructor) + "' with args " + Arrays.toString(objArr), e4.getCause());
        }
    }

    @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
    /* renamed from: c */
    public final void mo4442c(Object obj, JsonReader jsonReader, p92 p92Var) {
        Object[] objArr = (Object[]) obj;
        HashMap hashMap = this.f15782d;
        String str = p92Var.f25079c;
        Integer num = (Integer) hashMap.get(str);
        if (num != null) {
            int intValue = num.intValue();
            Object read = p92Var.f25085i.read(jsonReader);
            if (read == null && p92Var.f25088l) {
                StringBuilder m7065u = AbstractC1726qj.m7065u("null is not allowed as value for record component '", str, "' of primitive type; at path ");
                m7065u.append(jsonReader.getPath());
                throw new JsonParseException(m7065u.toString());
            }
            objArr[intValue] = read;
            return;
        }
        throw new IllegalStateException("Could not find the index in the constructor '" + ReflectionHelper.constructorToString(this.f15780b) + "' for field with name '" + str + "', unable to determine which argument in the constructor the field corresponds to. This is unexpected behavior, as we expect the RecordComponents to have the same names as the fields in the Java class, and that the order of the RecordComponents is the same as the order of the canonical constructor parameters.");
    }
}
