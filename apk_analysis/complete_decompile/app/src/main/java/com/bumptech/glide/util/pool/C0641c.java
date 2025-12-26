package com.bumptech.glide.util.pool;

import com.bumptech.glide.util.pool.FactoryPools;
import java.util.List;

/* renamed from: com.bumptech.glide.util.pool.c */
/* loaded from: classes.dex */
public final class C0641c implements FactoryPools.Resetter {
    @Override // com.bumptech.glide.util.pool.FactoryPools.Resetter
    public final void reset(Object obj) {
        ((List) obj).clear();
    }
}
