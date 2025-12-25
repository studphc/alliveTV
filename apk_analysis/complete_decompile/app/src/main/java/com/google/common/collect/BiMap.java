package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible
/* loaded from: classes.dex */
public interface BiMap<K, V> extends Map<K, V> {
    @CanIgnoreReturnValue
    @CheckForNull
    V forcePut(K k, V v);

    BiMap<V, K> inverse();

    @Override // java.util.Map
    @CanIgnoreReturnValue
    @CheckForNull
    V put(K k, V v);

    @Override // java.util.Map
    void putAll(Map<? extends K, ? extends V> map);

    @Override // java.util.Map
    /* bridge */ /* synthetic */ Collection values();

    @Override // java.util.Map
    Set<V> values();
}
