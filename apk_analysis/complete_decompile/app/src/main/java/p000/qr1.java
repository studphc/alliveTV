package p000;

import android.app.NotificationChannel;
import android.media.AudioAttributes;
import android.net.Uri;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class qr1 {
    @DoNotInline
    /* renamed from: a */
    public static boolean m7118a(NotificationChannel notificationChannel) {
        return notificationChannel.canBypassDnd();
    }

    @DoNotInline
    /* renamed from: b */
    public static boolean m7119b(NotificationChannel notificationChannel) {
        return notificationChannel.canShowBadge();
    }

    @DoNotInline
    /* renamed from: c */
    public static NotificationChannel m7120c(String str, CharSequence charSequence, int i) {
        return new NotificationChannel(str, charSequence, i);
    }

    @DoNotInline
    /* renamed from: d */
    public static void m7121d(NotificationChannel notificationChannel, boolean z) {
        notificationChannel.enableLights(z);
    }

    @DoNotInline
    /* renamed from: e */
    public static void m7122e(NotificationChannel notificationChannel, boolean z) {
        notificationChannel.enableVibration(z);
    }

    @DoNotInline
    /* renamed from: f */
    public static AudioAttributes m7123f(NotificationChannel notificationChannel) {
        return notificationChannel.getAudioAttributes();
    }

    @DoNotInline
    /* renamed from: g */
    public static String m7124g(NotificationChannel notificationChannel) {
        return notificationChannel.getDescription();
    }

    @DoNotInline
    /* renamed from: h */
    public static String m7125h(NotificationChannel notificationChannel) {
        return notificationChannel.getGroup();
    }

    @DoNotInline
    /* renamed from: i */
    public static String m7126i(NotificationChannel notificationChannel) {
        return notificationChannel.getId();
    }

    @DoNotInline
    /* renamed from: j */
    public static int m7127j(NotificationChannel notificationChannel) {
        return notificationChannel.getImportance();
    }

    @DoNotInline
    /* renamed from: k */
    public static int m7128k(NotificationChannel notificationChannel) {
        return notificationChannel.getLightColor();
    }

    @DoNotInline
    /* renamed from: l */
    public static int m7129l(NotificationChannel notificationChannel) {
        return notificationChannel.getLockscreenVisibility();
    }

    @DoNotInline
    /* renamed from: m */
    public static CharSequence m7130m(NotificationChannel notificationChannel) {
        return notificationChannel.getName();
    }

    @DoNotInline
    /* renamed from: n */
    public static Uri m7131n(NotificationChannel notificationChannel) {
        return notificationChannel.getSound();
    }

    @DoNotInline
    /* renamed from: o */
    public static long[] m7132o(NotificationChannel notificationChannel) {
        return notificationChannel.getVibrationPattern();
    }

    @DoNotInline
    /* renamed from: p */
    public static void m7133p(NotificationChannel notificationChannel, String str) {
        notificationChannel.setDescription(str);
    }

    @DoNotInline
    /* renamed from: q */
    public static void m7134q(NotificationChannel notificationChannel, String str) {
        notificationChannel.setGroup(str);
    }

    @DoNotInline
    /* renamed from: r */
    public static void m7135r(NotificationChannel notificationChannel, int i) {
        notificationChannel.setLightColor(i);
    }

    @DoNotInline
    /* renamed from: s */
    public static void m7136s(NotificationChannel notificationChannel, boolean z) {
        notificationChannel.setShowBadge(z);
    }

    @DoNotInline
    /* renamed from: t */
    public static void m7137t(NotificationChannel notificationChannel, Uri uri, AudioAttributes audioAttributes) {
        notificationChannel.setSound(uri, audioAttributes);
    }

    @DoNotInline
    /* renamed from: u */
    public static void m7138u(NotificationChannel notificationChannel, long[] jArr) {
        notificationChannel.setVibrationPattern(jArr);
    }

    @DoNotInline
    /* renamed from: v */
    public static boolean m7139v(NotificationChannel notificationChannel) {
        return notificationChannel.shouldShowLights();
    }

    @DoNotInline
    /* renamed from: w */
    public static boolean m7140w(NotificationChannel notificationChannel) {
        return notificationChannel.shouldVibrate();
    }
}
