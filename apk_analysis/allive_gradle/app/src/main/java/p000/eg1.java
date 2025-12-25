package p000;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class eg1 implements dg1 {

    /* renamed from: a */
    public final Map f16811a;

    /* renamed from: b */
    public final Function1 f16812b;

    public eg1(Map map, Function1 function1) {
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(function1, "default");
        this.f16811a = map;
        this.f16812b = function1;
    }

    @Override // p000.dg1
    /* renamed from: b */
    public final Object mo4580b(Object obj) {
        Map map = this.f16811a;
        Object obj2 = map.get(obj);
        if (obj2 == null && !map.containsKey(obj)) {
            return this.f16812b.invoke(obj);
        }
        return obj2;
    }

    @Override // java.util.Map
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return this.f16811a.containsKey(obj);
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return this.f16811a.containsValue(obj);
    }

    @Override // p000.dg1
    /* renamed from: d */
    public final Map mo4581d() {
        return this.f16811a;
    }

    @Override // java.util.Map
    public final Set entrySet() {
        return this.f16811a.entrySet();
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        return this.f16811a.equals(obj);
    }

    @Override // java.util.Map
    public final Object get(Object obj) {
        return this.f16811a.get(obj);
    }

    @Override // java.util.Map
    public final int hashCode() {
        return this.f16811a.hashCode();
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.f16811a.isEmpty();
    }

    @Override // java.util.Map
    public final Set keySet() {
        return this.f16811a.keySet();
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final int size() {
        return this.f16811a.size();
    }

    public final String toString() {
        return this.f16811a.toString();
    }

    @Override // java.util.Map
    public final Collection values() {
        return this.f16811a.values();
    }
}
