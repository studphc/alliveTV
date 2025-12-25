package p000;

import android.app.Notification;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class bs1 {
    @DoNotInline
    /* renamed from: a */
    public static int m2158a(Notification notification) {
        return notification.getBadgeIconType();
    }

    @DoNotInline
    /* renamed from: b */
    public static String m2159b(Notification notification) {
        return notification.getChannelId();
    }

    @DoNotInline
    /* renamed from: c */
    public static int m2160c(Notification notification) {
        return notification.getGroupAlertBehavior();
    }

    @DoNotInline
    /* renamed from: d */
    public static CharSequence m2161d(Notification notification) {
        return notification.getSettingsText();
    }

    @DoNotInline
    /* renamed from: e */
    public static String m2162e(Notification notification) {
        return notification.getShortcutId();
    }

    @DoNotInline
    /* renamed from: f */
    public static long m2163f(Notification notification) {
        return notification.getTimeoutAfter();
    }
}
