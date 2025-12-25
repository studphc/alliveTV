package com.google.android.exoplayer2.upstream.cache;

import com.google.android.exoplayer2.upstream.DataSpec;
import p000.C1255h3;

/* loaded from: classes.dex */
public interface CacheKeyFactory {
    public static final CacheKeyFactory DEFAULT = new C1255h3(8);

    String buildCacheKey(DataSpec dataSpec);
}
