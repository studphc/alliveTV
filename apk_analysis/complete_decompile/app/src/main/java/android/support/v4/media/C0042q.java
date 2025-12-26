package android.support.v4.media;

import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: android.support.v4.media.q */
/* loaded from: classes.dex */
public class C0042q extends MediaBrowser.SubscriptionCallback {

    /* renamed from: a */
    public final /* synthetic */ MediaBrowserCompat.SubscriptionCallback f352a;

    public C0042q(MediaBrowserCompat.SubscriptionCallback subscriptionCallback) {
        this.f352a = subscriptionCallback;
    }

    @Override // android.media.browse.MediaBrowser.SubscriptionCallback
    public final void onChildrenLoaded(String str, List list) {
        C0041p c0041p;
        List<MediaBrowserCompat.MediaItem> emptyList;
        MediaBrowserCompat.SubscriptionCallback subscriptionCallback = this.f352a;
        WeakReference weakReference = subscriptionCallback.f291c;
        if (weakReference == null) {
            c0041p = null;
        } else {
            c0041p = (C0041p) weakReference.get();
        }
        if (c0041p == null) {
            subscriptionCallback.onChildrenLoaded(str, MediaBrowserCompat.MediaItem.fromMediaItemList(list));
            return;
        }
        List<MediaBrowserCompat.MediaItem> fromMediaItemList = MediaBrowserCompat.MediaItem.fromMediaItemList(list);
        ArrayList arrayList = c0041p.f350a;
        ArrayList arrayList2 = c0041p.f351b;
        for (int i = 0; i < arrayList.size(); i++) {
            Bundle bundle = (Bundle) arrayList2.get(i);
            if (bundle == null) {
                subscriptionCallback.onChildrenLoaded(str, fromMediaItemList);
            } else {
                if (fromMediaItemList == null) {
                    emptyList = null;
                } else {
                    int i2 = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE, -1);
                    int i3 = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1);
                    if (i2 == -1 && i3 == -1) {
                        emptyList = fromMediaItemList;
                    } else {
                        int i4 = i3 * i2;
                        int i5 = i4 + i3;
                        if (i2 >= 0 && i3 >= 1 && i4 < fromMediaItemList.size()) {
                            if (i5 > fromMediaItemList.size()) {
                                i5 = fromMediaItemList.size();
                            }
                            emptyList = fromMediaItemList.subList(i4, i5);
                        } else {
                            emptyList = Collections.emptyList();
                        }
                    }
                }
                subscriptionCallback.onChildrenLoaded(str, emptyList, bundle);
            }
        }
    }

    @Override // android.media.browse.MediaBrowser.SubscriptionCallback
    public final void onError(String str) {
        this.f352a.onError(str);
    }
}
