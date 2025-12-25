package p000;

import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.support.v4.media.AbstractC0036k;
import android.support.v4.media.InterfaceC0039n;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.Log;
import androidx.media.MediaBrowserProtocol;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class qk1 extends Handler {

    /* renamed from: a */
    public final WeakReference f25631a;

    /* renamed from: b */
    public WeakReference f25632b;

    public qk1(AbstractC0036k abstractC0036k) {
        this.f25631a = new WeakReference(abstractC0036k);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        WeakReference weakReference = this.f25632b;
        if (weakReference != null && weakReference.get() != null) {
            WeakReference weakReference2 = this.f25631a;
            if (weakReference2.get() != null) {
                Bundle data = message.getData();
                MediaSessionCompat.ensureClassLoader(data);
                InterfaceC0039n interfaceC0039n = (InterfaceC0039n) weakReference2.get();
                Messenger messenger = (Messenger) this.f25632b.get();
                try {
                    int i = message.what;
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                Log.w("MediaBrowserCompat", "Unhandled message: " + message + "\n  Client version: 1\n  Service version: " + message.arg1);
                            } else {
                                Bundle bundle = data.getBundle(MediaBrowserProtocol.DATA_OPTIONS);
                                MediaSessionCompat.ensureClassLoader(bundle);
                                Bundle bundle2 = data.getBundle(MediaBrowserProtocol.DATA_NOTIFY_CHILDREN_CHANGED_OPTIONS);
                                MediaSessionCompat.ensureClassLoader(bundle2);
                                ((AbstractC0036k) interfaceC0039n).m119c(messenger, data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), data.getParcelableArrayList(MediaBrowserProtocol.DATA_MEDIA_ITEM_LIST), bundle, bundle2);
                            }
                        } else {
                            interfaceC0039n.getClass();
                        }
                    } else {
                        MediaSessionCompat.ensureClassLoader(data.getBundle(MediaBrowserProtocol.DATA_ROOT_HINTS));
                        data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID);
                        interfaceC0039n.getClass();
                    }
                } catch (BadParcelableException unused) {
                    Log.e("MediaBrowserCompat", "Could not unparcel the data.");
                    if (message.what == 1) {
                        interfaceC0039n.getClass();
                    }
                }
            }
        }
    }
}
