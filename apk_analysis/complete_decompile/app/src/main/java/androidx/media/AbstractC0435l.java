package androidx.media;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Messenger;
import android.service.media.MediaBrowserService;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.core.app.BundleCompat;
import androidx.media.MediaBrowserServiceCompat;
import p000.b01;

/* renamed from: androidx.media.l */
/* loaded from: classes.dex */
public abstract class AbstractC0435l extends MediaBrowserService {

    /* renamed from: a */
    public final /* synthetic */ AbstractC0436m f6713a;

    public AbstractC0435l(AbstractC0436m abstractC0436m, Context context) {
        this.f6713a = abstractC0436m;
        attachBaseContext(context);
    }

    @Override // android.service.media.MediaBrowserService
    public final MediaBrowserService.BrowserRoot onGetRoot(String str, int i, Bundle bundle) {
        Bundle bundle2;
        Bundle bundle3;
        int i2;
        MediaBrowserServiceCompat.BrowserRoot browserRoot;
        IBinder asBinder;
        MediaSessionCompat.ensureClassLoader(bundle);
        if (bundle == null) {
            bundle2 = null;
        } else {
            bundle2 = new Bundle(bundle);
        }
        AbstractC0436m abstractC0436m = this.f6713a;
        MediaBrowserServiceCompat mediaBrowserServiceCompat = abstractC0436m.f6717d;
        if (bundle2 != null && bundle2.getInt(MediaBrowserProtocol.EXTRA_CLIENT_VERSION, 0) != 0) {
            bundle2.remove(MediaBrowserProtocol.EXTRA_CLIENT_VERSION);
            abstractC0436m.f6716c = new Messenger(mediaBrowserServiceCompat.f6664f);
            Bundle bundle4 = new Bundle();
            bundle4.putInt(MediaBrowserProtocol.EXTRA_SERVICE_VERSION, 2);
            BundleCompat.putBinder(bundle4, MediaBrowserProtocol.EXTRA_MESSENGER_BINDER, abstractC0436m.f6716c.getBinder());
            MediaSessionCompat.Token token = mediaBrowserServiceCompat.f6665g;
            if (token != null) {
                IMediaSession extraBinder = token.getExtraBinder();
                if (extraBinder == null) {
                    asBinder = null;
                } else {
                    asBinder = extraBinder.asBinder();
                }
                BundleCompat.putBinder(bundle4, MediaBrowserProtocol.EXTRA_SESSION_BINDER, asBinder);
            } else {
                abstractC0436m.f6714a.add(bundle4);
            }
            int i3 = bundle2.getInt(MediaBrowserProtocol.EXTRA_CALLING_PID, -1);
            bundle2.remove(MediaBrowserProtocol.EXTRA_CALLING_PID);
            i2 = i3;
            bundle3 = bundle4;
        } else {
            bundle3 = null;
            i2 = -1;
        }
        C0431h c0431h = new C0431h(abstractC0436m.f6717d, str, i2, i, bundle2, null);
        mediaBrowserServiceCompat.f6663e = c0431h;
        MediaBrowserServiceCompat.BrowserRoot onGetRoot = mediaBrowserServiceCompat.onGetRoot(str, i, bundle2);
        mediaBrowserServiceCompat.f6663e = null;
        if (onGetRoot == null) {
            browserRoot = null;
        } else {
            if (abstractC0436m.f6716c != null) {
                mediaBrowserServiceCompat.f6661c.add(c0431h);
            }
            if (bundle3 == null) {
                bundle3 = onGetRoot.getExtras();
            } else if (onGetRoot.getExtras() != null) {
                bundle3.putAll(onGetRoot.getExtras());
            }
            browserRoot = new MediaBrowserServiceCompat.BrowserRoot(onGetRoot.getRootId(), bundle3);
        }
        if (browserRoot == null) {
            return null;
        }
        return new MediaBrowserService.BrowserRoot(browserRoot.f6666a, browserRoot.f6667b);
    }

    @Override // android.service.media.MediaBrowserService
    public final void onLoadChildren(String str, MediaBrowserService.Result result) {
        b01 b01Var = new b01(23, result);
        AbstractC0436m abstractC0436m = this.f6713a;
        abstractC0436m.getClass();
        C0433j c0433j = new C0433j(str, b01Var);
        MediaBrowserServiceCompat mediaBrowserServiceCompat = abstractC0436m.f6717d;
        mediaBrowserServiceCompat.f6663e = mediaBrowserServiceCompat.f6660b;
        mediaBrowserServiceCompat.onLoadChildren(str, c0433j);
        mediaBrowserServiceCompat.f6663e = null;
    }
}
