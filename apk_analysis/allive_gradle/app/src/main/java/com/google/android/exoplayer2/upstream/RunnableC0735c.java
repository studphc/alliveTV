package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.Loader;

/* renamed from: com.google.android.exoplayer2.upstream.c */
/* loaded from: classes.dex */
public final class RunnableC0735c implements Runnable {

    /* renamed from: a */
    public final Loader.ReleaseCallback f12579a;

    public RunnableC0735c(Loader.ReleaseCallback releaseCallback) {
        this.f12579a = releaseCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f12579a.onLoaderReleased();
    }
}
