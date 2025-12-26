package androidx.leanback.media;

import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.PlaybackStateCompat;

/* renamed from: androidx.leanback.media.b */
/* loaded from: classes.dex */
public final class C0299b extends MediaControllerCompat.Callback {

    /* renamed from: d */
    public final /* synthetic */ MediaControllerAdapter f5466d;

    public C0299b(MediaControllerAdapter mediaControllerAdapter) {
        this.f5466d = mediaControllerAdapter;
    }

    @Override // android.support.v4.media.session.MediaControllerCompat.Callback
    public final void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) {
        PlayerAdapter playerAdapter = this.f5466d;
        playerAdapter.getCallback().onMetadataChanged(playerAdapter);
    }

    @Override // android.support.v4.media.session.MediaControllerCompat.Callback
    public final void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat) {
        MediaControllerAdapter mediaControllerAdapter = this.f5466d;
        if (mediaControllerAdapter.f5381e && playbackStateCompat.getState() != 6) {
            mediaControllerAdapter.getCallback().onBufferingStateChanged(mediaControllerAdapter, false);
            mediaControllerAdapter.getCallback().onBufferedPositionChanged(mediaControllerAdapter);
            mediaControllerAdapter.f5381e = false;
        }
        if (playbackStateCompat.getState() != 0) {
            if (playbackStateCompat.getState() == 1) {
                mediaControllerAdapter.getCallback().onPlayCompleted(mediaControllerAdapter);
                return;
            }
            if (playbackStateCompat.getState() == 2) {
                mediaControllerAdapter.getCallback().onPlayStateChanged(mediaControllerAdapter);
                mediaControllerAdapter.getCallback().onCurrentPositionChanged(mediaControllerAdapter);
                return;
            }
            if (playbackStateCompat.getState() == 3) {
                mediaControllerAdapter.getCallback().onPlayStateChanged(mediaControllerAdapter);
                mediaControllerAdapter.getCallback().onCurrentPositionChanged(mediaControllerAdapter);
                return;
            }
            if (playbackStateCompat.getState() == 6) {
                mediaControllerAdapter.f5381e = true;
                mediaControllerAdapter.getCallback().onBufferingStateChanged(mediaControllerAdapter, true);
                mediaControllerAdapter.getCallback().onBufferedPositionChanged(mediaControllerAdapter);
            } else {
                if (playbackStateCompat.getState() == 7) {
                    if (playbackStateCompat.getErrorMessage() == null) {
                        mediaControllerAdapter.getCallback().onError(mediaControllerAdapter, playbackStateCompat.getErrorCode(), "");
                        return;
                    } else {
                        mediaControllerAdapter.getCallback().onError(mediaControllerAdapter, playbackStateCompat.getErrorCode(), playbackStateCompat.getErrorMessage().toString());
                        return;
                    }
                }
                if (playbackStateCompat.getState() == 4) {
                    mediaControllerAdapter.getCallback().onPlayStateChanged(mediaControllerAdapter);
                    mediaControllerAdapter.getCallback().onCurrentPositionChanged(mediaControllerAdapter);
                } else if (playbackStateCompat.getState() == 5) {
                    mediaControllerAdapter.getCallback().onPlayStateChanged(mediaControllerAdapter);
                    mediaControllerAdapter.getCallback().onCurrentPositionChanged(mediaControllerAdapter);
                }
            }
        }
    }
}
