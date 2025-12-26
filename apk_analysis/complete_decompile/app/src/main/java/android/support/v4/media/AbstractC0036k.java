package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Binder;
import android.os.Bundle;
import android.os.Messenger;
import android.os.Process;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.core.app.BundleCompat;
import androidx.media.MediaBrowserCompatUtils;
import androidx.media.MediaBrowserProtocol;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import p000.C1540m9;
import p000.qk1;

/* renamed from: android.support.v4.media.k */
/* loaded from: classes.dex */
public abstract class AbstractC0036k implements InterfaceC0028c, InterfaceC0039n {

    /* renamed from: a */
    public final Context f340a;

    /* renamed from: b */
    public final MediaBrowser f341b;

    /* renamed from: c */
    public final Bundle f342c;

    /* renamed from: d */
    public final qk1 f343d = new qk1(this);

    /* renamed from: e */
    public final ArrayMap f344e = new ArrayMap();

    /* renamed from: f */
    public int f345f;

    /* renamed from: g */
    public C1540m9 f346g;

    /* renamed from: h */
    public Messenger f347h;

    /* renamed from: i */
    public MediaSessionCompat.Token f348i;

    /* renamed from: j */
    public Bundle f349j;

    public AbstractC0036k(Context context, ComponentName componentName, MediaBrowserCompat.ConnectionCallback connectionCallback, Bundle bundle) {
        Bundle bundle2;
        this.f340a = context;
        if (bundle != null) {
            bundle2 = new Bundle(bundle);
        } else {
            bundle2 = new Bundle();
        }
        this.f342c = bundle2;
        bundle2.putInt(MediaBrowserProtocol.EXTRA_CLIENT_VERSION, 1);
        bundle2.putInt(MediaBrowserProtocol.EXTRA_CALLING_PID, Process.myPid());
        connectionCallback.f277b = this;
        this.f341b = new MediaBrowser(context, componentName, connectionCallback.f276a, bundle2);
    }

    @Override // android.support.v4.media.InterfaceC0028c
    /* renamed from: a */
    public void mo117a(String str, Bundle bundle, MediaBrowserCompat.SubscriptionCallback subscriptionCallback) {
        Bundle bundle2;
        ArrayMap arrayMap = this.f344e;
        C0041p c0041p = (C0041p) arrayMap.get(str);
        if (c0041p == null) {
            c0041p = new C0041p();
            arrayMap.put(str, c0041p);
        }
        subscriptionCallback.getClass();
        subscriptionCallback.f291c = new WeakReference(c0041p);
        if (bundle == null) {
            bundle2 = null;
        } else {
            bundle2 = new Bundle(bundle);
        }
        int i = 0;
        while (true) {
            ArrayList arrayList = c0041p.f351b;
            int size = arrayList.size();
            ArrayList arrayList2 = c0041p.f350a;
            if (i < size) {
                if (MediaBrowserCompatUtils.areSameOptions((Bundle) arrayList.get(i), bundle2)) {
                    arrayList2.set(i, subscriptionCallback);
                    break;
                }
                i++;
            } else {
                arrayList2.add(subscriptionCallback);
                arrayList.add(bundle2);
                break;
            }
        }
        C1540m9 c1540m9 = this.f346g;
        if (c1540m9 == null) {
            this.f341b.subscribe(str, subscriptionCallback.f289a);
            return;
        }
        try {
            Binder binder = subscriptionCallback.f290b;
            Messenger messenger = this.f347h;
            c1540m9.getClass();
            Bundle bundle3 = new Bundle();
            bundle3.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, str);
            BundleCompat.putBinder(bundle3, MediaBrowserProtocol.DATA_CALLBACK_TOKEN, binder);
            bundle3.putBundle(MediaBrowserProtocol.DATA_OPTIONS, bundle2);
            c1540m9.m6109s(3, bundle3, messenger);
        } catch (RemoteException unused) {
            Log.i("MediaBrowserCompat", "Remote error subscribing media item: " + str);
        }
    }

    @Override // android.support.v4.media.InterfaceC0028c
    /* renamed from: b */
    public void mo118b(String str, MediaBrowserCompat.SubscriptionCallback subscriptionCallback) {
        ArrayMap arrayMap = this.f344e;
        C0041p c0041p = (C0041p) arrayMap.get(str);
        if (c0041p == null) {
            return;
        }
        C1540m9 c1540m9 = this.f346g;
        ArrayList arrayList = c0041p.f351b;
        ArrayList arrayList2 = c0041p.f350a;
        if (c1540m9 == null) {
            MediaBrowser mediaBrowser = this.f341b;
            if (subscriptionCallback == null) {
                mediaBrowser.unsubscribe(str);
            } else {
                for (int size = arrayList2.size() - 1; size >= 0; size--) {
                    if (arrayList2.get(size) == subscriptionCallback) {
                        arrayList2.remove(size);
                        arrayList.remove(size);
                    }
                }
                if (arrayList2.size() == 0) {
                    mediaBrowser.unsubscribe(str);
                }
            }
        } else {
            try {
                if (subscriptionCallback == null) {
                    c1540m9.m6107q(str, null, this.f347h);
                } else {
                    for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
                        if (arrayList2.get(size2) == subscriptionCallback) {
                            this.f346g.m6107q(str, subscriptionCallback.f290b, this.f347h);
                            arrayList2.remove(size2);
                            arrayList.remove(size2);
                        }
                    }
                }
            } catch (RemoteException unused) {
                Log.d("MediaBrowserCompat", "removeSubscription failed with RemoteException parentId=" + str);
            }
        }
        if (arrayList2.isEmpty() || subscriptionCallback == null) {
            arrayMap.remove(str);
        }
    }

    /* renamed from: c */
    public final void m119c(Messenger messenger, String str, ArrayList arrayList, Bundle bundle, Bundle bundle2) {
        MediaBrowserCompat.SubscriptionCallback subscriptionCallback;
        if (this.f347h != messenger) {
            return;
        }
        C0041p c0041p = (C0041p) this.f344e.get(str);
        if (c0041p == null) {
            if (MediaBrowserCompat.f274b) {
                Log.d("MediaBrowserCompat", "onLoadChildren for id that isn't subscribed id=" + str);
                return;
            }
            return;
        }
        int i = 0;
        while (true) {
            ArrayList arrayList2 = c0041p.f351b;
            if (i < arrayList2.size()) {
                if (MediaBrowserCompatUtils.areSameOptions((Bundle) arrayList2.get(i), bundle)) {
                    subscriptionCallback = (MediaBrowserCompat.SubscriptionCallback) c0041p.f350a.get(i);
                    break;
                }
                i++;
            } else {
                subscriptionCallback = null;
                break;
            }
        }
        if (subscriptionCallback != null) {
            if (bundle == null) {
                if (arrayList == null) {
                    subscriptionCallback.onError(str);
                    return;
                }
                this.f349j = bundle2;
                subscriptionCallback.onChildrenLoaded(str, arrayList);
                this.f349j = null;
                return;
            }
            if (arrayList == null) {
                subscriptionCallback.onError(str, bundle);
                return;
            }
            this.f349j = bundle2;
            subscriptionCallback.onChildrenLoaded(str, arrayList, bundle);
            this.f349j = null;
        }
    }
}
