package com.google.common.cache;

import com.google.common.base.Supplier;
import com.google.common.cache.AbstractCache;

/* renamed from: com.google.common.cache.b */
/* loaded from: classes.dex */
public final class C0837b implements Supplier {
    @Override // com.google.common.base.Supplier
    public final Object get() {
        return new AbstractCache.SimpleStatsCounter();
    }
}
