package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.Multiset;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import p000.k31;

/* renamed from: com.google.common.collect.c0 */
/* loaded from: classes.dex */
public final class C0852c0 extends ImmutableMultiset {

    /* renamed from: e */
    public final /* synthetic */ ImmutableMultimap f14783e;

    public C0852c0(ImmutableMultimap immutableMultimap) {
        this.f14783e = immutableMultimap;
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.f14783e.containsKey(obj);
    }

    @Override // com.google.common.collect.Multiset
    public final int count(Object obj) {
        Collection collection = (Collection) this.f14783e.f14675f.get(obj);
        if (collection == null) {
            return 0;
        }
        return collection.size();
    }

    @Override // com.google.common.collect.ImmutableCollection
    /* renamed from: e */
    public final boolean mo7e() {
        return true;
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
    public final ImmutableSet elementSet() {
        return this.f14783e.keySet();
    }

    @Override // com.google.common.collect.ImmutableMultiset
    /* renamed from: g */
    public final Multiset.Entry mo3962g(int i) {
        Map.Entry entry = (Map.Entry) this.f14783e.f14675f.entrySet().asList().get(i);
        return Multisets.immutableEntry(entry.getKey(), ((Collection) entry.getValue()).size());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public final int size() {
        return this.f14783e.size();
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection
    @GwtIncompatible
    public Object writeReplace() {
        return new k31(this.f14783e);
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
    public final Set elementSet() {
        return this.f14783e.keySet();
    }
}
