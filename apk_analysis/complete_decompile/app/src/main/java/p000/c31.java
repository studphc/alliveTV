package p000;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class c31 extends h41 {

    /* renamed from: c */
    public final w21 f8243c;

    public c31(w21 w21Var) {
        this.f8243c = w21Var;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.f8243c.containsKey(obj);
    }

    @Override // com.google.common.collect.ImmutableCollection
    /* renamed from: e */
    public final boolean mo7e() {
        return true;
    }

    @Override // p000.h41
    public final Object get(int i) {
        return ((Map.Entry) this.f8243c.entrySet().asList().get(i)).getKey();
    }

    @Override // p000.h41, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final UnmodifiableIterator iterator() {
        return this.f8243c.mo3938i();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f8243c.size();
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    @GwtIncompatible
    public Object writeReplace() {
        return new b31(this.f8243c);
    }

    @Override // p000.h41, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return this.f8243c.mo3938i();
    }
}
