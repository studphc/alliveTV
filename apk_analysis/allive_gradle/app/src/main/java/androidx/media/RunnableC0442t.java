package androidx.media;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.Log;
import androidx.media.MediaBrowserServiceCompat;
import p000.AbstractC1726qj;
import p000.al1;
import p000.b01;

/* renamed from: androidx.media.t */
/* loaded from: classes.dex */
public final class RunnableC0442t implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ al1 f6725a;

    /* renamed from: b */
    public final /* synthetic */ String f6726b;

    /* renamed from: c */
    public final /* synthetic */ int f6727c;

    /* renamed from: d */
    public final /* synthetic */ int f6728d;

    /* renamed from: e */
    public final /* synthetic */ Bundle f6729e;

    /* renamed from: f */
    public final /* synthetic */ b01 f6730f;

    public RunnableC0442t(int i, int i2, b01 b01Var, al1 al1Var, Bundle bundle, String str) {
        this.f6730f = b01Var;
        this.f6725a = al1Var;
        this.f6726b = str;
        this.f6727c = i;
        this.f6728d = i2;
        this.f6729e = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        al1 al1Var = this.f6725a;
        IBinder binder = al1Var.f255a.getBinder();
        b01 b01Var = this.f6730f;
        ((MediaBrowserServiceCompat) b01Var.f7833b).f6662d.remove(binder);
        String str = this.f6726b;
        C0431h c0431h = new C0431h((MediaBrowserServiceCompat) b01Var.f7833b, str, this.f6727c, this.f6728d, this.f6729e, al1Var);
        MediaBrowserServiceCompat mediaBrowserServiceCompat = (MediaBrowserServiceCompat) b01Var.f7833b;
        mediaBrowserServiceCompat.f6663e = c0431h;
        MediaBrowserServiceCompat.BrowserRoot onGetRoot = mediaBrowserServiceCompat.onGetRoot(str, this.f6728d, this.f6729e);
        c0431h.f6706h = onGetRoot;
        mediaBrowserServiceCompat.f6663e = null;
        if (onGetRoot == null) {
            StringBuilder m7065u = AbstractC1726qj.m7065u("No root for client ", str, " from service ");
            m7065u.append(RunnableC0442t.class.getName());
            Log.i("MBServiceCompat", m7065u.toString());
            try {
                al1Var.m115b(2, null);
                return;
            } catch (RemoteException unused) {
                Log.w("MBServiceCompat", "Calling onConnectFailed() failed. Ignoring. pkg=".concat(str));
                return;
            }
        }
        try {
            mediaBrowserServiceCompat.f6662d.put(binder, c0431h);
            binder.linkToDeath(c0431h, 0);
            if (mediaBrowserServiceCompat.f6665g != null) {
                String rootId = c0431h.f6706h.getRootId();
                MediaSessionCompat.Token token = mediaBrowserServiceCompat.f6665g;
                Bundle extras = c0431h.f6706h.getExtras();
                if (extras == null) {
                    extras = new Bundle();
                }
                extras.putInt(MediaBrowserProtocol.EXTRA_SERVICE_VERSION, 2);
                Bundle bundle = new Bundle();
                bundle.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, rootId);
                bundle.putParcelable(MediaBrowserProtocol.DATA_MEDIA_SESSION_TOKEN, token);
                bundle.putBundle(MediaBrowserProtocol.DATA_ROOT_HINTS, extras);
                al1Var.m115b(1, bundle);
            }
        } catch (RemoteException unused2) {
            Log.w("MBServiceCompat", "Calling onConnect() failed. Dropping client. pkg=".concat(str));
            mediaBrowserServiceCompat.f6662d.remove(binder);
        }
    }
}
