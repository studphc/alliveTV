package android.support.v4.media.session;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.media.MediaMetadata;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.media.AudioAttributesCompat;
import androidx.media.R;
import androidx.versionedparcelable.VersionedParcelable;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import p000.ye0;

/* loaded from: classes.dex */
public final class MediaControllerCompat {

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String COMMAND_ADD_QUEUE_ITEM = "android.support.v4.media.session.command.ADD_QUEUE_ITEM";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String COMMAND_ADD_QUEUE_ITEM_AT = "android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String COMMAND_ARGUMENT_INDEX = "android.support.v4.media.session.command.ARGUMENT_INDEX";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String COMMAND_ARGUMENT_MEDIA_DESCRIPTION = "android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String COMMAND_GET_EXTRA_BINDER = "android.support.v4.media.session.command.GET_EXTRA_BINDER";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String COMMAND_REMOVE_QUEUE_ITEM = "android.support.v4.media.session.command.REMOVE_QUEUE_ITEM";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String COMMAND_REMOVE_QUEUE_ITEM_AT = "android.support.v4.media.session.command.REMOVE_QUEUE_ITEM_AT";

    /* renamed from: a */
    public final C0052h f354a;

    /* renamed from: b */
    public final MediaSessionCompat.Token f355b;

    /* renamed from: c */
    public final ConcurrentHashMap f356c = new ConcurrentHashMap();

    /* loaded from: classes.dex */
    public static abstract class Callback implements IBinder.DeathRecipient {

        /* renamed from: a */
        public final C0047c f357a = new C0047c(this);

        /* renamed from: b */
        public HandlerC0048d f358b;

        /* renamed from: c */
        public BinderC0051g f359c;

        /* renamed from: a */
        public final void m121a(int i, Object obj, Bundle bundle) {
            HandlerC0048d handlerC0048d = this.f358b;
            if (handlerC0048d != null) {
                Message obtainMessage = handlerC0048d.obtainMessage(i, obj);
                obtainMessage.setData(bundle);
                obtainMessage.sendToTarget();
            }
        }

        /* renamed from: b */
        public final void m122b(Handler handler) {
            if (handler == null) {
                HandlerC0048d handlerC0048d = this.f358b;
                if (handlerC0048d != null) {
                    handlerC0048d.f420a = false;
                    handlerC0048d.removeCallbacksAndMessages(null);
                    this.f358b = null;
                    return;
                }
                return;
            }
            HandlerC0048d handlerC0048d2 = new HandlerC0048d(this, handler.getLooper());
            this.f358b = handlerC0048d2;
            handlerC0048d2.f420a = true;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            m121a(8, null, null);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public IMediaControllerCallback getIControllerCallback() {
            return this.f359c;
        }

        public void onAudioInfoChanged(PlaybackInfo playbackInfo) {
        }

        public void onCaptioningEnabledChanged(boolean z) {
        }

        public void onExtrasChanged(Bundle bundle) {
        }

        public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) {
        }

        public void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat) {
        }

        public void onQueueChanged(List<MediaSessionCompat.QueueItem> list) {
        }

        public void onQueueTitleChanged(CharSequence charSequence) {
        }

        public void onRepeatModeChanged(int i) {
        }

        public void onSessionDestroyed() {
        }

        public void onSessionEvent(String str, Bundle bundle) {
        }

        public void onSessionReady() {
        }

        public void onShuffleModeChanged(int i) {
        }
    }

    /* loaded from: classes.dex */
    public static final class PlaybackInfo {
        public static final int PLAYBACK_TYPE_LOCAL = 1;
        public static final int PLAYBACK_TYPE_REMOTE = 2;

        /* renamed from: a */
        public final int f361a;

        /* renamed from: b */
        public final AudioAttributesCompat f362b;

        /* renamed from: c */
        public final int f363c;

        /* renamed from: d */
        public final int f364d;

        /* renamed from: e */
        public final int f365e;

        public PlaybackInfo(int i, AudioAttributesCompat audioAttributesCompat, int i2, int i3, int i4) {
            this.f361a = i;
            this.f362b = audioAttributesCompat;
            this.f363c = i2;
            this.f364d = i3;
            this.f365e = i4;
        }

        @NonNull
        public AudioAttributesCompat getAudioAttributes() {
            return this.f362b;
        }

        @Deprecated
        public int getAudioStream() {
            return this.f362b.getLegacyStreamType();
        }

        public int getCurrentVolume() {
            return this.f365e;
        }

        public int getMaxVolume() {
            return this.f364d;
        }

        public int getPlaybackType() {
            return this.f361a;
        }

        public int getVolumeControl() {
            return this.f363c;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class TransportControls {

        @Deprecated
        public static final String EXTRA_LEGACY_STREAM_TYPE = "android.media.session.extra.LEGACY_STREAM_TYPE";

        public abstract void fastForward();

        public abstract void pause();

        public abstract void play();

        public abstract void playFromMediaId(String str, Bundle bundle);

        public abstract void playFromSearch(String str, Bundle bundle);

        public abstract void playFromUri(Uri uri, Bundle bundle);

        public abstract void prepare();

        public abstract void prepareFromMediaId(String str, Bundle bundle);

        public abstract void prepareFromSearch(String str, Bundle bundle);

        public abstract void prepareFromUri(Uri uri, Bundle bundle);

        public abstract void rewind();

        public abstract void seekTo(long j);

        public abstract void sendCustomAction(PlaybackStateCompat.CustomAction customAction, Bundle bundle);

        public abstract void sendCustomAction(String str, Bundle bundle);

        public abstract void setCaptioningEnabled(boolean z);

        public void setPlaybackSpeed(float f) {
        }

        public abstract void setRating(RatingCompat ratingCompat);

        public abstract void setRating(RatingCompat ratingCompat, Bundle bundle);

        public abstract void setRepeatMode(int i);

        public abstract void setShuffleMode(int i);

        public abstract void skipToNext();

        public abstract void skipToPrevious();

        public abstract void skipToQueueItem(long j);

        public abstract void stop();
    }

    public MediaControllerCompat(Context context, @NonNull MediaSessionCompat mediaSessionCompat) {
        if (mediaSessionCompat != null) {
            MediaSessionCompat.Token sessionToken = mediaSessionCompat.getSessionToken();
            this.f355b = sessionToken;
            if (Build.VERSION.SDK_INT >= 29) {
                this.f354a = new C0052h(context, sessionToken);
                return;
            } else {
                this.f354a = new C0052h(context, sessionToken);
                return;
            }
        }
        throw new IllegalArgumentException("session must not be null");
    }

    /* renamed from: a */
    public static void m120a(String str, Bundle bundle) {
        if (str == null) {
            return;
        }
        if (str.equals(MediaSessionCompat.ACTION_FOLLOW) || str.equals(MediaSessionCompat.ACTION_UNFOLLOW)) {
            if (bundle != null && bundle.containsKey(MediaSessionCompat.ARGUMENT_MEDIA_ATTRIBUTE)) {
            } else {
                throw new IllegalArgumentException(ye0.m8296p("An extra field android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE is required for this action ", str, "."));
            }
        }
    }

    public static MediaControllerCompat getMediaController(@NonNull Activity activity) {
        Object tag = activity.getWindow().getDecorView().getTag(R.id.media_controller_compat_view_tag);
        if (tag instanceof MediaControllerCompat) {
            return (MediaControllerCompat) tag;
        }
        MediaController mediaController = activity.getMediaController();
        if (mediaController == null) {
            return null;
        }
        return new MediaControllerCompat(activity, MediaSessionCompat.Token.fromToken(mediaController.getSessionToken()));
    }

    public static void setMediaController(@NonNull Activity activity, MediaControllerCompat mediaControllerCompat) {
        MediaController mediaController;
        activity.getWindow().getDecorView().setTag(R.id.media_controller_compat_view_tag, mediaControllerCompat);
        if (mediaControllerCompat != null) {
            mediaController = new MediaController(activity, (MediaSession.Token) mediaControllerCompat.getSessionToken().getToken());
        } else {
            mediaController = null;
        }
        activity.setMediaController(mediaController);
    }

    public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        C0052h c0052h = this.f354a;
        if ((c0052h.f423a.getFlags() & 4) != 0) {
            Bundle bundle = new Bundle();
            bundle.putParcelable(COMMAND_ARGUMENT_MEDIA_DESCRIPTION, mediaDescriptionCompat);
            c0052h.f423a.sendCommand(COMMAND_ADD_QUEUE_ITEM, bundle, null);
            return;
        }
        throw new UnsupportedOperationException("This session doesn't support queue management operations");
    }

    public void adjustVolume(int i, int i2) {
        this.f354a.f423a.adjustVolume(i, i2);
    }

    public boolean dispatchMediaButtonEvent(KeyEvent keyEvent) {
        if (keyEvent != null) {
            return this.f354a.f423a.dispatchMediaButtonEvent(keyEvent);
        }
        throw new IllegalArgumentException("KeyEvent may not be null");
    }

    public Bundle getExtras() {
        return this.f354a.f423a.getExtras();
    }

    public long getFlags() {
        return this.f354a.f423a.getFlags();
    }

    public MediaMetadataCompat getMetadata() {
        MediaMetadata metadata = this.f354a.f423a.getMetadata();
        if (metadata != null) {
            return MediaMetadataCompat.fromMediaMetadata(metadata);
        }
        return null;
    }

    public String getPackageName() {
        return this.f354a.f423a.getPackageName();
    }

    public PlaybackInfo getPlaybackInfo() {
        MediaController.PlaybackInfo playbackInfo = this.f354a.f423a.getPlaybackInfo();
        if (playbackInfo != null) {
            return new PlaybackInfo(playbackInfo.getPlaybackType(), AudioAttributesCompat.wrap(playbackInfo.getAudioAttributes()), playbackInfo.getVolumeControl(), playbackInfo.getMaxVolume(), playbackInfo.getCurrentVolume());
        }
        return null;
    }

    public PlaybackStateCompat getPlaybackState() {
        C0052h c0052h = this.f354a;
        MediaSessionCompat.Token token = c0052h.f428f;
        if (token.getExtraBinder() != null) {
            try {
                return token.getExtraBinder().getPlaybackState();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in getPlaybackState.", e);
            }
        }
        PlaybackState playbackState = c0052h.f423a.getPlaybackState();
        if (playbackState != null) {
            return PlaybackStateCompat.fromPlaybackState(playbackState);
        }
        return null;
    }

    public List<MediaSessionCompat.QueueItem> getQueue() {
        List<MediaSession.QueueItem> queue = this.f354a.f423a.getQueue();
        if (queue != null) {
            return MediaSessionCompat.QueueItem.fromQueueItemList(queue);
        }
        return null;
    }

    public CharSequence getQueueTitle() {
        return this.f354a.f423a.getQueueTitle();
    }

    public int getRatingType() {
        return this.f354a.f423a.getRatingType();
    }

    public int getRepeatMode() {
        MediaSessionCompat.Token token = this.f354a.f428f;
        if (token.getExtraBinder() != null) {
            try {
                return token.getExtraBinder().getRepeatMode();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in getRepeatMode.", e);
            }
        }
        return -1;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public VersionedParcelable getSession2Token() {
        return this.f355b.getSession2Token();
    }

    public PendingIntent getSessionActivity() {
        return this.f354a.f423a.getSessionActivity();
    }

    @NonNull
    public Bundle getSessionInfo() {
        return this.f354a.getSessionInfo();
    }

    public MediaSessionCompat.Token getSessionToken() {
        return this.f355b;
    }

    public int getShuffleMode() {
        MediaSessionCompat.Token token = this.f354a.f428f;
        if (token.getExtraBinder() != null) {
            try {
                return token.getExtraBinder().getShuffleMode();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in getShuffleMode.", e);
            }
        }
        return -1;
    }

    public TransportControls getTransportControls() {
        MediaController.TransportControls transportControls = this.f354a.f423a.getTransportControls();
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            return new AbstractC0054j(transportControls);
        }
        if (i >= 24) {
            return new AbstractC0054j(transportControls);
        }
        return new AbstractC0054j(transportControls);
    }

    public boolean isCaptioningEnabled() {
        MediaSessionCompat.Token token = this.f354a.f428f;
        if (token.getExtraBinder() != null) {
            try {
                return token.getExtraBinder().isCaptioningEnabled();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in isCaptioningEnabled.", e);
            }
        }
        return false;
    }

    public boolean isSessionReady() {
        if (this.f354a.f428f.getExtraBinder() != null) {
            return true;
        }
        return false;
    }

    public void registerCallback(@NonNull Callback callback) {
        registerCallback(callback, null);
    }

    public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        C0052h c0052h = this.f354a;
        if ((c0052h.f423a.getFlags() & 4) != 0) {
            Bundle bundle = new Bundle();
            bundle.putParcelable(COMMAND_ARGUMENT_MEDIA_DESCRIPTION, mediaDescriptionCompat);
            c0052h.f423a.sendCommand(COMMAND_REMOVE_QUEUE_ITEM, bundle, null);
            return;
        }
        throw new UnsupportedOperationException("This session doesn't support queue management operations");
    }

    @Deprecated
    public void removeQueueItemAt(int i) {
        MediaSessionCompat.QueueItem queueItem;
        List<MediaSessionCompat.QueueItem> queue = getQueue();
        if (queue != null && i >= 0 && i < queue.size() && (queueItem = queue.get(i)) != null) {
            removeQueueItem(queueItem.getDescription());
        }
    }

    public void sendCommand(@NonNull String str, @Nullable Bundle bundle, @Nullable ResultReceiver resultReceiver) {
        if (!TextUtils.isEmpty(str)) {
            this.f354a.f423a.sendCommand(str, bundle, resultReceiver);
            return;
        }
        throw new IllegalArgumentException("command must neither be null nor empty");
    }

    public void setVolumeTo(int i, int i2) {
        this.f354a.f423a.setVolumeTo(i, i2);
    }

    public void unregisterCallback(@NonNull Callback callback) {
        if (callback != null) {
            if (this.f356c.remove(callback) == null) {
                Log.w("MediaControllerCompat", "the callback has never been registered");
                return;
            }
            try {
                this.f354a.m127b(callback);
                return;
            } finally {
                callback.m122b(null);
            }
        }
        throw new IllegalArgumentException("callback must not be null");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [android.support.v4.media.session.g, android.support.v4.media.session.IMediaControllerCallback, android.support.v4.media.session.e, java.lang.Object] */
    public void registerCallback(@NonNull Callback callback, Handler handler) {
        if (callback != null) {
            if (this.f356c.putIfAbsent(callback, Boolean.TRUE) != null) {
                Log.w("MediaControllerCompat", "the callback has already been registered");
                return;
            }
            if (handler == null) {
                handler = new Handler();
            }
            callback.m122b(handler);
            C0052h c0052h = this.f354a;
            c0052h.f423a.registerCallback(callback.f357a, handler);
            synchronized (c0052h.f424b) {
                if (c0052h.f428f.getExtraBinder() != null) {
                    ?? abstractBinderC0049e = new AbstractBinderC0049e(callback);
                    c0052h.f426d.put(callback, abstractBinderC0049e);
                    callback.f359c = abstractBinderC0049e;
                    try {
                        c0052h.f428f.getExtraBinder().registerCallbackListener(abstractBinderC0049e);
                        callback.m121a(13, null, null);
                    } catch (RemoteException e) {
                        Log.e("MediaControllerCompat", "Dead object in registerCallback.", e);
                    }
                } else {
                    callback.f359c = null;
                    c0052h.f425c.add(callback);
                }
            }
            return;
        }
        throw new IllegalArgumentException("callback must not be null");
    }

    public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat, int i) {
        C0052h c0052h = this.f354a;
        if ((c0052h.f423a.getFlags() & 4) != 0) {
            Bundle bundle = new Bundle();
            bundle.putParcelable(COMMAND_ARGUMENT_MEDIA_DESCRIPTION, mediaDescriptionCompat);
            bundle.putInt(COMMAND_ARGUMENT_INDEX, i);
            c0052h.f423a.sendCommand(COMMAND_ADD_QUEUE_ITEM_AT, bundle, null);
            return;
        }
        throw new UnsupportedOperationException("This session doesn't support queue management operations");
    }

    public Object getMediaController() {
        return this.f354a.f423a;
    }

    public MediaControllerCompat(Context context, @NonNull MediaSessionCompat.Token token) {
        if (token != null) {
            this.f355b = token;
            this.f354a = new C0052h(context, token);
            return;
        }
        throw new IllegalArgumentException("sessionToken must not be null");
    }
}
