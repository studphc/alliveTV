package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.C0893k1;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.SetMultimap;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class cq1 extends AbstractC1143e2 implements SetMultimap, Serializable {
    private static final long serialVersionUID = 7845222491160860175L;

    /* renamed from: f */
    public final Map f16083f;

    public cq1(Map map) {
        this.f16083f = (Map) Preconditions.checkNotNull(map);
    }

    @Override // p000.AbstractC1143e2
    /* renamed from: b */
    public final Map mo3947b() {
        return new kd0(this);
    }

    @Override // com.google.common.collect.Multimap
    public final void clear() {
        this.f16083f.clear();
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap
    public final boolean containsEntry(Object obj, Object obj2) {
        return this.f16083f.entrySet().contains(Maps.immutableEntry(obj, obj2));
    }

    @Override // com.google.common.collect.Multimap
    public final boolean containsKey(Object obj) {
        return this.f16083f.containsKey(obj);
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap
    public final boolean containsValue(Object obj) {
        return this.f16083f.containsValue(obj);
    }

    @Override // p000.AbstractC1143e2
    /* renamed from: d */
    public final Collection mo3948d() {
        throw new AssertionError("unreachable");
    }

    @Override // p000.AbstractC1143e2
    /* renamed from: e */
    public final Set mo3949e() {
        return this.f16083f.keySet();
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public final Collection entries() {
        return this.f16083f.entrySet();
    }

    @Override // p000.AbstractC1143e2
    /* renamed from: f */
    public final Multiset mo3950f() {
        return new C0893k1(this);
    }

    @Override // p000.AbstractC1143e2
    /* renamed from: g */
    public final Collection mo3951g() {
        return this.f16083f.values();
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public final Collection get(Object obj) {
        return new bq1(this, obj);
    }

    @Override // p000.AbstractC1143e2
    /* renamed from: h */
    public final Iterator mo3952h() {
        return this.f16083f.entrySet().iterator();
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap
    public final int hashCode() {
        return this.f16083f.hashCode();
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap
    public final boolean put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap
    public final boolean putAll(Object obj, Iterable iterable) {
        throw new UnsupportedOperationException();
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap
    public final boolean remove(Object obj, Object obj2) {
        return this.f16083f.entrySet().remove(Maps.immutableEntry(obj, obj2));
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public final Collection replaceValues(Object obj, Iterable iterable) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Multimap
    public final int size() {
        return this.f16083f.size();
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public final Set entries() {
        return this.f16083f.entrySet();
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public final Set get(Object obj) {
        return new bq1(this, obj);
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap
    public final boolean putAll(Multimap multimap) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public final Set removeAll(Object obj) {
        HashSet hashSet = new HashSet(2);
        Map map = this.f16083f;
        if (!map.containsKey(obj)) {
            return hashSet;
        }
        hashSet.add(map.remove(obj));
        return hashSet;
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public final Set replaceValues(Object obj, Iterable iterable) {
        throw new UnsupportedOperationException();
    }
}
