package com.google.android.exoplayer2.offline;

import com.google.android.exoplayer2.offline.SegmentDownloader;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.exoplayer2.upstream.cache.CacheWriter;
import com.google.android.exoplayer2.util.RunnableFutureTask;

/* renamed from: com.google.android.exoplayer2.offline.f */
/* loaded from: classes.dex */
public final class C0685f extends RunnableFutureTask {

    /* renamed from: h */
    public final SegmentDownloader.Segment f10882h;

    /* renamed from: i */
    public final CacheDataSource f10883i;

    /* renamed from: j */
    public final C0684e f10884j;

    /* renamed from: k */
    public final byte[] f10885k;

    /* renamed from: l */
    public final CacheWriter f10886l;

    public C0685f(SegmentDownloader.Segment segment, CacheDataSource cacheDataSource, C0684e c0684e, byte[] bArr) {
        this.f10882h = segment;
        this.f10883i = cacheDataSource;
        this.f10884j = c0684e;
        this.f10885k = bArr;
        this.f10886l = new CacheWriter(cacheDataSource, segment.dataSpec, bArr, c0684e);
    }

    @Override // com.google.android.exoplayer2.util.RunnableFutureTask
    public final void cancelWork() {
        this.f10886l.cancel();
    }

    @Override // com.google.android.exoplayer2.util.RunnableFutureTask
    public final Object doWork() {
        this.f10886l.cache();
        C0684e c0684e = this.f10884j;
        if (c0684e != null) {
            c0684e.f10881e++;
            c0684e.f10877a.onProgress(c0684e.f10878b, c0684e.f10880d, c0684e.m2724a());
            return null;
        }
        return null;
    }
}
