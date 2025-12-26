package android.support.v4.media.session;

import android.os.Bundle;
import android.support.v4.media.session.IMediaControllerCallback;
import android.support.v4.media.session.MediaControllerCompat;
import java.lang.ref.WeakReference;

/* renamed from: android.support.v4.media.session.e */
/* loaded from: classes.dex */
public abstract class AbstractBinderC0049e extends IMediaControllerCallback.Stub {

    /* renamed from: a */
    public final WeakReference f422a;

    public AbstractBinderC0049e(MediaControllerCompat.Callback callback) {
        this.f422a = new WeakReference(callback);
    }

    @Override // android.support.v4.media.session.IMediaControllerCallback
    public final void onCaptioningEnabledChanged(boolean z) {
        MediaControllerCompat.Callback callback = (MediaControllerCompat.Callback) this.f422a.get();
        if (callback != null) {
            callback.m121a(11, Boolean.valueOf(z), null);
        }
    }

    @Override // android.support.v4.media.session.IMediaControllerCallback
    public final void onEvent(String str, Bundle bundle) {
        MediaControllerCompat.Callback callback = (MediaControllerCompat.Callback) this.f422a.get();
        if (callback != null) {
            callback.m121a(1, str, bundle);
        }
    }

    @Override // android.support.v4.media.session.IMediaControllerCallback
    public final void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat) {
        MediaControllerCompat.Callback callback = (MediaControllerCompat.Callback) this.f422a.get();
        if (callback != null) {
            callback.m121a(2, playbackStateCompat, null);
        }
    }

    @Override // android.support.v4.media.session.IMediaControllerCallback
    public final void onRepeatModeChanged(int i) {
        MediaControllerCompat.Callback callback = (MediaControllerCompat.Callback) this.f422a.get();
        if (callback != null) {
            callback.m121a(9, Integer.valueOf(i), null);
        }
    }

    @Override // android.support.v4.media.session.IMediaControllerCallback
    public final void onSessionReady() {
        MediaControllerCompat.Callback callback = (MediaControllerCompat.Callback) this.f422a.get();
        if (callback != null) {
            callback.m121a(13, null, null);
        }
    }

    @Override // android.support.v4.media.session.IMediaControllerCallback
    public final void onShuffleModeChanged(int i) {
        MediaControllerCompat.Callback callback = (MediaControllerCompat.Callback) this.f422a.get();
        if (callback != null) {
            callback.m121a(12, Integer.valueOf(i), null);
        }
    }

    @Override // android.support.v4.media.session.IMediaControllerCallback
    public final void onShuffleModeChangedRemoved(boolean z) {
    }
}
