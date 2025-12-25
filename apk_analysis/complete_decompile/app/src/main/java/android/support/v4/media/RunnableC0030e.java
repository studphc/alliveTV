package android.support.v4.media;

import android.support.v4.media.MediaBrowserCompat;

/* renamed from: android.support.v4.media.e */
/* loaded from: classes.dex */
public final class RunnableC0030e implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ MediaBrowserCompat.ItemCallback f324a;

    /* renamed from: b */
    public final /* synthetic */ String f325b;

    public RunnableC0030e(String str, MediaBrowserCompat.ItemCallback itemCallback) {
        this.f324a = itemCallback;
        this.f325b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f324a.onError(this.f325b);
    }
}
