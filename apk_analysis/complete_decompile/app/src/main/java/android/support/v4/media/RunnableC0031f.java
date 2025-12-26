package android.support.v4.media;

import android.support.v4.media.MediaBrowserCompat;

/* renamed from: android.support.v4.media.f */
/* loaded from: classes.dex */
public final class RunnableC0031f implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ MediaBrowserCompat.ItemCallback f326a;

    /* renamed from: b */
    public final /* synthetic */ String f327b;

    public RunnableC0031f(String str, MediaBrowserCompat.ItemCallback itemCallback) {
        this.f326a = itemCallback;
        this.f327b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f326a.onError(this.f327b);
    }
}
