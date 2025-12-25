package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.Enum;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;
import p000.AbstractC1706q;

@GwtCompatible(emulated = true)
/* loaded from: classes.dex */
public final class EnumHashBiMap<K extends Enum<K>, V> extends AbstractC1706q {

    @GwtIncompatible
    private static final long serialVersionUID = 0;

    /* renamed from: f */
    public transient Class f14629f;

    public static <K extends Enum<K>, V> EnumHashBiMap<K, V> create(Class<K> cls) {
        EnumHashBiMap<K, V> enumHashBiMap = (EnumHashBiMap<K, V>) new AbstractC1706q(new EnumMap(cls), Maps.newHashMapWithExpectedSize(cls.getEnumConstants().length));
        enumHashBiMap.f14629f = cls;
        return enumHashBiMap;
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.f14629f = (Class) objectInputStream.readObject();
        m6939h(new EnumMap(this.f14629f), new HashMap((((Enum[]) this.f14629f.getEnumConstants()).length * 3) / 2));
        AbstractC0924q2.m4159b(this, objectInputStream, objectInputStream.readInt());
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.f14629f);
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p000.AbstractC1706q, com.google.common.collect.BiMap
    @CanIgnoreReturnValue
    @CheckForNull
    public /* bridge */ /* synthetic */ Object forcePut(Object obj, Object obj2) {
        return forcePut((EnumHashBiMap<K, V>) obj, (Enum) obj2);
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
        return this.f14629f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p000.AbstractC1706q, com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    @CanIgnoreReturnValue
    @CheckForNull
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return put((EnumHashBiMap<K, V>) obj, (Enum) obj2);
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

    @Override // p000.AbstractC1706q, com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    public /* bridge */ /* synthetic */ Set values() {
        return super.values();
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public V forcePut(K k, V v) {
        return (V) m6938g(k, v, true);
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public V put(K k, V v) {
        return (V) m6938g(k, v, false);
    }

    public static <K extends Enum<K>, V> EnumHashBiMap<K, V> create(Map<K, ? extends V> map) {
        EnumHashBiMap<K, V> create = create(EnumBiMap.m3850i(map));
        create.putAll(map);
        return create;
    }
}
