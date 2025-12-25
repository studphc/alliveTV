package p000;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.BiMap;
import com.google.common.collect.ForwardingMap;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.EnumMap;
import java.util.Map;
import java.util.Set;

/* renamed from: q */
/* loaded from: classes.dex */
public abstract class AbstractC1706q extends ForwardingMap implements BiMap, Serializable {

    @GwtIncompatible
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public transient AbstractMap f25352a;

    /* renamed from: b */
    public transient AbstractC1706q f25353b;

    /* renamed from: c */
    public transient C1669p f25354c;

    /* renamed from: d */
    public transient C1567n f25355d;

    /* renamed from: e */
    public transient C1567n f25356e;

    public AbstractC1706q(EnumMap enumMap, AbstractMap abstractMap) {
        m6939h(enumMap, abstractMap);
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public void clear() {
        this.f25352a.clear();
        this.f25353b.f25352a.clear();
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public boolean containsValue(Object obj) {
        return this.f25353b.containsKey(obj);
    }

    /* renamed from: e */
    public abstract Object mo3851e(Object obj);

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public Set entrySet() {
        C1567n c1567n = this.f25356e;
        if (c1567n == null) {
            C1567n c1567n2 = new C1567n(this, 0);
            this.f25356e = c1567n2;
            return c1567n2;
        }
        return c1567n;
    }

    public Object forcePut(Object obj, Object obj2) {
        return m6938g(obj, obj2, true);
    }

    /* renamed from: g */
    public final Object m6938g(Object obj, Object obj2, boolean z) {
        mo3851e(obj);
        mo3852f(obj2);
        boolean containsKey = containsKey(obj);
        if (containsKey && Objects.equal(obj2, get(obj))) {
            return obj2;
        }
        if (z) {
            inverse().remove(obj2);
        } else {
            Preconditions.checkArgument(!containsValue(obj2), "value already present: %s", obj2);
        }
        Object put = this.f25352a.put(obj, obj2);
        if (containsKey) {
            this.f25353b.f25352a.remove(put);
        }
        this.f25353b.f25352a.put(obj2, obj);
        return put;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [q, com.google.common.collect.ForwardingMap] */
    /* renamed from: h */
    public final void m6939h(EnumMap enumMap, AbstractMap abstractMap) {
        boolean z;
        boolean z2;
        boolean z3 = false;
        if (this.f25352a == null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        if (this.f25353b == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkState(z2);
        Preconditions.checkArgument(enumMap.isEmpty());
        Preconditions.checkArgument(abstractMap.isEmpty());
        if (enumMap != abstractMap) {
            z3 = true;
        }
        Preconditions.checkArgument(z3);
        this.f25352a = enumMap;
        ?? forwardingMap = new ForwardingMap();
        forwardingMap.f25352a = abstractMap;
        forwardingMap.f25353b = this;
        this.f25353b = forwardingMap;
    }

    public BiMap inverse() {
        return this.f25353b;
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public Set keySet() {
        C1669p c1669p = this.f25354c;
        if (c1669p == null) {
            C1669p c1669p2 = new C1669p(this, 0);
            this.f25354c = c1669p2;
            return c1669p2;
        }
        return c1669p;
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    public Object put(Object obj, Object obj2) {
        return m6938g(obj, obj2, false);
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    public void putAll(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public Object remove(Object obj) {
        if (containsKey(obj)) {
            Object remove = this.f25352a.remove(obj);
            this.f25353b.f25352a.remove(remove);
            return remove;
        }
        return null;
    }

    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public Map<Object, Object> delegate() {
        return this.f25352a;
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    public Set values() {
        C1567n c1567n = this.f25355d;
        if (c1567n != null) {
            return c1567n;
        }
        C1567n c1567n2 = new C1567n(this, 1);
        this.f25355d = c1567n2;
        return c1567n2;
    }

    /* renamed from: f */
    public Object mo3852f(Object obj) {
        return obj;
    }
}
