package android.support.v4.media.session;

import android.media.MediaMetadata;
import android.media.session.MediaController;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.media.AudioAttributesCompat;
import java.lang.ref.WeakReference;
import java.util.List;

/* renamed from: android.support.v4.media.session.c */
/* loaded from: classes.dex */
public final class C0047c extends MediaController.Callback {

    /* renamed from: a */
    public final WeakReference f419a;

    public C0047c(MediaControllerCompat.Callback callback) {
        this.f419a = new WeakReference(callback);
    }

    @Override // android.media.session.MediaController.Callback
    public final void onAudioInfoChanged(MediaController.PlaybackInfo playbackInfo) {
        MediaControllerCompat.Callback callback = (MediaControllerCompat.Callback) this.f419a.get();
        if (callback != null) {
            callback.onAudioInfoChanged(new MediaControllerCompat.PlaybackInfo(playbackInfo.getPlaybackType(), AudioAttributesCompat.wrap(playbackInfo.getAudioAttributes()), playbackInfo.getVolumeControl(), playbackInfo.getMaxVolume(), playbackInfo.getCurrentVolume()));
        }
    }

    @Override // android.media.session.MediaController.Callback
    public final void onExtrasChanged(Bundle bundle) {
        MediaSessionCompat.ensureClassLoader(bundle);
        MediaControllerCompat.Callback callback = (MediaControllerCompat.Callback) this.f419a.get();
        if (callback != null) {
            callback.onExtrasChanged(bundle);
        }
    }

    @Override // android.media.session.MediaController.Callback
    public final void onMetadataChanged(MediaMetadata mediaMetadata) {
        MediaControllerCompat.Callback callback = (MediaControllerCompat.Callback) this.f419a.get();
        if (callback != null) {
            callback.onMetadataChanged(MediaMetadataCompat.fromMediaMetadata(mediaMetadata));
        }
    }

    @Override // android.media.session.MediaController.Callback
    public final void onPlaybackStateChanged(PlaybackState playbackState) {
        MediaControllerCompat.Callback callback = (MediaControllerCompat.Callback) this.f419a.get();
        if (callback != null && callback.f359c == null) {
            callback.onPlaybackStateChanged(PlaybackStateCompat.fromPlaybackState(playbackState));
        }
    }

    @Override // android.media.session.MediaController.Callback
    public final void onQueueChanged(List list) {
        MediaControllerCompat.Callback callback = (MediaControllerCompat.Callback) this.f419a.get();
        if (callback != null) {
            callback.onQueueChanged(MediaSessionCompat.QueueItem.fromQueueItemList(list));
        }
    }

    @Override // android.media.session.MediaController.Callback
    public final void onQueueTitleChanged(CharSequence charSequence) {
        MediaControllerCompat.Callback callback = (MediaControllerCompat.Callback) this.f419a.get();
        if (callback != null) {
            callback.onQueueTitleChanged(charSequence);
        }
    }

    @Override // android.media.session.MediaController.Callback
    public final void onSessionDestroyed() {
        MediaControllerCompat.Callback callback = (MediaControllerCompat.Callback) this.f419a.get();
        if (callback != null) {
            callback.onSessionDestroyed();
        }
    }

    @Override // android.media.session.MediaController.Callback
    public final void onSessionEvent(String str, Bundle bundle) {
        MediaSessionCompat.ensureClassLoader(bundle);
        MediaControllerCompat.Callback callback = (MediaControllerCompat.Callback) this.f419a.get();
        if (callback != null) {
            callback.onSessionEvent(str, bundle);
        }
    }
}
