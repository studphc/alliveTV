package androidx.leanback.media;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.util.Log;
import p000.kl1;

@Deprecated
/* loaded from: classes.dex */
public abstract class MediaControllerGlue extends PlaybackControlGlue {

    /* renamed from: q */
    public MediaControllerCompat f5383q;

    /* renamed from: r */
    public final kl1 f5384r;

    public MediaControllerGlue(Context context, int[] iArr, int[] iArr2) {
        super(context, iArr, iArr2);
        this.f5384r = new kl1(this);
    }

    public void attachToMediaController(MediaControllerCompat mediaControllerCompat) {
        if (mediaControllerCompat != this.f5383q) {
            detach();
            this.f5383q = mediaControllerCompat;
            if (mediaControllerCompat != null) {
                mediaControllerCompat.registerCallback(this.f5384r);
            }
            onMetadataChanged();
            onStateChanged();
        }
    }

    public void detach() {
        MediaControllerCompat mediaControllerCompat = this.f5383q;
        if (mediaControllerCompat != null) {
            mediaControllerCompat.unregisterCallback(this.f5384r);
        }
        this.f5383q = null;
    }

    @Override // androidx.leanback.media.PlaybackControlGlue
    public int getCurrentPosition() {
        return (int) this.f5383q.getPlaybackState().getPosition();
    }

    @Override // androidx.leanback.media.PlaybackControlGlue
    public int getCurrentSpeedId() {
        int playbackSpeed = (int) this.f5383q.getPlaybackState().getPlaybackSpeed();
        int i = 0;
        if (playbackSpeed == 0) {
            return 0;
        }
        if (playbackSpeed == 1) {
            return 1;
        }
        if (playbackSpeed > 0) {
            int[] fastForwardSpeeds = getFastForwardSpeeds();
            while (i < fastForwardSpeeds.length) {
                if (playbackSpeed == fastForwardSpeeds[i]) {
                    return i + 10;
                }
                i++;
            }
        } else {
            int[] rewindSpeeds = getRewindSpeeds();
            while (i < rewindSpeeds.length) {
                if ((-playbackSpeed) == rewindSpeeds[i]) {
                    return (-10) - i;
                }
                i++;
            }
        }
        Log.w("MediaControllerGlue", "Couldn't find index for speed " + playbackSpeed);
        return -1;
    }

    @Override // androidx.leanback.media.PlaybackControlGlue
    public Drawable getMediaArt() {
        Bitmap iconBitmap = this.f5383q.getMetadata().getDescription().getIconBitmap();
        if (iconBitmap == null) {
            return null;
        }
        return new BitmapDrawable(getContext().getResources(), iconBitmap);
    }

    public final MediaControllerCompat getMediaController() {
        return this.f5383q;
    }

    @Override // androidx.leanback.media.PlaybackControlGlue
    public int getMediaDuration() {
        return (int) this.f5383q.getMetadata().getLong(MediaMetadataCompat.METADATA_KEY_DURATION);
    }

    @Override // androidx.leanback.media.PlaybackControlGlue
    public CharSequence getMediaSubtitle() {
        return this.f5383q.getMetadata().getDescription().getSubtitle();
    }

    @Override // androidx.leanback.media.PlaybackControlGlue
    public CharSequence getMediaTitle() {
        return this.f5383q.getMetadata().getDescription().getTitle();
    }

    @Override // androidx.leanback.media.PlaybackControlGlue
    public long getSupportedActions() {
        long j;
        long actions = this.f5383q.getPlaybackState().getActions();
        if ((512 & actions) != 0) {
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
        if ((64 & actions) != 0) {
            j |= 128;
        }
        if ((actions & 8) != 0) {
            return j | 32;
        }
        return j;
    }

    @Override // androidx.leanback.media.PlaybackControlGlue
    public boolean hasValidMedia() {
        MediaControllerCompat mediaControllerCompat = this.f5383q;
        if (mediaControllerCompat != null && mediaControllerCompat.getMetadata() != null) {
            return true;
        }
        return false;
    }

    @Override // androidx.leanback.media.PlaybackControlGlue
    public boolean isMediaPlaying() {
        if (this.f5383q.getPlaybackState().getState() == 3) {
            return true;
        }
        return false;
    }

    @Override // androidx.leanback.media.PlaybackGlue
    public void next() {
        this.f5383q.getTransportControls().skipToNext();
    }

    @Override // androidx.leanback.media.PlaybackGlue
    public void pause() {
        this.f5383q.getTransportControls().pause();
    }

    @Override // androidx.leanback.media.PlaybackControlGlue
    public void play(int i) {
        if (i == 1) {
            this.f5383q.getTransportControls().play();
        } else if (i > 0) {
            this.f5383q.getTransportControls().fastForward();
        } else {
            this.f5383q.getTransportControls().rewind();
        }
    }

    @Override // androidx.leanback.media.PlaybackGlue
    public void previous() {
        this.f5383q.getTransportControls().skipToPrevious();
    }
}
