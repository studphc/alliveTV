package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.Enum;
import java.util.EnumMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;
import p000.AbstractC1706q;

@GwtCompatible(emulated = true)
/* loaded from: classes.dex */
public final class EnumBiMap<K extends Enum<K>, V extends Enum<V>> extends AbstractC1706q {

    @GwtIncompatible
    private static final long serialVersionUID = 0;

    /* renamed from: f */
    public transient Class f14627f;

    /* renamed from: g */
    public transient Class f14628g;

    public static <K extends Enum<K>, V extends Enum<V>> EnumBiMap<K, V> create(Class<K> cls, Class<V> cls2) {
        EnumBiMap<K, V> enumBiMap = (EnumBiMap<K, V>) new AbstractC1706q(new EnumMap(cls), new EnumMap(cls2));
        enumBiMap.f14627f = cls;
        enumBiMap.f14628g = cls2;
        return enumBiMap;
    }

    /* renamed from: i */
    public static Class m3850i(Map map) {
        if (map instanceof EnumBiMap) {
            return ((EnumBiMap) map).keyType();
        }
        if (map instanceof EnumHashBiMap) {
            return ((EnumHashBiMap) map).keyType();
        }
        Preconditions.checkArgument(!map.isEmpty());
        return ((Enum) map.keySet().iterator().next()).getDeclaringClass();
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.f14627f = (Class) objectInputStream.readObject();
        this.f14628g = (Class) objectInputStream.readObject();
        m6939h(new EnumMap(this.f14627f), new EnumMap(this.f14628g));
        AbstractC0924q2.m4159b(this, objectInputStream, objectInputStream.readInt());
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.f14627f);
        objectOutputStream.writeObject(this.f14628g);
        AbstractC0924q2.m4162e(this, objectOutputStream);
    }

    @Override // p000.AbstractC1706q, com.google.common.collect.ForwardingMap, java.util.Map
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // p000.AbstractC1706q, com.google.common.collect.ForwardingMap, java.util.Map
    public boolean containsValue(@CheckForNull Object obj) {
        return this.f25353b.containsKey(obj);
    }

    @Override // p000.AbstractC1706q
    /* renamed from: e */
    public final Object mo3851e(Object obj) {
        return (Enum) Preconditions.checkNotNull((Enum) obj);
    }

    @Override // p000.AbstractC1706q, com.google.common.collect.ForwardingMap, java.util.Map
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // p000.AbstractC1706q
    /* renamed from: f */
    public final Object mo3852f(Object obj) {
        return (Enum) Preconditions.checkNotNull((Enum) obj);
    }

    @Override // p000.AbstractC1706q, com.google.common.collect.BiMap
    @CanIgnoreReturnValue
    @CheckForNull
    public Object forcePut(Object obj, Object obj2) {
        return m6938g(obj, obj2, true);
    }

    @Override // p000.AbstractC1706q, com.google.common.collect.BiMap
    public BiMap inverse() {
        return this.f25353b;
    }

    @Override // p000.AbstractC1706q, com.google.common.collect.ForwardingMap, java.util.Map
    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    public Class<K> keyType() {
        return this.f14627f;
    }

    @Override // p000.AbstractC1706q, com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    @CanIgnoreReturnValue
    @CheckForNull
    public Object put(Object obj, Object obj2) {
        return m6938g(obj, obj2, false);
    }

    @Override // p000.AbstractC1706q, com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    public /* bridge */ /* synthetic */ void putAll(Map map) {
        super.putAll(map);
    }

    @Override // p000.AbstractC1706q, com.google.common.collect.ForwardingMap, java.util.Map
    @CanIgnoreReturnValue
    @CheckForNull
    public /* bridge */ /* synthetic */ Object remove(@CheckForNull Object obj) {
        return super.remove(obj);
    }

    public Class<V> valueType() {
        return this.f14628g;
    }

    @Override // p000.AbstractC1706q, com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    public /* bridge */ /* synthetic */ Set values() {
        return super.values();
    }

    public static <K extends Enum<K>, V extends Enum<V>> EnumBiMap<K, V> create(Map<K, V> map) {
        Class declaringClass;
        Class m3850i = m3850i(map);
        if (map instanceof EnumBiMap) {
            declaringClass = ((EnumBiMap) map).f14628g;
        } else {
            Preconditions.checkArgument(!map.isEmpty());
            declaringClass = map.values().iterator().next().getDeclaringClass();
        }
        EnumBiMap<K, V> create = create(m3850i, declaringClass);
        create.putAll(map);
        return create;
    }
}
