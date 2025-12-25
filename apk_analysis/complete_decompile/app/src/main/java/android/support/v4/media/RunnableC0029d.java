package android.support.v4.media;

import android.support.v4.media.MediaBrowserCompat;

/* renamed from: android.support.v4.media.d */
/* loaded from: classes.dex */
public final class RunnableC0029d implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ MediaBrowserCompat.ItemCallback f322a;

    /* renamed from: b */
    public final /* synthetic */ String f323b;

    public RunnableC0029d(String str, MediaBrowserCompat.ItemCallback itemCallback) {
        this.f322a = itemCallback;
        this.f323b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f322a.onError(this.f323b);
    }
}
