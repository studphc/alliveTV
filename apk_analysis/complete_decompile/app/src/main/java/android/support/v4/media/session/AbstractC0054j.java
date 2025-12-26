package android.support.v4.media.session;

import android.media.Rating;
import android.media.session.MediaController;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: android.support.v4.media.session.j */
/* loaded from: classes.dex */
public abstract class AbstractC0054j extends MediaControllerCompat.TransportControls {

    /* renamed from: a */
    public final MediaController.TransportControls f429a;

    public AbstractC0054j(MediaController.TransportControls transportControls) {
        this.f429a = transportControls;
    }

    @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
    public final void fastForward() {
        this.f429a.fastForward();
    }

    @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
    public final void pause() {
        this.f429a.pause();
    }

    @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
    public final void play() {
        this.f429a.play();
    }

    @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
    public final void playFromMediaId(String str, Bundle bundle) {
        this.f429a.playFromMediaId(str, bundle);
    }

    @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
    public final void playFromSearch(String str, Bundle bundle) {
        this.f429a.playFromSearch(str, bundle);
    }

    @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
    public void prepare() {
        sendCustomAction(MediaSessionCompat.ACTION_PREPARE, (Bundle) null);
    }

    @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
    public void prepareFromMediaId(String str, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putString(MediaSessionCompat.ACTION_ARGUMENT_MEDIA_ID, str);
        bundle2.putBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS, bundle);
        sendCustomAction(MediaSessionCompat.ACTION_PREPARE_FROM_MEDIA_ID, bundle2);
    }

    @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
    public void prepareFromSearch(String str, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putString(MediaSessionCompat.ACTION_ARGUMENT_QUERY, str);
        bundle2.putBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS, bundle);
        sendCustomAction(MediaSessionCompat.ACTION_PREPARE_FROM_SEARCH, bundle2);
    }

    @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
    public void prepareFromUri(Uri uri, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable(MediaSessionCompat.ACTION_ARGUMENT_URI, uri);
        bundle2.putBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS, bundle);
        sendCustomAction(MediaSessionCompat.ACTION_PREPARE_FROM_URI, bundle2);
    }

    @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
    public final void rewind() {
        this.f429a.rewind();
    }

    @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
    public final void seekTo(long j) {
        this.f429a.seekTo(j);
    }

    @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
    public final void sendCustomAction(PlaybackStateCompat.CustomAction customAction, Bundle bundle) {
        MediaControllerCompat.m120a(customAction.getAction(), bundle);
        this.f429a.sendCustomAction(customAction.getAction(), bundle);
    }

    @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
    public final void setCaptioningEnabled(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(MediaSessionCompat.ACTION_ARGUMENT_CAPTIONING_ENABLED, z);
        sendCustomAction(MediaSessionCompat.ACTION_SET_CAPTIONING_ENABLED, bundle);
    }

    @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
    public void setPlaybackSpeed(float f) {
        if (f != RecyclerView.f7068F0) {
            Bundle bundle = new Bundle();
            bundle.putFloat(MediaSessionCompat.ACTION_ARGUMENT_PLAYBACK_SPEED, f);
            sendCustomAction(MediaSessionCompat.ACTION_SET_PLAYBACK_SPEED, bundle);
            return;
        }
        throw new IllegalArgumentException("speed must not be zero");
    }

    @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
    public final void setRating(RatingCompat ratingCompat) {
        this.f429a.setRating(ratingCompat != null ? (Rating) ratingCompat.getRating() : null);
    }

    @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
    public final void setRepeatMode(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt(MediaSessionCompat.ACTION_ARGUMENT_REPEAT_MODE, i);
        sendCustomAction(MediaSessionCompat.ACTION_SET_REPEAT_MODE, bundle);
    }

    @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
    public final void setShuffleMode(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt(MediaSessionCompat.ACTION_ARGUMENT_SHUFFLE_MODE, i);
        sendCustomAction(MediaSessionCompat.ACTION_SET_SHUFFLE_MODE, bundle);
    }

    @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
    public final void skipToNext() {
        this.f429a.skipToNext();
    }

    @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
    public final void skipToPrevious() {
        this.f429a.skipToPrevious();
    }

    @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
    public final void skipToQueueItem(long j) {
        this.f429a.skipToQueueItem(j);
    }

    @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
    public final void stop() {
        this.f429a.stop();
    }

    @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
    public final void setRating(RatingCompat ratingCompat, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable(MediaSessionCompat.ACTION_ARGUMENT_RATING, ratingCompat);
        bundle2.putBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS, bundle);
        sendCustomAction(MediaSessionCompat.ACTION_SET_RATING, bundle2);
    }

    @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
    public final void sendCustomAction(String str, Bundle bundle) {
        MediaControllerCompat.m120a(str, bundle);
        this.f429a.sendCustomAction(str, bundle);
    }
}
