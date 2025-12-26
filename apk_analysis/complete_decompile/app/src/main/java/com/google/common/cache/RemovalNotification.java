package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.AbstractMap;
import javax.annotation.CheckForNull;

@GwtCompatible
/* loaded from: classes.dex */
public final class RemovalNotification<K, V> extends AbstractMap.SimpleImmutableEntry<K, V> {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final RemovalCause f14568a;

    public RemovalNotification(Object obj, Object obj2, RemovalCause removalCause) {
        super(obj, obj2);
        this.f14568a = (RemovalCause) Preconditions.checkNotNull(removalCause);
    }

    public static <K, V> RemovalNotification<K, V> create(@CheckForNull K k, @CheckForNull V v, RemovalCause removalCause) {
        return new RemovalNotification<>(k, v, removalCause);
    }

    public RemovalCause getCause() {
        return this.f14568a;
    }

    public boolean wasEvicted() {
        return this.f14568a.mo3792a();
    }
}
