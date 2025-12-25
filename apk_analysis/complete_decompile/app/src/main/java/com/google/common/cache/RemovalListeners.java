package com.google.common.cache;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.cache.RemovalNotification;
import java.util.concurrent.Executor;

@GwtIncompatible
/* loaded from: classes.dex */
public final class RemovalListeners {
    public static <K, V> RemovalListener<K, V> asynchronous(final RemovalListener<K, V> removalListener, final Executor executor) {
        Preconditions.checkNotNull(removalListener);
        Preconditions.checkNotNull(executor);
        return new RemovalListener() { // from class: na2
            @Override // com.google.common.cache.RemovalListener
            public final void onRemoval(RemovalNotification removalNotification) {
                executor.execute(new RunnableC0583c7(28, removalListener, removalNotification));
            }
        };
    }
}
