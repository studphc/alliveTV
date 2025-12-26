package p000;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;

/* loaded from: classes.dex */
public abstract class h41 extends ImmutableSet {
    @Override // com.google.common.collect.ImmutableCollection
    /* renamed from: a */
    public final int mo3896a(Object[] objArr, int i) {
        return asList().mo3896a(objArr, i);
    }

    public abstract Object get(int i);

    @Override // com.google.common.collect.ImmutableSet
    /* renamed from: h */
    public final ImmutableList mo3978h() {
        return new g41(this);
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public UnmodifiableIterator iterator() {
        return asList().iterator();
    }
}
