package com.google.android.exoplayer2.offline;

import com.google.android.exoplayer2.util.RunnableFutureTask;

/* renamed from: com.google.android.exoplayer2.offline.d */
/* loaded from: classes.dex */
public final class C0683d extends RunnableFutureTask {

    /* renamed from: h */
    public final /* synthetic */ ProgressiveDownloader f10876h;

    public C0683d(ProgressiveDownloader progressiveDownloader) {
        this.f10876h = progressiveDownloader;
    }

    @Override // com.google.android.exoplayer2.util.RunnableFutureTask
    public final void cancelWork() {
        this.f10876h.f10835d.cancel();
    }

    @Override // com.google.android.exoplayer2.util.RunnableFutureTask
    public final Object doWork() {
        this.f10876h.f10835d.cache();
        return null;
    }
}
