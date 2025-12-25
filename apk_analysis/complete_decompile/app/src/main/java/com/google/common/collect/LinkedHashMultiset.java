package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true, serializable = true)
/* loaded from: classes.dex */
public final class LinkedHashMultiset<E> extends AbstractC0846b {
    public static <E> LinkedHashMultiset<E> create() {
        return create(3);
    }

    @Override // com.google.common.collect.AbstractC0856d, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ boolean contains(@CheckForNull Object obj) {
        return super.contains(obj);
    }

    @Override // com.google.common.collect.AbstractC0846b
    /* renamed from: e */
    public final C0869f2 mo3881e(int i) {
        return new C0869f2(i, 0);
    }

    @Override // com.google.common.collect.AbstractC0856d, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set elementSet() {
        return super.elementSet();
    }

    @Override // com.google.common.collect.AbstractC0856d, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.AbstractC0856d, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    public static <E> LinkedHashMultiset<E> create(int i) {
        return (LinkedHashMultiset<E>) new AbstractC0846b(i);
    }

    public static <E> LinkedHashMultiset<E> create(Iterable<? extends E> iterable) {
        LinkedHashMultiset<E> create = create(iterable instanceof Multiset ? ((Multiset) iterable).elementSet().size() : 11);
        Iterables.addAll(create, iterable);
        return create;
    }
}
