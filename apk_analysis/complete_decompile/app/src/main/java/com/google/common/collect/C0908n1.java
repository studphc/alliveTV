package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p000.AbstractC1143e2;
import p000.C0578c2;

/* renamed from: com.google.common.collect.n1 */
/* loaded from: classes.dex */
public class C0908n1 extends AbstractC1143e2 {

    /* renamed from: f */
    public final Multimap f14904f;

    /* renamed from: g */
    public final Maps.EntryTransformer f14905g;

    public C0908n1(Multimap multimap, Maps.EntryTransformer entryTransformer) {
        this.f14904f = (Multimap) Preconditions.checkNotNull(multimap);
        this.f14905g = (Maps.EntryTransformer) Preconditions.checkNotNull(entryTransformer);
    }

    @Override // p000.AbstractC1143e2
    /* renamed from: b */
    public final Map mo3947b() {
        return Maps.transformEntries(this.f14904f.asMap(), new C0903m1(this));
    }

    @Override // com.google.common.collect.Multimap
    public final void clear() {
        this.f14904f.clear();
    }

    @Override // com.google.common.collect.Multimap
    public final boolean containsKey(Object obj) {
        return this.f14904f.containsKey(obj);
    }

    @Override // p000.AbstractC1143e2
    /* renamed from: d */
    public final Collection mo3948d() {
        return new C0578c2(0, this);
    }

    @Override // p000.AbstractC1143e2
    /* renamed from: e */
    public final Set mo3949e() {
        return this.f14904f.keySet();
    }

    @Override // p000.AbstractC1143e2
    /* renamed from: f */
    public final Multiset mo3950f() {
        return this.f14904f.keys();
    }

    @Override // p000.AbstractC1143e2
    /* renamed from: g */
    public final Collection mo3951g() {
        Collection entries = this.f14904f.entries();
        Maps.EntryTransformer entryTransformer = this.f14905g;
        Preconditions.checkNotNull(entryTransformer);
        return Collections2.transform(entries, new C0912o0(entryTransformer));
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public Collection get(Object obj) {
        return mo4133i(this.f14904f.get(obj), obj);
    }

    @Override // p000.AbstractC1143e2
    /* renamed from: h */
    public final Iterator mo3952h() {
        Iterator it = this.f14904f.entries().iterator();
        Maps.EntryTransformer entryTransformer = this.f14905g;
        Preconditions.checkNotNull(entryTransformer);
        return Iterators.transform(it, new C0922q0(entryTransformer));
    }

    /* renamed from: i */
    public Collection mo4133i(Collection collection, Object obj) {
        Maps.EntryTransformer entryTransformer = this.f14905g;
        Preconditions.checkNotNull(entryTransformer);
        C0907n0 c0907n0 = new C0907n0(entryTransformer, obj);
        if (collection instanceof List) {
            return Lists.transform((List) collection, c0907n0);
        }
        return Collections2.transform(collection, c0907n0);
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap
    public final boolean isEmpty() {
        return this.f14904f.isEmpty();
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
        return get(obj).remove(obj2);
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public Collection removeAll(Object obj) {
        return mo4133i(this.f14904f.removeAll(obj), obj);
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public Collection replaceValues(Object obj, Iterable iterable) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Multimap
    public final int size() {
        return this.f14904f.size();
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap
    public final boolean putAll(Multimap multimap) {
        throw new UnsupportedOperationException();
    }
}
