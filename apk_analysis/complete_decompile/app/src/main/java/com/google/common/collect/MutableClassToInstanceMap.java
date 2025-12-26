package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Primitives;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;
import p000.C1669p;
import p000.qq1;

@GwtIncompatible
/* loaded from: classes.dex */
public final class MutableClassToInstanceMap<B> extends ForwardingMap<Class<? extends B>, B> implements ClassToInstanceMap<B>, Serializable {

    /* renamed from: a */
    public final Map f14745a;

    public MutableClassToInstanceMap(Map map) {
        this.f14745a = (Map) Preconditions.checkNotNull(map);
    }

    public static <B> MutableClassToInstanceMap<B> create() {
        return new MutableClassToInstanceMap<>(new HashMap());
    }

    private Object writeReplace() {
        return new qq1(delegate());
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public Set<Map.Entry<Class<? extends B>, B>> entrySet() {
        return new C1669p(this, 3);
    }

    @Override // com.google.common.collect.ClassToInstanceMap
    @CheckForNull
    public <T extends B> T getInstance(Class<T> cls) {
        return (T) Primitives.wrap(cls).cast(get(cls));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    @CanIgnoreReturnValue
    @CheckForNull
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return put((Class<? extends Class<? extends B>>) obj, (Class<? extends B>) obj2);
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    public void putAll(Map<? extends Class<? extends B>, ? extends B> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            Class cls = (Class) entry.getKey();
            Primitives.wrap(cls).cast(entry.getValue());
        }
        super.putAll(linkedHashMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ClassToInstanceMap
    @CanIgnoreReturnValue
    @CheckForNull
    public <T extends B> T putInstance(Class<T> cls, T t) {
        return (T) Primitives.wrap(cls).cast(put((Class<? extends Class<T>>) cls, (Class<T>) t));
    }

    public static <B> MutableClassToInstanceMap<B> create(Map<Class<? extends B>, B> map) {
        return new MutableClassToInstanceMap<>(map);
    }

    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public Map<Class<? extends B>, B> delegate() {
        return this.f14745a;
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public B put(Class<? extends B> cls, B b) {
        return (B) super.put((MutableClassToInstanceMap<B>) cls, (Class<? extends B>) Primitives.wrap(cls).cast(b));
    }
}
