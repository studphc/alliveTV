package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.List;

/* renamed from: com.google.common.collect.l1 */
/* loaded from: classes.dex */
public final class C0898l1 extends C0908n1 implements ListMultimap {
    @Override // com.google.common.collect.C0908n1
    /* renamed from: i */
    public final Collection mo4133i(Collection collection, Object obj) {
        Maps.EntryTransformer entryTransformer = this.f14905g;
        Preconditions.checkNotNull(entryTransformer);
        return Lists.transform((List) collection, new C0907n0(entryTransformer, obj));
    }

    @Override // com.google.common.collect.C0908n1, p000.AbstractC1143e2, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public final Collection replaceValues(Object obj, Iterable iterable) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.C0908n1, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public final List get(Object obj) {
        List list = (List) this.f14904f.get(obj);
        Maps.EntryTransformer entryTransformer = this.f14905g;
        Preconditions.checkNotNull(entryTransformer);
        return Lists.transform(list, new C0907n0(entryTransformer, obj));
    }

    @Override // com.google.common.collect.C0908n1, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public final List removeAll(Object obj) {
        List list = (List) this.f14904f.removeAll(obj);
        Maps.EntryTransformer entryTransformer = this.f14905g;
        Preconditions.checkNotNull(entryTransformer);
        return Lists.transform(list, new C0907n0(entryTransformer, obj));
    }

    @Override // com.google.common.collect.C0908n1, p000.AbstractC1143e2, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public final List replaceValues(Object obj, Iterable iterable) {
        throw new UnsupportedOperationException();
    }
}
