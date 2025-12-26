package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import p000.hh1;
import p000.yg1;

/* renamed from: com.google.common.collect.u0 */
/* loaded from: classes.dex */
public class C0938u0 extends yg1 {

    /* renamed from: a */
    public final Map f14969a;

    /* renamed from: b */
    public final Maps.EntryTransformer f14970b;

    public C0938u0(Map map, Maps.EntryTransformer entryTransformer) {
        this.f14969a = (Map) Preconditions.checkNotNull(map);
        this.f14970b = (Maps.EntryTransformer) Preconditions.checkNotNull(entryTransformer);
    }

    @Override // p000.yg1
    /* renamed from: a */
    public final Iterator mo84a() {
        Iterator it = this.f14969a.entrySet().iterator();
        Maps.EntryTransformer entryTransformer = this.f14970b;
        Preconditions.checkNotNull(entryTransformer);
        return Iterators.transform(it, new C0922q0(entryTransformer));
    }

    @Override // p000.yg1, java.util.AbstractMap, java.util.Map
    public final void clear() {
        this.f14969a.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        return this.f14969a.containsKey(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Map map = this.f14969a;
        Object obj2 = map.get(obj);
        if (obj2 == null && !map.containsKey(obj)) {
            return null;
        }
        return this.f14970b.transformEntry(obj, obj2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        return this.f14969a.keySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        Map map = this.f14969a;
        if (map.containsKey(obj)) {
            return this.f14970b.transformEntry(obj, map.remove(obj));
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f14969a.size();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection values() {
        return new hh1(this);
    }
}
