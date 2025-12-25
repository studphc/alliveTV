package com.google.android.exoplayer2.util;

import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.util.SntpClient;
import java.io.IOException;
import java.util.ConcurrentModificationException;

/* renamed from: com.google.android.exoplayer2.util.c */
/* loaded from: classes.dex */
public final class C0738c implements Loader.Callback {

    /* renamed from: a */
    public final SntpClient.InitializationCallback f12788a;

    public C0738c(SntpClient.InitializationCallback initializationCallback) {
        this.f12788a = initializationCallback;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public final void onLoadCanceled(Loader.Loadable loadable, long j, long j2, boolean z) {
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public final void onLoadCompleted(Loader.Loadable loadable, long j, long j2) {
        SntpClient.InitializationCallback initializationCallback = this.f12788a;
        if (initializationCallback != null) {
            if (!SntpClient.isInitialized()) {
                initializationCallback.onInitializationFailed(new IOException(new ConcurrentModificationException()));
            } else {
                initializationCallback.onInitialized();
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public final Loader.LoadErrorAction onLoadError(Loader.Loadable loadable, long j, long j2, IOException iOException, int i) {
        SntpClient.InitializationCallback initializationCallback = this.f12788a;
        if (initializationCallback != null) {
            initializationCallback.onInitializationFailed(iOException);
        }
        return Loader.DONT_RETRY;
    }
}
