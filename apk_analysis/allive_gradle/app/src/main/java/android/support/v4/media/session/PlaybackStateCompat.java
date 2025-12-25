package android.support.v4.media.session;

import android.annotation.SuppressLint;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p000.C1749r5;
import p000.m52;
import p000.n52;
import p000.ye0;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class PlaybackStateCompat implements Parcelable {
    public static final long ACTION_FAST_FORWARD = 64;
    public static final long ACTION_PAUSE = 2;
    public static final long ACTION_PLAY = 4;
    public static final long ACTION_PLAY_FROM_MEDIA_ID = 1024;
    public static final long ACTION_PLAY_FROM_SEARCH = 2048;
    public static final long ACTION_PLAY_FROM_URI = 8192;
    public static final long ACTION_PLAY_PAUSE = 512;
    public static final long ACTION_PREPARE = 16384;
    public static final long ACTION_PREPARE_FROM_MEDIA_ID = 32768;
    public static final long ACTION_PREPARE_FROM_SEARCH = 65536;
    public static final long ACTION_PREPARE_FROM_URI = 131072;
    public static final long ACTION_REWIND = 8;
    public static final long ACTION_SEEK_TO = 256;
    public static final long ACTION_SET_CAPTIONING_ENABLED = 1048576;
    public static final long ACTION_SET_PLAYBACK_SPEED = 4194304;
    public static final long ACTION_SET_RATING = 128;
    public static final long ACTION_SET_REPEAT_MODE = 262144;
    public static final long ACTION_SET_SHUFFLE_MODE = 2097152;

    @Deprecated
    public static final long ACTION_SET_SHUFFLE_MODE_ENABLED = 524288;
    public static final long ACTION_SKIP_TO_NEXT = 32;
    public static final long ACTION_SKIP_TO_PREVIOUS = 16;
    public static final long ACTION_SKIP_TO_QUEUE_ITEM = 4096;
    public static final long ACTION_STOP = 1;
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new C1749r5(27);
    public static final int ERROR_CODE_ACTION_ABORTED = 10;
    public static final int ERROR_CODE_APP_ERROR = 1;
    public static final int ERROR_CODE_AUTHENTICATION_EXPIRED = 3;
    public static final int ERROR_CODE_CONCURRENT_STREAM_LIMIT = 5;
    public static final int ERROR_CODE_CONTENT_ALREADY_PLAYING = 8;
    public static final int ERROR_CODE_END_OF_QUEUE = 11;
    public static final int ERROR_CODE_NOT_AVAILABLE_IN_REGION = 7;
    public static final int ERROR_CODE_NOT_SUPPORTED = 2;
    public static final int ERROR_CODE_PARENTAL_CONTROL_RESTRICTED = 6;
    public static final int ERROR_CODE_PREMIUM_ACCOUNT_REQUIRED = 4;
    public static final int ERROR_CODE_SKIP_LIMIT_REACHED = 9;
    public static final int ERROR_CODE_UNKNOWN_ERROR = 0;
    public static final long PLAYBACK_POSITION_UNKNOWN = -1;
    public static final int REPEAT_MODE_ALL = 2;
    public static final int REPEAT_MODE_GROUP = 3;
    public static final int REPEAT_MODE_INVALID = -1;
    public static final int REPEAT_MODE_NONE = 0;
    public static final int REPEAT_MODE_ONE = 1;
    public static final int SHUFFLE_MODE_ALL = 1;
    public static final int SHUFFLE_MODE_GROUP = 2;
    public static final int SHUFFLE_MODE_INVALID = -1;
    public static final int SHUFFLE_MODE_NONE = 0;
    public static final int STATE_BUFFERING = 6;
    public static final int STATE_CONNECTING = 8;
    public static final int STATE_ERROR = 7;
    public static final int STATE_FAST_FORWARDING = 4;
    public static final int STATE_NONE = 0;
    public static final int STATE_PAUSED = 2;
    public static final int STATE_PLAYING = 3;
    public static final int STATE_REWINDING = 5;
    public static final int STATE_SKIPPING_TO_NEXT = 10;
    public static final int STATE_SKIPPING_TO_PREVIOUS = 9;
    public static final int STATE_SKIPPING_TO_QUEUE_ITEM = 11;
    public static final int STATE_STOPPED = 1;

    /* renamed from: a */
    public final int f383a;

    /* renamed from: b */
    public final long f384b;

    /* renamed from: c */
    public final long f385c;

    /* renamed from: d */
    public final float f386d;

    /* renamed from: e */
    public final long f387e;

    /* renamed from: f */
    public final int f388f;

    /* renamed from: g */
    public final CharSequence f389g;

    /* renamed from: h */
    public final long f390h;

    /* renamed from: i */
    public final ArrayList f391i;

    /* renamed from: j */
    public final long f392j;

    /* renamed from: k */
    public final Bundle f393k;

    /* renamed from: l */
    public PlaybackState f394l;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface Actions {
    }

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a */
        public final ArrayList f395a;

        /* renamed from: b */
        public int f396b;

        /* renamed from: c */
        public long f397c;

        /* renamed from: d */
        public long f398d;

        /* renamed from: e */
        public float f399e;

        /* renamed from: f */
        public long f400f;

        /* renamed from: g */
        public int f401g;

        /* renamed from: h */
        public CharSequence f402h;

        /* renamed from: i */
        public long f403i;

        /* renamed from: j */
        public long f404j;

        /* renamed from: k */
        public Bundle f405k;

        public Builder() {
            this.f395a = new ArrayList();
            this.f404j = -1L;
        }

        public Builder addCustomAction(String str, String str2, int i) {
            return addCustomAction(new CustomAction(str, str2, i, null));
        }

        public PlaybackStateCompat build() {
            return new PlaybackStateCompat(this.f396b, this.f397c, this.f398d, this.f399e, this.f400f, this.f401g, this.f402h, this.f403i, this.f395a, this.f404j, this.f405k);
        }

        public Builder setActions(long j) {
            this.f400f = j;
            return this;
        }

        public Builder setActiveQueueItemId(long j) {
            this.f404j = j;
            return this;
        }

        public Builder setBufferedPosition(long j) {
            this.f398d = j;
            return this;
        }

        @Deprecated
        public Builder setErrorMessage(CharSequence charSequence) {
            this.f402h = charSequence;
            return this;
        }

        public Builder setExtras(Bundle bundle) {
            this.f405k = bundle;
            return this;
        }

        public Builder setState(int i, long j, float f) {
            return setState(i, j, f, SystemClock.elapsedRealtime());
        }

        public Builder addCustomAction(CustomAction customAction) {
            if (customAction != null) {
                this.f395a.add(customAction);
                return this;
            }
            throw new IllegalArgumentException("You may not add a null CustomAction to PlaybackStateCompat");
        }

        public Builder setErrorMessage(int i, CharSequence charSequence) {
            this.f401g = i;
            this.f402h = charSequence;
            return this;
        }

        public Builder setState(int i, long j, float f, long j2) {
            this.f396b = i;
            this.f397c = j;
            this.f403i = j2;
            this.f399e = f;
            return this;
        }

        public Builder(PlaybackStateCompat playbackStateCompat) {
            ArrayList arrayList = new ArrayList();
            this.f395a = arrayList;
            this.f404j = -1L;
            this.f396b = playbackStateCompat.f383a;
            this.f397c = playbackStateCompat.f384b;
            this.f399e = playbackStateCompat.f386d;
            this.f403i = playbackStateCompat.f390h;
            this.f398d = playbackStateCompat.f385c;
            this.f400f = playbackStateCompat.f387e;
            this.f401g = playbackStateCompat.f388f;
            this.f402h = playbackStateCompat.f389g;
            ArrayList arrayList2 = playbackStateCompat.f391i;
            if (arrayList2 != null) {
                arrayList.addAll(arrayList2);
            }
            this.f404j = playbackStateCompat.f392j;
            this.f405k = playbackStateCompat.f393k;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public @interface MediaKeyAction {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface RepeatMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface ShuffleMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface State {
    }

    public PlaybackStateCompat(int i, long j, long j2, float f, long j3, int i2, CharSequence charSequence, long j4, ArrayList arrayList, long j5, Bundle bundle) {
        this.f383a = i;
        this.f384b = j;
        this.f385c = j2;
        this.f386d = f;
        this.f387e = j3;
        this.f388f = i2;
        this.f389g = charSequence;
        this.f390h = j4;
        this.f391i = new ArrayList(arrayList);
        this.f392j = j5;
        this.f393k = bundle;
    }

    public static PlaybackStateCompat fromPlaybackState(Object obj) {
        ArrayList arrayList = null;
        if (obj == null) {
            return null;
        }
        PlaybackState playbackState = (PlaybackState) obj;
        List<PlaybackState.CustomAction> m6064j = m52.m6064j(playbackState);
        if (m6064j != null) {
            arrayList = new ArrayList(m6064j.size());
            Iterator<PlaybackState.CustomAction> it = m6064j.iterator();
            while (it.hasNext()) {
                arrayList.add(CustomAction.fromCustomAction(it.next()));
            }
        }
        Bundle m6313a = n52.m6313a(playbackState);
        MediaSessionCompat.ensureClassLoader(m6313a);
        PlaybackStateCompat playbackStateCompat = new PlaybackStateCompat(m52.m6072r(playbackState), m52.m6071q(playbackState), m52.m6063i(playbackState), m52.m6070p(playbackState), m52.m6061g(playbackState), 0, m52.m6065k(playbackState), m52.m6068n(playbackState), arrayList, m52.m6062h(playbackState), m6313a);
        playbackStateCompat.f394l = playbackState;
        return playbackStateCompat;
    }

    public static int toKeyCode(long j) {
        if (j == 4) {
            return 126;
        }
        if (j == 2) {
            return 127;
        }
        if (j == 32) {
            return 87;
        }
        if (j == 16) {
            return 88;
        }
        if (j == 1) {
            return 86;
        }
        if (j == 64) {
            return 90;
        }
        if (j == 8) {
            return 89;
        }
        return j == 512 ? 85 : 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getActions() {
        return this.f387e;
    }

    public long getActiveQueueItemId() {
        return this.f392j;
    }

    public long getBufferedPosition() {
        return this.f385c;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public long getCurrentPosition(Long l) {
        long elapsedRealtime;
        if (l != null) {
            elapsedRealtime = l.longValue();
        } else {
            elapsedRealtime = SystemClock.elapsedRealtime() - this.f390h;
        }
        return Math.max(0L, this.f384b + (this.f386d * ((float) elapsedRealtime)));
    }

    public List<CustomAction> getCustomActions() {
        return this.f391i;
    }

    public int getErrorCode() {
        return this.f388f;
    }

    public CharSequence getErrorMessage() {
        return this.f389g;
    }

    @Nullable
    public Bundle getExtras() {
        return this.f393k;
    }

    public long getLastPositionUpdateTime() {
        return this.f390h;
    }

    public float getPlaybackSpeed() {
        return this.f386d;
    }

    public Object getPlaybackState() {
        if (this.f394l == null) {
            PlaybackState.Builder m6058d = m52.m6058d();
            m52.m6078x(m6058d, this.f383a, this.f384b, this.f386d, this.f390h);
            m52.m6075u(m6058d, this.f385c);
            m52.m6073s(m6058d, this.f387e);
            m52.m6076v(m6058d, this.f389g);
            Iterator it = this.f391i.iterator();
            while (it.hasNext()) {
                m52.m6055a(m6058d, (PlaybackState.CustomAction) ((CustomAction) it.next()).getCustomAction());
            }
            m52.m6074t(m6058d, this.f392j);
            n52.m6314b(m6058d, this.f393k);
            this.f394l = m52.m6057c(m6058d);
        }
        return this.f394l;
    }

    public long getPosition() {
        return this.f384b;
    }

    public int getState() {
        return this.f383a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PlaybackState {state=");
        sb.append(this.f383a);
        sb.append(", position=");
        sb.append(this.f384b);
        sb.append(", buffered position=");
        sb.append(this.f385c);
        sb.append(", speed=");
        sb.append(this.f386d);
        sb.append(", updated=");
        sb.append(this.f390h);
        sb.append(", actions=");
        sb.append(this.f387e);
        sb.append(", error code=");
        sb.append(this.f388f);
        sb.append(", error message=");
        sb.append(this.f389g);
        sb.append(", custom actions=");
        sb.append(this.f391i);
        sb.append(", active item id=");
        return ye0.m8297q(sb, this.f392j, "}");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f383a);
        parcel.writeLong(this.f384b);
        parcel.writeFloat(this.f386d);
        parcel.writeLong(this.f390h);
        parcel.writeLong(this.f385c);
        parcel.writeLong(this.f387e);
        TextUtils.writeToParcel(this.f389g, parcel, i);
        parcel.writeTypedList(this.f391i);
        parcel.writeLong(this.f392j);
        parcel.writeBundle(this.f393k);
        parcel.writeInt(this.f388f);
    }

    /* loaded from: classes.dex */
    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new Object();

        /* renamed from: a */
        public final String f406a;

        /* renamed from: b */
        public final CharSequence f407b;

        /* renamed from: c */
        public final int f408c;

        /* renamed from: d */
        public final Bundle f409d;

        /* renamed from: e */
        public PlaybackState.CustomAction f410e;

        /* loaded from: classes.dex */
        public static final class Builder {

            /* renamed from: a */
            public final String f411a;

            /* renamed from: b */
            public final CharSequence f412b;

            /* renamed from: c */
            public final int f413c;

            /* renamed from: d */
            public Bundle f414d;

            public Builder(String str, CharSequence charSequence, int i) {
                if (!TextUtils.isEmpty(str)) {
                    if (!TextUtils.isEmpty(charSequence)) {
                        if (i != 0) {
                            this.f411a = str;
                            this.f412b = charSequence;
                            this.f413c = i;
                            return;
                        }
                        throw new IllegalArgumentException("You must specify an icon resource id to build a CustomAction");
                    }
                    throw new IllegalArgumentException("You must specify a name to build a CustomAction");
                }
                throw new IllegalArgumentException("You must specify an action to build a CustomAction");
            }

            public CustomAction build() {
                return new CustomAction(this.f411a, this.f412b, this.f413c, this.f414d);
            }

            public Builder setExtras(Bundle bundle) {
                this.f414d = bundle;
                return this;
            }
        }

        public CustomAction(String str, CharSequence charSequence, int i, Bundle bundle) {
            this.f406a = str;
            this.f407b = charSequence;
            this.f408c = i;
            this.f409d = bundle;
        }

        public static CustomAction fromCustomAction(Object obj) {
            if (obj != null) {
                PlaybackState.CustomAction customAction = (PlaybackState.CustomAction) obj;
                Bundle m6066l = m52.m6066l(customAction);
                MediaSessionCompat.ensureClassLoader(m6066l);
                CustomAction customAction2 = new CustomAction(m52.m6060f(customAction), m52.m6069o(customAction), m52.m6067m(customAction), m6066l);
                customAction2.f410e = customAction;
                return customAction2;
            }
            return null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getAction() {
            return this.f406a;
        }

        public Object getCustomAction() {
            PlaybackState.CustomAction customAction = this.f410e;
            if (customAction == null) {
                PlaybackState.CustomAction.Builder m6059e = m52.m6059e(this.f406a, this.f407b, this.f408c);
                m52.m6077w(m6059e, this.f409d);
                return m52.m6056b(m6059e);
            }
            return customAction;
        }

        public Bundle getExtras() {
            return this.f409d;
        }

        public int getIcon() {
            return this.f408c;
        }

        public CharSequence getName() {
            return this.f407b;
        }

        public String toString() {
            return "Action:mName='" + ((Object) this.f407b) + ", mIcon=" + this.f408c + ", mExtras=" + this.f409d;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f406a);
            TextUtils.writeToParcel(this.f407b, parcel, i);
            parcel.writeInt(this.f408c);
            parcel.writeBundle(this.f409d);
        }

        public CustomAction(Parcel parcel) {
            this.f406a = parcel.readString();
            this.f407b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f408c = parcel.readInt();
            this.f409d = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        }
    }

    public PlaybackStateCompat(Parcel parcel) {
        this.f383a = parcel.readInt();
        this.f384b = parcel.readLong();
        this.f386d = parcel.readFloat();
        this.f390h = parcel.readLong();
        this.f385c = parcel.readLong();
        this.f387e = parcel.readLong();
        this.f389g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f391i = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.f392j = parcel.readLong();
        this.f393k = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        this.f388f = parcel.readInt();
    }
}
