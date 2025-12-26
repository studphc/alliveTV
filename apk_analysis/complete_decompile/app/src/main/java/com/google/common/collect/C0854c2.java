package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.util.Iterator;
import java.util.Set;
import p000.kq1;
import p000.p63;

/* renamed from: com.google.common.collect.c2 */
/* loaded from: classes.dex */
public final class C0854c2 extends kq1 {

    /* renamed from: c */
    public final Multiset f14786c;

    /* renamed from: d */
    public final Predicate f14787d;

    public C0854c2(Multiset multiset, Predicate predicate) {
        this.f14786c = (Multiset) Preconditions.checkNotNull(multiset);
        this.f14787d = (Predicate) Preconditions.checkNotNull(predicate);
    }

    @Override // com.google.common.collect.AbstractC0856d
    /* renamed from: a */
    public final Set mo3837a() {
        return Sets.filter(this.f14786c.elementSet(), this.f14787d);
    }

    @Override // com.google.common.collect.AbstractC0856d, com.google.common.collect.Multiset
    public final int add(Object obj, int i) {
        Predicate predicate = this.f14787d;
        Preconditions.checkArgument(predicate.apply(obj), "Element %s does not match predicate %s", obj, predicate);
        return this.f14786c.add(obj, i);
    }

    @Override // com.google.common.collect.AbstractC0856d
    /* renamed from: c */
    public final Iterator mo3839c() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.Multiset
    public final int count(Object obj) {
        int count = this.f14786c.count(obj);
        if (count <= 0 || !this.f14787d.apply(obj)) {
            return 0;
        }
        return count;
    }

    @Override // com.google.common.collect.AbstractC0856d
    public final Set createEntrySet() {
        return Sets.filter(this.f14786c.entrySet(), new C0849b2(this));
    }

    @Override // com.google.common.collect.AbstractC0856d
    /* renamed from: d */
    public final Iterator mo3840d() {
        throw new AssertionError("should never be called");
    }

    @Override // p000.kq1, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
    public final Iterator iterator() {
        return Iterators.filter(this.f14786c.iterator(), this.f14787d);
    }

    @Override // com.google.common.collect.AbstractC0856d, com.google.common.collect.Multiset
    public final int remove(Object obj, int i) {
        p63.m6869m(i, "occurrences");
        if (i == 0) {
            return count(obj);
        }
        if (contains(obj)) {
            return this.f14786c.remove(obj, i);
        }
        return 0;
    }
}
