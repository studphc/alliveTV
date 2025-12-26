package android.support.v4.media.session;

import android.content.Intent;
import android.media.Rating;
import android.media.session.MediaSession;
import android.net.Uri;
import android.os.BadParcelableException;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.BundleCompat;
import androidx.media.MediaSessionManager;
import androidx.versionedparcelable.ParcelUtils;

/* renamed from: android.support.v4.media.session.m */
/* loaded from: classes.dex */
public final class C0057m extends MediaSession.Callback {

    /* renamed from: a */
    public final /* synthetic */ MediaSessionCompat.Callback f431a;

    public C0057m(MediaSessionCompat.Callback callback) {
        this.f431a = callback;
    }

    /* renamed from: b */
    public static void m128b(C0060p c0060p) {
        if (Build.VERSION.SDK_INT >= 28) {
            return;
        }
        String m135f = c0060p.m135f();
        if (TextUtils.isEmpty(m135f)) {
            m135f = MediaSessionManager.RemoteUserInfo.LEGACY_CONTROLLER;
        }
        c0060p.mo132c(new MediaSessionManager.RemoteUserInfo(m135f, -1, -1));
    }

    /* renamed from: a */
    public final C0060p m129a() {
        C0060p c0060p;
        synchronized (this.f431a.f370a) {
            c0060p = (C0060p) this.f431a.f373d.get();
        }
        if (c0060p == null || this.f431a != c0060p.mo130a()) {
            return null;
        }
        return c0060p;
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
        MediaSessionCompat.QueueItem queueItem;
        IBinder asBinder;
        C0060p m129a = m129a();
        if (m129a == null) {
            return;
        }
        MediaSessionCompat.ensureClassLoader(bundle);
        m128b(m129a);
        try {
            if (str.equals(MediaControllerCompat.COMMAND_GET_EXTRA_BINDER)) {
                Bundle bundle2 = new Bundle();
                MediaSessionCompat.Token token = m129a.f434b;
                IMediaSession extraBinder = token.getExtraBinder();
                if (extraBinder == null) {
                    asBinder = null;
                } else {
                    asBinder = extraBinder.asBinder();
                }
                BundleCompat.putBinder(bundle2, MediaSessionCompat.KEY_EXTRA_BINDER, asBinder);
                ParcelUtils.putVersionedParcelable(bundle2, MediaSessionCompat.KEY_SESSION2_TOKEN, token.getSession2Token());
                resultReceiver.send(0, bundle2);
            } else {
                boolean equals = str.equals(MediaControllerCompat.COMMAND_ADD_QUEUE_ITEM);
                MediaSessionCompat.Callback callback = this.f431a;
                if (equals) {
                    callback.onAddQueueItem((MediaDescriptionCompat) bundle.getParcelable(MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION));
                } else if (str.equals(MediaControllerCompat.COMMAND_ADD_QUEUE_ITEM_AT)) {
                    callback.onAddQueueItem((MediaDescriptionCompat) bundle.getParcelable(MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION), bundle.getInt(MediaControllerCompat.COMMAND_ARGUMENT_INDEX));
                } else if (str.equals(MediaControllerCompat.COMMAND_REMOVE_QUEUE_ITEM)) {
                    callback.onRemoveQueueItem((MediaDescriptionCompat) bundle.getParcelable(MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION));
                } else if (str.equals(MediaControllerCompat.COMMAND_REMOVE_QUEUE_ITEM_AT)) {
                    if (m129a.f440h != null) {
                        int i = bundle.getInt(MediaControllerCompat.COMMAND_ARGUMENT_INDEX, -1);
                        if (i >= 0 && i < m129a.f440h.size()) {
                            queueItem = (MediaSessionCompat.QueueItem) m129a.f440h.get(i);
                        } else {
                            queueItem = null;
                        }
                        if (queueItem != null) {
                            callback.onRemoveQueueItem(queueItem.getDescription());
                        }
                    }
                } else {
                    callback.onCommand(str, bundle, resultReceiver);
                }
            }
        } catch (BadParcelableException unused) {
            Log.e("MediaSessionCompat", "Could not unparcel the extra data.");
        }
        m129a.mo132c(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onCustomAction(String str, Bundle bundle) {
        C0060p m129a = m129a();
        if (m129a == null) {
            return;
        }
        MediaSessionCompat.ensureClassLoader(bundle);
        m128b(m129a);
        try {
            boolean equals = str.equals(MediaSessionCompat.ACTION_PLAY_FROM_URI);
            MediaSessionCompat.Callback callback = this.f431a;
            if (equals) {
                Uri uri = (Uri) bundle.getParcelable(MediaSessionCompat.ACTION_ARGUMENT_URI);
                Bundle bundle2 = bundle.getBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS);
                MediaSessionCompat.ensureClassLoader(bundle2);
                callback.onPlayFromUri(uri, bundle2);
            } else if (str.equals(MediaSessionCompat.ACTION_PREPARE)) {
                callback.onPrepare();
            } else if (str.equals(MediaSessionCompat.ACTION_PREPARE_FROM_MEDIA_ID)) {
                String string = bundle.getString(MediaSessionCompat.ACTION_ARGUMENT_MEDIA_ID);
                Bundle bundle3 = bundle.getBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS);
                MediaSessionCompat.ensureClassLoader(bundle3);
                callback.onPrepareFromMediaId(string, bundle3);
            } else if (str.equals(MediaSessionCompat.ACTION_PREPARE_FROM_SEARCH)) {
                String string2 = bundle.getString(MediaSessionCompat.ACTION_ARGUMENT_QUERY);
                Bundle bundle4 = bundle.getBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS);
                MediaSessionCompat.ensureClassLoader(bundle4);
                callback.onPrepareFromSearch(string2, bundle4);
            } else if (str.equals(MediaSessionCompat.ACTION_PREPARE_FROM_URI)) {
                Uri uri2 = (Uri) bundle.getParcelable(MediaSessionCompat.ACTION_ARGUMENT_URI);
                Bundle bundle5 = bundle.getBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS);
                MediaSessionCompat.ensureClassLoader(bundle5);
                callback.onPrepareFromUri(uri2, bundle5);
            } else if (str.equals(MediaSessionCompat.ACTION_SET_CAPTIONING_ENABLED)) {
                callback.onSetCaptioningEnabled(bundle.getBoolean(MediaSessionCompat.ACTION_ARGUMENT_CAPTIONING_ENABLED));
            } else if (str.equals(MediaSessionCompat.ACTION_SET_REPEAT_MODE)) {
                callback.onSetRepeatMode(bundle.getInt(MediaSessionCompat.ACTION_ARGUMENT_REPEAT_MODE));
            } else if (str.equals(MediaSessionCompat.ACTION_SET_SHUFFLE_MODE)) {
                callback.onSetShuffleMode(bundle.getInt(MediaSessionCompat.ACTION_ARGUMENT_SHUFFLE_MODE));
            } else if (str.equals(MediaSessionCompat.ACTION_SET_RATING)) {
                RatingCompat ratingCompat = (RatingCompat) bundle.getParcelable(MediaSessionCompat.ACTION_ARGUMENT_RATING);
                Bundle bundle6 = bundle.getBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS);
                MediaSessionCompat.ensureClassLoader(bundle6);
                callback.onSetRating(ratingCompat, bundle6);
            } else if (str.equals(MediaSessionCompat.ACTION_SET_PLAYBACK_SPEED)) {
                callback.onSetPlaybackSpeed(bundle.getFloat(MediaSessionCompat.ACTION_ARGUMENT_PLAYBACK_SPEED, 1.0f));
            } else {
                callback.onCustomAction(str, bundle);
            }
        } catch (BadParcelableException unused) {
            Log.e("MediaSessionCompat", "Could not unparcel the data.");
        }
        m129a.mo132c(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onFastForward() {
        C0060p m129a = m129a();
        if (m129a == null) {
            return;
        }
        m128b(m129a);
        this.f431a.onFastForward();
        m129a.mo132c(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final boolean onMediaButtonEvent(Intent intent) {
        C0060p m129a = m129a();
        if (m129a == null) {
            return false;
        }
        m128b(m129a);
        boolean onMediaButtonEvent = this.f431a.onMediaButtonEvent(intent);
        m129a.mo132c(null);
        if (!onMediaButtonEvent && !super.onMediaButtonEvent(intent)) {
            return false;
        }
        return true;
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onPause() {
        C0060p m129a = m129a();
        if (m129a == null) {
            return;
        }
        m128b(m129a);
        this.f431a.onPause();
        m129a.mo132c(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onPlay() {
        C0060p m129a = m129a();
        if (m129a == null) {
            return;
        }
        m128b(m129a);
        this.f431a.onPlay();
        m129a.mo132c(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onPlayFromMediaId(String str, Bundle bundle) {
        C0060p m129a = m129a();
        if (m129a == null) {
            return;
        }
        MediaSessionCompat.ensureClassLoader(bundle);
        m128b(m129a);
        this.f431a.onPlayFromMediaId(str, bundle);
        m129a.mo132c(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onPlayFromSearch(String str, Bundle bundle) {
        C0060p m129a = m129a();
        if (m129a == null) {
            return;
        }
        MediaSessionCompat.ensureClassLoader(bundle);
        m128b(m129a);
        this.f431a.onPlayFromSearch(str, bundle);
        m129a.mo132c(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onPlayFromUri(Uri uri, Bundle bundle) {
        C0060p m129a = m129a();
        if (m129a == null) {
            return;
        }
        MediaSessionCompat.ensureClassLoader(bundle);
        m128b(m129a);
        this.f431a.onPlayFromUri(uri, bundle);
        m129a.mo132c(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onPrepare() {
        C0060p m129a = m129a();
        if (m129a == null) {
            return;
        }
        m128b(m129a);
        this.f431a.onPrepare();
        m129a.mo132c(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onPrepareFromMediaId(String str, Bundle bundle) {
        C0060p m129a = m129a();
        if (m129a == null) {
            return;
        }
        MediaSessionCompat.ensureClassLoader(bundle);
        m128b(m129a);
        this.f431a.onPrepareFromMediaId(str, bundle);
        m129a.mo132c(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onPrepareFromSearch(String str, Bundle bundle) {
        C0060p m129a = m129a();
        if (m129a == null) {
            return;
        }
        MediaSessionCompat.ensureClassLoader(bundle);
        m128b(m129a);
        this.f431a.onPrepareFromSearch(str, bundle);
        m129a.mo132c(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onPrepareFromUri(Uri uri, Bundle bundle) {
        C0060p m129a = m129a();
        if (m129a == null) {
            return;
        }
        MediaSessionCompat.ensureClassLoader(bundle);
        m128b(m129a);
        this.f431a.onPrepareFromUri(uri, bundle);
        m129a.mo132c(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onRewind() {
        C0060p m129a = m129a();
        if (m129a == null) {
            return;
        }
        m128b(m129a);
        this.f431a.onRewind();
        m129a.mo132c(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onSeekTo(long j) {
        C0060p m129a = m129a();
        if (m129a == null) {
            return;
        }
        m128b(m129a);
        this.f431a.onSeekTo(j);
        m129a.mo132c(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onSetPlaybackSpeed(float f) {
        C0060p m129a = m129a();
        if (m129a == null) {
            return;
        }
        m128b(m129a);
        this.f431a.onSetPlaybackSpeed(f);
        m129a.mo132c(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onSetRating(Rating rating) {
        C0060p m129a = m129a();
        if (m129a == null) {
            return;
        }
        m128b(m129a);
        this.f431a.onSetRating(RatingCompat.fromRating(rating));
        m129a.mo132c(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onSkipToNext() {
        C0060p m129a = m129a();
        if (m129a == null) {
            return;
        }
        m128b(m129a);
        this.f431a.onSkipToNext();
        m129a.mo132c(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onSkipToPrevious() {
        C0060p m129a = m129a();
        if (m129a == null) {
            return;
        }
        m128b(m129a);
        this.f431a.onSkipToPrevious();
        m129a.mo132c(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onSkipToQueueItem(long j) {
        C0060p m129a = m129a();
        if (m129a == null) {
            return;
        }
        m128b(m129a);
        this.f431a.onSkipToQueueItem(j);
        m129a.mo132c(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onStop() {
        C0060p m129a = m129a();
        if (m129a == null) {
            return;
        }
        m128b(m129a);
        this.f431a.onStop();
        m129a.mo132c(null);
    }
}
