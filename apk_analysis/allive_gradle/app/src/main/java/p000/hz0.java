package p000;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Set;

/* loaded from: classes.dex */
public final class hz0 extends AbstractMap implements BiMap, Serializable {

    /* renamed from: a */
    public final HashBiMap f18224a;

    /* renamed from: b */
    public transient iz0 f18225b;

    public hz0(HashBiMap hashBiMap) {
        this.f18224a = hashBiMap;
    }

    @GwtIncompatible("serialization")
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.f18224a.f14657p = this;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        this.f18224a.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        return this.f18224a.containsValue(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(Object obj) {
        return this.f18224a.containsKey(obj);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [kz0, java.util.Set, iz0] */
    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        iz0 iz0Var = this.f18225b;
        if (iz0Var == null) {
            ?? kz0Var = new kz0(this.f18224a);
            this.f18225b = kz0Var;
            return kz0Var;
        }
        return iz0Var;
    }

    @Override // com.google.common.collect.BiMap
    public final Object forcePut(Object obj, Object obj2) {
        return this.f18224a.m3874n(obj, obj2, true);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        HashBiMap hashBiMap = this.f18224a;
        hashBiMap.getClass();
        int m3869i = hashBiMap.m3869i(o63.m6454N(obj), obj);
        if (m3869i == -1) {
            return null;
        }
        return hashBiMap.f14642a[m3869i];
    }

    @Override // com.google.common.collect.BiMap
    public final BiMap inverse() {
        return this.f18224a;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        return this.f18224a.values();
    }

    @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.BiMap
    public final Object put(Object obj, Object obj2) {
        return this.f18224a.m3874n(obj, obj2, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        HashBiMap hashBiMap = this.f18224a;
        hashBiMap.getClass();
        int m6454N = o63.m6454N(obj);
        int m3869i = hashBiMap.m3869i(m6454N, obj);
        if (m3869i == -1) {
            return null;
        }
        Object obj2 = hashBiMap.f14642a[m3869i];
        hashBiMap.m3877q(m3869i, m6454N);
        return obj2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f18224a.f14644c;
    }

    @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.BiMap
    public final Collection values() {
        return this.f18224a.keySet();
    }

    @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.BiMap
    public final Set values() {
        return this.f18224a.keySet();
    }
}
