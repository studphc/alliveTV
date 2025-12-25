package android.support.v4.media.session;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import android.view.KeyEvent;
import androidx.media.MediaSessionManager;
import java.util.List;

/* renamed from: android.support.v4.media.session.o */
/* loaded from: classes.dex */
public final class BinderC0059o extends IMediaSession.Stub {

    /* renamed from: a */
    public final /* synthetic */ C0060p f432a;

    public BinderC0059o(C0060p c0060p) {
        this.f432a = c0060p;
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final void addQueueItemAt(MediaDescriptionCompat mediaDescriptionCompat, int i) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final void adjustVolume(int i, int i2, String str) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final void fastForward() {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final Bundle getExtras() {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final long getFlags() {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final PendingIntent getLaunchPendingIntent() {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final MediaMetadataCompat getMetadata() {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final String getPackageName() {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final PlaybackStateCompat getPlaybackState() {
        C0060p c0060p = this.f432a;
        return MediaSessionCompat.m123a(c0060p.f439g, c0060p.f441i);
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final List getQueue() {
        return null;
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final CharSequence getQueueTitle() {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final int getRatingType() {
        return this.f432a.f442j;
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final int getRepeatMode() {
        return this.f432a.f444l;
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final Bundle getSessionInfo() {
        C0060p c0060p = this.f432a;
        if (c0060p.f436d == null) {
            return null;
        }
        return new Bundle(c0060p.f436d);
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final int getShuffleMode() {
        return this.f432a.f445m;
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final String getTag() {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final ParcelableVolumeInfo getVolumeAttributes() {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final boolean isCaptioningEnabled() {
        return this.f432a.f443k;
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final boolean isShuffleModeEnabledRemoved() {
        return false;
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final boolean isTransportControlEnabled() {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final void next() {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final void pause() {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final void play() {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final void playFromMediaId(String str, Bundle bundle) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final void playFromSearch(String str, Bundle bundle) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final void playFromUri(Uri uri, Bundle bundle) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final void prepare() {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final void prepareFromMediaId(String str, Bundle bundle) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final void prepareFromSearch(String str, Bundle bundle) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final void prepareFromUri(Uri uri, Bundle bundle) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final void previous() {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final void rate(RatingCompat ratingCompat) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final void rateWithExtras(RatingCompat ratingCompat, Bundle bundle) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final void registerCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
        C0060p c0060p = this.f432a;
        if (!c0060p.f437e) {
            c0060p.f438f.register(iMediaControllerCallback, new MediaSessionManager.RemoteUserInfo(MediaSessionManager.RemoteUserInfo.LEGACY_CONTROLLER, Binder.getCallingPid(), Binder.getCallingUid()));
        }
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final void removeQueueItemAt(int i) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final void rewind() {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final void seekTo(long j) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final void sendCommand(String str, Bundle bundle, MediaSessionCompat.ResultReceiverWrapper resultReceiverWrapper) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final void sendCustomAction(String str, Bundle bundle) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final boolean sendMediaButton(KeyEvent keyEvent) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final void setCaptioningEnabled(boolean z) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final void setPlaybackSpeed(float f) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final void setRepeatMode(int i) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final void setShuffleMode(int i) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final void setShuffleModeEnabledRemoved(boolean z) {
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final void setVolumeTo(int i, int i2, String str) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final void skipToQueueItem(long j) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final void stop() {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final void unregisterCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
        this.f432a.f438f.unregister(iMediaControllerCallback);
    }
}
