package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class eq1 extends ForwardingMultimap implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final Multimap f16945a;

    /* renamed from: b */
    public transient qd0 f16946b;

    /* renamed from: c */
    public transient Multiset f16947c;

    /* renamed from: d */
    public transient Set f16948d;

    /* renamed from: e */
    public transient Collection f16949e;

    /* renamed from: f */
    public transient Map f16950f;

    public eq1(Multimap multimap) {
        this.f16945a = (Multimap) Preconditions.checkNotNull(multimap);
    }

    @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public final Map asMap() {
        Map map = this.f16950f;
        if (map == null) {
            Map unmodifiableMap = Collections.unmodifiableMap(Maps.transformValues(this.f16945a.asMap(), new n82(5)));
            this.f16950f = unmodifiableMap;
            return unmodifiableMap;
        }
        return map;
    }

    @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public Collection entries() {
        qd0 qd0Var;
        qd0 qd0Var2 = this.f16946b;
        if (qd0Var2 == null) {
            Collection entries = this.f16945a.entries();
            if (entries instanceof Set) {
                qd0Var = new qd0(Collections.unmodifiableSet((Set) entries));
            } else {
                qd0Var = new qd0(Collections.unmodifiableCollection(entries));
            }
            qd0Var2 = qd0Var;
            this.f16946b = qd0Var2;
        }
        return qd0Var2;
    }

    @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public Collection get(Object obj) {
        return Multimaps.m4059a(this.f16945a.get(obj));
    }

    @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
    public final Set keySet() {
        Set set = this.f16948d;
        if (set == null) {
            Set unmodifiableSet = Collections.unmodifiableSet(this.f16945a.keySet());
            this.f16948d = unmodifiableSet;
            return unmodifiableSet;
        }
        return set;
    }

    @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
    public final Multiset keys() {
        Multiset multiset = this.f16947c;
        if (multiset == null) {
            Multiset unmodifiableMultiset = Multisets.unmodifiableMultiset(this.f16945a.keys());
            this.f16947c = unmodifiableMultiset;
            return unmodifiableMultiset;
        }
        return multiset;
    }

    @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
    public final boolean put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
    public final boolean putAll(Object obj, Iterable iterable) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
    public final boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public Collection removeAll(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public Collection replaceValues(Object obj, Iterable iterable) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
    public final Collection values() {
        Collection collection = this.f16949e;
        if (collection == null) {
            Collection unmodifiableCollection = Collections.unmodifiableCollection(this.f16945a.values());
            this.f16949e = unmodifiableCollection;
            return unmodifiableCollection;
        }
        return collection;
    }

    @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.ForwardingObject
    public Multimap delegate() {
        return this.f16945a;
    }

    @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
    public final boolean putAll(Multimap multimap) {
        throw new UnsupportedOperationException();
    }
}
