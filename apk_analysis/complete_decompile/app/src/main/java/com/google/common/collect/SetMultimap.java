package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible
/* loaded from: classes.dex */
public interface SetMultimap<K, V> extends Multimap<K, V> {
    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    Map<K, Collection<V>> asMap();

    @Override // 
    /* bridge */ /* synthetic */ Collection entries();

    @Override // com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    Set<Map.Entry<K, V>> entries();

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    boolean equals(@CheckForNull Object obj);

    @Override // 
    /* bridge */ /* synthetic */ Collection get(Object obj);

    @Override // com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    Set<V> get(K k);

    @Override // 
    @CanIgnoreReturnValue
    /* bridge */ /* synthetic */ Collection removeAll(@CheckForNull Object obj);

    @Override // com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    @CanIgnoreReturnValue
    Set<V> removeAll(@CheckForNull Object obj);

    @Override // 
    @CanIgnoreReturnValue
    /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable);

    @Override // com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    @CanIgnoreReturnValue
    Set<V> replaceValues(K k, Iterable<? extends V> iterable);
}
