package android.support.v4.media.session;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.MediaDescription;
import android.media.MediaMetadata;
import android.media.VolumeProvider;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.net.Uri;
import android.os.BadParcelableException;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.app.BundleCompat;
import androidx.core.os.BuildCompat;
import androidx.media.MediaSessionManager;
import androidx.media.VolumeProviderCompat;
import androidx.media.session.MediaButtonReceiver;
import androidx.versionedparcelable.ParcelUtils;
import androidx.versionedparcelable.VersionedParcelable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import p000.ye0;

/* loaded from: classes.dex */
public class MediaSessionCompat {

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_ARGUMENT_CAPTIONING_ENABLED = "android.support.v4.media.session.action.ARGUMENT_CAPTIONING_ENABLED";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_ARGUMENT_EXTRAS = "android.support.v4.media.session.action.ARGUMENT_EXTRAS";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_ARGUMENT_MEDIA_ID = "android.support.v4.media.session.action.ARGUMENT_MEDIA_ID";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_ARGUMENT_PLAYBACK_SPEED = "android.support.v4.media.session.action.ARGUMENT_PLAYBACK_SPEED";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_ARGUMENT_QUERY = "android.support.v4.media.session.action.ARGUMENT_QUERY";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_ARGUMENT_RATING = "android.support.v4.media.session.action.ARGUMENT_RATING";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_ARGUMENT_REPEAT_MODE = "android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_ARGUMENT_SHUFFLE_MODE = "android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_ARGUMENT_URI = "android.support.v4.media.session.action.ARGUMENT_URI";
    public static final String ACTION_FLAG_AS_INAPPROPRIATE = "android.support.v4.media.session.action.FLAG_AS_INAPPROPRIATE";
    public static final String ACTION_FOLLOW = "android.support.v4.media.session.action.FOLLOW";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_PLAY_FROM_URI = "android.support.v4.media.session.action.PLAY_FROM_URI";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_PREPARE = "android.support.v4.media.session.action.PREPARE";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_PREPARE_FROM_MEDIA_ID = "android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_PREPARE_FROM_SEARCH = "android.support.v4.media.session.action.PREPARE_FROM_SEARCH";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_PREPARE_FROM_URI = "android.support.v4.media.session.action.PREPARE_FROM_URI";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_SET_CAPTIONING_ENABLED = "android.support.v4.media.session.action.SET_CAPTIONING_ENABLED";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_SET_PLAYBACK_SPEED = "android.support.v4.media.session.action.SET_PLAYBACK_SPEED";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_SET_RATING = "android.support.v4.media.session.action.SET_RATING";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_SET_REPEAT_MODE = "android.support.v4.media.session.action.SET_REPEAT_MODE";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_SET_SHUFFLE_MODE = "android.support.v4.media.session.action.SET_SHUFFLE_MODE";
    public static final String ACTION_SKIP_AD = "android.support.v4.media.session.action.SKIP_AD";
    public static final String ACTION_UNFOLLOW = "android.support.v4.media.session.action.UNFOLLOW";
    public static final String ARGUMENT_MEDIA_ATTRIBUTE = "android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE";
    public static final String ARGUMENT_MEDIA_ATTRIBUTE_VALUE = "android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE_VALUE";

    @Deprecated
    public static final int FLAG_HANDLES_MEDIA_BUTTONS = 1;
    public static final int FLAG_HANDLES_QUEUE_COMMANDS = 4;

    @Deprecated
    public static final int FLAG_HANDLES_TRANSPORT_CONTROLS = 2;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String KEY_EXTRA_BINDER = "android.support.v4.media.session.EXTRA_BINDER";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String KEY_SESSION2_TOKEN = "android.support.v4.media.session.SESSION_TOKEN2";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String KEY_TOKEN = "android.support.v4.media.session.TOKEN";
    public static final int MEDIA_ATTRIBUTE_ALBUM = 1;
    public static final int MEDIA_ATTRIBUTE_ARTIST = 0;
    public static final int MEDIA_ATTRIBUTE_PLAYLIST = 2;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final int PENDING_INTENT_FLAG_MUTABLE;

    /* renamed from: d */
    public static int f366d;

    /* renamed from: a */
    public final C0060p f367a;

    /* renamed from: b */
    public final MediaControllerCompat f368b;

    /* renamed from: c */
    public final ArrayList f369c;

    /* loaded from: classes.dex */
    public static abstract class Callback {

        /* renamed from: c */
        public boolean f372c;

        /* renamed from: e */
        public HandlerC0056l f374e;

        /* renamed from: a */
        public final Object f370a = new Object();

        /* renamed from: b */
        public final C0057m f371b = new C0057m(this);

        /* renamed from: d */
        public WeakReference f373d = new WeakReference(null);

        /* renamed from: a */
        public final void m124a(InterfaceC0058n interfaceC0058n, Handler handler) {
            long actions;
            boolean z;
            boolean z2;
            if (!this.f372c) {
                return;
            }
            boolean z3 = false;
            this.f372c = false;
            handler.removeMessages(1);
            PlaybackStateCompat playbackState = interfaceC0058n.getPlaybackState();
            if (playbackState == null) {
                actions = 0;
            } else {
                actions = playbackState.getActions();
            }
            if (playbackState != null && playbackState.getState() == 3) {
                z = true;
            } else {
                z = false;
            }
            if ((516 & actions) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if ((actions & 514) != 0) {
                z3 = true;
            }
            if (z && z3) {
                onPause();
            } else if (!z && z2) {
                onPlay();
            }
        }

        /* renamed from: b */
        public final void m125b(InterfaceC0058n interfaceC0058n, Handler handler) {
            synchronized (this.f370a) {
                try {
                    this.f373d = new WeakReference(interfaceC0058n);
                    HandlerC0056l handlerC0056l = this.f374e;
                    HandlerC0056l handlerC0056l2 = null;
                    if (handlerC0056l != null) {
                        handlerC0056l.removeCallbacksAndMessages(null);
                    }
                    if (interfaceC0058n != null && handler != null) {
                        handlerC0056l2 = new HandlerC0056l(this, handler.getLooper());
                    }
                    this.f374e = handlerC0056l2;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void onAddQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        }

        public void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
        }

        public void onCustomAction(String str, Bundle bundle) {
        }

        public void onFastForward() {
        }

        public boolean onMediaButtonEvent(Intent intent) {
            InterfaceC0058n interfaceC0058n;
            HandlerC0056l handlerC0056l;
            KeyEvent keyEvent;
            long actions;
            if (Build.VERSION.SDK_INT >= 27) {
                return false;
            }
            synchronized (this.f370a) {
                interfaceC0058n = (InterfaceC0058n) this.f373d.get();
                handlerC0056l = this.f374e;
            }
            if (interfaceC0058n == null || handlerC0056l == null || (keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT")) == null || keyEvent.getAction() != 0) {
                return false;
            }
            MediaSessionManager.RemoteUserInfo mo133d = interfaceC0058n.mo133d();
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 79 && keyCode != 85) {
                m124a(interfaceC0058n, handlerC0056l);
                return false;
            }
            if (keyEvent.getRepeatCount() == 0) {
                if (this.f372c) {
                    handlerC0056l.removeMessages(1);
                    this.f372c = false;
                    PlaybackStateCompat playbackState = interfaceC0058n.getPlaybackState();
                    if (playbackState == null) {
                        actions = 0;
                    } else {
                        actions = playbackState.getActions();
                    }
                    if ((actions & 32) != 0) {
                        onSkipToNext();
                    }
                } else {
                    this.f372c = true;
                    handlerC0056l.sendMessageDelayed(handlerC0056l.obtainMessage(1, mo133d), ViewConfiguration.getDoubleTapTimeout());
                }
            } else {
                m124a(interfaceC0058n, handlerC0056l);
            }
            return true;
        }

        public void onPause() {
        }

        public void onPlay() {
        }

        public void onPlayFromMediaId(String str, Bundle bundle) {
        }

        public void onPlayFromSearch(String str, Bundle bundle) {
        }

        public void onPlayFromUri(Uri uri, Bundle bundle) {
        }

        public void onPrepare() {
        }

        public void onPrepareFromMediaId(String str, Bundle bundle) {
        }

        public void onPrepareFromSearch(String str, Bundle bundle) {
        }

        public void onPrepareFromUri(Uri uri, Bundle bundle) {
        }

        public void onRemoveQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        }

        @Deprecated
        public void onRemoveQueueItemAt(int i) {
        }

        public void onRewind() {
        }

        public void onSeekTo(long j) {
        }

        public void onSetCaptioningEnabled(boolean z) {
        }

        public void onSetPlaybackSpeed(float f) {
        }

        public void onSetRating(RatingCompat ratingCompat) {
        }

        public void onSetRepeatMode(int i) {
        }

        public void onSetShuffleMode(int i) {
        }

        public void onSkipToNext() {
        }

        public void onSkipToPrevious() {
        }

        public void onSkipToQueueItem(long j) {
        }

        public void onStop() {
        }

        public void onAddQueueItem(MediaDescriptionCompat mediaDescriptionCompat, int i) {
        }

        public void onSetRating(RatingCompat ratingCompat, Bundle bundle) {
        }
    }

    /* loaded from: classes.dex */
    public interface OnActiveChangeListener {
        void onActiveChanged();
    }

    @SuppressLint({"BanParcelableUsage"})
    /* loaded from: classes.dex */
    public static final class QueueItem implements Parcelable {
        public static final Parcelable.Creator<QueueItem> CREATOR = new Object();
        public static final int UNKNOWN_ID = -1;

        /* renamed from: a */
        public final MediaDescriptionCompat f375a;

        /* renamed from: b */
        public final long f376b;

        /* renamed from: c */
        public MediaSession.QueueItem f377c;

        public QueueItem(MediaDescriptionCompat mediaDescriptionCompat, long j) {
            this(null, mediaDescriptionCompat, j);
        }

        public static QueueItem fromQueueItem(Object obj) {
            if (obj != null) {
                MediaSession.QueueItem queueItem = (MediaSession.QueueItem) obj;
                return new QueueItem(queueItem, MediaDescriptionCompat.fromMediaDescription(AbstractC0062r.m140b(queueItem)), AbstractC0062r.m141c(queueItem));
            }
            return null;
        }

        public static List<QueueItem> fromQueueItemList(List<?> list) {
            if (list != null) {
                ArrayList arrayList = new ArrayList();
                Iterator<?> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(fromQueueItem(it.next()));
                }
                return arrayList;
            }
            return null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public MediaDescriptionCompat getDescription() {
            return this.f375a;
        }

        public long getQueueId() {
            return this.f376b;
        }

        public Object getQueueItem() {
            MediaSession.QueueItem queueItem = this.f377c;
            if (queueItem == null) {
                MediaSession.QueueItem m139a = AbstractC0062r.m139a((MediaDescription) this.f375a.getMediaDescription(), this.f376b);
                this.f377c = m139a;
                return m139a;
            }
            return queueItem;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("MediaSession.QueueItem {Description=");
            sb.append(this.f375a);
            sb.append(", Id=");
            return ye0.m8297q(sb, this.f376b, " }");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            this.f375a.writeToParcel(parcel, i);
            parcel.writeLong(this.f376b);
        }

        public QueueItem(MediaSession.QueueItem queueItem, MediaDescriptionCompat mediaDescriptionCompat, long j) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("Description cannot be null");
            }
            if (j != -1) {
                this.f375a = mediaDescriptionCompat;
                this.f376b = j;
                this.f377c = queueItem;
                return;
            }
            throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
        }

        public QueueItem(Parcel parcel) {
            this.f375a = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.f376b = parcel.readLong();
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    /* loaded from: classes.dex */
    public static final class ResultReceiverWrapper implements Parcelable {
        public static final Parcelable.Creator<ResultReceiverWrapper> CREATOR = new Object();

        /* renamed from: a */
        public ResultReceiver f378a;

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            this.f378a.writeToParcel(parcel, i);
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    /* loaded from: classes.dex */
    public static final class Token implements Parcelable {
        public static final Parcelable.Creator<Token> CREATOR = new Object();

        /* renamed from: a */
        public final Object f379a = new Object();

        /* renamed from: b */
        public final Object f380b;

        /* renamed from: c */
        public IMediaSession f381c;

        /* renamed from: d */
        public VersionedParcelable f382d;

        public Token(Object obj, IMediaSession iMediaSession, VersionedParcelable versionedParcelable) {
            this.f380b = obj;
            this.f381c = iMediaSession;
            this.f382d = versionedParcelable;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public static Token fromBundle(Bundle bundle) {
            if (bundle == null) {
                return null;
            }
            bundle.setClassLoader(Token.class.getClassLoader());
            IMediaSession asInterface = IMediaSession.Stub.asInterface(BundleCompat.getBinder(bundle, MediaSessionCompat.KEY_EXTRA_BINDER));
            VersionedParcelable versionedParcelable = ParcelUtils.getVersionedParcelable(bundle, MediaSessionCompat.KEY_SESSION2_TOKEN);
            Token token = (Token) bundle.getParcelable(MediaSessionCompat.KEY_TOKEN);
            if (token == null) {
                return null;
            }
            return new Token(token.f380b, asInterface, versionedParcelable);
        }

        public static Token fromToken(Object obj) {
            return fromToken(obj, null);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Token)) {
                return false;
            }
            Token token = (Token) obj;
            Object obj2 = this.f380b;
            if (obj2 == null) {
                if (token.f380b == null) {
                    return true;
                }
                return false;
            }
            Object obj3 = token.f380b;
            if (obj3 == null) {
                return false;
            }
            return obj2.equals(obj3);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public IMediaSession getExtraBinder() {
            IMediaSession iMediaSession;
            synchronized (this.f379a) {
                iMediaSession = this.f381c;
            }
            return iMediaSession;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public VersionedParcelable getSession2Token() {
            VersionedParcelable versionedParcelable;
            synchronized (this.f379a) {
                versionedParcelable = this.f382d;
            }
            return versionedParcelable;
        }

        public Object getToken() {
            return this.f380b;
        }

        public int hashCode() {
            Object obj = this.f380b;
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public void setExtraBinder(IMediaSession iMediaSession) {
            synchronized (this.f379a) {
                this.f381c = iMediaSession;
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void setSession2Token(VersionedParcelable versionedParcelable) {
            synchronized (this.f379a) {
                this.f382d = versionedParcelable;
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putParcelable(MediaSessionCompat.KEY_TOKEN, this);
            synchronized (this.f379a) {
                try {
                    IMediaSession iMediaSession = this.f381c;
                    if (iMediaSession != null) {
                        BundleCompat.putBinder(bundle, MediaSessionCompat.KEY_EXTRA_BINDER, iMediaSession.asBinder());
                    }
                    VersionedParcelable versionedParcelable = this.f382d;
                    if (versionedParcelable != null) {
                        ParcelUtils.putVersionedParcelable(bundle, MediaSessionCompat.KEY_SESSION2_TOKEN, versionedParcelable);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return bundle;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable((Parcelable) this.f380b, i);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public static Token fromToken(Object obj, IMediaSession iMediaSession) {
            if (obj == null) {
                return null;
            }
            if (obj instanceof MediaSession.Token) {
                return new Token(obj, iMediaSession, null);
            }
            throw new IllegalArgumentException("token is not a valid MediaSession.Token object");
        }
    }

    static {
        int i;
        if (BuildCompat.isAtLeastS()) {
            i = 33554432;
        } else {
            i = 0;
        }
        PENDING_INTENT_FLAG_MUTABLE = i;
    }

    public MediaSessionCompat(@NonNull Context context, @NonNull String str) {
        this(context, str, null, null);
    }

    /* renamed from: a */
    public static PlaybackStateCompat m123a(PlaybackStateCompat playbackStateCompat, MediaMetadataCompat mediaMetadataCompat) {
        long j;
        if (playbackStateCompat != null) {
            long j2 = -1;
            if (playbackStateCompat.getPosition() != -1) {
                if (playbackStateCompat.getState() == 3 || playbackStateCompat.getState() == 4 || playbackStateCompat.getState() == 5) {
                    if (playbackStateCompat.getLastPositionUpdateTime() > 0) {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        long position = playbackStateCompat.getPosition() + (playbackStateCompat.getPlaybackSpeed() * ((float) (elapsedRealtime - r0)));
                        if (mediaMetadataCompat != null && mediaMetadataCompat.containsKey(MediaMetadataCompat.METADATA_KEY_DURATION)) {
                            j2 = mediaMetadataCompat.getLong(MediaMetadataCompat.METADATA_KEY_DURATION);
                        }
                        if (j2 >= 0 && position > j2) {
                            j = j2;
                        } else if (position < 0) {
                            j = 0;
                        } else {
                            j = position;
                        }
                        return new PlaybackStateCompat.Builder(playbackStateCompat).setState(playbackStateCompat.getState(), j, playbackStateCompat.getPlaybackSpeed(), elapsedRealtime).build();
                    }
                    return playbackStateCompat;
                }
                return playbackStateCompat;
            }
            return playbackStateCompat;
        }
        return playbackStateCompat;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static void ensureClassLoader(@Nullable Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MediaSessionCompat.class.getClassLoader());
        }
    }

    public static MediaSessionCompat fromMediaSession(Context context, Object obj) {
        C0060p c0060p;
        Bundle sessionInfo;
        int i = Build.VERSION.SDK_INT;
        if (context != null && obj != null) {
            if (i >= 29) {
                c0060p = new C0060p(obj);
                sessionInfo = ((MediaSession) obj).getController().getSessionInfo();
                c0060p.f436d = sessionInfo;
            } else if (i >= 28) {
                c0060p = new C0060p(obj);
            } else {
                c0060p = new C0060p(obj);
            }
            return new MediaSessionCompat(context, c0060p);
        }
        return null;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static Bundle unparcelWithClassLoader(@Nullable Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        ensureClassLoader(bundle);
        try {
            bundle.isEmpty();
            return bundle;
        } catch (BadParcelableException unused) {
            Log.e("MediaSessionCompat", "Could not unparcel the data.");
            return null;
        }
    }

    public void addOnActiveChangeListener(OnActiveChangeListener onActiveChangeListener) {
        if (onActiveChangeListener != null) {
            this.f369c.add(onActiveChangeListener);
            return;
        }
        throw new IllegalArgumentException("Listener may not be null");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public String getCallingPackage() {
        return this.f367a.m135f();
    }

    public MediaControllerCompat getController() {
        return this.f368b;
    }

    @NonNull
    public final MediaSessionManager.RemoteUserInfo getCurrentControllerInfo() {
        return this.f367a.mo133d();
    }

    public Object getMediaSession() {
        return this.f367a.f433a;
    }

    public Object getRemoteControlClient() {
        this.f367a.getClass();
        return null;
    }

    public Token getSessionToken() {
        return this.f367a.f434b;
    }

    public boolean isActive() {
        return this.f367a.f433a.isActive();
    }

    public void release() {
        C0060p c0060p = this.f367a;
        c0060p.f437e = true;
        c0060p.f438f.kill();
        int i = Build.VERSION.SDK_INT;
        MediaSession mediaSession = c0060p.f433a;
        if (i == 27) {
            try {
                Field declaredField = mediaSession.getClass().getDeclaredField("mCallback");
                declaredField.setAccessible(true);
                Handler handler = (Handler) declaredField.get(mediaSession);
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                }
            } catch (Exception e) {
                Log.w("MediaSessionCompat", "Exception happened while accessing MediaSession.mCallback.", e);
            }
        }
        mediaSession.setCallback(null);
        mediaSession.release();
    }

    public void removeOnActiveChangeListener(OnActiveChangeListener onActiveChangeListener) {
        if (onActiveChangeListener != null) {
            this.f369c.remove(onActiveChangeListener);
            return;
        }
        throw new IllegalArgumentException("Listener may not be null");
    }

    public void sendSessionEvent(String str, Bundle bundle) {
        if (!TextUtils.isEmpty(str)) {
            this.f367a.f433a.sendSessionEvent(str, bundle);
            return;
        }
        throw new IllegalArgumentException("event cannot be null or empty");
    }

    public void setActive(boolean z) {
        this.f367a.f433a.setActive(z);
        Iterator it = this.f369c.iterator();
        while (it.hasNext()) {
            ((OnActiveChangeListener) it.next()).onActiveChanged();
        }
    }

    public void setCallback(Callback callback) {
        setCallback(callback, null);
    }

    public void setCaptioningEnabled(boolean z) {
        C0060p c0060p = this.f367a;
        if (c0060p.f443k != z) {
            c0060p.f443k = z;
            RemoteCallbackList remoteCallbackList = c0060p.f438f;
            for (int beginBroadcast = remoteCallbackList.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    ((IMediaControllerCallback) remoteCallbackList.getBroadcastItem(beginBroadcast)).onCaptioningEnabledChanged(z);
                } catch (RemoteException unused) {
                }
            }
            remoteCallbackList.finishBroadcast();
        }
    }

    public void setExtras(Bundle bundle) {
        this.f367a.f433a.setExtras(bundle);
    }

    public void setFlags(int i) {
        this.f367a.m137h(i);
    }

    public void setMediaButtonReceiver(PendingIntent pendingIntent) {
        this.f367a.m138i(pendingIntent);
    }

    public void setMetadata(MediaMetadataCompat mediaMetadataCompat) {
        MediaMetadata mediaMetadata;
        C0060p c0060p = this.f367a;
        c0060p.f441i = mediaMetadataCompat;
        if (mediaMetadataCompat == null) {
            mediaMetadata = null;
        } else {
            mediaMetadata = (MediaMetadata) mediaMetadataCompat.getMediaMetadata();
        }
        c0060p.f433a.setMetadata(mediaMetadata);
    }

    public void setPlaybackState(PlaybackStateCompat playbackStateCompat) {
        PlaybackState playbackState;
        C0060p c0060p = this.f367a;
        c0060p.f439g = playbackStateCompat;
        RemoteCallbackList remoteCallbackList = c0060p.f438f;
        for (int beginBroadcast = remoteCallbackList.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
            try {
                ((IMediaControllerCallback) remoteCallbackList.getBroadcastItem(beginBroadcast)).onPlaybackStateChanged(playbackStateCompat);
            } catch (RemoteException unused) {
            }
        }
        remoteCallbackList.finishBroadcast();
        if (playbackStateCompat == null) {
            playbackState = null;
        } else {
            playbackState = (PlaybackState) playbackStateCompat.getPlaybackState();
        }
        c0060p.f433a.setPlaybackState(playbackState);
    }

    public void setPlaybackToLocal(int i) {
        C0060p c0060p = this.f367a;
        c0060p.getClass();
        AudioAttributes.Builder builder = new AudioAttributes.Builder();
        builder.setLegacyStreamType(i);
        c0060p.f433a.setPlaybackToLocal(builder.build());
    }

    public void setPlaybackToRemote(VolumeProviderCompat volumeProviderCompat) {
        if (volumeProviderCompat != null) {
            C0060p c0060p = this.f367a;
            c0060p.getClass();
            c0060p.f433a.setPlaybackToRemote((VolumeProvider) volumeProviderCompat.getVolumeProvider());
            return;
        }
        throw new IllegalArgumentException("volumeProvider may not be null!");
    }

    public void setQueue(List<QueueItem> list) {
        if (list != null) {
            HashSet hashSet = new HashSet();
            for (QueueItem queueItem : list) {
                if (queueItem != null) {
                    if (hashSet.contains(Long.valueOf(queueItem.getQueueId()))) {
                        Log.e("MediaSessionCompat", "Found duplicate queue id: " + queueItem.getQueueId(), new IllegalArgumentException("id of each queue item should be unique"));
                    }
                    hashSet.add(Long.valueOf(queueItem.getQueueId()));
                } else {
                    throw new IllegalArgumentException("queue shouldn't have null items");
                }
            }
        }
        C0060p c0060p = this.f367a;
        c0060p.f440h = list;
        MediaSession mediaSession = c0060p.f433a;
        if (list == null) {
            mediaSession.setQueue(null);
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<QueueItem> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((MediaSession.QueueItem) it.next().getQueueItem());
        }
        mediaSession.setQueue(arrayList);
    }

    public void setQueueTitle(CharSequence charSequence) {
        this.f367a.f433a.setQueueTitle(charSequence);
    }

    public void setRatingType(int i) {
        this.f367a.mo131b(i);
    }

    public void setRepeatMode(int i) {
        C0060p c0060p = this.f367a;
        if (c0060p.f444l != i) {
            c0060p.f444l = i;
            RemoteCallbackList remoteCallbackList = c0060p.f438f;
            for (int beginBroadcast = remoteCallbackList.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    ((IMediaControllerCallback) remoteCallbackList.getBroadcastItem(beginBroadcast)).onRepeatModeChanged(i);
                } catch (RemoteException unused) {
                }
            }
            remoteCallbackList.finishBroadcast();
        }
    }

    public void setSessionActivity(PendingIntent pendingIntent) {
        this.f367a.f433a.setSessionActivity(pendingIntent);
    }

    public void setShuffleMode(int i) {
        C0060p c0060p = this.f367a;
        if (c0060p.f445m != i) {
            c0060p.f445m = i;
            RemoteCallbackList remoteCallbackList = c0060p.f438f;
            for (int beginBroadcast = remoteCallbackList.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    ((IMediaControllerCallback) remoteCallbackList.getBroadcastItem(beginBroadcast)).onShuffleModeChanged(i);
                } catch (RemoteException unused) {
                }
            }
            remoteCallbackList.finishBroadcast();
        }
    }

    public MediaSessionCompat(@NonNull Context context, @NonNull String str, @Nullable ComponentName componentName, @Nullable PendingIntent pendingIntent) {
        this(context, str, componentName, pendingIntent, null);
    }

    public void setCallback(Callback callback, Handler handler) {
        C0060p c0060p = this.f367a;
        if (callback == null) {
            c0060p.m136g(null, null);
            return;
        }
        if (handler == null) {
            handler = new Handler();
        }
        c0060p.m136g(callback, handler);
    }

    public MediaSessionCompat(@NonNull Context context, @NonNull String str, @Nullable ComponentName componentName, @Nullable PendingIntent pendingIntent, @Nullable Bundle bundle) {
        this(context, str, componentName, pendingIntent, bundle, null);
    }

    @SuppressLint({"WrongConstant"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public MediaSessionCompat(@NonNull Context context, @NonNull String str, @Nullable ComponentName componentName, @Nullable PendingIntent pendingIntent, @Nullable Bundle bundle, @Nullable VersionedParcelable versionedParcelable) {
        this.f369c = new ArrayList();
        if (context != null) {
            if (!TextUtils.isEmpty(str)) {
                if (componentName == null && (componentName = MediaButtonReceiver.getMediaButtonReceiverComponent(context)) == null) {
                    Log.w("MediaSessionCompat", "Couldn't find a unique registered media button receiver in the given context.");
                }
                if (componentName != null && pendingIntent == null) {
                    Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
                    intent.setComponent(componentName);
                    pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PENDING_INTENT_FLAG_MUTABLE);
                }
                int i = Build.VERSION.SDK_INT;
                if (i >= 29) {
                    this.f367a = new C0060p(context, str, versionedParcelable, bundle);
                } else if (i >= 28) {
                    this.f367a = new C0060p(context, str, versionedParcelable, bundle);
                } else {
                    this.f367a = new C0060p(context, str, versionedParcelable, bundle);
                }
                setCallback(new Callback(), new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper()));
                this.f367a.m138i(pendingIntent);
                this.f368b = new MediaControllerCompat(context, this);
                if (f366d == 0) {
                    f366d = (int) (TypedValue.applyDimension(1, 320.0f, context.getResources().getDisplayMetrics()) + 0.5f);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("tag must not be null or empty");
        }
        throw new IllegalArgumentException("context must not be null");
    }

    public MediaSessionCompat(Context context, C0060p c0060p) {
        this.f369c = new ArrayList();
        this.f367a = c0060p;
        this.f368b = new MediaControllerCompat(context, this);
    }
}
