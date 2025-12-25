package androidx.leanback.media;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class MediaControllerAdapter extends PlayerAdapter {

    /* renamed from: b */
    public final MediaControllerCompat f5378b;

    /* renamed from: c */
    public final Handler f5379c = new Handler();

    /* renamed from: d */
    public final RunnableC0298a f5380d = new RunnableC0298a(this);

    /* renamed from: e */
    public boolean f5381e = false;

    /* renamed from: f */
    public final C0299b f5382f = new C0299b(this);

    public MediaControllerAdapter(MediaControllerCompat mediaControllerCompat) {
        if (mediaControllerCompat != null) {
            this.f5378b = mediaControllerCompat;
            return;
        }
        throw new NullPointerException("Object of MediaControllerCompat is null");
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void fastForward() {
        this.f5378b.getTransportControls().fastForward();
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public long getBufferedPosition() {
        MediaControllerCompat mediaControllerCompat = this.f5378b;
        if (mediaControllerCompat.getPlaybackState() == null) {
            return 0L;
        }
        return mediaControllerCompat.getPlaybackState().getBufferedPosition();
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public long getCurrentPosition() {
        MediaControllerCompat mediaControllerCompat = this.f5378b;
        if (mediaControllerCompat.getPlaybackState() == null) {
            return 0L;
        }
        return mediaControllerCompat.getPlaybackState().getPosition();
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public long getDuration() {
        if (this.f5378b.getMetadata() == null) {
            return 0L;
        }
        return (int) r0.getMetadata().getLong(MediaMetadataCompat.METADATA_KEY_DURATION);
    }

    public Drawable getMediaArt(Context context) {
        Bitmap iconBitmap;
        MediaControllerCompat mediaControllerCompat = this.f5378b;
        if (mediaControllerCompat.getMetadata() == null || (iconBitmap = mediaControllerCompat.getMetadata().getDescription().getIconBitmap()) == null) {
            return null;
        }
        return new BitmapDrawable(context.getResources(), iconBitmap);
    }

    public MediaControllerCompat getMediaController() {
        return this.f5378b;
    }

    public CharSequence getMediaSubtitle() {
        MediaControllerCompat mediaControllerCompat = this.f5378b;
        if (mediaControllerCompat.getMetadata() == null) {
            return "";
        }
        return mediaControllerCompat.getMetadata().getDescription().getSubtitle();
    }

    public CharSequence getMediaTitle() {
        MediaControllerCompat mediaControllerCompat = this.f5378b;
        if (mediaControllerCompat.getMetadata() == null) {
            return "";
        }
        return mediaControllerCompat.getMetadata().getDescription().getTitle();
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public long getSupportedActions() {
        long j;
        MediaControllerCompat mediaControllerCompat = this.f5378b;
        if (mediaControllerCompat.getPlaybackState() == null) {
            return 0L;
        }
        long actions = mediaControllerCompat.getPlaybackState().getActions();
        if ((actions & 512) != 0) {
            j = 64;
        } else {
            j = 0;
        }
        if ((actions & 32) != 0) {
            j |= 256;
        }
        if ((actions & 16) != 0) {
            j |= 16;
        }
        if ((actions & 64) != 0) {
            j |= 128;
        }
        if ((8 & actions) != 0) {
            j |= 32;
        }
        if ((PlaybackStateCompat.ACTION_SET_REPEAT_MODE & actions) != 0) {
            j |= 512;
        }
        if ((actions & PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) != 0) {
            return j | 1024;
        }
        return j;
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public boolean isPlaying() {
        MediaControllerCompat mediaControllerCompat = this.f5378b;
        if (mediaControllerCompat.getPlaybackState() == null) {
            return false;
        }
        if (mediaControllerCompat.getPlaybackState().getState() != 3 && mediaControllerCompat.getPlaybackState().getState() != 4 && mediaControllerCompat.getPlaybackState().getState() != 5) {
            return false;
        }
        return true;
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void next() {
        this.f5378b.getTransportControls().skipToNext();
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void onAttachedToHost(@NonNull PlaybackGlueHost playbackGlueHost) {
        this.f5378b.registerCallback(this.f5382f);
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void onDetachedFromHost() {
        this.f5378b.unregisterCallback(this.f5382f);
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void pause() {
        this.f5378b.getTransportControls().pause();
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void play() {
        this.f5378b.getTransportControls().play();
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void previous() {
        this.f5378b.getTransportControls().skipToPrevious();
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void rewind() {
        this.f5378b.getTransportControls().rewind();
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void seekTo(long j) {
        this.f5378b.getTransportControls().seekTo(j);
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void setProgressUpdatingEnabled(boolean z) {
        Handler handler = this.f5379c;
        RunnableC0298a runnableC0298a = this.f5380d;
        handler.removeCallbacks(runnableC0298a);
        if (!z) {
            return;
        }
        handler.postDelayed(runnableC0298a, 16);
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void setRepeatAction(int i) {
        int i2;
        if (i != 0) {
            i2 = 2;
            if (i != 1) {
                if (i != 2) {
                    i2 = -1;
                } else {
                    i2 = 1;
                }
            }
        } else {
            i2 = 0;
        }
        this.f5378b.getTransportControls().setRepeatMode(i2);
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void setShuffleAction(int i) {
        int i2;
        if (i != 0) {
            i2 = 1;
            if (i != 1) {
                i2 = -1;
            }
        } else {
            i2 = 0;
        }
        this.f5378b.getTransportControls().setShuffleMode(i2);
    }
}
