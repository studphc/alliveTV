package android.support.v4.media;

import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Messenger;
import android.os.Process;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.Log;
import androidx.core.app.BundleCompat;
import androidx.media.MediaBrowserProtocol;
import java.lang.ref.WeakReference;
import p000.C1540m9;
import p000.qk1;

/* renamed from: android.support.v4.media.a */
/* loaded from: classes.dex */
public final class C0026a extends MediaBrowser.ConnectionCallback {

    /* renamed from: a */
    public final /* synthetic */ MediaBrowserCompat.ConnectionCallback f320a;

    public C0026a(MediaBrowserCompat.ConnectionCallback connectionCallback) {
        this.f320a = connectionCallback;
    }

    @Override // android.media.browse.MediaBrowser.ConnectionCallback
    public final void onConnected() {
        MediaBrowserCompat.ConnectionCallback connectionCallback = this.f320a;
        AbstractC0036k abstractC0036k = connectionCallback.f277b;
        if (abstractC0036k != null) {
            MediaBrowser mediaBrowser = abstractC0036k.f341b;
            try {
                Bundle extras = mediaBrowser.getExtras();
                if (extras != null) {
                    abstractC0036k.f345f = extras.getInt(MediaBrowserProtocol.EXTRA_SERVICE_VERSION, 0);
                    IBinder binder = BundleCompat.getBinder(extras, MediaBrowserProtocol.EXTRA_MESSENGER_BINDER);
                    if (binder != null) {
                        C1540m9 c1540m9 = new C1540m9(17, false);
                        c1540m9.f22854b = new Messenger(binder);
                        c1540m9.f22855c = abstractC0036k.f342c;
                        abstractC0036k.f346g = c1540m9;
                        qk1 qk1Var = abstractC0036k.f343d;
                        Messenger messenger = new Messenger(qk1Var);
                        abstractC0036k.f347h = messenger;
                        qk1Var.getClass();
                        qk1Var.f25632b = new WeakReference(messenger);
                        try {
                            C1540m9 c1540m92 = abstractC0036k.f346g;
                            Context context = abstractC0036k.f340a;
                            Messenger messenger2 = abstractC0036k.f347h;
                            c1540m92.getClass();
                            Bundle bundle = new Bundle();
                            bundle.putString(MediaBrowserProtocol.DATA_PACKAGE_NAME, context.getPackageName());
                            bundle.putInt(MediaBrowserProtocol.DATA_CALLING_PID, Process.myPid());
                            bundle.putBundle(MediaBrowserProtocol.DATA_ROOT_HINTS, (Bundle) c1540m92.f22855c);
                            c1540m92.m6109s(6, bundle, messenger2);
                        } catch (RemoteException unused) {
                            Log.i("MediaBrowserCompat", "Remote error registering client messenger.");
                        }
                    }
                    IMediaSession asInterface = IMediaSession.Stub.asInterface(BundleCompat.getBinder(extras, MediaBrowserProtocol.EXTRA_SESSION_BINDER));
                    if (asInterface != null) {
                        abstractC0036k.f348i = MediaSessionCompat.Token.fromToken(mediaBrowser.getSessionToken(), asInterface);
                    }
                }
            } catch (IllegalStateException e) {
                Log.e("MediaBrowserCompat", "Unexpected IllegalStateException", e);
            }
        }
        connectionCallback.onConnected();
    }

    @Override // android.media.browse.MediaBrowser.ConnectionCallback
    public final void onConnectionFailed() {
        MediaBrowserCompat.ConnectionCallback connectionCallback = this.f320a;
        AbstractC0036k abstractC0036k = connectionCallback.f277b;
        connectionCallback.onConnectionFailed();
    }

    @Override // android.media.browse.MediaBrowser.ConnectionCallback
    public final void onConnectionSuspended() {
        MediaBrowserCompat.ConnectionCallback connectionCallback = this.f320a;
        AbstractC0036k abstractC0036k = connectionCallback.f277b;
        if (abstractC0036k != null) {
            abstractC0036k.f346g = null;
            abstractC0036k.f347h = null;
            abstractC0036k.f348i = null;
            qk1 qk1Var = abstractC0036k.f343d;
            qk1Var.getClass();
            qk1Var.f25632b = new WeakReference(null);
        }
        connectionCallback.onConnectionSuspended();
    }
}
