package com.google.android.exoplayer2.offline;

import com.google.android.exoplayer2.offline.Downloader;
import com.google.android.exoplayer2.upstream.cache.CacheWriter;

/* renamed from: com.google.android.exoplayer2.offline.e */
/* loaded from: classes.dex */
public final class C0684e implements CacheWriter.ProgressListener {

    /* renamed from: a */
    public final Downloader.ProgressListener f10877a;

    /* renamed from: b */
    public final long f10878b;

    /* renamed from: c */
    public final int f10879c;

    /* renamed from: d */
    public long f10880d;

    /* renamed from: e */
    public int f10881e;

    public C0684e(Downloader.ProgressListener progressListener, long j, int i, long j2, int i2) {
        this.f10877a = progressListener;
        this.f10878b = j;
        this.f10879c = i;
        this.f10880d = j2;
        this.f10881e = i2;
    }

    /* renamed from: a */
    public final float m2724a() {
        long j = this.f10878b;
        if (j != -1 && j != 0) {
            return (((float) this.f10880d) * 100.0f) / ((float) j);
        }
        int i = this.f10879c;
        if (i != 0) {
            return (this.f10881e * 100.0f) / i;
        }
        return -1.0f;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.CacheWriter.ProgressListener
    public final void onProgress(long j, long j2, long j3) {
        long j4 = this.f10880d + j3;
        this.f10880d = j4;
        this.f10877a.onProgress(this.f10878b, j4, m2724a());
    }
}
