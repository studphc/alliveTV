package p000;

import com.google.common.collect.BiMap;
import com.google.common.collect.ForwardingMap;
import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class eh1 extends ForwardingMap implements BiMap, Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final Map f16825a;

    /* renamed from: b */
    public final BiMap f16826b;

    /* renamed from: c */
    public eh1 f16827c;

    /* renamed from: d */
    public transient Set f16828d;

    public eh1(BiMap biMap, eh1 eh1Var) {
        this.f16825a = Collections.unmodifiableMap(biMap);
        this.f16826b = biMap;
        this.f16827c = eh1Var;
    }

    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public final Object delegate() {
        return this.f16825a;
    }

    @Override // com.google.common.collect.BiMap
    public final Object forcePut(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.BiMap
    public final BiMap inverse() {
        eh1 eh1Var = this.f16827c;
        if (eh1Var == null) {
            eh1 eh1Var2 = new eh1(this.f16826b.inverse(), this);
            this.f16827c = eh1Var2;
            return eh1Var2;
        }
        return eh1Var;
    }

    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public final Map delegate() {
        return this.f16825a;
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    public final Set values() {
        Set set = this.f16828d;
        if (set != null) {
            return set;
        }
        Set unmodifiableSet = Collections.unmodifiableSet(this.f16826b.values());
        this.f16828d = unmodifiableSet;
        return unmodifiableSet;
    }
}
