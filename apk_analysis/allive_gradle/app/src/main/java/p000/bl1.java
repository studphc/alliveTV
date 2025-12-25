package p000;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.view.KeyEvent;

/* loaded from: classes.dex */
public final class bl1 extends MediaBrowserCompat.ConnectionCallback {

    /* renamed from: c */
    public final Context f8065c;

    /* renamed from: d */
    public final Intent f8066d;

    /* renamed from: e */
    public final BroadcastReceiver.PendingResult f8067e;

    /* renamed from: f */
    public MediaBrowserCompat f8068f;

    public bl1(Context context, Intent intent, BroadcastReceiver.PendingResult pendingResult) {
        this.f8065c = context;
        this.f8066d = intent;
        this.f8067e = pendingResult;
    }

    @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
    public final void onConnected() {
        new MediaControllerCompat(this.f8065c, this.f8068f.getSessionToken()).dispatchMediaButtonEvent((KeyEvent) this.f8066d.getParcelableExtra("android.intent.extra.KEY_EVENT"));
        this.f8068f.disconnect();
        this.f8067e.finish();
    }

    @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
    public final void onConnectionFailed() {
        this.f8068f.disconnect();
        this.f8067e.finish();
    }

    @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
    public final void onConnectionSuspended() {
        this.f8068f.disconnect();
        this.f8067e.finish();
    }
}
