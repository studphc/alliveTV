package p000;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;

/* loaded from: classes2.dex */
public final class sq1 implements Map, dg1, KMutableMap {

    /* renamed from: a */
    public final Map f26533a;

    /* renamed from: b */
    public final Function1 f26534b;

    public sq1(Map map, Function1 function1) {
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(function1, "default");
        this.f26533a = map;
        this.f26534b = function1;
    }

    @Override // p000.dg1
    /* renamed from: b */
    public final Object mo4580b(Object obj) {
        Map map = this.f26533a;
        Object obj2 = map.get(obj);
        if (obj2 == null && !map.containsKey(obj)) {
            return this.f26534b.invoke(obj);
        }
        return obj2;
    }

    @Override // java.util.Map
    public final void clear() {
        this.f26533a.clear();
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return this.f26533a.containsKey(obj);
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return this.f26533a.containsValue(obj);
    }

    @Override // p000.dg1
    /* renamed from: d */
    public final Map mo4581d() {
        return this.f26533a;
    }

    @Override // java.util.Map
    public final Set entrySet() {
        return this.f26533a.entrySet();
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        return this.f26533a.equals(obj);
    }

    @Override // java.util.Map
    public final Object get(Object obj) {
        return this.f26533a.get(obj);
    }

    @Override // java.util.Map
    public final int hashCode() {
        return this.f26533a.hashCode();
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.f26533a.isEmpty();
    }

    @Override // java.util.Map
    public final Set keySet() {
        return this.f26533a.keySet();
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        return this.f26533a.put(obj, obj2);
    }

    @Override // java.util.Map
    public final void putAll(Map from) {
        Intrinsics.checkNotNullParameter(from, "from");
        this.f26533a.putAll(from);
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        return this.f26533a.remove(obj);
    }

    @Override // java.util.Map
    public final int size() {
        return this.f26533a.size();
    }

    public final String toString() {
        return this.f26533a.toString();
    }

    @Override // java.util.Map
    public final Collection values() {
        return this.f26533a.values();
    }
}
