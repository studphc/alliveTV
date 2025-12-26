package android.support.v4.media;

import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat;

/* renamed from: android.support.v4.media.m */
/* loaded from: classes.dex */
public final class C0038m extends C0037l {
    @Override // android.support.v4.media.AbstractC0036k, android.support.v4.media.InterfaceC0028c
    /* renamed from: a */
    public final void mo117a(String str, Bundle bundle, MediaBrowserCompat.SubscriptionCallback subscriptionCallback) {
        if (this.f346g != null && this.f345f >= 2) {
            super.mo117a(str, bundle, subscriptionCallback);
            return;
        }
        MediaBrowser mediaBrowser = this.f341b;
        if (bundle != null) {
            mediaBrowser.subscribe(str, bundle, subscriptionCallback.f289a);
        } else {
            mediaBrowser.subscribe(str, subscriptionCallback.f289a);
        }
    }

    @Override // android.support.v4.media.AbstractC0036k, android.support.v4.media.InterfaceC0028c
    /* renamed from: b */
    public final void mo118b(String str, MediaBrowserCompat.SubscriptionCallback subscriptionCallback) {
        if (this.f346g != null && this.f345f >= 2) {
            super.mo118b(str, subscriptionCallback);
            return;
        }
        MediaBrowser mediaBrowser = this.f341b;
        if (subscriptionCallback != null) {
            mediaBrowser.unsubscribe(str, subscriptionCallback.f289a);
        } else {
            mediaBrowser.unsubscribe(str);
        }
    }
}
