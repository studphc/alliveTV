package android.support.v4.media.session;

import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.v4.media.session.IMediaSession;
import androidx.core.app.BundleCompat;
import androidx.versionedparcelable.ParcelUtils;
import java.lang.ref.WeakReference;

/* renamed from: android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver */
/* loaded from: classes.dex */
class ResultReceiverC0044x50fd9e4a extends ResultReceiver {

    /* renamed from: a */
    public WeakReference f360a;

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i, Bundle bundle) {
        C0052h c0052h = (C0052h) this.f360a.get();
        if (c0052h != null && bundle != null) {
            synchronized (c0052h.f424b) {
                c0052h.f428f.setExtraBinder(IMediaSession.Stub.asInterface(BundleCompat.getBinder(bundle, MediaSessionCompat.KEY_EXTRA_BINDER)));
                c0052h.f428f.setSession2Token(ParcelUtils.getVersionedParcelable(bundle, MediaSessionCompat.KEY_SESSION2_TOKEN));
                c0052h.m126a();
            }
        }
    }
}
