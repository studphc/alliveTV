package com.google.gson.internal;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import p000.ja0;

/* loaded from: classes2.dex */
public final class Excluder implements TypeAdapterFactory, Cloneable {
    public static final Excluder DEFAULT = new Excluder();

    /* renamed from: d */
    public boolean f15723d;

    /* renamed from: a */
    public double f15720a = -1.0d;

    /* renamed from: b */
    public int f15721b = 136;

    /* renamed from: c */
    public boolean f15722c = true;

    /* renamed from: e */
    public List f15724e = Collections.emptyList();

    /* renamed from: f */
    public List f15725f = Collections.emptyList();

    /* renamed from: c */
    public static boolean m4418c(Class cls) {
        if (!Enum.class.isAssignableFrom(cls) && (cls.getModifiers() & 8) == 0 && (cls.isAnonymousClass() || cls.isLocalClass())) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002f, code lost:
    
        if (r7.f15720a < r2.value()) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0023, code lost:
    
        if (r7.f15720a >= r0.value()) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0032, code lost:
    
        return true;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean m4419a(Class cls) {
        if (this.f15720a != -1.0d) {
            Since since = (Since) cls.getAnnotation(Since.class);
            Until until = (Until) cls.getAnnotation(Until.class);
            if (since != null) {
            }
            if (until != null) {
            }
        }
        if (!this.f15722c && cls.isMemberClass() && (cls.getModifiers() & 8) == 0) {
            return true;
        }
        return m4418c(cls);
    }

    /* renamed from: b */
    public final boolean m4420b(Class cls, boolean z) {
        List list;
        if (z) {
            list = this.f15724e;
        } else {
            list = this.f15725f;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((ExclusionStrategy) it.next()).shouldSkipClass(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        boolean z;
        boolean z2;
        Class<? super T> rawType = typeToken.getRawType();
        boolean m4419a = m4419a(rawType);
        if (!m4419a && !m4420b(rawType, true)) {
            z = false;
        } else {
            z = true;
        }
        if (!m4419a && !m4420b(rawType, false)) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!z && !z2) {
            return null;
        }
        return new ja0(this, z2, z, gson, typeToken);
    }

    public Excluder disableInnerClassSerialization() {
        Excluder m8506clone = m8506clone();
        m8506clone.f15722c = false;
        return m8506clone;
    }

    public boolean excludeClass(Class<?> cls, boolean z) {
        if (!m4419a(cls) && !m4420b(cls, z)) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002d, code lost:
    
        if (r7.f15720a >= r0.value()) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x003c, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0039, code lost:
    
        if (r7.f15720a < r2.value()) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean excludeField(Field field, boolean z) {
        List list;
        Expose expose;
        if ((this.f15721b & field.getModifiers()) != 0) {
            return true;
        }
        if (this.f15720a != -1.0d) {
            Since since = (Since) field.getAnnotation(Since.class);
            Until until = (Until) field.getAnnotation(Until.class);
            if (since != null) {
            }
            if (until != null) {
            }
        }
        if (field.isSynthetic()) {
            return true;
        }
        if (this.f15723d && ((expose = (Expose) field.getAnnotation(Expose.class)) == null || (!z ? !expose.deserialize() : !expose.serialize()))) {
            return true;
        }
        if (!this.f15722c) {
            Class<?> type = field.getType();
            if (type.isMemberClass() && (type.getModifiers() & 8) == 0) {
                return true;
            }
        }
        if (m4418c(field.getType())) {
            return true;
        }
        if (z) {
            list = this.f15724e;
        } else {
            list = this.f15725f;
        }
        if (!list.isEmpty()) {
            FieldAttributes fieldAttributes = new FieldAttributes(field);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (((ExclusionStrategy) it.next()).shouldSkipField(fieldAttributes)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public Excluder excludeFieldsWithoutExposeAnnotation() {
        Excluder m8506clone = m8506clone();
        m8506clone.f15723d = true;
        return m8506clone;
    }

    public Excluder withExclusionStrategy(ExclusionStrategy exclusionStrategy, boolean z, boolean z2) {
        Excluder m8506clone = m8506clone();
        if (z) {
            ArrayList arrayList = new ArrayList(this.f15724e);
            m8506clone.f15724e = arrayList;
            arrayList.add(exclusionStrategy);
        }
        if (z2) {
            ArrayList arrayList2 = new ArrayList(this.f15725f);
            m8506clone.f15725f = arrayList2;
            arrayList2.add(exclusionStrategy);
        }
        return m8506clone;
    }

    public Excluder withModifiers(int... iArr) {
        Excluder m8506clone = m8506clone();
        m8506clone.f15721b = 0;
        for (int i : iArr) {
            m8506clone.f15721b = i | m8506clone.f15721b;
        }
        return m8506clone;
    }

    public Excluder withVersion(double d) {
        Excluder m8506clone = m8506clone();
        m8506clone.f15720a = d;
        return m8506clone;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Excluder m8506clone() {
        try {
            return (Excluder) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}
