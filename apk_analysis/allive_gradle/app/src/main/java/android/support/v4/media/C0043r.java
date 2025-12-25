package android.support.v4.media;

import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaSessionCompat;
import java.util.List;

/* renamed from: android.support.v4.media.r */
/* loaded from: classes.dex */
public final class C0043r extends C0042q {

    /* renamed from: b */
    public final /* synthetic */ MediaBrowserCompat.SubscriptionCallback f353b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0043r(MediaBrowserCompat.SubscriptionCallback subscriptionCallback) {
        super(subscriptionCallback);
        this.f353b = subscriptionCallback;
    }

    @Override // android.media.browse.MediaBrowser.SubscriptionCallback
    public final void onChildrenLoaded(String str, List list, Bundle bundle) {
        MediaSessionCompat.ensureClassLoader(bundle);
        this.f353b.onChildrenLoaded(str, MediaBrowserCompat.MediaItem.fromMediaItemList(list), bundle);
    }

    @Override // android.media.browse.MediaBrowser.SubscriptionCallback
    public final void onError(String str, Bundle bundle) {
        MediaSessionCompat.ensureClassLoader(bundle);
        this.f353b.onError(str, bundle);
    }
}
