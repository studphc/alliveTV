package androidx.core.app;

import android.app.Notification;
import android.app.NotificationChannel;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;
import p000.qr1;
import p000.rr1;
import p000.sr1;

/* loaded from: classes.dex */
public class NotificationChannelCompat {
    public static final String DEFAULT_CHANNEL_ID = "miscellaneous";

    /* renamed from: a */
    public final String f3287a;

    /* renamed from: b */
    public CharSequence f3288b;

    /* renamed from: c */
    public int f3289c;

    /* renamed from: d */
    public String f3290d;

    /* renamed from: e */
    public String f3291e;

    /* renamed from: f */
    public boolean f3292f;

    /* renamed from: g */
    public Uri f3293g;

    /* renamed from: h */
    public AudioAttributes f3294h;

    /* renamed from: i */
    public boolean f3295i;

    /* renamed from: j */
    public int f3296j;

    /* renamed from: k */
    public boolean f3297k;

    /* renamed from: l */
    public long[] f3298l;

    /* renamed from: m */
    public String f3299m;

    /* renamed from: n */
    public String f3300n;

    /* renamed from: o */
    public final boolean f3301o;

    /* renamed from: p */
    public final int f3302p;

    /* renamed from: q */
    public final boolean f3303q;

    /* renamed from: r */
    public final boolean f3304r;

    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a */
        public final NotificationChannelCompat f3305a;

        public Builder(@NonNull String str, int i) {
            this.f3305a = new NotificationChannelCompat(str, i);
        }

        @NonNull
        public NotificationChannelCompat build() {
            return this.f3305a;
        }

        @NonNull
        public Builder setConversationId(@NonNull String str, @NonNull String str2) {
            if (Build.VERSION.SDK_INT >= 30) {
                NotificationChannelCompat notificationChannelCompat = this.f3305a;
                notificationChannelCompat.f3299m = str;
                notificationChannelCompat.f3300n = str2;
            }
            return this;
        }

        @NonNull
        public Builder setDescription(@Nullable String str) {
            this.f3305a.f3290d = str;
            return this;
        }

        @NonNull
        public Builder setGroup(@Nullable String str) {
            this.f3305a.f3291e = str;
            return this;
        }

        @NonNull
        public Builder setImportance(int i) {
            this.f3305a.f3289c = i;
            return this;
        }

        @NonNull
        public Builder setLightColor(int i) {
            this.f3305a.f3296j = i;
            return this;
        }

        @NonNull
        public Builder setLightsEnabled(boolean z) {
            this.f3305a.f3295i = z;
            return this;
        }

        @NonNull
        public Builder setName(@Nullable CharSequence charSequence) {
            this.f3305a.f3288b = charSequence;
            return this;
        }

        @NonNull
        public Builder setShowBadge(boolean z) {
            this.f3305a.f3292f = z;
            return this;
        }

        @NonNull
        public Builder setSound(@Nullable Uri uri, @Nullable AudioAttributes audioAttributes) {
            NotificationChannelCompat notificationChannelCompat = this.f3305a;
            notificationChannelCompat.f3293g = uri;
            notificationChannelCompat.f3294h = audioAttributes;
            return this;
        }

        @NonNull
        public Builder setVibrationEnabled(boolean z) {
            this.f3305a.f3297k = z;
            return this;
        }

        @NonNull
        public Builder setVibrationPattern(@Nullable long[] jArr) {
            boolean z;
            if (jArr != null && jArr.length > 0) {
                z = true;
            } else {
                z = false;
            }
            NotificationChannelCompat notificationChannelCompat = this.f3305a;
            notificationChannelCompat.f3297k = z;
            notificationChannelCompat.f3298l = jArr;
            return this;
        }
    }

    public NotificationChannelCompat(String str, int i) {
        this.f3292f = true;
        this.f3293g = Settings.System.DEFAULT_NOTIFICATION_URI;
        this.f3296j = 0;
        this.f3287a = (String) Preconditions.checkNotNull(str);
        this.f3289c = i;
        this.f3294h = Notification.AUDIO_ATTRIBUTES_DEFAULT;
    }

    /* renamed from: a */
    public final NotificationChannel m692a() {
        String str;
        String str2;
        int i = Build.VERSION.SDK_INT;
        if (i < 26) {
            return null;
        }
        NotificationChannel m7120c = qr1.m7120c(this.f3287a, this.f3288b, this.f3289c);
        qr1.m7133p(m7120c, this.f3290d);
        qr1.m7134q(m7120c, this.f3291e);
        qr1.m7136s(m7120c, this.f3292f);
        qr1.m7137t(m7120c, this.f3293g, this.f3294h);
        qr1.m7121d(m7120c, this.f3295i);
        qr1.m7135r(m7120c, this.f3296j);
        qr1.m7138u(m7120c, this.f3298l);
        qr1.m7122e(m7120c, this.f3297k);
        if (i >= 30 && (str = this.f3299m) != null && (str2 = this.f3300n) != null) {
            sr1.m7400d(m7120c, str, str2);
        }
        return m7120c;
    }

    public boolean canBubble() {
        return this.f3303q;
    }

    public boolean canBypassDnd() {
        return this.f3301o;
    }

    public boolean canShowBadge() {
        return this.f3292f;
    }

    @Nullable
    public AudioAttributes getAudioAttributes() {
        return this.f3294h;
    }

    @Nullable
    public String getConversationId() {
        return this.f3300n;
    }

    @Nullable
    public String getDescription() {
        return this.f3290d;
    }

    @Nullable
    public String getGroup() {
        return this.f3291e;
    }

    @NonNull
    public String getId() {
        return this.f3287a;
    }

    public int getImportance() {
        return this.f3289c;
    }

    public int getLightColor() {
        return this.f3296j;
    }

    public int getLockscreenVisibility() {
        return this.f3302p;
    }

    @Nullable
    public CharSequence getName() {
        return this.f3288b;
    }

    @Nullable
    public String getParentChannelId() {
        return this.f3299m;
    }

    @Nullable
    public Uri getSound() {
        return this.f3293g;
    }

    @Nullable
    public long[] getVibrationPattern() {
        return this.f3298l;
    }

    public boolean isImportantConversation() {
        return this.f3304r;
    }

    public boolean shouldShowLights() {
        return this.f3295i;
    }

    public boolean shouldVibrate() {
        return this.f3297k;
    }

    @NonNull
    public Builder toBuilder() {
        return new Builder(this.f3287a, this.f3289c).setName(this.f3288b).setDescription(this.f3290d).setGroup(this.f3291e).setShowBadge(this.f3292f).setSound(this.f3293g, this.f3294h).setLightsEnabled(this.f3295i).setLightColor(this.f3296j).setVibrationEnabled(this.f3297k).setVibrationPattern(this.f3298l).setConversationId(this.f3299m, this.f3300n);
    }

    public NotificationChannelCompat(NotificationChannel notificationChannel) {
        this(qr1.m7126i(notificationChannel), qr1.m7127j(notificationChannel));
        this.f3288b = qr1.m7130m(notificationChannel);
        this.f3290d = qr1.m7124g(notificationChannel);
        this.f3291e = qr1.m7125h(notificationChannel);
        this.f3292f = qr1.m7119b(notificationChannel);
        this.f3293g = qr1.m7131n(notificationChannel);
        this.f3294h = qr1.m7123f(notificationChannel);
        this.f3295i = qr1.m7139v(notificationChannel);
        this.f3296j = qr1.m7128k(notificationChannel);
        this.f3297k = qr1.m7140w(notificationChannel);
        this.f3298l = qr1.m7132o(notificationChannel);
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            this.f3299m = sr1.m7398b(notificationChannel);
            this.f3300n = sr1.m7397a(notificationChannel);
        }
        this.f3301o = qr1.m7118a(notificationChannel);
        this.f3302p = qr1.m7129l(notificationChannel);
        if (i >= 29) {
            this.f3303q = rr1.m7296a(notificationChannel);
        }
        if (i >= 30) {
            this.f3304r = sr1.m7399c(notificationChannel);
        }
    }
}
