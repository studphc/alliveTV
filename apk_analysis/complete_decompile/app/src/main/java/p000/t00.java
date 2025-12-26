package p000;

import com.google.common.collect.ForwardingMap;
import com.google.common.collect.Sets;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class t00 extends ForwardingMap {

    /* renamed from: a */
    public final Map f26644a;

    public t00(Map map) {
        this.f26644a = map;
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public final boolean containsKey(Object obj) {
        if (obj != null && super.containsKey(obj)) {
            return true;
        }
        return false;
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public final boolean containsValue(Object obj) {
        return super.standardContainsValue(obj);
    }

    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public final Object delegate() {
        return this.f26644a;
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public final Set entrySet() {
        return Sets.filter(super.entrySet(), new C1593np(2));
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public final boolean equals(Object obj) {
        if (obj != null && super.standardEquals(obj)) {
            return true;
        }
        return false;
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public final Object get(Object obj) {
        if (obj == null) {
            return null;
        }
        return (List) super.get(obj);
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public final int hashCode() {
        return super.standardHashCode();
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public final boolean isEmpty() {
        if (super.isEmpty()) {
            return true;
        }
        if (super.size() == 1 && super.containsKey(null)) {
            return true;
        }
        return false;
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public final Set keySet() {
        return Sets.filter(super.keySet(), new C1593np(1));
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public final int size() {
        return super.size() - (super.containsKey(null) ? 1 : 0);
    }

    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public final Map delegate() {
        return this.f26644a;
    }
}
