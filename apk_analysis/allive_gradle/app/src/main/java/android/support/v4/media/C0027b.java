package android.support.v4.media;

import android.media.browse.MediaBrowser;
import android.support.v4.media.MediaBrowserCompat;

/* renamed from: android.support.v4.media.b */
/* loaded from: classes.dex */
public final class C0027b extends MediaBrowser.ItemCallback {

    /* renamed from: a */
    public final /* synthetic */ MediaBrowserCompat.ItemCallback f321a;

    public C0027b(MediaBrowserCompat.ItemCallback itemCallback) {
        this.f321a = itemCallback;
    }

    @Override // android.media.browse.MediaBrowser.ItemCallback
    public final void onError(String str) {
        this.f321a.onError(str);
    }

    @Override // android.media.browse.MediaBrowser.ItemCallback
    public final void onItemLoaded(MediaBrowser.MediaItem mediaItem) {
        this.f321a.onItemLoaded(MediaBrowserCompat.MediaItem.fromMediaItem(mediaItem));
    }
}
